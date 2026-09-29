/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.manager.IConnectivityManager;
import de.audi.atip.interapp.media.IMediaServiceListener;
import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.atip.log.LogChannel;
import java.util.LinkedList;
import java.util.Map;

class CoMaMediaServiceListener
implements IMediaServiceListener {
    private final LogChannel log;
    private final IConnectivityManager connectivityManager;
    private String name;

    public CoMaMediaServiceListener(LogChannel logChannel, IConnectivityManager iConnectivityManager) {
        this.log = logChannel;
        this.connectivityManager = iConnectivityManager;
    }

    @Override
    public int getTerminalID() {
        return 0;
    }

    @Override
    public void sourceAvailable(int n, boolean bl) {
        this.log.log(1078071040, "CoMaMediaServiceListener#sourceAvailable(): sourceID: %1 available: %2", (Object)String.valueOf(n), (Object)String.valueOf(bl));
    }

    @Override
    public void sourceListChanged(Map map) {
        this.log.log(1078071040, "CoMaMediaServiceListener#sourceListChanged(): %1", (Object)map);
        Object object = map.get(new Integer(12));
        if (object == null || !(object instanceof LinkedList)) {
            this.log.log(-1601830656, "CoMaMediaServiceListener#sourceListChanged(): IMediaServiceListener sends invalid sourceList content");
            return;
        }
        LinkedList linkedList = (LinkedList)object;
        String string = null;
        if (!linkedList.isEmpty()) {
            MediaSlotInfo mediaSlotInfo = (MediaSlotInfo)linkedList.getFirst();
            string = mediaSlotInfo.getName();
        }
        if (CoMaMediaServiceListener.isDifferentStrings(string, this.name)) {
            this.name = string;
            this.connectivityManager.updateUPnPState(string);
            this.log.log(1078071040, "CoMaMediaServiceListener#sourceListChanged(): UPnP name: %1", (Object)string);
        }
    }

    private static final boolean isDifferentStrings(String string, String string2) {
        if (string == null) {
            return string2 != null;
        }
        return !string.equals(string2);
    }

    @Override
    public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
        if (mediaSlotInfo != null && mediaSlotInfo.getSourceType() == 11) {
            this.connectivityManager.updateActiveMediaDevice(1, mediaSlotInfo.getName());
        } else {
            this.log.log(-2137614336, "CoMaMediaServiceListener#updateActiveSource(): Source is no Bluetooth device.");
        }
    }

    @Override
    public void sourceDeactivated() {
    }

    @Override
    public void updatePlaybackState(int n) {
    }
}

