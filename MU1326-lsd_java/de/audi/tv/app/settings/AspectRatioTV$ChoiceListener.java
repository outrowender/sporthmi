/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.settings.AspectRatioTV;
import de.audi.tv.app.settings.AspectRatioTV$1;

class AspectRatioTV$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ AspectRatioTV this$0;

    private AspectRatioTV$ChoiceListener(AspectRatioTV aspectRatioTV) {
        this.this$0 = aspectRatioTV;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (AspectRatioTV.access$100(this.this$0) == 0) {
            AspectRatioTV.access$200(this.this$0, n2);
        }
    }

    /* synthetic */ AspectRatioTV$ChoiceListener(AspectRatioTV aspectRatioTV, AspectRatioTV$1 aspectRatioTV$1) {
        this(aspectRatioTV);
    }
}

