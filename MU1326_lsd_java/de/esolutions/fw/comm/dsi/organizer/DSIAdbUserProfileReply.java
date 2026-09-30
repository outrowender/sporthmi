/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.ProfileInfo;

public interface DSIAdbUserProfileReply {
    public static final String IPL_COMM_UUID = "5600e882-32bc-5962-bf4b-6c7c42e96b5b";
    public static final String IPL_COMM_INTERFACE_KEY = "087275ce-30fb-5962-9609-c69d8e3875d9";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.31";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.31";

    public void updateProfileInfo(ProfileInfo[] var1, int var2, int var3) throws MethodException;

    public void updateDeviceConnected(boolean var1, int var2) throws MethodException;

    public void updateDownloadCountSim(DownloadInfo var1, int var2) throws MethodException;

    public void updateDownloadCountMe(DownloadInfo var1, int var2) throws MethodException;

    public void updateDownloadCountOpp(DownloadInfo var1, int var2) throws MethodException;

    public void updateDownloadState(int var1, int var2, int var3) throws MethodException;

    public void newDeviceConnected(String var1) throws MethodException;

    public void downloadToProfileResult(int var1) throws MethodException;

    public void restartDownloadResult(int var1) throws MethodException;

    public void profileDeleted(int var1) throws MethodException;

    public void setProfileNameResult(int var1) throws MethodException;

    public void deleteProfilesResult(int var1) throws MethodException;

    public void commonEntryCountResult(int var1, int var2) throws MethodException;

    public void entryMeterResult(int var1, EntryMeter[] var2) throws MethodException;

    public void setPairingCodeResult(int var1) throws MethodException;

    public void setHomeIdResult(int var1) throws MethodException;

    public void updateDownloadState2ndPhone(int var1, int var2, int var3) throws MethodException;

    public void setSOSButtonResult(int var1) throws MethodException;

    public void updateSOSButton(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

