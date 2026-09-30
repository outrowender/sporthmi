/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.Identity;
import java.security.IdentityScope;
import java.security.InvalidParameterException;
import java.security.KeyException;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public abstract class Signer
extends Identity {
    private static final long serialVersionUID = -1763464102261361480L;
    PrivateKey privateKey;

    protected Signer() {
    }

    public Signer(String string) {
        super(string);
    }

    public Signer(String string, IdentityScope identityScope) throws KeyManagementException {
        super(string, identityScope);
    }

    public PrivateKey getPrivateKey() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("getSignerPrivateKey");
        }
        return this.privateKey;
    }

    public final void setKeyPair(KeyPair keyPair) throws InvalidParameterException, KeyException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("setSignerKeyPair");
        }
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        if (privateKey == null || publicKey == null) {
            throw new InvalidParameterException();
        }
        this.setPublicKey(publicKey);
        this.privateKey = privateKey;
    }

    public String toString() {
        return super.toString();
    }
}

