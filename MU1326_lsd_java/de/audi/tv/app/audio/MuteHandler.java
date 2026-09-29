/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.audio.MuteHandler$DSICallListenerExt;
import de.audi.tv.app.audio.MuteHandler$TVListenerImpl;
import de.audi.tv.app.audio.TVAudioService;
import de.audi.tv.app.cas.CasIDs;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;

public class MuteHandler {
    public final DefaultTVListener tvListener = new MuteHandler$TVListenerImpl(this, null);
    public final DSICallListener dsiCallListener = new MuteHandler$DSICallListenerExt(this, null);
    private final IAudioListener audioListener;
    private volatile int muteState;
    private volatile int casState = 0;
    private volatile int selectedSource = -1;
    private final LogChannel lc;
    private final TVAudioService audio;

    public MuteHandler(LogChannel logChannel, TVAudioService tVAudioService, IAudioListener iAudioListener) {
        this.lc = logChannel;
        this.audio = tVAudioService;
        this.audioListener = iAudioListener;
    }

    private void updateVolumeLock() {
        String string;
        boolean bl;
        this.lc.log(14808325, "[MuteHandler.updateVolumeLock]");
        if (this.selectedSource == 1) {
            bl = false;
            string = "AV active";
        } else if (CasIDs.isNOK(this.casState)) {
            bl = true;
            string = "CAS error";
        } else if (this.muteState != 0) {
            bl = true;
            string = "mute active";
        } else {
            bl = false;
            string = "mute and CAS are OK";
        }
        this.audio.setVolumeLock(bl, string);
        this.audioListener.onMuteChange(bl);
    }

    private void setMuteState(int n) {
        this.muteState = n;
        this.updateVolumeLock();
    }

    static /* synthetic */ int access$202(MuteHandler muteHandler, int n) {
        muteHandler.selectedSource = n;
        return muteHandler.selectedSource;
    }

    static /* synthetic */ void access$300(MuteHandler muteHandler) {
        muteHandler.updateVolumeLock();
    }

    static /* synthetic */ int access$402(MuteHandler muteHandler, int n) {
        muteHandler.casState = n;
        return muteHandler.casState;
    }

    static /* synthetic */ void access$500(MuteHandler muteHandler, int n) {
        muteHandler.setMuteState(n);
    }

    static /* synthetic */ TVAudioService access$600(MuteHandler muteHandler) {
        return muteHandler.audio;
    }
}

