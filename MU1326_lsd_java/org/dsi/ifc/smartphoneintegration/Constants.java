/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.smartphoneintegration;

public interface Constants {
    public static final int CONNECTIONTYPE_OTHER = 0;
    public static final int CONNECTIONTYPE_USB = 1;
    public static final int CONNECTIONTYPE_WLAN = 2;
    public static final int CONNECTIONMETHOD_MIRRORLINK = 1;
    public static final int CONNECTIONMETHOD_CARPLAY = 2;
    public static final int CONNECTIONMETHOD_CARPLAYVERIFIED = 4;
    public static final int CONNECTIONMETHOD_GAL = 8;
    public static final int CONNECTIONMETHOD_CARPLAY_WRONG_PORT = 16;
    public static final int CONNECTIONMETHOD_CARLIFE = 32;
    public static final int CONNECTIONSTATE_DISCONNECTED = 0;
    public static final int CONNECTIONSTATE_CONNECTED = 1;
    public static final int CONNECTIONSTATE_STARTED = 2;
    public static final int CONNECTIONSTATE_STOPPED = 3;
    public static final int CONNECTIONSTATE_FAILED_DEVICE_LOCKED = 4;
    public static final int CONNECTIONSTATE_FAILED_NO_MIRRORLINK_DEVICE = 5;
    public static final int CONNECTIONSTATE_FAILED_NO_CARPLAY_DEVICE = 6;
    public static final int CONNECTIONSTATE_FAILED_NO_GAL_DEVICE = 7;
    public static final int CONNECTIONSTATE_FAILED_TIMEOUT = 8;
    public static final int CONNECTIONSTATE_FAILED_OTHER = 9;
    public static final int CONNECTIONSTATE_FAILED_NO_CARLIFE_DEVICE = 10;
    public static final int SWAPSTATUS_MIRRORLINK = 1;
    public static final int SWAPSTATUS_CARPLAY = 2;
    public static final int SWAPSTATUS_GAL = 4;
    public static final int SWAPSTATUS_CARLIFE = 8;
    public static final int RESETMODE_FACTORYSETTINGS = 1;
    public static final int RESETMODE_CUSTOMERUPDATE = 2;
}

