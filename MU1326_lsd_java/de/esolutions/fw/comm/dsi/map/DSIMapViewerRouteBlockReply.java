/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.RouteBrowserInfo;

public interface DSIMapViewerRouteBlockReply {
    public static final String IPL_COMM_UUID = "e35a4736-beb5-5ae2-b7ef-1987f635d39c";
    public static final String IPL_COMM_INTERFACE_KEY = "6ffac28d-c4f7-5a0f-abce-6daaf18ea937";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.62";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.62";

    public void updateRBInfoOfSelectedSegments(RouteBrowserInfo var1, int var2) throws MethodException;

    public void pickSegmentUidsInScreenSpaceResult(Point var1, int var2, long[] var3, int var4) throws MethodException;

    public void highLightSegmentUidsInMapResult(long[] var1, boolean var2, int var3) throws MethodException;

    public void rBStartOfSelectionResult(long var1, int var3) throws MethodException;

    public void rBMarkNextSegmentResult(long var1, int var3) throws MethodException;

    public void rBMarkPreviousSegmentResult(long var1, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

