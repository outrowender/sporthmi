/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.settings.Subtitle;
import de.audi.tv.app.settings.Subtitle$1;

class Subtitle$ChoiceListenerImpl
extends DefaultChoiceListener {
    private final /* synthetic */ Subtitle this$0;

    private Subtitle$ChoiceListenerImpl(Subtitle subtitle) {
        this.this$0 = subtitle;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        boolean bl = n2 == 1;
        Subtitle.access$100((Subtitle)this.this$0).lcHMI.log(-2137614336, "[Subtitle.itemSelected] %2 -> %1", bl, (long)n2);
        Subtitle.access$200(this.this$0).enableSubtitle(bl);
    }

    /* synthetic */ Subtitle$ChoiceListenerImpl(Subtitle subtitle, Subtitle$1 subtitle$1) {
        this(subtitle);
    }
}

