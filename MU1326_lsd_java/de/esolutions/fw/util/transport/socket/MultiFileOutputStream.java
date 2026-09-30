/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.MultiFileNamer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MultiFileOutputStream
extends OutputStream {
    private final int splitSize;
    private final MultiFileNamer namer;
    private FileOutputStream stream;
    private int currentSize;

    private void beginNewFile() throws IOException {
        this.stream.close();
        this.currentSize = 0;
        String string = this.namer.nextFileName();
        try {
            this.stream = new FileOutputStream(string);
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new IOException("Can't open file: " + string);
        }
    }

    public MultiFileOutputStream(String string, String string2, int n, int n2, int n3) throws FileNotFoundException {
        this.splitSize = n3;
        this.namer = new MultiFileNamer(string, string2, n, n2);
        this.stream = new FileOutputStream(this.namer.nextFileName());
    }

    public MultiFileOutputStream(String string, String string2, int n) throws FileNotFoundException {
        this(string, string2, 4, 0, n);
    }

    public void close() throws IOException {
        super.close();
        this.stream.close();
    }

    public void write(int n) throws IOException {
        if (this.currentSize + 1 > this.splitSize) {
            this.beginNewFile();
        }
        this.stream.write(n);
        ++this.currentSize;
    }

    public void write(byte[] byArray) throws IOException {
        int n = byArray.length;
        if (this.currentSize + n > this.splitSize) {
            this.beginNewFile();
        }
        this.stream.write(byArray);
        this.currentSize += n;
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (this.currentSize + n2 > this.splitSize) {
            this.beginNewFile();
        }
        this.stream.write(byArray, n, n2);
        this.currentSize += n2;
    }
}

