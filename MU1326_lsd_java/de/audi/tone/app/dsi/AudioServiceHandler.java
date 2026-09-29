/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.dsi;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.ap.ActionProxyListener;
import de.audi.tone.app.dsi.AudioServiceHandler$ActionProxyListenerExt;

public class AudioServiceHandler {
    private final LogChannel lc;
    private HMIAudioService audioService;
    public final ActionProxyListener actionProxyListener = new AudioServiceHandler$ActionProxyListenerExt(this);

    public AudioServiceHandler(ToneEnv toneEnv) {
        this.lc = toneEnv.lcMain;
        this.audioService = new NullHMIAudioService(this.lc);
    }

    public void registerService(HMIAudioService hMIAudioService) {
        this.lc.log(-2137614336, "[AudioServiceHandler.registerService] %1", (Object)hMIAudioService);
        this.audioService = hMIAudioService;
    }

    public void deregisterAudioService() {
        this.lc.log(-2137614336, "[AudioServiceHandler.deregisterAudioService]");
        this.audioService = new NullHMIAudioService(this.lc);
    }

    public HMIAudioService getDSI() {
        return this.audioService;
    }

    public void requestConnection(int n, int n2) {
        this.lc.log(-2137614336, "[AudioServiceHandler.requestConnection] conn:%1 hmiTerminal:%2", (long)n2, (long)n);
        this.audioService.requestConnection(n2, n);
    }

    public void requestAndFadeToConnection(int n, int n2) {
        this.lc.log(-2137614336, "[AudioServiceHandler.requestAndFadeToConnection] conn:%1 hmiTerminal:%2", (long)n2, (long)n);
        this.audioService.requestAndFadeToConnection(n2, n);
    }

    public void fadeToConnection(int n, int n2) {
        this.lc.log(-2137614336, "[AudioServiceHandler.fadeToConnection] conn:%1 hmiTerminal:%2", (long)n2, (long)n);
        this.audioService.fadeToConnection(n2, n);
    }

    public void releaseConnection(int n, int n2) {
        this.lc.log(-2137614336, "[AudioServiceHandler.releaseConnection] AC:%1 HT:%2", (long)n2, (long)n);
        this.audioService.releaseConnection(n2, n);
    }

    public void releaseConnection(int n) {
        this.lc.log(-2137614336, "[AudioServiceHandler.releaseConnection] AC:%1", (long)n);
        this.audioService.releaseConnection(n);
    }

    public int getActiveEntertainmentConnection(int n) {
        return this.audioService.getActiveEntertainmentConnection(n);
    }

    public int getActiveConnection(int n) {
        return this.audioService.getActiveConnection(n);
    }

    public boolean isNotStopped(int n) {
        return this.audioService.getStatus(n) != 5;
    }
}

