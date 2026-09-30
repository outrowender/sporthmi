/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.ATIPAudioServiceListener;
import de.audi.atip.interapp.audio.IAudioSdisListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullATIPAudioServiceListener
extends NullService
implements ATIPAudioServiceListener {
    public NullATIPAudioServiceListener(LogChannel logChannel) {
        super(logChannel, "ATIPAudioServiceListener");
    }

    public void updateActiveConnection(int n, int n2) {
        this.log();
    }

    public void updateActiveEntertainmentConnection(int n, int n2) {
        this.log();
    }

    public void incVolume(int n) {
        this.log();
    }

    public void decVolume(int n) {
        this.log();
    }

    public void addAudioSdisListener(IAudioSdisListener iAudioSdisListener) {
        this.log();
    }

    public void removeAudioSdisListener(IAudioSdisListener iAudioSdisListener) {
        this.log();
    }
}

