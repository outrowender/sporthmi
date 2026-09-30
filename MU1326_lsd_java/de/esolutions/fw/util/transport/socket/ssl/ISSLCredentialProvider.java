/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket.ssl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public interface ISSLCredentialProvider {
    public void init() throws IOException, GeneralSecurityException;

    public KeyManagerFactory getKeyManagerFactory();

    public TrustManagerFactory getTrustManagerFactory();
}

