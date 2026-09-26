/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.tuner.app.sdars.SDARSManTune;
import de.audi.tuner.app.sdars.SDARSManTune$1;

class SDARSManTune$rangeListener
extends DefaultRangeListener {
    private final /* synthetic */ SDARSManTune this$0;

    private SDARSManTune$rangeListener(SDARSManTune sDARSManTune) {
        this.this$0 = sDARSManTune;
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.this$0.channelUp(n2, true);
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.this$0.channelDown(n2, true);
    }

    /* synthetic */ SDARSManTune$rangeListener(SDARSManTune sDARSManTune, SDARSManTune$1 sDARSManTune$1) {
        this(sDARSManTune);
    }
}

