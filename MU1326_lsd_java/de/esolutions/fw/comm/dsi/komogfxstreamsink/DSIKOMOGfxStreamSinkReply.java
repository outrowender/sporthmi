/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komogfxstreamsink;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIKOMOGfxStreamSinkReply {
    public static final String IPL_COMM_UUID = "6e1558ae-4cd5-5414-9ab7-734ff9d5d567";
    public static final String IPL_COMM_INTERFACE_KEY = "343602ed-cdc1-5b2a-9bc2-3d899ca8180e";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void updateGfxState(int var1, int var2) throws MethodException;

    public void updateRequestSync(int var1, int var2) throws MethodException;

    public void updateDataRate(int var1, int var2) throws MethodException;

    public void setFGLayerResult(int var1) throws MethodException;

    public void fadeInResult() throws MethodException;

    public void fadeOutResult() throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

