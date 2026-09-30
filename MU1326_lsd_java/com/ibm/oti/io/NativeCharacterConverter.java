/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharBuffer;
import com.ibm.oti.io.CharacterConverter;

public class NativeCharacterConverter
extends CharacterConverter {
    private String javaEncoding;
    private long osCodePage = -1L;
    private static boolean supportsNativeConv = NativeCharacterConverter.supportsNativeCharConv();

    public void setJavaEncoding(String string) {
        this.javaEncoding = string;
    }

    public String getJavaEncoding() {
        return this.javaEncoding;
    }

    private static native boolean supportsNativeCharConv();

    native boolean supportsCodePage(String var1);

    public static boolean supportsNativeConversion() {
        return supportsNativeConv;
    }

    public byte[] convert(char[] cArray, int n, int n2) {
        if (n >= 0 && n <= cArray.length && n2 >= 0 && n2 <= cArray.length - n) {
            if (n2 == 0) {
                return new byte[0];
            }
            return this.convertCharsToBytesImpl(cArray, n, n2, this.javaEncoding, this.osCodePage);
        }
        throw new IndexOutOfBoundsException();
    }

    private native byte[] convertCharsToBytesImpl(char[] var1, int var2, int var3, String var4, long var5);

    public char[] convert(byte[] byArray, int n, int n2) {
        if (n >= 0 && n <= byArray.length && n2 >= 0 && n2 <= byArray.length - n) {
            if (n2 == 0) {
                return new char[0];
            }
            return this.convertBytesToCharsImpl(byArray, n, n2, this.javaEncoding, this.osCodePage);
        }
        throw new IndexOutOfBoundsException();
    }

    private native char[] convertBytesToCharsImpl(byte[] var1, int var2, int var3, String var4, long var5);

    public int convert(byte[] byArray, int n, int n2, CharBuffer charBuffer) {
        int n3 = 0;
        int[] nArray = new int[]{charBuffer.getPos()};
        if (n >= 0 && n <= byArray.length && n2 >= 0 && n2 <= byArray.length - n) {
            n3 = this.convertStreamBytesToCharsImpl(byArray, n, n2, charBuffer.getChars(), charBuffer.getOffset(), charBuffer.getSize(), nArray, this.javaEncoding, this.osCodePage);
            charBuffer.setPos(nArray[0]);
            return n3;
        }
        throw new IndexOutOfBoundsException();
    }

    private native int convertStreamBytesToCharsImpl(byte[] var1, int var2, int var3, char[] var4, int var5, int var6, int[] var7, String var8, long var9);
}

