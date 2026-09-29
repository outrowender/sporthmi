/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.def.NullMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.volume.samples.FileSamplePlayer$RingtoneMediaSession;
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

    @Override
    public void play() {
        if (this.url == null) {
            this.env.lcMain.log(10000, "[FileSamplePlayer.play] URL is null!");
            return;
        }
        this.env.lcMain.log(-2137614336, "[FileSamplePlayer.play] url:%1", (Object)this.url);
        if (this.mediaFilePlayerSession != null) {
            this.mediaService.close(this.mediaFilePlayerSession);
        }
        this.mediaFilePlayerSession = new FileSamplePlayer$RingtoneMediaSession(this, 91, this.url);
        this.mediaService.open(this.mediaFilePlayerSession);
    }

    @Override
    public void stop() {
        this.env.lcMain.log(-2137614336, "[FileSamplePlayer.stop]");
        this.mediaService.close(this.mediaFilePlayerSession);
    }

    @Override
    public void registerService(Object object) {
        if (object instanceof IMediaFilePlayerService) {
            this.mediaService = (IMediaFilePlayerService)object;
        }
    }

    @Override
    public void deregisterService(Object object) {
        if (object instanceof IMediaFilePlayerService) {
            this.mediaService = new NullMediaFilePlayerService(this.env.lcMain);
        }
    }

    static /* synthetic */ ToneEnv access$000(FileSamplePlayer fileSamplePlayer) {
        return fileSamplePlayer.env;
    }
}

