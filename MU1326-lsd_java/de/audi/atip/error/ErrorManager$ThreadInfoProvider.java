/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ErrorManager$1;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class ErrorManager$ThreadInfoProvider
implements DumpInfoProvider {
    private ErrorManager$ThreadInfoProvider() {
    }

    @Override
    public String getName() {
        return "ThreadState";
    }

    private ThreadGroup getRoot() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }

    private void dumpThread(PrintStream printStream, Thread thread, String string) {
        printStream.print(new StringBuffer().append(string).append("Thread: ").append(thread.getName()).append(" Prio: ").append(thread.getPriority()).toString());
        if (!thread.isAlive()) {
            printStream.print(" ZOMBIE");
        }
        if (thread.isDaemon()) {
            printStream.print(" DAEMON");
        }
        if (thread.isInterrupted()) {
            printStream.print(" INTERRUPTED");
        }
        if (thread == Thread.currentThread()) {
            printStream.print(" CURRENT");
        }
        printStream.println();
        if (thread == Thread.currentThread()) {
            try {
                throw new Exception();
            }
            catch (Exception exception) {
                exception.printStackTrace(printStream);
            }
        }
    }

    private void dumpThreadGroup(PrintStream printStream, ThreadGroup threadGroup, String string) {
        printStream.println(new StringBuffer().append(string).append("ThreadGroup: ").append(threadGroup.getName()).toString());
        String string2 = new StringBuffer().append(string).append("  ").toString();
        Thread[] threadArray = new Thread[threadGroup.activeCount()];
        int n = threadGroup.enumerate(threadArray);
        for (int i2 = 0; i2 < n; ++i2) {
            if (threadArray[i2].getThreadGroup() != threadGroup) continue;
            this.dumpThread(printStream, threadArray[i2], string2);
        }
        ThreadGroup[] threadGroupArray = new ThreadGroup[threadGroup.activeGroupCount()];
        int n2 = threadGroup.enumerate(threadGroupArray);
        for (int i3 = 0; i3 < n2; ++i3) {
            if (threadGroupArray[i3].getParent() != threadGroup) continue;
            this.dumpThreadGroup(printStream, threadGroupArray[i3], string2);
        }
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        this.dumpThreadGroup(printStream, this.getRoot(), "");
        printStream.println();
    }

    /* synthetic */ ErrorManager$ThreadInfoProvider(ErrorManager$1 errorManager$1) {
        this();
    }
}

