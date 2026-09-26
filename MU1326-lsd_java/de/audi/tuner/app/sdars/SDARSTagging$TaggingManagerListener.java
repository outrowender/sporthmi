/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SDARSTagging;
import de.audi.tuner.app.sdars.SDARSTagging$1;
import de.audi.tuner.itunes.ITaggingManagerListener;

class SDARSTagging$TaggingManagerListener
implements ITaggingManagerListener {
    private final /* synthetic */ SDARSTagging this$0;

    private SDARSTagging$TaggingManagerListener(SDARSTagging sDARSTagging) {
        this.this$0 = sDARSTagging;
    }

    @Override
    public void taggedContentChanged() {
        this.this$0.setPdt(SDARSTagging.access$300(this.this$0));
    }

    @Override
    public void updateTagResult(int n) {
    }

    /* synthetic */ SDARSTagging$TaggingManagerListener(SDARSTagging sDARSTagging, SDARSTagging$1 sDARSTagging$1) {
        this(sDARSTagging);
    }
}

