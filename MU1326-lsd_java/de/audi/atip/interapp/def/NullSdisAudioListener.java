/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.IAudioSdisListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullSdisAudioListener
extends NullService
implements IAudioSdisListener {
    private int activeConnection;
    private int activeEntConnection;
    private int acTerminal;
    private int aecTerminal;

    public NullSdisAudioListener(LogChannel logChannel) {
        super(logChannel, "SdisAudioListener");
    }

    @Override
    public void updateActiveConnection(int n, int n2) {
        this.log();
        this.activeConnection = n;
        this.acTerminal = n2;
    }

    @Override
    public void updateActiveEntertainmentConnection(int n, int n2) {
        this.log();
        this.activeEntConnection = n;
        this.aecTerminal = n2;
    }

    public int getActiveConnection() {
        return this.activeConnection;
    }

    public int getActiveEntConnection() {
        return this.activeEntConnection;
    }

    public int getACTerminal() {
        return this.acTerminal;
    }

    public int getAECTerminal() {
        return this.aecTerminal;
    }
}

