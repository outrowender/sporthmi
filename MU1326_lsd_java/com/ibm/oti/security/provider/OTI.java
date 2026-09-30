/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;

public final class OTI
extends Provider {
    private static final String NAME = "OTI";
    private static final double VERSION = 1.4;
    private static final String INFO = "OTI DSA key, parameter generation and signing; SHA-1 digest; SHA1PRNG SecureRandom; JKS keystore";

    public OTI() {
        super(NAME, 1.4, INFO);
        this.registerServices();
    }

    private void registerServices() {
        AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                OTI.this.put("MessageDigest.SHA-1", "com.ibm.oti.security.provider.MessageDigestSHA");
                OTI.this.put("Alg.Alias.MessageDigest.SHA", "SHA-1");
                OTI.this.put("Alg.Alias.MessageDigest.SHA1", "SHA-1");
                OTI.this.put("Alg.Alias.MessageDigest.OID.1.3.14.3.2.26", "SHA-1");
                OTI.this.put("Alg.Alias.MessageDigest.1.3.14.3.2.26", "SHA-1");
                OTI.this.put("MessageDigest.MD5", "com.ibm.oti.security.provider.MessageDigestMD5");
                OTI.this.put("Alg.Alias.MessageDigest.1.2.840.113549.2.5", "MD5");
                OTI.this.put("Alg.Alias.MessageDigest.OID.1.2.840.113549.2.5", "MD5");
                OTI.this.put("SecureRandom.SHA1PRNG", "com.ibm.oti.security.provider.SecureRandomSHA1PRNG");
                OTI.this.put("AlgorithmParameterGenerator.DSA", "com.ibm.oti.security.provider.AlgorithmParameterGeneratorDSA");
                OTI.this.put("AlgorithmParameters.DSA", "com.ibm.oti.security.provider.AlgorithmParametersDSA");
                OTI.this.put("Alg.Alias.AlgorithmParameters.1.2.840.10040.4.1", "DSA");
                OTI.this.put("Alg.Alias.AlgorithmParameters.1.3.14.3.2.12", "DSA");
                OTI.this.put("KeyPairGenerator.DSA", "com.ibm.oti.security.provider.KeyPairGeneratorDSA");
                OTI.this.put("Alg.Alias.KeyPairGenerator.OID.1.2.840.10040.4.1", "DSA");
                OTI.this.put("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1", "DSA");
                OTI.this.put("Alg.Alias.KeyPairGenerator.1.3.14.3.2.12", "DSA");
                OTI.this.put("KeyFactory.DSA", "com.ibm.oti.security.provider.KeyFactoryDSA");
                OTI.this.put("Alg.Alias.KeyFactory.1.2.840.10040.4.1", "DSA");
                OTI.this.put("Alg.Alias.KeyFactory.1.3.14.3.2.12", "DSA");
                OTI.this.put("Signature.SHA1withDSA", "com.ibm.oti.security.provider.SignatureDSA");
                OTI.this.put("Alg.Alias.Signature.DSA", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.DSS", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.SHA/DSA", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.SHA1/DSA", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.SHA-1/DSA", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.SHAwithDSA", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.DSAwithSHA1", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.DSAWithSHA1", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.SHA-1withDSA", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.OID.1.2.840.10040.4.3", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.1.2.840.10040.4.3", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.1.3.14.3.2.13", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.1.3.14.3.2.27", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.OID.1.3.14.3.2.13", "SHA1withDSA");
                OTI.this.put("Alg.Alias.Signature.OID.1.3.14.3.2.27", "SHA1withDSA");
                OTI.this.put("KeyStore.JKS", "com.ibm.oti.security.provider.KeyStore");
                OTI.this.put("CertificateFactory.X509", "com.ibm.oti.security.provider.CertificateFactoryX509");
                OTI.this.put("Alg.Alias.CertificateFactory.X.509", "X509");
                OTI.this.put("KeyPairGenerator.RSA", "com.ibm.oti.security.provider.KeyPairGeneratorRSA");
                OTI.this.put("KeyFactory.RSA", "com.ibm.oti.security.provider.KeyFactoryRSA");
                OTI.this.put("Alg.Alias.KeyFactory.1.3.14.3.2.11", "RSA");
                OTI.this.put("Signature.MD2withRSA", "com.ibm.oti.security.provider.SignatureMD2withRSA");
                OTI.this.put("Alg.Alias.Signature.1.3.14.3.2.24", "MD2withRSA");
                OTI.this.put("Alg.Alias.Signature.OID.1.3.14.3.2.24", "MD2withRSA");
                OTI.this.put("Signature.MD5withRSA", "com.ibm.oti.security.provider.SignatureMD5withRSA");
                OTI.this.put("Alg.Alias.Signature.1.3.14.3.2.3", "MD5withRSA");
                OTI.this.put("Alg.Alias.Signature.OID.1.3.14.3.2.3", "MD5withRSA");
                OTI.this.put("Alg.Alias.Signature.1.3.14.3.2.25", "MD5withRSA");
                OTI.this.put("Alg.Alias.Signature.OID.1.3.14.3.2.25", "MD5withRSA");
                OTI.this.put("Signature.SHA1withRSA", "com.ibm.oti.security.provider.SignatureSHA1withRSA");
                OTI.this.put("Alg.Alias.Signature.SHAwithRSA", "SHA1withRSA");
                OTI.this.put("Alg.Alias.Signature.SHA-1withRSA", "SHA1withRSA");
                OTI.this.put("Alg.Alias.Signature.1.3.14.3.2.15", "SHA1withRSA");
                OTI.this.put("Alg.Alias.Signature.OID.1.3.14.3.2.15", "SHA1withRSA");
                OTI.this.put("Alg.Alias.Signature.1.3.14.3.2.29", "SHA1withRSA");
                OTI.this.put("Alg.Alias.Signature.OID.1.3.14.3.2.29", "SHA1withRSA");
                return null;
            }
        });
    }
}

