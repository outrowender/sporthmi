/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public interface DSIMapViewerStreetViewCtrl
extends DSIBase {
    public static final String VERSION = "2.11.62";
    public static final int ATTR_STREETVIEWLOADSTATUS = 1;
    public static final int ATTR_STREETVIEWAVAILABLE = 2;
    public static final int ATTR_STREETVIEWZOOMLISTINDEX = 3;
    public static final int ATTR_STREETVIEWZOOMLIST = 4;
    public static final int ATTR_STREETVIEWTHUMBNAILS = 5;
    public static final int ATTR_POSITION = 6;
    public static final int ATTR_ROTATION = 7;
    public static final int ATTR_SCREENVIEWPORT = 8;
    public static final int ATTR_STREETVIEWZOOMLEVEL = 9;
    public static final int ATTR_STREETVIEWPOSITION = 10;
    public static final int RT_STREETVIEWENABLED = 1000;
    public static final int RT_STREETVIEWVISIBLE = 1001;
    public static final int RT_STREETVIEWFREEZE = 1002;
    public static final int RT_SETSTREETVIEWZOOMINDEX = 1004;
    public static final int RT_STREETVIEWTHUMBNAILS = 1005;
    public static final int RT_LOADSTREETVIEW = 1006;
    public static final int RT_ROTATEVIEW = 1007;
    public static final int RT_ROTATEVIEWBYPOLARCOORDINATES = 1008;
    public static final int RT_GETINFOFORSCREENPOSITION = 1009;
    public static final int RT_SETPOSITION = 1010;
    public static final int RT_SETCROSSHAIRSVISIBILITY = 1011;
    public static final int RT_SETDAYNIGHTVIEW = 1012;
    public static final int RT_SETAZIMUTH = 1013;
    public static final int RT_SETINCLINATION = 1014;
    public static final int RT_SNAPSHOT = 1015;
    public static final int RT_SETVIEWROTATIONBYPOLARCOORDINATES = 1016;
    public static final int RT_STARTVIEWROTATIONBYPOLARCOORDINATES = 1017;
    public static final int RT_STOPVIEWROTATIONBYPOLARCOORDINATES = 1018;
    public static final int RT_GOTOVIEW = 1019;
    public static final int RT_SETSCREENVIEWPORT = 1020;
    public static final int RT_SETCROSSHAIRSPOSITION = 1021;
    public static final int RT_SETSTREETVIEWZOOMLEVEL = 1022;
    public static final int RP_STREETVIEWENABLED = 2000;
    public static final int RP_STREETVIEWVISIBLE = 2001;
    public static final int RP_STREETVIEWFREEZE = 2002;
    public static final int RP_GETINFOFORPOSITION = 2004;
    public static final int RP_SNAPSHOTRESULT = 2005;
    public static final int RESULTCODE_OK = 0;
    public static final int RESULTCODE_FAIL = 1;
    public static final int RESULTCODE_UNSUPPORTED = 2;
    public static final int LOADSTATUS_STATUS_IDLE = 0;
    public static final int LOADSTATUS_STATUS_LOADING = 1;
    public static final int LOADSTATUS_STATUS_LOAD_COMPLETE = 2;

    public void streetViewEnabled(boolean var1);

    public void streetViewVisible(boolean var1);

    public void streetViewFreeze(boolean var1);

    public void goToView();

    public void setStreetViewZoomIndex(int var1);

    public void streetViewThumbnails(StreetViewThumbnail[] var1);

    public void loadStreetView(boolean var1);

    public void rotateView(short var1, short var2);

    public void rotateViewByPolarCoordinates(int var1, int var2);

    public void setAzimuth(int var1);

    public void setInclination(int var1);

    public void getInfoForScreenPosition(short var1, short var2);

    public void setPosition(NavLocationWgs84 var1);

    public void setCrossHairsVisibility(boolean var1);

    public void setDayNightView(boolean var1);

    public void snapshot();

    public void setViewRotationByPolarCoordinates(float var1, float var2);

    public void startViewRotationByPolarCoordinates(float var1, float var2);

    public void stopViewRotationByPolarCoordinates();

    public void setScreenViewport(Rect var1);

    public void setCrossHairsPosition(Point var1);

    public void setStreetViewZoomLevel(float var1);
}

