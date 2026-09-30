/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.ddp20.DisplayRequest;
import org.dsi.ifc.ddp20.UpdateRequest;

public interface DSIDDP20
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int ATTR_VERSIONINFO = 1;
    public static final int ATTR_POWERSTATUS = 2;
    public static final int ATTR_DISPLAYSTATUS = 3;
    public static final int ATTR_BUFFERSTATUS = 4;
    public static final int CONTEXT_UNSPECIFIED = 0;
    public static final int CONTEXT_PHONE = 1;
    public static final int CONTEXT_MEDIA = 2;
    public static final int CONTEXT_NAVI = 3;
    public static final int POWERSTATE_UNDEFINED = 0;
    public static final int POWERSTATE_OFF = 1;
    public static final int POWERSTATE_STANDBY = 2;
    public static final int POWERSTATE_ON = 3;
    public static final int BUFFERSTATE_UNDEFINED = 0;
    public static final int BUFFERSTATE_OKAY = 1;
    public static final int BUFFERSTATE_CRITICAL = 2;
    public static final int MANUFACTURER_UNDEFINED = 0;
    public static final int MANUFACTURER_BOSCH = 1;
    public static final int MANUFACTURER_BOSCH_OEM = 2;
    public static final int MANUFACTURER_HARMAN_BECKER = 3;
    public static final int MANUFACTURER_VDO = 4;
    public static final int MANUFACTURER_MOTO = 5;
    public static final int MANUFACTURER_NOKIA = 6;
    public static final int MANUFACTURER_MMARELLI = 7;
    public static final int BRAND_UNDEFINED = 0;
    public static final int BRAND_VW = 1;
    public static final int BRAND_AU = 2;
    public static final int BRAND_SE = 3;
    public static final int BRAND_SK = 4;
    public static final int BRAND_VWN = 5;
    public static final int BRAND_BG = 6;
    public static final int BRAND_LB = 7;
    public static final int BRAND_BE = 8;
    public static final int BRAND_RR = 9;
    public static final int BRAND_PS = 10;
    public static final int BRAND_FD = 11;
    public static final int CLASS_UNDEFINED = 0;
    public static final int CLASS_A000 = 1;
    public static final int CLASS_A00 = 2;
    public static final int CLASS_A0 = 3;
    public static final int CLASS_A = 4;
    public static final int CLASS_B = 5;
    public static final int CLASS_C = 6;
    public static final int CLASS_D = 7;
    public static final int CLASS_EM = 8;
    public static final int CLASS_EP = 9;
    public static final int GENERATION_UNDEFINED = 0;
    public static final int GENERATION_0 = 1;
    public static final int GENERATION_1 = 2;
    public static final int GENERATION_2 = 3;
    public static final int GENERATION_3 = 4;
    public static final int GENERATION_5 = 6;
    public static final int GENERATION_6 = 7;
    public static final int GENERATION_7 = 8;
    public static final int GENERATION_8 = 9;
    public static final int GENERATION_9 = 10;
    public static final int GENERATION_10 = 11;
    public static final int DERIVATE_0 = 0;
    public static final int DERIVATE_1 = 1;
    public static final int DERIVATE_2 = 2;
    public static final int DERIVATE_3 = 3;
    public static final int DERIVATE_4 = 4;
    public static final int DERIVATE_5 = 5;
    public static final int DERIVATE_6 = 6;
    public static final int DERIVATE_7 = 7;
    public static final int DERIVATE_8 = 8;
    public static final int DERIVATE_9 = 9;
    public static final int INFO_NONE = 0;
    public static final int INFO_SERIES = 1;
    public static final int INFO_PA = 2;
    public static final int INFO_GPA = 3;
    public static final int DISPLAY_MONO1 = 1;
    public static final int DISPLAY_MONO2 = 2;
    public static final int DISPLAY_MONO3 = 3;
    public static final int DISPLAY_MONO4 = 4;
    public static final int DISPLAY_MONO5 = 5;
    public static final int DISPLAY_MONO6 = 6;
    public static final int DISPLAY_COLOR1 = 31;
    public static final int DISPLAY_COLOR2 = 32;
    public static final int DISPLAY_COLOR3 = 33;
    public static final int MMISTATE_INVALID = 0;
    public static final int MMISTATE_STANDBY = 1;
    public static final int MMISTATE_ON = 2;
    public static final int DISPLAYSTATE_INVALID = 0;
    public static final int DISPLAYSTATE_OFF = 1;
    public static final int DISPLAYSTATE_ON = 2;
    public static final int AUDIOSTATE_INVALID = 0;
    public static final int AUDIOSTATE_OFF = 1;
    public static final int AUDIOSTATE_ON = 2;
    public static final int NAVISTATE_INVALID = 0;
    public static final int NAVISTATE_NOT_INSTALLED = 1;
    public static final int NAVISTATE_INIT = 2;
    public static final int NAVISTATE_READY = 3;
    public static final int RGUIDESTATE_INVALID = 0;
    public static final int RGUIDESTATE_NOT_ACTIVE = 1;
    public static final int RGUIDESTATE_CALCULATION = 2;
    public static final int RGUIDESTATE_NEW_CALCULATION = 3;
    public static final int RGUIDESTATE_OFFMAP = 4;
    public static final int RGUIDESTATE_OFFROAD = 5;
    public static final int RGUIDESTATE_ACTIVE = 6;
    public static final int MEDIASTATE_INVALID = 0;
    public static final int MEDIASTATE_NOT_INSTALLED = 1;
    public static final int MEDIASTATE_INIT = 2;
    public static final int MEDIASTATE_READY = 3;
    public static final int PHONESTATE_INVALID = 0;
    public static final int PHONESTATE_NOT_INSTALLED = 1;
    public static final int PHONESTATE_INIT = 2;
    public static final int PHONESTATE_READY = 3;
    public static final int CALLSTATE_INVALID = 0;
    public static final int CALLSTATE_NO_CALL = 1;
    public static final int CALLSTATE_BUILD_CONNECTION = 2;
    public static final int CALLSTATE_INCOMING_CALL = 3;
    public static final int CALLSTATE_ACTIVE_CALL = 4;
    public static final int CALLTYPE_NO_CALL = 0;
    public static final int CALLTYPE_NORMAL_CALL = 1;
    public static final int CALLTYPE_CONFERENCE_CALL = 2;
    public static final int CALLTYPE_EMERGENCY_CALL = 3;
    public static final int FRAME_INVALID = 0;
    public static final int FRAME_STATUSLINE = 1;
    public static final int FRAME_LIST = 2;
    public static final int FRAME_RGI = 3;
    public static final int FRAME_TAB = 4;
    public static final int FRAME_RGI_EXT = 5;
    public static final int FRAME_CROSSING_ZOOM = 6;
    public static final int FRAME_COMPASS = 7;
    public static final int FRAME_LANE_GUIDANCE = 8;
    public static final int FRAME_NAVI_LIST = 9;
    public static final int FRAME_NAVI_SUBMENU = 10;
    public static final int FRAME_MEDIA_LIST = 11;
    public static final int FRAME_MEDIA_SUBMENU = 12;
    public static final int FRAME_PHONE_LIST = 13;
    public static final int FRAME_PHONE_SUBMENU = 14;
    public static final int FRAME_PHONE_POPUP = 16;
    public static final int FRAME_TRAFFIC_SIGN = 17;
    public static final int FRAME_MEDIA_FASTSCROLL_POPUP = 18;
    public static final int FRAME_PHONE_FASTSCROLL_POPUP = 19;
    public static final int FRAME_NAVI_FASTSCROLL_POPUP = 20;
    public static final int FRAME_MMI_INFO = 21;
    public static final int RT_GETDISPLAYSTATUS = 1000;
    public static final int RT_SETHMISTATE = 1001;
    public static final int RT_SETNAVISTATE = 1002;
    public static final int RT_SETMEDIASTATE = 1003;
    public static final int RT_SETPHONESTATE = 1004;
    public static final int RT_SETFRAMESTATUS = 1005;
    public static final int RT_SETFRAMEUPDATE = 1006;
    public static final int RT_SETMANEUVER = 1007;
    public static final int RT_SETCOMPASS = 1008;
    public static final int RT_SETDISTANCEBAR = 1009;
    public static final int RT_SETDEVIATIONBAR = 1010;
    public static final int RT_SETTEXT = 1011;
    public static final int RT_SETTEXTSTYLE = 1012;
    public static final int RT_SETCOLOR = 1013;
    public static final int RT_SETCURSOR = 1014;
    public static final int RT_SETTRAFFICSIGN = 1015;
    public static final int RT_SETLANEGUIDANCEHEADER = 1016;
    public static final int RT_SETLANEGUIDANCEDATA = 1017;
    public static final int RT_SETCODEPAGE = 1018;

    public void getDisplayStatus();

    public void setHMIState(int var1, int var2, int var3);

    public void setNaviState(int var1, int var2);

    public void setMediaState(int var1);

    public void setPhoneState(int var1, int var2, int var3);

    public void setFrameStatus(DisplayRequest var1);

    public void setFrameUpdate(UpdateRequest var1);

    public void setManeuver(int var1, short[] var2, boolean var3);

    public void setCompass(int var1, short[] var2, boolean var3);

    public void setDistanceBar(int var1, int var2, boolean var3, boolean var4);

    public void setDeviationBar(int var1, int var2, boolean var3, boolean var4);

    public void setText(int var1, int var2, String var3, int var4, boolean var5);

    public void setTextStyle(int var1, int var2, int var3, int var4, boolean var5);

    public void setColor(int var1, int var2, int[] var3, boolean var4);

    public void setCursor(int var1, int var2, int var3, int var4, int var5, boolean var6);

    public void setTrafficSign(int var1, int var2, int var3, int var4, boolean var5);

    public void setLaneGuidanceHeader(int var1, int var2, int var3, int var4, int var5, boolean var6);

    public void setLaneGuidanceData(int var1, int var2, int var3, int var4, short[] var5, boolean var6);

    public void setCodePage(int var1);
}

