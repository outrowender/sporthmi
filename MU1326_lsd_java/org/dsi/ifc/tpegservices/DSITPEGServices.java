/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;

public interface DSITPEGServices
extends DSIBase {
    public static final String VERSION = "2.11.5";
    public static final int RP_REQUESTLOCATIONDETAILSRESPONSE = 2000;
    public static final int RP_REQUESTFUELPRICEINFORMATIONRESPONSE = 2001;
    public static final int RP_REQUESTNEWSINFORMATIONRESPONSE = 2002;
    public static final int RP_REQUESTSIMPLEMAPLISTRESPONSE = 2003;
    public static final int RP_ADDSIMPLEMAPBOOKMARKRESULT = 2004;
    public static final int RP_DELETESIMPLEMAPBOOKMARKRESULT = 2005;
    public static final int RP_DELETEALLSIMPLEMAPBOOKMARKSRESULT = 2006;
    public static final int RP_REQUESTRESOURCEINFORMATIONRESPONSE = 2007;
    public static final int RP_SETLANGUAGERESPONSE = 2008;
    public static final int RP_REQUESTWEATHERINFORESULT = 2009;
    public static final int ATTR_TPEGCONTENTAVAILABILITY = 1;
    public static final int ATTR_SIMPLEMAPSBOOKMARKS = 2;
    public static final int RT_REQUESTSIMPLEMAPLIST = 1000;
    public static final int RT_ADDSIMPLEMAPBOOKMARK = 1001;
    public static final int RT_DELETESIMPLEMAPBOOKMARK = 1002;
    public static final int RT_DELETEALLSIMPLEMAPBOOKMARKS = 1003;
    public static final int RT_REQUESTLOCATIONDETAILS = 1004;
    public static final int RT_REQUESTFUELPRICEINFORMATION = 1005;
    public static final int RT_REQUESTNEWSINFORMATION = 1006;
    public static final int RT_REQUESTRESOURCEINFORMATION = 1007;
    public static final int RT_SETLANGUAGE = 1008;
    public static final int RT_REQUESTSORTEDFUELPRICEINFORMATION = 1009;
    public static final int RT_REQUESTWEATHERINFO = 1010;
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

    public void requestSimpleMapList(int var1, int var2);

    public void addSimpleMapBookmark(int var1);

    public void deleteSimpleMapBookmark(int var1);

    public void deleteAllSimpleMapBookmarks();

    public void requestLocationDetails(int var1);

    public void requestFuelPriceInformation(int var1, int var2);

    public void requestSortedFuelPriceInformation(int var1, int var2, int var3);

    public void requestNewsInformation(int var1);

    public void requestResourceInformation(int var1);

    public void setLanguage(String var1);

    public void requestWeatherInfo(NavLocation var1, int var2, int var3);
}

