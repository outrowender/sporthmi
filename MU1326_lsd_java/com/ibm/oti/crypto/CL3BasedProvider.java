/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.j9.bluez.crypto.CL3Key;
import com.ibm.oti.crypto.CL3BasedKey;
import com.ibm.oti.crypto.Key;
import com.ibm.oti.crypto.Provider;
import com.ibm.oti.crypto.Util;
import com.ibm.oti.util.Msg;
import java.io.IOException;

public abstract class CL3BasedProvider
extends Provider {
    int mode;
    byte[] iv;

    protected CL3BasedProvider(int n, int n2) {
        super(n, n2);
    }

    final void destroyKey(Key key) {
        if (key instanceof CL3BasedKey) {
            CL3BasedKey cL3BasedKey = (CL3BasedKey)key;
            cL3BasedKey.workingKey.dispose();
            cL3BasedKey.workingKey = null;
        }
    }

    final void cryptInit(Key key, int n, int n2, byte[] byArray) throws IOException {
        if (!(key instanceof CL3BasedKey)) {
            throw new IOException(Msg.getString("K01fa"));
        }
        this.mode = n;
        if (!this.isValidPadType(n2)) {
            throw new IOException(Msg.getString("K01f7"));
        }
        if (byArray == null || byArray.length != this.getIVLength()) {
            throw new IOException(Msg.getString("K01f6"));
        }
        this.iv = new byte[this.getIVLength()];
        System.arraycopy((Object)byArray, 0, (Object)this.iv, 0, this.getIVLength());
    }

    byte[] cryptUpdate(Key key, byte[] byArray, int n, int n2, boolean bl) throws IOException {
        if (!(key instanceof CL3BasedKey)) {
            throw new IOException(Msg.getString("K01fa"));
        }
        if (this.mode == 1) {
            return this.encryptImpl((CL3BasedKey)key, byArray, n, n2, bl);
        }
        return this.decryptImpl((CL3BasedKey)key, byArray, n, n2, bl);
    }

    boolean isValidPadType(int n) {
        return n == 4 || n == 3 || n == 2;
    }

    final byte[] encryptImpl(CL3BasedKey cL3BasedKey, byte[] byArray, int n, int n2, boolean bl) throws IOException {
        int n3 = n2 / this.getBlockLength();
        int n4 = n2 % this.getBlockLength();
        int n5 = n3 * this.getBlockLength();
        if (!bl && n4 != 0) {
            throw new IOException(Msg.getString("K0170"));
        }
        byte[] byArray2 = bl ? new byte[(n3 + 1) * this.getBlockLength()] : new byte[n5];
        this.cl3Call(cL3BasedKey.workingKey, 0, this.iv, 0, byArray, n, byArray2, 0, n5);
        if (bl) {
            byte[] byArray3 = null;
            switch (cL3BasedKey.padtype) {
                case 3: {
                    byArray3 = Util.padSSL(byArray, n + n5, n4, this.getBlockLength());
                    break;
                }
                case 4: {
                    byArray3 = Util.padTLS10(byArray, n + n5, n4, this.getBlockLength());
                    break;
                }
                case 2: {
                    byArray3 = Util.padPKCS5(byArray, n + n5, n4, this.getBlockLength());
                }
            }
            this.cl3Call(cL3BasedKey.workingKey, 0, this.iv, 0, byArray3, 0, byArray2, n5, this.getBlockLength());
        }
        return byArray2;
    }

    abstract void cl3Call(CL3Key var1, int var2, byte[] var3, int var4, byte[] var5, int var6, byte[] var7, int var8, int var9);

    final byte[] decryptImpl(CL3BasedKey cL3BasedKey, byte[] byArray, int n, int n2, boolean bl) throws IOException {
        if (n2 % this.getBlockLength() != 0) {
            throw new IOException(Msg.getString("K0170"));
        }
        int n3 = n2 / this.getBlockLength();
        int n4 = (n3 - 1) * this.getBlockLength();
        if (bl) {
            --n3;
        }
        byte[] byArray2 = new byte[n3 * this.getBlockLength()];
        this.cl3Call(cL3BasedKey.workingKey, 1, this.iv, 0, byArray, n, byArray2, 0, n3 * this.getBlockLength());
        if (bl) {
            byte[] byArray3 = new byte[this.getBlockLength()];
            this.cl3Call(cL3BasedKey.workingKey, 1, this.iv, 0, byArray, n + n4, byArray3, 0, this.getBlockLength());
            byte[] byArray4 = null;
            switch (cL3BasedKey.padtype) {
                case 4: {
                    byArray4 = Util.unpadTLS10(byArray3);
                    break;
                }
                case 3: {
                    byArray4 = Util.unpadSSL(byArray3);
                    break;
                }
                case 2: {
                    byArray4 = Util.unpadPKCS5(byArray3);
                }
            }
            return Util.concatenate(byArray2, byArray4);
        }
        return byArray2;
    }

    public abstract Key createKey(byte[] var1) throws IOException;
}

