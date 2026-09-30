/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

public interface BAPOperationState {
    public static final int STATE_NORMAL_OPERATION = 0;
    public static final int STATE_OFF_STAND_BY = 1;
    public static final int STATE_INITIALIZING = 3;
    public static final int STATE_DEFECT = 15;

    public int getState();
}

