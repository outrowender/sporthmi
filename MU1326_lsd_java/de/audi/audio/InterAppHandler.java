/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.audi.atip.interapp.audio.ATIPAudioServiceListener;
import de.audi.atip.interapp.def.NullATIPAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.audio.AudioEnv;

public class InterAppHandler {
    private final LogChannel lc;
    private volatile ATIPAudioServiceListener listener;
    private volatile int activeConn = 0;
    private volatile int activeEntConn = 0;

    public InterAppHandler(AudioEnv audioEnv) {
        this.lc = audioEnv.lcMain;
        this.listener = new NullATIPAudioServiceListener(this.lc);
    }

    public void register(ATIPAudioServiceListener aTIPAudioServiceListener) {
        this.lc.log(-2137614336, "[InterAppHandler.register] ATIPAudioListener:%1", (Object)aTIPAudioServiceListener);
        this.listener = aTIPAudioServiceListener;
        if (this.activeConn != 0) {
            this.lc.log(-2137614336, "[InterAppHandler.register] %1 -> AAC:%2", (Object)aTIPAudioServiceListener, (long)this.activeConn);
            this.updateActiveConnection(this.activeConn, 0);
        }
        if (this.activeEntConn != 0) {
            this.lc.log(-2137614336, "[InterAppHandler.register] %1 -> AEC:%2", (Object)aTIPAudioServiceListener, (long)this.activeEntConn);
            this.updateActiveEntertainmentConnection(this.activeEntConn, 0);
        }
    }

    public void deregister() {
        this.lc.log(-2137614336, "[InterAppHandler.deregister]");
        this.listener = new NullATIPAudioServiceListener(this.lc);
    }

    public ATIPAudioServiceListener getListener() {
        return this.listener;
    }

    public void updateActiveConnection(int n, int n2) {
        this.activeConn = n;
        this.listener.updateActiveConnection(n, n2);
    }

    public void updateActiveEntertainmentConnection(int n, int n2) {
        this.activeEntConn = n;
        this.listener.updateActiveEntertainmentConnection(n, n2);
    }
}

