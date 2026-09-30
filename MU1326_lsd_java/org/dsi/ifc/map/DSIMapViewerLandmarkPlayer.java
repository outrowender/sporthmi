/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.map.Point;

public interface DSIMapViewerLandmarkPlayer
extends DSIBase {
    public static final String VERSION = "2.11.62";
    public static final int RT_HIDELANDMARK = 1000;
    public static final int RT_SHOWLANDMARK = 1001;
    public static final int RP_SHOWLANDMARK = 2000;

    public void hideLandmark();

    public void showLandmark(Point var1, long var2);
}

