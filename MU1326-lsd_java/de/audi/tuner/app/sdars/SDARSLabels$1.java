/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SDARSLabels;
import de.audi.tuner.util.change.ChangeEvent;
import de.audi.tuner.util.change.ChangeListener;

class SDARSLabels$1
implements ChangeListener {
    private final /* synthetic */ SDARSLabels this$0;

    SDARSLabels$1(SDARSLabels sDARSLabels) {
        this.this$0 = sDARSLabels;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        SDARSLabels.access$300(this.this$0, false);
    }
}

