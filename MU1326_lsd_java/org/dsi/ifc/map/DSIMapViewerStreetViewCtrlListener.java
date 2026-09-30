/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public interface DSIMapViewerStreetViewCtrlListener
extends DSIListener {
    public void updateStreetViewLoadStatus(int var1, int var2);

    public void updateStreetViewAvailable(boolean var1, int var2);

    public void updateStreetViewZoomListIndex(int var1, int var2);

    public void updateStreetViewZoomList(float[] var1, int var2);

    public void updateStreetViewThumbnails(StreetViewThumbnail[] var1, int var2);

    public void streetViewEnabled(boolean var1);

    public void streetViewVisible(boolean var1);

    public void streetViewFreeze(boolean var1);

    public void updatePosition(NavLocationWgs84 var1, int var2);

    public void updateRotation(int var1, int var2, int var3);

    public void getInfoForPosition(PosInfo[] var1);

    public void snapshotResult(StreetViewThumbnail var1, int var2);

    public void updateScreenViewPort(Rect var1, int var2);

    public void updateStreetViewZoomLevel(float var1, int var2);

    public void updateStreetViewPosition(NavLocationWgs84 var1, boolean var2, int var3);
}

