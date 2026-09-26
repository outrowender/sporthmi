/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.util.ModelStatistics;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class ActionProxyStatistics$ActionProxyCallData {
    private final String ap;
    private final String apMethod;
    private int calls;
    private long totalProcessingTime;
    private List criticalMethodCalls;

    public ActionProxyStatistics$ActionProxyCallData(String string, String string2) {
        this.ap = string;
        this.apMethod = string2;
    }

    void addCall(long l) {
        ++this.calls;
        this.totalProcessingTime += l;
        if (l > 0) {
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

