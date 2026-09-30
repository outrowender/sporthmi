/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.MD5OutputStream;
import com.ibm.oti.security.provider.SignatureRSA;

public class SignatureMD5withRSA
extends SignatureRSA {
    private MD5OutputStream hash = new MD5OutputStream();

    public SignatureMD5withRSA() {
        super("MD5");
    }

    protected void resetHash() {
        this.hash.reset();
    }

    protected void updateHash(byte[] byArray, int n, int n2) {
        this.hash.write(byArray, n, n2);
    }

    protected void updateHash(byte by) {
        this.hash.write(by);
    }

    protected byte[] getHash() {
        return this.hash.getHashAsBytes();
    }
}

