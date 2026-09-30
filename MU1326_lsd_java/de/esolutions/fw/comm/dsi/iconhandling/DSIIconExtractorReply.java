/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.iconhandling;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public interface DSIIconExtractorReply {
    public static final String IPL_COMM_UUID = "cd212167-6def-5492-89f4-3fedb1cba37a";
    public static final String IPL_COMM_INTERFACE_KEY = "8f98c5a2-05bd-5f72-8f61-3f1d310579e0";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.16";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.16";

    public void iconResult(int var1) throws MethodException;

    public void resourceIdForTMCEventIcon(ResourceLocator var1) throws MethodException;

    public void resourceIdForPOIIcon(ResourceLocator var1) throws MethodException;

    public void renderingInformationForRoadIcon(ResourceLocator var1, TextRenderingInfo var2) throws MethodException;

    public void resourceIdForTargetIcon(ResourceLocator var1) throws MethodException;

    public void resourceIdForRoadClassIcon(ResourceLocator var1) throws MethodException;

    public void resourceIdForTrafficRegulationIcon(ResourceLocator var1) throws MethodException;

    public void resourceIdForAdditionalIcon(ResourceLocator var1) throws MethodException;

    public void renderingInformationForExitIcon(ResourceLocator var1, TextRenderingInfo var2) throws MethodException;

    public void resourceIdForCountryIcon(ResourceLocator var1) throws MethodException;

    public void resourceIdForTrafficRegulationIconWithSubIndex(ResourceLocator var1) throws MethodException;

    public void renderingInformationForExitIconWithVariant(ResourceLocator var1, TextRenderingInfo var2) throws MethodException;

    public void setBrandIconStyleResult(int var1) throws MethodException;

    public void resourceIdForTrafficSourceIconResult(ResourceLocator var1) throws MethodException;

    public void resourceIdForAreaWarningIconResult(ResourceLocator var1) throws MethodException;

    public void resourceIdForAdditionalTurnListIconResult(ResourceLocator var1) throws MethodException;

    public void resourceIdForComposedPOIIconResult(ResourceLocator var1) throws MethodException;

    public void resourceIdForPOIIconFromRawDataResult(ResourceLocator var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

