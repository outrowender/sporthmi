/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DownloadInfo;

public interface DSIAdbVCardExchangeReply {
    public static final String IPL_COMM_UUID = "652febaf-81ba-5aba-890b-6fa0da6c390d";
    public static final String IPL_COMM_INTERFACE_KEY = "8eb87df5-6b8c-54e8-9d1e-dbfd4bda2e56";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.31";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.31";

    public void updateExportCount(DownloadInfo var1, int var2) throws MethodException;

    public void updateImportCount(DownloadInfo var1, int var2) throws MethodException;

    public void importVCardResult(int var1, int var2, int var3, int var4) throws MethodException;

    public void exportVCardResult(int var1, int var2, int var3, int var4) throws MethodException;

    public void exportSpellerVCardResult(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void createVCardResult(int var1, long[] var2, int var3, String var4) throws MethodException;

    public void parseVCardResult(int var1, AdbEntry[] var2) throws MethodException;

    public void responseAbort(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

