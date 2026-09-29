/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.interapp.audio.ATIPAudioServiceListener;
import de.audi.atip.interapp.audio.IAudioSdisListener;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.sound.SoundHandler;
import de.audi.tone.app.volume.VolumeRangeManager;
import java.util.ArrayList;

public class ATIPAudioServiceListenerImpl
implements ATIPAudioServiceListener {
    private final LogChannel lc;
    private final VolumeRangeManager volManager;
    private final SoundHandler sound;
    private ArrayList sdisAudioListeners;
    private volatile int activeConnection;
    private volatile int activeEntertainmentConnection;

    public ATIPAudioServiceListenerImpl(ToneEnv toneEnv, VolumeRangeManager volumeRangeManager, SoundHandler soundHandler) {
        this.lc = toneEnv.lcHMI;
        this.volManager = volumeRangeManager;
        this.sound = soundHandler;
        this.sdisAudioListeners = new ArrayList();
    }

    @Override
    public void updateActiveConnection(int n, int n2) {
        this.lc.log(-2137614336, "[ATIPAudioServiceListenerImpl.updateActiveConnection] connection:%1 hmiTerminal: %2", (long)n, (long)n2);
        this.volManager.updateActiveConnection(n, n2);
        this.sound.updateActiveConnection(n, n2);
        if (n2 == 0) {
            this.activeConnection = n;
        }
        this.notifyListenersActiveConnection(n, n2);
    }

    @Override
    public void updateActiveEntertainmentConnection(int n, int n2) {
        this.lc.log(-2137614336, "[ATIPAudioServiceListenerImpl.updateActiveEntertainmentConnection] connection:%1 hmiTerminal: %2", (long)n, (long)n2);
        this.volManager.updateActiveEntertainmentConnection(n, n2);
        this.sound.updateActiveEntertainmentConnection(n, n2);
        if (n2 == 0) {
            this.activeEntertainmentConnection = n;
        }
        this.notifyListenersActiveEntConnection(n, n2);
    }

    @Override
    public void incVolume(int n) {
        this.lc.log(-2137614336, "[ATIPAudioServiceListenerImpl.incVolume] steps:%1", (long)n);
        this.volManager.getActiveMenu().increase(0, n);
    }

    @Override
    public void decVolume(int n) {
        this.lc.log(-2137614336, "[ATIPAudioServiceListenerImpl.decVolume] steps:%1", (long)n);
        this.volManager.getActiveMenu().decrease(0, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addAudioSdisListener(IAudioSdisListener iAudioSdisListener) {
        this.lc.log(-2137614336, "[ATIPAudioServiceListenerImpl.addAudioSdisListener] listener:%1", (Object)iAudioSdisListener);
        ArrayList arrayList = this.sdisAudioListeners;
        synchronized (arrayList) {
            this.sdisAudioListeners.add(iAudioSdisListener);
        }
        iAudioSdisListener.updateActiveConnection(this.activeConnection, 0);
        iAudioSdisListener.updateActiveEntertainmentConnection(this.activeEntertainmentConnection, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeAudioSdisListener(IAudioSdisListener iAudioSdisListener) {
        this.lc.log(-2137614336, "[ATIPAudioServiceListenerImpl.removeAudioSdisListener] listener:%1", (Object)iAudioSdisListener);
        ArrayList arrayList = this.sdisAudioListeners;
        synchronized (arrayList) {
            if (this.sdisAudioListeners.contains(iAudioSdisListener)) {
                this.sdisAudioListeners.remove(iAudioSdisListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifyListenersActiveConnection(int n, int n2) {
        ArrayList arrayList;
        Object object = this.sdisAudioListeners;
        synchronized (object) {
            arrayList = (ArrayList)this.sdisAudioListeners.clone();
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            IAudioSdisListener iAudioSdisListener = (IAudioSdisListener)object.next();
            int n3 = this.sdisAudioListeners.size();
            this.lc.log(-2137614336, "[ATIPAudioServiceListenerImpl.notifyListenersActiveConnection] listener:%1, sdisAudioListeners.size %2", (Object)iAudioSdisListener, (long)n3);
            iAudioSdisListener.updateActiveConnection(n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifyListenersActiveEntConnection(int n, int n2) {
        ArrayList arrayList;
        Object object = this.sdisAudioListeners;
        synchronized (object) {
            arrayList = (ArrayList)this.sdisAudioListeners.clone();
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            ((IAudioSdisListener)object.next()).updateActiveEntertainmentConnection(n, n2);
        }
    }
}

