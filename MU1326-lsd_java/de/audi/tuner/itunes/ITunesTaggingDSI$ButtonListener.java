/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.itunes;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.itunes.ITunesTaggingDSI;
import de.audi.tuner.itunes.ITunesTaggingDSI$1;

class ITunesTaggingDSI$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ ITunesTaggingDSI this$0;

    private ITunesTaggingDSI$ButtonListener(ITunesTaggingDSI iTunesTaggingDSI) {
        this.this$0 = iTunesTaggingDSI;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        ITunesTaggingDSI.access$100(this.this$0);
    }

    /* synthetic */ ITunesTaggingDSI$ButtonListener(ITunesTaggingDSI iTunesTaggingDSI, ITunesTaggingDSI$1 iTunesTaggingDSI$1) {
        this(iTunesTaggingDSI);
    }
}

