/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.Serializable;

public abstract class SecureRandomSpi
implements Serializable {
    protected abstract byte[] engineGenerateSeed(int var1);

    protected abstract void engineNextBytes(byte[] var1);

    protected abstract void engineSetSeed(byte[] var1);
}

