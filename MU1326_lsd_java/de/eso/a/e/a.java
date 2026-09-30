/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.e;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;

public class a {
    private Writer b;
    private int c = 76;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    boolean a = false;
    private static final char[] g = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static char[] h = g;
    private static final char i = '=';
    private static final int j = 63;

    public a(Writer writer) {
        this.b = writer;
    }

    public void a(int n) {
        this.f = n;
    }

    public void a(byte[] byArray) {
        this.a(byArray, 0, byArray.length);
        this.b.flush();
    }

    public void a(File file) {
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] byArray = new byte[255];
            int n = 0;
            while (!this.a) {
                n = bufferedInputStream.read(byArray);
                this.a(byArray, 0, n);
            }
            this.b.flush();
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw fileNotFoundException;
        }
        catch (IOException iOException) {
            throw iOException;
        }
        finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        }
    }

    public void a() {
        this.a(new byte[0], 0, -1);
    }

    private void a(byte[] byArray, int n, int n2) {
        if (n2 < 0) {
            this.a = true;
            switch (this.d) {
                case 1: {
                    this.a(h[this.e >> 2 & 0x3F]);
                    this.a(h[this.e << 4 & 0x3F]);
                    this.a('=');
                    this.a('=');
                    break;
                }
                case 2: {
                    this.a(h[this.e >> 10 & 0x3F]);
                    this.a(h[this.e >> 4 & 0x3F]);
                    this.a(h[this.e << 2 & 0x3F]);
                    this.a('=');
                    break;
                }
            }
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3;
                ++this.d;
                this.d %= 3;
                if ((n3 = byArray[n++]) < 0) {
                    n3 += 256;
                }
                this.e = (this.e << 8) + n3;
                if (0 != this.d) continue;
                this.a(h[this.e >> 18 & 0x3F]);
                this.a(h[this.e >> 12 & 0x3F]);
                this.a(h[this.e >> 6 & 0x3F]);
                this.a(h[this.e & 0x3F]);
                this.f += 4;
                if (this.c <= 0 || this.c > this.f) continue;
                this.b();
                this.a(' ');
                this.f = 1;
            }
        }
    }

    private void b() {
        this.b.write("\r\n");
    }

    private void a(char c2) {
        this.b.write(c2);
    }
}

