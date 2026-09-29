/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.sds;

import de.audi.tuner.ifc.listener.IUpdateListener;
import java.util.ArrayList;
import java.util.List;

public class UpdateListenerHandler {
    private final List updateListeners = new ArrayList(2);

    public void addUpdateListener(IUpdateListener iUpdateListener) {
        if (iUpdateListener != null) {
            this.informListener(iUpdateListener);
            this.updateListeners.add(iUpdateListener);
        }
    }

    private void informListener(IUpdateListener iUpdateListener) {
        iUpdateListener.updatedMemoryList();
        iUpdateListener.updatedBandList(this.getWavebands());
    }

    protected int[] getWavebands() {
        return new int[0];
    }

    public void propagateUpdatedBandList(int[] nArray) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedBandList(nArray);
        }
    }

    public void propagateUpdatedMemoryList() {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedMemoryList();
        }
    }

    public void propagateUpdatedStationList(int n) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedStationList(n);
        }
    }

    public void propagateUpdatedWaveband(int n) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedWaveband(n);
        }
    }

    public void propagateUpdatedActiveList(int n) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedActiveList(n);
        }
    }

    public void propagateUpdatedActiveStation(int n) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedActiveStation(n);
        }
    }

    public void propagateUpdatedActiveInfoState(int n) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedActiveInfoState(n);
        }
    }

    public void propagateupdatedAnnouncementStatus(int n) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedAnnouncementStatus(n);
        }
    }

    public void propagateupdatedSeekStatus(boolean bl) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedSeekStatus(bl);
        }
    }

    public void propagateupdatedScanStatus(boolean bl) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedScanStatus(bl);
        }
    }

    public void propagateUpdatedForceStationListUpdateStatus(int n, int n2) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedForceStationListUpdateStatus(n, n2);
        }
    }

    public void propagateUpdatedMuteStatus(int n, boolean bl) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedMuteStatus(n, bl);
        }
    }

    private IUpdateListener getUpdateListener(int n) {
        return (IUpdateListener)this.updateListeners.get(n);
    }

    public void propagateUpdatedTAStationName(String string, int n, long l) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            this.getUpdateListener(i2).updatedTAStationName(string, n, l);
        }
    }
}

