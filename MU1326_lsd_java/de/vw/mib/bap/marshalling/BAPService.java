/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

public interface BAPService {
    public void request(int var1, int var2, int var3, int var4);

    public void requestVoid(int var1, int var2);

    public void requestByteSequence(int var1, int var2, byte[] var3);

    public void requestError(int var1, int var2);

    public void setIndicationError(int var1, int var2);
}

