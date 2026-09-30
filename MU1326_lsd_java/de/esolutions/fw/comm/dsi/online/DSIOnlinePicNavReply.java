/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.online.PicNavSyncInfo;

public interface DSIOnlinePicNavReply {
    public static final String IPL_COMM_UUID = "62427d00-ba7b-5a5e-9d31-35938979b03c";
    public static final String IPL_COMM_INTERFACE_KEY = "8e99220c-4b18-5840-99fe-b790acdd6ba0";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public void updateSyncStatus(int var1, int var2) throws MethodException;

    public void synchronizeResult(int var1, PicNavSyncInfo var2) throws MethodException;

    public void getPendingTransactionsResult(int var1, PicNavSyncInfo var2) throws MethodException;

    public void setActiveProfileResult(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

