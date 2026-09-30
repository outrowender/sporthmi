/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.ASN1OID;
import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.security.provider.X509CRLEntry;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.security.provider.X509Extension;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class X509CRL
extends java.security.cert.X509CRL {
    private byte[] encoded;
    private int originalOffsetIntoRawBytes;
    private ASN1Decoder.Node tbsNode;
    private int version;
    private String sigAlgOID;
    private byte[] sigAlgParams;
    private byte[] rawSignature;
    private String signatureName;
    private String signatureProviderName;
    private X500Principal issuer;
    private Date thisUpdate;
    private Date nextUpdate;
    private Hashtable revokedCertificates;
    private Hashtable extensions;
    private static final String[] SUPPORTED_CRITICAL_EXTENSIONS = new String[0];

    protected X509CRL() {
    }

    public byte[] getEncoded() throws CRLException {
        return this.encoded;
    }

    public Principal getIssuerDN() {
        return this.issuer;
    }

    public Date getNextUpdate() {
        return this.nextUpdate;
    }

    public java.security.cert.X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        if (this.revokedCertificates == null) {
            return null;
        }
        return (java.security.cert.X509CRLEntry)this.revokedCertificates.get(bigInteger);
    }

    public Set getRevokedCertificates() {
        if (this.revokedCertificates == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration enumeration = this.revokedCertificates.elements();
        while (enumeration.hasMoreElements()) {
            hashSet.add(enumeration.nextElement());
        }
        return hashSet;
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

    public byte[] getTBSCertList() throws CRLException {
        byte[] byArray = new byte[this.tbsNode.endPosition - this.tbsNode.startPosition + 1];
        System.arraycopy((Object)this.encoded, this.tbsNode.startPosition - this.originalOffsetIntoRawBytes, (Object)byArray, 0, byArray.length);
        return byArray;
    }

    public Date getThisUpdate() {
        return this.thisUpdate;
    }

    public int getVersion() {
        return this.version;
    }

    public void verify(PublicKey publicKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
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

    public void verify(PublicKey publicKey, String string) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        if (this.signatureName == null) {
            throw new NoSuchAlgorithmException(this.sigAlgOID);
        }
        Signature signature = Signature.getInstance(this.signatureName, string);
        this.verify(publicKey, signature);
    }

    private void verify(PublicKey publicKey, Signature signature) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        signature.initVerify(publicKey);
        signature.update(this.getTBSCertList());
        boolean bl = signature.verify(this.getSignature());
        if (!bl) {
            throw new SignatureException();
        }
    }

    public boolean isRevoked(Certificate certificate) {
        try {
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate)certificate;
            java.security.cert.X509CRLEntry x509CRLEntry = this.getRevokedCertificate(x509Certificate.getSerialNumber());
            return x509CRLEntry != null;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X.509 CRL v");
        stringBuffer.append(this.getVersion());
        stringBuffer.append("\n\tThis update: ");
        stringBuffer.append(this.getThisUpdate());
        stringBuffer.append("\n\tNext update: ");
        stringBuffer.append(this.getNextUpdate());
        stringBuffer.append("\n\tExtensions: ");
        stringBuffer.append(this.extensions == null ? 0 : this.extensions.size());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static ASN1Decoder CRLDecoder(InputStream inputStream) {
        ASN1Decoder aSN1Decoder = new ASN1Decoder(inputStream);
        ASN1Decoder.TypeMapper typeMapper = new ASN1Decoder.TypeMapper(){

            public int map(int n, int n2, int n3) {
                if (n == 0) {
                    return 16;
                }
                return n;
            }
        };
        aSN1Decoder.configureTypeRedirection(2, typeMapper);
        return aSN1Decoder;
    }

    private void configureRevokedCertificates(ASN1Decoder.Node node, byte[] byArray) throws CRLException {
        ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node.data;
        this.revokedCertificates = new Hashtable();
        int n = 0;
        while (n < nodeArray.length) {
            ASN1Decoder.Node node2 = nodeArray[n];
            X509CRLEntry x509CRLEntry = X509CRLEntry.X509CRLEntryFromASN1Object(node2, byArray);
            this.revokedCertificates.put(x509CRLEntry.getSerialNumber(), x509CRLEntry);
            ++n;
        }
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

    private void configureSignature(ASN1Decoder.Node[] nodeArray) {
        ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])nodeArray[1].data;
        ASN1Decoder.BitString bitString = (ASN1Decoder.BitString)nodeArray[2].data;
        this.rawSignature = bitString.data;
        this.sigAlgOID = ASN1OID.OIDToString((int[])nodeArray2[0].data);
        String[] stringArray = new String[1];
        this.signatureName = X509Certificate.getAlias("Alg.Alias.Signature.", this.sigAlgOID, stringArray);
        this.signatureProviderName = stringArray[0];
        if (nodeArray2.length > 1) {
            ASN1Decoder.Node node = nodeArray2[1];
            if (node.type != 5) {
                this.sigAlgParams = new byte[node.endPosition - node.startPosition + 1];
                System.arraycopy((Object)this.encoded, node.startPosition - this.originalOffsetIntoRawBytes, (Object)this.sigAlgParams, 0, this.sigAlgParams.length);
            }
        }
    }

    static CRL CRLFromASN1Object(ASN1Decoder.Node node, byte[] byArray) throws CRLException {
        try {
            int n;
            Object object;
            X509CRL x509CRL = new X509CRL();
            ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node.data;
            int n2 = node.startPosition;
            int n3 = node.endPosition;
            if (n2 == 0 && n3 == byArray.length - 1) {
                x509CRL.encoded = byArray;
            } else {
                x509CRL.encoded = new byte[n3 - n2 + 1];
                System.arraycopy((Object)byArray, n2, (Object)x509CRL.encoded, 0, x509CRL.encoded.length);
            }
            x509CRL.originalOffsetIntoRawBytes = n2;
            x509CRL.configureSignature(nodeArray);
            ASN1Decoder.Node node2 = nodeArray[0];
            ASN1Decoder.Node[] nodeArray2 = (ASN1Decoder.Node[])node2.data;
            x509CRL.tbsNode = node2;
            if (nodeArray2[0].type == 2) {
                object = (BigInteger)nodeArray2[0].data;
                x509CRL.version = ((BigInteger)object).intValue() + 1;
                n = 0;
            } else {
                x509CRL.version = 2;
                n = -1;
            }
            x509CRL.issuer = object = new X500Principal(nodeArray2[n + 2]);
            ASN1Decoder.Node node3 = nodeArray2[n + 3];
            x509CRL.thisUpdate = (Date)node3.data;
            if (nodeArray2.length <= n + 4) {
                return x509CRL;
            }
            node3 = nodeArray2[n + 4];
            if (node3.type == 23 || node3.type == 24) {
                x509CRL.nextUpdate = (Date)node3.data;
            } else {
                --n;
            }
            if (nodeArray2.length <= n + 5) {
                return x509CRL;
            }
            ASN1Decoder.Node node4 = nodeArray2[n + 5];
            if (node4.originalType == 16) {
                x509CRL.configureRevokedCertificates(node4, byArray);
            } else {
                --n;
            }
            if (nodeArray2.length <= n + 6) {
                return x509CRL;
            }
            ASN1Decoder.Node node5 = nodeArray2[n + 6];
            if (node5.originalType == 0) {
                x509CRL.configureExtensions(node5);
            }
            return x509CRL;
        }
        catch (ClassCastException classCastException) {
            throw new CRLException();
        }
    }

    static CRL CRLFromASN1Object(InputStream inputStream) throws CRLException {
        try {
            ASN1Decoder aSN1Decoder = X509CRL.CRLDecoder(inputStream);
            aSN1Decoder.collectBytes(true);
            ASN1Decoder.Node node = aSN1Decoder.readContents();
            X509CRL x509CRL = (X509CRL)X509CRL.CRLFromASN1Object(node, aSN1Decoder.collectedBytes());
            return x509CRL;
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CRLException();
        }
        catch (ClassCastException classCastException) {
            throw new CRLException();
        }
    }

    public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
        return new javax.security.auth.x500.X500Principal(this.issuer.getName());
    }
}

