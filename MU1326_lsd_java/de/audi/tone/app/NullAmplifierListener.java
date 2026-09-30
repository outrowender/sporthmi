/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.interapp.audio.AmplifierListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullAmplifierListener
extends NullService
implements AmplifierListener {
    public NullAmplifierListener(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    public void updateAmplifier(int n) {
        this.log();
    }
}

