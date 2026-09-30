/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.keypanel;

import org.dsi.ifc.base.DSIBase;

public interface DSIKeyPanel
extends DSIBase {
    public static final String VERSION = "2.11.33";
    public static final int RT_SETILLUMINATION = 1000;
    public static final int RT_SETTMDISPLAYSTATE = 1002;
    public static final int RT_SETRECOGNIZERLANGUAGE = 1003;
    public static final int RT_SETRECOGNIZERMODE = 1004;
    public static final int RT_SETGENERICSETTING = 1005;
    public static final int RT_RESETDEVICE = 1006;
    public static final int RT_REQUESTGENERICSETTING = 1009;
    public static final int RT_REQUESTLASTKEY = 1010;
    public static final int RT_SETHAPTICFEEDBACK = 1011;
    public static final int RT_SETRECOGNIZERLANGUAGE2 = 1012;
    public static final int RT_GETVERSIONINFO = 1013;
    public static final int RT_SETTOUCHSENSITIVEAREA = 1014;
    public static final int RT_CLEARRECOGNIZER = 1015;
    public static final int RT_GETPROPERTY = 1016;
    public static final int ATTR_DISPLAYTURNMECHSTATUS = 7;
    public static final int ATTR_RECOGNIZERMODE = 9;
    public static final int ATTR_PROXIMITY = 18;
    public static final int ATTR_KEYBOARDTYPE = 19;
    public static final int ATTR_GESTURE2 = 20;
    public static final int ATTR_CHARACTEREVENT2 = 21;
    public static final int ATTR_RECOGNIZERLANGUAGE2 = 22;
    public static final int ATTR_ENCODER2 = 23;
    public static final int ATTR_TOUCHSENSITIVEAREA = 24;
    public static final int ATTR_KEY2 = 25;
    public static final int ATTR_INPUTPANELREADY = 26;
    public static final int ATTR_ADVANCEDPROXIMITY = 27;
    public static final int RP_GENERICSETTINGRESPONSE = 2000;
    public static final int RP_LASTKEY = 2001;
    public static final int RP_GETVERSIONINFO = 2002;
    public static final int RP_GETPROPERTY = 2003;

    public void setIllumination(int var1, int var2, int var3);

    public void setHapticFeedback(int var1, int var2, int var3);

    public void setTMDisplayState(boolean var1);

    public void setRecognizerLanguage(int var1, String var2);

    public void setRecognizerLanguage2(int var1, String var2, int var3);

    public void setRecognizerMode(int var1, int var2);

    public void clearRecognizer(int var1);

    public void setGenericSetting(int var1, int var2, int var3);

    public void resetDevice(int var1);

    public void requestGenericSetting(int var1, int var2);

    public void requestLastKey(int var1);

    public void getVersionInfo(int var1, int var2);

    public void setTouchSensitiveArea(int var1, int var2, int var3, int var4, int var5);

    public void getProperty(int var1, int var2, int var3);
}

