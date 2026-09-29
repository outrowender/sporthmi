/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.radio.IGracenoteServiceListener;
import de.audi.atip.log.LogChannel;

class NullGracenoteServiceListener
extends NullService
implements IGracenoteServiceListener {
    NullGracenoteServiceListener(LogChannel logChannel) {
        super(logChannel, "IGracenoteServiceListener");
    }

    @Override
    public void updateOnlineLookupStatus(int n) {
        this.log();
    }
}

