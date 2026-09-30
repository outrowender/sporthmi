/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9;

import com.microdoc.j9.ThreadInfo;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Hashtable;

public class Tools {
    public static void init() {
        long l;
        final int n = Integer.getInteger("dumpPriority", 5);
        final Integer n2 = Integer.getInteger("dumpThreadOnPort");
        if (n2 != null) {
            new Thread(){

                public void run() {
                    this.setName("Thread Dump - Socket listener");
                    this.setPriority(n);
                    Tools.runServerSocket(n2);
                }
            }.start();
        }
        if (0L != (l = Tools.getIntervalSetting("dumpThreads"))) {
            long l2 = Tools.getIntervalSetting("dumpThreadDelay");
            new IntervalThread(l, l2){

                public void run() {
                    this.setName("Thread Dump - Loop");
                    this.setPriority(n);
                    Tools.runThreadDumpLoop(this.fInterval, this.fInitialDelay, Integer.getInteger("deadlockDetection", -1));
                }
            }.start();
        }
    }

    private static void runThreadDumpLoop(long l, long l2, int n) {
        int n2 = 0;
        try {
            Thread.sleep(l2);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        while (true) {
            ThreadInfo[] threadInfoArray = Tools.getThreadsInfo();
            Tools.outputInfo(threadInfoArray, System.out);
            if (n > 0 && ++n2 >= n) {
                Tools.searchForDeadlocks(threadInfoArray, System.out);
                n2 = 0;
            }
            try {
                Thread.sleep(l);
            }
            catch (InterruptedException interruptedException) {
            }
        }
    }

    private static void searchForDeadlocks(ThreadInfo[] threadInfoArray, PrintStream printStream) {
        try {
            class DDInfo {
                ThreadInfo fThreadInfo;
                int fVisited = -1;
                boolean fDeadlocked = false;

                public DDInfo(ThreadInfo threadInfo) {
                    this.fThreadInfo = threadInfo;
                }

                public boolean isBlocked() {
                    int n = this.fThreadInfo.getStatus();
                    return n == 1 || n == 2;
                }
            }
            DDInfo dDInfo;
            ThreadInfo threadInfo;
            if (threadInfoArray == null) {
                return;
            }
            Hashtable hashtable = new Hashtable(threadInfoArray.length * 2);
            int n = 0;
            while (n < threadInfoArray.length) {
                ThreadInfo threadInfo2 = threadInfoArray[n];
                hashtable.put(threadInfo2.getThread(), new DDInfo(threadInfo2));
                ++n;
            }
            n = 0;
            int n2 = 0;
            while (n2 < threadInfoArray.length) {
                threadInfo = threadInfoArray[n2];
                dDInfo = (DDInfo)hashtable.get(threadInfo.getThread());
                if (dDInfo.fVisited < 0) {
                    dDInfo.fVisited = n2;
                    if (dDInfo.isBlocked()) {
                        DDInfo dDInfo2;
                        Thread thread = dDInfo.fThreadInfo.getMonitorOwner();
                        while (thread != null) {
                            dDInfo2 = (DDInfo)hashtable.get(thread);
                            if (dDInfo2 == null) {
                                if (thread == Thread.currentThread()) break;
                                System.out.println("JVM WARNING: monitor owner thread not listed");
                                System.out.println(new StringBuffer("             ").append(thread).toString());
                                break;
                            }
                            if (dDInfo2.fDeadlocked || dDInfo2.fVisited == n2) {
                                dDInfo.fDeadlocked = true;
                                break;
                            }
                            if (!dDInfo2.isBlocked()) {
                                dDInfo2.fVisited = n2;
                                break;
                            }
                            if (dDInfo2.fVisited >= 0 && dDInfo2.fVisited < n2) break;
                            dDInfo2.fVisited = n2;
                            thread = dDInfo2.fThreadInfo.getMonitorOwner();
                        }
                        if (dDInfo.fDeadlocked) {
                            ++n;
                            dDInfo2 = (DDInfo)hashtable.get(dDInfo.fThreadInfo.getMonitorOwner());
                            while (!dDInfo2.fDeadlocked) {
                                dDInfo2.fDeadlocked = true;
                                ++n;
                                dDInfo2 = (DDInfo)hashtable.get(dDInfo2.fThreadInfo.getMonitorOwner());
                            }
                        }
                    }
                }
                ++n2;
            }
            if (n > 0) {
                System.out.println(new StringBuffer("Found ").append(n).append(" deadlocked threads!!!").toString());
                n2 = 0;
                while (n2 < threadInfoArray.length) {
                    threadInfo = threadInfoArray[n2];
                    dDInfo = (DDInfo)hashtable.get(threadInfo.getThread());
                    if (dDInfo.fDeadlocked) {
                        System.out.println(threadInfo.toString());
                    }
                    ++n2;
                }
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static long getIntervalSetting(String string) {
        Integer n = Integer.getInteger(string);
        if (n != null) {
            return n.longValue() * 1000L;
        }
        Long l = Long.getLong(new StringBuffer(String.valueOf(string)).append("Ms").toString());
        if (l != null) {
            return l;
        }
        return 0L;
    }

    private static void runServerSocket(int n) {
        try {
            ServerSocket serverSocket = new ServerSocket(n);
            while (true) {
                Socket socket = serverSocket.accept();
                Tools.dumpThreadsInfo();
                socket.close();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
    }

    private static void outputInfo(ThreadInfo[] threadInfoArray, PrintStream printStream) {
        try {
            if (threadInfoArray == null) {
                System.out.println("No thread information received");
                return;
            }
            printStream.println(new StringBuffer("Thread informations for ").append(threadInfoArray.length).append(" threads (").append(new Date()).append(")").toString());
            int n = 0;
            while (n < threadInfoArray.length) {
                if (threadInfoArray[n] != null) {
                    printStream.println(threadInfoArray[n].toString());
                }
                ++n;
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static native ThreadInfo[] getThreadsInfo();

    public static void dumpThreadsInfo(boolean bl, boolean bl2) {
        ThreadInfo[] threadInfoArray = Tools.getThreadsInfo();
        if (bl) {
            Tools.outputInfo(threadInfoArray, System.out);
        }
        if (bl2) {
            Tools.searchForDeadlocks(threadInfoArray, System.out);
        }
    }

    public static void dumpThreadsInfo() {
        Tools.dumpThreadsInfo(true, true);
    }

    private static class IntervalThread
    extends Thread {
        long fInterval;
        long fInitialDelay;

        public IntervalThread(long l, long l2) {
            this.fInterval = l;
            this.fInitialDelay = l2;
        }
    }
}

