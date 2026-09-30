/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public interface DSIPoiOnlineSearch
extends DSIBase {
    public static final String VERSION = "2.11.42";
    public static final int TYPEOFREQUEST_FREETYPE = 1;
    public static final int TYPEOFREQUEST_DYNAMICPOI = 2;
    public static final int DYNAMICPOICATEGORY_GAS_STATIONS = 1;
    public static final int DYNAMICPOICATEGORY_PARKINGLOTS = 2;
    public static final int DYNAMICPOICATEGORY_NATURALGAS_STATIONS = 3;
    public static final int DYNAMICPOICATEGORY_ECHARGING_STATIONS = 4;
    public static final int DYNAMICPOICATEGORY_ECHARGING_STATIONS_NORMAL = 5;
    public static final int DYNAMICPOICATEGORY_ECHARGING_STATIONS_FAST = 6;
    public static final int SORTKEY_DEFAULT = 0;
    public static final int SORTKEY_DISTANCE = 1;
    public static final int SORTKEY_CATEGORY_DATA = 2;
    public static final int SOURCEID_AUDI = 1;
    public static final int SOURCEID_GOOGLE = 2;
    public static final int SOURCEID_YAHOO = 3;
    public static final int SOURCEID_LYCOS = 4;
    public static final int SOURCEID_MSN = 5;
    public static final int SOURCEID_AOL = 6;
    public static final int SOURCEID_TONLINE = 7;
    public static final int SOURCEID_TINFO = 8;
    public static final int SOURCEID_VW = 9;
    public static final int STATUS_OK_INIT = 10;
    public static final int STATUS_OK_SEARCH_COMPLETE = 11;
    public static final int STATUS_OK_SEARCH_CANCELED = 12;
    public static final int STATUS_ERROR_CAR_HARDWARE = 21;
    public static final int STATUS_ERROR_CAR_DSI = 22;
    public static final int STATUS_ERROR_CAR_CONNECTIVITY_SETUP = 23;
    public static final int STATUS_ERROR_CAR_CONNECTIVITY_ERROR = 24;
    public static final int STATUS_ERROR_POISTS_SSL_HANDSHAKE_FAILED = 31;
    public static final int STATUS_ERROR_POISTS_TIMEOUT = 41;
    public static final int STATUS_ERROR_POISTS_CONNECTION_CLOSED = 42;
    public static final int STATUS_ERROR_POISTS_CONNECTION_REJECTED = 43;
    public static final int STATUS_ERROR_POISTS_PARSE = 44;
    public static final int STATUS_ERROR_POISTS_HOST_UNRESOLVABLE = 45;
    public static final int STATUS_ERROR_POISTS_UNKNOWN_ERROR = 46;
    public static final int STATUS_ERROR_POISTS_INVALID_INPUT = 47;
    public static final int STATUS_ERROR_POISTS_URL_INVALID = 48;
    public static final int STATUS_ERROR_POIDB_TIMEOUT = 51;
    public static final int STATUS_ERROR_POIDB_CONNECTION_CLOSED = 52;
    public static final int STATUS_ERROR_POIDB_CONNECTION_REJECTED = 53;
    public static final int STATUS_ERROR_POIDB_PARSE = 54;
    public static final int STATUS_ERROR_POIDB_HOST_UNRESOLVABLE = 55;
    public static final int STATUS_ERROR_POIDB_UNKNOWN_ERROR = 56;
    public static final int STATUS_ERROR_VOICE_LANGUAGE_NOT_SUPPORTED = 57;
    public static final int STATUS_ERROR_VOICE_NOT_RECOGNIZED = 58;
    public static final int STATUS_ERROR_VOICE_RECOGNIZED_NO_RESULTS = 59;
    public static final int STATUS_ERROR_LANGUAGE_NOT_SUPPORTED = 61;
    public static final int STATUS_ERROR_VOICE_RECOGNITION_FAILED = 62;
    public static final int STATUS_ERROR_PROFANITY_DETECTED = 63;
    public static final int RESULTSOURCE_POI = 0;
    public static final int RESULTSOURCE_SDS = 1;
    public static final int USEDPOI_UNKNOWN = 0;
    public static final int USEDPOI_NAVIGATETO = 10;
    public static final int USEDPOI_PHONECALL = 11;
    public static final int USEDPOI_ADDEDTOADDRESSBOOK = 12;
    public static final int TYPEOFPOI_UNKNOWN = 0;
    public static final int TYPEOFPOI_REGULAR = 1;
    public static final int TYPEOFPOI_AD = 2;
    public static final int RT_POISTARTSELECTION = 1000;
    public static final int RT_POISTOPSELECTION = 1001;
    public static final int RT_POIREQUESTVALUELIST = 1002;
    public static final int RT_POIREQUESTSPELLINGSUGGESTION = 1003;
    public static final int RT_USEDPOI = 1004;
    public static final int RT_SETLANGUAGE = 1005;
    public static final int RT_SETFALLBACKLANGUAGE = 1006;
    public static final int RT_POIVOICESEARCHACTIVE = 1007;
    public static final int RT_POISTARTVOICESELECTION = 1008;
    public static final int RT_POIRAWVOICEDATAAVAILABLE = 1011;
    public static final int RT_POISTARTSELECTIONZOOM = 1012;
    public static final int RT_DYNAMICPOISTARTSELECTION = 1013;
    public static final int RT_DYNAMICPOISTARTSELECTIONZOOM = 1014;
    public static final int RT_PRECHECKDYNAMICPOICATEGORY = 1015;
    public static final int RP_POIRESULT = 2000;
    public static final int RP_POISPELLINGSUGGESTION = 2001;
    public static final int RP_POIVALUELIST = 2002;
    public static final int RP_PRECHECKDYNAMICPOICATEGORYRESPONSE = 2003;

    public void poiStartSelectionZoom(String var1, int var2, int var3, int var4, int var5, int var6);

    public void dynamicPoiStartSelectionZoom(int var1, int var2, int var3, int var4, int var5, int var6, int var7);

    public void poiStartSelection(String var1, int var2, int var3, int var4, int var5);

    public void dynamicPoiStartSelection(int var1, int var2, int var3, int var4, int var5, int var6);

    public void poiStopSelection();

    public void poiRequestValueList(int var1, int var2);

    public void poiStartVoiceSelection(int var1, int var2, int var3, int var4, boolean var5, int var6);

    public void poiRawVoiceDataAvailable(String var1, int var2);

    public void poiRequestSpellingSuggestion();

    public void usedPoi(PoiOnlineSearchValuelistElement var1, int var2);

    public void setLanguage(String var1);

    public void setFallbackLanguage(String var1);

    public void poiVoiceSearchActive();

    public void precheckDynamicPOICategory(int var1);
}

