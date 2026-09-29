/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

public interface IPLAMessageHandler {
    public static final int INVALID_POPUP_ID;
    public static final int PLA_OPS_STANDALONE_INACTIVE;
    public static final int PLA_OPS_STANDALONE_LEFT_SEARCH;
    public static final int PLA_OPS_STANDALONE_RIGHT_SEARCH;

    default public void init() {
    }

    default public void deinit() {
    }

    default public void showMessage(int n) {
    }

    default public void updateMessage() {
    }

    default public void setPlaOpsStandaloneState(int n) {
    }
}

