/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.oti.crypto.Provider;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Key {
    public static final int OPERATION_ENCRYPT = 1;
    public static final int OPERATION_DECRYPT = 2;
    public static final int PAD_NONE = 1;
    public static final int PAD_PKCS5 = 2;
    public static final int PAD_SSL = 3;
    public static final int PAD_TLS = 4;
    public static final int PAD_MIN = 1;
    public static final int PAD_MAX = 4;
    Provider provider;
    byte[] key;
    int operation;
    int padtype;
    private boolean cryptInit = false;
    private byte[] buffInput;
    private int buffInputCount = 0;
    private ByteArrayOutputStream buffOutput = new ByteArrayOutputStream();

    Key(Provider provider, byte[] byArray) throws IOException {
        if (provider.isDestroyed()) {
            throw new IOException(Msg.getString("K01f8"));
        }
        this.provider = provider;
        if (byArray.length != provider.getKeyLength()) {
            throw new IOException(Msg.getString("K01f9"));
        }
        this.key = byArray;
        this.buffInput = (byte[])(provider.getBlockLength() == 0 ? null : new byte[byArray.length]);
    }

    public void cryptInit(int n, int n2, byte[] byArray) throws IOException {
        if (n != 1 && n != 2) {
            throw new IOException(Msg.getString("K01fb"));
        }
        this.operation = n;
        if (n2 < 1 || n2 > 4) {
            throw new IOException(Msg.getString("K01f7"));
        }
        this.padtype = n2;
        this.provider.cryptInit(this, n, n2, byArray);
        this.cryptInit = true;
        this.buffInputCount = 0;
        this.buffOutput.reset();
    }

    public void cryptUpdate(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        if (!this.cryptInit) {
            throw new IllegalStateException();
        }
        if (this.buffInput != null && this.buffInputCount > 0 && n2 >= (n3 = this.buffInput.length - this.buffInputCount)) {
            System.arraycopy((Object)byArray, n, (Object)this.buffInput, this.buffInputCount, n3);
            this.buffOutput.write(this.provider.cryptUpdate(this, this.buffInput, 0, this.buffInput.length, false));
            n += n3;
            n2 -= n3;
            this.buffInputCount = 0;
        }
        if (this.provider.getBlockLength() > 0) {
            n3 = (n2 - 1) / this.provider.getBlockLength();
            if (n3 > 0) {
                this.buffOutput.write(this.provider.cryptUpdate(this, byArray, n, n3 * this.provider.getBlockLength() - n, false));
                n += n3 * this.provider.getBlockLength();
                n2 -= n3 * this.provider.getBlockLength();
            }
        } else {
            this.buffOutput.write(this.provider.cryptUpdate(this, byArray, n, n2 - n, false));
            n += n2;
            n2 -= n2;
        }
        if (n2 > 0) {
            System.arraycopy((Object)byArray, n, (Object)this.buffInput, this.buffInputCount, n2);
            this.buffInputCount += n2;
        }
    }

    public byte[] cryptFinish() throws IOException {
        if (this.buffInputCount > 0) {
            this.buffOutput.write(this.provider.cryptUpdate(this, this.buffInput, 0, this.buffInputCount, true));
        }
        this.cryptInit = false;
        return this.buffOutput.toByteArray();
    }
}

