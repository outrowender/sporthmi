/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.swap;

public interface SWaPEventListener {
    public static final int STATE_NOT_INITIALIZED;
    public static final int STATE_LEGAL;
    public static final int STATE_ILLEGAL;
    public static final int STATE_SUPPORTED;
    public static final int STATE_TEMP;
    public static final int STATE_PERM;
    public static final int FSC_SPORTCHRONO;
    public static final int FSC_LOGBOOK;

    default public int[] getFSCs() {
    }

    default public void updateFSC(int n, int n2, int n3) {
    }
}

