/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.MediaSlotInfo;
import java.util.Map;

public interface IMediaServiceListener {
    default public int getTerminalID() {
    }

    default public void sourceAvailable(int n, boolean bl) {
    }

    default public void sourceListChanged(Map map) {
    }

    default public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
    }

    default public void updatePlaybackState(int n) {
    }

    default public void sourceDeactivated() {
    }
}

