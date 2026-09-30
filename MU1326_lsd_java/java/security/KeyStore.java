/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.PriviAction;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;

public class KeyStore {
    private static final String KEY_PREFIX = "KeyStore.";
    private String type;
    private Provider provider;
    private KeyStoreSpi keyStoreSpi;
    private boolean loaded = false;

    protected KeyStore(KeyStoreSpi keyStoreSpi, Provider provider, String string) {
        this.setProvider(provider);
        this.setType(string);
        this.keyStoreSpi = keyStoreSpi;
    }

    public final Enumeration aliases() throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        return this.keyStoreSpi.engineAliases();
    }

    public final boolean containsAlias(String string) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        return this.keyStoreSpi.engineContainsAlias(string);
    }

    private static KeyStore createKeyStore(Provider provider, Class clazz, String string) throws KeyStoreException {
        try {
            KeyStoreSpi keyStoreSpi = (KeyStoreSpi)clazz.newInstance();
            return new KeyStore(keyStoreSpi, provider, string);
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {}
        throw new KeyStoreException(string);
    }

    public final void deleteEntry(String string) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        this.keyStoreSpi.engineDeleteEntry(string);
    }

    public final Certificate getCertificate(String string) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        return this.keyStoreSpi.engineGetCertificate(string);
    }

    public final String getCertificateAlias(Certificate certificate) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        return this.keyStoreSpi.engineGetCertificateAlias(certificate);
    }

    public final Certificate[] getCertificateChain(String string) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        return this.keyStoreSpi.engineGetCertificateChain(string);
    }

    public final Date getCreationDate(String string) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        return this.keyStoreSpi.engineGetCreationDate(string);
    }

    public static KeyStore getInstance(String string) throws KeyStoreException {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return KeyStore.toKeyStoreImplementation(string);
    }

    public static KeyStore getInstance(String string, String string2) throws KeyStoreException, NoSuchProviderException {
        if (string2 == null) {
            throw new IllegalArgumentException();
        }
        if (string == null) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(string2);
        if (provider == null) {
            throw new NoSuchProviderException(string2);
        }
        return KeyStore.toKeyStoreImplementation(string, provider);
    }

    public static KeyStore getInstance(String string, Provider provider) throws KeyStoreException {
        if (string == null || provider == null) {
            throw new IllegalArgumentException();
        }
        return KeyStore.toKeyStoreImplementation(string, provider);
    }

    public final Key getKey(String string, char[] cArray) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        return this.keyStoreSpi.engineGetKey(string, cArray);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isCertificateEntry(String string) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        return this.keyStoreSpi.engineIsCertificateEntry(string);
    }

    public final boolean isKeyEntry(String string) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        return this.keyStoreSpi.engineIsKeyEntry(string);
    }

    public final void load(InputStream inputStream, char[] cArray) throws IOException, NoSuchAlgorithmException, CertificateException {
        this.keyStoreSpi.engineLoad(inputStream, cArray);
        this.loaded = true;
    }

    public final void setCertificateEntry(String string, Certificate certificate) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        this.keyStoreSpi.engineSetCertificateEntry(string, certificate);
    }

    public final void setKeyEntry(String string, byte[] byArray, Certificate[] certificateArray) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        this.keyStoreSpi.engineSetKeyEntry(string, byArray, certificateArray);
    }

    public final void setKeyEntry(String string, Key key, char[] cArray, Certificate[] certificateArray) throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        this.keyStoreSpi.engineSetKeyEntry(string, key, cArray, certificateArray);
    }

    void setProvider(Provider provider) {
        this.provider = provider;
    }

    void setType(String string) {
        this.type = string;
    }

    public final int size() throws KeyStoreException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        return this.keyStoreSpi.engineSize();
    }

    public final void store(OutputStream outputStream, char[] cArray) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        if (!this.loaded) {
            throw new KeyStoreException();
        }
        this.keyStoreSpi.engineStore(outputStream, cArray);
    }

    private static KeyStore toKeyStoreImplementation(String string) throws KeyStoreException {
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            try {
                return KeyStore.toKeyStoreImplementation(string, provider);
            }
            catch (KeyStoreException keyStoreException) {
                ++n;
            }
        }
        throw new KeyStoreException(string);
    }

    private static KeyStore toKeyStoreImplementation(String string, Provider provider) throws KeyStoreException {
        String string2;
        try {
            string2 = provider.lookupProperty(KEY_PREFIX, string);
        }
        catch (ClassCastException classCastException) {
            throw new KeyStoreException(string);
        }
        if (string2 == null) {
            throw new KeyStoreException(string);
        }
        try {
            Class clazz = Class.forName(string2, true, provider.getClass().getClassLoader());
            return KeyStore.createKeyStore(provider, clazz, string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new KeyStoreException(string);
        }
    }

    public static final String getDefaultType() {
        String string = (String)AccessController.doPrivileged(PriviAction.getSecurityProperty("keystore.type"));
        if (string == null) {
            return "jks";
        }
        return string;
    }
}

