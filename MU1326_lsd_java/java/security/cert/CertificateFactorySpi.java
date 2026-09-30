/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class CertificateFactorySpi {
    public abstract Certificate engineGenerateCertificate(InputStream var1) throws CertificateException;

    public abstract Collection engineGenerateCertificates(InputStream var1) throws CertificateException;

    public abstract CRL engineGenerateCRL(InputStream var1) throws CRLException;

    public abstract Collection engineGenerateCRLs(InputStream var1) throws CRLException;

    public Iterator engineGetCertPathEncodings() {
        throw new UnsupportedOperationException();
    }

    public CertPath engineGenerateCertPath(InputStream inputStream) throws CertificateException {
        Collection collection = this.engineGenerateCertificates(inputStream);
        ArrayList arrayList = new ArrayList(collection);
        return this.engineGenerateCertPath(arrayList);
    }

    public CertPath engineGenerateCertPath(InputStream inputStream, String string) throws CertificateException {
        throw new UnsupportedOperationException();
    }

    public CertPath engineGenerateCertPath(List list) throws CertificateException {
        throw new UnsupportedOperationException();
    }
}

