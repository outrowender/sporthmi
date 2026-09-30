/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.SHAOutputStream;
import java.security.MessageDigest;

public class MessageDigestSHA
extends MessageDigest
implements Cloneable {
    private SHAOutputStream shaStream = new SHAOutputStream();

    public MessageDigestSHA() {
        super("SHA-1");
    }

    public Object clone() throws CloneNotSupportedException {
        MessageDigestSHA messageDigestSHA = (MessageDigestSHA)super.clone();
        messageDigestSHA.shaStream = (SHAOutputStream)this.shaStream.clone();
        return messageDigestSHA;
    }

    protected byte[] engineDigest() {
        return this.shaStream.getHashAsBytes();
    }

    protected int engineGetDigestLength() {
        return 20;
    }

    protected void engineReset() {
        this.shaStream.reset();
    }

    protected void engineUpdate(byte[] byArray, int n, int n2) {
        this.shaStream.write(byArray, n, n2);
    }

    protected void engineUpdate(byte by) {
        this.shaStream.write(by);
    }
}

