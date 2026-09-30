/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.Reader;

public class CharArrayReader
extends Reader {
    protected char[] buf;
    protected int pos = 0;
    protected int markedPos = -1;
    protected int count = 0;

    public CharArrayReader(char[] cArray) {
        super(cArray);
        this.buf = cArray;
        this.count = cArray.length;
    }

    public CharArrayReader(char[] cArray, int n, int n2) {
        super(cArray);
        if (n < 0 || n > cArray.length || n2 < 0) {
            throw new IllegalArgumentException();
        }
        this.buf = cArray;
        this.pos = n;
        this.count = this.pos + n2 < cArray.length ? n2 : cArray.length;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                this.buf = null;
            }
        }
    }

    private boolean isOpen() {
        return this.buf != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void mark(int n) throws IOException {
        Object object = this.lock;
        synchronized (object) {
            if (!this.isOpen()) {
                throw new IOException(Msg.getString("K0060"));
            }
            this.markedPos = this.pos;
        }
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            block5: {
                if (!this.isOpen()) break block5;
                if (this.pos != this.count) {
                    return this.buf[this.pos++];
                }
                return -1;
            }
            throw new IOException(Msg.getString("K0060"));
        }
    }

    public int read(char[] cArray, int n, int n2) throws IOException {
        if (n >= 0 && n <= cArray.length && n2 >= 0 && n2 <= cArray.length - n) {
            Object object = this.lock;
            synchronized (object) {
                block6: {
                    if (!this.isOpen()) break block6;
                    if (this.pos != this.count) {
                        int n3 = this.pos + n2 > this.count ? this.count - this.pos : n2;
                        System.arraycopy((Object)this.buf, this.pos, (Object)cArray, n, n3);
                        this.pos += n3;
                        return n3;
                    }
                    return -1;
                }
                throw new IOException(Msg.getString("K0060"));
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean ready() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                return this.pos != this.count;
            }
            throw new IOException(Msg.getString("K0060"));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            if (!this.isOpen()) {
                throw new IOException(Msg.getString("K0060"));
            }
            this.pos = this.markedPos != -1 ? this.markedPos : 0;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long skip(long l) throws IOException {
        Object object = this.lock;
        synchronized (object) {
            block5: {
                if (!this.isOpen()) throw new IOException(Msg.getString("K0060"));
                if (l > 0L) break block5;
                return 0L;
            }
            long l2 = 0L;
            if (l < (long)(this.count - this.pos)) {
                this.pos += (int)l;
                return l;
            }
            l2 = this.count - this.pos;
            this.pos = this.count;
            return l2;
        }
    }
}

