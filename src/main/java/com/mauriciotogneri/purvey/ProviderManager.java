package com.mauriciotogneri.purvey;

import com.mauriciotogneri.purvey.Singleton.Type;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProviderManager implements InvocationHandler
{
    private final Map<String, Object> providers = new HashMap<>();
    private final Map<Method, Object> methodsSingleton = new HashMap<>();
    private final Map<Class<?>, Object> returnTypeSingleton = new HashMap<>();

    private static final Map<Class<?>, Object> rootProviders = new HashMap<>();

    private ProviderManager()
    {
    }

    @SuppressWarnings("unchecked")
    public synchronized static <T> T get(Class<T> provider)
    {
        if (ProviderManager.rootProviders.containsKey(provider))
        {
            return (T) ProviderManager.rootProviders.get(provider);
        }
        else
        {
            T result = (T) Proxy.newProxyInstance(provider.getClassLoader(), new Class<?>[]
                    {
                            provider
                    }, new ProviderManager());

            ProviderManager.rootProviders.put(provider, result);

            return result;
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] parameters) throws Throwable
    {
        synchronized (ProviderManager.class)
        {
            Object provider = this.providers.get(method.getDeclaringClass().getName());

            if (provider == null)
            {
                Object newProvider = parameters[0];
                Class<?>[] interfaces = newProvider.getClass().getInterfaces();

                for (Class<?> element : interfaces)
                {
                    this.providers.put(element.getName(), newProvider);
                }
            }
            else
            {
                Singleton singleton = method.getDeclaredAnnotation(Singleton.class);

                if ((singleton != null) && (singleton.type() == Type.RETURN_TYPE) && this.returnTypeSingleton.containsKey(method.getReturnType()))
                {
                    return this.returnTypeSingleton.get(method.getReturnType());
                }
                else if ((singleton != null) && (singleton.type() == Type.METHOD) && this.methodsSingleton.containsKey(method))
                {
                    return this.methodsSingleton.get(method);
                }
                else
                {
                    Object result = method.invoke(provider, parameters);

                    if (singleton != null)
                    {
                        if (singleton.type() == Type.RETURN_TYPE)
                        {
                            this.returnTypeSingleton.put(method.getReturnType(), result);
                        }
                        else if (singleton.type() == Type.METHOD)
                        {
                            this.methodsSingleton.put(method, result);
                        }
                    }

                    return result;
                }
            }

            return null;
        }
    }
}