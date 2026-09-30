/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.RouteBrowserInfo;

public interface DSIMapViewerRouteBlockListener
extends DSIListener {
    public void updateRBInfoOfSelectedSegments(RouteBrowserInfo var1, int var2);

    public void pickSegmentUidsInScreenSpaceResult(Point var1, int var2, long[] var3, int var4);

    public void highLightSegmentUidsInMapResult(long[] var1, boolean var2, int var3);

    public void rBStartOfSelectionResult(long var1, int var3);

    public void rBMarkNextSegmentResult(long var1, int var3);

    public void rBMarkPreviousSegmentResult(long var1, int var3);
}

