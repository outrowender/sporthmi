/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark;

import de.dreisoft.lsd.benchmark.BenchmarkResult;
import de.dreisoft.lsd.benchmark.BenchmarkTag;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BenchmarkSuite {
    public static final int CAT_UNDEFINED;
    public static final int CAT_LSD_STARTUP;
    public static final int CAT_SERVICE_REGISTRATION;
    public static final int CAT_SERVICE_UNREGISTRATION;
    public static final int CAT_FILTER_CREATION;
    public static final int CAT_FILTER_EVALUATION;
    public static final int CAT_TRACKER_CREATION;
    public static final int CAT_TRACKER_OPENING;
    public static final int CAT_TRACKER_SVC_ADDED;
    public static final int CAT_SERVICE_COUNT;
    public static final int CAT_TRACKER_COUNT;
    public static final String[] CAT_NAME;
    protected final String name;
    private List tagList = new ArrayList(1024);
    private BenchmarkResult result;

    public BenchmarkSuite(String string) {
        this.name = string;
    }

    public static String getCategoryName(int n) {
        if (n < CAT_NAME.length) {
            return CAT_NAME[n];
        }
        return "-";
    }

    public void runTests() {
    }

    public synchronized void setStartTag(int n) {
        this.tagList.add(new BenchmarkTag(1, n));
    }

    public synchronized void setStartTag(int n, int n2) {
        this.tagList.add(new BenchmarkTag(1, n, n2));
    }

    public synchronized void setStartTag(int n, String string) {
        this.tagList.add(new BenchmarkTag(1, n, string));
    }

    public synchronized void setStartTag(int n, int n2, String string) {
        this.tagList.add(new BenchmarkTag(1, n, n2, string));
    }

    public synchronized void setEndTag(int n) {
        this.tagList.add(new BenchmarkTag(2, n));
    }

    public synchronized void setEndTag(int n, int n2) {
        this.tagList.add(new BenchmarkTag(2, n, n2));
    }

    public synchronized void setEndTag(int n, String string) {
        this.tagList.add(new BenchmarkTag(2, n, string));
    }

    public synchronized void setEndTag(int n, int n2, String string) {
        this.tagList.add(new BenchmarkTag(2, n, n2, string));
    }

    public synchronized void setCountTag(int n, String string) {
        this.tagList.add(new BenchmarkTag(3, n, string));
    }

    public synchronized void setCountTag(int n, int n2, String string) {
        this.tagList.add(new BenchmarkTag(3, n, n2, string));
    }

    public synchronized void setTag(int n) {
        this.tagList.add(new BenchmarkTag(0, n));
    }

    public synchronized void setTag(int n, String string) {
        this.tagList.add(new BenchmarkTag(0, n, string));
    }

    public synchronized void analyze() {
        this.result = new BenchmarkResult();
        block8: for (int i2 = 0; i2 < this.tagList.size(); ++i2) {
            BenchmarkTag benchmarkTag = (BenchmarkTag)this.tagList.get(i2);
            switch (benchmarkTag.getType()) {
                case 1: {
                    for (int i3 = i2 + 1; i3 < this.tagList.size(); ++i3) {
                        BenchmarkTag benchmarkTag2 = (BenchmarkTag)this.tagList.get(i3);
                        if (!benchmarkTag.correspondsTo(benchmarkTag2)) continue;
                        long l = benchmarkTag2.getTimestamp() - benchmarkTag.getTimestamp();
                        this.result.addDuration(benchmarkTag.getCategory(), benchmarkTag.getSamples(), l);
                        continue block8;
                    }
                    continue block8;
                }
                case 3: {
                    switch (benchmarkTag.getCategory()) {
                        case 9: {
                            this.result.addServices(benchmarkTag.getInfo(), benchmarkTag.getSamples());
                            continue block8;
                        }
                        case 10: {
                            this.result.addTrackers(benchmarkTag.getInfo(), benchmarkTag.getSamples());
                            continue block8;
                        }
                    }
                    continue block8;
                }
            }
        }
    }

    public synchronized void printResults() {
        this.printResults(System.out);
    }

    public synchronized void printResults(PrintStream printStream) {
        printStream.println();
        printStream.println();
        printStream.println(new StringBuffer().append("+++ ").append(this.name).append(" Benchmark Results +++").toString());
        printStream.println();
        printStream.println("+++ Benchmark Tags +++");
        for (int i2 = 0; i2 < this.tagList.size(); ++i2) {
            BenchmarkTag benchmarkTag = (BenchmarkTag)this.tagList.get(i2);
            printStream.println(benchmarkTag.toString());
        }
        printStream.println();
        if (this.result != null) {
            printStream.println("+++ Benchmark Summary +++");
            this.result.printSummary(printStream);
            printStream.println();
            printStream.println();
        }
    }

    static {
        CAT_NAME = new String[]{"undefined", "LSD startup", "service registration", "service unregistration", "filter creation", "filter evaluation", "tracker creation", "tracker opening", "service added", "service count", "tracker count"};
    }
}

