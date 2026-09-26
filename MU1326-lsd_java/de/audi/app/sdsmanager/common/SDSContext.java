/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

public class SDSContext {
    private static final int APP_CONTEXT_CAR;
    private static final int APP_CONTEXT_MAP;
    private static final int APP_CONTEXT_MEDIA;
    private static final int APP_CONTEXT_NAVI;
    private static final int APP_CONTEXT_PHONE;
    private static final int APP_CONTEXT_TONE;
    private static final int APP_CONTEXT_TUNER;
    private static final int APP_CONTEXT_TUNER_FAVORITES;
    private static final int APP_CONTEXT_TUNER_STATIONLIST;
    private static final int APP_CONTEXT_PHONE_PIN_SPELLER;
    private static final int APP_CONTEXT_PHONE_NUMBER_SPELLER;
    private static final int APP_CONTEXT_MEDIA_LIST;
    private static final int APP_CONTEXT_NAVI_DEST_ADDRESS_FORM;
    private static final int APP_CONTEXT_NAVI_DEST_ADDRESS;
    private static final int APP_CONTEXT_PHONE_CALL_IDLE_MAIN;
    private static final int APP_CONTEXT_PHONE_CONTACTS;
    private static final int APP_CONTEXT_PHONE_CONTACTS_DETAIL;
    private static final int APP_CONTEXT_PHONE_FAVORITES_LIST;
    private static final int APP_CONTEXT_TUNER_LIST_SEARCH_MAIN;
    private static final int APP_CONTEXT_TUNER_LIST_COMMON;
    private static final int APP_CONTEXT_TUNER_LIST_ONLINE;
    private static final int APP_CONTEXT_MEDIA_PLAYER_SEARCH_RESULT;
    private static final int APP_CONTEXT_MEDIA_BROWSER_SEARCH;
    private static final int APP_CONTEXT_CONNECT_NAVI_ONLINE_SEARCH;
    private static final int APP_CONTEXT_NAVI_DEST_CONTACTS;
    private static final int APP_CONTEXT_NAVI_DEST_FAVORITES;
    private static final int APP_CONTEXT_NAVI_DEST_INTELLIDEST;
    private static final int APP_CONTEXT_NAVI_DEST_LAST_DEST;
    private static final int APP_CONTEXT_NAVI_DEST_ONLINEDEST;
    private static final int APP_CONTEXT_NAVI_DEST_POI;
    private static final int APP_CONTEXT_NAVI_DEST_POI_PERSONAL;
    private static final int APP_CONTEXT_NAVI_MAP_POI_ON_ROUTE_MAIN;
    private static final int APP_CONTEXT_CAR_SEARCH;
    private static final int APP_CONTEXT_NAVI_DEST_CONTACTS_DETAIL;
    private static final int APP_CONTEXT_PHONE_CALLSTACKS;
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

