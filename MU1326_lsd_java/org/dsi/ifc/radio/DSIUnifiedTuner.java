/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIBase;

public interface DSIUnifiedTuner
extends DSIBase {
    public static final String VERSION = "2.11.36";
    public static final int ATTR_DETECTEDDEVICE = 1;
    public static final int ATTR_AUDIOSTATUS = 2;
    public static final int ATTR_SELECTEDSTATION = 3;
    public static final int ATTR_STATIONLIST = 4;
    public static final int ATTR_RADIOTEXT = 5;
    public static final int ATTR_ENHANCEDRADIOTEXT = 6;
    public static final int ATTR_RADIOTEXTPLUS = 7;
    public static final int ATTR_ENHANCEDRADIOTEXTPLUS = 8;
    public static final int ATTR_SLIDESHOWINFO = 9;
    public static final int ATTR_SOFTLINKSWITCHSTATUS = 10;
    public static final int ATTR_REGMODESTATUS = 11;
    public static final int ATTR_DEVICEUSAGESTATUS = 12;
    public static final int ATTR_PROFILESTATE = 13;
    public static final int RT_SELECTSTATION = 1000;
    public static final int RT_SETSTATIONFOLLOWINGMODE = 1001;
    public static final int RT_SETLISTMODE = 1002;
    public static final int RT_ENABLERADIOTEXTPLUS = 1003;
    public static final int RT_SETSOFTLINKSWITCH = 1004;
    public static final int RT_SETREGMODE = 1005;
    public static final int RT_SWITCHDEVICEUSAGE = 1006;
    public static final int RT_PROFILECHANGE = 1007;
    public static final int RT_PROFILECOPY = 1008;
    public static final int RT_PROFILERESET = 1009;
    public static final int RT_PROFILERESETALL = 1010;
    public static final int RP_SELECTSTATIONSTATUS = 2000;
    public static final int RP_LISTMODE = 2001;
    public static final int RP_STATIONFOLLOWINGMODE = 2002;
    public static final int RP_PROFILECHANGED = 2003;
    public static final int RP_PROFILECOPIED = 2004;
    public static final int RP_PROFILERESET = 2005;
    public static final int RP_PROFILERESETALL = 2006;
    public static final int DEVICETYPE_NONE = 1;
    public static final int DEVICETYPE_RU = 3;
    public static final int STATIONFOLLOWINGMODE_AUTO = 1;
    public static final int STATIONFOLLOWINGMODE_STAYANALOG = 2;
    public static final int STATIONFOLLOWINGMODE_STAYDIGITAL = 3;
    public static final int STATIONFOLLOWINGMODE_OFF = 4;
    public static final int SOFTLINKSWITCH_OFF = 0;
    public static final int SOFTLINKSWITCH_ON = 1;
    public static final int REGMODE_OFF = 0;
    public static final int REGMODE_ON = 1;
    public static final int REGMODE_AUTO = 2;
    public static final int AUDIOSTATUS_ANALOG = 1;
    public static final int AUDIOSTATUS_DIGITAL = 2;
    public static final int AUDIOSTATUS_MUTE = 3;
    public static final int LISTMODE_AUTO = 1;
    public static final int LISTMODE_SHOWALTERNATIVES = 2;
    public static final int TPAVAILABILITY_UNKNOWN = 0;
    public static final int TPAVAILABILITY_NO = 1;
    public static final int TPAVAILABILITY_DIRECT = 2;
    public static final int TPAVAILABILITY_LINKED = 3;
    public static final int SELECTSTATIONMODE_FM = 1;
    public static final int SELECTSTATIONMODE_DAB = 2;
    public static final int RADIOTEXTSOURCE_FM = 1;
    public static final int RADIOTEXTSOURCE_DAB = 2;
    public static final int SCROLLINGPS_UNKNOWN = 0;
    public static final int SCROLLINGPS_FALSE = 1;
    public static final int SCROLLINGPS_TRUE = 2;
    public static final int SELECTSTATIONSTATUS_UNDEFINED = 0;
    public static final int SELECTSTATIONSTATUS_RUNNING = 1;
    public static final int SELECTSTATIONSTATUS_DONE = 2;
    public static final int SELECTSTATIONSTATUS_ABORTED = 3;
    public static final int SELECTSTATIONSTATUS_FAILURE = 4;
    public static final int DEVICEUSAGE_AVAILABLE = 0;
    public static final int DEVICEUSAGE_USED = 1;

    public void selectStation(int var1, long var2, int var4, int var5, int var6, int var7);

    public void setStationFollowingMode(int var1);

    public void setListMode(int var1);

    public void enableRadioTextPlus(int[] var1);

    public void setSoftLinkSwitch(int var1);

    public void setRegMode(int var1);

    public void switchDeviceUsage(int var1);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();
}

