/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance;

import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncInstanceReply {
    public static final String IPL_COMM_UUID = "33835c21-9cd6-4b66-a078-9209b43a1b61";
    public static final String IPL_COMM_INTERFACE_KEY = "15181a2f-42ba-55da-a0d1-172a25018685";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void responseInstanceId(String var1, String var2, int var3, int var4) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;
}

