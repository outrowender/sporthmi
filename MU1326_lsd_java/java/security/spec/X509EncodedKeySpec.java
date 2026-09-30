/*
 * Decompiled with CFR 0.152.
 */
package java.security.spec;

import java.security.spec.EncodedKeySpec;

public class X509EncodedKeySpec
extends EncodedKeySpec {
    public X509EncodedKeySpec(byte[] byArray) {
        super(byArray);
    }

    public byte[] getEncoded() {
        return super.getEncoded();
    }

    public final String getFormat() {
        return "X.509";
    }
}

