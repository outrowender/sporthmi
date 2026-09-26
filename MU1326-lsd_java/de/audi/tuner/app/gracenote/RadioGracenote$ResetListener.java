/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.tuner.app.gracenote.RadioGracenote;
import de.audi.tuner.app.gracenote.RadioGracenote$1;
import de.audi.tuner.ifc.listener.MessageListener;

class RadioGracenote$ResetListener
extends MessageListener {
    private final /* synthetic */ RadioGracenote this$0;

    private RadioGracenote$ResetListener(RadioGracenote radioGracenote) {
        this.this$0 = radioGracenote;
    }

    @Override
    public void resetToDefaultSettings() {
        RadioGracenote.access$400((RadioGracenote)this.this$0).gracenote.log(-2137614336, "[RadioGracenote.ResetListener.enableOnlineLookup]");
        this.this$0.enableOnlineLookup();
    }

    /* synthetic */ RadioGracenote$ResetListener(RadioGracenote radioGracenote, RadioGracenote$1 radioGracenote$1) {
        this(radioGracenote);
    }
}

