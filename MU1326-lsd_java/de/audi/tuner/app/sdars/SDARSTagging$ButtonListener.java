/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.sdars.SDARSTagging;
import de.audi.tuner.app.sdars.SDARSTagging$1;

class SDARSTagging$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SDARSTagging this$0;

    private SDARSTagging$ButtonListener(SDARSTagging sDARSTagging) {
        this.this$0 = sDARSTagging;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        SDARSTagging.access$200(this.this$0);
    }

    /* synthetic */ SDARSTagging$ButtonListener(SDARSTagging sDARSTagging, SDARSTagging$1 sDARSTagging$1) {
        this(sDARSTagging);
    }
}

