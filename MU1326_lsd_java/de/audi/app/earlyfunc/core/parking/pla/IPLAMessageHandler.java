/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

public interface IPLAMessageHandler {
    public static final int INVALID_POPUP_ID = -1;
    public static final int PLA_OPS_STANDALONE_INACTIVE = 0;
    public static final int PLA_OPS_STANDALONE_LEFT_SEARCH = 1;
    public static final int PLA_OPS_STANDALONE_RIGHT_SEARCH = 2;

    public void init();

    public void deinit();

    public void showMessage(int var1);

    public void updateMessage();

    public void setPlaOpsStandaloneState(int var1);
}

