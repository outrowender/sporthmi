/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.SDISRangeListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullSDISRangeListener
extends NullService
implements SDISRangeListener {
    public NullSDISRangeListener(LogChannel logChannel) {
        super(logChannel, "SDISRangeListener");
    }

    public void decrement(int n, int n2, int n3) {
        this.log("decrement");
    }

    public void increment(int n, int n2, int n3) {
        this.log("increment");
    }

    public void changeVolume(int n) {
        this.log("changeVolume");
    }
}

