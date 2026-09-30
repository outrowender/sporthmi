/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.MD5OutputStream;
import java.security.MessageDigest;

public class MessageDigestMD5
extends MessageDigest
implements Cloneable {
    private MD5OutputStream md5Stream = new MD5OutputStream();

    public MessageDigestMD5() {
        super("MD5");
    }

    public Object clone() throws CloneNotSupportedException {
        MessageDigestMD5 messageDigestMD5 = (MessageDigestMD5)super.clone();
        messageDigestMD5.md5Stream = this.md5Stream.copyOf();
        return messageDigestMD5;
    }

    protected byte[] engineDigest() {
        return this.md5Stream.getHashAsBytes();
    }

    protected int engineGetDigestLength() {
        return 16;
    }

    protected void engineReset() {
        this.md5Stream.reset();
    }

    protected void engineUpdate(byte[] byArray, int n, int n2) {
        this.md5Stream.write(byArray, n, n2);
    }

    protected void engineUpdate(byte by) {
        this.md5Stream.write(by);
    }
}

