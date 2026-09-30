/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface NaviSDSPOIOnlineService {
    public static final byte OK = 0;
    public static final byte NOK = 1;
    public static final byte INVALID = 2;
    public static final byte LIST_HISTORY = 0;
    public static final byte LIST_RESULTS = 1;
    public static final byte PARTIAL_POPUP = 2;
    public static final byte AUDIO_TYPE_PCM = 0;
    public static final byte AUDIO_TYPE_SPEEX_NO_HEADER = 1;
    public static final byte AUDIO_TYPE_SPEEX_WITH_HEADER = 2;
    public static final int POI_ONLINE_BY_INDEX = -1;
    public static final byte STATUS_DATA_AVAILABLE_OK = 0;
    public static final byte STATUS_DATA_AVAILABLE_ERROR_GENERIC = 1;
    public static final byte STATUS_DATA_AVAILABLE_ERROR_PROXY = 2;
    public static final byte STATUS_DATA_AVAILABLE_TIMEOUT = 3;
    public static final byte STATUS_DATA_AVAILABLE_NO_RESULTS = 4;
    public static final byte STATUS_DATA_AVAILABLE_RECOGNITION_FAILED = 5;
    public static final byte STATUS_DATA_AVAILABLE_LANGUAGE_NOT_SUPPORTED = 6;
    public static final byte STATUS_DATA_AVAILABLE_SPELLING_SUGGESTIONS = 7;
    public static final byte STATUS_DATA_AVAILABLE_SAFE_SEARCH = 8;
    public static final byte STATUS_DATA_AVAILABLE_ERROR_CONNECTION = 9;
    public static final byte SEARCH_AREA_CURRENT_POSITION = 0;
    public static final byte SEARCH_AREA_TARGET_POSITION = 1;
    public static final byte SEARCH_AREA_OTHER_TOWN = 2;
    public static final byte SEARCH_AREA_STOPOVER_POSITION = 6;
    public static final byte USETYPE_UNDEFINED = 0;
    public static final byte USETYPE_TELEPHONE = 1;
    public static final byte USETYPE_NAVIGATION = 2;
    public static final byte USETYPE_ADDRESS_BOOK = 3;

    public byte poiOnlineSearchInit(boolean var1, int var2, String var3);

    public byte poiOnlineSearchCancel();

    public void poiOnlineSearchDidYouMean();

    public byte poiOnlineVoiceDataAvailable(String var1, int var2);

    public void poiOnlineSetSearchArea(byte var1);

    public void markCurrentPOIUsedFor(byte var1);

    public int getCurrentPOIOnlineListSize();

    public void resetCurrentPOIOnlineList();

    public void poiOnlineShowList(byte var1);

    public void selectDestination(int var1);
}

