/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.tghu.smi.ErrorLog;

public class ErrorLog$HistoryRingBuffer {
    private int[] buffer;
    private long[] timestamps;
    private int size = 0;
    private int startIdx = 0;
    private int endIdx = 0;
    private final /* synthetic */ ErrorLog this$0;

    public ErrorLog$HistoryRingBuffer(ErrorLog errorLog, int n) {
        this.this$0 = errorLog;
        this.buffer = new int[n];
        this.timestamps = new long[n];
    }

    public int getCapacity() {
        return this.buffer.length;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void put(int n) {
        this.buffer[this.endIdx] = n;
        this.timestamps[this.endIdx] = ErrorLog.access$000(this.this$0).getMonotonicTime();
        if (this.size == this.getCapacity()) {
            ++this.startIdx;
            ++this.endIdx;
        } else {
            ++this.endIdx;
            ++this.size;
        }
        this.startIdx %= this.getCapacity();
        this.endIdx %= this.getCapacity();
    }

    public int get(int n) {
        if (n < this.size) {
            int n2 = (this.startIdx + n) % this.getCapacity();
            return this.buffer[n2];
        }
        throw new IndexOutOfBoundsException(new StringBuffer().append("Index out of bounds (size=").append(this.size).append(", index=").append(n).append(")").toString());
    }

    public long getTimestamp(int n) {
        if (n < this.size) {
            int n2 = (this.startIdx + n) % this.getCapacity();
            return this.timestamps[n2];
        }
        throw new IndexOutOfBoundsException(new StringBuffer().append("Index out of bounds (size=").append(this.size).append(", index=").append(n).append(")").toString());
    }
}

