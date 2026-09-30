/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAdbSdsReply {
    public static final String IPL_COMM_UUID = "d52e8b7b-22d1-582c-a00a-2d5a5a40ce7c";
    public static final String IPL_COMM_INTERFACE_KEY = "803e4a60-f8b0-5229-839b-b430e08ede41";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.31";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.31";

    public void getAllVoiceTagsResult(int var1, int[] var2) throws MethodException;

    public void deleteVoiceTagsResult(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

