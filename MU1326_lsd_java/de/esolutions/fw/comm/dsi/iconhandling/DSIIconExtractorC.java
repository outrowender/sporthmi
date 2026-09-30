/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.iconhandling;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIIconExtractorC {
    public void resourceIdForTMCEventIcon(int var1, int var2, int var3) throws MethodException;

    public void resourceIdForPOIIcon(int var1, int var2, int var3) throws MethodException;

    public void renderingInformationForRoadIcon(int var1, int var2, int var3) throws MethodException;

    public void resourceIdForTargetIcon(int var1, int var2) throws MethodException;

    public void resourceIdForRoadClassIcon(int var1, int var2, int var3) throws MethodException;

    public void resourceIdForTrafficRegulationIcon(int var1, int var2, int var3) throws MethodException;

    public void renderingInformationForExitIcon(int var1, int var2, int var3) throws MethodException;

    public void resourceIdForAdditionalIcon(int var1, int var2, int var3) throws MethodException;

    public void resourceIdForCountryIcon(int var1, int var2) throws MethodException;

    public void resourceIdForTrafficRegulationIconWithSubindex(int var1, int var2, int var3, int var4) throws MethodException;

    public void renderingInformationForExitIconWithVariant(int var1, int var2, int var3, int var4) throws MethodException;

    public void setBrandIconStyle(int[] var1, int var2) throws MethodException;

    public void resourceIdForAdditionalTurnListIcon(int var1, int var2, int var3, int var4) throws MethodException;

    public void resourceIdForTrafficSourceIcon(int var1, int var2) throws MethodException;

    public void resourceIdForAreaWarningIcon(int var1, int var2) throws MethodException;

    public void resourceIdForComposedPOIIcon(int var1, int var2, int var3, int[] var4) throws MethodException;

    public void resourceIdForPOIIconFromRawData(int var1, int var2, int var3) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

