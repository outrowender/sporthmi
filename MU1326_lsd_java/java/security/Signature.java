/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.Msg;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Set;

public abstract class Signature
extends SignatureSpi {
    protected static final int UNINITIALIZED = 0;
    protected static final int SIGN = 2;
    protected static final int VERIFY = 3;
    protected int state;
    private static final String[] STATE_DESCRIPTION = new String[]{"UNINITIALIZED", "SIGN", "VERIFY"};
    private static final String KEY_PREFIX = "Signature.";
    private String algorithmName;
    private Provider provider;

    protected Signature(String string) {
        this.setAlgorithm(string);
        this.state = 0;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final String getAlgorithm() {
        return this.algorithmName;
    }

    public static Signature getInstance(String string) throws NoSuchAlgorithmException {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return Signature.toSignatureImplementation(string);
    }

    public static Signature getInstance(String string, String string2) throws NoSuchAlgorithmException, NoSuchProviderException {
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
        return Signature.toSignatureImplementation(string, provider);
    }

    public static Signature getInstance(String string, Provider provider) throws NoSuchAlgorithmException {
        if (string == null || provider == null) {
            throw new IllegalArgumentException();
        }
        return Signature.toSignatureImplementation(string, provider);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final void initSign(PrivateKey privateKey) throws InvalidKeyException {
        this.state = 2;
        this.engineInitSign(privateKey);
    }

    public final void initSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.state = 2;
        this.engineInitSign(privateKey, secureRandom);
    }

    public final void initVerify(PublicKey publicKey) throws InvalidKeyException {
        this.state = 3;
        this.engineInitVerify(publicKey);
    }

    public final void initVerify(Certificate certificate) throws InvalidKeyException {
        boolean[] blArray;
        X509Certificate x509Certificate;
        Set set;
        this.state = 3;
        if (certificate instanceof X509Certificate && (set = (x509Certificate = (X509Certificate)certificate).getCriticalExtensionOIDs()) != null && !set.isEmpty() && set.contains("2.5.29.15") && !(blArray = x509Certificate.getKeyUsage())[0]) {
            throw new InvalidKeyException(Msg.getString("K00e4"));
        }
        this.engineInitVerify(certificate.getPublicKey());
    }

    void setAlgorithm(String string) {
        this.algorithmName = string;
    }

    public final void setParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        this.engineSetParameter(algorithmParameterSpec);
    }

    public final AlgorithmParameters getParameters() {
        return this.engineGetParameters();
    }

    void setProvider(Provider provider) {
        this.provider = provider;
    }

    public final byte[] sign() throws SignatureException {
        if (this.state != 2) {
            throw new SignatureException();
        }
        return this.engineSign();
    }

    public final int sign(byte[] byArray, int n, int n2) throws SignatureException {
        if (this.state != 2) {
            throw new SignatureException();
        }
        return this.engineSign(byArray, n, n2);
    }

    private static Signature toSignatureImplementation(String string) throws NoSuchAlgorithmException {
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            try {
                return Signature.toSignatureImplementation(string, provider);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n;
            }
        }
        throw new NoSuchAlgorithmException(string);
    }

    private static Signature toSignatureImplementation(String string, Provider provider) throws NoSuchAlgorithmException {
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
            SignatureSpi signatureSpi = (SignatureSpi)clazz.newInstance();
            Signature signature = signatureSpi instanceof Signature ? (Signature)signatureSpi : new Wrapper(signatureSpi, string);
            signature.setProvider(provider);
            return signature;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(this.getAlgorithm());
        stringBuffer.append(" Signature (");
        stringBuffer.append(STATE_DESCRIPTION[this.state]);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public final void update(byte[] byArray) throws SignatureException {
        if (this.state == 0) {
            throw new SignatureException();
        }
        this.engineUpdate(byArray, 0, byArray.length);
    }

    public final void update(byte[] byArray, int n, int n2) throws SignatureException {
        if (this.state == 0) {
            throw new SignatureException();
        }
        this.engineUpdate(byArray, n, n2);
    }

    public final void update(byte by) throws SignatureException {
        if (this.state == 0) {
            throw new SignatureException();
        }
        this.engineUpdate(by);
    }

    public final boolean verify(byte[] byArray) throws SignatureException {
        if (this.state != 3) {
            throw new SignatureException();
        }
        return this.engineVerify(byArray);
    }

    public final boolean verify(byte[] byArray, int n, int n2) throws SignatureException {
        if (this.state != 3) {
            throw new SignatureException();
        }
        return this.engineVerify(byArray, n, n2);
    }

    private static class Wrapper
    extends Signature {
        SignatureSpi signatureProvider;

        Wrapper(SignatureSpi signatureSpi, String string) {
            super(string);
            this.signatureProvider = signatureSpi;
        }

        public Object clone() throws CloneNotSupportedException {
            Wrapper wrapper = new Wrapper((SignatureSpi)this.signatureProvider.clone(), this.getAlgorithm());
            wrapper.setProvider(this.getProvider());
            return wrapper;
        }

        protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
            this.signatureProvider.engineInitSign(privateKey);
        }

        protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
            this.signatureProvider.engineInitVerify(publicKey);
        }

        protected byte[] engineSign() throws SignatureException {
            return this.signatureProvider.engineSign();
        }

        protected void engineUpdate(byte[] byArray, int n, int n2) throws SignatureException {
            this.signatureProvider.engineUpdate(byArray, n, n2);
        }

        protected void engineUpdate(byte by) throws SignatureException {
            this.signatureProvider.engineUpdate(by);
        }

        protected boolean engineVerify(byte[] byArray) throws SignatureException {
            return this.signatureProvider.engineVerify(byArray);
        }

        public String toString() {
            if (this.signatureProvider != null) {
                return this.signatureProvider.toString();
            }
            return super.toString();
        }
    }
}

