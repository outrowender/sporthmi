/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

public class Const {
    public static final int BAND_NONE = 8;
    public static final int BAND_FM = 1;
    public static final int BAND_AM = 4;
    public static final int BAND_DAB = 5;
    public static final int BAND_DRM = 6;
    public static final int BAND_SDARS = 7;
    public static final int BAND_SDARS_FAVORITES = 8;
    public static final int BAND_TI = 10;
    public static final int BAND_UNIFIED = 11;
    public static final int BAND_FAVORITES = 12;
    public static final int BAND_HISTORY = 13;
    public static final int BAND_TV = 15;
    public static final int MAX_BANDS = 16;
    public static final int DISPLAYMODE_NAMES_ON = 1;
    public static final int DISPLAYMODE_NAMES_VARIABEL = 0;
    public static final int DISPLAYMODE_NAMES_FIXED = 1;
    public static final int STATUS_NOT_AVAILABLE = 0;
    public static final int STATUS_WAITING = 1;
    public static final int STATUS_LOADED = 2;
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    static final int ENABLED = 1;
    static final int DISABLED = 0;
    public static final int IMAGETYPE_STLOGO = 0;
    public static final int IMAGETYPE_COVERART = 1;
    public static final int IMAGETYPE_SLS = 2;
    public static final int IMAGETYPE_DEFAULT = 3;
    public static final int IMAGETYPE_STLOGO_FROM_DB = 4;
    public static final int SHOW_IMAGETYPE_STLOGO = 1;
    public static final int SHOW_IMAGETYPE_COVERART = 2;
    public static final int SHOW_IMAGETYPE_SLS = 4;
    public static final int SHOW_IMAGETYPE_DEFAULT = 8;
    public static final int MIN_DISLPAY_DURATION_5_SECONDS = 5000;
    public static final int MAX_PRESETS_PORSCHE = 15;
    public static final int MAX_FAVORITES_AUDI = 50;
    public static final int MAX_FAVORITES_PGEN2 = 20;
    public static final int MAX_NAR_HK_PRESETS = 8;
    public static final int INIT_ALREADY_TRIGGERED = 0;
    public static final int INIT_JUST_EXECUTED = 1;
    public static final int INIT_ERROR_NO_DSI = 2;
    public static final int SDARS_SID_SIZE = 384;
    public static final int SDARS_CATEGORY_SIZE = 256;
    public static final String sxmAffiliateId = "Jg8Ac3PqA8Y";

    public static int sds2RadioBand(int n) {
        switch (n) {
            case 4: {
                return 4;
            }
            case 8: {
                return 10;
            }
            case 1: {
                return 1;
            }
            case 5: {
                return 5;
            }
            case 7: {
                return 7;
            }
            case 9: {
                return 11;
            }
            case 10: {
                return 12;
            }
            case 11: {
                return 13;
            }
            case 14: {
                return 8;
            }
        }
        throw new IllegalArgumentException("SDS-band " + n);
    }

    public static int radioBand2SdsBand(int n) {
        switch (n) {
            case 4: {
                return 4;
            }
            case 10: {
                return 8;
            }
            case 1: {
                return 1;
            }
            case 5: {
                return 5;
            }
            case 7: {
                return 7;
            }
            case 11: {
                return 9;
            }
            case 12: {
                return 10;
            }
            case 13: {
                return 11;
            }
        }
        throw new IllegalArgumentException("Radio-band " + n);
    }
}

