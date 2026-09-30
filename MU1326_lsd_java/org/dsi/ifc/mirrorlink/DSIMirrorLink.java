/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.mirrorlink.ClientCapabilities;
import org.dsi.ifc.mirrorlink.Event;

public interface DSIMirrorLink
extends DSIBase {
    public static final String VERSION = "2.11.13";
    public static final int ATTR_DISCOVEREDDEVICES = 1;
    public static final int ATTR_DEVICECONNECTIONSTATUS = 3;
    public static final int ATTR_DEVICESOFTKEYS = 4;
    public static final int ATTR_APPLICATIONSTATUS = 5;
    public static final int ATTR_SCREENORIENTATION = 6;
    public static final int ATTR_SHOWKEYBOARD = 7;
    public static final int ATTR_SCREENORIENTATIONAVAILABLE = 8;
    public static final int ATTR_SCREENROTATIONAVAILABLE = 9;
    public static final int ATTR_AUDIOCONNECTIONREQUESTED = 10;
    public static final int ATTR_AVAILABLEAPPLICATIONSLIST = 11;
    public static final int ATTR_SINGLEAPPLICATIONMODE = 12;
    public static final int ATTR_PHONEVIEWAVAILABLE = 13;
    public static final int ATTR_UNCERTIFIEDCONTENT = 14;
    public static final int ATTR_DEVICESTATUS = 15;
    public static final int ATTR_SWAPSTATUS = 16;
    public static final int ATTR_SHOWNOTIFICATION = 17;
    public static final int ATTR_NOTIFICATIONSERVICEENABLED = 18;
    public static final int ATTR_LOCATIONDATASERVICESENABLED = 19;
    public static final int ATTR_SWITCHTOCLIENTNATIVEUI = 20;
    public static final int RT_REQUESTCLIENTCAPABILITIES = 1000;
    public static final int RT_REQUESTACCESSMODE = 1001;
    public static final int RT_REQUESTDAYNIGHTMODE = 1002;
    public static final int RT_REQUESTUSABLEVIEWPORT = 1003;
    public static final int RT_REQUESTCONNECTDEVICE = 1004;
    public static final int RT_REQUESTDISCONNECTDEVICE = 1005;
    public static final int RT_REQUESTROTATESCREEN = 1006;
    public static final int RT_REQUESTCHANGEORIENTATION = 1007;
    public static final int RT_REQUESTSOFTKEYEVENT = 1008;
    public static final int RT_REQUESTLAUNCHAPP = 1009;
    public static final int RT_REQUESTTERMINATEAPP = 1010;
    public static final int RT_REQUESTSTARTSPELLER = 1011;
    public static final int RT_REQUESTADDSPELLERCHARS = 1012;
    public static final int RT_REQUESTREMOVESPELLERCHAR = 1013;
    public static final int RT_REQUESTCLEARSPELLER = 1014;
    public static final int RT_REQUESTSENDSTRING = 1016;
    public static final int RT_REQUESTAUDIOOPTION = 1017;
    public static final int RT_REQUESTAUDIOCONNECTIONAUDIBLE = 1018;
    public static final int RT_REQUESTSENDTOUCHEVENTS = 1019;
    public static final int RT_REQUESTCONTEXTVISIBLE = 1020;
    public static final int RT_REQUESTKEYBOARDMODE = 1021;
    public static final int RT_REQUESTAVAILABLEAPPLICATIONSWINDOW = 1022;
    public static final int RT_REQUESTDISPLAYKEYBOARD = 1023;
    public static final int RT_REQUESTDISMISSHMIKEYBOARD = 1024;
    public static final int RT_REQUESTFACTORYSETTINGS = 1025;
    public static final int RT_REQUESTPHONEVIEW = 1026;
    public static final int RT_REQUESTCONTEXTSWITCHED = 1027;
    public static final int RT_INVOKENOTIACTION = 1028;
    public static final int RT_REQUESTNOTIFICATIONSERVICEENABLED = 1029;
    public static final int RT_REQUESTLOCATIONDATASERVICESENABLED = 1030;
    public static final int RP_RESPONSECLIENTCAPABILITIES = 2000;
    public static final int RP_RESPONSEACCESSMODE = 2001;
    public static final int RP_RESPONSEDAYNIGHTMODE = 2002;
    public static final int RP_RESPONSEUSABLEVIEWPORT = 2003;
    public static final int RP_RESPONSECONTEXTVISIBLE = 2004;
    public static final int RP_RESPONSECONNECTDEVICE = 2005;
    public static final int RP_RESPONSEDISCONNECTDEVICE = 2006;
    public static final int RP_RESPONSEROTATESCREEN = 2007;
    public static final int RP_RESPONSESOFTKEYEVENT = 2008;
    public static final int RP_RESPONSELAUNCHAPP = 2009;
    public static final int RP_RESPONSETERMINATEAPP = 2010;
    public static final int RP_RESPONSESPELLERRESULT = 2011;
    public static final int RP_RESPONSESENDSTRING = 2013;
    public static final int RP_RESPONSEAUDIOOPTION = 2014;
    public static final int RP_RESPONSEAUDIOCONNECTIONAUDIBLE = 2015;
    public static final int RP_RESPONSESENDTOUCHEVENTS = 2016;
    public static final int RP_RESPONSEKEYBOARDMODE = 2017;
    public static final int RP_RESPONSEAVAILABLEAPPLICATIONSWINDOW = 2018;
    public static final int RP_RESPONSEDISPLAYKEYBOARD = 2019;
    public static final int RP_RESPONSEDISMISSHMIKEYBOARD = 2020;
    public static final int RP_RESPONSEFACTORYSETTINGS = 2021;
    public static final int RP_RESPONSEPHONEVIEW = 2022;
    public static final int RP_RESPONSECONTEXTSWITCHED = 2023;

    public void requestClientCapabilities(ClientCapabilities var1);

    public void requestAccessMode(int var1);

    public void requestDayNightMode(int var1);

    public void requestUsableViewport(int var1, int var2, int var3, int var4);

    public void requestContextVisible(boolean var1);

    public void requestConnectDevice(int var1);

    public void requestDisconnectDevice(int var1);

    public void requestRotateScreen(int var1);

    public void requestChangeOrientation(int var1);

    public void requestSoftKeyEvent(int var1, int var2);

    public void requestLaunchApp(int var1);

    public void requestTerminateApp(int var1);

    public void requestStartSpeller(String var1);

    public void requestAddSpellerChars(String var1);

    public void requestRemoveSpellerChar();

    public void requestClearSpeller();

    public void requestSendString(String var1);

    public void requestAudioOption(int var1);

    public void requestAudioConnectionAudible(int var1, boolean var2);

    public void requestSendTouchEvents(Event[] var1, int var2);

    public void requestKeyboardMode(int var1);

    public void requestAvailableApplicationsWindow(int var1, int var2);

    public void requestDisplayKeyboard();

    public void requestDismissHMIKeyboard();

    public void requestFactorySettings();

    public void requestPhoneView();

    public void requestContextSwitched(boolean var1);

    public void invokeNotiAction(int var1, int var2);

    public void requestNotificationServiceEnabled(boolean var1, int var2, int var3, int var4, int var5);

    public void requestLocationDataServicesEnabled(boolean var1);
}

