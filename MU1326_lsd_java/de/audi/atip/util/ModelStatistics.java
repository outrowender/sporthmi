/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.util.ModelStatistics$CriticalMethodCall;
import de.audi.atip.util.ModelStatistics$ModelData;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class ModelStatistics {
    public static final boolean DEBUG_PROCESSING_TIME;
    public static final String TEXT_KEY_PRESSED;
    public static final String TEXT_KEY_TYPED;
    public static final String TEXT_KEY_RELEASED;
    public static final String TEXT_ITEM_SELECTED;
    public static final String TEXT_ITEM_FOCUSED;
    public static final String TEXT_ITEM_RELEASED;
    public static final String TEXT_JOY_E;
    public static final String TEXT_JOY_IDLE;
    public static final String TEXT_JOY_N;
    public static final String TEXT_JOY_NE;
    public static final String TEXT_JOY_NW;
    public static final String TEXT_JOY_S;
    public static final String TEXT_JOY_SE;
    public static final String TEXT_JOY_SW;
    public static final String TEXT_JOY_W;
    public static final String TEXT_INCREMENT;
    public static final String TEXT_DECREMENT;
    public static final String TEXT_SET_VALUE_HIT;
    public static final String TEXT_TOUCH_SCREEN_PRESSED;
    public static final String TEXT_TOUCH_SCREEN_RELEASED;
    public static final String TEXT_TOUCH_SCREEN_POSITION_MOVED;
    public static final String TEXT_TOUCH_SCREEN_LONG_PRESSED;
    public static final String TEXT_TEXT_CHANGED;
    public static final String TEXT_COMMAND_PRESSED;
    public static final String TEXT_REQUEST_TOOLTIP_DATA;
    public static final String TEXT_TOOLTIP_VISIBLE;
    public static final String TEXT_TOOLTIP_HIDDEN;
    public static final String TEXT_METRICS_UPDATED;
    private static final long PROCESSING_THRESHOLD;
    private static long[] sleepPeriods;
    private static int nextSleepIndex;
    private static int criticalCallCount;
    private SortedMap data = new TreeMap();
    private long started = System.currentTimeMillis();
    private Exception modelException;

    private ModelStatistics$ModelData getModelData(int n) {
        Integer n2 = new Integer(n);
        ModelStatistics$ModelData modelStatistics$ModelData = (ModelStatistics$ModelData)this.data.get(n2);
        if (modelStatistics$ModelData == null) {
            modelStatistics$ModelData = new ModelStatistics$ModelData(n);
            this.data.put(n2, modelStatistics$ModelData);
        }
        return modelStatistics$ModelData;
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
            ((ModelStatistics$ModelData)this.data.get(iterator.next())).dump(printStream);
        }
    }

    public synchronized void dumpCriticalMethodCalls(PrintStream printStream) {
        printStream.print("Statistik measured for: ");
        printStream.println(System.currentTimeMillis() - this.started);
        Iterator iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            ((ModelStatistics$ModelData)this.data.get(iterator.next())).dumpCriticalMethodCalls(printStream);
        }
    }

    public synchronized void addModelCall(int n, String string, long l) {
        ++this.getModelData((int)n).callsFromGUI;
        this.getModelData((int)n).totalProcessingTimeGUICalls = (int)((long)this.getModelData((int)n).totalProcessingTimeGUICalls + l);
        if ((l > 0 || this.modelException != null) && criticalCallCount < 500) {
            ++criticalCallCount;
            ModelStatistics$CriticalMethodCall modelStatistics$CriticalMethodCall = new ModelStatistics$CriticalMethodCall(string, l, sleepPeriods, this.modelException);
            this.getModelData(n).addCriticalMethodCall(modelStatistics$CriticalMethodCall);
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

    static {
        sleepPeriods = new long[20];
        nextSleepIndex = 0;
        criticalCallCount = 0;
    }
}

