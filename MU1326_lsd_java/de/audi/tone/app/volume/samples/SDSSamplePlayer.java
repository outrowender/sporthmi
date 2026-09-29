/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.def.NullSDSService;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class SDSSamplePlayer
implements ISamplePlayer {
    private final LogChannel lc;
    private SDSService sdsService;

    public SDSSamplePlayer(LogChannel logChannel) {
        this.lc = logChannel;
        this.sdsService = new NullSDSService(logChannel);
    }

    @Override
    public void registerService(Object object) {
        if (object instanceof SDSService) {
            this.lc.log(-2137614336, "[SDSSamplePlayer.registerService] %1", object);
            this.sdsService = (SDSService)object;
        }
    }

    @Override
    public void deregisterService(Object object) {
        if (object instanceof SDSService) {
            this.lc.log(1078071040, "[SDSSamplePlayer.deregisterService] %1", object);
            this.sdsService = new NullSDSService(this.lc);
        }
    }

    @Override
    public void play() {
        this.lc.log(-2137614336, "SDSSamplePlayer.play(): Sending SDS command VOLUME!");
        this.sdsService.startVolumeSettingSession();
    }

    @Override
    public void stop() {
        this.lc.log(-2137614336, "SDSSamplePlayer.stop(): Sending SDS command SILENT_ABORT!");
        this.sdsService.stopVolumeSettingSession();
    }
}

