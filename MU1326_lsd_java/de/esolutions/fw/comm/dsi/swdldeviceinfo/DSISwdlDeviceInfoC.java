/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdldeviceinfo;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISwdlDeviceInfoC {
    public void setAccessType(int var1) throws MethodException;

    public void getDevices() throws MethodException;

    public void getModules(int var1) throws MethodException;

    public void getLanguages(int var1) throws MethodException;

    public void getErrors(int var1) throws MethodException;

    public void isDataModule(int var1, int var2) throws MethodException;

    public void isNoExclusiveBoloUpdate(int var1, int var2) throws MethodException;

    public void getVersions(int var1, int var2) throws MethodException;

    public void getTargetVersions(int var1, int var2) throws MethodException;

    public void getAdditionalInfo(int var1, int var2) throws MethodException;

    public void toggleSelection(int var1, int var2, short var3) throws MethodException;

    public void getFileNames(int var1, int var2) throws MethodException;

    public void getFileDetails(int var1, int var2, short var3) throws MethodException;

    public void getInfoFilePath(int var1) throws MethodException;

    public void setDeviceSelection(int var1, int var2) throws MethodException;

    public void getNumberOfPopups() throws MethodException;

    public void getPopup(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

