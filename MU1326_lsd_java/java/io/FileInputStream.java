/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStream
extends InputStream {
    FileDescriptor fd;

    static {
        FileInputStream.oneTimeInitialization();
    }

    private static native void oneTimeInitialization();

    public FileInputStream(File file) throws FileNotFoundException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(file.getPath());
        }
        this.fd = new FileDescriptor();
        if (this.openImpl(file.properPath(true)) != 0) {
            throw new FileNotFoundException(file.getPath());
        }
    }

    public FileInputStream(FileDescriptor fileDescriptor) {
        if (fileDescriptor != null) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkRead(fileDescriptor);
            }
        } else {
            throw new NullPointerException();
        }
        this.fd = fileDescriptor;
    }

    public FileInputStream(String string) throws FileNotFoundException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(string);
        }
        this.fd = new FileDescriptor();
        if (this.openImpl(new File(string).properPath(true)) != 0) {
            throw new FileNotFoundException(string);
        }
    }

    public native int available();

    public void close() throws IOException {
        this.closeImpl();
    }

    private native void closeImpl();

    protected void finalize() throws IOException {
        if (this.fd != null) {
            this.close();
        }
    }

    public final FileDescriptor getFD() throws IOException {
        if (this.fd != null) {
            return this.fd;
        }
        throw new IOException();
    }

    private native int openImpl(byte[] var1);

    public int read() throws IOException {
        if (this.fd != null) {
            return this.readByteImpl(this.getFD().descriptor);
        }
        throw new IOException();
    }

    private native int readByteImpl(long var1);

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        if (this.fd != null) {
            return this.readImpl(byArray, n, n2, this.getFD().descriptor);
        }
        throw new IOException();
    }

    private native int readImpl(byte[] var1, int var2, int var3, long var4);

    public native long skip(long var1);
}

