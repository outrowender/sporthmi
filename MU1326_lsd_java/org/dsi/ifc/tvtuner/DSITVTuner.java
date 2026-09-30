/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tvtuner;

import org.dsi.ifc.base.DSIBase;

public interface DSITVTuner
extends DSIBase {
    public static final String VERSION = "2.11.9";
    public static final int ATTR_TUNERSTATE = 1;
    public static final int ATTR_SELECTEDSOURCE = 2;
    public static final int ATTR_SERVICELIST = 3;
    public static final int ATTR_SELECTEDSERVICE = 4;
    public static final int ATTR_MUTESTATE = 5;
    public static final int ATTR_INFOTEXTSTATE = 6;
    public static final int ATTR_AUDIOCHANNEL = 7;
    public static final int ATTR_SERVICELINKING = 8;
    public static final int ATTR_SUBTITLE = 9;
    public static final int ATTR_AVNORM = 10;
    public static final int ATTR_TVNORMAREA = 11;
    public static final int ATTR_TVNORMLIST = 12;
    public static final int ATTR_TVNORMAREASUBLIST = 13;
    public static final int ATTR_TERMINALMODE = 14;
    public static final int ATTR_EWSINFOLIST = 15;
    public static final int ATTR_STARTUPMUCONFIG = 16;
    public static final int ATTR_MESSAGESERVICE = 17;
    public static final int ATTR_TUNESTATUS = 18;
    public static final int ATTR_CASINFO = 19;
    public static final int ATTR_TMTVKEYPANEL = 20;
    public static final int ATTR_LOGOLIST = 21;
    public static final int ATTR_BROWSERLISTSORT = 22;
    public static final int TUNERSTATE_INACTIVE = 0;
    public static final int TUNERSTATE_ACTIVE = 1;
    public static final int RESPONSERESULT_FAILURE = 0;
    public static final int RESPONSERESULT_SUCCESS = 1;
    public static final int SOURCETYPE_TV = 0;
    public static final int SOURCETYPE_AV = 1;
    public static final int SEEKDIRECTION_UP = 1;
    public static final int SEEKDIRECTION_DOWN = 2;
    public static final int SEEKMODE_CHANNEL = 1;
    public static final int SEEKMODE_AUTO = 2;
    public static final int STYPE_UNKNOWN = 0;
    public static final int STYPE_DTV = 1;
    public static final int STYPE_DTV_HDTV = 2;
    public static final int STYPE_AUDIO = 3;
    public static final int STYPE_DATA = 4;
    public static final int STYPE_CAS_PAYTV = 5;
    public static final int STYPE_VISUAL_AUDIO = 6;
    public static final int STYPE_ISDB_SUBSERVICE_1 = 7;
    public static final int STYPE_ISDB_SUBSERVICE_2 = 8;
    public static final int STYPE_CMMB = 9;
    public static final int STYPE_CMMB_AUDIO = 10;
    public static final int STYPE_DTV_SUBSERVICE_2 = 11;
    public static final int STYPE_DTV_SUBSERVICE_3 = 12;
    public static final int STYPE_DTV_SUBSERVICE_4 = 13;
    public static final int STYPE_DTV_SUBSERVICE_5 = 14;
    public static final int STYPE_DUMMY = 15;
    public static final int MUTESTATE_AUDIO_GOOD = 0;
    public static final int MUTESTATE_DROP_OUT = 1;
    public static final int MUTESTATE_NO_RECEPTION = 2;
    public static final int MUTESTATE_NO_AUDIO_SERVICE = 3;
    public static final int SERVICEFLAG_NOT_AVAILABLE = 0;
    public static final int SERVICEFLAG_LOADING = 1;
    public static final int SERVICEFLAG_FULL_AVAILABLE = 2;
    public static final int AVNORM_AUTO = 0;
    public static final int AVNORM_PAL = 1;
    public static final int AVNORM_NTSC = 2;
    public static final int TERMINALMODE_OFF_TV_AV_MODE = 0;
    public static final int TERMINALMODE_TELETEXT = 1;
    public static final int TERMINALMODE_DB_DVB = 2;
    public static final int TERMINALMODE_DB_ISDB = 3;
    public static final int TERMINALMODE_DB_DTMB_CMMB = 4;
    public static final int TERMINALMODE_DB_DMB = 5;
    public static final int TERMINALMODE_DB_ATSC = 6;
    public static final int TERMINALMODE_DB1 = 7;
    public static final int TERMINALMODE_DB2 = 8;
    public static final int TERMINALMODE_BWS = 9;
    public static final int TERMINALMODE_SLS_DLS = 10;
    public static final int TERMINALMODE_TXT = 11;
    public static final int TERMINALMODE_CAS = 12;
    public static final int TERMINALMODE_EPG = 13;
    public static final int TERMINALMODE_VISUAL_AUDIO = 14;
    public static final int TERMINALMODE_TV_ENGINEERING = 15;
    public static final int SCREENMODE_MU_SPEED_DISCLAIMER_OFF = 0;
    public static final int SCREENMODE_MU_SPEED_DISCLAIMER_ON = 1;
    public static final int TMTOUCHPADBEHAVIOUR_NO_COORD = 0;
    public static final int TMTOUCHPADBEHAVIOUR_COORD = 1;
    public static final int TMTOUCHPADBEHAVIOUR_MAP_TO_JOYSTICK = 2;
    public static final int RT_SWITCHSOURCE = 1000;
    public static final int RT_SELECTNEXTSERVICE = 1001;
    public static final int RT_SELECTSERVICE = 1002;
    public static final int RT_SETAUDIOCHANNEL = 1003;
    public static final int RT_ENABLESERVICELINKING = 1004;
    public static final int RT_ENABLESUBTITLE = 1005;
    public static final int RT_SETAVNORM = 1006;
    public static final int RT_SETNORMAREA = 1007;
    public static final int RT_SETNORMAREASUBLIST = 1008;
    public static final int RT_SETTERMINALMODE = 1009;
    public static final int RT_INCMOVED = 1010;
    public static final int RT_SETCOORDINATEREL = 1011;
    public static final int RT_SETTMTVKEYPANEL = 1012;
    public static final int RT_ABORTSEEK = 1013;
    public static final int RT_SETBROWSERLISTSORT = 1014;
    public static final int RP_SWITCHSOURCE = 2000;
    public static final int RP_SELECTNEXTSERVICE = 2001;
    public static final int RP_SELECTSERVICE = 2002;
    public static final int RP_ABORTSEEK = 2003;

    public void selectService(long var1, int var3, int var4);

    public void selectNextService(int var1, int var2);

    public void abortSeek();

    public void switchSource(int var1);

    public void setAudioChannel(int var1);

    public void setNormArea(int var1);

    public void enableServiceLinking(boolean var1);

    public void setTerminalMode(int var1, int var2);

    public void setNormAreaSubList(int[] var1);

    public void setAVNorm(int var1);

    public void incMoved(byte var1);

    public void setCoordinateRel(short var1, short var2, short var3);

    public void setTMTVKeyPanel(short var1, short var2);

    public void enableSubtitle(boolean var1);

    public void setBrowserListSort(int var1);
}

