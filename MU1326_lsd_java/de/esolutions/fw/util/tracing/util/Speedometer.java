/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.util;

import de.esolutions.fw.util.commons.Buffer;

public class Speedometer {
    private final Sample[] samples;
    private final int capacity;
    private int size;
    private int pos;
    private int totalSamples;
    private long totalDelta;
    private long totalData;
    private long lastSampleTime;

    public Speedometer(int n) {
        this.capacity = n;
        this.samples = new Sample[n];
        for (int i2 = 0; i2 < n; ++i2) {
            this.samples[i2] = new Sample();
        }
        this.reset();
    }

    public void reset() {
        this.size = 0;
        this.pos = 0;
        this.lastSampleTime = -1L;
        this.totalDelta = 0L;
        this.totalSamples = 0;
        this.totalData = 0L;
    }

    public void addSample(long l, long l2) {
        if (this.lastSampleTime == -1L) {
            this.lastSampleTime = l;
            return;
        }
        long l3 = l - this.lastSampleTime;
        this.lastSampleTime = l;
        if (l3 == 0L) {
            if (this.size == this.capacity) {
                if (this.samples[this.pos].getDelta() != 0L) {
                    ++this.pos;
                    if (this.pos == this.capacity) {
                        this.pos = 0;
                    }
                    this.totalDelta -= this.samples[this.pos].getDelta();
                    this.totalSamples -= this.samples[this.pos].getCounter();
                    this.totalData -= this.samples[this.pos].getDataSum();
                    this.samples[this.pos].set(0L, l2);
                } else {
                    this.samples[this.pos].add(l2);
                }
            } else {
                this.samples[this.size].set(0L, l2);
                ++this.size;
            }
        } else if (this.size < this.capacity) {
            this.samples[this.size].set(l3, l2);
            ++this.size;
        } else {
            this.totalDelta -= this.samples[this.pos].getDelta();
            this.totalSamples -= this.samples[this.pos].getCounter();
            this.totalData -= this.samples[this.pos].getDataSum();
            this.samples[this.pos].set(l3, l2);
            ++this.pos;
            if (this.pos == this.capacity) {
                this.pos = 0;
            }
        }
        this.totalDelta += l3;
        ++this.totalSamples;
        this.totalData += l2;
    }

    public int getDelta() {
        if (this.totalSamples == 0) {
            return 0;
        }
        return (int)(this.totalDelta / (long)this.totalSamples);
    }

    public int getFrequency(int n) {
        if (this.totalDelta == 0L) {
            return 0;
        }
        return (int)((long)(this.totalSamples * n) / this.totalDelta);
    }

    public int getDataRate(int n) {
        if (this.totalDelta == 0L) {
            return 0;
        }
        return (int)(this.totalData * (long)n / this.totalDelta);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[");
        for (int i2 = 0; i2 < this.size; ++i2) {
            buffer.append(this.samples[i2]);
            if (i2 == this.pos) {
                buffer.append("*");
            }
            buffer.append(" ");
        }
        buffer.append("] -> sd=");
        buffer.append(this.totalDelta);
        buffer.append(",sv=");
        buffer.append(this.totalData);
        buffer.append("/sc=");
        buffer.append(this.totalSamples);
        return buffer.toString();
    }

    private static class Sample {
        private long delta;
        private int count;
        private long data;

        private Sample() {
        }

        public void set(long l, long l2) {
            this.delta = l;
            this.data = l2;
            this.count = 1;
        }

        public void add(long l) {
            this.data += l;
            ++this.count;
        }

        public long getDelta() {
            return this.delta;
        }

        public int getCounter() {
            return this.count;
        }

        public long getDataSum() {
            return this.data;
        }

        public String toString() {
            return new StringBuffer().append("d=").append(this.delta).append(",c=").append(this.count).append(",v=").append(this.data).toString();
        }
    }
}

