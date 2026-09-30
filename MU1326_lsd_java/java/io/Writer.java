/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.IOException;

public abstract class Writer {
    protected Object lock;

    protected Writer() {
        this.lock = this;
    }

    protected Writer(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.lock = object;
    }

    public abstract void close() throws IOException;

    public abstract void flush() throws IOException;

    public void write(char[] cArray) throws IOException {
        this.write(cArray, 0, cArray.length);
    }

    public abstract void write(char[] var1, int var2, int var3) throws IOException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write(int n) throws IOException {
        Object object = this.lock;
        synchronized (object) {
            char[] cArray = new char[]{(char)n};
            this.write(cArray);
        }
    }

    public void write(String string) throws IOException {
        char[] cArray = new char[string.length()];
        string.getChars(0, cArray.length, cArray, 0);
        this.write(cArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write(String string, int n, int n2) throws IOException {
        if (n2 >= 0) {
            char[] cArray = new char[n2];
            string.getChars(n, n + n2, cArray, 0);
            Object object = this.lock;
            synchronized (object) {
                this.write(cArray);
            }
        } else {
            throw new StringIndexOutOfBoundsException();
        }
    }
}

