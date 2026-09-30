/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic;

import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncGenericReply {
    public static final String IPL_COMM_UUID = "8194babf-6beb-418f-bd90-f74b3c21802b";
    public static final String IPL_COMM_INTERFACE_KEY = "a72d3c71-2310-5bc0-8a73-f82f260b9d4e";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void sendDataFromUnit(GenericPacket var1) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;
}

