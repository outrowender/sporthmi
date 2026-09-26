/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaServiceListener;
import de.audi.atip.interapp.media.MediaSlotInfo;
import java.util.Map;

public class IMediaServiceListener$DefaultMediaServiceListener
implements IMediaServiceListener {
    @Override
    public int getTerminalID() {
        return 0;
    }

    @Override
    public void sourceAvailable(int n, boolean bl) {
    }

    @Override
    public void sourceListChanged(Map map) {
    }

    @Override
    public void updatePlaybackState(int n) {
    }

    @Override
    public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
    }

    @Override
    public void sourceDeactivated() {
    }
}

