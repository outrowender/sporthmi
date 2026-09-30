/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public class AlgorithmParameters {
    private static final String KEY_PREFIX = "AlgorithmParameters.";
    private String algorithmName;
    private Provider provider;
    private AlgorithmParametersSpi algorithmParametersSpi;
    private boolean initialized = false;

    protected AlgorithmParameters(AlgorithmParametersSpi algorithmParametersSpi, Provider provider, String string) {
        this.setProvider(provider);
        this.setAlgorithm(string);
        this.algorithmParametersSpi = algorithmParametersSpi;
    }

    private static AlgorithmParameters createAlgorithmParameters(Provider provider, Class clazz, String string) throws NoSuchAlgorithmException {
        try {
            AlgorithmParametersSpi algorithmParametersSpi = (AlgorithmParametersSpi)clazz.newInstance();
            AlgorithmParameters algorithmParameters = new AlgorithmParameters(algorithmParametersSpi, provider, string);
            return algorithmParameters;
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {}
        throw new NoSuchAlgorithmException(string);
    }

    public final String getAlgorithm() {
        return this.algorithmName;
    }

    public final byte[] getEncoded() throws IOException {
        return this.algorithmParametersSpi.engineGetEncoded();
    }

    public final byte[] getEncoded(String string) throws IOException {
        if (string == null) {
            return this.getEncoded();
        }
        return this.algorithmParametersSpi.engineGetEncoded(string);
    }

    public static AlgorithmParameters getInstance(String string) throws NoSuchAlgorithmException {
        if (string != null) {
            return AlgorithmParameters.toAlgorithmParametersImplementation(string);
        }
        throw new IllegalArgumentException();
    }

    public static AlgorithmParameters getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (string2 == null || string == null) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(string2);
        if (provider != null) {
            return AlgorithmParameters.toAlgorithmParametersImplementation(string, provider);
        }
        throw new NoSuchProviderException(string2);
    }

    public static AlgorithmParameters getInstance(String string, Provider provider) throws NoSuchAlgorithmException {
        if (string == null || provider == null) {
            throw new IllegalArgumentException();
        }
        return AlgorithmParameters.toAlgorithmParametersImplementation(string, provider);
    }

    public final AlgorithmParameterSpec getParameterSpec(Class clazz) throws InvalidParameterSpecException {
        if (this.initialized) {
            return this.algorithmParametersSpi.engineGetParameterSpec(clazz);
        }
        throw new InvalidParameterSpecException();
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final void init(byte[] byArray) throws IOException {
        if (this.initialized) {
            throw new IOException();
        }
        this.algorithmParametersSpi.engineInit(byArray);
        this.initialized = true;
    }

    public final void init(byte[] byArray, String string) throws IOException {
        if (this.initialized) {
            throw new IOException();
        }
        this.algorithmParametersSpi.engineInit(byArray, string);
        this.initialized = true;
    }

    public final void init(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (this.initialized) {
            throw new InvalidParameterSpecException();
        }
        this.algorithmParametersSpi.engineInit(algorithmParameterSpec);
        this.initialized = true;
    }

    void setAlgorithm(String string) {
        this.algorithmName = string;
    }

    void setProvider(Provider provider) {
        this.provider = provider;
    }

    private static AlgorithmParameters toAlgorithmParametersImplementation(String string) throws NoSuchAlgorithmException {
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            try {
                return AlgorithmParameters.toAlgorithmParametersImplementation(string, provider);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n;
            }
        }
        throw new NoSuchAlgorithmException(string);
    }

    private static AlgorithmParameters toAlgorithmParametersImplementation(String string, Provider provider) throws NoSuchAlgorithmException {
        String string2;
        try {
            string2 = provider.getProperty(KEY_PREFIX + string);
        }
        catch (ClassCastException classCastException) {
            throw new NoSuchAlgorithmException(string);
        }
        if (string2 == null) {
            throw new NoSuchAlgorithmException(string);
        }
        try {
            Class clazz = Class.forName(string2, true, provider.getClass().getClassLoader());
            return AlgorithmParameters.createAlgorithmParameters(provider, clazz, string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoSuchAlgorithmException(string);
        }
    }

    public final String toString() {
        if (this.initialized) {
            return this.algorithmParametersSpi.engineToString();
        }
        return null;
    }
}

