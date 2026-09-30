/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

public interface IGreyOutAndPopupHandler {
    public static final int HIDE_MENU_GREYOUT_POPUP = 0;
    public static final int SHOW_MENU_GREYOUT_POPUP = 1;
    public static final int NO_ANNOUNCEMENT_ACTIVE = 0;
    public static final int APS_ACTIVE = 1;
    public static final int TA_ACTIVE = 4;
    public static final int SDS_ACTIVE = 2;
    public static final int NAVI_ANNOUNCEMENT_ACTIVE = 3;
    public static final int PHONE_CALL_ACTIVE = 5;
    public static final int CONNECTED_GATEWAY_ACTIVE = 6;
    public static final int A2LS_ACTIVE = 7;

    public void updateActiveEntertainmentConnection(int var1, int var2);

    public void updateActiveConnection(int var1, int var2);

    public int getGreyOutState();
}

