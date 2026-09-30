/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.wlan;

import de.esolutions.fw.comm.core.IEnum;

public interface eEncMode
extends IEnum {
    public static final int CRYPTOMODELS_CM_PLAINTEXT = 1;
    public static final int CRYPTOMODELS_CM_WEP64 = 2;
    public static final int CRYPTOMODELS_CM_WEP128 = 3;
    public static final int CRYPTOMODELS_CM_TKIP = 4;
    public static final int CRYPTOMODELS_CM_AES_CCMP = 5;
    public static final int CRYPTOMODELS_CM_WPA2_TKIP = 6;
    public static final int CRYPTOMODELS_CM_WPA2_AES_CCMP = 7;
    public static final int CRYPTOMODELS_CM_WPA_TKIP_AES = 8;
    public static final int CRYPTOMODELS_CM_WPA2_TKIP_AES = 9;
}

