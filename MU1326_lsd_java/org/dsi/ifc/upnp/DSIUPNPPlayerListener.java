/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.upnp;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.upnp.DeviceInfo;
import org.dsi.ifc.upnp.EntryInfo;
import org.dsi.ifc.upnp.PlaybackMode;

public interface DSIUPNPPlayerListener
extends DSIListener {
    public void updatePlaybackModeList(String var1, PlaybackMode[] var2, int var3);

    public void updatePlaybackMode(String var1, int var2, int var3);

    public void updatePlaybackState(String var1, int var2, int var3);

    public void updatePlayPosition(String var1, String var2, int var3, int var4, int var5);

    public void updateDetailInfo(String var1, EntryInfo var2, ResourceLocator var3, int var4);

    public void updateDeviceList(DeviceInfo[] var1, int var2);

    public void updateVolume(String var1, int var2, int var3);
}

