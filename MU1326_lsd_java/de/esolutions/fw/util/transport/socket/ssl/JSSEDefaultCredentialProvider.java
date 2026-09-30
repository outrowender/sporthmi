/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket.ssl;

import de.esolutions.fw.util.transport.socket.ssl.ISSLCredentialProvider;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class JSSEDefaultCredentialProvider
implements ISSLCredentialProvider {
    private InputStream keyStoreStream;
    private InputStream trustStoreStream;
    private String keyStorePassPhrase;
    private String trustStorePassPhrase;
    private KeyManagerFactory keyManagerFactory;
    private TrustManagerFactory trustManagerFactory;

    public void setKeyStoreStream(InputStream inputStream) {
        this.keyStoreStream = inputStream;
    }

    public void setTrustStoreStream(InputStream inputStream) {
        this.trustStoreStream = inputStream;
    }

    public void setKeyStorePassPhrase(String string) {
        this.keyStorePassPhrase = string;
    }

    public void setTrustStorePassPhrase(String string) {
        this.trustStorePassPhrase = string;
    }

    public KeyManagerFactory getKeyManagerFactory() {
        return this.keyManagerFactory;
    }

    public TrustManagerFactory getTrustManagerFactory() {
        return this.trustManagerFactory;
    }

    public void init() throws IOException, GeneralSecurityException {
        if (this.keyManagerFactory != null && this.trustManagerFactory != null) {
            return;
        }
        if (this.keyStoreStream == null) {
            throw new IOException("No keyStoreStream given!");
        }
        this.loadKeyStore(this.keyStoreStream);
        if (this.trustStoreStream == null) {
            throw new IOException("No trustStoreStream given!");
        }
        this.loadTrustStore(this.trustStoreStream);
    }

    private void loadKeyStore(InputStream inputStream) throws IOException, GeneralSecurityException {
        String string = this.keyStorePassPhrase;
        if (string == null) {
            string = "";
        }
        char[] cArray = string.toCharArray();
        String string2 = KeyStore.getDefaultType();
        System.out.println("JSSE: defaultKeyStore: " + KeyStore.getDefaultType());
        String string3 = KeyManagerFactory.getDefaultAlgorithm();
        System.out.println("JSSE: defaultKeyManager: " + string3);
        this.keyManagerFactory = KeyManagerFactory.getInstance(string3);
        KeyStore keyStore = KeyStore.getInstance(string2);
        keyStore.load(inputStream, cArray);
        this.keyManagerFactory.init(keyStore, cArray);
    }

    private void loadTrustStore(InputStream inputStream) throws IOException, GeneralSecurityException {
        String string = this.trustStorePassPhrase;
        if (string == null) {
            string = "";
        }
        char[] cArray = string.toCharArray();
        String string2 = KeyStore.getDefaultType();
        System.out.println("JSSE: defaultKeyStore: " + KeyStore.getDefaultType());
        String string3 = TrustManagerFactory.getDefaultAlgorithm();
        System.out.println("JSSE: defaultTrustManager: " + string3);
        this.trustManagerFactory = TrustManagerFactory.getInstance(string3);
        KeyStore keyStore = KeyStore.getInstance(string2);
        keyStore.load(inputStream, cArray);
        this.trustManagerFactory.init(keyStore);
    }
}

