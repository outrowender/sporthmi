/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.swap;

public interface SWaPEventListener {
    public static final int STATE_NOT_INITIALIZED = -1;
    public static final int STATE_LEGAL = 0;
    public static final int STATE_ILLEGAL = 1;
    public static final int STATE_SUPPORTED = 2;
    public static final int STATE_TEMP = 3;
    public static final int STATE_PERM = 4;
    public static final int FSC_SPORTCHRONO = 394496;
    public static final int FSC_LOGBOOK = 394752;

    public int[] getFSCs();

    public void updateFSC(int var1, int var2, int var3);
}

