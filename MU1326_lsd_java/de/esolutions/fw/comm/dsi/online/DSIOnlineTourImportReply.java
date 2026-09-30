/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIOnlineTourImportReply {
    public static final String IPL_COMM_UUID = "426b4e5c-52db-5f92-b26c-ea476cf9735e";
    public static final String IPL_COMM_INTERFACE_KEY = "490703e9-9991-5248-b8c4-930a7edcd612";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public void indicateToursAvailable(int var1) throws MethodException;

    public void responseTourDownload(int var1) throws MethodException;

    public void indicateTourDownloadFinished(int var1, String var2, String var3, int var4) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

