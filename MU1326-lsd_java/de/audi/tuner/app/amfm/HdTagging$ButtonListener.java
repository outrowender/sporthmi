/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.amfm.HdTagging;
import de.audi.tuner.app.amfm.HdTagging$1;

class HdTagging$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ HdTagging this$0;

    private HdTagging$ButtonListener(HdTagging hdTagging) {
        this.this$0 = hdTagging;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        HdTagging.access$500(this.this$0);
    }

    /* synthetic */ HdTagging$ButtonListener(HdTagging hdTagging, HdTagging$1 hdTagging$1) {
        this(hdTagging);
    }
}

