/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.SignatureRSA;
import com.ibm.oti.util.SHAOutputStream;

public class SignatureSHA1withRSA
extends SignatureRSA {
    private SHAOutputStream hash = new SHAOutputStream();

    public SignatureSHA1withRSA() {
        super("SHA1");
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

