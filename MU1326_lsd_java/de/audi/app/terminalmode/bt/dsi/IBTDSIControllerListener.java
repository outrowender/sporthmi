/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.bt.dsi;

public interface IBTDSIControllerListener {
    public static final int BT_STATE_UNKNOWN = 0;
    public static final int BT_STATE_OFF = 1;
    public static final int BT_STATE_ON = 2;

    public void updateBTState(int var1);
}

