/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.HashingAlgorithm;

public class HashingAlgorithmNull
extends HashingAlgorithm {
    public int getHashSize() {
        return 0;
    }

    public byte[] getPad1() {
        return new byte[0];
    }

    public byte[] getPad2() {
        return new byte[0];
    }

    public byte[] hashSSL(byte[] byArray) {
        return new byte[0];
    }

    public byte[] hashTLS(byte[] byArray, byte[] byArray2) {
        return new byte[0];
    }
}

