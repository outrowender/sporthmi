/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.def.NullMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.interapp.media.IMediaFileSessionPlayer;
import de.audi.atip.interapp.media.IMediaSessionPlayer;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class FileSamplePlayer
implements ISamplePlayer {
    private final ToneEnv env;
    private IMediaFilePlayerService mediaService;
    private volatile IMediaFilePlayerSession mediaFilePlayerSession;
    private volatile String url = null;

    public FileSamplePlayer(ToneEnv toneEnv) {
        this.env = toneEnv;
        this.mediaService = new NullMediaFilePlayerService(toneEnv.lcMain);
    }

    public void setUserDefinedRingtone(String string, String string2) {
        this.url = string;
    }

    public void play() {
        if (this.url == null) {
            this.env.lcMain.log(10000, "[FileSamplePlayer.play] URL is null!");
            return;
        }
        this.env.lcMain.log(10000000, "[FileSamplePlayer.play] url:%1", (Object)this.url);
        if (this.mediaFilePlayerSession != null) {
            this.mediaService.close(this.mediaFilePlayerSession);
        }
        this.mediaFilePlayerSession = new RingtoneMediaSession(91, this.url);
        this.mediaService.open(this.mediaFilePlayerSession);
    }

    public void stop() {
        this.env.lcMain.log(10000000, "[FileSamplePlayer.stop]");
        this.mediaService.close(this.mediaFilePlayerSession);
    }

    public void registerService(Object object) {
        if (object instanceof IMediaFilePlayerService) {
            this.mediaService = (IMediaFilePlayerService)object;
        }
    }

    public void deregisterService(Object object) {
        if (object instanceof IMediaFilePlayerService) {
            this.mediaService = new NullMediaFilePlayerService(this.env.lcMain);
        }
    }

    private class RingtoneMediaSession
    implements IMediaFilePlayerSession {
        private final int audioConnection;
        private final String url;
        private volatile IMediaFileSessionPlayer filePlayerSession;

        public RingtoneMediaSession(int n, String string) {
            this.audioConnection = n;
            this.url = string;
        }

        public int getAudioConnection() {
            return this.audioConnection;
        }

        public int getType() {
            return 1;
        }

        public String getName() {
            return "RingtoneMediaSession";
        }

        public void onActive(IMediaSessionPlayer iMediaSessionPlayer) {
            ((FileSamplePlayer)FileSamplePlayer.this).env.lcMain.log(1000000, "[FileSamplePlayer.RingtoneMediaSession#onActive] playing %1", (Object)this.url);
            this.filePlayerSession = (IMediaFileSessionPlayer)iMediaSessionPlayer;
            this.filePlayerSession.play(this.url, true);
        }

        public void onSuspend() {
            ((FileSamplePlayer)FileSamplePlayer.this).env.lcMain.log(1000000, "[FileSamplePlayer.RingtoneMediaSession#onSuspend]");
        }

        public void onClose() {
            ((FileSamplePlayer)FileSamplePlayer.this).env.lcMain.log(1000000, "[FileSamplePlayer.RingtoneMediaSession#onClose]");
        }

        public void updateState(int n) {
            ((FileSamplePlayer)FileSamplePlayer.this).env.lcMain.log(1000000, "[FileSamplePlayer.RingtoneMediaSession#updateState] state=%1", (long)n);
            if (n == 6) {
                ((FileSamplePlayer)FileSamplePlayer.this).env.lcMain.log(100000, "[FileSamplePlayer.RingtoneMediaSession#updateState] STATE_STOPPED_WITH_ERROR");
            }
        }

        public void updatePlayPosition(int n, int n2) {
        }

        public void updateVideoContext(int n) {
        }
    }
}

