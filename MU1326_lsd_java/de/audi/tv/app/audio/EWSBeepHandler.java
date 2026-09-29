/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.interapp.def.NullSystemTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tv.app.audio.EWSBeepHandler$HandlingStrategy;
import de.audi.tv.app.audio.EWSBeepHandler$PlayerListener;
import de.audi.tv.app.util.Handler;
import de.audi.tv.app.util.Handler$Builder;

public class EWSBeepHandler {
    private static final int TONEID_WARNING;
    private static final int EVENT_RELEASE_CONNECTION_FALLBACK;
    private static final int EVENT_RELEASE_CONNECTION_FALLBACK_DELAY;
    public final EWSBeepHandler$PlayerListener playerListener = new EWSBeepHandler$PlayerListener(this, null);
    private final Handler handler;
    private volatile SystemTonePlayer systemTonePlayer;
    private volatile HMIAudioService hmiAudioService;
    private final LogChannel lc;

    public EWSBeepHandler(LogChannel logChannel, Handler$Builder handler$Builder) {
        this.lc = logChannel;
        this.systemTonePlayer = new NullSystemTonePlayer(logChannel);
        this.hmiAudioService = new NullHMIAudioService(logChannel);
        this.handler = handler$Builder.setHandlingStrategy(new EWSBeepHandler$HandlingStrategy(this, null)).getHandler();
    }

    public void setSystemTonePlayer(SystemTonePlayer systemTonePlayer) {
        this.systemTonePlayer = systemTonePlayer;
    }

    public void setHMIAudioService(HMIAudioService hMIAudioService) {
        this.hmiAudioService = hMIAudioService;
    }

    public void playWarnTone(int n) {
        this.hmiAudioService.requestConnection(121);
    }

    static /* synthetic */ SystemTonePlayer access$200(EWSBeepHandler eWSBeepHandler) {
        return eWSBeepHandler.systemTonePlayer;
    }

    static /* synthetic */ Handler access$300(EWSBeepHandler eWSBeepHandler) {
        return eWSBeepHandler.handler;
    }

    static /* synthetic */ HMIAudioService access$400(EWSBeepHandler eWSBeepHandler) {
        return eWSBeepHandler.hmiAudioService;
    }

    static /* synthetic */ LogChannel access$500(EWSBeepHandler eWSBeepHandler) {
        return eWSBeepHandler.lc;
    }
}

