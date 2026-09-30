/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.predictivenavigation;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public interface DSIPredictiveNavigationReply {
    public static final String IPL_COMM_UUID = "858fb3eb-f9f4-5578-a0e6-68c88d2c9881";
    public static final String IPL_COMM_INTERFACE_KEY = "430e0b9d-dec1-5286-bf8c-d0b07c687172";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.3";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.3";

    public void updateOperationMode(int var1, int var2) throws MethodException;

    public void updateLikelyDestinations(LikelyDestination[] var1, int var2) throws MethodException;

    public void updateMaxPredictions(int var1, int var2) throws MethodException;

    public void clearCacheResult() throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

