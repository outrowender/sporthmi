/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.spec.DSAParameterSpec;
import java.util.Arrays;

public class DSAPublicKey
implements java.security.interfaces.DSAPublicKey {
    static final String ENCODING_FORMAT = "X.509";
    private DSAParams parametersDSA;
    private BigInteger y;
    private byte[] encoded;
    static final int[] OID = new int[]{1, 2, 840, 10040, 4, 1};
    static final int[] OIDalt = new int[]{1, 3, 14, 3, 2, 12};

    public BigInteger getY() {
        return this.y;
    }

    public DSAParams getParams() {
        return this.parametersDSA;
    }

    public String getAlgorithm() {
        return "DSA";
    }

    byte[] keyToX509Encoding() throws ASN1Exception {
        Object object;
        Object[] objectArray;
        Object[] objectArray2 = new Object[2];
        objectArray2[0] = objectArray = new Object[2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
        aSN1Encoder.writeObject(this.getY());
        objectArray2[1] = new ASN1Decoder.BitString(0, byteArrayOutputStream.toByteArray());
        objectArray[0] = OID;
        if (this.parametersDSA != null) {
            object = new Object[]{this.parametersDSA.getP(), this.parametersDSA.getQ(), this.parametersDSA.getG()};
            objectArray[1] = object;
        }
        object = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder2 = new ASN1Encoder((OutputStream)object);
        aSN1Encoder2.writeObject(objectArray2);
        return ((ByteArrayOutputStream)object).toByteArray();
    }

    public ASN1Decoder.Node toASN1Node() {
        ASN1Decoder.Node[] nodeArray;
        ASN1Decoder.Node[] nodeArray2;
        ASN1Decoder.Node node = new ASN1Decoder.Node();
        node.type = 16;
        node.data = nodeArray2 = new ASN1Decoder.Node[2];
        ASN1Decoder.Node[] nodeArray3 = null;
        if (this.parametersDSA != null) {
            nodeArray = new ASN1Decoder.Node();
            nodeArray.type = 16;
            nodeArray.data = nodeArray3 = new ASN1Decoder.Node[3];
            nodeArray3[0] = new ASN1Decoder.Node();
            nodeArray3[0].type = 2;
            nodeArray3[0].data = this.parametersDSA.getP();
            nodeArray3[1] = new ASN1Decoder.Node();
            nodeArray3[1].type = 2;
            nodeArray3[1].data = this.parametersDSA.getQ();
            nodeArray3[2] = new ASN1Decoder.Node();
            nodeArray3[2].type = 2;
            nodeArray3[2].data = this.parametersDSA.getG();
        }
        nodeArray2[0] = new ASN1Decoder.Node();
        nodeArray2[0].type = 16;
        nodeArray2[0].data = nodeArray = new ASN1Decoder.Node[2];
        nodeArray[0] = new ASN1Decoder.Node();
        nodeArray[0].type = 6;
        nodeArray[0].data = OID;
        nodeArray[1] = new ASN1Decoder.Node();
        if (nodeArray3 != null) {
            nodeArray[1].type = 16;
            nodeArray[1].data = nodeArray3;
        } else {
            nodeArray[1].type = 5;
        }
        ASN1Decoder.Node node2 = new ASN1Decoder.Node();
        node2.type = 2;
        node2.data = this.y;
        nodeArray2[1] = new ASN1Decoder.Node();
        nodeArray2[1].type = 3;
        nodeArray2[1].data = new ASN1Decoder.BitString(0, ASN1Encoder.encodeNode(node2));
        return node;
    }

    static Object[] decodeX509(byte[] byArray) throws ASN1Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
        Object[] objectArray = new Object[2];
        try {
            ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])aSN1Decoder.readContents().data;
            ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])nodeArray[0].data;
            if (!Arrays.equals(OID, (int[])nodeArray2[0].data) && !Arrays.equals(OIDalt, (int[])nodeArray2[0].data)) {
                throw new ASN1Exception();
            }
            ASN1Decoder.BitString bitString = (ASN1Decoder.BitString)nodeArray[1].data;
            byteArrayInputStream = new ByteArrayInputStream(bitString.data);
            aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
            objectArray[1] = (BigInteger)aSN1Decoder.readContents().data;
            ASN1Decoder.Node[] nodeArray3 = (ASN1Decoder.Node[])nodeArray2[1].data;
            if (nodeArray3 != null) {
                BigInteger bigInteger = (BigInteger)nodeArray3[0].data;
                BigInteger bigInteger2 = (BigInteger)nodeArray3[1].data;
                BigInteger bigInteger3 = (BigInteger)nodeArray3[2].data;
                objectArray[0] = new DSAParameterSpec(bigInteger, bigInteger2, bigInteger3);
            }
            return objectArray;
        }
        catch (ClassCastException classCastException) {
            throw new ASN1Exception();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new ASN1Exception();
        }
    }

    public byte[] getEncoded() {
        if (this.encoded == null) {
            try {
                this.encoded = this.keyToX509Encoding();
            }
            catch (ASN1Exception aSN1Exception) {}
        }
        return this.encoded;
    }

    public String getFormat() {
        return ENCODING_FORMAT;
    }

    public DSAPublicKey(DSAParams dSAParams, BigInteger bigInteger) {
        this.parametersDSA = dSAParams;
        this.y = bigInteger;
    }

    public String toString() {
        BigInteger bigInteger = this.parametersDSA.getP();
        BigInteger bigInteger2 = this.parametersDSA.getQ();
        BigInteger bigInteger3 = this.parametersDSA.getG();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getClass().getName());
        stringBuffer.append("\n\t");
        stringBuffer.append("Y: ");
        stringBuffer.append(this.getY().toString(16));
        stringBuffer.append("\n\t");
        stringBuffer.append("p: ");
        stringBuffer.append(bigInteger.toString(16));
        stringBuffer.append("\n\t");
        stringBuffer.append("q: ");
        stringBuffer.append(bigInteger2.toString(16));
        stringBuffer.append("\n\t");
        stringBuffer.append("g: ");
        stringBuffer.append(bigInteger3.toString(16));
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.getEncoded());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.encoded = (byte[])objectInputStream.readObject();
        Object[] objectArray = DSAPublicKey.decodeX509(this.encoded);
        this.parametersDSA = (DSAParameterSpec)objectArray[0];
        this.y = (BigInteger)objectArray[1];
    }

    public DSAPublicKey(byte[] byArray) throws IllegalArgumentException {
        this.encoded = byArray;
        try {
            Object[] objectArray = DSAPublicKey.decodeX509(byArray);
            this.parametersDSA = (DSAParameterSpec)objectArray[0];
            this.y = (BigInteger)objectArray[1];
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
    }
}

