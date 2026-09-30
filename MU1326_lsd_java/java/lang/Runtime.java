/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.lang.SystemProcess;
import com.ibm.oti.vm.VM;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

public class Runtime {
    private static final Runtime runtime = new Runtime();

    private Runtime() {
    }

    public Process exec(String[] stringArray) throws IOException {
        return this.exec(stringArray, null);
    }

    public Process exec(String[] stringArray, String[] stringArray2) throws IOException {
        return this.exec(stringArray, stringArray2, null);
    }

    public Process exec(String[] stringArray, String[] stringArray2, File file) throws IOException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkExec(stringArray[0]);
        }
        if (stringArray2 == null) {
            stringArray2 = new String[]{};
        }
        return SystemProcess.create(stringArray, stringArray2, file);
    }

    public Process exec(String string) throws IOException {
        return this.exec(string, null);
    }

    public Process exec(String string, String[] stringArray) throws IOException {
        return this.exec(string, stringArray, null);
    }

    public Process exec(String string, String[] stringArray, File file) throws IOException {
        int n = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(string);
        int n2 = stringTokenizer.countTokens();
        String[] stringArray2 = new String[n2];
        while (n < n2) {
            stringArray2[n++] = stringTokenizer.nextToken();
        }
        return this.exec(stringArray2, stringArray, file);
    }

    public void exit(int n) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkExit(n);
        }
        this.exitImpl(n);
    }

    private native void exitImpl(int var1);

    public native long freeMemory();

    public native void gc();

    public static Runtime getRuntime() {
        return runtime;
    }

    public synchronized void load(String string) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkLink(string);
        }
        ClassLoader.loadLibraryWithPath(string, ClassLoader.callerClassLoader(), null);
    }

    public void loadLibrary(String string) {
        ClassLoader.loadLibraryWithClassLoader(string, ClassLoader.callerClassLoader());
    }

    public native void runFinalization();

    public native long totalMemory();

    public void traceInstructions(boolean bl) {
    }

    public void traceMethodCalls(boolean bl) {
    }

    public void addShutdownHook(Thread thread) {
        VM.addShutdownHook(thread);
    }

    public boolean removeShutdownHook(Thread thread) {
        return VM.removeShutdownHook(thread);
    }

    public void halt(int n) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkExit(n);
        }
        this.haltImpl(n);
    }

    private native void haltImpl(int var1);

    public int availableProcessors() {
        return this.availableProcessorsImpl();
    }

    private native int availableProcessorsImpl();

    public long maxMemory() {
        return this.maxMemoryImpl();
    }

    private native long maxMemoryImpl();
}

