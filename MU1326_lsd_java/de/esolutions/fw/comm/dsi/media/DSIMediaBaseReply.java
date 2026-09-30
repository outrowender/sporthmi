/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public interface DSIMediaBaseReply {
    public static final String IPL_COMM_UUID = "b113ffff-bd42-5cac-8697-cfd388045c9c";
    public static final String IPL_COMM_INTERFACE_KEY = "cb67bc81-5b36-5b17-867c-324a01f573a3";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public void updateParentalML(int var1, int var2) throws MethodException;

    public void updatePreferredLanguage(String var1, int var2) throws MethodException;

    public void updateMediaList(MediaInfo[] var1, int var2) throws MethodException;

    public void updateDeviceList(DeviceInfo[] var1, int var2) throws MethodException;

    public void updateCustomerUpdate(int var1, int var2) throws MethodException;

    public void updateApplicationVersion(String var1, int var2) throws MethodException;

    public void updateMetadataDBVersion(String var1, int var2) throws MethodException;

    public void responseResetFactorySettings(int var1, boolean var2) throws MethodException;

    public void launchAppResult(long var1, long var3, String var5, boolean var6) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

