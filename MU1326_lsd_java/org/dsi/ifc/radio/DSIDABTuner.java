/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIBase;

public interface DSIDABTuner
extends DSIBase {
    public static final String VERSION = "2.11.36";
    public static final int ATTR_SELECTEDENSEMBLE = 1;
    public static final int ATTR_SELECTEDSERVICE = 2;
    public static final int ATTR_SELECTEDCOMPONENT = 3;
    public static final int ATTR_SELECTEDFREQUENCY = 4;
    public static final int ATTR_ENSEMBLELIST = 5;
    public static final int ATTR_SERVICELIST = 6;
    public static final int ATTR_COMPONENTLIST = 7;
    public static final int ATTR_DATASERVICELIST = 8;
    public static final int ATTR_FREQUENCYLIST = 9;
    public static final int ATTR_RADIOTEXT = 10;
    public static final int ATTR_SYNCSTATUS = 11;
    public static final int ATTR_QUALITY = 12;
    public static final int ATTR_DRCSWITCHSTATUS = 13;
    public static final int ATTR_LINKINGSWITCHSTATUS = 14;
    public static final int ATTR_FREQUENCYTABLESWITCHSTATUS = 15;
    public static final int ATTR_LINKINGSTATUS = 18;
    public static final int ATTR_LINKINGUSAGESTATUS = 19;
    public static final int ATTR_AUDIOSTATUS = 20;
    public static final int ATTR_DETECTEDDEVICE = 21;
    public static final int ATTR_QUALITYINFO = 22;
    public static final int ATTR_DECODEDDATASERVICE = 24;
    public static final int ATTR_EPGLOGO = 25;
    public static final int ATTR_AVAILABILITY = 27;
    public static final int ATTR_INTELLITEXT = 28;
    public static final int ATTR_EPGLISTDATA = 29;
    public static final int ATTR_EPGDETAILDATA = 30;
    public static final int ATTR_EPGMODE = 31;
    public static final int ATTR_SLIDESHOWINFO = 32;
    public static final int ATTR_RADIOTEXTPLUSINFO = 33;
    public static final int ATTR_EPGLOGOLIST = 34;
    public static final int ATTR_PROFILESTATE = 35;
    public static final int SELECTSERVICEMODE_UNDEFINED = 0;
    public static final int SELECTSERVICEMODE_SID = 1;
    public static final int SELECTSERVICEMODE_SID_AND_ENSID = 2;
    public static final int SELECTSERVICEMODE_SCIDI = 3;
    public static final int SELECTSERVICEMODE_INDEX = 4;
    public static final int SELECTSERVICEMODE_ABORT = 5;
    public static final int SELECTSERVICEMODE_SID_AND_FREQUENCY = 6;
    public static final int SEEKSERVICEMODE_UNDEFINED = 0;
    public static final int SEEKSERVICEMODE_AUTO_UP = 1;
    public static final int SEEKSERVICEMODE_AUTO_DOWN = 2;
    public static final int SEEKSERVICEMODE_SCAN_UP = 3;
    public static final int SEEKSERVICEMODE_ABORT = 4;
    public static final int SEEKSERVICEMODE_SCAN_UP_5_SECONDS = 5;
    public static final int SEEKSERVICEMODE_ENSEMBLE_UP = 6;
    public static final int SEEKSERVICEMODE_ENSEMBLE_DOWN = 7;
    public static final int SEEKSERVICEMODE_ENSEMBLE_JUMP_LM_UP_NO_SERVICE_SELECT = 8;
    public static final int SEEKSERVICEMODE_ENSEMBLE_JUMP_LM_DOWN_NO_SERVICE_SELECT = 9;
    public static final int SEEKSERVICEMODE_ENSEMBLE_UP_NO_SERVICE_SELECT = 10;
    public static final int SEEKSERVICEMODE_ENSEMBLE_DOWN_NO_SERVICE_SELECT = 11;
    public static final int TUNEENSEMBLEMODE_UNDEFINED = 0;
    public static final int TUNEENSEMBLEMODE_ENSID = 1;
    public static final int TUNEENSEMBLEMODE_FREQUENCY = 2;
    public static final int TUNEENSEMBLEMODE_ABORT = 3;
    public static final int EPGMODE_UNDEFINED = 0;
    public static final int EPGMODE_OFF = 1;
    public static final int EPGMODE_LOGO = 2;
    public static final int EPGMODE_TEXT = 3;
    public static final int EPGMODE_FULL = 4;
    public static final int SLIDESHOWMODE_OFF = 0;
    public static final int SLIDESHOWMODE_ON = 1;
    public static final int INTELLITEXTMODE_OFF = 0;
    public static final int INTELLITEXTMODE_ON = 1;
    public static final int SELECTSERVICESTATUS_UNDEFINED = 0;
    public static final int SELECTSERVICESTATUS_RUNNING = 1;
    public static final int SELECTSERVICESTATUS_ABORTED = 2;
    public static final int SELECTSERVICESTATUS_DONE = 3;
    public static final int SELECTSERVICESTATUS_SERVICE_INVALID = 4;
    public static final int SELECTSERVICESTATUS_NO_SERVICE = 5;
    public static final int SELECTSERVICESTATUS_NO_ENSEMBLE_TUNED = 6;
    public static final int SELECTSERVICESTATUS_INDEX_INVALID = 7;
    public static final int SEEKSERVICESTATUS_UNDEFINED = 0;
    public static final int SEEKSERVICESTATUS_RUNNING = 1;
    public static final int SEEKSERVICESTATUS_ABORTED = 2;
    public static final int SEEKSERVICESTATUS_FINISHED = 3;
    public static final int SEEKSERVICESTATUS_FAILURE = 4;
    public static final int TUNEENSEMBLESTATUS_UNDEFINED = 0;
    public static final int TUNEENSEMBLESTATUS_RUNNING = 1;
    public static final int TUNEENSEMBLESTATUS_ABORTED = 2;
    public static final int TUNEENSEMBLESTATUS_FINISHED = 3;
    public static final int TUNEENSEMBLESTATUS_WRONG_FREQUENCY = 4;
    public static final int TUNEENSEMBLESTATUS_WRONG_FREQUENCYLABEL = 5;
    public static final int TUNEENSEMBLESTATUS_FAILURE = 6;
    public static final int SELECTDATASERVICESTATUS_UNDEFINED = 0;
    public static final int SELECTDATASERVICESTATUS_RUNNING = 1;
    public static final int SELECTDATASERVICESTATUS_ABORTED = 2;
    public static final int SELECTDATASERVICESTATUS_DONE = 3;
    public static final int SELECTDATASERVICESTATUS_SERVICE_INVALID = 4;
    public static final int SELECTDATASERVICESTATUS_NO_SERVICE = 5;
    public static final int SYNCSTATUS_UNDEFINED = 0;
    public static final int SYNCSTATUS_SYNC_LOST = 1;
    public static final int SYNCSTATUS_MUTE_ENSEMBLE = 2;
    public static final int SYNCSTATUS_MUTE_SERVICE = 3;
    public static final int SYNCSTATUS_MUTE_OFF = 4;
    public static final int FREQUENCYTABLE_UNDEFINED = 0;
    public static final int FREQUENCYTABLE_AUTO = 1;
    public static final int FREQUENCYTABLE_EUROPE = 2;
    public static final int FREQUENCYTABLE_EUROPE_LBAND = 3;
    public static final int FREQUENCYTABLE_EUROPE_VHFBAND = 4;
    public static final int FREQUENCYTABLE_CANADA = 5;
    public static final int FREQUENCYTABLE_KOREA = 6;
    public static final int FREQUENCYTABLE_NEWZEALAND = 7;
    public static final int FREQUENCYTABLE_AUTO_LBAND_OFF = 8;
    public static final int LINKINGSTATUS_UNDEFINED = 0;
    public static final int LINKINGSTATUS_OFF = 1;
    public static final int LINKINGSTATUS_RDS = 2;
    public static final int LINKINGSTATUS_DRM = 3;
    public static final int LINKINGMODE_UNDEFINED = 0;
    public static final int LINKINGMODE_OFF = 1;
    public static final int LINKINGMODE_DAB_ONLY = 2;
    public static final int LINKINGMODE_ON = 3;
    public static final int LINKINGMODE_FM = 4;
    public static final int LINKINGMODE_DAB = 5;
    public static final int LINKINGMODE_DAB_ONLY_SOFT = 6;
    public static final int LINKINGMODE_ON_SOFT = 7;
    public static final int LINKINGMODE_FM_SOFT = 8;
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
    public static final int DRCSTATUS_UNDEFINED = 0;
    public static final int DRCSTATUS_NOT_AVAILABLE = 1;
    public static final int DRCSTATUS_AVAILABLE = 2;
    public static final int MUSICSPEECH_UNDEFINED = 0;
    public static final int MUSICSPEECH_MUSIC = 1;
    public static final int MUSICSPEECH_SPEECH = 2;
    public static final int AUDIOMODE_UNDEFINED = 0;
    public static final int AUDIOMODE_STEREO = 1;
    public static final int AUDIOMODE_JOINED_STEREO = 2;
    public static final int AUDIOMODE_DUAL_CHANNEL = 3;
    public static final int AUDIOMODE_MONO = 4;
    public static final int AUDIOMODE_TOGGLING_STEREO = 5;
    public static final int DECODINGALGORITHM_UNDEFINED = 0;
    public static final int DECODINGALGORITHM_MPEG1 = 1;
    public static final int DECODINGALGORITHM_MPEG2 = 2;
    public static final int ORIGINALSTATUS_UNDEFINED = 0;
    public static final int ORIGINALSTATUS_FLAG_NOT_SET = 1;
    public static final int ORIGINALSTATUS_FLAG_SET = 2;
    public static final int COPYRIGHTSTATUS_UNDEFINED = 0;
    public static final int COPYRIGHTSTATUS_FLAG_NOT_SET = 1;
    public static final int COPYRIGHTSTATUS_FLAG_SET = 2;
    public static final int SAMPLINGRATE_UNDEFINED = 0;
    public static final int SAMPLINGRATE_24KHZ = 1;
    public static final int SAMPLINGRATE_48KHZ = 2;
    public static final int DEVICETYPE_UNDEFINED = 0;
    public static final int DEVICETYPE_NONE = 1;
    public static final int DEVICETYPE_UNKNOWN = 2;
    public static final int DEVICETYPE_RU = 3;
    public static final int DEVICETYPE_KENWOOD = 4;
    public static final int SLIDESHOWIMAGE_CATEGORY_INVALID = 0;
    public static final int SLIDESHOWIMAGE_CATEGORY_UNKNOWN = 1;
    public static final int SLIDESHOWIMAGE_CATEGORY_STATIONLOGO = 2;
    public static final int DATASERVICETYPE_UNDEFINED = 0;
    public static final int DATASERVICETYPE_UNKNOWN = 1;
    public static final int DATASERVICETYPE_SLIDE_SHOW = 2;
    public static final int DATASERVICETYPE_BWS = 3;
    public static final int RESETTYPE_UNDEFINED = 0;
    public static final int RESETTYPE_TO_DEFAULT = 1;
    public static final int RESETTYPE_ANONYMIZE = 2;
    public static final int UPDATEMODE_UNDEFINED = 0;
    public static final int UPDATEMODE_START = 1;
    public static final int UPDATEMODE_ABORT = 2;
    public static final int UPDATEMODE_DELETE_LEARNMEMORY = 3;
    public static final int FORCELMUPDATESTATUS_UNDEFINED = 0;
    public static final int FORCELMUPDATESTATUS_RUNNING = 1;
    public static final int FORCELMUPDATESTATUS_DONE = 2;
    public static final int FORCELMUPDATESTATUS_ABORTED = 3;
    public static final int FORCELMUPDATESTATUS_FAILURE = 4;
    public static final int PREPARETUNINGSTATUS_UNDEFINED = 0;
    public static final int PREPARETUNINGSTATUS_RUNNING = 1;
    public static final int PREPARETUNINGSTATUS_DONE = 2;
    public static final int PREPARETUNINGSTATUS_ABORTED = 3;
    public static final int PREPARETUNINGSTATUS_FAILURE = 4;
    public static final int RT_SELECTSERVICE = 1000;
    public static final int RT_SEEKSERVICE = 1001;
    public static final int RT_TUNEENSEMBLE = 1002;
    public static final int RT_SELECTDATASERVICE = 1003;
    public static final int RT_SWITCHDRC = 1004;
    public static final int RT_SWITCHLINKING = 1005;
    public static final int RT_SWITCHLINKINGDEVICEUSAGE = 1006;
    public static final int RT_SWITCHFREQUENCYTABLE = 1007;
    public static final int RT_RESET = 1008;
    public static final int RT_FORCELMUPDATE = 1009;
    public static final int RT_PREPARETUNING = 1010;
    public static final int RT_ENABLERADIOTEXTPLUS = 1011;
    public static final int RT_SETEPGMODE = 1012;
    public static final int RT_SETSLIDESHOWMODE = 1013;
    public static final int RT_SETINTELLITEXTMODE = 1014;
    public static final int RT_GETEPGDETAILDATA = 1015;
    public static final int RT_PROFILECHANGE = 1016;
    public static final int RT_PROFILECOPY = 1017;
    public static final int RT_PROFILERESET = 1018;
    public static final int RT_PROFILERESETALL = 1019;
    public static final int RP_SELECTSERVICESTATUS = 2000;
    public static final int RP_SEEKSERVICESTATUS = 2001;
    public static final int RP_TUNEENSEMBLESTATUS = 2002;
    public static final int RP_SELECTDATASERVICESTATUS = 2003;
    public static final int RP_FORCELMUPDATESTATUS = 2004;
    public static final int RP_PREPARETUNINGSTATUS = 2005;
    public static final int RP_PROFILECHANGED = 2006;
    public static final int RP_PROFILECOPIED = 2007;
    public static final int RP_PROFILERESET = 2008;
    public static final int RP_PROFILERESETALL = 2009;

    public void selectService(int var1, long var2, int var4, int var5, int var6, int var7, long var8);

    public void seekService(int var1);

    public void tuneEnsemble(int var1, int var2, int var3, long var4);

    public void selectDataService(int var1, int var2, long var3, int var5);

    public void switchDRC(boolean var1);

    public void switchLinking(int var1);

    public void switchLinkingDeviceUsage(int var1);

    public void switchFrequencyTable(int var1);

    public void reset(int var1);

    public void forceLMUpdate(int var1);

    public void prepareTuning(int var1, long var2, int var4, int var5, int var6, int var7);

    public void enableRadioTextPlus(int[] var1);

    public void setEpgMode(int var1);

    public void setSlideShowMode(int var1);

    public void setIntellitextMode(int var1);

    public void getEPGDetailData(int var1, int var2, long var3, int var5);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();
}

