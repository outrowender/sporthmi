/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.PKCS1;
import com.ibm.oti.security.provider.RSAPrivateKey;
import com.ibm.oti.security.provider.RSAPublicKey;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Arrays;

public class RSAPrivateCrtKey
extends RSAPrivateKey
implements java.security.interfaces.RSAPrivateCrtKey {
    private static final long serialVersionUID = -8013128276751145578L;
    protected BigInteger publicExponent;
    protected BigInteger p;
    protected BigInteger q;
    protected BigInteger dP;
    protected BigInteger dQ;
    protected BigInteger qInv;

    public RSAPrivateCrtKey(java.security.interfaces.RSAPrivateCrtKey rSAPrivateCrtKey) {
        super(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPrivateExponent());
        this.publicExponent = rSAPrivateCrtKey.getPublicExponent();
        this.p = rSAPrivateCrtKey.getPrimeP();
        this.q = rSAPrivateCrtKey.getPrimeQ();
        this.dP = rSAPrivateCrtKey.getPrimeExponentP();
        this.dQ = rSAPrivateCrtKey.getPrimeExponentQ();
        this.qInv = rSAPrivateCrtKey.getCrtCoefficient();
    }

    public RSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        super(rSAPrivateCrtKeySpec.getModulus(), rSAPrivateCrtKeySpec.getPrivateExponent());
        this.publicExponent = rSAPrivateCrtKeySpec.getPublicExponent();
        this.p = rSAPrivateCrtKeySpec.getPrimeP();
        this.q = rSAPrivateCrtKeySpec.getPrimeQ();
        this.dP = rSAPrivateCrtKeySpec.getPrimeExponentP();
        this.dQ = rSAPrivateCrtKeySpec.getPrimeExponentQ();
        this.qInv = rSAPrivateCrtKeySpec.getCrtCoefficient();
    }

    public RSAPrivateCrtKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(bigInteger, bigInteger3);
        this.publicExponent = bigInteger2;
        this.p = bigInteger4;
        this.q = bigInteger5;
        this.dP = bigInteger6;
        this.dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public RSAPrivateCrtKey(PKCS8EncodedKeySpec pKCS8EncodedKeySpec) throws InvalidKeySpecException {
        this.encoded = pKCS8EncodedKeySpec.getEncoded();
        try {
            this.decodeFromPKCS8();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new InvalidKeySpecException(illegalArgumentException.getMessage());
        }
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public BigInteger getPrimeP() {
        return this.p;
    }

    public BigInteger getPrimeQ() {
        return this.q;
    }

    public BigInteger getPrimeExponentP() {
        return this.dP;
    }

    public BigInteger getPrimeExponentQ() {
        return this.dQ;
    }

    public BigInteger getCrtCoefficient() {
        return this.qInv;
    }

    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public BigInteger getModulus() {
        return this.p.multiply(this.q);
    }

    public String getAlgorithm() {
        return "RSA";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public byte[] getEncoded() {
        if (this.encoded == null) {
            this.encodeToPKCS8();
        }
        return this.encoded;
    }

    public RSAPrivateKeySpec toKeySpec() {
        return new RSAPrivateCrtKeySpec(this.modulus, this.publicExponent, this.privateExponent, this.p, this.q, this.dP, this.dQ, this.qInv);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getClass().getName());
        RSAPublicKey.writeParamString(this.modulus, "modulus (n)", stringBuffer);
        RSAPublicKey.writeParamString(this.publicExponent, "public exponent (e)", stringBuffer);
        RSAPublicKey.writeParamString(this.privateExponent, "private exponent (d)", stringBuffer);
        RSAPublicKey.writeParamString(this.p, "prime P (P)", stringBuffer);
        RSAPublicKey.writeParamString(this.q, "prime Q (Q)", stringBuffer);
        RSAPublicKey.writeParamString(this.dP, "prime exponent P (dP)", stringBuffer);
        RSAPublicKey.writeParamString(this.dQ, "prime exponent Q (dQ)", stringBuffer);
        RSAPublicKey.writeParamString(this.qInv, "CRT coefficient (qInv)", stringBuffer);
        return stringBuffer.toString();
    }

    private void encodeToPKCS8() {
        ASN1Decoder.Node[] nodeArray;
        ASN1Decoder.Node node = new ASN1Decoder.Node();
        node.type = 16;
        node.data = nodeArray = new ASN1Decoder.Node[9];
        int n = 0;
        while (n < nodeArray.length) {
            nodeArray[n] = new ASN1Decoder.Node();
            nodeArray[n].type = 2;
            switch (n) {
                case 0: {
                    nodeArray[n].data = BigInteger.ZERO;
                    break;
                }
                case 1: {
                    nodeArray[n].data = this.modulus;
                    break;
                }
                case 2: {
                    nodeArray[n].data = this.publicExponent;
                    break;
                }
                case 3: {
                    nodeArray[n].data = this.privateExponent;
                    break;
                }
                case 4: {
                    nodeArray[n].data = this.p;
                    break;
                }
                case 5: {
                    nodeArray[n].data = this.q;
                    break;
                }
                case 6: {
                    nodeArray[n].data = this.dP;
                    break;
                }
                case 7: {
                    nodeArray[n].data = this.dQ;
                    break;
                }
                case 8: {
                    nodeArray[n].data = this.qInv;
                }
            }
            ++n;
        }
        byte[] byArray = ASN1Encoder.encodeNode(node);
        ASN1Decoder.Node node2 = new ASN1Decoder.Node();
        node2.type = 16;
        node2.data = nodeArray = new ASN1Decoder.Node[3];
        nodeArray[0] = new ASN1Decoder.Node();
        nodeArray[0].type = 2;
        nodeArray[0].data = BigInteger.ZERO;
        nodeArray[1] = new ASN1Decoder.Node();
        nodeArray[1].type = 16;
        nodeArray[1].data = new ASN1Decoder.Node[2];
        ((ASN1Decoder.Node[])nodeArray[1].data)[0] = new ASN1Decoder.Node();
        ((ASN1Decoder.Node[])nodeArray[1].data)[0].type = 6;
        ((ASN1Decoder.Node[])nodeArray[1].data)[0].data = PKCS1.OID_RSA;
        ((ASN1Decoder.Node[])nodeArray[1].data)[1] = new ASN1Decoder.Node();
        ((ASN1Decoder.Node[])nodeArray[1].data)[1].type = 5;
        ((ASN1Decoder.Node[])nodeArray[1].data)[1].data = null;
        nodeArray[2] = new ASN1Decoder.Node();
        nodeArray[2].type = 4;
        nodeArray[2].data = byArray;
        this.encoded = ASN1Encoder.encodeNode(node2);
    }

    protected void decodeFromPKCS8() throws IllegalArgumentException {
        try {
            ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(this.encoded));
            ASN1Decoder.Node node = aSN1Decoder.readContents();
            ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node.data;
            if (!((BigInteger)nodeArray[0].data).equals(BigInteger.ZERO)) {
                throw new IllegalArgumentException();
            }
            int[] nArray = (int[])((ASN1Decoder.Node[])nodeArray[1].data)[0].data;
            if (!Arrays.equals(nArray, PKCS1.OID_RSA)) {
                throw new IllegalArgumentException();
            }
            byte[] byArray = (byte[])nodeArray[2].data;
            aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray));
            ASN1Decoder.Node node2 = aSN1Decoder.readContents();
            nodeArray = (ASN1Decoder.Node[])node2.data;
            int n = 0;
            while (n < nodeArray.length) {
                switch (n) {
                    case 0: {
                        if (((BigInteger)nodeArray[n].data).equals(BigInteger.ZERO)) break;
                        throw new IllegalArgumentException();
                    }
                    case 1: {
                        this.modulus = (BigInteger)nodeArray[n].data;
                        break;
                    }
                    case 2: {
                        this.publicExponent = (BigInteger)nodeArray[n].data;
                        break;
                    }
                    case 3: {
                        this.privateExponent = (BigInteger)nodeArray[n].data;
                        break;
                    }
                    case 4: {
                        this.p = (BigInteger)nodeArray[n].data;
                        break;
                    }
                    case 5: {
                        this.q = (BigInteger)nodeArray[n].data;
                        break;
                    }
                    case 6: {
                        this.dP = (BigInteger)nodeArray[n].data;
                        break;
                    }
                    case 7: {
                        this.dQ = (BigInteger)nodeArray[n].data;
                        break;
                    }
                    case 8: {
                        this.qInv = (BigInteger)nodeArray[n].data;
                    }
                }
                ++n;
            }
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
        catch (ClassCastException classCastException) {
            throw new IllegalArgumentException();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new IllegalArgumentException();
        }
    }

    protected RSAPrivateCrtKey() {
    }
}

