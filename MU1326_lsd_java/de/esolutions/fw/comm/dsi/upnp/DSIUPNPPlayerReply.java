/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.upnp.DeviceInfo;
import org.dsi.ifc.upnp.EntryInfo;
import org.dsi.ifc.upnp.PlaybackMode;

public interface DSIUPNPPlayerReply {
    public static final String IPL_COMM_UUID = "b2460ea2-323f-538a-8290-4872acffc102";
    public static final String IPL_COMM_INTERFACE_KEY = "d60ab136-6c8a-5316-86b9-edfdbaa8b238";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void updatePlaybackModeList(String var1, PlaybackMode[] var2, int var3) throws MethodException;

    public void updatePlaybackMode(String var1, int var2, int var3) throws MethodException;

    public void updatePlaybackState(String var1, int var2, int var3) throws MethodException;

    public void updatePlayPosition(String var1, String var2, int var3, int var4, int var5) throws MethodException;

    public void updateDetailInfo(String var1, EntryInfo var2, ResourceLocator var3, int var4) throws MethodException;

    public void updateDeviceList(DeviceInfo[] var1, int var2) throws MethodException;

    public void updateVolume(String var1, int var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

