/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.PKCS7;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.Msg;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CertPathX509
extends CertPath {
    static final String PKCS7_ENCODING = "PKCS7";
    static final String PKIPATH_ENCODING = "PkiPath";
    private static String defaultEncoding = "PkiPath";
    private static String[] supportedEncodings = new String[]{"PKCS7", "PkiPath"};
    private List certificates = null;

    public CertPathX509() {
        super("X.509");
        this.certificates = new ArrayList(0);
    }

    CertPathX509(List list) {
        super("X.509");
        this.certificates = new ArrayList(list);
    }

    public Iterator getEncodings() {
        List list = Arrays.asList(supportedEncodings);
        return list.iterator();
    }

    public List getCertificates() {
        return Collections.unmodifiableList(this.certificates);
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return this.getEncoded(defaultEncoding);
    }

    public byte[] getEncoded(String string) throws CertificateEncodingException {
        if (string.equals(PKCS7_ENCODING)) {
            return CertPathX509.encodeAsPKCS7(this.certificates);
        }
        if (string.equals(PKIPATH_ENCODING)) {
            return CertPathX509.encodeAsPkiPath(this.certificates);
        }
        throw new CertificateEncodingException(Msg.getString("K0300"));
    }

    static String getDefaultEncoding() {
        return defaultEncoding;
    }

    static Iterator getSupportedEncodings() {
        List list = Arrays.asList(supportedEncodings);
        return list.iterator();
    }

    private static byte[] encodeAsPKCS7(List list) throws CertificateEncodingException {
        try {
            return PKCS7.encodeCertList(list);
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateEncodingException(aSN1Exception.getMessage());
        }
    }

    private static byte[] encodeAsPkiPath(List list) throws CertificateEncodingException {
        Object[] objectArray = new Object[list.size()];
        int n = 0;
        Object object = list.iterator();
        while (object.hasNext()) {
            Certificate certificate = (Certificate)object.next();
            byte[] byArray = certificate.getEncoded();
            ASN1Decoder.Data data = new ASN1Decoder.Data(byArray);
            objectArray[n++] = data;
        }
        object = ASN1Encoder.getEncoding(objectArray);
        return object;
    }
}

