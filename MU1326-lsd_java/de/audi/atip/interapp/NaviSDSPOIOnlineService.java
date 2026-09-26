/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface NaviSDSPOIOnlineService {
    public static final byte OK;
    public static final byte NOK;
    public static final byte INVALID;
    public static final byte LIST_HISTORY;
    public static final byte LIST_RESULTS;
    public static final byte PARTIAL_POPUP;
    public static final byte AUDIO_TYPE_PCM;
    public static final byte AUDIO_TYPE_SPEEX_NO_HEADER;
    public static final byte AUDIO_TYPE_SPEEX_WITH_HEADER;
    public static final int POI_ONLINE_BY_INDEX;
    public static final byte STATUS_DATA_AVAILABLE_OK;
    public static final byte STATUS_DATA_AVAILABLE_ERROR_GENERIC;
    public static final byte STATUS_DATA_AVAILABLE_ERROR_PROXY;
    public static final byte STATUS_DATA_AVAILABLE_TIMEOUT;
    public static final byte STATUS_DATA_AVAILABLE_NO_RESULTS;
    public static final byte STATUS_DATA_AVAILABLE_RECOGNITION_FAILED;
    public static final byte STATUS_DATA_AVAILABLE_LANGUAGE_NOT_SUPPORTED;
    public static final byte STATUS_DATA_AVAILABLE_SPELLING_SUGGESTIONS;
    public static final byte STATUS_DATA_AVAILABLE_SAFE_SEARCH;
    public static final byte STATUS_DATA_AVAILABLE_ERROR_CONNECTION;
    public static final byte SEARCH_AREA_CURRENT_POSITION;
    public static final byte SEARCH_AREA_TARGET_POSITION;
    public static final byte SEARCH_AREA_OTHER_TOWN;
    public static final byte SEARCH_AREA_STOPOVER_POSITION;
    public static final byte USETYPE_UNDEFINED;
    public static final byte USETYPE_TELEPHONE;
    public static final byte USETYPE_NAVIGATION;
    public static final byte USETYPE_ADDRESS_BOOK;

    default public byte poiOnlineSearchInit(boolean bl, int n, String string) {
    }

    default public byte poiOnlineSearchCancel() {
    }

    default public void poiOnlineSearchDidYouMean() {
    }

    default public byte poiOnlineVoiceDataAvailable(String string, int n) {
    }

    default public void poiOnlineSetSearchArea(byte by) {
    }

    default public void markCurrentPOIUsedFor(byte by) {
    }

    default public int getCurrentPOIOnlineListSize() {
    }

    default public void resetCurrentPOIOnlineList() {
    }

    default public void poiOnlineShowList(byte by) {
    }

    default public void selectDestination(int n) {
    }
}

