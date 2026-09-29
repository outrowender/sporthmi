/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.settings.VisualAudio;
import de.audi.tv.app.settings.VisualAudio$1;

class VisualAudio$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ VisualAudio this$0;

    private VisualAudio$ChoiceListener(VisualAudio visualAudio) {
        this.this$0 = visualAudio;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        boolean bl = n2 == 1;
        VisualAudio.access$200((VisualAudio)this.this$0).lcHMI.log(-2137614336, "[VisualAudio.itemSelected] %2 -> %1", bl, (long)n2);
        VisualAudio.access$100(this.this$0, bl);
        VisualAudio.access$200((VisualAudio)this.this$0).properties.settings.visualAudioActive.accept(new Boolean(bl));
    }

    /* synthetic */ VisualAudio$ChoiceListener(VisualAudio visualAudio, VisualAudio$1 visualAudio$1) {
        this(visualAudio);
    }
}

