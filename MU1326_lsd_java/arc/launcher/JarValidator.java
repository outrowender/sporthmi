/*
 * Decompiled with CFR 0.152.
 */
package arc.launcher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;

public final class JarValidator {
    public static final int JAR_VALID = 0;
    public static final int ERROR_CODE_UNKNOWN_SIGNATURE = 2;
    public static final int ERROR_CODE_FILE_LEN_MISMATCH = 3;
    public static final int ERROR_CODE_CRC_MISMATCH = 4;
    private static final int EOCD_SIG_VALUE = 101010256;
    private static final byte[] EOCD_SIG;
    private static final int EOCD_SIZE_WITHOUT_COMMENT = 22;
    private static final int SIGN_SIZE = 12;
    private static final int EOCD_SIZE_WITH_SIGN = 34;
    private static final byte[] SIGN_SIG;
    private static final int BUFFER_SIZE = 1024;
    private final RandomAccessFile orgJarFile;
    private final int fileSize;
    private final byte[] buffer = new byte[1024];

    static {
        SIGN_SIG = new byte[]{70, 83, -16, 81};
        LIByteBuffer lIByteBuffer = LIByteBuffer.allocate(4);
        lIByteBuffer.putInt(101010256);
        EOCD_SIG = lIByteBuffer.array();
    }

    public static void signJar(File file, File file2) throws IOException {
        if (((Object)file).equals(file2)) {
            throw new IllegalArgumentException("destination file may not override the original jar file");
        }
        JarValidator jarValidator = new JarValidator(file);
        jarValidator.createSignJar(file2);
        jarValidator.close();
    }

    public static boolean isSignedJarFileValid(File file) {
        JarValidator jarValidator = null;
        boolean bl = false;
        try {
            try {
                jarValidator = new JarValidator(file);
                bl = jarValidator.checkSignedJar() == 0;
            }
            catch (Throwable throwable) {}
        }
        catch (Throwable throwable) {
            if (jarValidator != null) {
                try {
                    jarValidator.close();
                }
                catch (IOException iOException) {}
            }
            throw throwable;
        }
        if (jarValidator != null) {
            try {
                jarValidator.close();
            }
            catch (IOException iOException) {}
        }
        return bl;
    }

    public JarValidator(File file) throws IOException {
        this.orgJarFile = new RandomAccessFile(file, "r");
        this.fileSize = (int)file.length();
    }

    public void close() throws IOException {
        this.orgJarFile.close();
    }

    public void createSignJar(File file) throws IOException {
        int n = this.getEOCDPosition();
        if (n == -1) {
            throw new IllegalStateException("Cannot find EOCD");
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, false);
            CRC32 cRC32 = new CRC32();
            int n2 = n + 20;
            this.orgJarFile.seek(0L);
            while (n2 > 0) {
                int n3 = Math.min(n2, 1024);
                if (this.orgJarFile.read(this.buffer, 0, n3) != n3) {
                    throw new IllegalStateException("read failed");
                }
                cRC32.update(this.buffer, 0, n3);
                fileOutputStream.write(this.buffer, 0, n3);
                n2 -= n3;
            }
            byte[] byArray = new byte[14];
            LIByteBuffer lIByteBuffer = LIByteBuffer.wrap(byArray);
            lIByteBuffer.putShort((short)12);
            cRC32.update(byArray, 0, 2);
            lIByteBuffer.put(SIGN_SIG);
            lIByteBuffer.putInt(n + 34);
            lIByteBuffer.putInt((int)cRC32.getValue());
            fileOutputStream.write(byArray);
        }
        finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public int checkSignedJar() throws IOException {
        int n;
        int n2 = this.getEOCDPosition();
        if (n2 == -1) {
            throw new IllegalStateException("Cannot find EOCD");
        }
        if (n2 + 34 != this.fileSize) {
            return 2;
        }
        this.orgJarFile.seek(0L);
        int n3 = n2 + 22;
        CRC32 cRC32 = new CRC32();
        while (n3 > 0) {
            int n4 = Math.min(n3, 1024);
            if (this.orgJarFile.read(this.buffer, 0, n4) != n4) {
                throw new IllegalStateException("read failed");
            }
            cRC32.update(this.buffer, 0, n4);
            n3 -= n4;
        }
        byte[] byArray = new byte[12];
        this.orgJarFile.read(byArray);
        LIByteBuffer lIByteBuffer = LIByteBuffer.wrap(byArray);
        int n5 = 0;
        while (n5 < 4) {
            if (lIByteBuffer.get() != SIGN_SIG[n5]) {
                return 2;
            }
            ++n5;
        }
        n5 = lIByteBuffer.getInt();
        if (n5 != this.fileSize) {
            return 3;
        }
        int n6 = lIByteBuffer.getInt();
        if (n6 != (n = (int)cRC32.getValue())) {
            return 4;
        }
        return 0;
    }

    int getEOCDPosition() throws IOException {
        int n = this.fileSize;
        int n2 = n - 22;
        if (this.isEocdValid(n2)) {
            return n2;
        }
        n2 = n - 34;
        if (this.isEocdValid(n2)) {
            return n2;
        }
        int n3 = n - 1024;
        while (true) {
            if (n3 < 0) {
                n3 = 0;
            }
            this.orgJarFile.seek(n3);
            int n4 = this.orgJarFile.read(this.buffer);
            int n5 = JarValidator.lastIndexOfEocdSig(this.buffer, n4);
            if (n5 >= 0 && this.isEocdValid(n2 = n5 + n3)) {
                return n2;
            }
            if (n3 == 0) {
                return -1;
            }
            n3 -= 1028;
        }
    }

    boolean isEocdValid(int n) throws IOException {
        this.orgJarFile.seek(n);
        byte[] byArray = new byte[22];
        int n2 = this.orgJarFile.read(byArray);
        if (n2 != 22) {
            return false;
        }
        LIByteBuffer lIByteBuffer = LIByteBuffer.wrap(byArray);
        if (lIByteBuffer.getInt() != 101010256) {
            return false;
        }
        lIByteBuffer.position(20);
        short s = lIByteBuffer.getShort();
        return this.fileSize == n + 22 + s;
    }

    static int lastIndexOfEocdSig(byte[] byArray, int n) {
        int n2 = n - 1;
        block0: while (n2 >= 3) {
            int n3 = 3;
            while (n3 >= 0) {
                if (EOCD_SIG[n3] != byArray[n2--]) continue block0;
                --n3;
            }
            return n2 + 1;
        }
        return -1;
    }

    public static class LIByteBuffer {
        int pos;
        byte[] buf;

        private LIByteBuffer(byte[] byArray) {
            this.buf = byArray;
        }

        public static LIByteBuffer wrap(byte[] byArray) {
            return new LIByteBuffer(byArray);
        }

        public static LIByteBuffer allocate(int n) {
            return new LIByteBuffer(new byte[n]);
        }

        public byte[] array() {
            return this.buf;
        }

        public void position(int n) {
            this.pos = n;
        }

        public byte get() {
            return this.buf[this.pos++];
        }

        public void put(byte[] byArray) {
            int n = byArray.length;
            int n2 = 0;
            while (n2 < n) {
                this.buf[this.pos++] = byArray[n2];
                ++n2;
            }
        }

        public short getShort() {
            int n = this.buf[this.pos++] & 0xFF;
            int n2 = this.buf[this.pos++] & 0xFF;
            return (short)((n2 << 8) + (n << 0));
        }

        public void putShort(short s) {
            this.buf[this.pos++] = (byte)(s >>> 0 & 0xFF);
            this.buf[this.pos++] = (byte)(s >>> 8 & 0xFF);
        }

        public int getInt() {
            int n = this.buf[this.pos++] & 0xFF;
            int n2 = this.buf[this.pos++] & 0xFF;
            int n3 = this.buf[this.pos++] & 0xFF;
            int n4 = this.buf[this.pos++] & 0xFF;
            return (n4 << 24) + (n3 << 16) + (n2 << 8) + (n << 0);
        }

        public void putInt(int n) {
            this.buf[this.pos++] = (byte)(n >>> 0 & 0xFF);
            this.buf[this.pos++] = (byte)(n >>> 8 & 0xFF);
            this.buf[this.pos++] = (byte)(n >>> 16 & 0xFF);
            this.buf[this.pos++] = (byte)(n >>> 24 & 0xFF);
        }
    }
}

