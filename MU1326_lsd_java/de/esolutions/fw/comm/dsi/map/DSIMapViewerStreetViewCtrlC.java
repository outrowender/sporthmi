/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public interface DSIMapViewerStreetViewCtrlC {
    public void streetViewEnabled(boolean var1) throws MethodException;

    public void streetViewVisible(boolean var1) throws MethodException;

    public void streetViewFreeze(boolean var1) throws MethodException;

    public void goToView() throws MethodException;

    public void setStreetViewZoomIndex(int var1) throws MethodException;

    public void streetViewThumbnails(StreetViewThumbnail[] var1) throws MethodException;

    public void loadStreetView(boolean var1) throws MethodException;

    public void rotateView(short var1, short var2) throws MethodException;

    public void rotateViewByPolarCoordinates(int var1, int var2) throws MethodException;

    public void setAzimuth(int var1) throws MethodException;

    public void setInclination(int var1) throws MethodException;

    public void getInfoForScreenPosition(short var1, short var2) throws MethodException;

    public void setPosition(NavLocationWgs84 var1) throws MethodException;

    public void setCrossHairsVisibility(boolean var1) throws MethodException;

    public void setDayNightView(boolean var1) throws MethodException;

    public void snapshot() throws MethodException;

    public void setViewRotationByPolarCoordinates(float var1, float var2) throws MethodException;

    public void startViewRotationByPolarCoordinates(float var1, float var2) throws MethodException;

    public void stopViewRotationByPolarCoordinates() throws MethodException;

    public void setScreenViewport(Rect var1) throws MethodException;

    public void setCrossHairsPosition(Point var1) throws MethodException;

    public void setStreetViewZoomLevel(float var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

