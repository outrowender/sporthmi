/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.CertPathX509;
import com.ibm.oti.security.provider.PKCS7;
import com.ibm.oti.security.provider.X509CRL;
import com.ibm.oti.security.provider.X509CertImpl;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.BASE64Decoder;
import com.ibm.oti.util.Msg;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CertificateFactoryX509
extends CertificateFactorySpi {
    private static final String BEGIN_CERTIFICATE = "-----BEGIN CERTIFICATE-----";
    private static final String END_CERTIFICATE = "-----END CERTIFICATE-----";
    private static final String BEGIN_PKCS7 = "-----BEGIN PKCS7-----";
    private static final String END_PKCS7 = "-----END PKCS7-----";

    public Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException {
        try {
            inputStream = new BufferedInputStream(inputStream);
            try {
                return this.parseDERCertificate(inputStream);
            }
            catch (CertificateException certificateException) {
                return this.parsePEMCertificate(inputStream);
            }
        }
        catch (IOException iOException) {
            throw new CertificateException();
        }
    }

    public Collection engineGenerateCertificates(InputStream inputStream) throws CertificateException {
        Vector vector = new Vector();
        try {
            inputStream = new BufferedInputStream(inputStream);
            try {
                while (true) {
                    vector.add(this.parseDERCertificate(inputStream));
                }
            }
            catch (CertificateException certificateException) {
                if (vector.size() > 0) {
                    return vector;
                }
                try {
                    while (true) {
                        vector.add(this.parsePEMCertificate(inputStream));
                    }
                }
                catch (CertificateException certificateException2) {
                    if (vector.size() > 0) {
                        return vector;
                    }
                    PKCS7 pKCS7 = this.parsePKCS7(inputStream);
                    if (pKCS7 != null && pKCS7.isSignedData()) {
                        return pKCS7.signedData().certificates();
                    }
                }
            }
        }
        catch (IOException iOException) {}
        throw new CertificateException();
    }

    public CRL engineGenerateCRL(InputStream inputStream) throws CRLException {
        try {
            inputStream = new BufferedInputStream(inputStream);
            inputStream.mark(1024);
            try {
                return X509CRL.CRLFromASN1Object(inputStream);
            }
            catch (CRLException cRLException) {
                inputStream.reset();
                throw cRLException;
            }
        }
        catch (IOException iOException) {
            throw new CRLException();
        }
    }

    public Collection engineGenerateCRLs(InputStream inputStream) throws CRLException {
        Vector vector = new Vector();
        try {
            inputStream = new BufferedInputStream(inputStream);
            inputStream.mark(1024);
            try {
                while (true) {
                    vector.add(this.engineGenerateCRL(inputStream));
                }
            }
            catch (CRLException cRLException) {
                inputStream.reset();
                if (vector.size() > 0) {
                    return vector;
                }
                PKCS7 pKCS7 = this.parsePKCS7(inputStream);
                if (pKCS7 != null && pKCS7.isSignedData()) {
                    return pKCS7.signedData().CRLs();
                }
            }
        }
        catch (IOException iOException) {
        }
        catch (CertificateException certificateException) {}
        throw new CRLException();
    }

    public CertPath engineGenerateCertPath(InputStream inputStream, String string) throws CertificateException {
        if (string.equals("PKCS7")) {
            return this.genCertPathFromPKCS7(inputStream);
        }
        if (string.equals("PkiPath")) {
            return this.genCertPathFromPkiPath(inputStream);
        }
        throw new CertificateException(Msg.getString("K0300"));
    }

    private CertPath genCertPathFromPkiPath(InputStream inputStream) throws CertificateEncodingException, CertificateException {
        ASN1Decoder aSN1Decoder = new ASN1Decoder(inputStream);
        aSN1Decoder.collectBytes(true);
        aSN1Decoder.configureTypeRedirection(3, X509CertImpl.X509_MAPPER);
        ASN1Decoder.Node node = null;
        try {
            node = aSN1Decoder.readContents();
        }
        catch (ASN1Exception aSN1Exception) {
            throw new CertificateEncodingException(aSN1Exception.getMessage());
        }
        if (node == null) {
            throw new CertificateEncodingException(Msg.getString("K039a"));
        }
        ASN1Decoder.Node[] nodeArray = (ASN1Decoder.Node[])node.data;
        LinkedList linkedList = new LinkedList();
        int n = 0;
        while (n < nodeArray.length) {
            X509Certificate x509Certificate = X509Certificate.certificateFromASN1Object(nodeArray[n], aSN1Decoder.collectedBytes());
            linkedList.add(x509Certificate);
            ++n;
        }
        CertPath certPath = this.engineGenerateCertPath(linkedList);
        return certPath;
    }

    private CertPath genCertPathFromPKCS7(InputStream inputStream) throws CertificateException, CertificateEncodingException {
        PKCS7 pKCS7;
        try {
            pKCS7 = this.parsePKCS7(inputStream);
        }
        catch (IOException iOException) {
            throw new CertificateEncodingException();
        }
        if (pKCS7 != null && pKCS7.isSignedData()) {
            return new CertPathX509(pKCS7.signedData().certificates());
        }
        throw new CertificateEncodingException(Msg.getString("K0301"));
    }

    public CertPath engineGenerateCertPath(InputStream inputStream) throws CertificateException {
        return this.engineGenerateCertPath(inputStream, CertPathX509.getDefaultEncoding());
    }

    public CertPath engineGenerateCertPath(List list) throws CertificateException {
        int n = 0;
        while (n < list.size()) {
            if (!(list.get(n) instanceof X509Certificate)) {
                throw new CertificateException("Type not supported by CertificateFactory");
            }
            ++n;
        }
        return new CertPathX509(list);
    }

    public Iterator engineGetCertPathEncodings() {
        return CertPathX509.getSupportedEncodings();
    }

    private Certificate parsePEMCertificate(InputStream inputStream) throws CertificateException, IOException {
        inputStream.mark(1024);
        try {
            byte[] byArray = this.readLine(inputStream);
            if (byArray == null || !CertificateFactoryX509.equals(BEGIN_CERTIFICATE, byArray)) {
                throw new CertificateException();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (!CertificateFactoryX509.equals(END_CERTIFICATE, byArray = this.readLine(inputStream))) {
                byteArrayOutputStream.write(byArray);
            }
            byte[] byArray2 = null;
            try {
                byArray2 = BASE64Decoder.decode(byteArrayOutputStream.toByteArray());
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new CertificateEncodingException();
            }
            return X509Certificate.certificateFromASN1Object(byArray2);
        }
        catch (CertificateException certificateException) {
            inputStream.reset();
            throw certificateException;
        }
        catch (RuntimeException runtimeException) {
            inputStream.reset();
            throw new CertificateException(runtimeException.getMessage());
        }
    }

    private Certificate parseDERCertificate(InputStream inputStream) throws CertificateException, IOException {
        inputStream.mark(1024);
        try {
            return X509Certificate.certificateFromASN1Object(inputStream);
        }
        catch (CertificateException certificateException) {
            inputStream.reset();
            throw certificateException;
        }
        catch (RuntimeException runtimeException) {
            inputStream.reset();
            throw new CertificateException(runtimeException.getMessage());
        }
    }

    private PKCS7 parsePKCS7(InputStream inputStream) throws CertificateException, IOException {
        inputStream.mark(1024);
        try {
            return new PKCS7(inputStream);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            inputStream.reset();
        }
        catch (RuntimeException runtimeException) {
            inputStream.reset();
        }
        inputStream.mark(1024);
        byte[] byArray = this.readLine(inputStream);
        if (byArray == null || !CertificateFactoryX509.equals(BEGIN_PKCS7, byArray)) {
            throw new CertificateException();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (!CertificateFactoryX509.equals(END_PKCS7, byArray = this.readLine(inputStream))) {
            byteArrayOutputStream.write(byArray);
        }
        byte[] byArray2 = BASE64Decoder.decode(byteArrayOutputStream.toByteArray());
        try {
            return new PKCS7(byArray2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            inputStream.reset();
            throw new CertificateException();
        }
        catch (RuntimeException runtimeException) {
            inputStream.reset();
            throw new CertificateException(runtimeException.getMessage());
        }
    }

    private static boolean equals(String string, byte[] byArray) throws CertificateException {
        if (byArray == null) {
            throw new CertificateException();
        }
        if (byArray.length != string.length()) {
            return false;
        }
        int n = 0;
        while (n < byArray.length) {
            if (byArray[n] != (byte)string.charAt(n)) {
                return false;
            }
            ++n;
        }
        return true;
    }

    private byte[] readLine(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(80);
        while (true) {
            int n = inputStream.read();
            switch (n) {
                case -1: {
                    if (byteArrayOutputStream.size() == 0) {
                        return null;
                    }
                    return byteArrayOutputStream.toByteArray();
                }
                case 13: {
                    byteArrayOutputStream.size();
                    return byteArrayOutputStream.toByteArray();
                }
                case 10: {
                    byteArrayOutputStream.size();
                    return byteArrayOutputStream.toByteArray();
                }
            }
            byteArrayOutputStream.write(n);
        }
    }
}

