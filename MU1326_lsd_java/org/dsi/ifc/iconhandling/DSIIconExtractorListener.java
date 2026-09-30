/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.iconhandling;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public interface DSIIconExtractorListener
extends DSIListener {
    public void iconResult(int var1);

    public void resourceIdForTMCEventIcon(ResourceLocator var1);

    public void resourceIdForPOIIcon(ResourceLocator var1);

    public void renderingInformationForRoadIcon(ResourceLocator var1, TextRenderingInfo var2);

    public void resourceIdForTargetIcon(ResourceLocator var1);

    public void resourceIdForRoadClassIcon(ResourceLocator var1);

    public void resourceIdForTrafficRegulationIcon(ResourceLocator var1);

    public void resourceIdForAdditionalIcon(ResourceLocator var1);

    public void renderingInformationForExitIcon(ResourceLocator var1, TextRenderingInfo var2);

    public void resourceIdForCountryIcon(ResourceLocator var1);

    public void resourceIdForTrafficRegulationIconWithSubIndex(ResourceLocator var1);

    public void renderingInformationForExitIconWithVariant(ResourceLocator var1, TextRenderingInfo var2);

    public void setBrandIconStyleResult(int var1);

    public void resourceIdForTrafficSourceIconResult(ResourceLocator var1);

    public void resourceIdForAreaWarningIconResult(ResourceLocator var1);

    public void resourceIdForAdditionalTurnListIconResult(ResourceLocator var1);

    public void resourceIdForComposedPOIIconResult(ResourceLocator var1);

    public void resourceIdForPOIIconFromRawDataResult(ResourceLocator var1);
}

