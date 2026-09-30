/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIBase;

public interface DSIAMFMTuner
extends DSIBase {
    public static final String VERSION = "2.11.36";
    public static final int ATTR_SELECTEDSTATION = 1;
    public static final int ATTR_STATIONLIST = 2;
    public static final int ATTR_STATIONLISTMW = 3;
    public static final int ATTR_STATIONLISTLW = 4;
    public static final int ATTR_WAVEBANDINFOLIST = 5;
    public static final int ATTR_RADIOTEXT = 6;
    public static final int ATTR_AFSWITCHSTATUS = 7;
    public static final int ATTR_REGSWITCHSTATUS = 8;
    public static final int ATTR_LINKINGUSAGESTATUS = 9;
    public static final int ATTR_DETECTEDDEVICE = 10;
    public static final int ATTR_RADIOTEXTPLUS = 11;
    public static final int ATTR_PIIGNORESWITCHSTATUS = 12;
    public static final int ATTR_RDSIGNORESWITCHSTATUS = 13;
    public static final int ATTR_MESWITCHSTATUS = 14;
    public static final int ATTR_HDSTATUS = 15;
    public static final int ATTR_HDMODE = 16;
    public static final int ATTR_HDSTATIONINFO = 17;
    public static final int ATTR_AVAILABILITY = 18;
    public static final int ATTR_ELECTRONICSERIALCODE = 19;
    public static final int ATTR_SELECTEDSTATIONHD = 20;
    public static final int ATTR_PROFILESTATE = 21;
    public static final int WAVEBAND_UNDEFINED = 0;
    public static final int WAVEBAND_FM = 1;
    public static final int WAVEBAND_SW = 2;
    public static final int WAVEBAND_MW = 3;
    public static final int WAVEBAND_LW = 4;
    public static final int SEEKSTATIONMODE_UNDEFINED = 0;
    public static final int SEEKSTATIONMODE_UP = 1;
    public static final int SEEKSTATIONMODE_DOWN = 2;
    public static final int SEEKSTATIONMODE_ABORT = 3;
    public static final int SEEKSTATIONMODE_STOP = 4;
    public static final int SEEKSTATIONMODE_UP_NO_STOP = 5;
    public static final int SEEKSTATIONMODE_DOWN_NO_STOP = 6;
    public static final int DEVICESTATUS_UNDEFINED = 0;
    public static final int DEVICESTATUS_NOT_READY = 1;
    public static final int DEVICESTATUS_READY = 2;
    public static final int REGSTATUS_UNDEFINED = 0;
    public static final int REGSTATUS_ON = 1;
    public static final int REGSTATUS_OFF = 2;
    public static final int REGSTATUS_AUTO = 3;
    public static final int TUNEFREQUENCYSTEPSSTATUS_UNDEFINED = 0;
    public static final int TUNEFREQUENCYSTEPSSTATUS_RUNNING = 1;
    public static final int TUNEFREQUENCYSTEPSSTATUS_DONE = 2;
    public static final int TUNEFREQUENCYSTEPSSTATUS_ABORTED = 3;
    public static final int TUNEFREQUENCYSTEPSSTATUS_FAILURE = 4;
    public static final int SELECTSTATIONSTATUS_UNDEFINED = 0;
    public static final int SELECTSTATIONSTATUS_RUNNING = 1;
    public static final int SELECTSTATIONSTATUS_DONE = 2;
    public static final int SELECTSTATIONSTATUS_ABORTED = 3;
    public static final int SELECTSTATIONSTATUS_FAILURE = 4;
    public static final int PREPARETUNINGSTATUS_UNDEFINED = 0;
    public static final int PREPARETUNINGSTATUS_RUNNING = 1;
    public static final int PREPARETUNINGSTATUS_DONE = 2;
    public static final int PREPARETUNINGSTATUS_ABORTED = 3;
    public static final int PREPARETUNINGSTATUS_FAILURE = 4;
    public static final int SEEKSTATIONSTATUS_UNDEFINED = 0;
    public static final int SEEKSTATIONSTATUS_RUNNING = 1;
    public static final int SEEKSTATIONSTATUS_DONE = 2;
    public static final int SEEKSTATIONSTATUS_ABORTED = 3;
    public static final int SEEKSTATIONSTATUS_STOPPED = 4;
    public static final int SEEKSTATIONSTATUS_FAILURE = 5;
    public static final int LINKINGDEVICEUSAGE_UNDEFINED = 0;
    public static final int LINKINGDEVICEUSAGE_DEVICE_AVAILABLE = 1;
    public static final int LINKINGDEVICEUSAGE_DEVICE_USED = 2;
    public static final int LINKINGUSEDTYPE_UNDEFINED = 0;
    public static final int LINKINGUSEDTYPE_FOLLOWING_MASTER = 1;
    public static final int LINKINGUSEDTYPE_EXTERNAL_REQUEST = 2;
    public static final int LINKINGUSEDTYPE_PTY31 = 3;
    public static final int LINKINGUSEDTYPE_TA = 4;
    public static final int LINKINGUSEDTYPE_OTHER_ANNOUNCEMENT = 5;
    public static final int LINKINGUSEDTYPE_TIM = 6;
    public static final int DEVICETYPE_UNDEFINED = 0;
    public static final int DEVICETYPE_NONE = 1;
    public static final int DEVICETYPE_UNKNOWN = 2;
    public static final int DEVICETYPE_RU = 3;
    public static final int DEVICETYPE_RU_HD = 4;
    public static final int RESETTYPE_UNDEFINED = 0;
    public static final int RESETTYPE_TO_DEFAULT = 1;
    public static final int RESETTYPE_ANONYMIZE = 2;
    public static final int SELECTFREQUENCYSTATUS_UNDEFINED = 0;
    public static final int SELECTFREQUENCYSTATUS_RUNNING = 1;
    public static final int SELECTFREQUENCYSTATUS_DONE = 2;
    public static final int SELECTFREQUENCYSTATUS_ABORTED = 3;
    public static final int SELECTFREQUENCYSTATUS_FAILURE = 4;
    public static final int SETAMBANDRANGESTATUS_UNDEFINED = 0;
    public static final int SETAMBANDRANGESTATUS_RUNNING = 1;
    public static final int SETAMBANDRANGESTATUS_DONE = 2;
    public static final int SETAMBANDRANGESTATUS_ABORTED = 3;
    public static final int SETAMBANDRANGESTATUS_FAILURE = 4;
    public static final int AMBANDRANGE_UNDEFINED = 0;
    public static final int AMBANDRANGE_EU = 2;
    public static final int AMBANDRANGE_NAR = 1;
    public static final int AMBANDRANGE_JP = 3;
    public static final int AMBANDRANGE_EU_GER = 4;
    public static final int AMBANDRANGE_AUS = 5;
    public static final int UPDATEMODE_UNDEFINED = 0;
    public static final int UPDATEMODE_START = 1;
    public static final int UPDATEMODE_ABORT = 2;
    public static final int FORCEUPDATESTATUS_UNDEFINED = 0;
    public static final int FORCEUPDATESTATUS_RUNNING = 1;
    public static final int FORCEUPDATESTATUS_DONE = 2;
    public static final int FORCEUPDATESTATUS_ABORTED = 3;
    public static final int FORCEUPDATESTATUS_FAILURE = 4;
    public static final int SERVICE_NONE = 0;
    public static final int SERVICE_MPS = 1;
    public static final int SERVICE_SPS2 = 2;
    public static final int SERVICE_SPS3 = 4;
    public static final int SERVICE_SPS4 = 8;
    public static final int SERVICE_SPS5 = 16;
    public static final int SERVICE_SPS6 = 32;
    public static final int SERVICE_SPS7 = 64;
    public static final int SERVICE_SPS8 = 128;
    public static final int HDSTATUS_UNKNOWN = 0;
    public static final int HDSTATUS_ANALOG = 1;
    public static final int HDSTATUS_DIGITAL = 2;
    public static final int HDSTATUS_MUTE = 3;
    public static final int HDSTATUS_BGM = 4;
    public static final int HDMODE_UNDEF = 0;
    public static final int HDMODE_AUTOMATIC = 1;
    public static final int HDMODE_ANALOG = 2;
    public static final int HDMODE_DIGITAL = 3;
    public static final int HDMODE_BGM_OVERRIDE = 4;
    public static final int HDMODE_AM_OFF_FM_ON = 5;
    public static final int HDMODE_AM_ON_FM_OFF = 6;
    public static final int SUBSCRIPTION_UNDEFINED = 0;
    public static final int SUBSCRIPTION_UNSUBSCRIBED = 1;
    public static final int SUBSCRIPTION_SUBSCRIBED = 2;
    public static final int SUBSCRIPTION_FREE = 3;
    public static final int RT_TUNEFREQUENCYSTEPS = 1000;
    public static final int RT_SELECTSTATION = 1001;
    public static final int RT_SEEKSTATION = 1002;
    public static final int RT_SWITCHAF = 1003;
    public static final int RT_SWITCHREG = 1004;
    public static final int RT_SWITCHLINKINGDEVICEUSAGE = 1005;
    public static final int RT_RESET = 1006;
    public static final int RT_SETAMBANDRANGE = 1007;
    public static final int RT_PREPARETUNING = 1008;
    public static final int RT_SELECTFREQUENCY = 1009;
    public static final int RT_ISONPRESET = 1010;
    public static final int RT_FORCEFMUPDATE = 1011;
    public static final int RT_SWITCHPIIGNORE = 1012;
    public static final int RT_FREEPRESET = 1013;
    public static final int RT_FORCEAMUPDATE = 1014;
    public static final int RT_SWITCHRDSIGNORE = 1015;
    public static final int RT_SWITCHME = 1016;
    public static final int RT_ENABLERADIOTEXTPLUS = 1017;
    public static final int RT_SETMODEHD = 1018;
    public static final int RT_SETERTPREFERED = 1019;
    public static final int RT_SETERTDISPLAYABLE = 1020;
    public static final int RT_PROFILECHANGE = 1021;
    public static final int RT_PROFILECOPY = 1022;
    public static final int RT_PROFILERESET = 1023;
    public static final int RT_PROFILERESETALL = 1024;
    public static final int RP_TUNEFREQUENCYSTEPSSTATUS = 2000;
    public static final int RP_SELECTSTATIONSTATUS = 2001;
    public static final int RP_SEEKSTATIONSTATUS = 2002;
    public static final int RP_PREPARETUNINGSTATUS = 2003;
    public static final int RP_SELECTFREQUENCYSTATUS = 2004;
    public static final int RP_SETAMBANDRANGESTATUS = 2005;
    public static final int RP_FORCEFMUPDATESTATUS = 2006;
    public static final int RP_FORCEAMUPDATESTATUS = 2007;
    public static final int RP_PROFILECHANGED = 2008;
    public static final int RP_PROFILECOPIED = 2009;
    public static final int RP_PROFILERESET = 2010;
    public static final int RP_PROFILERESETALL = 2011;

    public void tuneFrequencySteps(int var1);

    public void selectStation(int var1, int var2, int var3);

    public void prepareTuning(int var1, int var2, int var3);

    public void seekStation(int var1);

    public void switchAF(boolean var1);

    public void switchME(boolean var1);

    public void switchREG(int var1);

    public void switchLinkingDeviceUsage(int var1);

    public void reset(int var1);

    public void selectFrequency(int var1);

    public void setAMBandRange(int var1);

    public void isOnPreset(int var1, int var2, int var3, String var4);

    public void forceFMUpdate(int var1);

    public void switchPiIgnore(boolean var1);

    public void freePreset(int var1);

    public void forceAMUpdate(int var1);

    public void switchRDSIgnore(boolean var1);

    public void enableRadiotextPlus(int[] var1);

    public void setModeHD(int var1);

    public void setERTPrefered(boolean var1);

    public void setERTDisplayable(boolean var1);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();
}

