/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.PKCS1;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAPublicKey
implements java.security.interfaces.RSAPublicKey {
    protected BigInteger modulus = null;
    protected BigInteger publicExponent = null;
    protected byte[] encoded = null;

    public RSAPublicKey(java.security.interfaces.RSAPublicKey rSAPublicKey) {
        this(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
    }

    public RSAPublicKey(RSAPublicKeySpec rSAPublicKeySpec) {
        this(rSAPublicKeySpec.getModulus(), rSAPublicKeySpec.getPublicExponent());
    }

    public RSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.modulus = bigInteger;
        this.publicExponent = bigInteger2;
    }

    public RSAPublicKey() {
    }

    public RSAPublicKey(X509EncodedKeySpec x509EncodedKeySpec) throws InvalidKeySpecException {
        this.encoded = x509EncodedKeySpec.getEncoded();
        try {
            this.decodeFromX509();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new InvalidKeySpecException();
        }
    }

    public RSAPublicKey(byte[] byArray) throws IllegalArgumentException {
        this.encoded = byArray;
        try {
            this.decodeFromX509();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
    }

    public String getAlgorithm() {
        return "RSA";
    }

    public byte[] getEncoded() {
        if (this.encoded == null) {
            this.encoded = ASN1Encoder.encodeNode(this.toASN1Node());
        }
        return this.encoded;
    }

    public String getFormat() {
        return "X.509";
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public RSAPublicKeySpec toKeySpec() {
        return new RSAPublicKeySpec(this.modulus, this.publicExponent);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getClass().getName());
        RSAPublicKey.writeParamString(this.modulus, "modulus (n)", stringBuffer);
        RSAPublicKey.writeParamString(this.publicExponent, "public exponent (e)", stringBuffer);
        return stringBuffer.toString();
    }

    public static void writeParamString(BigInteger bigInteger, String string, StringBuffer stringBuffer) {
        stringBuffer.append("\n\t");
        stringBuffer.append(string);
        stringBuffer.append(": ");
        String string2 = bigInteger.toString(16);
        int n = 0;
        while (n < string2.length()) {
            if (n % 64 == 0) {
                stringBuffer.append("\n\t\t");
            } else if (n % 8 == 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(string2.charAt(n));
            ++n;
        }
    }

    protected void decodeFromX509() throws ASN1Exception {
        ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(this.encoded));
        try {
            ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])aSN1Decoder.readContents().data;
            ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])nodeArray[0].data;
            int[] nArray = (int[])nodeArray2[0].data;
            int n = 0;
            while (n < PKCS1.OID_RSA.length) {
                if (n == nArray.length || nArray[n] != PKCS1.OID_RSA[n]) {
                    throw new ASN1Exception();
                }
                ++n;
            }
            ASN1Decoder.BitString bitString = (ASN1Decoder.BitString)nodeArray[1].data;
            aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(bitString.data));
            ASN1Decoder.Node[] nodeArray3 = (ASN1Decoder.Node[])aSN1Decoder.readContents().data;
            if (nodeArray3 == null || nodeArray3.length < 2) {
                throw new ASN1Exception();
            }
            this.modulus = (BigInteger)nodeArray3[0].data;
            this.publicExponent = (BigInteger)nodeArray3[1].data;
        }
        catch (ClassCastException classCastException) {
            throw new ASN1Exception();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new ASN1Exception();
        }
    }

    public ASN1Decoder.Node toASN1Node() {
        ASN1Decoder.Node[] nodeArray;
        ASN1Decoder.Node[] nodeArray2;
        ASN1Decoder.Node[] nodeArray3;
        ASN1Decoder.Node node = new ASN1Decoder.Node();
        node.type = 16;
        node.data = nodeArray3 = new ASN1Decoder.Node[2];
        nodeArray3[0] = new ASN1Decoder.Node();
        nodeArray3[0].type = 16;
        nodeArray3[0].data = nodeArray2 = new ASN1Decoder.Node[2];
        nodeArray2[0] = new ASN1Decoder.Node();
        nodeArray2[0].type = 6;
        nodeArray2[0].data = PKCS1.OID_RSA;
        nodeArray2[1] = new ASN1Decoder.Node();
        nodeArray2[1].type = 5;
        ASN1Decoder.Node node2 = new ASN1Decoder.Node();
        node2.type = 16;
        node2.data = nodeArray = new ASN1Decoder.Node[2];
        nodeArray[0] = new ASN1Decoder.Node();
        nodeArray[0].type = 2;
        nodeArray[0].data = this.modulus;
        nodeArray[1] = new ASN1Decoder.Node();
        nodeArray[1].type = 2;
        nodeArray[1].data = this.publicExponent;
        nodeArray3[1] = new ASN1Decoder.Node();
        nodeArray3[1].type = 3;
        nodeArray3[1].data = new ASN1Decoder.BitString(0, ASN1Encoder.encodeNode(node2));
        return node;
    }
}

