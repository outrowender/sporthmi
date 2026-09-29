/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark;

import de.dreisoft.lsd.benchmark.BenchmarkResult;
import de.dreisoft.lsd.benchmark.BenchmarkSuite;
import de.dreisoft.lsd.benchmark.Text;

class BenchmarkResult$CategoryDurations
implements Comparable {
    private static final int ACCURACY;
    private final int category;
    private int samples = 0;
    private long minDuration = 0;
    private long maxDuration = Integer.MIN_VALUE;
    private long sumDuration = 0L;

    public BenchmarkResult$CategoryDurations(int n) {
        this.category = n;
    }

    public void addDuration(int n, long l) {
        long l2 = (l <<= 4) / (long)n;
        if (l2 < this.minDuration) {
            this.minDuration = l2;
        }
        if (l2 > this.maxDuration) {
            this.maxDuration = l2;
        }
        this.sumDuration += l;
        this.samples += n;
    }

    public long getAvgDuration() {
        return this.getAvgDuration(1);
    }

    public long getAvgDuration(int n) {
        return this.sumDuration * (long)n / (long)this.samples >> 4;
    }

    public long getMaxDuration() {
        return this.maxDuration >> 4;
    }

    public long getMinDuration() {
        return this.minDuration >> 4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        String string = BenchmarkSuite.getCategoryName(this.category);
        stringBuffer.append("[CAT-").append(this.category).append(" ").append(string).append("] ");
        Text.fillWithSpace(stringBuffer, 36);
        Text.appendFixedNumber(stringBuffer, this.samples, 5).append(" samples ");
        stringBuffer.append("| ");
        stringBuffer.append("min: ");
        Text.appendFixedNumber(stringBuffer, this.getMinDuration(), 6).append("ms ");
        stringBuffer.append("| ");
        stringBuffer.append("avg: ");
        Text.appendFixedNumber(stringBuffer, this.getAvgDuration(), 6).append("ms/s ");
        Text.appendFixedNumber(stringBuffer, this.getAvgDuration(BenchmarkResult.access$000()), 6).append(new StringBuffer().append("ms/").append(BenchmarkResult.access$000()).append("s ").toString());
        Text.appendFixedNumber(stringBuffer, this.getAvgDuration(BenchmarkResult.access$000() * 10), 6).append(new StringBuffer().append("ms/").append(BenchmarkResult.access$000() * 10).append("s ").toString());
        stringBuffer.append("| ");
        stringBuffer.append("max: ");
        Text.appendFixedNumber(stringBuffer, this.getMaxDuration(), 6).append("ms ");
        return stringBuffer.toString();
    }

    @Override
    public int compareTo(Object object) {
        BenchmarkResult$CategoryDurations benchmarkResult$CategoryDurations = (BenchmarkResult$CategoryDurations)object;
        if (this.category < benchmarkResult$CategoryDurations.category) {
            return -1;
        }
        if (this.category > benchmarkResult$CategoryDurations.category) {
            return 1;
        }
        return 0;
    }
}

