/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.def.NullNaviService;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class NaviSamplePlayer
implements ISamplePlayer {
    private NaviService naviService;
    private final LogChannel lc;
    private volatile boolean playing;

    public NaviSamplePlayer(LogChannel logChannel) {
        this.lc = logChannel;
        this.naviService = new NullNaviService(logChannel);
    }

    public void registerService(Object object) {
        if (object instanceof NaviService) {
            this.lc.log(10000000, "[NaviSamplePlayer.registerService] service: %1", object);
            this.naviService = (NaviService)object;
        } else {
            this.lc.log(10000000, "[NaviSamplePlayer.registerService] service: %1 is not instanceof NaviService", object);
        }
    }

    public void deregisterService(Object object) {
        if (object instanceof NaviService) {
            this.lc.log(1000000, "[NaviSamplePlayer.deregisterService]", object);
            this.naviService = new NullNaviService(this.lc);
        }
    }

    public void play() {
        if (!this.playing) {
            this.lc.log(10000000, "[NaviSamplePlayer.play]");
            this.naviService.setAnnouncementRepeatMode(true);
            this.playing = true;
        } else {
            this.lc.log(10000000, "[NaviSamplePlayer.play] ignored (already playing)");
        }
    }

    public void stop() {
        this.lc.log(10000000, "[NaviSamplePlayer.stop]");
        this.naviService.setAnnouncementRepeatMode(false);
        this.playing = false;
    }
}

