/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

public abstract class KeyPairGenerator
extends KeyPairGeneratorSpi {
    private static final String KEY_PREFIX = "KeyPairGenerator.";
    private String algorithmName;
    private Provider provider;

    protected KeyPairGenerator(String string) {
        this.setAlgorithm(string);
    }

    public final KeyPair genKeyPair() {
        return this.generateKeyPair();
    }

    public String getAlgorithm() {
        return this.algorithmName;
    }

    public static KeyPairGenerator getInstance(String string) throws NoSuchAlgorithmException {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return KeyPairGenerator.toKeyPairGeneratorImplementation(string);
    }

    public static KeyPairGenerator getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException {
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
        return KeyPairGenerator.toKeyPairGeneratorImplementation(string, provider);
    }

    public static KeyPairGenerator getInstance(String string, Provider provider) throws NoSuchAlgorithmException {
        if (string == null || provider == null) {
            throw new IllegalArgumentException();
        }
        return KeyPairGenerator.toKeyPairGeneratorImplementation(string, provider);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public void initialize(int n) {
        this.initialize(n, new SecureRandom());
    }

    public void initialize(int n, SecureRandom secureRandom) {
        throw new UnsupportedOperationException();
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        this.initialize(algorithmParameterSpec, new SecureRandom());
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        super.initialize(algorithmParameterSpec, secureRandom);
    }

    void setAlgorithm(String string) {
        this.algorithmName = string;
    }

    void setProvider(Provider provider) {
        this.provider = provider;
    }

    private static KeyPairGenerator toKeyPairGeneratorImplementation(String string) throws NoSuchAlgorithmException {
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            try {
                return KeyPairGenerator.toKeyPairGeneratorImplementation(string, provider);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n;
            }
        }
        throw new NoSuchAlgorithmException(string);
    }

    private static KeyPairGenerator toKeyPairGeneratorImplementation(String string, Provider provider) throws NoSuchAlgorithmException {
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
            KeyPairGeneratorSpi keyPairGeneratorSpi = (KeyPairGeneratorSpi)clazz.newInstance();
            KeyPairGenerator keyPairGenerator = keyPairGeneratorSpi instanceof KeyPairGenerator ? (KeyPairGenerator)keyPairGeneratorSpi : new Wrapper(keyPairGeneratorSpi, string);
            keyPairGenerator.setProvider(provider);
            return keyPairGenerator;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (ClassCastException classCastException) {}
        throw new NoSuchAlgorithmException(string);
    }

    public KeyPair generateKeyPair() {
        return null;
    }

    private static class Wrapper
    extends KeyPairGenerator {
        KeyPairGeneratorSpi keyPairGeneratorProvider;

        Wrapper(KeyPairGeneratorSpi keyPairGeneratorSpi, String string) {
            super(string);
            this.keyPairGeneratorProvider = keyPairGeneratorSpi;
        }

        public KeyPair generateKeyPair() {
            return this.keyPairGeneratorProvider.generateKeyPair();
        }

        public void initialize(int n, SecureRandom secureRandom) {
            this.keyPairGeneratorProvider.initialize(n, secureRandom);
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            this.keyPairGeneratorProvider.initialize(algorithmParameterSpec, secureRandom);
        }
    }
}

