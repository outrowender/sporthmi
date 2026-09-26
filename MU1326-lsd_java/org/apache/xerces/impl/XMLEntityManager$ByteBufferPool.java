/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

final class XMLEntityManager$ByteBufferPool {
    private static final int DEFAULT_POOL_SIZE;
    private int fPoolSize;
    private int fBufferSize;
    private byte[][] fByteBufferPool;
    private int fDepth;

    public XMLEntityManager$ByteBufferPool(int n) {
        this(3, n);
    }

    public XMLEntityManager$ByteBufferPool(int n, int n2) {
        this.fPoolSize = n;
        this.fBufferSize = n2;
        this.fByteBufferPool = new byte[this.fPoolSize][];
        this.fDepth = 0;
    }

    public byte[] getBuffer() {
        return this.fDepth > 0 ? this.fByteBufferPool[--this.fDepth] : new byte[this.fBufferSize];
    }

    public void returnBuffer(byte[] byArray) {
        if (this.fDepth < this.fByteBufferPool.length) {
            this.fByteBufferPool[this.fDepth++] = byArray;
        }
    }

    public void setBufferSize(int n) {
        this.fBufferSize = n;
        this.fByteBufferPool = new byte[this.fPoolSize][];
        this.fDepth = 0;
    }
}

