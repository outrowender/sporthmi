/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerZoomEngine
extends DSIBase {
    public static final String VERSION = "2.11.62";
    public static final int ATTR_AUTOZOOMENABLED = 1;
    public static final int ATTR_MANOEUVREZOOMENABLED = 2;
    public static final int ATTR_RECOMMENDEDZOOM = 3;
    public static final int ATTR_ZOOMENGINESTATE = 4;
    public static final int ZOOMENGINESTATE_OFF = 0;
    public static final int ZOOMENGINESTATE_READY = 1;
    public static final int ZOOMENGINESTATE_AUTOZOOM = 2;
    public static final int ZOOMENGINESTATE_MANOEUVREZOOM = 3;
    public static final int ZOOMENGINESTATE_INVALID_ZOOMSTATE = 255;
    public static final int MAPVIEWTYPE_VIEW2D = 0;
    public static final int MAPVIEWTYPE_BIRDVIEW = 1;
    public static final int MAPVIEWTYPE_VIEW3D = 2;
    public static final int RT_AUTOZOOMENABLE = 1000;
    public static final int RT_MANOEUVREZOOMENABLE = 1001;
    public static final int RT_SETVIEWTYPE = 1002;
    public static final int RT_SETZOOMAREA = 1003;
    public static final int RT_SETCARPOSITION = 1004;
    public static final int RT_SETMAPROTATION = 1005;
    public static final int RT_SETMAPORIENTATION = 1006;

    public void autoZoomEnable(boolean var1);

    public void manoeuvreZoomEnable(boolean var1);

    public void setViewType(int var1);

    public void setCarPosition(Point var1);

    public void setMapRotation(short var1);

    public void setMapOrientation(int var1, Point var2);

    public void setZoomArea(Rect var1);
}

