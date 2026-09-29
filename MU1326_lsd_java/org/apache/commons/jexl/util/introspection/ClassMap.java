/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package org.apache.commons.jexl.util.introspection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Hashtable;
import java.util.Map;
import org.apache.commons.jexl.util.introspection.ClassMap$CacheMiss;
import org.apache.commons.jexl.util.introspection.ClassMap$MethodInfo;
import org.apache.commons.jexl.util.introspection.MethodMap;
import org.apache.commons.jexl.util.introspection.MethodMap$AmbiguousException;

public class ClassMap {
    private static final ClassMap$CacheMiss CACHE_MISS = new ClassMap$CacheMiss(null);
    private static final Object OBJECT = new Object();
    private Class clazz;
    private final Map methodCache = new Hashtable();
    private final MethodMap methodMap = new MethodMap();

    public ClassMap(Class clazz) {
        this.clazz = clazz;
        this.populateMethodCache();
    }

    Class getCachedClass() {
        return this.clazz;
    }

    public Method findMethod(String string, Object[] objectArray) {
        String string2 = ClassMap.makeMethodKey(string, objectArray);
        Object object = this.methodCache.get(string2);
        if (object == CACHE_MISS) {
            return null;
        }
        if (object == null) {
            try {
                object = this.methodMap.find(string, objectArray);
            }
            catch (MethodMap$AmbiguousException methodMap$AmbiguousException) {
                this.methodCache.put(string2, CACHE_MISS);
                throw methodMap$AmbiguousException;
            }
            if (object == null) {
                this.methodCache.put(string2, CACHE_MISS);
            } else {
                this.methodCache.put(string2, object);
            }
        }
        return (Method)object;
    }

    private void populateMethodCache() {
        Method[] methodArray = ClassMap.getAccessibleMethods(this.clazz);
        for (int i2 = 0; i2 < methodArray.length; ++i2) {
            Method method = methodArray[i2];
            Method method2 = ClassMap.getPublicMethod(method);
            if (method2 == null) continue;
            this.methodMap.add(method2);
            this.methodCache.put(this.makeMethodKey(method2), method2);
        }
    }

    private String makeMethodKey(Method method) {
        Class[] classArray = method.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer(method.getName());
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            if (classArray[i2].isPrimitive()) {
                if (classArray[i2].equals(Boolean.TYPE)) {
                    stringBuffer.append("java.lang.Boolean");
                    continue;
                }
                if (classArray[i2].equals(Byte.TYPE)) {
                    stringBuffer.append("java.lang.Byte");
                    continue;
                }
                if (classArray[i2].equals(Character.TYPE)) {
                    stringBuffer.append("java.lang.Character");
                    continue;
                }
                if (classArray[i2].equals(Double.TYPE)) {
                    stringBuffer.append("java.lang.Double");
                    continue;
                }
                if (classArray[i2].equals(Float.TYPE)) {
                    stringBuffer.append("java.lang.Float");
                    continue;
                }
                if (classArray[i2].equals(Integer.TYPE)) {
                    stringBuffer.append("java.lang.Integer");
                    continue;
                }
                if (classArray[i2].equals(Long.TYPE)) {
                    stringBuffer.append("java.lang.Long");
                    continue;
                }
                if (!classArray[i2].equals(Short.TYPE)) continue;
                stringBuffer.append("java.lang.Short");
                continue;
            }
            stringBuffer.append(classArray[i2].getName());
        }
        return stringBuffer.toString();
    }

    private static String makeMethodKey(String string, Object[] objectArray) {
        StringBuffer stringBuffer = new StringBuffer().append(string);
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Object object = objectArray[i2];
            if (object == null) {
                object = OBJECT;
            }
            stringBuffer.append(object.getClass().getName());
        }
        return stringBuffer.toString();
    }

    private static Method[] getAccessibleMethods(Class clazz) {
        Method[] methodArray = clazz.getMethods();
        if (Modifier.isPublic(clazz.getModifiers())) {
            return methodArray;
        }
        ClassMap$MethodInfo[] classMap$MethodInfoArray = new ClassMap$MethodInfo[methodArray.length];
        int n = methodArray.length;
        while (n-- > 0) {
            classMap$MethodInfoArray[n] = new ClassMap$MethodInfo(methodArray[n]);
        }
        n = ClassMap.getAccessibleMethods(clazz, classMap$MethodInfoArray, 0);
        if (n < methodArray.length) {
            methodArray = new Method[n];
        }
        int n2 = 0;
        for (int i2 = 0; i2 < classMap$MethodInfoArray.length; ++i2) {
            ClassMap$MethodInfo classMap$MethodInfo = classMap$MethodInfoArray[i2];
            if (!classMap$MethodInfo.upcast) continue;
            methodArray[n2++] = classMap$MethodInfo.method;
        }
        return methodArray;
    }

    private static int getAccessibleMethods(Class clazz, ClassMap$MethodInfo[] classMap$MethodInfoArray, int n) {
        Class clazz2;
        Object object;
        int n2 = classMap$MethodInfoArray.length;
        if (Modifier.isPublic(clazz.getModifiers())) {
            for (int i2 = 0; i2 < n2 && n < n2; ++i2) {
                try {
                    object = classMap$MethodInfoArray[i2];
                    if (((ClassMap$MethodInfo)object).upcast) continue;
                    ((ClassMap$MethodInfo)object).tryUpcasting(clazz);
                    ++n;
                    continue;
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    // empty catch block
                }
            }
            if (n == n2) {
                return n;
            }
        }
        if ((clazz2 = clazz.getSuperclass()) != null && (n = ClassMap.getAccessibleMethods(clazz2, classMap$MethodInfoArray, n)) == n2) {
            return n;
        }
        object = clazz.getInterfaces();
        int n3 = ((Class[])object).length;
        while (n3-- > 0) {
            if ((n = ClassMap.getAccessibleMethods(object[n3], classMap$MethodInfoArray, n)) != n2) continue;
            return n;
        }
        return n;
    }

    public static Method getPublicMethod(Method method) {
        Class clazz = method.getDeclaringClass();
        if ((clazz.getModifiers() & 1) != 0) {
            return method;
        }
        return ClassMap.getPublicMethod(clazz, method.getName(), method.getParameterTypes());
    }

    private static Method getPublicMethod(Class clazz, String string, Class[] classArray) {
        Object object;
        if ((clazz.getModifiers() & 1) != 0) {
            try {
                return clazz.getMethod(string, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                return null;
            }
        }
        Class clazz2 = clazz.getSuperclass();
        if (clazz2 != null && (object = ClassMap.getPublicMethod(clazz2, string, classArray)) != null) {
            return object;
        }
        object = clazz.getInterfaces();
        for (int i2 = 0; i2 < ((Class[])object).length; ++i2) {
            Method method = ClassMap.getPublicMethod(object[i2], string, classArray);
            if (method == null) continue;
            return method;
        }
        return null;
    }
}

