/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark;

import de.dreisoft.lsd.benchmark.BenchmarkSuite;

public class BenchmarkTag {
    public static final int TYPE_UNDEFINED;
    public static final int TYPE_START;
    public static final int TYPE_END;
    public static final int TYPE_COUNT;
    private final int type;
    private final int category;
    private final int samples;
    private final long timestamp = System.currentTimeMillis();
    private final Thread thread = Thread.currentThread();
    private final String info;

    public BenchmarkTag(int n, int n2) {
        this(n, n2, null);
    }

    public BenchmarkTag(int n, int n2, String string) {
        this.type = n;
        this.samples = this.type == 1 || this.type == 2 ? 1 : 0;
        this.category = n2;
        this.info = string;
    }

    public BenchmarkTag(int n, int n2, int n3) {
        this(n, n2, n3, null);
    }

    public BenchmarkTag(int n, int n2, int n3, String string) {
        this.type = n;
        this.samples = this.type == 1 || this.type == 2 || this.type == 3 ? n3 : 0;
        this.category = n2;
        this.info = string;
    }

    public int getType() {
        return this.type;
    }

    public int getCategory() {
        return this.category;
    }

    public int getSamples() {
        return this.samples;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public Thread getThread() {
        return this.thread;
    }

    public String getInfo() {
        return this.info;
    }

    public boolean correspondsTo(BenchmarkTag benchmarkTag) {
        if (this.category != benchmarkTag.category) {
            return false;
        }
        if (this.thread != benchmarkTag.thread) {
            return false;
        }
        if (this.samples != benchmarkTag.samples) {
            return false;
        }
        switch (this.type) {
            case 1: {
                if (benchmarkTag.type == 2) {
                    return this.timestamp <= benchmarkTag.timestamp;
                }
                return false;
            }
            case 2: {
                if (benchmarkTag.type == 1) {
                    return this.timestamp >= benchmarkTag.timestamp;
                }
                return false;
            }
        }
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("<");
        switch (this.type) {
            case 1: {
                stringBuffer.append("STA");
                break;
            }
            case 2: {
                stringBuffer.append("END");
                break;
            }
            case 3: {
                stringBuffer.append("CNT");
                break;
            }
            default: {
                stringBuffer.append("---");
            }
        }
        stringBuffer.append("> ");
        String string = BenchmarkSuite.getCategoryName(this.category);
        stringBuffer.append("[CAT-").append(this.category).append(" ").append(string).append("] ");
        stringBuffer.append("time: ").append(this.timestamp);
        if (this.info != null) {
            stringBuffer.append(" | ").append(this.info);
        }
        if (this.type == 3) {
            stringBuffer.append(' ').append(this.samples).append('x');
        }
        return stringBuffer.toString();
    }
}

