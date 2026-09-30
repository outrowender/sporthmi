/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ModelStatistics {
    public static final boolean DEBUG_PROCESSING_TIME = false;
    public static final String TEXT_KEY_PRESSED = "keyPressed";
    public static final String TEXT_KEY_TYPED = "keyTyped";
    public static final String TEXT_KEY_RELEASED = "keyReleased";
    public static final String TEXT_ITEM_SELECTED = "itemSelected";
    public static final String TEXT_ITEM_FOCUSED = "itemFocused";
    public static final String TEXT_ITEM_RELEASED = "itemReleased";
    public static final String TEXT_JOY_E = "joyE";
    public static final String TEXT_JOY_IDLE = "joyIdle";
    public static final String TEXT_JOY_N = "joyN";
    public static final String TEXT_JOY_NE = "joyNE";
    public static final String TEXT_JOY_NW = "joyNW";
    public static final String TEXT_JOY_S = "joyS";
    public static final String TEXT_JOY_SE = "joySE";
    public static final String TEXT_JOY_SW = "joySW";
    public static final String TEXT_JOY_W = "joyW";
    public static final String TEXT_INCREMENT = "increment";
    public static final String TEXT_DECREMENT = "decrement";
    public static final String TEXT_SET_VALUE_HIT = "setValueHit";
    public static final String TEXT_TOUCH_SCREEN_PRESSED = "touchScreenPressed";
    public static final String TEXT_TOUCH_SCREEN_RELEASED = "touchScreenReleased";
    public static final String TEXT_TOUCH_SCREEN_POSITION_MOVED = "touchScreenPositionMoved";
    public static final String TEXT_TOUCH_SCREEN_LONG_PRESSED = "touchScreenLongPressed";
    public static final String TEXT_TEXT_CHANGED = "textChanged";
    public static final String TEXT_COMMAND_PRESSED = "commandPressed";
    public static final String TEXT_REQUEST_TOOLTIP_DATA = "requestTooltipData";
    public static final String TEXT_TOOLTIP_VISIBLE = "tooltipVisible";
    public static final String TEXT_TOOLTIP_HIDDEN = "tooltipHidden";
    public static final String TEXT_METRICS_UPDATED = "metricsUpdated";
    private static final long PROCESSING_THRESHOLD = 50L;
    private static long[] sleepPeriods = new long[20];
    private static int nextSleepIndex = 0;
    private static int criticalCallCount = 0;
    private SortedMap data = new TreeMap();
    private long started = System.currentTimeMillis();
    private Exception modelException;

    private ModelData getModelData(int n) {
        Integer n2 = new Integer(n);
        ModelData modelData = (ModelData)this.data.get(n2);
        if (modelData == null) {
            modelData = new ModelData(n);
            this.data.put(n2, modelData);
        }
        return modelData;
    }

    public synchronized void countValueChanged(int n) {
        ++this.getModelData((int)n).valueChanges;
    }

    public synchronized void countStateChanged(int n) {
        ++this.getModelData((int)n).stateChanges;
    }

    public synchronized void countUpdateEvent(int n, long l) {
        ++this.getModelData((int)n).events;
        this.getModelData((int)n).eventDispatchTime += l;
    }

    public synchronized void countRedraw(int n) {
        ++this.getModelData((int)n).redraws;
    }

    public synchronized void reset() {
        this.data = new TreeMap();
        this.started = System.currentTimeMillis();
    }

    public synchronized void dump(PrintStream printStream) {
        printStream.print("Statistik measured for: ");
        printStream.println(System.currentTimeMillis() - this.started);
        printStream.println("ModelId, valueChanged, stateChanged, events, redraws, dispatch time, calls from GUI, process time calls from GUI");
        Iterator iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            ((ModelData)this.data.get(iterator.next())).dump(printStream);
        }
    }

    public synchronized void dumpCriticalMethodCalls(PrintStream printStream) {
        printStream.print("Statistik measured for: ");
        printStream.println(System.currentTimeMillis() - this.started);
        Iterator iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            ((ModelData)this.data.get(iterator.next())).dumpCriticalMethodCalls(printStream);
        }
    }

    public synchronized void addModelCall(int n, String string, long l) {
        ++this.getModelData((int)n).callsFromGUI;
        this.getModelData((int)n).totalProcessingTimeGUICalls = (int)((long)this.getModelData((int)n).totalProcessingTimeGUICalls + l);
        if ((l > 50L || this.modelException != null) && criticalCallCount < 500) {
            ++criticalCallCount;
            CriticalMethodCall criticalMethodCall = new CriticalMethodCall(string, l, sleepPeriods, this.modelException);
            this.getModelData(n).addCriticalMethodCall(criticalMethodCall);
        }
        this.modelException = null;
        ModelStatistics.resetSleepTime();
    }

    public synchronized void addModelException(int n, Exception exception) {
        this.modelException = exception;
    }

    public void addSleepTime(long l) {
        if (nextSleepIndex < sleepPeriods.length) {
            ModelStatistics.sleepPeriods[ModelStatistics.nextSleepIndex] = l;
            ++nextSleepIndex;
        }
    }

    public static void resetSleepTime() {
        for (int i2 = 0; i2 < sleepPeriods.length; ++i2) {
            ModelStatistics.sleepPeriods[i2] = 0L;
        }
        nextSleepIndex = 0;
    }

    public static long[] getSleepPeriods() {
        return sleepPeriods;
    }

    private static class ModelData {
        int modelId;
        int valueChanges = 0;
        int stateChanges = 0;
        int events = 0;
        int redraws = 0;
        long eventDispatchTime = 0L;
        int callsFromGUI = 0;
        int totalProcessingTimeGUICalls = 0;
        List criticalMethodCalls;

        ModelData(int n) {
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
                    CriticalMethodCall criticalMethodCall = (CriticalMethodCall)this.criticalMethodCalls.get(i2);
                    printStream.print(criticalMethodCall.methodName);
                    printStream.print(" took: ");
                    printStream.println(criticalMethodCall.processingTime);
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
                    CriticalMethodCall criticalMethodCall = (CriticalMethodCall)this.criticalMethodCalls.get(i2);
                    printStream.print(criticalMethodCall.methodName);
                    printStream.print(" took: ");
                    printStream.print(criticalMethodCall.processingTime);
                    for (int i3 = 0; i3 < criticalMethodCall.sleepTimes.length && criticalMethodCall.sleepTimes[i3] > 0L; ++i3) {
                        if (i3 == 0) {
                            printStream.print(" sleeping: ");
                        } else {
                            printStream.print(", ");
                        }
                        printStream.print(criticalMethodCall.sleepTimes[i3]);
                    }
                    if (criticalMethodCall.ex != null) {
                        printStream.print(" Exception: ");
                        printStream.println(criticalMethodCall.ex);
                        continue;
                    }
                    printStream.println("");
                }
            }
        }

        void addCriticalMethodCall(CriticalMethodCall criticalMethodCall) {
            if (this.criticalMethodCalls == null) {
                this.criticalMethodCalls = new ArrayList(20);
            }
            this.criticalMethodCalls.add(criticalMethodCall);
        }
    }

    private static class CriticalMethodCall {
        String methodName;
        long processingTime;
        long[] sleepTimes;
        Exception ex;

        public CriticalMethodCall(String string, long l, long[] lArray, Exception exception) {
            this.methodName = string;
            this.processingTime = l;
            this.sleepTimes = new long[lArray.length];
            System.arraycopy((Object)lArray, 0, (Object)this.sleepTimes, 0, lArray.length);
            this.ex = exception;
        }
    }
}

