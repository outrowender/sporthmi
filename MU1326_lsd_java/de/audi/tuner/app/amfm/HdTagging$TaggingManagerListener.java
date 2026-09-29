/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.HdTagging;
import de.audi.tuner.app.amfm.HdTagging$1;
import de.audi.tuner.itunes.ITaggingManagerListener;

class HdTagging$TaggingManagerListener
implements ITaggingManagerListener {
    private final /* synthetic */ HdTagging this$0;

    private HdTagging$TaggingManagerListener(HdTagging hdTagging) {
        this.this$0 = hdTagging;
    }

    @Override
    public void taggedContentChanged() {
        HdTagging.access$800(this.this$0);
    }

    @Override
    public void updateTagResult(int n) {
    }

    /* synthetic */ HdTagging$TaggingManagerListener(HdTagging hdTagging, HdTagging$1 hdTagging$1) {
        this(hdTagging);
    }
}

