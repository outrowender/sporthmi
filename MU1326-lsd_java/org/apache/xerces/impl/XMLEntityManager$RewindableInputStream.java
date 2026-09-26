/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import java.io.InputStream;
import org.apache.xerces.impl.XMLEntityManager;

public final class XMLEntityManager$RewindableInputStream
extends InputStream {
    private InputStream fInputStream;
    private byte[] fData = new byte[64];
    private int fStartOffset;
    private int fEndOffset;
    private int fOffset;
    private int fLength;
    private int fMark;
    private final /* synthetic */ XMLEntityManager this$0;

    public XMLEntityManager$RewindableInputStream(XMLEntityManager xMLEntityManager, InputStream inputStream) {
        this.this$0 = xMLEntityManager;
        this.fInputStream = inputStream;
        this.fStartOffset = 0;
        this.fEndOffset = -1;
        this.fOffset = 0;
        this.fLength = 0;
        this.fMark = 0;
    }

    public void setStartOffset(int n) {
        this.fStartOffset = n;
    }

    public void rewind() {
        this.fOffset = this.fStartOffset;
    }

    @Override
    public int read() {
        int n = 0;
        if (this.fOffset < this.fLength) {
            return this.fData[this.fOffset++] & 0xFF;
        }
        if (this.fOffset == this.fEndOffset) {
            return -1;
        }
        if (this.fOffset == this.fData.length) {
            byte[] byArray = new byte[this.fOffset << 1];
            System.arraycopy((Object)this.fData, 0, (Object)byArray, 0, this.fOffset);
            this.fData = byArray;
        }
        if ((n = this.fInputStream.read()) == -1) {
            this.fEndOffset = this.fOffset;
            return -1;
        }
        this.fData[this.fLength++] = (byte)n;
        ++this.fOffset;
        return n & 0xFF;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        int n3 = this.fLength - this.fOffset;
        if (n3 == 0) {
            if (this.fOffset == this.fEndOffset) {
                return -1;
            }
            if (this.this$0.fCurrentEntity.mayReadChunks) {
                return this.fInputStream.read(byArray, n, n2);
            }
            int n4 = this.read();
            if (n4 == -1) {
                this.fEndOffset = this.fOffset;
                return -1;
            }
            byArray[n] = (byte)n4;
            return 1;
        }
        if (n2 < n3) {
            if (n2 <= 0) {
                return 0;
            }
        } else {
            n2 = n3;
        }
        if (byArray != null) {
            System.arraycopy((Object)this.fData, this.fOffset, (Object)byArray, n, n2);
        }
        this.fOffset += n2;
        return n2;
    }

    @Override
    public long skip(long l) {
        if (l <= 0L) {
            return 0L;
        }
        int n = this.fLength - this.fOffset;
        if (n == 0) {
            if (this.fOffset == this.fEndOffset) {
                return 0L;
            }
            return this.fInputStream.skip(l);
        }
        if (l <= (long)n) {
            this.fOffset = (int)((long)this.fOffset + l);
            return l;
        }
        this.fOffset += n;
        if (this.fOffset == this.fEndOffset) {
            return n;
        }
        return this.fInputStream.skip(l -= (long)n) + (long)n;
    }

    @Override
    public int available() {
        int n = this.fLength - this.fOffset;
        if (n == 0) {
            if (this.fOffset == this.fEndOffset) {
                return -1;
            }
            return this.this$0.fCurrentEntity.mayReadChunks ? this.fInputStream.available() : 0;
        }
        return n;
    }

    @Override
    public void mark(int n) {
        this.fMark = this.fOffset;
    }

    @Override
    public void reset() {
        this.fOffset = this.fMark;
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public void close() {
        if (this.fInputStream != null) {
            this.fInputStream.close();
            this.fInputStream = null;
        }
    }
}

