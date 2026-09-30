/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

public abstract class HashingAlgorithm {
    public abstract int getHashSize();

    public abstract byte[] hashSSL(byte[] var1);

    public abstract byte[] hashTLS(byte[] var1, byte[] var2);

    public abstract byte[] getPad1();

    public abstract byte[] getPad2();
}

