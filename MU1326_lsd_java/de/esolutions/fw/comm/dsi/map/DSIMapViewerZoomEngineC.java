/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerZoomEngineC {
    public void autoZoomEnable(boolean var1) throws MethodException;

    public void manoeuvreZoomEnable(boolean var1) throws MethodException;

    public void setViewType(int var1) throws MethodException;

    public void setCarPosition(Point var1) throws MethodException;

    public void setMapRotation(short var1) throws MethodException;

    public void setMapOrientation(int var1, Point var2) throws MethodException;

    public void setZoomArea(Rect var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

