/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.BlockElement;

public interface DSIBlockingListener
extends DSIListener {
    public void updateListOfBlocks(BlockElement[] var1, int var2);

    public void updateNaviCoreAvailableToSetBlocks(int var1, int var2);

    public void updateMaximumNumberOfBlockedAreas(int var1, int var2);

    public void updateMaximumNumberOfBlockedRouteSegments(int var1, int var2);

    public void updateMaximumNumberOfBlockedRoadSegments(int var1, int var2);

    public void updateMaximumDimensionsOfBlockedArea(int var1, int var2, int var3);

    public void updateMaximumSegmentLengthOfBlockedRouteSegment(int var1, int var2);

    public void updateMaximumLengthOfBlockRouteBasedOnLength(int var1, int var2);

    public void blockAreaResult(long var1, int var3);

    public void blockRouteSegmentsResult(long var1, int var3);

    public void blockRoadSegmentsResult(long var1, int var3);

    public void blockRouteBasedOnLengthResult(long var1, int var3);

    public void persistBlockResult(long[] var1, int var2);

    public void deleteBlockResult(long[] var1, int var2);

    public void setBlockDescriptionResult(long[] var1, int var2);

    public void getBoundingRectangleOfBlocksResult(long[] var1, NavRectangle var2);
}

