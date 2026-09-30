/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swap;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.swap.ConfigInfo;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

public interface DSISWaPReply {
    public static final String IPL_COMM_UUID = "5d89d8f3-07c4-5d00-9db7-32c55c981f43";
    public static final String IPL_COMM_INTERFACE_KEY = "cbe65faa-96b7-5ffd-b8c1-9f9ade45b142";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public void updateSoftwareEnabling(int[] var1, int var2) throws MethodException;

    public void updateIllegalFSCs(int[] var1, int var2) throws MethodException;

    public void updateAreFSCsSigned(boolean var1, int var2) throws MethodException;

    public void updateLimitedLifetime(boolean var1, int var2) throws MethodException;

    public void updateConfigCheck(ConfigInfo var1, int var2) throws MethodException;

    public void updateConfigPrepare(String var1, int var2) throws MethodException;

    public void updateConfigFinalize(ConfigInfo var1, int var2) throws MethodException;

    public void updateFscList(SFscStatus[] var1, int var2) throws MethodException;

    public void encryptFile(String var1, int var2) throws MethodException;

    public void checkSignature(boolean var1, String var2) throws MethodException;

    public void getPublicKey(short[] var1, boolean var2) throws MethodException;

    public void checkSingleFsc(int var1, int var2) throws MethodException;

    public void decryptFile(String var1, int var2) throws MethodException;

    public void getFscDetail(SFscDetails var1) throws MethodException;

    public void importFSCs(int var1, SFscImportStatus var2) throws MethodException;

    public void importFSCsList(int var1, SFscImportStatus[] var2) throws MethodException;

    public void exportCCD(int var1) throws MethodException;

    public void getHistory(SFscHistory var1) throws MethodException;

    public void getHistoryList(SFscHistory[] var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

