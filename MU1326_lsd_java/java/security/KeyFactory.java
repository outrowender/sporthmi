/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class KeyFactory {
    private static final String KEY_PREFIX = "KeyFactory.";
    private String algorithmName;
    private Provider provider;
    private KeyFactorySpi keyFactorySpi;

    protected KeyFactory(KeyFactorySpi keyFactorySpi, Provider provider, String string) {
        this.setProvider(provider);
        this.setAlgorithm(string);
        this.keyFactorySpi = keyFactorySpi;
    }

    private static KeyFactory createKeyFactory(Provider provider, Class clazz, String string) throws NoSuchAlgorithmException {
        try {
            KeyFactorySpi keyFactorySpi = (KeyFactorySpi)clazz.newInstance();
            return new KeyFactory(keyFactorySpi, provider, string);
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {}
        throw new NoSuchAlgorithmException(string);
    }

    public final PrivateKey generatePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        return this.keyFactorySpi.engineGeneratePrivate(keySpec);
    }

    public final String getAlgorithm() {
        return this.algorithmName;
    }

    public static KeyFactory getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (string2 == null) {
            throw new IllegalArgumentException();
        }
        if (string == null) {
            throw new IllegalArgumentException();
        }
        if (string2.equals("")) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(string2);
        if (provider == null) {
            throw new NoSuchProviderException(string2);
        }
        return KeyFactory.toKeyFactoryImplementation(string, provider);
    }

    public static KeyFactory getInstance(String string, Provider provider) throws NoSuchAlgorithmException {
        if (string == null || provider == null) {
            throw new IllegalArgumentException();
        }
        return KeyFactory.toKeyFactoryImplementation(string, provider);
    }

    public final KeySpec getKeySpec(Key key, Class clazz) throws InvalidKeySpecException {
        return this.keyFactorySpi.engineGetKeySpec(key, clazz);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    void setAlgorithm(String string) {
        this.algorithmName = string;
    }

    void setProvider(Provider provider) {
        this.provider = provider;
    }

    private static KeyFactory toKeyFactoryImplementation(String string) throws NoSuchAlgorithmException {
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            try {
                return KeyFactory.toKeyFactoryImplementation(string, provider);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n;
            }
        }
        throw new NoSuchAlgorithmException(string);
    }

    private static KeyFactory toKeyFactoryImplementation(String string, Provider provider) throws NoSuchAlgorithmException {
        String string2;
        try {
            string2 = provider.lookupProperty(KEY_PREFIX, string);
        }
        catch (ClassCastException classCastException) {
            throw new NoSuchAlgorithmException(string);
        }
        if (string2 == null) {
            throw new NoSuchAlgorithmException(string);
        }
        try {
            Class clazz = Class.forName(string2, true, provider.getClass().getClassLoader());
            return KeyFactory.createKeyFactory(provider, clazz, string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoSuchAlgorithmException(string);
        }
    }

    public final Key translateKey(Key key) throws InvalidKeyException {
        return this.keyFactorySpi.engineTranslateKey(key);
    }

    public final PublicKey generatePublic(KeySpec keySpec) throws InvalidKeySpecException {
        return this.keyFactorySpi.engineGeneratePublic(keySpec);
    }

    public static KeyFactory getInstance(String string) throws NoSuchAlgorithmException {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return KeyFactory.toKeyFactoryImplementation(string);
    }
}

