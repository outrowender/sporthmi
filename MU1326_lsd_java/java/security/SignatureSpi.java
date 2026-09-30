/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;

public abstract class SignatureSpi {
    protected SecureRandom appRandom;

    public Object clone() throws CloneNotSupportedException {
        SignatureSpi signatureSpi = (SignatureSpi)super.clone();
        try {
            signatureSpi.appRandom = (SecureRandom)this.appRandom.getClass().newInstance();
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new CloneNotSupportedException();
        }
        catch (InstantiationException instantiationException) {
            throw new CloneNotSupportedException();
        }
        return signatureSpi;
    }

    protected abstract void engineInitSign(PrivateKey var1) throws InvalidKeyException;

    protected void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.appRandom = secureRandom;
        this.engineInitSign(privateKey);
    }

    protected abstract void engineInitVerify(PublicKey var1) throws InvalidKeyException;

    protected void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        throw new UnsupportedOperationException();
    }

    protected AlgorithmParameters engineGetParameters() {
        throw new UnsupportedOperationException();
    }

    protected abstract byte[] engineSign() throws SignatureException;

    protected int engineSign(byte[] byArray, int n, int n2) throws SignatureException {
        byte[] byArray2 = this.engineSign();
        if (n2 < byArray2.length) {
            throw new SignatureException();
        }
        System.arraycopy((Object)byArray2, 0, (Object)byArray, n, byArray2.length);
        return byArray2.length;
    }

    protected abstract void engineUpdate(byte[] var1, int var2, int var3) throws SignatureException;

    protected abstract void engineUpdate(byte var1) throws SignatureException;

    protected abstract boolean engineVerify(byte[] var1) throws SignatureException;

    protected boolean engineVerify(byte[] byArray, int n, int n2) throws SignatureException {
        byte[] byArray2 = new byte[n2];
        System.arraycopy((Object)byArray, n, (Object)byArray2, 0, n2);
        return this.engineVerify(byArray2);
    }
}

