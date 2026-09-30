/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.OutputStream;

public class FilterOutputStream
extends OutputStream {
    protected OutputStream out;

    public FilterOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public void close() throws IOException {
        try {
            this.flush();
        }
        finally {
            this.out.close();
        }
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(byte[] byArray) throws IOException {
        this.write(byArray, 0, byArray.length);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (n <= byArray.length && n >= 0 && n2 >= 0 && n2 <= byArray.length - n) {
            int n3 = 0;
            while (n3 < n2) {
                this.write(byArray[n + n3]);
                ++n3;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
        }
    }

    public void write(int n) throws IOException {
        this.out.write(n);
    }
}

