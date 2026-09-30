/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullHMIAudioServiceListener
extends NullService
implements HMIAudioServiceListener {
    public NullHMIAudioServiceListener(LogChannel logChannel) {
        super(logChannel, "HMIAudioServiceListener");
    }

    public void updateAMAvailable(boolean bl) {
        this.log();
    }

    public void stopConnection(int n, int n2) {
        this.log();
    }

    public void pauseConnection(int n, int n2) {
        this.log();
    }

    public void startConnection(int n, int n2) {
        this.log();
    }

    public void errorConnection(int n, int n2, int n3) {
        this.log();
    }

    public void fadedIn(int n, int n2) {
        this.log();
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }
}

