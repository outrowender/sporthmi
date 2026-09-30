/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.util.Random;

public class SecureRandom
extends Random {
    private static final long serialVersionUID = 4940670005562187L;
    private static final String DEFAULT_ALGORITHM_NAME = "SHA1PRNG";
    private static final String KEY_PREFIX = "SecureRandom.";
    private static SecureRandom DEFAULT = null;
    private Provider provider;
    private SecureRandomSpi secureRandomSpi;
    private byte[] state;
    private MessageDigest digest;
    private byte[] randomBytes;
    private int randomBytesUsed;
    private long counter;
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;
    static /* synthetic */ Class class$3;

    static {
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[7];
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.security.Provider");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[0] = new ObjectStreamField("provider", clazz);
        Class clazz2 = class$1;
        if (clazz2 == null) {
            try {
                clazz2 = class$1 = Class.forName("java.security.SecureRandomSpi");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[1] = new ObjectStreamField("secureRandomSpi", clazz2);
        Class clazz3 = class$2;
        if (clazz3 == null) {
            try {
                clazz3 = class$2 = Class.forName("[B");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[2] = new ObjectStreamField("state", clazz3);
        Class clazz4 = class$3;
        if (clazz4 == null) {
            try {
                clazz4 = class$3 = Class.forName("java.security.MessageDigest");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[3] = new ObjectStreamField("digest", clazz4);
        Class clazz5 = class$2;
        if (clazz5 == null) {
            try {
                clazz5 = class$2 = Class.forName("[B");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[4] = new ObjectStreamField("randomBytes", clazz5);
        objectStreamFieldArray[5] = new ObjectStreamField("randomBytesUsed", Integer.TYPE);
        objectStreamFieldArray[6] = new ObjectStreamField("counter", Long.TYPE);
        serialPersistentFields = objectStreamFieldArray;
    }

    public SecureRandom() {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance(DEFAULT_ALGORITHM_NAME);
            this.secureRandomSpi = secureRandom.secureRandomSpi;
            this.provider = secureRandom.provider;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new Error(noSuchAlgorithmException.toString());
        }
    }

    public SecureRandom(byte[] byArray) {
        this();
        this.setSeed(byArray);
    }

    protected SecureRandom(SecureRandomSpi secureRandomSpi, Provider provider) {
        this.provider = provider;
        this.secureRandomSpi = secureRandomSpi;
    }

    private static SecureRandom createSecureRandom(Provider provider, Class clazz, String string) throws NoSuchAlgorithmException {
        try {
            SecureRandomSpi secureRandomSpi = (SecureRandomSpi)clazz.newInstance();
            SecureRandom secureRandom = new SecureRandom(secureRandomSpi, provider);
            return secureRandom;
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {}
        throw new NoSuchAlgorithmException(string);
    }

    public byte[] generateSeed(int n) {
        return this.secureRandomSpi.engineGenerateSeed(n);
    }

    public static SecureRandom getInstance(String string) throws NoSuchAlgorithmException {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return SecureRandom.toSecureRandomImplementation(string);
    }

    public static SecureRandom getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException {
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
        return SecureRandom.toSecureRandomImplementation(string, provider);
    }

    public static SecureRandom getInstance(String string, Provider provider) throws NoSuchAlgorithmException {
        if (string == null || provider == null) {
            throw new IllegalArgumentException();
        }
        return SecureRandom.toSecureRandomImplementation(string, provider);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public static byte[] getSeed(int n) {
        if (DEFAULT == null) {
            DEFAULT = new SecureRandom();
        }
        byte[] byArray = new byte[n];
        DEFAULT.nextBytes(byArray);
        return byArray;
    }

    protected final int next(int n) {
        if (n == 0) {
            return 0;
        }
        int n2 = n / 8;
        int n3 = n - n2 * 8;
        if (n3 > 0) {
            ++n2;
        }
        byte[] byArray = new byte[n2];
        this.nextBytes(byArray);
        int n4 = byArray[0] & 0xFF;
        if (n3 > 0) {
            n4 >>= 8 - n3;
        }
        int n5 = 1;
        while (n5 < n2) {
            n4 = n4 << 8 | byArray[n5] & 0xFF;
            ++n5;
        }
        return n4;
    }

    public void nextBytes(byte[] byArray) {
        this.secureRandomSpi.engineNextBytes(byArray);
    }

    public void setSeed(byte[] byArray) {
        this.secureRandomSpi.engineSetSeed(byArray);
    }

    public void setSeed(long l) {
        if (this.secureRandomSpi == null) {
            return;
        }
        byte[] byArray = new byte[8];
        int n = 7;
        while (n >= 0) {
            byArray[n] = (byte)(l & 0xFFL);
            l >>>= 8;
            --n;
        }
        this.setSeed(byArray);
    }

    private static SecureRandom toSecureRandomImplementation(String string) throws NoSuchAlgorithmException {
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            try {
                return SecureRandom.toSecureRandomImplementation(string, provider);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n;
            }
        }
        throw new NoSuchAlgorithmException(string);
    }

    private static SecureRandom toSecureRandomImplementation(String string, Provider provider) throws NoSuchAlgorithmException {
        String string2;
        try {
            string2 = provider.getProperty(new StringBuffer(KEY_PREFIX).append(string).toString());
        }
        catch (ClassCastException classCastException) {
            throw new NoSuchAlgorithmException(string);
        }
        if (string2 == null) {
            throw new NoSuchAlgorithmException(string);
        }
        try {
            Class clazz = Class.forName(string2, true, provider.getClass().getClassLoader());
            return SecureRandom.createSecureRandom(provider, clazz, string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoSuchAlgorithmException(string);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putField = objectOutputStream.putFields();
        putField.put("provider", this.provider);
        putField.put("secureRandomSpi", this.secureRandomSpi);
        objectOutputStream.writeFields();
    }
}

