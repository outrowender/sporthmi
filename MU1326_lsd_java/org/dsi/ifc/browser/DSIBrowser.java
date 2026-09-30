/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.browser.TimePeriod;

public interface DSIBrowser
extends DSIBase {
    public static final String VERSION = "2.11.18";
    public static final int ATTR_BROWSERSTATE = 1;
    public static final int ATTR_PAGETITLE = 2;
    public static final int ATTR_ACTIVEURL = 3;
    public static final int ATTR_ZOOMFACTOR = 4;
    public static final int ATTR_PROGRESS = 7;
    public static final int ATTR_BUTTONSTATE = 10;
    public static final int ATTR_SCROLLBARX = 12;
    public static final int ATTR_SCROLLBARY = 13;
    public static final int ATTR_HASFOCUS = 14;
    public static final int ATTR_ENCRYPTION = 15;
    public static final int ATTR_VIRTUALKEYBOARDSTATUS = 16;
    public static final int ATTR_SELECTIONLISTCONTENT = 17;
    public static final int ATTR_KEYBOARDDISPLAY = 18;
    public static final int RT_CANCELLOADING = 1000;
    public static final int RT_FOLLOWLINK = 1001;
    public static final int RT_GETPREFERENCE = 1002;
    public static final int RT_GOBACK = 1003;
    public static final int RT_GOFORWARD = 1004;
    public static final int RT_GOTOHOMEURL = 1005;
    public static final int RT_LOADURL = 1006;
    public static final int RT_NEXTFOCUS = 1007;
    public static final int RT_PREVIOUSFOCUS = 1008;
    public static final int RT_SCROLL = 1009;
    public static final int RT_RELOADURL = 1010;
    public static final int RT_SETPREFERENCE = 1011;
    public static final int RT_STOPBROWSER = 1013;
    public static final int RT_ZOOM = 1014;
    public static final int RT_DELETEHISTORY = 1015;
    public static final int RT_SUSPENDBROWSER = 1016;
    public static final int RT_RESUMEBROWSER = 1017;
    public static final int RT_SETLANGUAGE = 1018;
    public static final int RT_DOWNLOADFILE = 1020;
    public static final int RT_CLICKONPOSITION = 1021;
    public static final int RT_DELETECOOKIES = 1022;
    public static final int RT_ENTERIMAGESELECTIONMODE = 1024;
    public static final int RT_JAVASCRIPTALERTACK = 1025;
    public static final int RT_JAVASCRIPTCONFIRMACK = 1026;
    public static final int RT_JAVASCRIPTPROMPTACK = 1027;
    public static final int RT_DELETEPASSWORDS = 1028;
    public static final int RT_DELETECACHE = 1029;
    public static final int RT_BRINGTOFRONT = 1030;
    public static final int RT_KEYBOARDINPUT = 1031;
    public static final int RT_SETSELECTION = 1032;
    public static final int RT_RESETTOFACTORYDEFAULTS = 1033;
    public static final int RT_EXPORTBROWSERDATA = 1035;
    public static final int RT_IMPORTBROWSERDATA = 1036;
    public static final int RT_GETHISTORY = 1037;
    public static final int RT_EXECUTEJAVASCRIPT = 1038;
    public static final int RT_TOUCHSCROLL = 1039;
    public static final int RP_GETPREFERENCERESULT = 2000;
    public static final int RP_RESUMEBROWSERRESULT = 2005;
    public static final int RP_EXPORTBROWSERDATARESULT = 2006;
    public static final int RP_IMPORTBROWSERDATARESULT = 2007;
    public static final int RP_GETHISTORYRESULT = 2008;
    public static final int IN_JAVASCRIPTALERT = 3001;
    public static final int IN_JAVASCRIPTCONFIRM = 3002;
    public static final int IN_JAVASCRIPTPROMPT = 3003;
    public static final int IN_INDICATEEFIURL = 3004;
    public static final int IN_INDICATEDOWNLOADURL = 3005;
    public static final int IN_INDICATEUNKNOWNMIMETYPE = 3006;
    public static final int IN_INDICATEPOPUP = 3007;
    public static final int IN_INDICATEDOWNLOADPROGRESS = 3008;

    public void cancelLoading();

    public void followLink(boolean var1);

    public void getPreference(int var1);

    public void goBack();

    public void goForward();

    public void gotoHomeUrl();

    public void loadUrl(String var1);

    public void nextFocus(int var1);

    public void previousFocus(int var1);

    public void scroll(int var1, int var2);

    public void reloadUrl();

    public void setPreference(int var1, int var2, String var3);

    public void stopBrowser();

    public void zoom(int var1, boolean var2);

    public void suspendBrowser();

    public void resumeBrowser();

    public void setLanguage(String var1);

    public void deleteCookies();

    public void deleteHistory();

    public void deletePasswords();

    public void deleteCache();

    public void downloadFile(String var1, String var2);

    public void enterImageSelectionMode();

    public void clickOnPosition(int var1, int var2, boolean var3);

    public void javaScriptAlertAck();

    public void javaScriptConfirmAck(boolean var1);

    public void javaScriptPromptAck(String var1, boolean var2);

    public void bringToFront();

    public void keyboardInput(String var1);

    public void setSelection(int var1, boolean var2);

    public void resetToFactoryDefaults();

    public void exportBrowserData(String var1);

    public void importBrowserData(String var1);

    public void getHistory(TimePeriod var1);

    public void executeJavaScript(String var1);

    public void touchScroll(int var1, int var2);
}

