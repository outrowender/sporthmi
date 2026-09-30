/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.audio.TVAudioService;
import de.audi.tv.app.cas.CasIDs;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class MuteHandler {
    public final DefaultTVListener tvListener = new TVListenerImpl();
    public final DSICallListener dsiCallListener = new DSICallListenerExt();
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
        this.lc.log(100000000, "[MuteHandler.updateVolumeLock]");
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

    private class TVListenerImpl
    extends DefaultTVListener {
        private TVListenerImpl() {
        }

        public void updateSelectedSource(int n) {
            MuteHandler.this.selectedSource = n;
            MuteHandler.this.updateVolumeLock();
        }

        public void updateSelectedService(ProgramInfo programInfo) {
            MuteHandler.this.casState = programInfo.casStatus;
            MuteHandler.this.updateVolumeLock();
        }

        public void updateMuteState(int n) {
            MuteHandler.this.setMuteState(n);
        }
    }

    private class DSICallListenerExt
    extends DSICallListener {
        private DSICallListenerExt() {
        }

        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            MuteHandler.this.setMuteState(0);
            if (bl) {
                MuteHandler.this.audio.demute();
            }
        }

        public void switchSource(int n, boolean bl) {
            if (bl) {
                MuteHandler.this.audio.demute();
            }
        }
    }
}

