/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.bt.dsi;

public interface IBTDSIControllerListener {
    public static final int BT_STATE_UNKNOWN;
    public static final int BT_STATE_OFF;
    public static final int BT_STATE_ON;

    default public void updateBTState(int n) {
    }
}

