/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.map.Point;

public interface DSIMapViewerRouteBlockC {
    public void rBMarkNextSegment() throws MethodException;

    public void rBMarkPreviousSegment() throws MethodException;

    public void rBSetSegmentScales(long var1, long var3) throws MethodException;

    public void rBStartOfSelection() throws MethodException;

    public void pickSegmentUidsInScreenSpace(Point var1, int var2) throws MethodException;

    public void highLightSegmentUidsInMap(long[] var1, boolean var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

