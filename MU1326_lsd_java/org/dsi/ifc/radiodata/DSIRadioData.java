/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radiodata;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public interface DSIRadioData
extends DSIBase {
    public static final String VERSION = "2.11.4";
    public static final int RT_REQUESTRADIOSTATIONDATA = 1000;
    public static final int RT_REQUESTRADIOSTATIONLOGOS = 1001;
    public static final int RT_REQUESTDYNAMICDATABASEALTERATION = 1002;
    public static final int RT_REQUESTCOUNTRYLISTUPDATE = 1003;
    public static final int RT_REQUESTDATABASEVERSIONINFO = 1004;
    public static final int RT_REQUESTPERSISTSTATIONLOGOS = 1005;
    public static final int RT_REQUESTCOUNTRYREGIONDATA = 1006;
    public static final int RT_REQUESTCOUNTRYREGIONTRANSLATIONDATA = 1007;
    public static final int RT_PROFILECHANGE = 1008;
    public static final int RT_PROFILECOPY = 1009;
    public static final int RT_PROFILERESET = 1010;
    public static final int RT_PROFILERESETALL = 1011;
    public static final int RP_RESPONSERADIOSTATIONDATA = 2000;
    public static final int RP_RESPONSERADIOSTATIONLOGOS = 2001;
    public static final int RP_RESPONSEDYNAMICDATABASEALTERATION = 2002;
    public static final int RP_RESPONSECOUNTRYLIST = 2003;
    public static final int RP_RESPONSEDATABASEVERSIONINFO = 2004;
    public static final int RP_RESPONSEPERSISTSTATIONLOGOS = 2005;
    public static final int RP_RESPONSECOUNTRYREGIONDATA = 2006;
    public static final int RP_RESPONSECOUNTRYREGIONTRANSLATIONDATA = 2007;
    public static final int RP_RESPONSEPERSISTSTATIONLOGOSWITHCHANGEDURLS = 2008;
    public static final int RP_PROFILECHANGED = 2009;
    public static final int RP_PROFILECOPIED = 2010;
    public static final int RP_PROFILERESET = 2011;
    public static final int RP_PROFILERESETALL = 2012;
    public static final int ATTR_DATABASESTATE = 1;
    public static final int ATTR_RADIOSTATIONLOGOS = 2;
    public static final int ATTR_PROFILESTATE = 3;
    public static final int ATTR_PERSISTSTATIONLOGOSWITHCHANGEDURLS = 4;
    public static final int DATABASESTATE_DB_DOES_NOT_EXISTS = 0;
    public static final int DATABASESTATE_DB_NOT_AVAILABLE = 1;
    public static final int DATABASESTATE_DB_AVAILABLE = 2;
    public static final int DATABASESTATE_DB_VERSION_UPDATE = 3;
    public static final int DATABASEALTERATION_DELETE_STATION = 0;
    public static final int DATABASEALTERATION_DELETE_LOGO = 1;
    public static final int DATABASEALTERATION_DELETE_STATION_AND_LOGO = 2;
    public static final int DATABASEALTERATION_ADD_STATION = 3;
    public static final int DATABASEALTERATION_ADD_LOGO = 4;
    public static final int DATABASEALTERATION_ADD_STATION_AND_LOGO = 5;
    public static final int DATABASEALTERATIONRESPONSE_DELETE_STATION = 0;
    public static final int DATABASEALTERATIONRESPONSE_DELETE_LOGO = 1;
    public static final int DATABASEALTERATIONRESPONSE_DELETE_STATION_AND_LOGO = 2;
    public static final int DATABASEALTERATIONRESPONSE_ADD_STATION = 3;
    public static final int DATABASEALTERATIONRESPONSE_ADD_LOGO = 4;
    public static final int DATABASEALTERATIONRESPONSE_ADD_STATION_AND_LOGO = 5;
    public static final int DATABASEALTERATIONRESPONSE_DB_DOES_NOT_EXISTS = 6;
    public static final int DATABASEALTERATIONRESPONSE_DB_NOT_AVAILABLE = 7;
    public static final int DATABASEALTERATIONRESPONSE_DB_VERSION_UPDATE = 8;
    public static final int LOGOPRIORITY_MANUAL_LOGO = 0;
    public static final int LOGOPRIORITY_NEWEST_LOGO = 1;
    public static final int LOGOPRIORITY_STATIC_LOGO = 2;
    public static final int LOGOPRIORITY_ALL_LOGOS = 3;
    public static final int LOGOPRIORITY_GENERIC_LOGO = 4;
    public static final int REQUESTPERSISTSTALOGOS_REQUEST_PROCESSED = 0;
    public static final int REQUESTPERSISTSTALOGOS_REQUEST_FAILED = 1;
    public static final int PERSISTSTATIONLOGOSTYPE_PRESETS = 0;
    public static final int PERSISTSTATIONLOGOSTYPE_CURRENT_STATION = 1;
    public static final int PERSISTSTATIONLOGOSTYPE_STATION_LIST = 2;

    public void requestRadioStationData(RadioStationDataRequest[] var1, int var2);

    public void requestRadioStationLogos(RadioStationLogoRequest[] var1, int var2);

    public void requestDynamicDatabaseAlteration(RadioStationData var1, ResourceLocator var2, int var3, int var4);

    public void requestCountryListUpdate(int var1);

    public void requestDatabaseVersionInfo(int var1);

    public void requestPersistStationLogos(RadioStationData[] var1, ResourceLocator[] var2, int var3, int var4);

    public void requestCountryRegionData(int var1);

    public void requestCountryRegionTranslationData(int var1, String var2, int var3);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();
}

