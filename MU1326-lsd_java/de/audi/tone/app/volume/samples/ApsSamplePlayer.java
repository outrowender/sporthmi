/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.audio.ToneServiceListener;
import de.audi.atip.interapp.def.NullToneServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class ApsSamplePlayer
implements ISamplePlayer {
    private ToneServiceListener listener;
    private LogChannel lc;

    public ApsSamplePlayer(LogChannel logChannel) {
        this.lc = logChannel;
        this.listener = new NullToneServiceListener(logChannel, "ToneServiceListener");
    }

    @Override
    public void play() {
        this.lc.log(-2137614336, "[ApsSamplePlayer.play]");
        this.listener.updateApsEntertainmentLoweringComboboxState(1);
    }

    @Override
    public void stop() {
        this.lc.log(-2137614336, "[ApsSamplePlayer.stop]");
        this.listener.updateApsEntertainmentLoweringComboboxState(0);
    }

    @Override
    public void registerService(Object object) {
        if (object instanceof ToneServiceListener) {
            this.lc.log(-2137614336, "[ApsSamplePlayer.registerService] service  registered: %1", object);
            this.listener = (ToneServiceListener)object;
        } else {
            this.lc.log(-2137614336, "[ApsSamplePlayer.registerService] service not registered: %1", object);
        }
    }

    @Override
    public void deregisterService(Object object) {
        if (object instanceof ToneServiceListener) {
            this.listener = new NullToneServiceListener(this.lc, "ToneServiceListener");
        }
    }
}

