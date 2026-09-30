/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.modelapi;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.modelapi.ListRowData;
import org.dsi.ifc.modelapi.NBestResultEntry;

public interface DSIModelAPI
extends DSIBase {
    public static final String VERSION = "2.11.12";
    public static final int STATE_HMI_STATE_NAV_ENTER = 0;
    public static final int STATE_HMI_STATE_NAV_EXIT = 1;
    public static final int STATE_HMI_STATE_HK_RETURN = 2;
    public static final int STATE_HMI_STATE_HK_SETUP = 3;
    public static final int STATE_HMI_STATE_INFO_ENTER = 4;
    public static final int STATE_HMI_STATE_INFO_EXIT = 5;
    public static final int STATE_HMI_STATE_ANNOUNCEMENT_ENTER = 6;
    public static final int STATE_HMI_STATE_ANNOUNCEMENT_EXIT = 7;
    public static final int STATE_HMI_STATE_NAV_SETUP_ENTER = 8;
    public static final int STATE_HMI_STATE_NAV_SETUP_EXIT = 9;
    public static final int STATE_HMI_STATE_INFO_SETUP_ENTER = 10;
    public static final int STATE_HMI_STATE_INFO_SETUP_EXIT = 11;
    public static final int STATE_HMI_STATE_TRAFFIC_ENTER = 12;
    public static final int STATE_HMI_STATE_TRAFFIC_EXIT = 13;
    public static final int STATE_HMI_STATE_REMOTE_NAV_ASIA_ENTER = 14;
    public static final int STATE_HMI_STATE_REMOTE_NAV_ASIA_EXIT = 15;
    public static final int CONTEXTID_HMI_CONTEXT_NAVI = 0;
    public static final int CONTEXTID_HMI_CONTEXT_INFO = 1;
    public static final int CONTEXTID_HMI_CONTEXT_NAVI_SETUP = 2;
    public static final int CONTEXTID_HMI_CONTEXT_INFO_SETUP = 3;
    public static final int CONTEXTID_HMI_CONTEXT_TRAFFIC = 4;
    public static final int CONTEXTID_HMI_CONTEXT_TEL = 5;
    public static final int RT_POPUPREMOVED = 1000;
    public static final int RT_HMISTATE = 1001;
    public static final int RT_KEYTYPED = 1002;
    public static final int RT_INCREMENT = 1003;
    public static final int RT_DECREMENT = 1004;
    public static final int RT_TEXTCHANGED = 1005;
    public static final int RT_ITEMSELECTED = 1006;
    public static final int RT_ITEMFOCUSED = 1007;
    public static final int RT_FILLLISTBUFFERATSTART = 1008;
    public static final int RT_FILLLISTBUFFERATEND = 1009;
    public static final int RT_TEXTCHANGEDFREETEXTSPELLER = 1010;
    public static final int RT_SCREENHIDDEN = 1011;
    public static final int RT_SCREENVISIBLE = 1012;
    public static final int RT_TOUCHPADMOVEMENT = 1013;
    public static final int RT_VALIDATECHARACTERS = 1014;
    public static final int RT_TOUCHSCREENPRESSED = 1015;
    public static final int RT_TOUCHSCREENLONGPRESSED = 1016;
    public static final int RT_TOUCHSCREENMOVED = 1017;
    public static final int RT_TOUCHSCREENRELEASED = 1018;
    public static final int RT_INPUTMODECHANGED = 1019;
    public static final int RT_SDSSESSIONENDED = 1020;
    public static final int RT_SDSSESSIONSTARTED = 1021;
    public static final int RT_SDSRULEFIRED = 1022;
    public static final int RT_SDSRULEFIREDNBEST = 1023;
    public static final int RT_ITEMDRAG = 1024;
    public static final int RT_ITEMSELECTEDCOLUMN = 1025;
    public static final int RT_TOUCHSCREENZOOM = 1026;
    public static final int RT_SDSRULEFIREDONESHOT = 1027;
    public static final int RT_SDSPROMPTFINISHED = 1028;
    public static final int RT_LISTDATACHANGED = 1029;
    public static final int RT_ADDSPELLERSTROKE = 1030;
    public static final int RT_GETVALIDHANZICHARSWINDOW = 1031;
    public static final int RT_SETPOIVIEWPORTDATA = 1032;
    public static final int RT_RESPONSESTATEMACHINECONTROL = 1033;
    public static final int RP_VALIDATECHARACTERSRESULT = 2000;
    public static final int RP_GETVALIDHANZICHARSWINDOWRESULT = 2001;
    public static final int IN_SHOWSCREEN = 3000;
    public static final int IN_SHOWINFOSCREEN = 3001;
    public static final int IN_SHOWPOPUP = 3002;
    public static final int IN_REMOVEPOPUP = 3003;
    public static final int IN_SETVISIBLE = 3004;
    public static final int IN_SETLABEL = 3005;
    public static final int IN_SETMODELENABLED = 3006;
    public static final int IN_SETCHOICEVALUE = 3007;
    public static final int IN_SETTEXTFIELD = 3008;
    public static final int IN_SETRANGELIMITS = 3009;
    public static final int IN_SETRANGEVALUE = 3010;
    public static final int IN_SETTEXT = 3011;
    public static final int IN_SETMATCHSPELLERDATA = 3012;
    public static final int IN_SETMATCHCOUNT = 3013;
    public static final int IN_SETMETRICSINVALID = 3014;
    public static final int IN_SETMETRICSVALUE = 3015;
    public static final int IN_SETLISTDATA = 3016;
    public static final int IN_SETSELECTED = 3017;
    public static final int IN_SETSLIDINGLISTDATA = 3018;
    public static final int IN_FILLLISTBUFFERATSTART = 3019;
    public static final int IN_FILLLISTBUFFERATEND = 3020;
    public static final int IN_SETRGIDATA = 3021;
    public static final int IN_FILLSLIDINGLISTROW = 3022;
    public static final int IN_SWITCHCONTEXT = 3023;
    public static final int IN_SETMODELPRESSED = 3024;
    public static final int IN_SHOWSETUPSCREEN = 3025;
    public static final int IN_SHOWINFOSETUPSCREEN = 3026;
    public static final int IN_TRIGGERSDCOMPONENT = 3027;
    public static final int IN_SHOWTRAFFICSCREEN = 3028;
    public static final int IN_REMOVESINGLEPOPUP = 3029;
    public static final int IN_SETSUBLISTDATA = 3030;
    public static final int IN_SETSLIDINGSUBLISTDATA = 3031;
    public static final int IN_SETFMTTIME = 3032;
    public static final int IN_SETFMTDATE = 3033;
    public static final int IN_SETFMTRTT = 3034;
    public static final int IN_SETFMTDISTANCE = 3035;
    public static final int IN_SETFMTALTITUDE = 3036;
    public static final int IN_SETFMTRADIOFREQUENCY = 3037;
    public static final int IN_SETFMTORIENTATION = 3038;
    public static final int IN_SETFMTGEOCOORDINATESLONGITUDE = 3039;
    public static final int IN_SETFMTGEOCOORDINATESLATITUDE = 3040;
    public static final int IN_SETSLIDINGLISTSIZE = 3041;
    public static final int IN_SETDYNAMICIMAGE = 3042;
    public static final int IN_SETSDSDYNAMICVALUE = 3043;
    public static final int IN_SETSDSDYNAMICOBJECTID = 3044;
    public static final int IN_REQUESTSTATEMACHINECONTROL = 3045;
    public static final int IN_DDSHANDLED = 3046;
    public static final int IN_SETSLIDINGLISTDATAWITHINITIALCURSORPOS = 3047;

    public void popupRemoved(int var1);

    public void hmiState(int var1);

    public void keyTyped(int var1);

    public void increment(int var1, int var2);

    public void decrement(int var1, int var2);

    public void textChanged(int var1, String var2, String var3);

    public void itemSelected(int var1, long var2);

    public void itemFocused(int var1, long var2);

    public void itemDrag(int var1, long var2, long var4);

    public void itemSelectedColumn(int var1, long var2, int var4);

    public void fillListBufferAtStart(int var1, long var2, int var4);

    public void fillListBufferAtEnd(int var1, long var2, int var4);

    public void textChangedFreeTextSpeller(int var1, String var2, String var3, String var4, String var5);

    public void screenHidden(int var1);

    public void screenVisible(int var1);

    public void touchPadMovement(int var1, int var2, int var3);

    public void validateCharacters(int var1, String var2);

    public void touchScreenPressed(int var1, int var2, int var3);

    public void touchScreenLongPressed(int var1, int var2);

    public void touchScreenMoved(int var1, int var2, int var3, int var4, int var5);

    public void touchScreenReleased(int var1, int var2, int var3);

    public void touchScreenZoom(int var1, int var2, int var3, int var4, int var5);

    public void inputModeChanged(int var1, int var2);

    public void sdsSessionEnded();

    public void sdsSessionStarted();

    public void sdsRuleFired(int var1);

    public void sdsRuleFiredNBest(int var1, NBestResultEntry var2);

    public void sdsRuleFiredOneShot(int var1, NBestResultEntry[] var2);

    public void sdsPromptFinished();

    public void listDataChanged(int var1, ListRowData[] var2);

    public void setPOIViewPortData(int var1, ListRowData[] var2, int var3, double[] var4);

    public void addSpellerStroke(int var1, String var2, String var3);

    public void getValidHanziCharsWindow(int var1, int var2, int var3);

    public void responseStateMachineControl();
}

