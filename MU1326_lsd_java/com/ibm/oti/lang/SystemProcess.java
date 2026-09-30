/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang;

import com.ibm.oti.lang.ProcessInputStream;
import com.ibm.oti.lang.ProcessOutputStream;
import com.ibm.oti.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SystemProcess
extends Process {
    InputStream err;
    InputStream out;
    OutputStream in;
    long handle = -1L;
    boolean exitCodeAvailable = false;
    int exitCode;
    Object lock;
    boolean waiterStarted = false;
    Throwable exception = null;

    static {
        SystemProcess.oneTimeInitialization();
    }

    private static native void oneTimeInitialization();

    private SystemProcess() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Process create(String[] stringArray, String[] stringArray2, final File file) throws IOException {
        final byte[][] byArray = new byte[stringArray.length][];
        int n = 0;
        while (n < stringArray.length) {
            byArray[n] = Util.getBytes(stringArray[n]);
            ++n;
        }
        final byte[][] byArray2 = new byte[stringArray2.length][];
        n = 0;
        while (n < stringArray2.length) {
            byArray2[n] = Util.getBytes(stringArray2[n]);
            ++n;
        }
        final SystemProcess systemProcess = new SystemProcess();
        systemProcess.lock = new Object();
        Runnable runnable = new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                long[] lArray = null;
                try {
                    lArray = SystemProcess.createImpl(systemProcess, byArray, byArray2, file == null ? null : Util.getBytes(file.getPath()));
                }
                catch (Throwable throwable) {
                    Object object = systemProcess.lock;
                    synchronized (object) {
                        systemProcess.exception = throwable;
                        systemProcess.waiterStarted = true;
                        systemProcess.lock.notifyAll();
                    }
                    return;
                }
                systemProcess.handle = lArray[0];
                systemProcess.in = new ProcessOutputStream(lArray[1]);
                systemProcess.out = new ProcessInputStream(lArray[2]);
                systemProcess.err = new ProcessInputStream(lArray[3]);
                Object object = systemProcess.lock;
                synchronized (object) {
                    systemProcess.waiterStarted = true;
                    systemProcess.lock.notifyAll();
                }
                systemProcess.exitCode = systemProcess.waitForCompletionImpl();
                object = systemProcess.lock;
                synchronized (object) {
                    systemProcess.closeImpl();
                    systemProcess.handle = -1L;
                    systemProcess.exitCodeAvailable = true;
                    try {
                        systemProcess.in.close();
                    }
                    catch (IOException iOException) {}
                    systemProcess.lock.notifyAll();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        Object object = systemProcess.lock;
        synchronized (object) {
            boolean bl = false;
            while (!systemProcess.waiterStarted) {
                try {
                    systemProcess.lock.wait();
                }
                catch (InterruptedException interruptedException) {
                    bl = true;
                }
            }
            if (bl) {
                Thread.currentThread().interrupt();
            }
            if (systemProcess.exception != null) {
                systemProcess.exception.fillInStackTrace();
                if (systemProcess.exception instanceof IOException) {
                    throw (IOException)systemProcess.exception;
                }
                if (systemProcess.exception instanceof Error) {
                    throw (Error)systemProcess.exception;
                }
                throw (RuntimeException)systemProcess.exception;
            }
        }
        return systemProcess;
    }

    protected static synchronized native long[] createImpl(Process var0, byte[][] var1, byte[][] var2, byte[] var3);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void destroy() {
        Object object = this.lock;
        synchronized (object) {
            if (this.handle != -1L) {
                this.destroyImpl();
            }
        }
    }

    private native void destroyImpl();

    native void closeImpl();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int exitValue() {
        Object object = this.lock;
        synchronized (object) {
            if (!this.exitCodeAvailable) {
                throw new IllegalThreadStateException();
            }
            return this.exitCode;
        }
    }

    public InputStream getErrorStream() {
        return this.err;
    }

    public InputStream getInputStream() {
        return this.out;
    }

    public OutputStream getOutputStream() {
        return this.in;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int waitFor() throws InterruptedException {
        Object object = this.lock;
        synchronized (object) {
            while (!this.exitCodeAvailable) {
                this.lock.wait();
            }
            return this.exitCode;
        }
    }

    native int waitForCompletionImpl();
}

