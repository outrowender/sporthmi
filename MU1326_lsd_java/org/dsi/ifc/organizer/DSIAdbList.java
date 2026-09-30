/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbList
extends DSIBase {
    public static final String VERSION = "2.11.31";
    public static final int RT_STARTSPELLER = 1000;
    public static final int RT_STOPSPELLER = 1001;
    public static final int RT_ADDSPELLERCHARS = 1002;
    public static final int RT_REMOVESPELLERCHAR = 1003;
    public static final int RT_GETVIEWWINDOW = 1004;
    public static final int RT_VALIDATESPELLERCHARS = 1005;
    public static final int RT_SETLISTSTYLE = 1006;
    public static final int RT_GETSPELLERVIEWWINDOW = 1007;
    public static final int RT_GETVALIDHANZICHARSWINDOW = 1008;
    public static final int RT_ADDSPELLERSTROKE = 1009;
    public static final int ATTR_VIEWSIZE = 1;
    public static final int ATTR_ALPHABETICALINDEX = 2;
    public static final int RP_STOPSPELLERRESULT = 2001;
    public static final int RP_SPELLERRESULT = 2002;
    public static final int RP_GETVIEWWINDOWRESULT = 2003;
    public static final int RP_VALIDATESPELLERCHARSRESULT = 2004;
    public static final int RP_SETLISTSTYLERESULT = 2005;
    public static final int RP_GETSPELLERVIEWWINDOWRESULT = 2006;
    public static final int RP_GETVALIDHANZICHARSWINDOWRESULT = 2008;
    public static final int IN_INVALIDDATA = 3000;

    public void startSpeller(int var1, int var2, int var3);

    public void stopSpeller(int var1);

    public void addSpellerChars(int var1, String var2);

    public void addSpellerStroke(int var1, String var2);

    public void removeSpellerChar(int var1);

    public void validateSpellerChars(int var1, String var2);

    public void getViewWindow(long var1, int var3, int var4, int var5);

    public void getSpellerViewWindow(int var1, long var2, int var4, int var5, int var6);

    public void getValidHanziCharsWindow(int var1, int var2, int var3);

    public void setListStyle(int var1, int var2, int var3);
}

