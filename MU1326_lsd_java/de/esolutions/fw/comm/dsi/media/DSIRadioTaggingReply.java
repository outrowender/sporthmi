/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIRadioTaggingReply {
    public static final String IPL_COMM_UUID = "e7a79385-c2e2-59e6-8480-d08d3c150175";
    public static final String IPL_COMM_INTERFACE_KEY = "435a193d-31a2-5c0b-ad87-6a10d4b15544";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public void tagResult(int var1) throws MethodException;

    public void updateCompatibleDevAvail(int var1, int var2) throws MethodException;

    public void groupTagsResult(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

