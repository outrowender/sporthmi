/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.map.Point;

public interface DSIMapViewerRouteBlock
extends DSIBase {
    public static final String VERSION = "2.11.62";
    public static final int ATTR_RBINFOOFSELECTEDSEGMENTS = 1;
    public static final int RT_RBMARKNEXTSEGMENT = 1001;
    public static final int RT_RBMARKPREVIOUSSEGMENT = 1002;
    public static final int RT_RBSETSEGMENTSCALES = 1003;
    public static final int RT_RBSTARTOFSELECTION = 1005;
    public static final int RT_PICKSEGMENTUIDSINSCREENSPACE = 1006;
    public static final int RT_HIGHLIGHTSEGMENTUIDSINMAP = 1007;
    public static final int RP_PICKSEGMENTUIDSINSCREENSPACERESULT = 2000;
    public static final int RP_HIGHLIGHTSEGMENTUIDSINMAPRESULT = 2001;
    public static final int RP_RBSTARTOFSELECTIONRESULT = 2002;
    public static final int RP_RBMARKNEXTSEGMENTRESULT = 2003;
    public static final int RP_RBMARKPREVIOUSSEGMENTRESULT = 2004;

    public void rBMarkNextSegment();

    public void rBMarkPreviousSegment();

    public void rBSetSegmentScales(long var1, long var3);

    public void rBStartOfSelection();

    public void pickSegmentUidsInScreenSpace(Point var1, int var2);

    public void highLightSegmentUidsInMap(long[] var1, boolean var2);
}

