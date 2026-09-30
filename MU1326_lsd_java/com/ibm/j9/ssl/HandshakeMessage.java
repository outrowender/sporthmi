/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.Util;
import java.io.IOException;
import java.io.InputStream;

public class HandshakeMessage {
    public static final byte HELLO_REQUEST = 0;
    public static final byte CLIENT_HELLO = 1;
    public static final byte SERVER_HELLO = 2;
    public static final byte CERTIFICATE = 11;
    public static final byte SERVER_KEY_EXCHANGE = 12;
    public static final byte CERTIFICATE_REQUEST = 13;
    public static final byte SERVER_HELLO_DONE = 14;
    public static final byte CERTIFICATE_VERIFY = 15;
    public static final byte CLIENT_KEY_EXCHANGE = 16;
    public static final byte FINISHED = 20;
    public byte type;
    public byte[] rawData;

    public HandshakeMessage() {
    }

    public HandshakeMessage(InputStream inputStream) throws IOException {
        this.type = (byte)inputStream.read();
        byte[] byArray = new byte[3];
        inputStream.read(byArray);
        int n = (int)Util.getLong(byArray, 0, 3);
        this.rawData = new byte[n];
        inputStream.read(this.rawData);
    }

    public HandshakeMessage(byte[] byArray) {
        this.type = byArray[0];
        int n = (int)Util.getLong(byArray, 1, 3);
        byte[] byArray2 = new byte[n];
        System.arraycopy((Object)byArray, 4, (Object)byArray2, 0, n);
    }

    public byte[] toByteArray() {
        byte[] byArray = new byte[4 + this.rawData.length];
        byArray[0] = this.type;
        byArray[1] = (byte)(this.rawData.length >> 16 & 0xFF);
        byArray[2] = (byte)(this.rawData.length >> 8 & 0xFF);
        byArray[3] = (byte)(this.rawData.length & 0xFF);
        System.arraycopy((Object)this.rawData, 0, (Object)byArray, 4, this.rawData.length);
        return byArray;
    }
}

