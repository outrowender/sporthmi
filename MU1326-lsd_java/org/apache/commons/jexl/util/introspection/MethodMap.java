/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package org.apache.commons.jexl.util.introspection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.jexl.util.introspection.MethodMap$AmbiguousException;

public class MethodMap {
    private static final int MORE_SPECIFIC;
    private static final int LESS_SPECIFIC;
    private static final int INCOMPARABLE;
    protected Map methodByNameMap = new Hashtable();
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Character;
    static /* synthetic */ Class class$java$lang$Byte;
    static /* synthetic */ Class class$java$lang$Short;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Float;
    static /* synthetic */ Class class$java$lang$Double;

    public void add(Method method) {
        String string = method.getName();
        List list = this.get(string);
        if (list == null) {
            list = new ArrayList();
            this.methodByNameMap.put(string, list);
        }
        list.add(method);
    }

    public List get(String string) {
        return (List)this.methodByNameMap.get(string);
    }

    public Method find(String string, Object[] objectArray) {
        List list = this.get(string);
        if (list == null) {
            return null;
        }
        int n = objectArray.length;
        Class[] classArray = new Class[n];
        for (int i2 = 0; i2 < n; ++i2) {
            Object object = objectArray[i2];
            classArray[i2] = object == null ? null : object.getClass();
        }
        return MethodMap.getMostSpecific(list, classArray);
    }

    private static Method getMostSpecific(List list, Class[] classArray) {
        LinkedList linkedList = MethodMap.getApplicables(list, classArray);
        if (linkedList.isEmpty()) {
            return null;
        }
        if (linkedList.size() == 1) {
            return (Method)linkedList.getFirst();
        }
        LinkedList linkedList2 = new LinkedList();
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Method method = (Method)iterator.next();
            Class[] classArray2 = method.getParameterTypes();
            boolean bl = false;
            Iterator iterator2 = linkedList2.iterator();
            while (!bl && iterator2.hasNext()) {
                Method method2 = (Method)iterator2.next();
                switch (MethodMap.moreSpecific(classArray2, method2.getParameterTypes())) {
                    case 0: {
                        iterator2.remove();
                        break;
                    }
                    case 1: {
                        bl = true;
                    }
                }
            }
            if (bl) continue;
            linkedList2.addLast(method);
        }
        if (linkedList2.size() > 1) {
            throw new MethodMap$AmbiguousException();
        }
        return (Method)linkedList2.getFirst();
    }

    private static int moreSpecific(Class[] classArray, Class[] classArray2) {
        boolean bl = false;
        boolean bl2 = false;
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            if (classArray[i2] == classArray2[i2]) continue;
            bl = bl || MethodMap.isStrictMethodInvocationConvertible(classArray2[i2], classArray[i2]);
            bl2 = bl2 || MethodMap.isStrictMethodInvocationConvertible(classArray[i2], classArray2[i2]);
        }
        if (bl) {
            if (bl2) {
                return 2;
            }
            return 0;
        }
        if (bl2) {
            return 1;
        }
        return 2;
    }

    private static LinkedList getApplicables(List list, Class[] classArray) {
        LinkedList linkedList = new LinkedList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Method method = (Method)iterator.next();
            if (!MethodMap.isApplicable(method, classArray)) continue;
            linkedList.add(method);
        }
        return linkedList;
    }

    private static boolean isApplicable(Method method, Class[] classArray) {
        Class[] classArray2 = method.getParameterTypes();
        if (classArray2.length != classArray.length) {
            return false;
        }
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            if (MethodMap.isMethodInvocationConvertible(classArray2[i2], classArray[i2])) continue;
            return false;
        }
        return true;
    }

    private static boolean isMethodInvocationConvertible(Class clazz, Class clazz2) {
        if (clazz2 == null && !clazz.isPrimitive()) {
            return true;
        }
        if (clazz2 != null && clazz.isAssignableFrom(clazz2)) {
            return true;
        }
        if (clazz.isPrimitive()) {
            if (clazz == Boolean.TYPE && clazz2 == (class$java$lang$Boolean == null ? (class$java$lang$Boolean = MethodMap.class$("java.lang.Boolean")) : class$java$lang$Boolean)) {
                return true;
            }
            if (clazz == Character.TYPE && clazz2 == (class$java$lang$Character == null ? (class$java$lang$Character = MethodMap.class$("java.lang.Character")) : class$java$lang$Character)) {
                return true;
            }
            if (clazz == Byte.TYPE && clazz2 == (class$java$lang$Byte == null ? (class$java$lang$Byte = MethodMap.class$("java.lang.Byte")) : class$java$lang$Byte)) {
                return true;
            }
            if (clazz == Short.TYPE && (clazz2 == (class$java$lang$Short == null ? (class$java$lang$Short = MethodMap.class$("java.lang.Short")) : class$java$lang$Short) || clazz2 == (class$java$lang$Byte == null ? (class$java$lang$Byte = MethodMap.class$("java.lang.Byte")) : class$java$lang$Byte))) {
                return true;
            }
            if (clazz == Integer.TYPE && (clazz2 == (class$java$lang$Integer == null ? (class$java$lang$Integer = MethodMap.class$("java.lang.Integer")) : class$java$lang$Integer) || clazz2 == (class$java$lang$Short == null ? (class$java$lang$Short = MethodMap.class$("java.lang.Short")) : class$java$lang$Short) || clazz2 == (class$java$lang$Byte == null ? (class$java$lang$Byte = MethodMap.class$("java.lang.Byte")) : class$java$lang$Byte))) {
                return true;
            }
            if (clazz == Long.TYPE && (clazz2 == (class$java$lang$Long == null ? (class$java$lang$Long = MethodMap.class$("java.lang.Long")) : class$java$lang$Long) || clazz2 == (class$java$lang$Integer == null ? (class$java$lang$Integer = MethodMap.class$("java.lang.Integer")) : class$java$lang$Integer) || clazz2 == (class$java$lang$Short == null ? (class$java$lang$Short = MethodMap.class$("java.lang.Short")) : class$java$lang$Short) || clazz2 == (class$java$lang$Byte == null ? (class$java$lang$Byte = MethodMap.class$("java.lang.Byte")) : class$java$lang$Byte))) {
                return true;
            }
            if (clazz == Float.TYPE && (clazz2 == (class$java$lang$Float == null ? (class$java$lang$Float = MethodMap.class$("java.lang.Float")) : class$java$lang$Float) || clazz2 == (class$java$lang$Long == null ? (class$java$lang$Long = MethodMap.class$("java.lang.Long")) : class$java$lang$Long) || clazz2 == (class$java$lang$Integer == null ? (class$java$lang$Integer = MethodMap.class$("java.lang.Integer")) : class$java$lang$Integer) || clazz2 == (class$java$lang$Short == null ? (class$java$lang$Short = MethodMap.class$("java.lang.Short")) : class$java$lang$Short) || clazz2 == (class$java$lang$Byte == null ? (class$java$lang$Byte = MethodMap.class$("java.lang.Byte")) : class$java$lang$Byte))) {
                return true;
            }
            if (clazz == Double.TYPE && (clazz2 == (class$java$lang$Double == null ? (class$java$lang$Double = MethodMap.class$("java.lang.Double")) : class$java$lang$Double) || clazz2 == (class$java$lang$Float == null ? (class$java$lang$Float = MethodMap.class$("java.lang.Float")) : class$java$lang$Float) || clazz2 == (class$java$lang$Long == null ? (class$java$lang$Long = MethodMap.class$("java.lang.Long")) : class$java$lang$Long) || clazz2 == (class$java$lang$Integer == null ? (class$java$lang$Integer = MethodMap.class$("java.lang.Integer")) : class$java$lang$Integer) || clazz2 == (class$java$lang$Short == null ? (class$java$lang$Short = MethodMap.class$("java.lang.Short")) : class$java$lang$Short) || clazz2 == (class$java$lang$Byte == null ? (class$java$lang$Byte = MethodMap.class$("java.lang.Byte")) : class$java$lang$Byte))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStrictMethodInvocationConvertible(Class clazz, Class clazz2) {
        if (clazz2 == null && !clazz.isPrimitive()) {
            return true;
        }
        if (clazz.isAssignableFrom(clazz2)) {
            return true;
        }
        if (clazz.isPrimitive()) {
            if (clazz == Short.TYPE && clazz2 == Byte.TYPE) {
                return true;
            }
            if (clazz == Integer.TYPE && (clazz2 == Short.TYPE || clazz2 == Byte.TYPE)) {
                return true;
            }
            if (clazz == Long.TYPE && (clazz2 == Integer.TYPE || clazz2 == Short.TYPE || clazz2 == Byte.TYPE)) {
                return true;
            }
            if (clazz == Float.TYPE && (clazz2 == Long.TYPE || clazz2 == Integer.TYPE || clazz2 == Short.TYPE || clazz2 == Byte.TYPE)) {
                return true;
            }
            if (clazz == Double.TYPE && (clazz2 == Float.TYPE || clazz2 == Long.TYPE || clazz2 == Integer.TYPE || clazz2 == Short.TYPE || clazz2 == Byte.TYPE)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

