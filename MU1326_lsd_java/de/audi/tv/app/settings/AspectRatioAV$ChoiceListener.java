/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.settings.AspectRatioAV;
import de.audi.tv.app.settings.AspectRatioAV$1;

class AspectRatioAV$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ AspectRatioAV this$0;

    private AspectRatioAV$ChoiceListener(AspectRatioAV aspectRatioAV) {
        this.this$0 = aspectRatioAV;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (AspectRatioAV.access$100(this.this$0) == 1) {
            AspectRatioAV.access$200(this.this$0, n2);
        }
    }

    /* synthetic */ AspectRatioAV$ChoiceListener(AspectRatioAV aspectRatioAV, AspectRatioAV$1 aspectRatioAV$1) {
        this(aspectRatioAV);
    }
}

