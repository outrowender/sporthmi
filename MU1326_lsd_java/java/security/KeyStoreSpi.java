/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;

public abstract class KeyStoreSpi {
    public abstract Enumeration engineAliases();

    public abstract boolean engineContainsAlias(String var1);

    public abstract void engineDeleteEntry(String var1) throws KeyStoreException;

    public abstract Certificate engineGetCertificate(String var1);

    public abstract String engineGetCertificateAlias(Certificate var1);

    public abstract Certificate[] engineGetCertificateChain(String var1);

    public abstract Date engineGetCreationDate(String var1);

    public abstract Key engineGetKey(String var1, char[] var2) throws NoSuchAlgorithmException, UnrecoverableKeyException;

    public abstract boolean engineIsCertificateEntry(String var1);

    public abstract boolean engineIsKeyEntry(String var1);

    public abstract void engineLoad(InputStream var1, char[] var2) throws IOException, NoSuchAlgorithmException, CertificateException;

    public abstract void engineSetCertificateEntry(String var1, Certificate var2) throws KeyStoreException;

    public abstract void engineSetKeyEntry(String var1, byte[] var2, Certificate[] var3) throws KeyStoreException;

    public abstract void engineSetKeyEntry(String var1, Key var2, char[] var3, Certificate[] var4) throws KeyStoreException;

    public abstract int engineSize();

    public abstract void engineStore(OutputStream var1, char[] var2) throws IOException, NoSuchAlgorithmException, CertificateException;
}

