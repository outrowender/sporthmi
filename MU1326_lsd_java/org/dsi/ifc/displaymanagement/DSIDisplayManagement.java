/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.displaymanagement;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.displaymanagement.DisplayContext;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIDisplayManagement
extends DSIBase {
    public static final String VERSION = "2.11.27";
    public static final int RT_DECLARECONTEXTS = 1000;
    public static final int RT_SWITCHCONTEXT = 1001;
    public static final int RT_SETOPACITY = 1002;
    public static final int RT_FADETOOPACITY = 1003;
    public static final int RT_SETPOSITION = 1004;
    public static final int RT_GETEXTENTS = 1005;
    public static final int RT_TAKESCREENSHOT = 1006;
    public static final int RT_LOCKDISPLAY = 1007;
    public static final int RT_UNLOCKDISPLAY = 1008;
    public static final int RT_SWITCHDISPLAYPOWER = 1009;
    public static final int RT_GETDISPLAYPOWER = 1010;
    public static final int RT_SETDISPLAYBRIGHTNESS = 1011;
    public static final int RT_SETBRIGHTNESS = 1012;
    public static final int RT_GETBRIGHTNESS = 1013;
    public static final int RT_SETCONTRAST = 1014;
    public static final int RT_GETCONTRAST = 1015;
    public static final int RT_SETCOLOR = 1016;
    public static final int RT_GETCOLOR = 1017;
    public static final int RT_SETTINT = 1018;
    public static final int RT_GETTINT = 1019;
    public static final int RT_GETDISPLAYBRIGHTNESS = 1022;
    public static final int RT_SETCROPPING = 1023;
    public static final int RT_GETDISPLAYABLEINFO = 1024;
    public static final int RT_SETDIMENSION = 1025;
    public static final int RT_SETSCALEMODE = 1026;
    public static final int RT_TAKESCREENSHOTONEXTERNALSTORAGE = 1027;
    public static final int RT_SETDISPLAYTYPE = 1028;
    public static final int RT_GETDISPLAYTYPE = 1029;
    public static final int RT_SETUPDATERATE = 1030;
    public static final int RT_GETUPDATERATE = 1031;
    public static final int RT_STARTCOMPONENT = 1032;
    public static final int RT_STOPCOMPONENT = 1033;
    public static final int RT_CREATEIMAGEDISPLAYABLE = 1034;
    public static final int RT_REQUESTUPDATEIMAGEDISPLAYABLE = 1035;
    public static final int RT_DESTROYIMAGEDISPLAYABLE = 1036;
    public static final int RT_INITANNOTATIONS = 1037;
    public static final int RT_SETANNOTATIONDATA = 1038;
    public static final int RP_GETEXTENTS = 2000;
    public static final int RP_ACTIVECONTEXT = 2001;
    public static final int RP_FADESTARTED = 2002;
    public static final int RP_FADECOMPLETE = 2003;
    public static final int RP_GETDISPLAYPOWER = 2004;
    public static final int RP_GETBRIGHTNESS = 2005;
    public static final int RP_GETCONTRAST = 2006;
    public static final int RP_GETCOLOR = 2007;
    public static final int RP_GETTINT = 2008;
    public static final int RP_LOCKDISPLAYRESULT = 2010;
    public static final int RP_UNLOCKDISPLAYRESULT = 2011;
    public static final int RP_GETDISPLAYBRIGHTNESS = 2012;
    public static final int RP_SETCROPPINGRESULT = 2013;
    public static final int RP_GETDISPLAYABLEINFO = 2014;
    public static final int RP_TAKESCREENSHOTONEXTERNALSTORAGERESULT = 2015;
    public static final int RP_SETDISPLAYTYPERESULT = 2016;
    public static final int RP_GETDISPLAYTYPERESULT = 2017;
    public static final int RP_SETUPDATERATERESULT = 2018;
    public static final int RP_GETUPDATERATERESULT = 2019;
    public static final int RP_STARTCOMPONENTRESULT = 2020;
    public static final int RP_STOPCOMPONENTRESULT = 2021;
    public static final int RP_SETANNOTATIONDATARESPONSE = 2022;
    public static final int RP_INITANNOTATIONSRESPONSE = 2023;
    public static final int RP_DESTROYIMAGEDISPLAYABLERESPONSE = 2024;
    public static final int RP_REQUESTUPDATEIMAGEDISPLAYABLERESPONSE = 2025;
    public static final int RP_CREATEIMAGEDISPLAYABLERESPONSE = 2026;

    public void declareContexts(DisplayContext[] var1);

    public void switchContext(int var1, int var2, int var3);

    public void setOpacity(int var1, int var2, int var3);

    public void fadeToOpacity(int var1, int var2, int var3, int var4);

    public void setPosition(int var1, int var2, int var3, int var4);

    public void getExtents(int var1);

    public void takeScreenshot(int var1, String var2);

    public void lockDisplay(int var1);

    public void unlockDisplay(int var1);

    public void switchDisplayPower(int var1, int var2);

    public void getDisplayPower(int var1);

    public void setDisplayBrightness(int var1, int var2);

    public void getDisplayBrightness(int var1);

    public void setBrightness(int var1, int var2);

    public void getBrightness(int var1);

    public void setContrast(int var1, int var2);

    public void getContrast(int var1);

    public void setColor(int var1, int var2);

    public void getColor(int var1);

    public void setTint(int var1, int var2);

    public void getTint(int var1);

    public void setCropping(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10);

    public void getDisplayableInfo(int var1, int var2);

    public void setDimension(int var1, int var2, int var3, int var4);

    public void setScaleMode(int var1, int var2, int var3);

    public void takeScreenshotOnExternalStorage(int var1, String var2);

    public void setDisplayType(int var1, int var2);

    public void getDisplayType(int var1);

    public void setUpdateRate(int var1, int var2);

    public void getUpdateRate(int var1);

    public void startComponent(int var1, int var2, int var3);

    public void stopComponent(int var1, int var2, int var3);

    public void createImageDisplayable(ResourceLocator var1, int var2);

    public void requestUpdateImageDisplayable(ResourceLocator var1, int var2);

    public void destroyImageDisplayable(int var1);

    public void initAnnotations(int var1);

    public void setAnnotationData(int var1, int var2, String var3);
}

