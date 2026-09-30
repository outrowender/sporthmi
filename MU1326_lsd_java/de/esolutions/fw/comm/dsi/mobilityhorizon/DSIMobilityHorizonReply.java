/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public interface DSIMobilityHorizonReply {
    public static final String IPL_COMM_UUID = "7d847e9a-3c9b-5a2c-b62d-7f65852518ec";
    public static final String IPL_COMM_INTERFACE_KEY = "b0185ce3-3de1-549a-8790-709b4294a359";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.8";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.8";

    public void updateLocations(MobilityHorizonLocation[] var1, int var2) throws MethodException;

    public void updateConsideredLocationTypes(int[] var1, int var2) throws MethodException;

    public void updateDriveTrainMode(int var1, int var2) throws MethodException;

    public void updateMobilityHorizonStatus(int var1, int var2) throws MethodException;

    public void requestLocationRangeLevelResult(int var1, int var2) throws MethodException;

    public void locationRangeLevelChanged(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

