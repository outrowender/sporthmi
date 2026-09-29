/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelRingtoneManager;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.interapp.media.IMediaFileSessionPlayer;
import de.audi.atip.interapp.media.IMediaSessionPlayer;

class TelRingtoneManager$RingtoneMediaSession
implements IMediaFilePlayerSession {
    private final int audioConnection;
    private final int mode;
    private final String url;
    private volatile IMediaFileSessionPlayer filePlayerSession;
    private boolean sessionStarted;
    private final /* synthetic */ TelRingtoneManager this$0;

    public TelRingtoneManager$RingtoneMediaSession(TelRingtoneManager telRingtoneManager, int n, int n2, String string) {
        this.this$0 = telRingtoneManager;
        this.audioConnection = n;
        this.mode = n2;
        this.url = string;
        this.setSessionStarted(true);
    }

    @Override
    public int getAudioConnection() {
        return this.audioConnection;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public String getName() {
        return "RingtoneMediaSession";
    }

    @Override
    public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
        TelRingtoneManager.access$100(this.this$0).log(1078071040, "[TelRingtoneManager.RingtoneMediaSession#onActive] playing %1", (Object)this.url);
        this.filePlayerSession = (IMediaFileSessionPlayer)iMediaSessionPlayer;
        this.filePlayerSession.play(this.url, true);
    }

    @Override
    public void onSuspend() {
        TelRingtoneManager.access$200(this.this$0).log(1078071040, "[TelRingtoneManager.RingtoneMediaSession#onSuspend]");
    }

    @Override
    public void onClose() {
        TelRingtoneManager.access$300(this.this$0).log(1078071040, "[TelRingtoneManager.RingtoneMediaSession#onClose]");
    }

    @Override
    public void updateState(int n) {
        TelRingtoneManager.access$400(this.this$0).log(1078071040, "[TelRingtoneManager.RingtoneMediaSession#updateState] state=%1", (long)n);
        if (n == 6) {
            TelRingtoneManager.access$500(this.this$0).log(-1601830656, "[TelRingtoneManager.RingtoneMediaSession#updateState] STATE_STOPPED_WITH_ERROR");
            if (this.mode == 0) {
                TelRingtoneManager.access$900(this.this$0).scheduleRingingDefaultRingtoneFallback(TelRingtoneManager.access$600(this.this$0), TelRingtoneManager.access$700(this.this$0), TelRingtoneManager.access$800(this.this$0));
            } else if (this.mode == 1) {
                TelRingtoneManager.access$900(this.this$0).scheduleRingtoneListDefaultRingtoneFallback(TelRingtoneManager.access$600(this.this$0), TelRingtoneManager.access$700(this.this$0), TelRingtoneManager.access$800(this.this$0));
            } else {
                TelRingtoneManager.access$1000(this.this$0).log(-1601830656, "[TelRingtoneManager.RingtoneMediaSession#updateState] unknown mode %1", (long)this.mode);
            }
            this.this$0.notifyMediaPlaybackError();
        }
    }

    @Override
    public void updatePlayPosition(int n, int n2) {
    }

    @Override
    public void updateVideoContext(int n) {
    }

    public boolean isSessionStarted() {
        return this.sessionStarted;
    }

    public void setSessionStarted(boolean bl) {
        this.sessionStarted = bl;
    }
}

