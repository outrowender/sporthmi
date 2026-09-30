/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class SimpleCharStream {
    public static final boolean staticFlag = false;
    int bufsize;
    int available;
    int tokenBegin;
    public int bufpos = -1;
    private int[] bufline;
    private int[] bufcolumn;
    private int column = 0;
    private int line = 1;
    private boolean prevCharIsCR = false;
    private boolean prevCharIsLF = false;
    private Reader inputStream;
    private char[] buffer;
    private int maxNextCharInd = 0;
    private int inBuf = 0;

    private final void ExpandBuff(boolean bl) {
        char[] cArray = new char[this.bufsize + 2048];
        int[] nArray = new int[this.bufsize + 2048];
        int[] nArray2 = new int[this.bufsize + 2048];
        try {
            if (bl) {
                System.arraycopy((Object)this.buffer, this.tokenBegin, (Object)cArray, 0, this.bufsize - this.tokenBegin);
                System.arraycopy((Object)this.buffer, 0, (Object)cArray, this.bufsize - this.tokenBegin, this.bufpos);
                this.buffer = cArray;
                System.arraycopy((Object)this.bufline, this.tokenBegin, (Object)nArray, 0, this.bufsize - this.tokenBegin);
                System.arraycopy((Object)this.bufline, 0, (Object)nArray, this.bufsize - this.tokenBegin, this.bufpos);
                this.bufline = nArray;
                System.arraycopy((Object)this.bufcolumn, this.tokenBegin, (Object)nArray2, 0, this.bufsize - this.tokenBegin);
                System.arraycopy((Object)this.bufcolumn, 0, (Object)nArray2, this.bufsize - this.tokenBegin, this.bufpos);
                this.bufcolumn = nArray2;
                this.maxNextCharInd = this.bufpos += this.bufsize - this.tokenBegin;
            } else {
                System.arraycopy((Object)this.buffer, this.tokenBegin, (Object)cArray, 0, this.bufsize - this.tokenBegin);
                this.buffer = cArray;
                System.arraycopy((Object)this.bufline, this.tokenBegin, (Object)nArray, 0, this.bufsize - this.tokenBegin);
                this.bufline = nArray;
                System.arraycopy((Object)this.bufcolumn, this.tokenBegin, (Object)nArray2, 0, this.bufsize - this.tokenBegin);
                this.bufcolumn = nArray2;
                this.maxNextCharInd = this.bufpos -= this.tokenBegin;
            }
        }
        catch (Throwable throwable) {
            throw new Error(throwable.getMessage());
        }
        this.bufsize += 2048;
        this.available = this.bufsize;
        this.tokenBegin = 0;
    }

    private final void FillBuff() throws IOException {
        if (this.maxNextCharInd == this.available) {
            if (this.available == this.bufsize) {
                if (this.tokenBegin > 2048) {
                    this.maxNextCharInd = 0;
                    this.bufpos = 0;
                    this.available = this.tokenBegin;
                } else if (this.tokenBegin < 0) {
                    this.maxNextCharInd = 0;
                    this.bufpos = 0;
                } else {
                    this.ExpandBuff(false);
                }
            } else if (this.available > this.tokenBegin) {
                this.available = this.bufsize;
            } else if (this.tokenBegin - this.available < 2048) {
                this.ExpandBuff(true);
            } else {
                this.available = this.tokenBegin;
            }
        }
        try {
            int n = this.inputStream.read(this.buffer, this.maxNextCharInd, this.available - this.maxNextCharInd);
            if (n == -1) {
                this.inputStream.close();
                throw new IOException();
            }
            this.maxNextCharInd += n;
            return;
        }
        catch (IOException iOException) {
            --this.bufpos;
            this.backup(0);
            if (this.tokenBegin == -1) {
                this.tokenBegin = this.bufpos;
            }
            throw iOException;
        }
    }

    public final char BeginToken() throws IOException {
        this.tokenBegin = -1;
        char c2 = this.readChar();
        this.tokenBegin = this.bufpos;
        return c2;
    }

    private final void UpdateLineColumn(char c2) {
        ++this.column;
        if (this.prevCharIsLF) {
            this.prevCharIsLF = false;
            this.column = 1;
            ++this.line;
        } else if (this.prevCharIsCR) {
            this.prevCharIsCR = false;
            if (c2 == '\n') {
                this.prevCharIsLF = true;
            } else {
                this.column = 1;
                ++this.line;
            }
        }
        switch (c2) {
            case '\r': {
                this.prevCharIsCR = true;
                break;
            }
            case '\n': {
                this.prevCharIsLF = true;
                break;
            }
            case '\t': {
                --this.column;
                this.column += 8 - (this.column & 7);
                break;
            }
        }
        this.bufline[this.bufpos] = this.line;
        this.bufcolumn[this.bufpos] = this.column;
    }

    public final char readChar() throws IOException {
        if (this.inBuf > 0) {
            --this.inBuf;
            if (++this.bufpos == this.bufsize) {
                this.bufpos = 0;
            }
            return this.buffer[this.bufpos];
        }
        if (++this.bufpos >= this.maxNextCharInd) {
            this.FillBuff();
        }
        char c2 = this.buffer[this.bufpos];
        this.UpdateLineColumn(c2);
        return c2;
    }

    public final int getColumn() {
        return this.bufcolumn[this.bufpos];
    }

    public final int getLine() {
        return this.bufline[this.bufpos];
    }

    public final int getEndColumn() {
        return this.bufcolumn[this.bufpos];
    }

    public final int getEndLine() {
        return this.bufline[this.bufpos];
    }

    public final int getBeginColumn() {
        return this.bufcolumn[this.tokenBegin];
    }

    public final int getBeginLine() {
        return this.bufline[this.tokenBegin];
    }

    public final void backup(int n) {
        this.inBuf += n;
        if ((this.bufpos -= n) < 0) {
            this.bufpos += this.bufsize;
        }
    }

    public SimpleCharStream(Reader reader, int n, int n2, int n3) {
        this.inputStream = reader;
        this.line = n;
        this.column = n2 - 1;
        this.available = this.bufsize = n3;
        this.buffer = new char[n3];
        this.bufline = new int[n3];
        this.bufcolumn = new int[n3];
    }

    public SimpleCharStream(Reader reader, int n, int n2) {
        this(reader, n, n2, 4096);
    }

    public SimpleCharStream(Reader reader) {
        this(reader, 1, 1, 4096);
    }

    public void ReInit(Reader reader, int n, int n2, int n3) {
        this.inputStream = reader;
        this.line = n;
        this.column = n2 - 1;
        if (this.buffer == null || n3 != this.buffer.length) {
            this.available = this.bufsize = n3;
            this.buffer = new char[n3];
            this.bufline = new int[n3];
            this.bufcolumn = new int[n3];
        }
        this.prevCharIsCR = false;
        this.prevCharIsLF = false;
        this.maxNextCharInd = 0;
        this.inBuf = 0;
        this.tokenBegin = 0;
        this.bufpos = -1;
    }

    public void ReInit(Reader reader, int n, int n2) {
        this.ReInit(reader, n, n2, 4096);
    }

    public void ReInit(Reader reader) {
        this.ReInit(reader, 1, 1, 4096);
    }

    public SimpleCharStream(InputStream inputStream, int n, int n2, int n3) {
        this(new InputStreamReader(inputStream), n, n2, 4096);
    }

    public SimpleCharStream(InputStream inputStream, int n, int n2) {
        this(inputStream, n, n2, 4096);
    }

    public SimpleCharStream(InputStream inputStream) {
        this(inputStream, 1, 1, 4096);
    }

    public void ReInit(InputStream inputStream, int n, int n2, int n3) {
        this.ReInit(new InputStreamReader(inputStream), n, n2, 4096);
    }

    public void ReInit(InputStream inputStream) {
        this.ReInit(inputStream, 1, 1, 4096);
    }

    public void ReInit(InputStream inputStream, int n, int n2) {
        this.ReInit(inputStream, n, n2, 4096);
    }

    public final String GetImage() {
        if (this.bufpos >= this.tokenBegin) {
            return new String(this.buffer, this.tokenBegin, this.bufpos - this.tokenBegin + 1);
        }
        return new String(this.buffer, this.tokenBegin, this.bufsize - this.tokenBegin) + new String(this.buffer, 0, this.bufpos + 1);
    }

    public final char[] GetSuffix(int n) {
        char[] cArray = new char[n];
        if (this.bufpos + 1 >= n) {
            System.arraycopy((Object)this.buffer, this.bufpos - n + 1, (Object)cArray, 0, n);
        } else {
            System.arraycopy((Object)this.buffer, this.bufsize - (n - this.bufpos - 1), (Object)cArray, 0, n - this.bufpos - 1);
            System.arraycopy((Object)this.buffer, 0, (Object)cArray, n - this.bufpos - 1, this.bufpos + 1);
        }
        return cArray;
    }

    public void Done() {
        this.buffer = null;
        this.bufline = null;
        this.bufcolumn = null;
    }

    public void adjustBeginLineColumn(int n, int n2) {
        int n3;
        int n4 = this.tokenBegin;
        int n5 = this.bufpos >= this.tokenBegin ? this.bufpos - this.tokenBegin + this.inBuf + 1 : this.bufsize - this.tokenBegin + this.bufpos + 1 + this.inBuf;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        for (n3 = 0; n3 < n5 && this.bufline[n6 = n4 % this.bufsize] == this.bufline[n7 = ++n4 % this.bufsize]; ++n3) {
            this.bufline[n6] = n;
            n8 = n9 + this.bufcolumn[n7] - this.bufcolumn[n6];
            this.bufcolumn[n6] = n2 + n9;
            n9 = n8;
        }
        if (n3 < n5) {
            this.bufline[n6] = n++;
            this.bufcolumn[n6] = n2 + n9;
            while (n3++ < n5) {
                n6 = n4 % this.bufsize;
                if (this.bufline[n6] != this.bufline[++n4 % this.bufsize]) {
                    this.bufline[n6] = n++;
                    continue;
                }
                this.bufline[n6] = n;
            }
        }
        this.line = this.bufline[n6];
        this.column = this.bufcolumn[n6];
    }
}

