/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.settings.AVNorm;
import de.audi.tv.app.settings.AVNorm$1;

class AVNorm$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ AVNorm this$0;

    private AVNorm$ChoiceListener(AVNorm aVNorm) {
        this.this$0 = aVNorm;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        AVNorm.access$100(this.this$0, n2);
    }

    /* synthetic */ AVNorm$ChoiceListener(AVNorm aVNorm, AVNorm$1 aVNorm$1) {
        this(aVNorm);
    }
}

