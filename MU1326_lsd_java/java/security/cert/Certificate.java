/*
 * Decompiled with CFR 0.152.
 */
package java.security.cert;

import java.io.ByteArrayInputStream;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.zip.CRC32;

public abstract class Certificate
implements Serializable {
    private static final long serialVersionUID = -6751606818319535583L;
    private String type;

    protected Certificate(String string) {
        this.type = string;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        Certificate certificate = null;
        try {
            certificate = (Certificate)object;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        try {
            return Arrays.equals(this.getEncoded(), certificate.getEncoded());
        }
        catch (CertificateEncodingException certificateEncodingException) {
            return false;
        }
    }

    public abstract byte[] getEncoded() throws CertificateEncodingException;

    public abstract PublicKey getPublicKey();

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        try {
            CRC32 cRC32 = new CRC32();
            cRC32.update(this.getEncoded());
            return (int)cRC32.getValue();
        }
        catch (CertificateEncodingException certificateEncodingException) {
            return super.hashCode();
        }
    }

    public abstract String toString();

    public abstract void verify(PublicKey var1) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public abstract void verify(PublicKey var1, String var2) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    protected Object writeReplace() throws ObjectStreamException {
        byte[] byArray = null;
        try {
            byArray = this.getEncoded();
        }
        catch (CertificateEncodingException certificateEncodingException) {
            throw new NotSerializableException(certificateEncodingException.toString());
        }
        return new CertificateRep(this.type, byArray);
    }

    protected static class CertificateRep
    implements Serializable {
        static final long serialVersionUID = -8563758940495660020L;
        String type;
        byte[] data;

        protected CertificateRep(String string, byte[] byArray) {
            this.type = string;
            this.data = byArray;
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(this.type);
                Certificate certificate = certificateFactory.generateCertificate(new ByteArrayInputStream(this.data));
                return certificate;
            }
            catch (CertificateException certificateException) {
                throw new InvalidObjectException(certificateException.toString());
            }
        }
    }
}

