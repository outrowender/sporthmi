/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.ZipStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.zip.ZipConstants;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

public class ZipFile
implements ZipConstants {
    private String fileName;
    long descriptor = -1L;
    private int size = -1;
    private int mode;
    private Object lock = new Object();
    public static final int OPEN_READ = 1;
    public static final int OPEN_DELETE = 4;

    static {
        ZipFile.ntvinit();
    }

    public ZipFile(File file) throws ZipException, IOException {
        this(file.getPath());
    }

    public ZipFile(File file, int n) throws IOException {
        if (n == 1 || n == 5) {
            this.fileName = file.getPath();
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkRead(this.fileName);
                if ((n & 4) != 0) {
                    securityManager.checkDelete(this.fileName);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        this.mode = n;
        this.openZip(this.fileName);
    }

    public ZipFile(String string) throws IOException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(string);
        }
        this.fileName = string;
        this.openZip(this.fileName);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void openZip(String string) throws IOException {
        int n;
        Object object = this.lock;
        synchronized (object) {
            n = this.openZipImpl(Util.getBytes(this.fileName));
        }
        if (n != 0) {
            switch (n) {
                case 1: {
                    throw new ZipException(Msg.getString("K01c3", this.fileName));
                }
                case 2: {
                    throw new ZipException(Msg.getString("K01c4", this.fileName));
                }
            }
            throw new OutOfMemoryError();
        }
    }

    protected void finalize() throws IOException {
        this.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() throws IOException {
        if (this.fileName != null) {
            Object object = this.lock;
            synchronized (object) {
                this.closeZipImpl();
            }
            if ((this.mode & 4) != 0) {
                AccessController.doPrivileged(new PrivilegedAction(){

                    public Object run() {
                        new File(ZipFile.this.fileName).delete();
                        return null;
                    }
                });
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Enumeration entries() {
        Object object = this.lock;
        synchronized (object) {
            return new ZFEnum();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ZipEntry getEntry(String string) {
        if (string != null) {
            ZipEntry zipEntry;
            Object object = this.lock;
            synchronized (object) {
                zipEntry = this.getEntryImpl(this.descriptor, string);
            }
            return zipEntry;
        }
        throw new NullPointerException();
    }

    public InputStream getInputStream(ZipEntry zipEntry) throws IOException {
        return ZipStream.getZipStream(this, zipEntry.getName());
    }

    public String getName() {
        return this.fileName;
    }

    private native int openZipImpl(byte[] var1);

    private native void closeZipImpl();

    private native ZipEntry getEntryImpl(long var1, String var3);

    public int size() {
        if (this.size != -1) {
            return this.size;
        }
        this.size = 0;
        Enumeration enumeration = this.entries();
        while (enumeration.hasMoreElements()) {
            ++this.size;
            enumeration.nextElement();
        }
        return this.size;
    }

    private static native void ntvinit();

    class ZFEnum
    implements Enumeration {
        private long nextEntryPointer;
        private ZipEntry current;

        ZFEnum() {
            this.nextEntryPointer = this.resetZip(ZipFile.this.descriptor);
            this.current = this.getNextEntry(ZipFile.this.descriptor, this.nextEntryPointer);
        }

        private native long resetZip(long var1);

        private native ZipEntry getNextEntry(long var1, long var3);

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean hasMoreElements() {
            Object object = ZipFile.this.lock;
            synchronized (object) {
                if (ZipFile.this.descriptor == -1L) {
                    throw new IllegalStateException(Msg.getString("K00b7"));
                }
            }
            return this.current != null;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object nextElement() {
            if (this.current == null) {
                throw new NoSuchElementException();
            }
            ZipEntry zipEntry = this.current;
            Object object = ZipFile.this.lock;
            synchronized (object) {
                if (ZipFile.this.descriptor == -1L) {
                    throw new IllegalStateException(Msg.getString("K00b7"));
                }
                this.current = this.getNextEntry(ZipFile.this.descriptor, this.nextEntryPointer);
            }
            return zipEntry;
        }
    }
}

