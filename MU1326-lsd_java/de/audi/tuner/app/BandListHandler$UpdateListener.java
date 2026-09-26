/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.BandListHandler$1;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;

class BandListHandler$UpdateListener
extends DefaultUpdateListener
implements IUpdateListener {
    private final /* synthetic */ BandListHandler this$0;

    private BandListHandler$UpdateListener(BandListHandler bandListHandler) {
        this.this$0 = bandListHandler;
    }

    @Override
    public void updatedMemoryList() {
        int n = BandListHandler.access$200(this.this$0).getBaseListModel(1938292992).getLength();
        if (n > 0) {
            this.this$0.addToBandList(12);
        } else {
            this.this$0.removeFromBandList(12);
        }
    }

    /* synthetic */ BandListHandler$UpdateListener(BandListHandler bandListHandler, BandListHandler$1 bandListHandler$1) {
        this(bandListHandler);
    }
}

