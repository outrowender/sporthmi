/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.interapp.media.IMediaFileSessionPlayer;
import de.audi.atip.interapp.media.IMediaSessionPlayer;
import de.audi.tone.app.volume.samples.FileSamplePlayer;

class FileSamplePlayer$RingtoneMediaSession
implements IMediaFilePlayerSession {
    private final int audioConnection;
    private final String url;
    private volatile IMediaFileSessionPlayer filePlayerSession;
    private final /* synthetic */ FileSamplePlayer this$0;

    public FileSamplePlayer$RingtoneMediaSession(FileSamplePlayer fileSamplePlayer, int n, String string) {
        this.this$0 = fileSamplePlayer;
        this.audioConnection = n;
        this.url = string;
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
        FileSamplePlayer.access$000((FileSamplePlayer)this.this$0).lcMain.log(1078071040, "[FileSamplePlayer.RingtoneMediaSession#onActive] playing %1", (Object)this.url);
        this.filePlayerSession = (IMediaFileSessionPlayer)iMediaSessionPlayer;
        this.filePlayerSession.play(this.url, true);
    }

    @Override
    public void onSuspend() {
        FileSamplePlayer.access$000((FileSamplePlayer)this.this$0).lcMain.log(1078071040, "[FileSamplePlayer.RingtoneMediaSession#onSuspend]");
    }

    @Override
    public void onClose() {
        FileSamplePlayer.access$000((FileSamplePlayer)this.this$0).lcMain.log(1078071040, "[FileSamplePlayer.RingtoneMediaSession#onClose]");
    }

    @Override
    public void updateState(int n) {
        FileSamplePlayer.access$000((FileSamplePlayer)this.this$0).lcMain.log(1078071040, "[FileSamplePlayer.RingtoneMediaSession#updateState] state=%1", (long)n);
        if (n == 6) {
            FileSamplePlayer.access$000((FileSamplePlayer)this.this$0).lcMain.log(-1601830656, "[FileSamplePlayer.RingtoneMediaSession#updateState] STATE_STOPPED_WITH_ERROR");
        }
    }

    @Override
    public void updatePlayPosition(int n, int n2) {
    }

    @Override
    public void updateVideoContext(int n) {
    }
}

