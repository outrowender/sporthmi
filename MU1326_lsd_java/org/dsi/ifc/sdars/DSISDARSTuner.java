/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.base.DSIBase;

public interface DSISDARSTuner
extends DSIBase {
    public static final String VERSION = "2.11.20";
    public static final int ATTR_ELECTRONICSERIALCODE = 2;
    public static final int ATTR_SERVICESTATUS3 = 6;
    public static final int ATTR_SIGNALQUALITY = 7;
    public static final int ATTR_SELECTEDSTATION = 8;
    public static final int ATTR_STATIONLIST = 9;
    public static final int ATTR_CATEGORYLIST = 10;
    public static final int ATTR_DETECTEDDEVICE = 12;
    public static final int ATTR_STATICTAGGINGINFO = 13;
    public static final int ATTR_AVAILABILITY = 26;
    public static final int ATTR_STATIONDESCRIPTION = 27;
    public static final int ATTR_SUBSCRIPTIONSTATUS = 28;
    public static final int ATTR_PROFILESTATE = 30;
    public static final int UNDEFINEDVALUES_SID = 255;
    public static final int UNDEFINEDVALUES_STATION_NUMBER = 255;
    public static final int UNDEFINEDVALUES_CATEGORY_NUMBER = 255;
    public static final int UNDEFINEDVALUES_SIGNAL = 0;
    public static final int STATIONSELECTIONMODE_SID = 4;
    public static final int SELECTSTATIONSTATUS_UNDEFINED = 0;
    public static final int SELECTSTATIONSTATUS_RUNNING = 1;
    public static final int SELECTSTATIONSTATUS_ABORTED = 2;
    public static final int SELECTSTATIONSTATUS_DONE = 3;
    public static final int SELECTSTATIONSTATUS_INVALID = 4;
    public static final int SELECTSTATIONSTATUS_NOT_SUBSCRIBED = 5;
    public static final int SELECTSTATIONSTATUS_GCI_UPDATE_RUNNING = 6;
    public static final int SUBSCRIPTION_UNDEFINED = 0;
    public static final int SUBSCRIPTION_UNSUBSCRIBED = 1;
    public static final int SUBSCRIPTION_SUBSCRIBED = 2;
    public static final int SUBSCRIPTION_SUSPENDALERT = 3;
    public static final int SUBSCRIPTION_SUSPENDED = 4;
    public static final int EPGFLAG_UNDEFINED = 0;
    public static final int EPGFLAG_FEATURED = 1;
    public static final int EPGFLAG_HIGHLIGHTED = 2;
    public static final int EPGFLAG_LIVE = 4;
    public static final int EPGFLAG_NEW = 8;
    public static final int AUDIOSTATUS_UNDEFINED = 0;
    public static final int AUDIOSTATUS_MUTE_ON = 1;
    public static final int AUDIOSTATUS_MUTE_OFF = 2;
    public static final int LISTUPDATESTATUS_UNDEFINED = 0;
    public static final int LISTUPDATESTATUS_RUNNING = 1;
    public static final int LISTUPDATESTATUS_LIST_STABLE = 2;
    public static final int UPDATESTATUS_UNDEFINED = 0;
    public static final int UPDATESTATUS_RUNNING = 1;
    public static final int UPDATESTATUS_STABLE = 2;
    public static final int SIGNALQUALITY_UNDEFINED = 0;
    public static final int SIGNALQUALITY_NO_SIGNAL = 1;
    public static final int SIGNALQUALITY_WEAK = 2;
    public static final int SIGNALQUALITY_GOOD = 3;
    public static final int SIGNALQUALITY_EXCELLENT = 4;
    public static final int SIGNALSTATUS_UNDEFINED = 0;
    public static final int SIGNALSTATUS_NOT_PRESENT = 1;
    public static final int SIGNALSTATUS_PRESENT = 2;
    public static final int ANTENNASTATUS_UNDEFINED = 0;
    public static final int ANTENNASTATUS_NOT_CONNECTED = 1;
    public static final int ANTENNASTATUS_CONNECTED = 2;
    public static final int DEVICETYPE_UNDEFINED = 0;
    public static final int DEVICETYPE_NONE = 1;
    public static final int DEVICETYPE_UNKNOWN = 2;
    public static final int DEVICETYPE_RU = 3;
    public static final int DEVICETYPE_UNAVAILABLE = 4;
    public static final int RESETTYPE_UNDEFINED = 0;
    public static final int RESETTYPE_TO_DEFAULT = 1;
    public static final int AVAILABILITY_NOTAVAILABLE = 1;
    public static final int AVAILABILITY_AVAILABLE = 2;
    public static final int RESETTYPE_ANONYMIZE = 2;
    public static final int INFORMATION_UNKNOWN = 0;
    public static final int INFORMATION_EPGCHANNELLIST = 1;
    public static final int INFORMATION_RADIOTEXT2 = 2;
    public static final int INFORMATION_CHANNELART = 4;
    public static final int INFORMATION_BACKGROUNDART = 8;
    public static final int INFORMATION_ALBUMART = 16;
    public static final int INFORMATION_GENREART = 32;
    public static final int INFORMATION_STUDIOART = 64;
    public static final int RT_SELECTSTATION = 1000;
    public static final int RT_RESET = 1001;
    public static final int RT_GETTIME = 1002;
    public static final int RT_SETRADIOTEXT2CONFIG = 1003;
    public static final int RT_GETEPG24HOUR = 1004;
    public static final int RT_GETEPGDESCRIPTION = 1005;
    public static final int RT_NOTIFYHMIREADY = 1007;
    public static final int RT_PROFILECHANGE = 1008;
    public static final int RT_PROFILECOPY = 1009;
    public static final int RT_PROFILERESET = 1010;
    public static final int RT_PROFILERESETALL = 1011;
    public static final int RP_SELECTSTATIONSTATUS = 2000;
    public static final int RP_RESPONSETIME = 2001;
    public static final int RP_RESPONSEEPG24HOUR = 2002;
    public static final int RP_RESPONSEEPGDESCRIPTION = 2003;
    public static final int RP_PROFILECHANGED = 2004;
    public static final int RP_PROFILECOPIED = 2005;
    public static final int RP_PROFILERESET = 2006;
    public static final int RP_PROFILERESETALL = 2007;
    public static final int IN_INFORMATIONEPGCHANNELLIST = 3000;
    public static final int IN_INFORMATIONRADIOTEXT = 3001;
    public static final int IN_INFORMATIONCHANNELART = 3002;
    public static final int IN_INFORMATIONBACKGROUNDART = 3003;
    public static final int IN_INFORMATIONALBUMART = 3004;
    public static final int IN_INFORMATIONGENREART = 3005;
    public static final int IN_INFORMATIONSTUDIOART = 3006;
    public static final int IN_INFORMATIONRADIOTEXT2 = 3007;

    public void selectStation(int var1, int var2);

    public void getTime();

    public void getEPG24Hour(int var1);

    public void getEPGDescription(int var1, int var2);

    public void notifyHMIReady(int var1);

    public void reset(int var1);

    public void setRadioText2Config(int var1, int var2);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();
}

