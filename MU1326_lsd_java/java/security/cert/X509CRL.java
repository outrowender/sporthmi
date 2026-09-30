/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Extension;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public abstract class X509CRL
extends CRL
implements X509Extension {
    protected X509CRL() {
        super("X.509");
    }

    public abstract byte[] getEncoded() throws CRLException;

    public abstract Principal getIssuerDN();

    public abstract Date getNextUpdate();

    public abstract X509CRLEntry getRevokedCertificate(BigInteger var1);

    public abstract Set getRevokedCertificates();

    public abstract String getSigAlgName();

    public abstract String getSigAlgOID();

    public abstract byte[] getSigAlgParams();

    public abstract byte[] getSignature();

    public abstract byte[] getTBSCertList() throws CRLException;

    public abstract Date getThisUpdate();

    public abstract int getVersion();

    public abstract void verify(PublicKey var1) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public abstract void verify(PublicKey var1, String var2) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof X509CRL)) {
            return false;
        }
        X509CRL x509CRL = (X509CRL)object;
        try {
            return Arrays.equals(this.getEncoded(), x509CRL.getEncoded());
        }
        catch (CRLException cRLException) {
            return false;
        }
    }

    public int hashCode() {
        try {
            byte[] byArray = this.getEncoded();
            int n = 1;
            int n2 = 0;
            while (n2 < byArray.length) {
                n *= byArray[n2] & 0xFF;
                ++n2;
            }
            return n;
        }
        catch (CRLException cRLException) {
            return 0;
        }
    }

    public X500Principal getIssuerX500Principal() {
        return new X500Principal(this.getIssuerDN().getName());
    }
}

