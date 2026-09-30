/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

public class DigestOutputStream
extends FilterOutputStream {
    protected MessageDigest digest;
    private boolean on;

    public DigestOutputStream(OutputStream outputStream, MessageDigest messageDigest) {
        super(outputStream);
        this.setMessageDigest(messageDigest);
        this.on(true);
    }

    public MessageDigest getMessageDigest() {
        return this.digest;
    }

    public void on(boolean bl) {
        this.on = bl;
    }

    public void setMessageDigest(MessageDigest messageDigest) {
        this.digest = messageDigest;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[Digest Output Stream]");
        if (this.digest != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.digest.toString());
        }
        if (this.on) {
            stringBuffer.append(", <on>");
        } else {
            stringBuffer.append(", <off>");
        }
        return stringBuffer.toString();
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        super.write(byArray, n, n2);
    }

    public void write(int n) throws IOException {
        super.write(n);
        if (this.on) {
            this.digest.engineUpdate((byte)n);
        }
    }
}

