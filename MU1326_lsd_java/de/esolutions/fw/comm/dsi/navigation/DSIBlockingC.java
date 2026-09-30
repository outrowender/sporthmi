/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public interface DSIBlockingC {
    public void blockArea(NavLocationWgs84 var1, NavLocationWgs84 var2) throws MethodException;

    public void blockRouteSegments(long var1, long var3) throws MethodException;

    public void blockRoadSegments(NavLocation var1) throws MethodException;

    public void blockRouteBasedOnLength(int var1, int var2) throws MethodException;

    public void persistBlock(long[] var1) throws MethodException;

    public void deleteBlock(long[] var1) throws MethodException;

    public void setBlockDescription(long[] var1, String var2) throws MethodException;

    public void getBoundingRectangleOfBlocks(long[] var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

