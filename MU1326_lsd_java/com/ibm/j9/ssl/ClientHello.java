/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.CipherSpec;
import com.ibm.j9.ssl.HandshakeSocket;
import com.ibm.j9.ssl.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ClientHello {
    private HandshakeSocket socket;
    private byte[] random;
    private byte[] sessionID = null;
    private byte[] compressionMethods;
    private static String lineTerminator = Util.getLineTerminator();

    public ClientHello(HandshakeSocket handshakeSocket, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        this.socket = handshakeSocket;
        this.random = byArray;
        if (byArray2 != null) {
            this.sessionID = new byte[byArray2.length];
            int n = 0;
            while (n < byArray2.length) {
                this.sessionID[n] = byArray2[n];
                ++n;
            }
        }
        this.compressionMethods = byArray3;
    }

    public byte[] toByteArray() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.getHighestVersion());
            byteArrayOutputStream.write(this.random);
            byteArrayOutputStream.write((byte)(this.sessionID == null ? 0 : this.sessionID.length));
            if (this.sessionID != null && this.sessionID.length > 0) {
                byteArrayOutputStream.write(this.sessionID);
            }
            CipherSpec[] cipherSpecArray = this.socket.getEnabledCipherSpecs();
            byteArrayOutputStream.write(Util.getBytes(cipherSpecArray.length * 2, 2));
            int n = 0;
            while (n < cipherSpecArray.length) {
                byteArrayOutputStream.write(cipherSpecArray[n].getId());
                ++n;
            }
            byteArrayOutputStream.write((byte)this.compressionMethods.length);
            n = 0;
            while (n < this.compressionMethods.length) {
                byteArrayOutputStream.write(this.compressionMethods[n]);
                ++n;
            }
        }
        catch (IOException iOException) {}
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] getHighestVersion() {
        byte[] byArray = new byte[2];
        int n = 0;
        while (n < this.socket.getEnabledProtocols().length) {
            byte[] byArray2 = CipherSpec.getProtocolVersion(this.socket.getEnabledProtocols()[n]);
            if (byArray2[0] > byArray[0]) {
                byArray = byArray2;
            } else if (byArray2[0] == byArray[0] && byArray2[1] > byArray[1]) {
                byArray = byArray2;
            }
            ++n;
        }
        return byArray;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("=====Client Hello=====" + lineTerminator);
        stringBuffer.append("Version: " + this.getHighestVersion() + lineTerminator);
        stringBuffer.append("Random (" + this.random.length + "): " + Util.getStringForByteArray(this.random) + lineTerminator);
        stringBuffer.append("Session ID: ");
        if (this.sessionID == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(Util.getStringForByteArray(this.sessionID));
        }
        stringBuffer.append(lineTerminator);
        stringBuffer.append("Cipher Suites: ");
        int n = 0;
        while (n < this.socket.getEnabledCipherSpecs().length) {
            stringBuffer.append(this.socket.getEnabledCipherSpecs()[n] + ";");
            ++n;
        }
        stringBuffer.append(lineTerminator);
        stringBuffer.append("Compression methods: ");
        if (this.compressionMethods == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(this.compressionMethods[0]);
            n = 1;
            while (n < this.compressionMethods.length) {
                stringBuffer.append(";" + this.compressionMethods[n]);
                ++n;
            }
            stringBuffer.append(lineTerminator);
        }
        stringBuffer.append("======================" + lineTerminator);
        return stringBuffer.toString();
    }
}

