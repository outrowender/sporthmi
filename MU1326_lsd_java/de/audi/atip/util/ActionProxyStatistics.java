/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.util.ModelStatistics;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ActionProxyStatistics {
    public static final boolean DEBUG_PROCESSING_TIME = false;
    private static final long PROCESSING_THRESHOLD = 50L;
    private static ActionProxyStatistics instance = new ActionProxyStatistics();
    private SortedMap data = new TreeMap();
    private long started = System.currentTimeMillis();

    private ActionProxyStatistics() {
    }

    public static ActionProxyStatistics getInstance() {
        return instance;
    }

    public synchronized void reset() {
        this.data = new TreeMap();
        this.started = System.currentTimeMillis();
    }

    public synchronized void dump(PrintStream printStream) {
        printStream.print("Statistic measured for Action Proxies: ");
        printStream.println(System.currentTimeMillis() - this.started);
        Iterator iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            ((ActionProxyCallData)this.data.get(iterator.next())).dump(printStream);
        }
    }

    public synchronized void dumpCriticalMethodCalls(PrintStream printStream) {
        printStream.print("Statistic measured for: ");
        printStream.println(System.currentTimeMillis() - this.started);
        Iterator iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            ((ActionProxyCallData)this.data.get(iterator.next())).dumpCriticalCalls(printStream);
        }
    }

    public synchronized void addActionProxyCall(String string, String string2, long l) {
        ActionProxyCallData actionProxyCallData = this.getAPCallData(string, string2);
        actionProxyCallData.addCall(l);
        ModelStatistics.resetSleepTime();
    }

    private ActionProxyCallData getAPCallData(String string, String string2) {
        String string3 = string + '.' + string2;
        ActionProxyCallData actionProxyCallData = (ActionProxyCallData)this.data.get(string3);
        if (actionProxyCallData == null) {
            actionProxyCallData = new ActionProxyCallData(string, string2);
            this.data.put(string3, actionProxyCallData);
        }
        return actionProxyCallData;
    }

    private static class ActionProxyCallData {
        private final String ap;
        private final String apMethod;
        private int calls;
        private long totalProcessingTime;
        private List criticalMethodCalls;

        public ActionProxyCallData(String string, String string2) {
            this.ap = string;
            this.apMethod = string2;
        }

        void addCall(long l) {
            ++this.calls;
            this.totalProcessingTime += l;
            if (l > 50L) {
                if (this.criticalMethodCalls == null) {
                    this.criticalMethodCalls = new ArrayList(20);
                }
                long[] lArray = ModelStatistics.getSleepPeriods();
                long[] lArray2 = new long[lArray.length + 1];
                lArray2[0] = l;
                System.arraycopy((Object)lArray, 0, (Object)lArray2, 1, lArray.length);
                this.criticalMethodCalls.add(lArray2);
            }
        }

        void dump(PrintStream printStream) {
            printStream.print("AP-call: ");
            printStream.print(this.ap);
            printStream.print(".");
            printStream.print(this.apMethod);
            printStream.print(", ");
            printStream.print(this.calls);
            printStream.print(", ");
            printStream.println(this.totalProcessingTime);
            if (this.criticalMethodCalls != null) {
                int n = this.criticalMethodCalls.size();
                for (int i2 = 0; i2 < n; ++i2) {
                    long[] lArray = (long[])this.criticalMethodCalls.get(i2);
                    printStream.print("    ");
                    printStream.print(this.ap);
                    printStream.print(".");
                    printStream.print(this.apMethod);
                    printStream.print(" took: ");
                    printStream.print(lArray[0]);
                    for (int i3 = 1; i3 < lArray.length && lArray[i3] > 0L; ++i3) {
                        if (i3 == 1) {
                            printStream.print(" sleeping: ");
                        } else {
                            printStream.print(", ");
                        }
                        printStream.print(lArray[i3]);
                    }
                    printStream.println("");
                }
            }
        }

        void dumpCriticalCalls(PrintStream printStream) {
            if (this.criticalMethodCalls != null) {
                printStream.print("AP-call: ");
                printStream.print(this.ap);
                printStream.print(".");
                printStream.println(this.apMethod);
                int n = this.criticalMethodCalls.size();
                for (int i2 = 0; i2 < n; ++i2) {
                    long[] lArray = (long[])this.criticalMethodCalls.get(i2);
                    printStream.print("  took: ");
                    printStream.print(lArray[0]);
                    for (int i3 = 1; i3 < lArray.length && lArray[i3] > 0L; ++i3) {
                        if (i3 == 1) {
                            printStream.print(" sleeping: ");
                        }
                        printStream.print(lArray[i3]);
                        printStream.print(", ");
                    }
                    printStream.println("");
                }
            }
        }
    }
}

