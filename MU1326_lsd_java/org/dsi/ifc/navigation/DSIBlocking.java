/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public interface DSIBlocking
extends DSIBase {
    public static final String VERSION = "2.11.71";
    public static final int ATTR_NAVICOREAVAILABLETOSETBLOCKS = 1;
    public static final int ATTR_LISTOFBLOCKS = 2;
    public static final int ATTR_MAXIMUMNUMBEROFBLOCKEDAREAS = 3;
    public static final int ATTR_MAXIMUMNUMBEROFBLOCKEDROUTESEGMENTS = 4;
    public static final int ATTR_MAXIMUMNUMBEROFBLOCKEDROADSEGMENTS = 5;
    public static final int ATTR_MAXIMUMDIMENSIONSOFBLOCKEDAREA = 6;
    public static final int ATTR_MAXIMUMSEGMENTLENGTHOFBLOCKEDROUTESEGMENT = 7;
    public static final int ATTR_MAXIMUMLENGTHOFBLOCKROUTEBASEDONLENGTH = 8;
    public static final int BLOCKREQUESTRESULTCODE_OK = 0;
    public static final int BLOCKREQUESTRESULTCODE_FAILED = 1;
    public static final int BLOCKREQUESTRESULTCODE_FAILEDOUTOFMEMORY = 2;
    public static final int BLOCKINGELEMENTTYPE_RECTANGULARAREA = 0;
    public static final int BLOCKINGELEMENTTYPE_ROUTE_SEGMENT = 1;
    public static final int BLOCKINGELEMENTTYPE_ROAD_SEGMENT = 2;
    public static final int BLOCKINGELEMENTTYPE_ROUTEBASESONLENGTH = 3;
    public static final int NAVICOREAVAILABLETOSETBLOCKS_READYTOBLOCK = 0;
    public static final int NAVICOREAVAILABLETOSETBLOCKS_BUSY = 1;
    public static final int RT_BLOCKAREA = 1000;
    public static final int RT_BLOCKROUTESEGMENTS = 1001;
    public static final int RT_BLOCKROADSEGMENTS = 1002;
    public static final int RT_BLOCKROUTEBASEDONLENGTH = 1003;
    public static final int RT_PERSISTBLOCK = 1004;
    public static final int RT_DELETEBLOCK = 1005;
    public static final int RT_SETBLOCKDESCRIPTION = 1006;
    public static final int RT_GETBOUNDINGRECTANGLEOFBLOCKS = 1007;
    public static final int RP_BLOCKAREARESULT = 2000;
    public static final int RP_BLOCKROUTESEGMENTSRESULT = 2001;
    public static final int RP_BLOCKROADSEGMENTSRESULT = 2002;
    public static final int RP_BLOCKROUTEBASEDONLENGTHRESULT = 2003;
    public static final int RP_PERSISTBLOCKRESULT = 2004;
    public static final int RP_DELETEBLOCKRESULT = 2005;
    public static final int RP_SETBLOCKDESCRIPTIONRESULT = 2006;
    public static final int RP_GETBOUNDINGRECTANGLEOFBLOCKSRESULT = 2007;

    public void blockArea(NavLocationWgs84 var1, NavLocationWgs84 var2);

    public void blockRouteSegments(long var1, long var3);

    public void blockRoadSegments(NavLocation var1);

    public void blockRouteBasedOnLength(int var1, int var2);

    public void persistBlock(long[] var1);

    public void deleteBlock(long[] var1);

    public void setBlockDescription(long[] var1, String var2);

    public void getBoundingRectangleOfBlocks(long[] var1);
}

