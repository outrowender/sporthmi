/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class DispatcherProxy {
    private DispatcherProxy() {
    }

    public static Object create(Class clazz, final Object object, final DispatcherBase dispatcherBase) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), new Class[]{clazz}, new InvocationHandler(){

            public Object invoke(Object object2, final Method method, final Object[] objectArray) throws Throwable {
                if (method.getReturnType().equals(Void.TYPE)) {
                    dispatcherBase.execute(new Runnable(){

                        public void run() {
                            try {
                                method.invoke(object, objectArray);
                            }
                            catch (Exception exception) {
                                throw new RuntimeException(exception);
                            }
                        }
                    });
                    return null;
                }
                return method.invoke(object, objectArray);
            }
        });
    }
}

