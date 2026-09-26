/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.util.NowPlayingScreenController;
import de.audi.atip.util.NowPlayingScreenController$1;

class NowPlayingScreenController$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ NowPlayingScreenController this$0;

    private NowPlayingScreenController$ChoiceListener(NowPlayingScreenController nowPlayingScreenController) {
        this.this$0 = nowPlayingScreenController;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        NowPlayingScreenController.access$100(this.this$0).log(-2137614336, "[NowPlayingScreenController.itemSelected] '%1'", (long)n2);
        NowPlayingScreenController.access$200(this.this$0).setValue(n2);
        boolean bl = n2 == NowPlayingScreenController.access$300();
        NowPlayingScreenController.access$400(this.this$0).setBoolean(1002, 220, bl);
    }

    /* synthetic */ NowPlayingScreenController$ChoiceListener(NowPlayingScreenController nowPlayingScreenController, NowPlayingScreenController$1 nowPlayingScreenController$1) {
        this(nowPlayingScreenController);
    }
}

