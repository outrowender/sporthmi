/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public interface DSIMobilityHorizonC {
    public void setConsumptionInfo(ConsumptionInfo[] var1) throws MethodException;

    public void setLocations(MobilityHorizonLocation[] var1) throws MethodException;

    public void setConsideredLocationTypes(int[] var1) throws MethodException;

    public void setDriveTrainMode(int var1) throws MethodException;

    public void requestLocationRangeLevel(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

