/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

public interface FsgArrayListIdGenerator {
    public int createBAPPosID(long var1);

    public void reset();

    public boolean isBAPPosIDValid(int var1, long var2);

    public boolean isLongID();
}

