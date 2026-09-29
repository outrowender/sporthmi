/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark;

import de.dreisoft.lsd.benchmark.BenchmarkResult$CategoryDurations;
import de.dreisoft.lsd.benchmark.BenchmarkResult$ServiceCounter;
import de.dreisoft.lsd.benchmark.Text;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class BenchmarkResult {
    private static int baseResolution = 100;
    private Map svcCounterMap = new TreeMap();
    private Map trackerCounterMap = new TreeMap();
    private Map durationsMap = new TreeMap();

    public static void setBaseResolution(int n) {
        baseResolution = n;
    }

    public void addService(String string) {
        this.addServices(string, 1);
    }

    public void addServices(String string, int n) {
        BenchmarkResult$ServiceCounter benchmarkResult$ServiceCounter = this.getServiceCounter(string);
        benchmarkResult$ServiceCounter.add(n);
    }

    public void addTracker(String string) {
        this.addTrackers(string, 1);
    }

    public void addTrackers(String string, int n) {
        BenchmarkResult$ServiceCounter benchmarkResult$ServiceCounter = this.getTrackerCounter(string);
        benchmarkResult$ServiceCounter.add(n);
    }

    public void addDuration(int n, int n2, long l) {
        BenchmarkResult$CategoryDurations benchmarkResult$CategoryDurations = this.getCatDurations(n);
        benchmarkResult$CategoryDurations.addDuration(n2, l);
    }

    public synchronized void printSummary() {
        this.printSummary(System.out);
    }

    public synchronized void printSummary(PrintStream printStream) {
        StringBuffer stringBuffer;
        int n;
        Comparable comparable;
        int n2 = 0;
        Iterator iterator = this.svcCounterMap.values().iterator();
        while (iterator.hasNext()) {
            comparable = (BenchmarkResult$ServiceCounter)iterator.next();
            n = ((BenchmarkResult$ServiceCounter)comparable).getValue();
            if (n == 0) continue;
            printStream.println(((BenchmarkResult$ServiceCounter)comparable).toString());
            n2 += n;
        }
        if (n2 != 0) {
            printStream.println("------------");
            stringBuffer = Text.appendFixedNumber(new StringBuffer(), n2, 3);
            stringBuffer.append(" services");
            printStream.println(stringBuffer);
            printStream.println("---------------");
        }
        n2 = 0;
        iterator = this.trackerCounterMap.values().iterator();
        while (iterator.hasNext()) {
            comparable = (BenchmarkResult$ServiceCounter)iterator.next();
            n = ((BenchmarkResult$ServiceCounter)comparable).getValue();
            if (n == 0) continue;
            printStream.println(((BenchmarkResult$ServiceCounter)comparable).toString());
            n2 += n;
        }
        if (n2 != 0) {
            printStream.println("------------");
            stringBuffer = Text.appendFixedNumber(new StringBuffer(), n2, 3);
            stringBuffer.append(" services tracked");
            printStream.println(stringBuffer);
            printStream.println("---------------");
        }
        iterator = this.durationsMap.values().iterator();
        while (iterator.hasNext()) {
            comparable = (BenchmarkResult$CategoryDurations)iterator.next();
            printStream.println(((BenchmarkResult$CategoryDurations)comparable).toString());
        }
    }

    private BenchmarkResult$ServiceCounter getServiceCounter(String string) {
        BenchmarkResult$ServiceCounter benchmarkResult$ServiceCounter = (BenchmarkResult$ServiceCounter)this.svcCounterMap.get(string);
        if (benchmarkResult$ServiceCounter == null) {
            benchmarkResult$ServiceCounter = new BenchmarkResult$ServiceCounter("service", string);
            this.svcCounterMap.put(string, benchmarkResult$ServiceCounter);
        }
        return benchmarkResult$ServiceCounter;
    }

    private BenchmarkResult$ServiceCounter getTrackerCounter(String string) {
        BenchmarkResult$ServiceCounter benchmarkResult$ServiceCounter = (BenchmarkResult$ServiceCounter)this.trackerCounterMap.get(string);
        if (benchmarkResult$ServiceCounter == null) {
            benchmarkResult$ServiceCounter = new BenchmarkResult$ServiceCounter("tracking service", string);
            this.trackerCounterMap.put(string, benchmarkResult$ServiceCounter);
        }
        return benchmarkResult$ServiceCounter;
    }

    private BenchmarkResult$CategoryDurations getCatDurations(int n) {
        Integer n2 = new Integer(n);
        BenchmarkResult$CategoryDurations benchmarkResult$CategoryDurations = (BenchmarkResult$CategoryDurations)this.durationsMap.get(n2);
        if (benchmarkResult$CategoryDurations == null) {
            benchmarkResult$CategoryDurations = new BenchmarkResult$CategoryDurations(n);
            this.durationsMap.put(n2, benchmarkResult$CategoryDurations);
        }
        return benchmarkResult$CategoryDurations;
    }

    static /* synthetic */ int access$000() {
        return baseResolution;
    }
}

