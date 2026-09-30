/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car;

import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarGenericReply {
    public static final String IPL_COMM_UUID = "4bec9bb4-6e17-4b7b-80ff-a9b336700c76";
    public static final String IPL_COMM_INTERFACE_KEY = "0455eeb3-67d3-5538-a0cf-8ec326f2a00e";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;
}

