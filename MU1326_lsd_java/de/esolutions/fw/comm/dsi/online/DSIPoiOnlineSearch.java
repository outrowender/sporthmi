/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

public interface DSIPoiOnlineSearch {
    public static final String IPL_COMM_UUID = "aa635f1f-b678-5372-8d8b-36d8ab476c26";
    public static final String IPL_COMM_INTERFACE_KEY = "9e515a1f-c3a9-51ef-817e-5074321f2f0d";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public static interface Consts {
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
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

