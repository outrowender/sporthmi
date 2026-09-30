/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.J9SSLSessionContext;
import com.ibm.j9.ssl.SessionState;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public interface J9SSLContext {
    public void getRandomBytes(byte[] var1);

    public void verifyCertificateChain(X509Certificate[] var1) throws CertificateException;

    public void setEnableSessionCreation(boolean var1);

    public boolean getSessionCreationEnabled();

    public void addSession(SessionState var1);

    public void removeSession(SessionState var1);

    public SessionState getSession(String var1);

    public J9SSLSessionContext getSessionContext();

    public String getClientAlias(String[] var1, Principal[] var2);

    public PrivateKey getPrivateKey(String var1);

    public X509Certificate[] getClientCertificateChain(String var1);
}

