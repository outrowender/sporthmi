/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlselection;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISwdlSelectionC {
    public void setUserSwdl(boolean var1) throws MethodException;

    public void setGotFocus(boolean var1) throws MethodException;

    public void getMedia() throws MethodException;

    public void storeNfsIpAddress(String var1) throws MethodException;

    public void storeNfsPath(String var1) throws MethodException;

    public void setMedium(int var1) throws MethodException;

    public void setRelease(long var1) throws MethodException;

    public void getUserDefinedAllowed() throws MethodException;

    public void setInstallationType(boolean var1) throws MethodException;

    public void setTargetLanguage(short var1) throws MethodException;

    public void getIncompatibleDevices() throws MethodException;

    public void startDownload() throws MethodException;

    public void createCriticalUnlock() throws MethodException;

    public void startVersionUpload() throws MethodException;

    public void abortVersionUpload() throws MethodException;

    public void endVersionUpload() throws MethodException;

    public void storeCifsServer(String var1) throws MethodException;

    public void storeCifsPath(String var1) throws MethodException;

    public void storeCifsUser(String var1) throws MethodException;

    public void storeCifsPassword(String var1) throws MethodException;

    public void storeFsPath(String var1) throws MethodException;

    public void checkConsistency() throws MethodException;

    public void abortSetMedium() throws MethodException;

    public void abortSetRelease() throws MethodException;

    public void getFinalizeTargets() throws MethodException;

    public void setFinalizeTarget(int var1) throws MethodException;

    public void enterComponentUpdateConfirmation(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

