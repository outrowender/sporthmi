/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.iconhandling;

import org.dsi.ifc.base.DSIBase;

public interface DSIIconExtractor
extends DSIBase {
    public static final String VERSION = "2.11.16";
    public static final int ICONSIZE_SMALL = 0;
    public static final int ICONSIZE_MEDIUM = 1;
    public static final int ICONSIZE_LARGE = 2;
    public static final int ICONSIZE_VERY_SMALL = 3;
    public static final int ICONSIZE_VERY_LARGE = 4;
    public static final int ICONRESULT_OK = 0;
    public static final int ICONRESULT_ERROR = 1;
    public static final int TMCICONSUBINDEX_NORMAL = 0;
    public static final int TMCICONSUBINDEX_GRAYED_OUT = 1;
    public static final int TMCICONSUBINDEX_BYPASSED = 2;
    public static final int TMCICONSUBINDEX_BYPASSED_DISAPPEARS = 3;
    public static final int TRAFFICREGULATIONICONSUBINDEX_NORMAL = 0;
    public static final int TRAFFICREGULATIONICONSUBINDEX_GRAYED_OUT = 1;
    public static final int TRAFFICREGULATIONICONSUBINDEX_CROSSED_OUT = 2;
    public static final int BRANDICONSTYLE_ACTUALBRANDICON = 0;
    public static final int BRANDICONSTYLE_GENERIC = 1;
    public static final int RT_RESOURCEIDFORTMCEVENTICON = 1000;
    public static final int RT_RESOURCEIDFORPOIICON = 1001;
    public static final int RT_RENDERINGINFORMATIONFORROADICON = 1002;
    public static final int RT_RESOURCEIDFORTARGETICON = 1003;
    public static final int RT_RESOURCEIDFORROADCLASSICON = 1004;
    public static final int RT_RESOURCEIDFORTRAFFICREGULATIONICON = 1005;
    public static final int RT_RENDERINGINFORMATIONFOREXITICON = 1006;
    public static final int RT_RESOURCEIDFORADDITIONALICON = 1007;
    public static final int RT_RESOURCEIDFORCOUNTRYICON = 1008;
    public static final int RT_RESOURCEIDFORTRAFFICREGULATIONICONWITHSUBINDEX = 1009;
    public static final int RT_RENDERINGINFORMATIONFOREXITICONWITHVARIANT = 1010;
    public static final int RT_SETBRANDICONSTYLE = 1011;
    public static final int RT_RESOURCEIDFORADDITIONALTURNLISTICON = 1021;
    public static final int RT_RESOURCEIDFORTRAFFICSOURCEICON = 1022;
    public static final int RT_RESOURCEIDFORAREAWARNINGICON = 1023;
    public static final int RT_RESOURCEIDFORCOMPOSEDPOIICON = 1024;
    public static final int RT_RESOURCEIDFORPOIICONFROMRAWDATA = 1025;
    public static final int RP_RESOURCEIDFORTMCEVENTICON = 2000;
    public static final int RP_RESOURCEIDFORPOIICON = 2001;
    public static final int RP_RENDERINGINFORMATIONFORROADICON = 2002;
    public static final int RP_RESOURCEIDFORTARGETICON = 2003;
    public static final int RP_RESOURCEIDFORROADCLASSICON = 2004;
    public static final int RP_RESOURCEIDFORTRAFFICREGULATIONICON = 2005;
    public static final int RP_RENDERINGINFORMATIONFOREXITICON = 2006;
    public static final int RP_ICONRESULT = 2007;
    public static final int RP_RESOURCEIDFORADDITIONALICON = 2008;
    public static final int RP_RESOURCEIDFORCOUNTRYICON = 2009;
    public static final int RP_RESOURCEIDFORTRAFFICREGULATIONICONWITHSUBINDEX = 2010;
    public static final int RP_RENDERINGINFORMATIONFOREXITICONWITHVARIANT = 2011;
    public static final int RP_SETBRANDICONSTYLERESULT = 2012;
    public static final int RP_RESOURCEIDFORTRAFFICSOURCEICONRESULT = 2022;
    public static final int RP_RESOURCEIDFORAREAWARNINGICONRESULT = 2023;
    public static final int RP_RESOURCEIDFORADDITIONALTURNLISTICONRESULT = 2024;
    public static final int RP_RESOURCEIDFORCOMPOSEDPOIICONRESULT = 2025;
    public static final int RP_RESOURCEIDFORPOIICONFROMRAWDATARESULT = 2026;

    public void resourceIdForTMCEventIcon(int var1, int var2, int var3);

    public void resourceIdForPOIIcon(int var1, int var2, int var3);

    public void renderingInformationForRoadIcon(int var1, int var2, int var3);

    public void resourceIdForTargetIcon(int var1, int var2);

    public void resourceIdForRoadClassIcon(int var1, int var2, int var3);

    public void resourceIdForTrafficRegulationIcon(int var1, int var2, int var3);

    public void renderingInformationForExitIcon(int var1, int var2, int var3);

    public void resourceIdForAdditionalIcon(int var1, int var2, int var3);

    public void resourceIdForCountryIcon(int var1, int var2);

    public void resourceIdForTrafficRegulationIconWithSubindex(int var1, int var2, int var3, int var4);

    public void renderingInformationForExitIconWithVariant(int var1, int var2, int var3, int var4);

    public void setBrandIconStyle(int[] var1, int var2);

    public void resourceIdForAdditionalTurnListIcon(int var1, int var2, int var3, int var4);

    public void resourceIdForTrafficSourceIcon(int var1, int var2);

    public void resourceIdForAreaWarningIcon(int var1, int var2);

    public void resourceIdForComposedPOIIcon(int var1, int var2, int var3, int[] var4);

    public void resourceIdForPOIIconFromRawData(int var1, int var2, int var3);
}

