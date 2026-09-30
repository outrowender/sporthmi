/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdldeviceinfo;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISwdlDeviceInfoReply {
    public static final String IPL_COMM_UUID = "36a2e2a5-a8cb-5aa2-88da-885af6a1f6b4";
    public static final String IPL_COMM_INTERFACE_KEY = "a9fd0f99-b1dc-5a0b-8ea0-ee8ce728ca21";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.6";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.6";

    public void updateSummaryChanged(String var1, int var2) throws MethodException;

    public void getDevices(String[] var1, int[] var2) throws MethodException;

    public void getModules(int var1, String[] var2, int[] var3, short[] var4) throws MethodException;

    public void getLanguages(int var1, String[] var2, short var3, short var4, short var5) throws MethodException;

    public void getErrors(int var1, int[] var2, short[] var3) throws MethodException;

    public void isDataModule(int var1, int var2, boolean var3) throws MethodException;

    public void isNoExclusiveBoloUpdate(int var1, int var2, boolean var3) throws MethodException;

    public void getVersions(int var1, int var2, long[] var3) throws MethodException;

    public void getTargetVersions(int var1, int var2, long[] var3) throws MethodException;

    public void getAdditionalInfo(int var1, int var2, int[] var3) throws MethodException;

    public void getFileNames(int var1, int var2, String[] var3) throws MethodException;

    public void getFileDetails(int var1, int var2, int var3, long var4, long var6, long var8, boolean var10, boolean var11, String var12, String var13) throws MethodException;

    public void getInfoFilePath(int var1, String var2, String var3) throws MethodException;

    public void getNumberOfPopups(int var1) throws MethodException;

    public void getPopup(int var1, int var2, String var3, int var4, int var5, int var6, String var7) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

