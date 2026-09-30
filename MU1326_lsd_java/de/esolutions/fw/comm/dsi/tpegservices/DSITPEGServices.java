/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices;

public interface DSITPEGServices {
    public static final String IPL_COMM_UUID = "fd9bc210-a829-5360-b874-09b6978b5b51";
    public static final String IPL_COMM_INTERFACE_KEY = "7df675ac-5a57-5e93-bcae-c171725c0d43";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.5";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.5";

    public static interface Consts {
        public static final String VERSION = "2.11.5";
        public static final int TPEGSERVICE_UNKNOWN = 0;
        public static final int TPEGSERVICE_OILPRICE = 1;
        public static final int TPEGSERVICE_NEWS = 2;
        public static final int TPEGSERVICE_WEATHER = 3;
        public static final int SIMPLEMAP_CONTENTTYPE_UNKNOWN = 0;
        public static final int SIMPLEMAP_CONTENTTYPE_TOPLIST = 1;
        public static final int SIMPLEMAP_CONTENTTYPE_SUBLIST = 2;
        public static final int SIMPLEMAP_CONTENTTYPE_MAPLIST = 3;
        public static final int SIMPLEMAP_CONTENTTYPE_COMPLETELIST = 4;
        public static final int TPEGNEWSCATEGORY_UNKNOWN = 0;
        public static final int TPEGNEWSCATEGORY_SOCIALAFFAIRS = 1;
        public static final int TPEGNEWSCATEGORY_POLITICS = 2;
        public static final int TPEGNEWSCATEGORY_ENTERTAINMENT = 3;
        public static final int TPEGNEWSCATEGORY_SPORTS = 4;
        public static final int TPEGNEWSCATEGORY_BUSINESS = 5;
        public static final int TPEGNEWSCATEGORY_NATIONAL = 6;
        public static final int TPEGNEWSCATEGORY_TECHNOLOGY = 7;
        public static final int TPEGNEWSCATEGORY_WEATHER = 8;
        public static final int RESULT_UNKNOWN = 0;
        public static final int RESULT_OK = 1;
        public static final int RESULT_BOOKMARK_FULL_WARNING = 2;
        public static final int RESULT_ERROR = 3;
        public static final int SORTORDER_DEFAULT = 0;
        public static final int SORTORDER_PRICE = 1;
        public static final int SORTORDER_DISTANCE = 2;
        public static final int WEATHERREQUESTMODE_CCP = 0;
        public static final int WEATHERREQUESTMODE_SELECTEDLOCATION = 1;
        public static final int WEATHERINFOTYPE_UNKNOWN = 0;
        public static final int WEATHERINFOTYPE_PERIOD_1 = 1;
        public static final int WEATHERINFOTYPE_PERIOD_2 = 2;
        public static final int WEATHERINFOTYPE_PERIOD_3 = 3;
        public static final int WEATHERINFOTYPE_PERIOD_4 = 4;
        public static final int WEATHERINFOTYPE_PERIOD_5 = 5;
        public static final int WEATHERINFOTYPE_PERIOD_6 = 6;
        public static final int WEATHERINFOTYPE_PERIOD_7 = 7;
        public static final int WEATHERINFOTYPE_PERIOD_8 = 8;
        public static final int WEATHERINFOTYPE_PERIOD_9 = 9;
        public static final int WEATHERINFOINTERVAL_UNKNOWN = 0;
        public static final int WEATHERINFOINTERVAL_1HOUR = 1;
        public static final int WEATHERINFOINTERVAL_3HOURS = 2;
        public static final int WEATHERINFOINTERVAL_1DAY = 3;
        public static final int WEATHERTYPE_UNKNOWN = 0;
        public static final int WEATHERTYPE_CLEAR = 1;
        public static final int WEATHERTYPE_SLIGHTLY_CLOUDY = 2;
        public static final int WEATHERTYPE_PARTLY_CLOUDY = 3;
        public static final int WEATHERTYPE_CLOUDY = 4;
        public static final int WEATHERTYPE_RAIN = 5;
        public static final int WEATHERTYPE_SNOW = 6;
        public static final int WEATHERTYPE_RAIN_OR_SNOW = 7;
        public static final int REQUESTWEATHERRESULT_OK = 0;
        public static final int REQUESTWEATHERRESULT_ERROR = 1;
        public static final int REQUESTWEATHERRESULT_NODATA = 2;
        public static final int REQUESTWEATHERRESULT_CACHED_DATA = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

