/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komonavinfo;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIKOMONavInfoReply {
    public static final String IPL_COMM_UUID = "65a2a4f0-a422-567d-8fee-74f7e2b92299";
    public static final String IPL_COMM_INTERFACE_KEY = "7cb05421-362d-5bf6-9822-c67715a04a9b";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.10";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.10";

    public void setCurrentStreetResult(int var1) throws MethodException;

    public void setTurnToStreetResult(int var1) throws MethodException;

    public void setCityNameResult(int var1) throws MethodException;

    public void setSemiDynRouteResult(int var1) throws MethodException;

    public void setTrafficOffsetResult(int var1) throws MethodException;

    public void setRgSelectResult(int var1) throws MethodException;

    public void setCapabilitiesResult(int var1) throws MethodException;

    public void setMapScaleResult(int var1, int var2, boolean[] var3, int var4, int var5, boolean[] var6, boolean var7) throws MethodException;

    public void setMapScale(int var1, int var2, boolean[] var3, int var4, int var5, int var6) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

