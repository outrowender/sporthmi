/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.zip.ZipFile;

public class ZipStream
extends InputStream {
    private long streamHandle;
    private long uncompressedSize;
    private long pos;
    private long markPos = 0L;
    private Object lock;
    private ZipFile zipFile;
    private static Field descriptorField;
    private static Field lockField;
    static /* synthetic */ Class class$0;

    static {
        AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                Class clazz = class$0;
                if (clazz == null) {
                    try {
                        clazz = class$0 = Class.forName("java.util.zip.ZipFile");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                Class clazz2 = clazz;
                try {
                    descriptorField = clazz2.getDeclaredField("descriptor");
                    descriptorField.setAccessible(true);
                    lockField = clazz2.getDeclaredField("lock");
                    lockField.setAccessible(true);
                    return null;
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    throw new Error();
                }
            }
        });
    }

    ZipStream(long l) throws IOException {
        this.streamHandle = l;
        this.uncompressedSize = this.streamSizeImpl(this.streamHandle);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static InputStream getZipStream(ZipFile zipFile, String string) throws IOException {
        Object object;
        try {
            object = lockField.get(zipFile);
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
        Object object2 = object;
        synchronized (object2) {
            long l = ZipStream.checkDescriptor(zipFile);
            long l2 = ZipStream.openZipFileImpl(l, string);
            if (l2 == 0L) {
                return null;
            }
            ZipStream zipStream = new ZipStream(l2);
            zipStream.setInternals(zipFile, object);
            return zipStream;
        }
    }

    private void setInternals(ZipFile zipFile, Object object) {
        this.lock = object;
        this.zipFile = zipFile;
    }

    private static long checkDescriptor(ZipFile zipFile) {
        long l = -1L;
        try {
            l = descriptorField.getLong(zipFile);
        }
        catch (IllegalAccessException illegalAccessException) {}
        if (l == -1L) {
            throw new IllegalStateException(Msg.getString("K00b7"));
        }
        return l;
    }

    protected void finalize() {
        this.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            if (this.streamHandle != 0L) {
                this.closeStreamImpl(this.streamHandle);
                this.streamHandle = 0L;
            }
        }
    }

    public int available() throws IOException {
        return (int)(this.uncompressedSize - this.pos);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int read(byte[] byArray, int n, int n2) throws IOException {
        if (n <= byArray.length && n >= 0 && n2 >= 0 && n2 <= byArray.length - n) {
            Object object = this.lock;
            synchronized (object) {
                block7: {
                    ZipStream.checkDescriptor(this.zipFile);
                    if (this.streamHandle == 0L) {
                        throw new IOException(Msg.getString("K0059"));
                    }
                    if (this.pos != this.uncompressedSize) break block7;
                    return -1;
                }
                long l = this.uncompressedSize - this.pos;
                if ((long)n2 > l) {
                    n2 = (int)l;
                }
                this.readStreamImpl(this.streamHandle, byArray, n, n2);
                this.pos += (long)n2;
                return n2;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int read() throws IOException {
        byte[] byArray = new byte[1];
        if (this.read(byArray, 0, 1) == -1) {
            return -1;
        }
        return byArray[0] & 0xFF;
    }

    public boolean markSupported() {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void mark(int n) {
        Object object = this.lock;
        synchronized (object) {
            try {
                if (this.streamHandle != 0L) {
                    this.markStreamImpl(this.streamHandle);
                }
                this.markPos = this.pos;
            }
            catch (IOException iOException) {}
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            ZipStream.checkDescriptor(this.zipFile);
            if (this.streamHandle == 0L) {
                throw new IOException(Msg.getString("K0059"));
            }
            this.resetStreamImpl(this.streamHandle);
            this.pos = this.markPos;
        }
    }

    private static native long openZipFileImpl(long var0, String var2);

    private native long streamSizeImpl(long var1);

    private native void readStreamImpl(long var1, byte[] var3, int var4, int var5);

    private native void markStreamImpl(long var1);

    private native void resetStreamImpl(long var1);

    private native void closeStreamImpl(long var1);
}

