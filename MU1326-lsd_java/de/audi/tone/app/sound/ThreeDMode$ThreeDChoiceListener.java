/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tone.app.sound.ThreeDMode;
import de.audi.tone.app.sound.ThreeDMode$1;

class ThreeDMode$ThreeDChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ ThreeDMode this$0;

    private ThreeDMode$ThreeDChoiceListener(ThreeDMode threeDMode) {
        this.this$0 = threeDMode;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        int n5 = ThreeDMode.access$100()[n2];
        ThreeDMode.access$200((ThreeDMode)this.this$0).lcHMI.log(-2137614336, "[ThreeDMode.itemSelected] index:%1 -> mode3d:%2", (long)n2, (long)n5);
        ThreeDMode.access$300(this.this$0).setThreeDMode(n5);
    }

    /* synthetic */ ThreeDMode$ThreeDChoiceListener(ThreeDMode threeDMode, ThreeDMode$1 threeDMode$1) {
        this(threeDMode);
    }
}

