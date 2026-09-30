/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.X509CertImpl;
import com.ibm.oti.util.ASN1Decoder;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public class X509Certificate
extends java.security.cert.X509Certificate {
    private final X509CertImpl impl;
    static final String extendedKeyUsageOID = "2.5.29.37";
    static final String issuerAltNamesOID = "2.5.29.18";
    static final String subjectAltNamesOID = "2.5.29.17";
    public static final Hashtable OID_DATABASE = new Hashtable(5);
    private static final String OID_BasicConstraints = "2.5.29.19";
    private static final String OID_KeyUsage = "2.5.29.15";
    private static final String[] SUPPORTED_CRITICAL_EXTENSIONS;

    static {
        OID_DATABASE.put("1.2.840.113549.1.1.2", "MD2withRSA");
        OID_DATABASE.put("1.2.840.113549.1.1.4", "MD5withRSA");
        OID_DATABASE.put("1.2.840.113549.1.1.5", "SHA1withRSA");
        OID_DATABASE.put("1.2.840.10040.4.3", "SHA1withDSA");
        OID_DATABASE.put("1.3.14.3.2.26", "SHA");
        OID_DATABASE.put("1.2.840.113549.2.5", "MD5");
        OID_DATABASE.put("1.2.840.113549.2.2", "MD2");
        OID_DATABASE.put("1.2.840.113549.1.1.1", "RSA");
        OID_DATABASE.put("1.2.840.10040.4.1", "DSA");
        OID_DATABASE.put("1.3.14.3.2.12", "DSA");
        OID_DATABASE.put("1.2.840.10046.2.1", "DiffieHellman");
        SUPPORTED_CRITICAL_EXTENSIONS = new String[]{OID_BasicConstraints, OID_KeyUsage};
    }

    public X509Certificate(X509CertImpl x509CertImpl) {
        this.impl = x509CertImpl;
    }

    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.impl.checkValidity(new Date());
    }

    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        this.impl.checkValidity(date);
    }

    public int getBasicConstraints() {
        return this.impl.getBasicConstraints();
    }

    public Principal getIssuerDN() {
        return this.impl.getIssuerDN();
    }

    public X500Principal getIssuerX500Principal() {
        return new X500Principal(this.impl.getIssuerDN().getName());
    }

    public boolean[] getIssuerUniqueID() {
        return this.impl.getIssuerUniqueID();
    }

    public boolean[] getKeyUsage() {
        return this.impl.getKeyUsage();
    }

    public Date getNotAfter() {
        return this.impl.getNotAfter();
    }

    public Date getNotBefore() {
        return this.impl.getNotBefore();
    }

    public BigInteger getSerialNumber() {
        return this.impl.getSerialNumber();
    }

    public String getSigAlgName() {
        return this.impl.getSigAlgName();
    }

    public String getSigAlgOID() {
        return this.impl.getSigAlgOID();
    }

    public byte[] getSigAlgParams() {
        return this.impl.getSigAlgParams();
    }

    public byte[] getSignature() {
        return this.impl.getSignature();
    }

    public Principal getSubjectDN() {
        return this.impl.getSubjectDN();
    }

    public X500Principal getSubjectX500Principal() {
        return new X500Principal(this.impl.getSubjectDN().getName());
    }

    public boolean[] getSubjectUniqueID() {
        return this.impl.getSubjectUniqueID();
    }

    public byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.impl.getTBSCertificate();
    }

    public int getVersion() {
        return this.impl.getVersion();
    }

    public boolean hasUnsupportedCriticalExtension() {
        return this.impl.hasUnsupportedCriticalExtension();
    }

    public Set getCriticalExtensionOIDs() {
        return this.impl.getCriticalExtensionOIDs();
    }

    public Set getNonCriticalExtensionOIDs() {
        return this.impl.getNonCriticalExtensionOIDs();
    }

    public byte[] getExtensionValue(String string) {
        return this.impl.getExtensionValue(string);
    }

    public List getExtendedKeyUsage() throws CertificateParsingException {
        return this.impl.getExtendedKeyUsage();
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return this.impl.getEncoded();
    }

    public PublicKey getPublicKey() {
        return this.impl.getPublicKey();
    }

    public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.impl.verify(publicKey);
    }

    public void verify(PublicKey publicKey, String string) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.impl.verify(publicKey, string);
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

    static String getAlias(String string, String string2, String[] stringArray) {
        return X509CertImpl.getAlias(string, string2, stringArray);
    }

    public static X509Certificate certificateFromASN1Object(byte[] byArray) throws CertificateException {
        X509CertImpl x509CertImpl = X509CertImpl.certificateFromASN1Object(byArray);
        return new X509Certificate(x509CertImpl);
    }

    public static X509Certificate certificateFromASN1Object(ASN1Decoder.Node node, byte[] byArray) throws CertificateException {
        X509CertImpl x509CertImpl = X509CertImpl.certificateFromASN1Object(node, byArray);
        return new X509Certificate(x509CertImpl);
    }

    public static X509Certificate certificateFromASN1Object(InputStream inputStream) throws CertificateException {
        X509CertImpl x509CertImpl = X509CertImpl.certificateFromASN1Object(inputStream);
        return new X509Certificate(x509CertImpl);
    }

    public static Certificate certificateFromData(PublicKey publicKey, String string, Date date, Date date2) throws CertificateException {
        X509CertImpl x509CertImpl = X509CertImpl.certificateFromData(publicKey, string, date, date2);
        return new X509Certificate(x509CertImpl);
    }

    public byte[] getSignedAndEncoded(String string, PrivateKey privateKey) throws CertificateException {
        return this.impl.getSignedAndEncoded(string, privateKey);
    }

    public Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return this.impl.getSubjectAlternativeNames();
    }

    public Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return this.impl.getIssuerAlternativeNames();
    }

    public void setIssuerDN(Principal principal) {
        this.impl.setIssuerDN(principal);
    }

    public void setSubjectDN(Principal principal) {
        this.impl.setSubjectDN(principal);
    }
}

