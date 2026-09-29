/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark;

import de.dreisoft.lsd.benchmark.Text;

class BenchmarkResult$ServiceCounter
implements Comparable {
    public static final String TYPE_SERVICE;
    public static final String TYPE_TRACKER;
    private final String type;
    private final String ifc;
    private int counter = 0;

    public BenchmarkResult$ServiceCounter(String string, String string2) {
        this.type = string;
        this.ifc = string2;
    }

    public int getValue() {
        return this.counter;
    }

    public void add(int n) {
        this.counter += n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(32);
        Text.appendFixedNumber(stringBuffer, this.counter, 3).append("x  ");
        stringBuffer.append(this.type).append("  ").append(this.ifc);
        return stringBuffer.toString();
    }

    @Override
    public int compareTo(Object object) {
        BenchmarkResult$ServiceCounter benchmarkResult$ServiceCounter = (BenchmarkResult$ServiceCounter)object;
        return this.ifc.compareTo(benchmarkResult$ServiceCounter.ifc);
    }
}

