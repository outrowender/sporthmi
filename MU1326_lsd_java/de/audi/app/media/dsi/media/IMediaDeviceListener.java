/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public interface IMediaDeviceListener {
    public void updateDeviceList(DeviceInfo[] var1);

    public void updateMediaList(MediaInfo[] var1);
}

