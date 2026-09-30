/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.Pair;
import de.audi.tv.app.util.Predicates;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ReflectionUtils {
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$java$lang$Object;

    public static final List parseArgs(Object object) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (object != null) {
            StringTokenizer stringTokenizer = new StringTokenizer((String)object, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String string = stringTokenizer.nextToken().trim();
                Pair pair = ReflectionUtils.parseToken(string);
                linkedList.add(pair.first);
                linkedList2.add(pair.second);
            }
        }
        return linkedList2;
    }

    private static Pair parseToken(String string) {
        try {
            int n = Integer.parseInt(string);
            return new Pair(Integer.TYPE, new Integer(n));
        }
        catch (NumberFormatException numberFormatException) {
            try {
                long l = Long.parseLong(string);
                return new Pair(Long.TYPE, new Long(l));
            }
            catch (NumberFormatException numberFormatException2) {
                try {
                    float f2 = Float.parseFloat(string);
                    return new Pair(Float.TYPE, new Float(f2));
                }
                catch (NumberFormatException numberFormatException3) {
                    try {
                        double d2 = Double.parseDouble(string);
                        return new Pair(Double.TYPE, new Double(d2));
                    }
                    catch (NumberFormatException numberFormatException4) {
                        if (string != null && (string.toLowerCase().equals("true") || string.toLowerCase().equals("false"))) {
                            return new Pair(Boolean.TYPE, Boolean.valueOf(string));
                        }
                        return new Pair(class$java$lang$String == null ? (class$java$lang$String = ReflectionUtils.class$("java.lang.String")) : class$java$lang$String, string);
                    }
                }
            }
        }
    }

    public static Collection getDeclaredFields(Class clazz) {
        return Predicates.filter(Arrays.asList(clazz.getDeclaredFields()), new Predicates.Predicate(){

            public boolean apply(Object object) {
                boolean bl = Modifier.isPrivate(((Field)object).getModifiers());
                boolean bl2 = ((Field)object).getName().startsWith("this");
                return !bl2 && !bl;
            }
        });
    }

    public static Collection getPublicDeclaredMethods(Class clazz) {
        List list = Arrays.asList(clazz.getDeclaredMethods());
        Predicates.AndCompoundPredicate andCompoundPredicate = new Predicates.AndCompoundPredicate();
        andCompoundPredicate.add(new IsNotPrivatePredicate());
        andCompoundPredicate.add(new IsNotEnclosingAccessPredicate());
        return Predicates.filter(list, andCompoundPredicate);
    }

    public static String getSimpleName(Class clazz) {
        int n = Math.max(clazz.getName().lastIndexOf(36), clazz.getName().lastIndexOf(46));
        return clazz.getName().substring(n + 1);
    }

    public static boolean implementsInterface(Class clazz, Class clazz2) {
        Class clazz3 = clazz;
        while (!clazz3.equals(class$java$lang$Object == null ? ReflectionUtils.class$("java.lang.Object") : class$java$lang$Object)) {
            if (Arrays.asList(clazz3.getInterfaces()).contains(clazz2)) {
                return true;
            }
            clazz3 = clazz3.getSuperclass();
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

    private static class IsNotPrivatePredicate
    implements Predicates.Predicate {
        private IsNotPrivatePredicate() {
        }

        public boolean apply(Object object) {
            return !Modifier.isPrivate(((Method)object).getModifiers());
        }
    }

    private static class IsNotEnclosingAccessPredicate
    implements Predicates.Predicate {
        private IsNotEnclosingAccessPredicate() {
        }

        public boolean apply(Object object) {
            return !((Method)object).getName().startsWith("access");
        }
    }
}

