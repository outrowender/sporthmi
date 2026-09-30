/*
 * Decompiled with CFR 0.152.
 */
package de.eso.IconExtractor;

import java.nio.ByteBuffer;

public class IconExtractor {
    private static final int NO_ERROR = 0;
    private static final int NATIVE_ICONEXTRACTOR_NOT_FOUND = -1;
    private static final int FUNCTION_RESOLUTION_FAILED = -2;
    private static final int FRAMEWORK_INIT_FAILED = -3;
    private static final int IMAGE_NOT_FOUND = -4;
    private static final int JNI_ERROR = -5;

    private static void explainError(int n) {
        switch (n) {
            case 0: {
                break;
            }
            case -1: {
                throw new RuntimeException("Native part of iconextractor could not be loaded. Check presence of libstyledbservice.so and its dependencies!");
            }
            case -2: {
                throw new RuntimeException("Native part of iconextractor was found, but methods could not be resolved. This is very unlikely to happen unless someone messed up the system or iconextracor interface was changed.");
            }
            case -3: {
                throw new RuntimeException("Framework initialization failed! Check that a valid framework.json is reachable via IPL_CONFIG_DIR, that process name 'styledbservice' is configured there and that the broker is running.");
            }
            case -4: {
                throw new RuntimeException("Image with specified id not found. This can have a lot of reasons. First, please check if a COMM connection to navigation process is working. If it is, please make sure that navigation really has an image with the requested id.");
            }
            case -5: {
                throw new RuntimeException("Well, something went terribly wrong in internal JNI communication. This is either an out-of-memory situation or a mismatch between java and native parts of iconextractor.");
            }
            default: {
                throw new RuntimeException("WTF: unhandled exception id " + n);
            }
        }
    }

    public static void initialize() {
        System.loadLibrary("styledbservice");
        int n = IconExtractor.initializeIE();
        IconExtractor.explainError(n);
    }

    public static void shutdown() {
        IconExtractor.shutdownIE();
    }

    public static Bitmap getImage(long l, long l2) {
        int[] nArray = new int[2];
        int n = IconExtractor.getSize(l, nArray);
        IconExtractor.explainError(n);
        if (nArray[0] == 0 && nArray[1] == 0) {
            return null;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(nArray[0] * nArray[1] * 4);
        n = IconExtractor.getData(l, byteBuffer, l2);
        IconExtractor.explainError(n);
        Bitmap bitmap = new Bitmap(nArray[0], nArray[1], byteBuffer);
        return bitmap;
    }

    public static Bitmap getImage(long l) {
        return IconExtractor.getImage(l, 1000L);
    }

    public static Bitmap getImage(String string, long l) {
        if (string == null) {
            throw new RuntimeException("String id is null!");
        }
        int[] nArray = new int[2];
        int n = IconExtractor.getSizeStr(string, nArray);
        IconExtractor.explainError(n);
        if (nArray[0] == 0 && nArray[1] == 0) {
            return null;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(nArray[0] * nArray[1] * 4);
        n = IconExtractor.getDataStr(string, byteBuffer, l);
        IconExtractor.explainError(n);
        Bitmap bitmap = new Bitmap(nArray[0], nArray[1], byteBuffer);
        return bitmap;
    }

    public static Bitmap getImage(String string) {
        return IconExtractor.getImage(string, 1000L);
    }

    private static native int initializeIE();

    private static native void shutdownIE();

    private static native int getSize(long var0, int[] var2);

    private static native int getData(long var0, ByteBuffer var2, long var3);

    private static native int getSizeStr(String var0, int[] var1);

    private static native int getDataStr(String var0, ByteBuffer var1, long var2);

    public static void main(String[] stringArray) {
        System.out.println("This is a iconextractor standalone test");
        IconExtractor.initialize();
        Bitmap bitmap = IconExtractor.getImage(1L, 1000L);
        if (bitmap == null) {
            System.out.println("No bitmap found");
        } else {
            System.out.println("IconExtractor got bitmap of size " + bitmap.getWidth() + "x" + bitmap.getHeight());
        }
        IconExtractor.shutdown();
    }

    public static class Bitmap {
        public static final int FORMAT_GRAYSCALE = 1;
        public static final int FORMAT_RGBA = 4;
        int mWidth;
        int mHeight;
        ByteBuffer mData;

        public Bitmap(int n, int n2, ByteBuffer byteBuffer) {
            this.mWidth = n;
            this.mHeight = n2;
            this.mData = byteBuffer;
        }

        public ByteBuffer getData() {
            return this.mData;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getFormat() {
            return 4;
        }
    }
}

