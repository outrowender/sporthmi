/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.MultiFileNamer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MultiFileInputStream
extends InputStream {
    private MultiFileNamer namer;
    private FileInputStream stream;

    public MultiFileInputStream(String string, String string2, int n, int n2) throws FileNotFoundException {
        this.namer = new MultiFileNamer(string, string2, n, n2);
        this.stream = new FileInputStream(this.namer.nextFileName());
    }

    public MultiFileInputStream(String string, String string2) throws FileNotFoundException {
        this(string, string2, 4, 0);
    }

    public void close() throws IOException {
        this.stream.close();
    }

    public int read() throws IOException {
        int n = this.stream.read();
        if (n == -1) {
            this.stream.close();
            try {
                this.stream = new FileInputStream(this.namer.nextFileName());
                n = this.stream.read();
            }
            catch (FileNotFoundException fileNotFoundException) {
                return -1;
            }
        }
        return n;
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = this.stream.read(byArray, n, n2);
        if (n3 == -1) {
            this.stream.close();
            try {
                this.stream = new FileInputStream(this.namer.nextFileName());
                n3 = this.stream.read(byArray, n, n2);
            }
            catch (FileNotFoundException fileNotFoundException) {
                return -1;
            }
        }
        return n3;
    }
}

