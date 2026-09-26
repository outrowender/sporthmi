/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.gracenote.RadioGracenote;
import de.audi.tuner.app.gracenote.RadioGracenote$1;

class RadioGracenote$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ RadioGracenote this$0;

    private RadioGracenote$ChoiceListener(RadioGracenote radioGracenote) {
        this.this$0 = radioGracenote;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        RadioGracenote.access$400((RadioGracenote)this.this$0).hmi.log(-2137614336, "[RadioGracenote.ChoiceListener.itemSelected] change online lookup, itemID: %1", (long)n2);
        if (n2 == 0) {
            this.this$0.disableOnlineLookup();
        } else {
            this.this$0.enableOnlineLookup();
        }
        TunerProxyManager.getInstance().getActiveTuner().reRequestCoverArt();
    }

    /* synthetic */ RadioGracenote$ChoiceListener(RadioGracenote radioGracenote, RadioGracenote$1 radioGracenote$1) {
        this(radioGracenote);
    }
}

