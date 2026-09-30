/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import de.audi.atip.utils.collections.Optional;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.collections.Predicates;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.GPair;
import de.audi.atip.utils.generics.Generics;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
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
                GPair<Class, Object> gPair = ReflectionUtils.parseToken(string);
                linkedList.add(gPair.getFirst());
                linkedList2.add(gPair.getSecond());
            }
        }
        return linkedList2;
    }

    private static GPair<Class, Object> parseToken(String string) {
        try {
            int n = Integer.parseInt(string);
            return new GPair<Class, Object>(Integer.TYPE, new Integer(n));
        }
        catch (NumberFormatException numberFormatException) {
            try {
                long l = Long.parseLong(string);
                return new GPair<Class, Object>(Long.TYPE, new Long(l));
            }
            catch (NumberFormatException numberFormatException2) {
                try {
                    float f2 = Float.parseFloat(string);
                    return new GPair<Class, Object>(Float.TYPE, new Float(f2));
                }
                catch (NumberFormatException numberFormatException3) {
                    try {
                        double d2 = Double.parseDouble(string);
                        return new GPair<Class, Object>(Double.TYPE, new Double(d2));
                    }
                    catch (NumberFormatException numberFormatException4) {
                        if (string != null && (string.toLowerCase().equals("true") || string.toLowerCase().equals("false"))) {
                            return new GPair<Class, Object>(Boolean.TYPE, Boolean.valueOf(string));
                        }
                        return new GPair<Class, Object>(class$java$lang$String == null ? (class$java$lang$String = ReflectionUtils.class$("java.lang.String")) : class$java$lang$String, string);
                    }
                }
            }
        }
    }

    public static Collection getDeclaredFields(Class clazz) {
        return Predicates.filter(Arrays.asList(clazz.getDeclaredFields()), new Predicate<Field>(){

            @Override
            public boolean apply(Field field) {
                boolean bl = Modifier.isPrivate(field.getModifiers());
                boolean bl2 = field.getName().startsWith("this");
                return !bl2 && !bl;
            }

            @Override
            public /* synthetic */ boolean apply(Object object) {
                return this.apply((Field)object);
            }
        });
    }

    public static Collection getPublicDeclaredMethods(Class clazz) {
        List list = Arrays.asList(clazz.getDeclaredMethods());
        Predicates.AndCompoundPredicate<Method> andCompoundPredicate = new Predicates.AndCompoundPredicate<Method>();
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

    public static Optional<Field> getFieldByName(Class clazz, final String string) {
        Optional<Field> optional = Predicates.tryFind(Generics.newArrayList(clazz.getDeclaredFields()), new Predicate<Field>(){

            @Override
            public boolean apply(Field field) {
                return field.getName().equals(string);
            }

            @Override
            public /* synthetic */ boolean apply(Object object) {
                return this.apply((Field)object);
            }
        });
        return optional;
    }

    public static GMap<Integer, Integer> createConstantsMap(String string, String string2, String string3) {
        GMap<Integer, Integer> gMap = Generics.newHashMap();
        try {
            Field[] fieldArray;
            Class clazz = Class.forName(string);
            Class clazz2 = Class.forName(string2);
            for (Field field : fieldArray = clazz.getDeclaredFields()) {
                if (!field.getName().startsWith(string3)) continue;
                Optional<Field> optional = ReflectionUtils.getFieldByName(clazz2, field.getName());
                if (optional.exists() && optional.get().getName().startsWith(string3)) {
                    gMap.put(new Integer(field.getInt(clazz)), new Integer(optional.get().getInt(clazz2)));
                    continue;
                }
                gMap.put(new Integer(field.getInt(clazz)), null);
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
            return null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return null;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            return null;
        }
        return gMap;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class IsNotPrivatePredicate
    implements Predicate<Method> {
        private IsNotPrivatePredicate() {
        }

        @Override
        public boolean apply(Method method) {
            return !Modifier.isPrivate(method.getModifiers());
        }

        @Override
        public /* synthetic */ boolean apply(Object object) {
            return this.apply((Method)object);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class IsNotOverridePredicate
    implements Predicate<Method> {
        Collection superClassAndInterfcaeMethods;

        public IsNotOverridePredicate(Class clazz) {
            Class clazz2 = clazz;
            this.addInterfaces(clazz2);
            while (!clazz2.equals(class$java$lang$Object == null ? ReflectionUtils.class$("java.lang.Object") : class$java$lang$Object)) {
                clazz2 = clazz.getSuperclass();
                this.addInterfaces(clazz2);
                this.addMethods(clazz2);
            }
        }

        private void addInterfaces(Class clazz) {
            Iterator iterator = Arrays.asList(clazz.getInterfaces()).iterator();
            while (iterator.hasNext()) {
                Class clazz2 = (Class)iterator.next();
                this.addMethods(clazz2);
            }
        }

        private boolean addMethods(Class clazz) {
            return this.superClassAndInterfcaeMethods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
        }

        @Override
        public boolean apply(Method method) {
            return Predicates.filter(this.superClassAndInterfcaeMethods, new EqualsByNamePredicate(method)).isEmpty();
        }

        @Override
        public /* synthetic */ boolean apply(Object object) {
            return this.apply((Method)object);
        }

        /*
         * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
         */
        private class EqualsByNamePredicate
        implements Predicate<Method> {
            private Method oneMethod;

            public EqualsByNamePredicate(Method method) {
                this.oneMethod = method;
            }

            @Override
            public boolean apply(Method method) {
                return method.getName().equals(this.oneMethod.getName());
            }

            @Override
            public /* synthetic */ boolean apply(Object object) {
                return this.apply((Method)object);
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class IsNotEnclosingAccessPredicate
    implements Predicate<Method> {
        private IsNotEnclosingAccessPredicate() {
        }

        @Override
        public boolean apply(Method method) {
            return !method.getName().startsWith("access");
        }

        @Override
        public /* synthetic */ boolean apply(Object object) {
            return this.apply((Method)object);
        }
    }
}

