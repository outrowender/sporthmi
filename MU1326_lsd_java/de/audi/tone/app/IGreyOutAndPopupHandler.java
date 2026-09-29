/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

public interface IGreyOutAndPopupHandler {
    public static final int HIDE_MENU_GREYOUT_POPUP;
    public static final int SHOW_MENU_GREYOUT_POPUP;
    public static final int NO_ANNOUNCEMENT_ACTIVE;
    public static final int APS_ACTIVE;
    public static final int TA_ACTIVE;
    public static final int SDS_ACTIVE;
    public static final int NAVI_ANNOUNCEMENT_ACTIVE;
    public static final int PHONE_CALL_ACTIVE;
    public static final int CONNECTED_GATEWAY_ACTIVE;
    public static final int A2LS_ACTIVE;

    default public void updateActiveEntertainmentConnection(int n, int n2) {
    }

    default public void updateActiveConnection(int n, int n2) {
    }

    default public int getGreyOutState() {
    }
}

