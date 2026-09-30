/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.ASN1OID;
import com.ibm.oti.security.provider.UnparsedX509PublicKey;
import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.security.provider.X509Extension;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class X509CertImpl {
    byte[] encoded;
    int originalOffsetIntoRawBytes;
    ASN1Decoder.Node tbsNode;
    int version;
    BigInteger serialNumber;
    X500Principal issuer;
    X500Principal subject;
    Date notBefore;
    Date notAfter;
    String sigAlgOID;
    byte[] sigAlgParams;
    byte[] rawSignature;
    String signatureName;
    String signatureProviderName;
    String subjectAlgOID;
    ASN1Decoder.Node subjectPublicKeyASN1DER;
    PublicKey subjectPublicKey;
    boolean[] subjectUniqueID;
    boolean[] issuerUniqueID;
    Hashtable extensions;
    static final String extendedKeyUsageOID = "2.5.29.37";
    static final String subjectAltNamesOID = "2.5.29.17";
    static final String issuerAltNamesOID = "2.5.29.18";
    public static final Hashtable OID_DATABASE = new Hashtable(5);
    private static final String OID_BasicConstraints = "2.5.29.19";
    private static final String OID_KeyUsage = "2.5.29.15";
    private static final String[] SUPPORTED_CRITICAL_EXTENSIONS;
    protected static final ASN1Decoder.TypeMapper X509_MAPPER;
    static final Hashtable KEYALGORITHM_OID;
    static final Hashtable SIGNALGORITHM_OID;

    static {
        OID_DATABASE.put("1.2.840.113549.1.1.2", "MD2withRSA");
        OID_DATABASE.put("1.2.840.113549.1.1.4", "MD5withRSA");
        OID_DATABASE.put("1.2.840.113549.1.1.5", "SHA1withRSA");
        OID_DATABASE.put("1.2.840.10040.4.3", "SHA1withDSA");
        OID_DATABASE.put("1.3.14.3.2.26", "SHA");
        OID_DATABASE.put("1.2.840.113549.2.5", "MD5");
        OID_DATABASE.put("1.2.840.113549.1.1.1", "RSA");
        OID_DATABASE.put("1.2.840.10040.4.1", "DSA");
        OID_DATABASE.put("1.3.14.3.2.12", "DSA");
        OID_DATABASE.put("1.2.840.10046.2.1", "DiffieHellman");
        SUPPORTED_CRITICAL_EXTENSIONS = new String[]{OID_BasicConstraints, OID_KeyUsage};
        X509_MAPPER = new ASN1Decoder.TypeMapper(){

            public int map(int n, int n2, int n3) {
                switch (n) {
                    case 1: 
                    case 2: {
                        return 2;
                    }
                    case 0: 
                    case 3: {
                        return 16;
                    }
                }
                return n;
            }
        };
        KEYALGORITHM_OID = new Hashtable(7);
        KEYALGORITHM_OID.put("RSA", "1.2.840.113549.1.1.1");
        KEYALGORITHM_OID.put("DSA", "1.2.840.10040.4.1");
        KEYALGORITHM_OID.put("DiffieHellman", "1.2.840.10046.2.1");
        SIGNALGORITHM_OID = new Hashtable(7);
        SIGNALGORITHM_OID.put("MD2withRSA", "1.2.840.113549.1.1.2");
        SIGNALGORITHM_OID.put("MD5withRSA", "1.2.840.113549.1.1.4");
        SIGNALGORITHM_OID.put("SHA1withRSA", "1.2.840.113549.1.1.5");
        SIGNALGORITHM_OID.put("SHA1withDSA", "1.2.840.10040.4.3");
    }

    protected X509CertImpl() {
    }

    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.checkValidity(new Date());
    }

    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        if (date.getTime() < this.notBefore.getTime()) {
            String string = Msg.getString("K0328");
            throw new CertificateNotYetValidException(string);
        }
        if (date.getTime() > this.notAfter.getTime()) {
            String string = Msg.getString("K0329");
            throw new CertificateExpiredException(string);
        }
    }

    public int getBasicConstraints() {
        if (this.extensions == null) {
            return -1;
        }
        X509Extension x509Extension = (X509Extension)this.extensions.get(OID_BasicConstraints);
        if (x509Extension == null) {
            return -1;
        }
        byte[] byArray = x509Extension.value();
        if (byArray == null) {
            return -1;
        }
        ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray));
        try {
            ASN1Decoder.Node node = aSN1Decoder.readContents();
            ASN1Decoder.Node node2 = node.subnode(0);
            boolean bl = false;
            if (node2 == null) {
                return -1;
            }
            if (node2.type == 1) {
                bl = (Boolean)node2.data;
            }
            if (!bl) {
                return -1;
            }
            ASN1Decoder.Node node3 = node.subnode(Integer.MAX_VALUE);
            if (node3 == null) {
                return -1;
            }
            if (node3.type != 2) {
                return -2;
            }
            return ((BigInteger)node3.data).intValue();
        }
        catch (ASN1Exception aSN1Exception) {
        }
        catch (ClassCastException classCastException) {
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
        return -1;
    }

    public Principal getIssuerDN() {
        return this.issuer;
    }

    public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
        return new javax.security.auth.x500.X500Principal(this.issuer.getName());
    }

    public boolean[] getIssuerUniqueID() {
        return this.issuerUniqueID;
    }

    public boolean[] getKeyUsage() {
        if (this.extensions == null) {
            return null;
        }
        X509Extension x509Extension = (X509Extension)this.extensions.get(OID_KeyUsage);
        if (x509Extension == null) {
            return null;
        }
        byte[] byArray = x509Extension.value();
        if (byArray == null) {
            return null;
        }
        if (byArray.length < 1) {
            return null;
        }
        ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray));
        try {
            ASN1Decoder.Node node = aSN1Decoder.readContents();
            if (node.type != 3) {
                return null;
            }
            ASN1Decoder.BitString bitString = (ASN1Decoder.BitString)node.data;
            int n = bitString.bitLength();
            boolean[] blArray = new boolean[Math.max(n, 9)];
            int n2 = 0;
            while (n2 < n) {
                blArray[n2] = bitString.bitAt(n2);
                ++n2;
            }
            return blArray;
        }
        catch (ASN1Exception aSN1Exception) {
        }
        catch (ClassCastException classCastException) {
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
        return null;
    }

    public Date getNotAfter() {
        return this.notAfter;
    }

    public Date getNotBefore() {
        return this.notBefore;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public String getSigAlgName() {
        return this.signatureName;
    }

    public String getSigAlgOID() {
        return this.sigAlgOID;
    }

    public byte[] getSigAlgParams() {
        return this.sigAlgParams;
    }

    public byte[] getSignature() {
        return this.rawSignature;
    }

    public Principal getSubjectDN() {
        return this.subject;
    }

    public javax.security.auth.x500.X500Principal getSubjectX500Principal() {
        return new javax.security.auth.x500.X500Principal(this.subject.getName());
    }

    public boolean[] getSubjectUniqueID() {
        return this.subjectUniqueID;
    }

    public byte[] getTBSCertificate() throws CertificateEncodingException {
        byte[] byArray = new byte[this.tbsNode.endPosition - this.tbsNode.startPosition + 1];
        System.arraycopy((Object)this.encoded, this.tbsNode.startPosition - this.originalOffsetIntoRawBytes, (Object)byArray, 0, byArray.length);
        return byArray;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set set = this.getCriticalExtensionOIDs();
        if (set == null) {
            return false;
        }
        if (set.size() > SUPPORTED_CRITICAL_EXTENSIONS.length) {
            return true;
        }
        int n = 0;
        while (n < SUPPORTED_CRITICAL_EXTENSIONS.length) {
            set.remove(SUPPORTED_CRITICAL_EXTENSIONS[n]);
            ++n;
        }
        return set.size() != 0;
    }

    public Set getCriticalExtensionOIDs() {
        return this.getExtensionOIDs(true);
    }

    public Set getNonCriticalExtensionOIDs() {
        return this.getExtensionOIDs(false);
    }

    public byte[] getExtensionValue(String string) {
        if (this.extensions == null) {
            return null;
        }
        X509Extension x509Extension = (X509Extension)this.extensions.get(string);
        if (x509Extension == null) {
            return null;
        }
        byte[] byArray = x509Extension.value();
        if (byArray == null) {
            byArray = new byte[]{};
        }
        ASN1Decoder.Node node = new ASN1Decoder.Node();
        node.type = 4;
        node.data = x509Extension.value();
        return ASN1Encoder.encodeNode(node);
    }

    public List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] byArray = this.getExtensionValue(extendedKeyUsageOID);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
        ASN1Decoder.Node node = null;
        try {
            node = aSN1Decoder.readContents();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateParsingException();
        }
        byte[] byArray2 = (byte[])node.data;
        aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray2));
        try {
            node = aSN1Decoder.readContents();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateParsingException();
        }
        ArrayList arrayList = new ArrayList();
        ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node.data;
        int n = 0;
        while (n < nodeArray.length) {
            if (nodeArray[n].type != 6) {
                throw new CertificateParsingException();
            }
            int[] nArray = (int[])nodeArray[n].data;
            ASN1OID aSN1OID = new ASN1OID(nArray);
            arrayList.add(aSN1OID.toString());
            ++n;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return this.encoded;
    }

    public PublicKey getPublicKey() {
        return this.subjectPublicKey;
    }

    private byte[] getSubjectPublicKeyInfoAsBytes() {
        byte[] byArray = new byte[this.subjectPublicKeyASN1DER.endPosition - this.subjectPublicKeyASN1DER.startPosition + 1];
        System.arraycopy((Object)this.encoded, this.subjectPublicKeyASN1DER.startPosition - this.originalOffsetIntoRawBytes, (Object)byArray, 0, byArray.length);
        return byArray;
    }

    public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        if (this.signatureProviderName != null) {
            this.verify(publicKey, this.signatureProviderName);
        } else {
            if (this.signatureName == null) {
                throw new NoSuchAlgorithmException(this.sigAlgOID);
            }
            Signature signature = Signature.getInstance(this.signatureName);
            this.verify(publicKey, signature);
        }
    }

    public void verify(PublicKey publicKey, String string) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        if (this.signatureName == null) {
            throw new NoSuchAlgorithmException(this.sigAlgOID);
        }
        Signature signature = Signature.getInstance(this.signatureName, string);
        this.verify(publicKey, signature);
    }

    private void verify(PublicKey publicKey, Signature signature) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        signature.initVerify(publicKey);
        signature.update(this.getTBSCertificate());
        boolean bl = signature.verify(this.getSignature());
        if (!bl) {
            throw new SignatureException();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X.509 Certificate v");
        stringBuffer.append(this.getVersion());
        stringBuffer.append("\nSubjectDN: ");
        stringBuffer.append(this.getSubjectDN());
        stringBuffer.append("\n\tNot Before: ");
        stringBuffer.append(this.getNotBefore());
        stringBuffer.append("\n\tNot After: ");
        stringBuffer.append(this.getNotAfter());
        stringBuffer.append("\nIssuerDN: ");
        stringBuffer.append(this.getIssuerDN());
        stringBuffer.append("\nSerialNumber: ");
        stringBuffer.append(this.getSerialNumber().toString(16));
        stringBuffer.append("\nSigAlgName: ");
        stringBuffer.append(this.getSigAlgName());
        stringBuffer.append(", SigAlgOID: ");
        stringBuffer.append(this.getSigAlgOID());
        return stringBuffer.toString();
    }

    private void configureSignature(ASN1Decoder.Node[] nodeArray) {
        ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])nodeArray[1].data;
        ASN1Decoder.BitString bitString = (ASN1Decoder.BitString)nodeArray[2].data;
        this.rawSignature = bitString.data;
        this.sigAlgOID = ASN1OID.OIDToString((int[])nodeArray2[0].data);
        String[] stringArray = new String[1];
        this.signatureName = X509CertImpl.getAlias("Alg.Alias.Signature.", this.sigAlgOID, stringArray);
        this.signatureProviderName = stringArray[0];
        ASN1Decoder.Node node = null;
        if (nodeArray2.length > 1) {
            node = nodeArray2[1];
        }
        if (node != null && node.type != 5) {
            this.sigAlgParams = new byte[node.endPosition - node.startPosition + 1];
            System.arraycopy((Object)this.encoded, node.startPosition - this.originalOffsetIntoRawBytes, (Object)this.sigAlgParams, 0, this.sigAlgParams.length);
        }
    }

    static String getAlias(String string, String string2, String[] stringArray) {
        String string3 = String.valueOf(string) + string2;
        String string4 = null;
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            string4 = (String)provider.get(string3);
            if (string4 != null) {
                if (stringArray != null) {
                    stringArray[0] = provider.getName();
                }
                return string4;
            }
            ++n;
        }
        return (String)X509Certificate.OID_DATABASE.get(string2);
    }

    private void configureSubjectPublicKeyInfo(ASN1Decoder.Node[] nodeArray, int n) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
        ASN1Decoder.Node node = nodeArray[n + 6];
        ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])node.data;
        ASN1Decoder.Node node2 = nodeArray2[0];
        ASN1Decoder.Node[] nodeArray3 = (ASN1Decoder.Node[])node2.data;
        this.subjectAlgOID = ASN1OID.OIDToString((int[])nodeArray3[0].data);
        this.subjectPublicKeyASN1DER = node;
        String string = X509CertImpl.getAlias("Alg.Alias.KeyFactory.", this.subjectAlgOID, null);
        byte[] byArray = this.getSubjectPublicKeyInfoAsBytes();
        this.subjectPublicKey = this.createPublicKeyUsingProviders(string, byArray);
        if (this.subjectPublicKey != null) {
            return;
        }
        UnparsedX509PublicKey unparsedX509PublicKey = new UnparsedX509PublicKey(byArray);
        unparsedX509PublicKey.algorithm = string == null ? this.subjectAlgOID : string;
        this.subjectPublicKey = unparsedX509PublicKey;
    }

    protected PublicKey createPublicKeyUsingProviders(String string, byte[] byArray) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
        KeyFactory keyFactory = null;
        try {
            if (string != null) {
                keyFactory = KeyFactory.getInstance(string);
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
        if (keyFactory != null) {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byArray);
            return keyFactory.generatePublic(x509EncodedKeySpec);
        }
        return null;
    }

    private Set getExtensionOIDs(boolean bl) {
        if (this.extensions == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration enumeration = this.extensions.elements();
        while (enumeration.hasMoreElements()) {
            X509Extension x509Extension = (X509Extension)enumeration.nextElement();
            if (x509Extension.isCritical() != bl) continue;
            hashSet.add(x509Extension.name());
        }
        return hashSet;
    }

    private boolean[] computeUniqueID(ASN1Decoder.Node node) {
        byte[] byArray = node.data instanceof ASN1Decoder.BitString ? ((ASN1Decoder.BitString)node.data).data : ((BigInteger)node.data).toByteArray();
        boolean[] blArray = new boolean[byArray.length * 8];
        int n = 0;
        while (n < byArray.length * 8) {
            blArray[n] = (byArray[n / 8] & 128 >> n % 8) != 0;
            ++n;
        }
        return blArray;
    }

    private void configureExtensions(ASN1Decoder.Node node) {
        ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node.data;
        ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])nodeArray[0].data;
        this.extensions = new Hashtable();
        int n = 0;
        while (n < nodeArray2.length) {
            ASN1Decoder.Node node2 = nodeArray2[n];
            ASN1Decoder.Node[] nodeArray3 = (ASN1Decoder.Node[])node2.data;
            boolean bl = false;
            if (nodeArray3.length > 2) {
                bl = (Boolean)nodeArray3[1].data;
            }
            ASN1OID aSN1OID = new ASN1OID((int[])nodeArray3[0].data);
            byte[] byArray = (byte[])nodeArray3[nodeArray3.length - 1].data;
            X509Extension x509Extension = new X509Extension(aSN1OID, byArray, bl);
            this.extensions.put(x509Extension.name(), x509Extension);
            ++n;
        }
    }

    private void configureOptionalParts(ASN1Decoder.Node[] nodeArray, int n) {
        int n2 = n + 7;
        while (n2 < nodeArray.length) {
            ASN1Decoder.Node node = nodeArray[n2];
            ++n2;
            switch (node.originalType) {
                case 1: {
                    this.issuerUniqueID = this.computeUniqueID(node);
                    break;
                }
                case 2: {
                    this.subjectUniqueID = this.computeUniqueID(node);
                    break;
                }
                case 3: {
                    this.configureExtensions(node);
                }
            }
        }
    }

    public static X509CertImpl certificateFromASN1Object(byte[] byArray) throws CertificateException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return X509CertImpl.certificateFromASN1Object(byteArrayInputStream);
    }

    public static X509CertImpl certificateFromASN1Object(ASN1Decoder.Node node, byte[] byArray) throws CertificateException {
        X509CertImpl x509CertImpl = new X509CertImpl();
        final class PrinFactory
        implements PrincipalFactory {
            PrinFactory() {
            }

            public X500Principal getInstance(ASN1Decoder.Node node) {
                return new X500Principal(node);
            }
        }
        return X509CertImpl.certificateFromASN1Object(node, byArray, x509CertImpl, new PrinFactory());
    }

    public static X509CertImpl certificateFromASN1Object(ASN1Decoder.Node node, byte[] byArray, X509CertImpl x509CertImpl, PrincipalFactory principalFactory) throws CertificateException {
        try {
            X500Principal x500Principal;
            X500Principal x500Principal2;
            int n;
            ASN1Decoder.Node[] nodeArray;
            Object object;
            ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])node.data;
            int n2 = node.startPosition;
            int n3 = node.endPosition;
            if (n2 == 0 && n3 == byArray.length - 1) {
                x509CertImpl.encoded = byArray;
            } else {
                x509CertImpl.encoded = new byte[n3 - n2 + 1];
                System.arraycopy((Object)byArray, n2, (Object)x509CertImpl.encoded, 0, x509CertImpl.encoded.length);
            }
            x509CertImpl.originalOffsetIntoRawBytes = n2;
            x509CertImpl.configureSignature(nodeArray2);
            ASN1Decoder.Node node2 = nodeArray2[0];
            ASN1Decoder.Node[] nodeArray3 = (ASN1Decoder.Node[])node2.data;
            x509CertImpl.tbsNode = node2;
            if (nodeArray3[0].originalType == 0) {
                object = (ASN1Decoder.Node[])nodeArray3[0].data;
                nodeArray = (ASN1Decoder.Node[])object[0].data;
                x509CertImpl.version = nodeArray.intValue() + 1;
                n = 0;
            } else {
                x509CertImpl.version = 1;
                n = -1;
            }
            x509CertImpl.serialNumber = (BigInteger)nodeArray3[n + 1].data;
            object = nodeArray3[n + 4];
            nodeArray = (ASN1Decoder.Node[])object.data;
            x509CertImpl.notBefore = (Date)nodeArray[0].data;
            x509CertImpl.notAfter = (Date)nodeArray[1].data;
            x509CertImpl.issuer = x500Principal2 = principalFactory.getInstance(nodeArray3[n + 3]);
            x509CertImpl.subject = x500Principal = principalFactory.getInstance(nodeArray3[n + 5]);
            x509CertImpl.configureSubjectPublicKeyInfo(nodeArray3, n);
            x509CertImpl.configureOptionalParts(nodeArray3, n);
            return x509CertImpl;
        }
        catch (ClassCastException classCastException) {
            throw new CertificateException();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new CertificateException();
        }
        catch (NoSuchProviderException noSuchProviderException) {
            throw new CertificateException();
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            throw new CertificateException();
        }
    }

    public static X509CertImpl certificateFromASN1Object(InputStream inputStream) throws CertificateException {
        try {
            ASN1Decoder aSN1Decoder = new ASN1Decoder(inputStream);
            aSN1Decoder.configureTypeRedirection(2, X509_MAPPER);
            aSN1Decoder.collectBytes(true);
            ASN1Decoder.Node node = aSN1Decoder.readContents();
            if (node == null) {
                throw new CertificateException();
            }
            X509CertImpl x509CertImpl = X509CertImpl.certificateFromASN1Object(node, aSN1Decoder.collectedBytes());
            return x509CertImpl;
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateException();
        }
    }

    public static X509CertImpl certificateFromData(PublicKey publicKey, String string, Date date, Date date2, BigInteger bigInteger) throws CertificateException {
        X509CertImpl x509CertImpl = X509CertImpl.certificateFromData(publicKey, string, date, date2);
        x509CertImpl.serialNumber = bigInteger;
        return x509CertImpl;
    }

    public static X509CertImpl certificateFromData(PublicKey publicKey, String string, Date date, Date date2) throws CertificateException {
        try {
            X509CertImpl x509CertImpl = new X509CertImpl();
            x509CertImpl.encoded = null;
            x509CertImpl.subjectPublicKey = publicKey;
            x509CertImpl.notBefore = date;
            x509CertImpl.notAfter = date2;
            x509CertImpl.version = 1;
            x509CertImpl.serialNumber = new BigInteger(String.valueOf(x509CertImpl.notBefore.getTime() / 1000L));
            if (string != null) {
                X500Principal x500Principal;
                X500Principal x500Principal2;
                x509CertImpl.issuer = x500Principal2 = new X500Principal(string);
                x509CertImpl.subject = x500Principal = new X500Principal(string);
            }
            return x509CertImpl;
        }
        catch (ClassCastException classCastException) {
            throw new CertificateException(classCastException.getMessage());
        }
    }

    public byte[] getSignedAndEncoded(String string, PrivateKey privateKey) throws CertificateException {
        try {
            int n = -1;
            Object[] objectArray = new Object[n + 7];
            objectArray[n + 1] = this.serialNumber;
            Object[] objectArray2 = new Object[2];
            String string2 = (String)SIGNALGORITHM_OID.get(string);
            objectArray2[0] = ASN1OID.stringToIntOID(string2);
            objectArray2[1] = null;
            objectArray[n + 2] = objectArray2;
            objectArray[n + 3] = new ASN1Decoder.Data(this.issuer.getEncoded());
            Object[] objectArray3 = new Object[]{new ASN1Decoder.UTCTime(this.notBefore), new ASN1Decoder.UTCTime(this.notAfter)};
            objectArray[n + 4] = objectArray3;
            objectArray[n + 5] = new ASN1Decoder.Data(this.subject.getEncoded());
            objectArray[n + 6] = new ASN1Decoder.Data(this.subjectPublicKey.getEncoded());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
            aSN1Encoder.writeObject(objectArray);
            Signature signature = Signature.getInstance(string);
            signature.initSign(privateKey);
            signature.update(byteArrayOutputStream.toByteArray());
            Object[] objectArray4 = new Object[2];
            string2 = (String)SIGNALGORITHM_OID.get(string);
            objectArray4[0] = ASN1OID.stringToIntOID(string2);
            objectArray4[1] = null;
            ASN1Decoder.BitString bitString = new ASN1Decoder.BitString(0, signature.sign());
            Object[] objectArray5 = new Object[]{new ASN1Decoder.Data(byteArrayOutputStream.toByteArray()), objectArray4, bitString};
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            ASN1Encoder aSN1Encoder2 = new ASN1Encoder(byteArrayOutputStream2);
            aSN1Encoder2.writeObject(objectArray5);
            return byteArrayOutputStream2.toByteArray();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateException(aSN1Exception.getMessage());
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new CertificateException(invalidKeyException.getMessage());
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new CertificateException(noSuchAlgorithmException.getMessage());
        }
        catch (SignatureException signatureException) {
            throw new CertificateException(signatureException.getMessage());
        }
    }

    public Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return this.getAlternativeNames(subjectAltNamesOID);
    }

    public Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return this.getAlternativeNames(issuerAltNamesOID);
    }

    private Collection getAlternativeNames(String string) throws CertificateParsingException {
        try {
            byte[] byArray = this.getExtensionValue(string);
            if (byArray == null) {
                return null;
            }
            ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray));
            ASN1Decoder.Node node = aSN1Decoder.readContents();
            if (node.type != 4) {
                throw new CertificateParsingException();
            }
            aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream((byte[])node.data));
            ASN1Decoder.Node node2 = aSN1Decoder.readContents();
            if (node2.type != 16) {
                throw new CertificateParsingException();
            }
            LinkedList linkedList = new LinkedList();
            ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node2.data;
            int n = 0;
            while (n < nodeArray.length) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])node.data, nodeArray[n].startPosition, nodeArray[n].endPosition);
                aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
                aSN1Decoder.configureTypeRedirection(0, new GeneralNamesMapper());
                ASN1Decoder.Node node3 = aSN1Decoder.readContents();
                int n2 = nodeArray[n].type;
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(new Integer(n2));
                switch (n2) {
                    case 1: 
                    case 2: 
                    case 4: 
                    case 6: {
                        arrayList.add(new String((String)node3.data));
                        linkedList.add(arrayList);
                        break;
                    }
                    case 3: 
                    case 5: {
                        byte[] byArray2 = (byte[])node3.data;
                        byte[] byArray3 = new byte[byArray2.length];
                        System.arraycopy((Object)byArray2, 0, (Object)byArray3, 0, byArray2.length);
                        arrayList.add(byArray3);
                        linkedList.add(arrayList);
                        break;
                    }
                    case 7: {
                        byte[] byArray4 = (byte[])node3.data;
                        InetAddress inetAddress = null;
                        inetAddress = InetAddress.getByAddress(byArray4);
                        arrayList.add(inetAddress.getHostAddress());
                        linkedList.add(arrayList);
                        break;
                    }
                    case 8: {
                        arrayList.add(ASN1OID.OIDToString((int[])node3.data));
                        linkedList.add(arrayList);
                        break;
                    }
                    default: {
                        throw new CertificateParsingException(Msg.getString("K0414", n2));
                    }
                }
                ++n;
            }
            return Collections.unmodifiableList(linkedList);
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateParsingException();
        }
        catch (UnknownHostException unknownHostException) {
            throw new CertificateParsingException();
        }
    }

    public void setIssuerDN(Principal principal) {
        this.issuer = new X500Principal(principal.getName());
    }

    public void setSubjectDN(Principal principal) {
        this.subject = new X500Principal(principal.getName());
    }

    public static interface PrincipalFactory {
        public X500Principal getInstance(ASN1Decoder.Node var1);
    }

    private static class GeneralNamesMapper
    implements ASN1Decoder.TypeMapper {
        public int map(int n, int n2, int n3) {
            switch (n) {
                case 1: 
                case 2: 
                case 6: {
                    return 22;
                }
                case 4: {
                    return 19;
                }
                case 7: {
                    return 4;
                }
                case 8: {
                    return 6;
                }
            }
            return 4;
        }
    }
}

