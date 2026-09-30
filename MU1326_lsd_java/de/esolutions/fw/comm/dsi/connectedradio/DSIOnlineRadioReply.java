/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIOnlineRadioReply {
    public static final String IPL_COMM_UUID = "67900ab4-039a-59dd-9141-ca1a0fb8a2bf";
    public static final String IPL_COMM_INTERFACE_KEY = "cda08e84-495a-5b75-83b5-00f0e4603808";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void getRadioStationLogoResult(int var1, int var2, RadioStation var3, int var4) throws MethodException;

    public void getStreamUrlResult(int var1, int var2, RadioStation var3) throws MethodException;

    public void getMetaInformationResult(int var1, int var2, RadioStation var3) throws MethodException;

    public void downloadDatabaseResult(int var1, int var2) throws MethodException;

    public void cancelDownloadDatabaseResult(int var1, int var2) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

