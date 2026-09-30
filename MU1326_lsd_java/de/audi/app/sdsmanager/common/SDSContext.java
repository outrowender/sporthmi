/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

public class SDSContext {
    private static final int APP_CONTEXT_CAR = 0;
    private static final int APP_CONTEXT_MAP = 1;
    private static final int APP_CONTEXT_MEDIA = 2;
    private static final int APP_CONTEXT_NAVI = 4;
    private static final int APP_CONTEXT_PHONE = 5;
    private static final int APP_CONTEXT_TONE = 6;
    private static final int APP_CONTEXT_TUNER = 7;
    private static final int APP_CONTEXT_TUNER_FAVORITES = 8;
    private static final int APP_CONTEXT_TUNER_STATIONLIST = 9;
    private static final int APP_CONTEXT_PHONE_PIN_SPELLER = 10;
    private static final int APP_CONTEXT_PHONE_NUMBER_SPELLER = 11;
    private static final int APP_CONTEXT_MEDIA_LIST = 12;
    private static final int APP_CONTEXT_NAVI_DEST_ADDRESS_FORM = 13;
    private static final int APP_CONTEXT_NAVI_DEST_ADDRESS = 14;
    private static final int APP_CONTEXT_PHONE_CALL_IDLE_MAIN = 15;
    private static final int APP_CONTEXT_PHONE_CONTACTS = 16;
    private static final int APP_CONTEXT_PHONE_CONTACTS_DETAIL = 17;
    private static final int APP_CONTEXT_PHONE_FAVORITES_LIST = 18;
    private static final int APP_CONTEXT_TUNER_LIST_SEARCH_MAIN = 19;
    private static final int APP_CONTEXT_TUNER_LIST_COMMON = 20;
    private static final int APP_CONTEXT_TUNER_LIST_ONLINE = 21;
    private static final int APP_CONTEXT_MEDIA_PLAYER_SEARCH_RESULT = 22;
    private static final int APP_CONTEXT_MEDIA_BROWSER_SEARCH = 23;
    private static final int APP_CONTEXT_CONNECT_NAVI_ONLINE_SEARCH = 24;
    private static final int APP_CONTEXT_NAVI_DEST_CONTACTS = 25;
    private static final int APP_CONTEXT_NAVI_DEST_FAVORITES = 26;
    private static final int APP_CONTEXT_NAVI_DEST_INTELLIDEST = 27;
    private static final int APP_CONTEXT_NAVI_DEST_LAST_DEST = 28;
    private static final int APP_CONTEXT_NAVI_DEST_ONLINEDEST = 29;
    private static final int APP_CONTEXT_NAVI_DEST_POI = 30;
    private static final int APP_CONTEXT_NAVI_DEST_POI_PERSONAL = 31;
    private static final int APP_CONTEXT_NAVI_MAP_POI_ON_ROUTE_MAIN = 32;
    private static final int APP_CONTEXT_CAR_SEARCH = 33;
    private static final int APP_CONTEXT_NAVI_DEST_CONTACTS_DETAIL = 34;
    private static final int APP_CONTEXT_PHONE_CALLSTACKS = -1;
    private final int contextID;

    public SDSContext(int n) {
        this.contextID = n;
    }

    private boolean isCarSearchContext() {
        return this.contextID == 33;
    }

    private boolean isCarDefaultContext() {
        return this.contextID == 0;
    }

    public boolean isCarContext() {
        return this.isCarDefaultContext() || this.isCarSearchContext();
    }

    private boolean isMediaDefaultContext() {
        return this.contextID == 2;
    }

    private boolean isMediaListContext() {
        return this.contextID == 12;
    }

    private boolean isMediaSearchContext() {
        return this.contextID == 23 || this.contextID == 22;
    }

    public boolean isMediaContext() {
        return this.isMediaDefaultContext() || this.isMediaListContext() || this.isMediaSearchContext();
    }

    private boolean isMapContext() {
        return this.contextID == 1;
    }

    private boolean isNaviDefaultContext() {
        return this.contextID == 4;
    }

    private boolean isNaviDestContext() {
        return this.contextID == 14 || this.contextID == 13 || this.contextID == 25 || this.contextID == 34 || this.contextID == 26 || this.contextID == 27 || this.contextID == 28 || this.contextID == 29 || this.contextID == 30 || this.contextID == 31;
    }

    private boolean isNaviMapOnRouteContext() {
        return this.contextID == 32;
    }

    private boolean isNaviOnlineContext() {
        return this.contextID == 24;
    }

    public boolean isNaviContext() {
        return this.isMapContext() || this.isNaviDefaultContext() || this.isNaviDestContext() || this.isNaviMapOnRouteContext() || this.isNaviOnlineContext();
    }

    private boolean isPhoneDefaultContext() {
        return this.contextID == 5;
    }

    private boolean isPhoneIdleContext() {
        return this.contextID == 15;
    }

    private boolean isPhoneContactContext() {
        return this.contextID == 16 || this.contextID == 17;
    }

    private boolean isPhoneListContext() {
        return this.contextID == -1 || this.contextID == 18;
    }

    public boolean isPhoneSpellerContext() {
        return this.contextID == 11 || this.contextID == 10;
    }

    public boolean isPhoneContext() {
        return this.isPhoneContactContext() || this.isPhoneDefaultContext() || this.isPhoneIdleContext() || this.isPhoneListContext() || this.isPhoneSpellerContext();
    }

    private boolean isTunerListContext() {
        return this.contextID == 8 || this.contextID == 20 || this.contextID == 21 || this.contextID == 19 || this.contextID == 9;
    }

    private boolean isTunerDefaultContext() {
        return this.contextID == 7;
    }

    public boolean isTunerContext() {
        return this.isTunerDefaultContext() || this.isTunerListContext();
    }

    public boolean isToneContext() {
        return this.contextID == 6;
    }
}

