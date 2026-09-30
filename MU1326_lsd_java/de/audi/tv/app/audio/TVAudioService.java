/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.base.TVEventDefaultListener;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.tvtuner.ProgramInfo;

public class TVAudioService
implements HMIAudioServiceListener {
    private HMIAudioService service;
    private final LogChannel lc;
    private final HMIAudioServiceListener ewsPlayer;
    public final TVEventListener eventListener = new TVEventListener();
    public final IAudioListener smAudioService = new AudioConnectionService();
    private static final int CHILD_LOCK_MUTE_CONNECTION = 141;
    private static final int CONNECTION_REQUESTED = 0;
    private static final int CONNECTION_STOPPED = 1;
    private static final int CONNECTION_STARTED = 2;
    private static final int CONNECTION_PAUSED = 3;
    private static final int CONNECTION_FADEDIN = 4;
    private static final int CONNECTION_FADINGIN = 5;
    private volatile boolean stationTuned = false;
    private volatile int connectionState = 1;
    private volatile int sdisConnectionState = 1;
    private boolean hasMuAudioFocus = false;
    private boolean hasSdisAudioFocus = false;
    private volatile boolean audioManagerAvailable = false;
    private boolean demuteOnGetMUAudioFocus = false;
    private final ArrayList childAudioServiceListeners = new ArrayList(0);

    public TVAudioService(LogChannel logChannel, HMIAudioServiceListener hMIAudioServiceListener) {
        this.lc = logChannel;
        this.service = new NullHMIAudioService(logChannel);
        this.ewsPlayer = hMIAudioServiceListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setService(HMIAudioService hMIAudioService) {
        this.service = hMIAudioService;
        TVAudioService tVAudioService = this;
        synchronized (tVAudioService) {
            if (this.connectionState == 0) {
                hMIAudioService.requestConnection(27, 0);
            }
            if (this.sdisConnectionState == 0) {
                hMIAudioService.requestConnection(307, 3);
            }
            if (this.connectionState == 0 || this.sdisConnectionState == 0) {
                this.lc.log(10000000, "[TVAudioService.requestConnection] connection: %1", 27L);
            }
        }
    }

    public void addChildAudioServiceListener(HMIAudioServiceListener hMIAudioServiceListener) {
        this.childAudioServiceListeners.add(hMIAudioServiceListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void requestConnection(int n, int n2) {
        this.lc.log(10000000, "[TVAudioService.requestConnection] connection: %1", (long)n);
        this.service.requestConnection(n, n2);
        TVAudioService tVAudioService = this;
        synchronized (tVAudioService) {
            this.setConnectionState(n, 0);
        }
    }

    private void releaseConnection(int n, int n2) {
        this.lc.log(10000000, "[TVAudioService.releaseConnection] connection: %1", (long)n);
        this.service.releaseConnection(n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAMAvailable(boolean bl) {
        Object object;
        this.lc.log(10000000, "[TVAudioService.updateAMAvailable]");
        this.audioManagerAvailable = bl;
        if (bl) {
            object = this;
            synchronized (object) {
                if (this.connectionState != 1) {
                    this.connectionState = 1;
                    this.requestConnection(27, 0);
                }
                if (this.sdisConnectionState != 1) {
                    this.sdisConnectionState = 1;
                    this.requestConnection(307, 3);
                }
            }
        }
        object = this.childAudioServiceListeners.iterator();
        while (object.hasNext()) {
            ((HMIAudioServiceListener)object.next()).updateAMAvailable(bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stopConnection(int n, int n2) {
        Object object;
        if (n == 27 || n == 307) {
            this.lc.log(10000000, "[TVAudioService.stopConnection] connection: %1", (long)n);
            object = this;
            synchronized (object) {
                this.setConnectionState(n, 1);
            }
        } else {
            this.ewsPlayer.stopConnection(n, n2);
        }
        object = this.childAudioServiceListeners.iterator();
        while (object.hasNext()) {
            ((HMIAudioServiceListener)object.next()).stopConnection(n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void pauseConnection(int n, int n2) {
        Object object;
        if (n == 27 || n == 307) {
            this.lc.log(10000000, "[TVAudioService.pauseConnection] connection: %1", (long)n);
            object = this;
            synchronized (object) {
                this.setConnectionState(n, 3);
            }
        } else {
            this.ewsPlayer.pauseConnection(n, n2);
        }
        object = this.childAudioServiceListeners.iterator();
        while (object.hasNext()) {
            ((HMIAudioServiceListener)object.next()).pauseConnection(n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void startConnection(int n, int n2) {
        Object object;
        if (n == 27 || n == 307) {
            this.lc.log(10000000, "[TVAudioService.startConnection] connection: %1", (long)n);
            object = this;
            synchronized (object) {
                this.setConnectionState(n, 2);
            }
            this.fadeToConnection(n, n2);
        } else {
            this.ewsPlayer.startConnection(n, n2);
        }
        object = this.childAudioServiceListeners.iterator();
        while (object.hasNext()) {
            ((HMIAudioServiceListener)object.next()).startConnection(n, n2);
        }
    }

    public void errorConnection(int n, int n2, int n3) {
        if (n == 27 || n == 307 || n == 141) {
            this.lc.log(100000, "[TVAudioService.errorConnection] error code: %1, connection: %2", (long)n3, (long)n);
        } else {
            this.ewsPlayer.errorConnection(n, n2, n3);
        }
        Iterator iterator = this.childAudioServiceListeners.iterator();
        while (iterator.hasNext()) {
            ((HMIAudioServiceListener)iterator.next()).errorConnection(n, n2, n3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fadedIn(int n, int n2) {
        Object object;
        if (n == 27 || n == 307) {
            this.lc.log(10000000, "[TVAudioService.fadedIn] connection: %1", (long)n);
            object = this;
            synchronized (object) {
                this.setConnectionState(n, 4);
            }
        } else {
            this.ewsPlayer.fadedIn(n, n2);
        }
        object = this.childAudioServiceListeners.iterator();
        while (object.hasNext()) {
            ((HMIAudioServiceListener)object.next()).fadedIn(n, n2);
        }
    }

    private void setConnectionState(int n, int n2) {
        if (n == 27) {
            this.connectionState = n2;
        } else if (n == 307) {
            this.sdisConnectionState = n2;
        }
    }

    private synchronized void fadeToConnection(int n, int n2) {
        if (this.connectionState == 2 && this.stationTuned && this.audioManagerAvailable) {
            this.lc.log(10000000, "[TVAudioService.fadeToConnection] requesting fade-in connection: %1", (long)n);
            this.service.fadeToConnection(n, n2);
            this.setConnectionState(n, 5);
        }
    }

    synchronized void setVolumeLock(boolean bl, String string) {
        if (this.connectionState != 1) {
            this.service.setVolumelock(27, 0, bl, string);
        }
        if (this.sdisConnectionState != 1) {
            this.service.setVolumelock(307, 3, bl, string);
        }
    }

    synchronized void demute() {
        if (this.hasMuAudioFocus) {
            this.handleDemute();
        } else {
            this.demuteOnGetMUAudioFocus = true;
        }
    }

    private void handleDemute() {
        this.releaseConnection(8, 0);
        this.service.releaseA2LSConnection();
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
        Iterator iterator = this.childAudioServiceListeners.iterator();
        while (iterator.hasNext()) {
            ((HMIAudioServiceListener)iterator.next()).updateVolumeLock(n, n2, bl);
        }
    }

    private class TVEventListener
    extends TVEventDefaultListener {
        private TVEventListener() {
        }

        public void onSelectedServiceDebounced(ProgramInfo programInfo) {
            TVAudioService.this.lc.log(10000000, "[TVAudioService.onSelectedServiceDebounced]");
            TVAudioService.this.stationTuned = true;
            if (TVAudioService.this.connectionState == 2) {
                TVAudioService.this.fadeToConnection(27, 0);
            }
            if (TVAudioService.this.sdisConnectionState == 2) {
                TVAudioService.this.fadeToConnection(307, 3);
            }
        }

        public void onMuGotTvAudioFocus() {
            if (!TVAudioService.this.hasMuAudioFocus && !TVAudioService.this.hasSdisAudioFocus) {
                TVAudioService.this.requestConnection(9, 0);
            }
        }

        public void onSdisGotTvAudioFocus() {
        }

        public void onChildLockEnabled() {
            TVAudioService.this.lc.log(10000000, "[TVAudioService.onChildLockEnabled] requesting child lock mute connection");
            TVAudioService.this.service.requestConnection(141, 0);
        }

        public void onChildLockDisabled() {
            TVAudioService.this.lc.log(10000000, "[TVAudioService.onChildLockDisabled] releasing child lock mute connection");
            TVAudioService.this.service.releaseConnection(141, 0);
        }
    }

    private class AudioConnectionService
    implements IAudioListener {
        private AudioConnectionService() {
        }

        public void onMuGotTvAudioFocus(boolean bl) {
            TVAudioService.this.hasMuAudioFocus = true;
            TVAudioService.this.requestConnection(27, 0);
            if (!bl && TVAudioService.this.demuteOnGetMUAudioFocus) {
                TVAudioService.this.handleDemute();
            }
            TVAudioService.this.demuteOnGetMUAudioFocus = false;
        }

        public void onMuLostTvAudioFocus() {
            TVAudioService.this.hasMuAudioFocus = false;
            TVAudioService.this.releaseConnection(27, 0);
            TVAudioService.this.demuteOnGetMUAudioFocus = false;
        }

        public void onSdisGotTvAudioFocus() {
            TVAudioService.this.hasSdisAudioFocus = true;
            TVAudioService.this.requestConnection(307, 3);
        }

        public void onSdisLostTvAudioFocus() {
            TVAudioService.this.hasSdisAudioFocus = false;
            TVAudioService.this.releaseConnection(307, 3);
        }

        public void onMuteChange(boolean bl) {
        }
    }
}

