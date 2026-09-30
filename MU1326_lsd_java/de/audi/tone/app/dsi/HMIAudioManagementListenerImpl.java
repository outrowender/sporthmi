/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.dsi;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.intra.AppAudioListeners;
import de.audi.tone.app.intra.IAppAudioListener;

public class HMIAudioManagementListenerImpl
implements HMIAudioServiceListener {
    private final ToneEnv env;
    private final AppAudioListeners listeners = new AppAudioListeners();
    private volatile boolean amAvailable;

    public HMIAudioManagementListenerImpl(ToneEnv toneEnv) {
        this.env = toneEnv;
    }

    public void addAppListener(IAppAudioListener iAppAudioListener) {
        this.env.lcMain.log(10000000, "[HMIAudioManagementListenerImpl.addAppListener] %1", (Object)iAppAudioListener);
        iAppAudioListener.updateAMAvailable(this.amAvailable);
        this.listeners.add(iAppAudioListener);
    }

    public void fadedIn(int n, int n2) {
        this.env.lcMain.log(10000000, "[HMIAudioManagementListenerImpl.fadedIn] HC:%1 HT:%2", (long)n, (long)n2);
        this.broadcastConnectionStatus(n, 0, n2);
    }

    public void startConnection(int n, int n2) {
        this.env.lcMain.log(10000000, "[HMIAudioManagementListenerImpl.startConnection] HC:%1 HT:%2", (long)n, (long)n2);
        this.broadcastConnectionStatus(n, 2, n2);
    }

    public void pauseConnection(int n, int n2) {
        this.env.lcMain.log(10000000, "[HMIAudioManagementListenerImpl.pauseConnection] HC:%1 HT:%2", (long)n, (long)n2);
        this.broadcastConnectionStatus(n, 4, n2);
    }

    public void stopConnection(int n, int n2) {
        this.env.lcMain.log(10000000, "[HMIAudioManagementListenerImpl.stopConnection] HC:%1 HT:%2", (long)n, (long)n2);
        this.broadcastConnectionStatus(n, 5, n2);
    }

    public void errorConnection(int n, int n2, int n3) {
        this.env.lcMain.log(10000, "[HMIAudioManagementListenerImpl.errorConnection] HC:%1 HT:%2 error:%3", (long)n, (long)n2, (long)n3);
        this.broadcastConnectionStatus(n, 5, n2);
    }

    public void updateAMAvailable(boolean bl) {
        this.env.lcMain.log(1000000, "[HMIAudioManagementListenerImpl.updateAMAvailable] available:%1", bl);
        IAppAudioListener[] iAppAudioListenerArray = this.listeners.toArray();
        for (int i2 = 0; i2 < iAppAudioListenerArray.length; ++i2) {
            iAppAudioListenerArray[i2].updateAMAvailable(bl);
        }
    }

    private void broadcastConnectionStatus(int n, int n2, int n3) {
        IAppAudioListener[] iAppAudioListenerArray = this.listeners.toArray();
        for (int i2 = 0; i2 < iAppAudioListenerArray.length; ++i2) {
            iAppAudioListenerArray[i2].updateConnectionStatus(n, n2, n3);
        }
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }
}

