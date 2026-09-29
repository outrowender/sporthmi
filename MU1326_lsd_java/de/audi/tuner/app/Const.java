/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

public class Const {
    public static final int BAND_NONE;
    public static final int BAND_FM;
    public static final int BAND_AM;
    public static final int BAND_DAB;
    public static final int BAND_DRM;
    public static final int BAND_SDARS;
    public static final int BAND_SDARS_FAVORITES;
    public static final int BAND_TI;
    public static final int BAND_UNIFIED;
    public static final int BAND_FAVORITES;
    public static final int BAND_HISTORY;
    public static final int BAND_TV;
    public static final int MAX_BANDS;
    public static final int DISPLAYMODE_NAMES_ON;
    public static final int DISPLAYMODE_NAMES_VARIABEL;
    public static final int DISPLAYMODE_NAMES_FIXED;
    public static final int STATUS_NOT_AVAILABLE;
    public static final int STATUS_WAITING;
    public static final int STATUS_LOADED;
    public static final int TRUE;
    public static final int FALSE;
    static final int ENABLED;
    static final int DISABLED;
    public static final int IMAGETYPE_STLOGO;
    public static final int IMAGETYPE_COVERART;
    public static final int IMAGETYPE_SLS;
    public static final int IMAGETYPE_DEFAULT;
    public static final int IMAGETYPE_STLOGO_FROM_DB;
    public static final int SHOW_IMAGETYPE_STLOGO;
    public static final int SHOW_IMAGETYPE_COVERART;
    public static final int SHOW_IMAGETYPE_SLS;
    public static final int SHOW_IMAGETYPE_DEFAULT;
    public static final int MIN_DISLPAY_DURATION_5_SECONDS;
    public static final int MAX_PRESETS_PORSCHE;
    public static final int MAX_FAVORITES_AUDI;
    public static final int MAX_FAVORITES_PGEN2;
    public static final int MAX_NAR_HK_PRESETS;
    public static final int INIT_ALREADY_TRIGGERED;
    public static final int INIT_JUST_EXECUTED;
    public static final int INIT_ERROR_NO_DSI;
    public static final int SDARS_SID_SIZE;
    public static final int SDARS_CATEGORY_SIZE;
    public static final String sxmAffiliateId;

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
        throw new IllegalArgumentException(new StringBuffer().append("SDS-band ").append(n).toString());
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
        throw new IllegalArgumentException(new StringBuffer().append("Radio-band ").append(n).toString());
    }
}

