/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  sun.misc.Perf
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.NanoTimer;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import java.lang.reflect.Array;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Iterator;
import sun.misc.Perf;

public final class Utils {
    private static final NanoTimer nanoTimer;
    private static final String providerProp = "edu.emory.mathcs.backport.java.util.concurrent.NanoTimerProvider";
    static /* synthetic */ Class array$Ljava$lang$Object;

    private Utils() {
    }

    public static long nanoTime() {
        return nanoTimer.nanoTime();
    }

    public static long awaitNanos(Condition condition, long l) throws InterruptedException {
        if (l <= 0L) {
            return l;
        }
        long l2 = Utils.nanoTime();
        condition.await(l, TimeUnit.NANOSECONDS);
        return l - (Utils.nanoTime() - l2);
    }

    private static long gcd(long l, long l2) {
        while (l2 > 0L) {
            long l3 = l % l2;
            l = l2;
            l2 = l3;
        }
        return l;
    }

    public static Object[] collectionToArray(Collection collection) {
        int n = collection.size();
        Object[] objectArray = new Object[n];
        Iterator iterator = collection.iterator();
        int n2 = 0;
        while (true) {
            if (n2 < n && iterator.hasNext()) {
                objectArray[n2++] = iterator.next();
                continue;
            }
            if (!iterator.hasNext()) {
                if (n2 == n) {
                    return objectArray;
                }
                return Arrays.copyOf(objectArray, n2, array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = Utils.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object);
            }
            int n3 = (objectArray.length / 2 + 1) * 3;
            if (n3 < objectArray.length) {
                if (objectArray.length < Integer.MAX_VALUE) {
                    n3 = Integer.MAX_VALUE;
                } else {
                    throw new OutOfMemoryError("required array size too large");
                }
            }
            objectArray = Arrays.copyOf(objectArray, n3, array$Ljava$lang$Object == null ? Utils.class$("[Ljava.lang.Object;") : array$Ljava$lang$Object);
            n = n3;
        }
    }

    public static Object[] collectionToArray(Collection collection, Object[] objectArray) {
        Class clazz = objectArray.getClass();
        int n = collection.size();
        Object[] objectArray2 = objectArray.length >= n ? objectArray : (Object[])Array.newInstance(clazz.getComponentType(), n);
        Iterator iterator = collection.iterator();
        int n2 = 0;
        while (true) {
            if (n2 < n && iterator.hasNext()) {
                objectArray2[n2++] = iterator.next();
                continue;
            }
            if (!iterator.hasNext()) {
                if (n2 == n) {
                    return objectArray2;
                }
                if (objectArray2 == objectArray) {
                    objectArray[n2] = null;
                    return objectArray;
                }
                return Arrays.copyOf(objectArray2, n2, clazz);
            }
            int n3 = (objectArray2.length / 2 + 1) * 3;
            if (n3 < objectArray2.length) {
                if (objectArray2.length < Integer.MAX_VALUE) {
                    n3 = Integer.MAX_VALUE;
                } else {
                    throw new OutOfMemoryError("required array size too large");
                }
            }
            objectArray2 = Arrays.copyOf(objectArray2, n3, clazz);
            n = n3;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        NanoTimer nanoTimer = null;
        try {
            String string = (String)AccessController.doPrivileged(new PrivilegedAction(){

                public Object run() {
                    return System.getProperty(Utils.providerProp);
                }
            });
            if (string != null) {
                Class clazz = Class.forName(string);
                nanoTimer = (NanoTimer)clazz.newInstance();
            }
        }
        catch (Exception exception) {
            System.err.println("WARNING: unable to load the system-property-defined nanotime provider; switching to the default");
            exception.printStackTrace();
        }
        if (nanoTimer == null) {
            try {
                nanoTimer = new SunPerfProvider();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (nanoTimer == null) {
            nanoTimer = new MillisProvider();
        }
        Utils.nanoTimer = nanoTimer;
    }

    private static final class MillisProvider
    implements NanoTimer {
        MillisProvider() {
        }

        public long nanoTime() {
            return System.currentTimeMillis() * 1000000L;
        }
    }

    private static final class SunPerfProvider
    implements NanoTimer {
        final Perf perf = (Perf)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                return Perf.getPerf();
            }
        });
        final long multiplier;
        final long divisor;

        SunPerfProvider() {
            long l = 1000000000L;
            long l2 = this.perf.highResFrequency();
            long l3 = Utils.gcd(l, l2);
            this.multiplier = l / l3;
            this.divisor = l2 / l3;
        }

        public long nanoTime() {
            long l = this.perf.highResCounter();
            return l / this.divisor * this.multiplier + l % this.divisor * this.multiplier / this.divisor;
        }
    }
}

