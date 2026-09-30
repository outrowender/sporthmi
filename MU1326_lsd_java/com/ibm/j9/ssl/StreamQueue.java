/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamQueue {
    private byte[] buffer = new byte[1024];
    private int posRead = 0;
    private int posWrite = 0;
    private InputStream queueRead = new InputStream(){

        public int available() throws IOException {
            return StreamQueue.this.getSize();
        }

        public int read() throws IOException {
            byte[] byArray = new byte[1];
            this.read(byArray, 0, 1);
            return byArray[0] & 0xFF;
        }

        public int read(byte[] byArray, int n, int n2) throws IOException {
            if (n2 > this.available()) {
                n2 = this.available();
            }
            int n3 = n2 > StreamQueue.this.buffer.length - StreamQueue.this.posRead ? StreamQueue.this.buffer.length - StreamQueue.this.posRead : n2;
            System.arraycopy((Object)StreamQueue.this.buffer, StreamQueue.this.posRead, (Object)byArray, n, n3);
            if (n3 < n2) {
                System.arraycopy((Object)StreamQueue.this.buffer, 0, (Object)byArray, n + n3, n2 - n3);
                StreamQueue.this.posRead = n2 - n3;
            } else {
                StreamQueue streamQueue = StreamQueue.this;
                streamQueue.posRead = streamQueue.posRead + n2;
            }
            return n2;
        }

        public int read(byte[] byArray) throws IOException {
            return this.read(byArray, 0, byArray.length);
        }
    };
    private OutputStream queueWrite = new OutputStream(){

        public void write(byte[] byArray, int n, int n2) throws IOException {
            if (StreamQueue.this.getUnusedCapacity() < n2) {
                StreamQueue.this.grow(n2 - StreamQueue.this.getUnusedCapacity());
            }
            int n3 = n2 > StreamQueue.this.buffer.length - StreamQueue.this.posWrite ? StreamQueue.this.buffer.length - StreamQueue.this.posWrite : n2;
            System.arraycopy((Object)byArray, n, (Object)StreamQueue.this.buffer, StreamQueue.this.posWrite, n3);
            if (n3 < n2) {
                System.arraycopy((Object)byArray, n + n3, (Object)StreamQueue.this.buffer, 0, n2 - n3);
                StreamQueue.this.posWrite = n2 - n3;
            } else {
                StreamQueue streamQueue = StreamQueue.this;
                streamQueue.posWrite = streamQueue.posWrite + n2;
            }
        }

        public void write(byte[] byArray) throws IOException {
            this.write(byArray, 0, byArray.length);
        }

        public void write(int n) throws IOException {
            byte[] byArray = new byte[]{(byte)n};
            this.write(byArray, 0, 1);
        }
    };

    public InputStream getReadStream() {
        return this.queueRead;
    }

    public OutputStream getWriteStream() {
        return this.queueWrite;
    }

    public int getCapacity() {
        return this.buffer.length - 1;
    }

    public int getSize() {
        if (this.posRead == this.posWrite) {
            return 0;
        }
        if (this.posRead < this.posWrite) {
            return this.posWrite - this.posRead;
        }
        return this.buffer.length - this.posRead + this.posWrite;
    }

    public int getUnusedCapacity() {
        return this.getCapacity() - this.getSize();
    }

    private int grow(int n) throws IOException {
        n = n < this.buffer.length / 8 ? this.buffer.length / 8 : n;
        byte[] byArray = new byte[this.buffer.length + n];
        int n2 = this.getSize();
        this.queueRead.read(byArray, 0, n2);
        this.posRead = 0;
        this.posWrite = n2;
        this.buffer = byArray;
        return n;
    }
}

