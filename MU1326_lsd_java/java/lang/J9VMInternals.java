/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

class J9VMInternals {
    private static final int UNINITIALIZED = 0;
    private static final int INITIALIZED = 1;
    private static final int FAILED = 2;
    private static final int UNVERIFIED = 3;
    private static Map exceptions;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;

    J9VMInternals() {
    }

    private static void completeInitialization() {
        exceptions = new WeakHashMap();
        ClassLoader.completeInitialization();
        Thread.currentThread().completeInitialization();
    }

    private static native void sendClassPrepareEvent(Class var0);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void verify(Class clazz) {
        block24: while (true) {
            Class clazz2;
            switch (J9VMInternals.getInitStatus(clazz)) {
                case 0: 
                case 1: 
                case 2: {
                    return;
                }
                case 3: {
                    Class clazz3 = clazz;
                    synchronized (clazz3) {
                        if (J9VMInternals.getInitStatus(clazz) != 3) {
                            continue block24;
                        }
                        J9VMInternals.setInitThread(clazz);
                    }
                    clazz2 = clazz.getSuperclass();
                    try {
                        if (clazz2 != null) {
                            J9VMInternals.verify(clazz2);
                        }
                        J9VMInternals.verifyImpl(clazz);
                    }
                    catch (Error error) {
                        J9VMInternals.setInitStatus(clazz, 3);
                        throw error;
                    }
                    catch (Throwable throwable) {
                        J9VMInternals.setInitStatus(clazz, 3);
                        throw new VerifyError(throwable.toString());
                    }
                    clazz3 = clazz;
                    synchronized (clazz3) {
                        if (J9VMInternals.getInitThread(clazz) && (J9VMInternals.getInitStatus(clazz) & 3) == 3) {
                            J9VMInternals.setInitStatus(clazz, 0);
                        }
                    }
                    return;
                }
            }
            clazz2 = clazz;
            synchronized (clazz2) {
                int n = J9VMInternals.getInitStatus(clazz);
                if ((n & 0xFFFFFFFC) == 0) {
                    continue;
                }
                if ((n & 3) != 3) {
                    return;
                }
                if (!J9VMInternals.getInitThread(clazz)) {
                    try {
                        clazz.wait();
                    }
                    catch (InterruptedException interruptedException) {}
                    continue;
                }
            }
            try {
                J9VMInternals.verifyImpl(clazz);
            }
            catch (Error error) {
                J9VMInternals.setInitStatus(clazz, 3);
                throw error;
            }
            catch (Throwable throwable) {
                J9VMInternals.setInitStatus(clazz, 3);
                throw new VerifyError(throwable.toString());
            }
            clazz2 = clazz;
            synchronized (clazz2) {
                if (J9VMInternals.getInitThread(clazz) && (J9VMInternals.getInitStatus(clazz) & 3) == 3) {
                    J9VMInternals.setInitStatus(clazz, 0);
                }
            }
        }
    }

    private static native void verifyImpl(Class var0);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void initialize(Class clazz) throws Throwable {
        block31: while (true) {
            Object object;
            switch (J9VMInternals.getInitStatus(clazz)) {
                case 1: {
                    return;
                }
                case 3: {
                    J9VMInternals.verify(clazz);
                    continue block31;
                }
                case 2: {
                    NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError(new StringBuffer(String.valueOf(clazz.getName())).append(" (initialization failure)").toString());
                    if (exceptions != null) {
                        object = exceptions;
                        synchronized (object) {
                            Throwable throwable;
                            WeakReference weakReference = (WeakReference)exceptions.get(clazz);
                            if (weakReference != null && (throwable = (Throwable)weakReference.get()) != null) {
                                throwable = J9VMInternals.copyThrowable(throwable);
                                noClassDefFoundError.initCause(throwable);
                            }
                        }
                    }
                    throw noClassDefFoundError;
                }
                case 0: {
                    Class clazz2 = clazz;
                    synchronized (clazz2) {
                        if (J9VMInternals.getInitStatus(clazz) != 0) {
                            continue block31;
                        }
                        J9VMInternals.setInitThread(clazz);
                    }
                    object = clazz.getSuperclass();
                    if (object != null) {
                        try {
                            J9VMInternals.initialize((Class)object);
                        }
                        catch (Error error) {
                            J9VMInternals.setInitStatus(clazz, 2);
                            if (exceptions == null) {
                                exceptions = new WeakHashMap();
                            }
                            Map map = exceptions;
                            synchronized (map) {
                                Throwable throwable = error;
                                if (error instanceof ExceptionInInitializerError) {
                                    throwable = ((ExceptionInInitializerError)error).getException();
                                }
                                exceptions.put(clazz, new WeakReference(J9VMInternals.copyThrowable(throwable)));
                            }
                            throw error;
                        }
                    }
                    J9VMInternals.sendClassPrepareEvent(clazz);
                    try {
                        J9VMInternals.initializeImpl(clazz);
                    }
                    catch (Error error) {
                        J9VMInternals.setInitStatus(clazz, 2);
                        if (exceptions == null) {
                            exceptions = new WeakHashMap();
                        }
                        Map map = exceptions;
                        synchronized (map) {
                            exceptions.put(clazz, new WeakReference(J9VMInternals.copyThrowable(error)));
                        }
                        throw error;
                    }
                    catch (Throwable throwable) {
                        J9VMInternals.setInitStatus(clazz, 2);
                        if (exceptions == null) {
                            exceptions = new WeakHashMap();
                        }
                        Map map = exceptions;
                        synchronized (map) {
                            exceptions.put(clazz, new WeakReference(J9VMInternals.copyThrowable(throwable)));
                        }
                        throw new ExceptionInInitializerError(throwable);
                    }
                    J9VMInternals.setInitStatus(clazz, 1);
                    return;
                }
            }
            object = clazz;
            synchronized (object) {
                int n = J9VMInternals.getInitStatus(clazz);
                if ((n & 0xFFFFFFFC) == 0) {
                    continue;
                }
                if ((n & 3) == 0) {
                    if (J9VMInternals.getInitThread(clazz)) {
                        return;
                    }
                    try {
                        clazz.wait();
                    }
                    catch (InterruptedException interruptedException) {}
                    continue;
                }
            }
            J9VMInternals.verify(clazz);
        }
    }

    private static native Throwable newInstance(Class var0, Class var1);

    private static Throwable cloneThrowable(final Throwable throwable) {
        return (Throwable)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                Throwable throwable3;
                try {
                    Class clazz = throwable.getClass();
                    Class clazz2 = class$0;
                    if (clazz2 == null) {
                        try {
                            clazz2 = class$0 = Class.forName("java.lang.Object");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    throwable3 = J9VMInternals.newInstance(clazz, clazz2);
                    while (clazz != null) {
                        Field[] fieldArray = clazz.getDeclaredFields();
                        int n = 0;
                        while (n < fieldArray.length) {
                            if (!Modifier.isStatic(fieldArray[n].getModifiers())) {
                                Class clazz3 = class$1;
                                if (clazz3 == null) {
                                    try {
                                        clazz3 = Class.forName("java.lang.Throwable");
                                    }
                                    catch (ClassNotFoundException classNotFoundException) {
                                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                                    }
                                }
                                if (clazz != clazz3 || !fieldArray[n].getName().equals("walkback")) {
                                    fieldArray[n].setAccessible(true);
                                    Class clazz4 = class$1;
                                    if (clazz4 == null) {
                                        try {
                                            clazz4 = Class.forName("java.lang.Throwable");
                                        }
                                        catch (ClassNotFoundException classNotFoundException) {
                                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                                        }
                                    }
                                    Object object = clazz == clazz4 && fieldArray[n].getName().equals("cause") ? throwable3 : fieldArray[n].get(throwable);
                                    fieldArray[n].set(throwable3, object);
                                }
                            }
                            ++n;
                        }
                        clazz = clazz.getSuperclass();
                    }
                }
                catch (Throwable throwable2) {
                    throwable3 = new Throwable(new StringBuffer("Error cloning Throwable (").append(throwable2).append("). The original exception was: ").append(throwable.toString()).toString());
                }
                return throwable3;
            }
        });
    }

    private static Throwable copyThrowable(Throwable throwable) {
        Throwable throwable2 = J9VMInternals.cloneThrowable(throwable);
        throwable2.setStackTrace(throwable.getStackTrace());
        Throwable throwable3 = throwable2;
        Throwable throwable4 = throwable.getCause();
        HashMap hashMap = new HashMap();
        hashMap.put(throwable, throwable);
        while (throwable4 != null && hashMap.get(throwable4) == null) {
            hashMap.put(throwable4, throwable4);
            Throwable throwable5 = J9VMInternals.cloneThrowable(throwable4);
            throwable5.setStackTrace(throwable4.getStackTrace());
            throwable3.initCause(throwable5);
            throwable3 = throwable5;
            throwable4 = throwable4.getCause();
        }
        return throwable2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void setInitStatus(Class clazz, int n) {
        Class clazz2 = clazz;
        synchronized (clazz2) {
            J9VMInternals.setInitStatusImpl(clazz, n);
            clazz.notifyAll();
        }
    }

    private static native int getInitStatus(Class var0);

    private static native void setInitStatusImpl(Class var0, int var1);

    private static native void initializeImpl(Class var0);

    private static native boolean getInitThread(Class var0);

    private static native void setInitThread(Class var0);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void threadCleanup(Thread thread) {
        try {
            thread.threadGroup.remove(thread);
        }
        catch (Throwable throwable) {
            thread.threadGroup = null;
            Object object = thread.lock;
            synchronized (object) {
                thread.threadRef = 0L;
            }
            object = thread;
            synchronized (object) {
                thread.notifyAll();
            }
            throw throwable;
        }
        thread.threadGroup = null;
        Object object = thread.lock;
        synchronized (object) {
            thread.threadRef = 0L;
        }
        object = thread;
        synchronized (object) {
            thread.notifyAll();
        }
    }

    private static void checkPackageAccess(Class clazz) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPackageAccess(clazz.getPackageName());
        }
    }

    private static void runFinalize(Object object) {
        try {
            object.finalize();
        }
        catch (Throwable throwable) {}
    }

    static native StackTraceElement[] getStackTrace(Throwable var0, boolean var1);
}

