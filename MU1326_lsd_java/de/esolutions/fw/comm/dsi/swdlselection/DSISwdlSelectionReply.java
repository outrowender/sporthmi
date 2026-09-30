/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlselection;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.swdlselection.LameClient;

public interface DSISwdlSelectionReply {
    public static final String IPL_COMM_UUID = "fb91eb47-429d-5abb-ab06-b298a7835f6d";
    public static final String IPL_COMM_INTERFACE_KEY = "3f2a3d3c-757b-5e14-88ca-e40491368c8e";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.12";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.12";

    public void updateLameClients(LameClient[] var1, int var2) throws MethodException;

    public void updateEngineering(boolean var1, int var2) throws MethodException;

    public void updateUserSwdl(boolean var1, int var2) throws MethodException;

    public void updateRingNotOK(boolean var1, int var2) throws MethodException;

    public void updateEndDownload(boolean var1, int var2) throws MethodException;

    public void updateAvailableMedia(byte var1, int var2) throws MethodException;

    public void updateUnitType(int var1, int var2) throws MethodException;

    public void getMedia(int[] var1) throws MethodException;

    public void storeNfsIpAddress(String var1) throws MethodException;

    public void storeNfsPath(String var1) throws MethodException;

    public void storeFsPath(String var1) throws MethodException;

    public void setMedium(int var1, String var2, String[] var3) throws MethodException;

    public void setRelease(int var1, String var2) throws MethodException;

    public void getUserDefinedAllowed(boolean var1) throws MethodException;

    public void setTargetLanguage(short var1) throws MethodException;

    public void getIncompatibleDevices(String[] var1, String[] var2) throws MethodException;

    public void startVersionUpload(boolean var1) throws MethodException;

    public void checkConsistency(int var1, boolean var2, String var3, int var4) throws MethodException;

    public void abortSetMedium() throws MethodException;

    public void abortSetRelease() throws MethodException;

    public void getFinalizeTargets(int[] var1) throws MethodException;

    public void setFinalizeTarget(int var1, long var2, long var4, long var6) throws MethodException;

    public void enterComponentUpdateConfirmation() throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

