/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import org.apache.xerces.impl.XMLEntityManager$CharacterBuffer;

final class XMLEntityManager$CharacterBufferPool {
    private static final int DEFAULT_POOL_SIZE;
    private XMLEntityManager$CharacterBuffer[] fInternalBufferPool;
    private XMLEntityManager$CharacterBuffer[] fExternalBufferPool;
    private int fExternalBufferSize;
    private int fInternalBufferSize;
    private int fPoolSize;
    private int fInternalTop;
    private int fExternalTop;

    public XMLEntityManager$CharacterBufferPool(int n, int n2) {
        this(3, n, n2);
    }

    public XMLEntityManager$CharacterBufferPool(int n, int n2, int n3) {
        this.fExternalBufferSize = n2;
        this.fInternalBufferSize = n3;
        this.fPoolSize = n;
        this.init();
    }

    private void init() {
        this.fInternalBufferPool = new XMLEntityManager$CharacterBuffer[this.fPoolSize];
        this.fExternalBufferPool = new XMLEntityManager$CharacterBuffer[this.fPoolSize];
        this.fInternalTop = -1;
        this.fExternalTop = -1;
    }

    public XMLEntityManager$CharacterBuffer getBuffer(boolean bl) {
        if (bl) {
            if (this.fExternalTop > -1) {
                return this.fExternalBufferPool[this.fExternalTop--];
            }
            return new XMLEntityManager$CharacterBuffer(true, this.fExternalBufferSize);
        }
        if (this.fInternalTop > -1) {
            return this.fInternalBufferPool[this.fInternalTop--];
        }
        return new XMLEntityManager$CharacterBuffer(false, this.fInternalBufferSize);
    }

    public void returnBuffer(XMLEntityManager$CharacterBuffer xMLEntityManager$CharacterBuffer) {
        if (XMLEntityManager$CharacterBuffer.access$500(xMLEntityManager$CharacterBuffer)) {
            if (this.fExternalTop < this.fExternalBufferPool.length - 1) {
                this.fExternalBufferPool[++this.fExternalTop] = xMLEntityManager$CharacterBuffer;
            }
        } else if (this.fInternalTop < this.fInternalBufferPool.length - 1) {
            this.fInternalBufferPool[++this.fInternalTop] = xMLEntityManager$CharacterBuffer;
        }
    }

    public void setExternalBufferSize(int n) {
        this.fExternalBufferSize = n;
        this.fExternalBufferPool = new XMLEntityManager$CharacterBuffer[this.fPoolSize];
        this.fExternalTop = -1;
    }
}

