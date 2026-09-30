/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.RSAPublicKey;
import java.math.BigInteger;
import java.security.spec.RSAPrivateKeySpec;

public class RSAPrivateKey
implements java.security.interfaces.RSAPrivateKey {
    protected BigInteger modulus = null;
    protected BigInteger privateExponent = null;
    protected byte[] encoded = null;

    protected RSAPrivateKey() {
    }

    public RSAPrivateKey(java.security.interfaces.RSAPrivateKey rSAPrivateKey) {
        this(rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent());
    }

    public RSAPrivateKey(RSAPrivateKeySpec rSAPrivateKeySpec) {
        this(rSAPrivateKeySpec.getModulus(), rSAPrivateKeySpec.getPrivateExponent());
    }

    public RSAPrivateKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.modulus = bigInteger;
        this.privateExponent = bigInteger2;
    }

    public String getAlgorithm() {
        return "RSA";
    }

    public byte[] getEncoded() {
        return null;
    }

    public String getFormat() {
        return null;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public RSAPrivateKeySpec toKeySpec() {
        return new RSAPrivateKeySpec(this.modulus, this.privateExponent);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getClass().getName());
        RSAPublicKey.writeParamString(this.modulus, "modulus (n)", stringBuffer);
        RSAPublicKey.writeParamString(this.privateExponent, "private exponent (d)", stringBuffer);
        return stringBuffer.toString();
    }
}

