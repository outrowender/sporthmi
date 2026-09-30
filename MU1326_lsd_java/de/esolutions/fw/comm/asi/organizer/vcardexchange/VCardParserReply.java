/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.organizer.AdbEntry;

public interface VCardParserReply {
    public static final String IPL_COMM_UUID = "c4084aff-df82-4408-b56c-2aef1da8ec7e";
    public static final String IPL_COMM_INTERFACE_KEY = "167912de-3ac1-5a6e-8756-89022777b8bc";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.9";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.7";

    public void parseVCardResult(int var1, AdbEntry var2, int var3, int var4) throws MethodException;

    public void parseVCardDirectoryResult(int var1, AdbEntry[] var2, int var3, int var4) throws MethodException;

    public void exportVCardResult(int var1, String var2, int var3) throws MethodException;

    public void exportSmallVCardResult(int var1, String var2, int var3) throws MethodException;

    public void parsingFinished(int var1) throws MethodException;

    public void exportFinished(int var1, int var2) throws MethodException;

    public void smallExportFinished(int var1, long[] var2, int var3, String var4, int var5) throws MethodException;

    public void setBinaryContentTempPathResult(int var1, String var2) throws MethodException;

    public void setBinaryContentQuotaPerFileResult(int var1, long var2) throws MethodException;
}

