/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.oti.security.provider.ASN1OID;
import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.security.provider.X509CRL;
import com.ibm.oti.security.provider.X509CertImpl;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.OIDDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Principal;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class PKCS7 {
    private ASN1Decoder decoder;
    private ASN1Decoder.Node contents;
    private byte[] encoded;
    static final int[] DATA_OID = new int[]{1, 2, 840, 113549, 1, 7, 1};
    static final int[] SIGNED_DATA_OID = new int[]{1, 2, 840, 113549, 1, 7, 2};
    static final int[] ENVELOPED_DATA_OID = new int[]{1, 2, 840, 113549, 1, 7, 3};
    static final int[] SIGNED_AND_ENVELOPED_DATA_OID = new int[]{1, 2, 840, 113549, 1, 7, 4};
    static final int[] DIGESTED_DATA_OID = new int[]{1, 2, 840, 113549, 1, 7, 5};
    static final int[] ENCRYPTED_DATA_OID = new int[]{1, 2, 840, 113549, 1, 7, 6};
    static final int[][] POSSIBLE_CONTENTS = new int[6][];

    static {
        PKCS7.POSSIBLE_CONTENTS[0] = DATA_OID;
        PKCS7.POSSIBLE_CONTENTS[1] = SIGNED_DATA_OID;
        PKCS7.POSSIBLE_CONTENTS[2] = ENVELOPED_DATA_OID;
        PKCS7.POSSIBLE_CONTENTS[3] = SIGNED_AND_ENVELOPED_DATA_OID;
        PKCS7.POSSIBLE_CONTENTS[4] = DIGESTED_DATA_OID;
        PKCS7.POSSIBLE_CONTENTS[5] = ENCRYPTED_DATA_OID;
    }

    public static ASN1Decoder decoder(InputStream inputStream) {
        ASN1Decoder aSN1Decoder = new ASN1Decoder(inputStream);
        ASN1Decoder.TypeMapper typeMapper = new ASN1Decoder.TypeMapper(){

            public int map(int n, int n2, int n3) {
                if (n == 0) {
                    return 16;
                }
                return n;
            }
        };
        aSN1Decoder.configureTypeRedirection(1, typeMapper);
        typeMapper = new ASN1Decoder.TypeMapper(){

            public int map(int n, int n2, int n3) {
                if (n == 0 || n == 1) {
                    return 17;
                }
                return n;
            }
        };
        aSN1Decoder.configureTypeRedirection(3, typeMapper);
        typeMapper = new ASN1Decoder.TypeMapper(){

            public int map(int n, int n2, int n3) {
                if (n == 0) {
                    return 16;
                }
                return n;
            }
        };
        aSN1Decoder.configureTypeRedirection(4, typeMapper);
        typeMapper = new ASN1Decoder.TypeMapper(){

            public int map(int n, int n2, int n3) {
                if (n == 0 && n3 == 4) {
                    return 17;
                }
                if (n == 0) {
                    return 16;
                }
                return n;
            }
        };
        aSN1Decoder.configureTypeRedirection(5, typeMapper);
        aSN1Decoder.configureTypeRedirection(6, X509CertImpl.X509_MAPPER);
        return aSN1Decoder;
    }

    public static byte[] encodeCertList(List list) throws ASN1Exception {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3;
        Object[] objectArray4 = new Object[list.size()];
        int n = 0;
        Object object = list.iterator();
        while (object.hasNext()) {
            try {
                objectArray3 = (Object[])object.next();
                objectArray2 = objectArray3.getEncoded();
                objectArray = new ASN1Decoder.Data((byte[])objectArray2);
                objectArray4[n++] = objectArray;
            }
            catch (CertificateEncodingException certificateEncodingException) {
                return null;
            }
        }
        object = new ASN1Decoder.CertificateSet(objectArray4);
        objectArray3 = new Object[]{BigInteger.ONE, new ASN1Decoder.Set2(new Object[0]), DATA_OID, object, new ASN1Decoder.Set2(new Object[0])};
        objectArray2 = new Object[1];
        objectArray2[0] = (byte)objectArray3;
        objectArray = new Object[]{SIGNED_DATA_OID, objectArray2};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
        aSN1Encoder.writeObject(objectArray);
        byte[] byArray = byteArrayOutputStream.toByteArray();
        return byArray;
    }

    public static byte[] getASN1DEREncoded(Certificate[] certificateArray, String string, String string2, byte[] byArray) throws IOException {
        return PKCS7.getASN1DEREncoded(certificateArray, string, string2, byArray, true, null, null);
    }

    public static byte[] getASN1DEREncoded(Certificate[] certificateArray, String string, String string2, byte[] byArray, boolean bl, byte[] byArray2, ASN1Decoder.Set2 set2) throws IOException {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3;
        Object[] objectArray4 = new Object[certificateArray.length];
        int n = 0;
        while (n < certificateArray.length) {
            try {
                objectArray3 = certificateArray[n];
                objectArray2 = objectArray3.getEncoded();
                objectArray = new ASN1Decoder.Data((byte[])objectArray2);
                objectArray4[n] = objectArray;
            }
            catch (CertificateEncodingException certificateEncodingException) {
                return null;
            }
            ++n;
        }
        ASN1Decoder.CertificateSet certificateSet = new ASN1Decoder.CertificateSet(objectArray4);
        objectArray3 = null;
        objectArray3 = bl ? new Object[5] : new Object[4];
        objectArray3[0] = BigInteger.ONE;
        objectArray2 = new Object[2];
        objectArray2[0] = (byte)PKCS7.algorithmNameToOID(string);
        objectArray2[1] = (byte)null;
        objectArray3[1] = new ASN1Decoder.Set2(new Object[]{objectArray2});
        objectArray = null;
        if (byArray2 == null) {
            objectArray = new Object[]{DATA_OID};
        } else {
            objectArray = new Object[2];
            objectArray[0] = DATA_OID;
            ASN1Decoder.Explicit explicit = new ASN1Decoder.Explicit(byArray2);
            objectArray[1] = explicit;
        }
        objectArray3[2] = objectArray;
        int n2 = 3;
        if (bl) {
            objectArray3[3] = certificateSet;
            n2 = 4;
        }
        java.security.cert.X509Certificate x509Certificate = null;
        if (certificateArray == null || certificateArray.length <= 0) {
            return null;
        }
        x509Certificate = (java.security.cert.X509Certificate)certificateArray[0];
        byte[] byArray3 = SignerInfo.getASN1DEREncoded(x509Certificate, string, string2, byArray, set2);
        objectArray3[n2] = new ASN1Decoder.Set2(new Object[]{new ASN1Decoder.Data(byArray3)});
        Object[] objectArray5 = new Object[]{objectArray3};
        Object[] objectArray6 = new Object[]{SIGNED_DATA_OID, objectArray5};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
        aSN1Encoder.writeObject(objectArray6);
        byte[] byArray4 = byteArrayOutputStream.toByteArray();
        return byArray4;
    }

    static int[] algorithmNameToOID(String string) {
        String string2 = OIDDatabase.getInstance().getFirstOIDForAlgorithm(string);
        return ASN1OID.stringToIntOID(string2);
    }

    public PKCS7(InputStream inputStream) {
        this.decoder = PKCS7.decoder(inputStream);
        try {
            this.decoder.collectBytes(true);
            this.contents = this.decoder.readContents();
            this.encoded = this.decoder.collectedBytes();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
        if (!this.contentsIsPKCS7()) {
            throw new IllegalArgumentException();
        }
    }

    public PKCS7(byte[] byArray) throws IllegalArgumentException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        this.decoder = PKCS7.decoder(byteArrayInputStream);
        try {
            this.contents = this.decoder.readContents();
            this.encoded = byArray;
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
        if (!this.contentsIsPKCS7()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isSignedData() {
        try {
            ASN1Decoder.Node node = this.contents.subnode(0);
            if (node == null) {
                return false;
            }
            int[] nArray = (int[])node.data;
            return Arrays.equals(SIGNED_DATA_OID, nArray);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public SignedData signedData() {
        try {
            if (!this.isSignedData()) {
                return null;
            }
            int[] nArray = new int[2];
            nArray[0] = 1;
            int[] nArray2 = nArray;
            return new SignedData((ASN1Decoder.Node)this.contents.subnode(nArray2), this.encoded);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return null;
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    public ASN1Decoder.Node contents() {
        return this.contents;
    }

    boolean contentsIsPKCS7() {
        int[] nArray = null;
        try {
            ASN1Decoder.Node node = this.contents.subnode(0);
            if (node == null) {
                return false;
            }
            nArray = (int[])node.data;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        int n = 0;
        while (n < POSSIBLE_CONTENTS.length) {
            if (Arrays.equals(POSSIBLE_CONTENTS[n], nArray)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public static ASN1Decoder.Set2 getSignedAttributes(byte[] byArray, String string) {
        byte[] byArray2 = byArray;
        byte[] byArray3 = null;
        if (string.equals("SHA")) {
            byArray3 = new byte[20];
            CL3.sha(null, byArray2, 0, byArray2.length, byArray3, 0);
        } else if (string.equals("MD5")) {
            byArray3 = new byte[16];
            CL3.md5(null, byArray2, 0, byArray2.length, byArray3, 0);
        }
        Object[] objectArray = new Object[2];
        Object[] objectArray2 = new Object[]{DATA_OID};
        objectArray[0] = ASN1OID.stringToIntOID("1.2.840.113549.1.9.3");
        objectArray[1] = new ASN1Decoder.Set2(objectArray2);
        Object[] objectArray3 = new Object[2];
        Object[] objectArray4 = new Object[]{byArray3};
        objectArray3[0] = ASN1OID.stringToIntOID("1.2.840.113549.1.9.4");
        objectArray3[1] = new ASN1Decoder.Set2(objectArray4);
        Object[] objectArray5 = new Object[2];
        Object[] objectArray6 = new Object[]{new ASN1Decoder.UTCTime(new Date())};
        objectArray5[0] = ASN1OID.stringToIntOID("1.2.840.113549.1.9.5");
        objectArray5[1] = new ASN1Decoder.Set2(objectArray6);
        return new ASN1Decoder.Set2(new Object[]{objectArray, objectArray3, objectArray5});
    }

    public static byte[] encodeSignedAttributesForDigest(ASN1Decoder.Set2 set2) {
        byte[] byArray = ASN1Encoder.getEncoding(set2);
        return byArray;
    }

    public static class SignedData {
        private ASN1Decoder.Node contents;
        private byte[] encoded;

        SignedData(ASN1Decoder.Node node, byte[] byArray) {
            this.contents = node;
            this.encoded = byArray;
        }

        public SignerInfo[] signerInfos() {
            try {
                ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])this.contents.data;
                ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])nodeArray[nodeArray.length - 1].data;
                SignerInfo[] signerInfoArray = new SignerInfo[nodeArray2.length];
                int n = 0;
                while (n < nodeArray2.length) {
                    signerInfoArray[n] = new SignerInfo(nodeArray2[n]);
                    ++n;
                }
                return signerInfoArray;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return null;
            }
            catch (ClassCastException classCastException) {
                return null;
            }
        }

        public Vector certificates() throws CertificateException {
            Vector vector = new Vector();
            try {
                ASN1Decoder.Node node = ((ASN1Decoder.Node[])this.contents.data)[3];
                if (node.originalType != 0) {
                    return vector;
                }
                ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node.data;
                int n = 0;
                while (n < nodeArray.length) {
                    vector.add(X509Certificate.certificateFromASN1Object(nodeArray[n], this.encoded));
                    ++n;
                }
                return vector;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return vector;
            }
            catch (ClassCastException classCastException) {
                return vector;
            }
        }

        public Vector CRLs() throws CRLException {
            Vector vector = new Vector();
            try {
                ASN1Decoder.Node node = ((ASN1Decoder.Node[])this.contents.data)[3];
                if (node.originalType != 1) {
                    node = ((ASN1Decoder.Node[])this.contents.data)[4];
                    if (node.originalType != 1) {
                        return vector;
                    }
                }
                ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node.data;
                int n = 0;
                while (n < nodeArray.length) {
                    vector.add(X509CRL.CRLFromASN1Object(nodeArray[n], this.encoded));
                    ++n;
                }
                return vector;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return vector;
            }
            catch (ClassCastException classCastException) {
                return vector;
            }
        }
    }

    public static class SignerInfo {
        private ASN1Decoder.Node contents;
        private Principal issuer = null;
        private BigInteger serialNumber = null;
        private static final int[] ATTRIBUTE_MESSAGE_DIGEST = new int[]{1, 2, 840, 113549, 1, 9, 4};
        private ASN1Decoder.Set2 signedAttributes = null;
        private String digestAlgorithmName;
        private String encryptionAlgorithmName;
        private byte[] encryptedDigest;

        SignerInfo(ASN1Decoder.Node node) {
            this.contents = node;
        }

        public byte[] encryptedDigest() {
            try {
                ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])this.contents.data;
                int n = 0;
                while (nodeArray[n].type != 4) {
                    ++n;
                }
                return (byte[])nodeArray[n].data;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return null;
            }
            catch (ClassCastException classCastException) {
                return null;
            }
        }

        public String digestEncryptionAlgorithm() {
            int[] nArray = this.digestEncryptionAlgorithmOID();
            if (nArray == null) {
                return null;
            }
            String string = ASN1OID.OIDToString(nArray);
            return X509Certificate.getAlias("Alg.Alias.KeyFactory.", string, null);
        }

        public String digestAlgorithm() {
            int[] nArray = this.digestAlgorithmOID();
            if (nArray == null) {
                return null;
            }
            String string = ASN1OID.OIDToString(nArray);
            return X509Certificate.getAlias("Alg.Alias.MessageDigest.", string, null);
        }

        public int[] digestEncryptionAlgorithmOID() {
            try {
                ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])this.contents.data;
                int n = 0;
                while (nodeArray[n].type != 4) {
                    ++n;
                }
                ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])nodeArray[--n].data;
                return (int[])nodeArray2[0].data;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return null;
            }
            catch (ClassCastException classCastException) {
                return null;
            }
        }

        public int[] digestAlgorithmOID() {
            try {
                ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])this.contents.data;
                ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])nodeArray[2].data;
                return (int[])nodeArray2[0].data;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return null;
            }
            catch (ClassCastException classCastException) {
                return null;
            }
        }

        public String signatureName() {
            String string = this.digestAlgorithm();
            String string2 = this.digestEncryptionAlgorithm();
            if (string == null || string2 == null) {
                return null;
            }
            return String.valueOf(string) + "with" + string2;
        }

        public ASN1Decoder.Node[] authenticatedAttributes() {
            ASN1Decoder.Node node = this.contents.subnodeWithOriginalType(0);
            if (node == null || node.data == null) {
                return new ASN1Decoder.Node[0];
            }
            return (ASN1Decoder.Node[])node.data;
        }

        public byte[] contentMessageDigest() {
            ASN1Decoder.Node[] nodeArray = this.authenticatedAttributes();
            int n = 0;
            while (n < nodeArray.length) {
                int[] nArray = (int[])nodeArray[n].subnode((int)0).data;
                if (Arrays.equals(nArray, ATTRIBUTE_MESSAGE_DIGEST)) {
                    ASN1Decoder.Node node = nodeArray[n].subnode(1).subnode(0);
                    return (byte[])node.data;
                }
                ++n;
            }
            return null;
        }

        public Principal getIssuer() {
            if (this.issuer == null) {
                X500Principal x500Principal = new X500Principal(this.contents.subnode(1).subnode(0));
                this.issuer = x500Principal;
            }
            return this.issuer;
        }

        public BigInteger getSerialNumber() {
            if (this.serialNumber == null) {
                this.serialNumber = (BigInteger)this.contents.subnode((int)1).subnode((int)1).data;
            }
            return this.serialNumber;
        }

        private SignerInfo(java.security.cert.X509Certificate x509Certificate, String string, String string2, byte[] byArray, ASN1Decoder.Set2 set2) {
            this.digestAlgorithmName = string;
            this.encryptionAlgorithmName = string2;
            this.encryptedDigest = byArray;
            this.signedAttributes = set2;
            this.issuer = x509Certificate.getIssuerDN();
            this.serialNumber = x509Certificate.getSerialNumber();
        }

        private byte[] getEncoded() throws IOException {
            Object[] objectArray;
            int n = 0;
            if (this.signedAttributes == null) {
                objectArray = new Object[5];
            } else {
                objectArray = new Object[6];
                n = 1;
            }
            objectArray[0] = BigInteger.ONE;
            Object[] objectArray2 = new Object[]{!(this.issuer instanceof X500Principal) ? new ASN1Decoder.Data(new X500Principal(this.issuer.getName()).getEncoded()) : new ASN1Decoder.Data(((X500Principal)this.issuer).getEncoded()), this.serialNumber};
            objectArray[1] = objectArray2;
            Object[] objectArray3 = new Object[]{PKCS7.algorithmNameToOID(this.digestAlgorithmName), null};
            objectArray[2] = objectArray3;
            if (this.signedAttributes != null) {
                objectArray[3] = new ASN1Decoder.ImplicitSet(this.signedAttributes, 0);
            }
            Object[] objectArray4 = new Object[]{PKCS7.algorithmNameToOID(this.encryptionAlgorithmName), null};
            objectArray[3 + n] = objectArray4;
            objectArray[4 + n] = this.encryptedDigest;
            byte[] byArray = ASN1Encoder.getEncoding(objectArray);
            return byArray;
        }

        public static byte[] getASN1DEREncoded(java.security.cert.X509Certificate x509Certificate, String string, String string2, byte[] byArray, ASN1Decoder.Set2 set2) throws IOException {
            return new SignerInfo(x509Certificate, string, string2, byArray, set2).getEncoded();
        }
    }
}

