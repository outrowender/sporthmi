/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMobileEquipmentTopologyReply {
    public static final String IPL_COMM_UUID = "feeabe13-beb4-557e-896d-8930e0c0a11f";
    public static final String IPL_COMM_INTERFACE_KEY = "32209517-73f4-5519-832e-1d0884f7b94b";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.9";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.9";

    public void responseChangeTopology(int var1) throws MethodException;

    public void updateTopology(int[] var1, int var2) throws MethodException;

    public void updateUsage(int[] var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

