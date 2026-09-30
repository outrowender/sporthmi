/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.CertificateVerifierSecurity;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

public class CertificateVerifier {
    public static final int USAGE_MIDLET_SUITE_INSTALL = 1;
    public static final int USAGE_SSL_SERVER_AUTH = 2;

    public static void verifyCertificateChain(X509Certificate[] x509CertificateArray, Date date, int n) throws CertificateException, IOException {
        CertificateVerifierSecurity.verifyCertificateChain(x509CertificateArray, date);
    }
}

