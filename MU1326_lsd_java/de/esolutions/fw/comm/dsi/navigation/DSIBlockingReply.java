/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.BlockElement;

public interface DSIBlockingReply {
    public static final String IPL_COMM_UUID = "6afc3000-ee79-58d1-bd7b-c2ed0e0804bd";
    public static final String IPL_COMM_INTERFACE_KEY = "4d4866c8-b77a-58e3-89ce-99092a93d36f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.71";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.71";

    public void updateListOfBlocks(BlockElement[] var1, int var2) throws MethodException;

    public void updateNaviCoreAvailableToSetBlocks(int var1, int var2) throws MethodException;

    public void updateMaximumNumberOfBlockedAreas(int var1, int var2) throws MethodException;

    public void updateMaximumNumberOfBlockedRouteSegments(int var1, int var2) throws MethodException;

    public void updateMaximumNumberOfBlockedRoadSegments(int var1, int var2) throws MethodException;

    public void updateMaximumDimensionsOfBlockedArea(int var1, int var2, int var3) throws MethodException;

    public void updateMaximumSegmentLengthOfBlockedRouteSegment(int var1, int var2) throws MethodException;

    public void updateMaximumLengthOfBlockRouteBasedOnLength(int var1, int var2) throws MethodException;

    public void blockAreaResult(long var1, int var3) throws MethodException;

    public void blockRouteSegmentsResult(long var1, int var3) throws MethodException;

    public void blockRoadSegmentsResult(long var1, int var3) throws MethodException;

    public void blockRouteBasedOnLengthResult(long var1, int var3) throws MethodException;

    public void persistBlockResult(long[] var1, int var2) throws MethodException;

    public void deleteBlockResult(long[] var1, int var2) throws MethodException;

    public void setBlockDescriptionResult(long[] var1, int var2) throws MethodException;

    public void getBoundingRectangleOfBlocksResult(long[] var1, NavRectangle var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

