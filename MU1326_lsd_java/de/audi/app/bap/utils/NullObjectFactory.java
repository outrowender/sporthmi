/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class NullObjectFactory {
    private static final Map DEFAULT_VALUES;

    public static Object makeNullObjectFor(Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler(){

            public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
                return NullObjectFactory.defaultValueFor(method.getReturnType());
            }
        });
    }

    private static Object defaultValueFor(Class clazz) {
        return DEFAULT_VALUES.get(clazz);
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Boolean.TYPE, Boolean.FALSE);
        hashMap.put(Character.TYPE, new Character('\u0000'));
        hashMap.put(Byte.TYPE, new Byte(0));
        hashMap.put(Short.TYPE, new Short(0));
        hashMap.put(Integer.TYPE, new Integer(0));
        hashMap.put(Long.TYPE, new Long(0L));
        hashMap.put(Float.TYPE, new Float(0.0f));
        hashMap.put(Double.TYPE, new Double(0.0));
        DEFAULT_VALUES = Collections.unmodifiableMap(hashMap);
    }
}

