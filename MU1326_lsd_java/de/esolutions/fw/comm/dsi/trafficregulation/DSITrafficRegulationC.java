/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.trafficregulation;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSITrafficRegulationC {
    public void setSpeedLimitWarning(boolean var1, boolean var2, int var3) throws MethodException;

    public void requestRoadClassSpeedInfoForCountry(String var1) throws MethodException;

    public void setTrailerStatus(boolean var1) throws MethodException;

    public void setWarningStatus(int var1, boolean var2, boolean var3, int var4) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

