/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navfleetservices;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSINavFleetServicesReply {
    public static final String IPL_COMM_UUID = "e2564039-c9a4-5e5b-ab31-a7a4c6b9b02a";
    public static final String IPL_COMM_INTERFACE_KEY = "2a330eab-ac67-5335-971f-efda96983bd9";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public void setVZOTrackerStateResult(int var1) throws MethodException;

    public void setVZODownloadStateResult(int var1) throws MethodException;

    public void setLGITrackerStateResult(int var1) throws MethodException;

    public void setLGIDownloadStateResult(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

