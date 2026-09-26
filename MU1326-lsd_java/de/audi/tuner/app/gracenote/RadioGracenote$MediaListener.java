/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.atip.interapp.radio.IGracenoteService;
import de.audi.tuner.app.gracenote.RadioGracenote;
import de.audi.tuner.app.gracenote.RadioGracenote$1;

class RadioGracenote$MediaListener
implements IGracenoteService {
    private final /* synthetic */ RadioGracenote this$0;

    private RadioGracenote$MediaListener(RadioGracenote radioGracenote) {
        this.this$0 = radioGracenote;
    }

    @Override
    public void disableOnlineLookup() {
        RadioGracenote.access$400((RadioGracenote)this.this$0).gracenote.log(-2137614336, "[RadioGracenote.MediaListener.disableOnlineLookup]");
        this.this$0.disableOnlineLookup();
    }

    @Override
    public void enableOnlineLookup() {
        RadioGracenote.access$400((RadioGracenote)this.this$0).gracenote.log(-2137614336, "[RadioGracenote.MediaListener.enableOnlineLookup]");
        this.this$0.enableOnlineLookup();
    }

    /* synthetic */ RadioGracenote$MediaListener(RadioGracenote radioGracenote, RadioGracenote$1 radioGracenote$1) {
        this(radioGracenote);
    }
}

