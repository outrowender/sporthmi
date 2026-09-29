/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.Pair;
import de.audi.tv.app.util.Predicates;
import de.audi.tv.app.util.Predicates$AndCompoundPredicate;
import de.audi.tv.app.util.ReflectionUtils$1;
import de.audi.tv.app.util.ReflectionUtils$IsNotEnclosingAccessPredicate;
import de.audi.tv.app.util.ReflectionUtils$IsNotPrivatePredicate;
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
                        double d2 = Double.parseDouble((String)string);
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
        return Predicates.filter(Arrays.asList(clazz.getDeclaredFields()), new ReflectionUtils$1());
    }

    public static Collection getPublicDeclaredMethods(Class clazz) {
        List list = Arrays.asList(clazz.getDeclaredMethods());
        Predicates$AndCompoundPredicate predicates$AndCompoundPredicate = new Predicates$AndCompoundPredicate();
        predicates$AndCompoundPredicate.add(new ReflectionUtils$IsNotPrivatePredicate(null));
        predicates$AndCompoundPredicate.add(new ReflectionUtils$IsNotEnclosingAccessPredicate(null));
        return Predicates.filter(list, predicates$AndCompoundPredicate);
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
}

