/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$1;

class SeekActiveContentHandler$CancelButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SeekActiveContentHandler this$0;

    private SeekActiveContentHandler$CancelButtonListener(SeekActiveContentHandler seekActiveContentHandler) {
        this.this$0 = seekActiveContentHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        SeekActiveContentHandler.access$1500(this.this$0);
    }

    /* synthetic */ SeekActiveContentHandler$CancelButtonListener(SeekActiveContentHandler seekActiveContentHandler, SeekActiveContentHandler$1 seekActiveContentHandler$1) {
        this(seekActiveContentHandler);
    }
}

