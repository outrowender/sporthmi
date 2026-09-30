/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

public interface BAPServiceListener {
    public boolean indication(int var1, int var2, int var3, int var4);

    public boolean indication(int var1, int var2);

    public boolean indication(int var1, int var2, byte[] var3);

    public boolean indicationError(int var1, int var2);

    public boolean acknowledge(int var1, int var2);
}

