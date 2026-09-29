/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.util.ActionProxyStatistics$ActionProxyCallData;
import de.audi.atip.util.ModelStatistics;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class ActionProxyStatistics {
    public static final boolean DEBUG_PROCESSING_TIME;
    private static final long PROCESSING_THRESHOLD;
    private static ActionProxyStatistics instance;
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
            ((ActionProxyStatistics$ActionProxyCallData)this.data.get(iterator.next())).dump(printStream);
        }
    }

    public synchronized void dumpCriticalMethodCalls(PrintStream printStream) {
        printStream.print("Statistic measured for: ");
        printStream.println(System.currentTimeMillis() - this.started);
        Iterator iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            ((ActionProxyStatistics$ActionProxyCallData)this.data.get(iterator.next())).dumpCriticalCalls(printStream);
        }
    }

    public synchronized void addActionProxyCall(String string, String string2, long l) {
        ActionProxyStatistics$ActionProxyCallData actionProxyStatistics$ActionProxyCallData = this.getAPCallData(string, string2);
        actionProxyStatistics$ActionProxyCallData.addCall(l);
        ModelStatistics.resetSleepTime();
    }

    private ActionProxyStatistics$ActionProxyCallData getAPCallData(String string, String string2) {
        String string3 = new StringBuffer().append(string).append('.').append(string2).toString();
        ActionProxyStatistics$ActionProxyCallData actionProxyStatistics$ActionProxyCallData = (ActionProxyStatistics$ActionProxyCallData)this.data.get(string3);
        if (actionProxyStatistics$ActionProxyCallData == null) {
            actionProxyStatistics$ActionProxyCallData = new ActionProxyStatistics$ActionProxyCallData(string, string2);
            this.data.put(string3, actionProxyStatistics$ActionProxyCallData);
        }
        return actionProxyStatistics$ActionProxyCallData;
    }

    static {
        instance = new ActionProxyStatistics();
    }
}

