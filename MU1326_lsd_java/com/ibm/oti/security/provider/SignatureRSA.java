/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.PKCS1;
import com.ibm.oti.security.provider.RSAPrivateCrtKey;
import com.ibm.oti.security.provider.RSAPrivateKey;
import com.ibm.oti.security.provider.RSAPublicKey;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public abstract class SignatureRSA
extends Signature {
    protected static final int STATE_UNINITIALIZED = 0;
    protected static final int STATE_SIGN = 1;
    protected static final int STATE_VERIFY = 2;
    protected static final String[] STATE_DESCRIPTION = new String[]{"UNINITIALIZED", "SIGN", "VERIFY"};
    protected RSAPrivateKey privateKey;
    protected RSAPublicKey publicKey;
    protected int state = 0;
    protected String digestAlgorithmName;
    protected PKCS1 rsaEngine = null;

    public SignatureRSA(String string) {
        super(String.valueOf(string) + "with" + "RSA");
        this.digestAlgorithmName = string;
        this.rsaEngine = new PKCS1(string);
    }

    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof java.security.interfaces.RSAPrivateCrtKey) {
            this.privateKey = new RSAPrivateCrtKey((java.security.interfaces.RSAPrivateCrtKey)privateKey);
        } else if (privateKey instanceof java.security.interfaces.RSAPrivateKey) {
            this.privateKey = new RSAPrivateKey((RSAPrivateKey)privateKey);
        } else {
            throw new InvalidKeyException(Msg.getString("K00a5", privateKey));
        }
        this.state = 1;
        this.resetHash();
    }

    protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        boolean bl = true;
        if (publicKey != null) {
            try {
                this.publicKey = new RSAPublicKey((java.security.interfaces.RSAPublicKey)publicKey);
            }
            catch (ClassCastException classCastException) {
                bl = false;
            }
        } else {
            bl = false;
        }
        if (!bl) {
            throw new InvalidKeyException(Msg.getString("K00a5", publicKey));
        }
        this.state = 2;
        this.resetHash();
    }

    protected byte[] engineSign() throws SignatureException {
        try {
            byte[] byArray = this.rsaEngine.signSSA_PKCS1_v15Impl(this.privateKey, this.getHash());
            this.resetHash();
            return byArray;
        }
        catch (IOException iOException) {
            throw new SignatureException(iOException.getMessage());
        }
    }

    protected void engineUpdate(byte by) throws SignatureException {
        this.updateHash(by);
    }

    protected void engineUpdate(byte[] byArray, int n, int n2) throws SignatureException {
        this.updateHash(byArray, n, n2);
    }

    protected boolean engineVerify(byte[] byArray) throws SignatureException {
        int n = this.publicKey.getModulus().bitLength();
        int n2 = (int)Math.ceil((double)n / 8.0);
        n2 = Math.min(byArray.length, n2);
        byte[] byArray2 = new byte[n2];
        System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, n2);
        boolean bl = this.rsaEngine.verifySSA_PKCS1_v15Impl(this.publicKey, this.getHash(), byArray2);
        this.resetHash();
        return bl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(" RSA Signature (");
        stringBuffer.append(STATE_DESCRIPTION[this.state]);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    protected abstract void resetHash();

    protected abstract void updateHash(byte[] var1, int var2, int var3);

    protected abstract void updateHash(byte var1);

    protected abstract byte[] getHash();
}

