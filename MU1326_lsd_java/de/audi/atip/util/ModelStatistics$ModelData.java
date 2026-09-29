/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.util.ModelStatistics$CriticalMethodCall;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class ModelStatistics$ModelData {
    int modelId;
    int valueChanges = 0;
    int stateChanges = 0;
    int events = 0;
    int redraws = 0;
    long eventDispatchTime = 0L;
    int callsFromGUI = 0;
    int totalProcessingTimeGUICalls = 0;
    List criticalMethodCalls;

    ModelStatistics$ModelData(int n) {
        this.modelId = n;
    }

    void dump(PrintStream printStream) {
        printStream.print("ModelId: ");
        printStream.print(this.modelId);
        printStream.print(", ");
        printStream.print(this.valueChanges);
        printStream.print(", ");
        printStream.print(this.stateChanges);
        printStream.print(", ");
        printStream.print(this.events);
        printStream.print(", ");
        printStream.print(this.redraws);
        printStream.print(", ");
        printStream.print(this.eventDispatchTime);
        printStream.print(", ");
        printStream.print(this.callsFromGUI);
        printStream.print(", ");
        printStream.println(this.totalProcessingTimeGUICalls);
        if (this.criticalMethodCalls != null) {
            int n = this.criticalMethodCalls.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ModelStatistics$CriticalMethodCall modelStatistics$CriticalMethodCall = (ModelStatistics$CriticalMethodCall)this.criticalMethodCalls.get(i2);
                printStream.print(modelStatistics$CriticalMethodCall.methodName);
                printStream.print(" took: ");
                printStream.println(modelStatistics$CriticalMethodCall.processingTime);
            }
        }
    }

    void dumpCriticalMethodCalls(PrintStream printStream) {
        if (this.criticalMethodCalls != null) {
            printStream.print("ModelId: ");
            printStream.print(this.modelId);
            printStream.print(" Application: ");
            int n = this.criticalMethodCalls.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ModelStatistics$CriticalMethodCall modelStatistics$CriticalMethodCall = (ModelStatistics$CriticalMethodCall)this.criticalMethodCalls.get(i2);
                printStream.print(modelStatistics$CriticalMethodCall.methodName);
                printStream.print(" took: ");
                printStream.print(modelStatistics$CriticalMethodCall.processingTime);
                for (int i3 = 0; i3 < modelStatistics$CriticalMethodCall.sleepTimes.length && modelStatistics$CriticalMethodCall.sleepTimes[i3] > 0L; ++i3) {
                    if (i3 == 0) {
                        printStream.print(" sleeping: ");
                    } else {
                        printStream.print(", ");
                    }
                    printStream.print(modelStatistics$CriticalMethodCall.sleepTimes[i3]);
                }
                if (modelStatistics$CriticalMethodCall.ex != null) {
                    printStream.print(" Exception: ");
                    printStream.println(modelStatistics$CriticalMethodCall.ex);
                    continue;
                }
                printStream.println("");
            }
        }
    }

    void addCriticalMethodCall(ModelStatistics$CriticalMethodCall modelStatistics$CriticalMethodCall) {
        if (this.criticalMethodCalls == null) {
            this.criticalMethodCalls = new ArrayList(20);
        }
        this.criticalMethodCalls.add(modelStatistics$CriticalMethodCall);
    }
}

