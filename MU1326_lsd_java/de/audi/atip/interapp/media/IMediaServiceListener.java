/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.MediaSlotInfo;
import java.util.Map;

public interface IMediaServiceListener {
    public int getTerminalID();

    public void sourceAvailable(int var1, boolean var2);

    public void sourceListChanged(Map var1);

    public void updateActiveSource(MediaSlotInfo var1, boolean var2);

    public void updatePlaybackState(int var1);

    public void sourceDeactivated();

    public static class DefaultMediaServiceListener
    implements IMediaServiceListener {
        public int getTerminalID() {
            return 0;
        }

        public void sourceAvailable(int n, boolean bl) {
        }

        public void sourceListChanged(Map map) {
        }

        public void updatePlaybackState(int n) {
        }

        public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
        }

        public void sourceDeactivated() {
        }
    }
}

