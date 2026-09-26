/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.HardKeyListener;
import de.audi.tv.app.HardKeyListener$1;
import de.audi.tv.app.base.TVEventDefaultListener;

class HardKeyListener$ActivationListener
extends TVEventDefaultListener {
    private final /* synthetic */ HardKeyListener this$0;

    private HardKeyListener$ActivationListener(HardKeyListener hardKeyListener) {
        this.this$0 = hardKeyListener;
    }

    @Override
    public void onMuGotTvAudioFocus() {
        HardKeyListener.access$202(this.this$0, true);
        HardKeyListener.access$300(this.this$0).log(1078071040, "[HardKeyListener.ActivationListener.onGotAudioFocus] HardKey evaluation enabled.");
    }

    @Override
    public void onMuLostTvAudioFocus() {
        HardKeyListener.access$202(this.this$0, false);
        HardKeyListener.access$300(this.this$0).log(1078071040, "[HardKeyListener.ActivationListener.onLostAudioFocus] HardKey evaluation disabled.");
    }

    /* synthetic */ HardKeyListener$ActivationListener(HardKeyListener hardKeyListener, HardKeyListener$1 hardKeyListener$1) {
        this(hardKeyListener);
    }
}

