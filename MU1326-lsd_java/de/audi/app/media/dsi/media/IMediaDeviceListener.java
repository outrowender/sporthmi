/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public interface IMediaDeviceListener {
    default public void updateDeviceList(DeviceInfo[] deviceInfoArray) {
    }

    default public void updateMediaList(MediaInfo[] mediaInfoArray) {
    }
}

