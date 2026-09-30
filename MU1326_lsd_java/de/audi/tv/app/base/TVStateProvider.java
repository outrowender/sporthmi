/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.tv.ITVStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.storage.TVStorage;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class TVStateProvider {
    private List listeners = new ArrayList(2);
    private boolean startUpMUreceived = false;
    private int tvTunerState = 1;
    private final Object mutex = new Object();
    private int[] sources;
    final TVListener tvListener = new TVListener();
    final ITVEventListener tvStatusListener = new TVStatusListener();
    private final LogChannel log;

    TVStateProvider(LogChannel logChannel, TVStorage tVStorage) {
        int[] nArray;
        this.log = logChannel;
        if (tVStorage.isAvSourceAvailable()) {
            int[] nArray2 = new int[2];
            nArray2[0] = 0;
            nArray = nArray2;
            nArray2[1] = 1;
        } else {
            int[] nArray3 = new int[1];
            nArray = nArray3;
            nArray3[0] = 0;
        }
        this.sources = nArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void addListener(ITVStateListener iTVStateListener) {
        Object object = this.mutex;
        synchronized (object) {
            this.log.log(10000000, "[TVStateProvider.addListener]");
            this.listeners.add(iTVStateListener);
            if (this.startUpMUreceived) {
                this.log.log(10000000, "[TVStateProvider.addListener] sending state, sources: %1, state: %2", (Object)this.sources, (long)this.tvTunerState);
                iTVStateListener.updateState(this.tvTunerState, this.sources);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void removeListener(ITVStateListener iTVStateListener) {
        Object object = this.mutex;
        synchronized (object) {
            this.log.log(10000000, "[TVStateProvider.removeListener]");
            this.listeners.remove(iTVStateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void deinit() {
        Object object = this.mutex;
        synchronized (object) {
            this.startUpMUreceived = false;
            this.log.log(10000000, "[TVStateProvider.signalStop] signal stop, sending sources: %1, state: %2", (Object)this.sources, 1L);
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                ((ITVStateListener)this.listeners.get(i2)).updateState(1, this.sources);
            }
        }
    }

    private void sendUpdate() {
        this.log.log(10000000, "[TVStateProvider.sendUpdate] sending update, sources: %1, state: %2", (Object)this.sources, (long)this.tvTunerState);
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((ITVStateListener)this.listeners.get(i2)).updateState(this.tvTunerState, this.sources);
        }
    }

    static /* synthetic */ int[] access$602(TVStateProvider tVStateProvider, int[] nArray) {
        tVStateProvider.sources = nArray;
        return nArray;
    }

    private class TVListener
    extends DefaultTVListener {
        private TVListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
            Object object = TVStateProvider.this.mutex;
            synchronized (object) {
                if (!TVStateProvider.this.startUpMUreceived) {
                    int[] nArray;
                    TVStateProvider.this.startUpMUreceived = true;
                    if (startUpConfig.avSrcAvail) {
                        int[] nArray2 = new int[2];
                        nArray2[0] = 0;
                        nArray = nArray2;
                        nArray2[1] = 1;
                    } else {
                        int[] nArray3 = new int[1];
                        nArray = nArray3;
                        nArray3[0] = 0;
                    }
                    TVStateProvider.access$602(TVStateProvider.this, nArray);
                    TVStateProvider.this.sendUpdate();
                }
            }
        }
    }

    private class TVStatusListener
    extends TVEventDefaultListener {
        private TVStatusListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onTunerAvailable() {
            Object object = TVStateProvider.this.mutex;
            synchronized (object) {
                TVStateProvider.this.tvTunerState = 0;
                TVStateProvider.this.sendUpdate();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onTunerUnavailable() {
            Object object = TVStateProvider.this.mutex;
            synchronized (object) {
                TVStateProvider.this.tvTunerState = 1;
                TVStateProvider.this.sendUpdate();
            }
        }
    }
}

