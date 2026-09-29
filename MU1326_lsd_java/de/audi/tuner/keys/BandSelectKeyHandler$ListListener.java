/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.keys;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.keys.BandSelectKeyHandler;
import de.audi.tuner.keys.BandSelectKeyHandler$1;

class BandSelectKeyHandler$ListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ BandSelectKeyHandler this$0;

    private BandSelectKeyHandler$ListListener(BandSelectKeyHandler bandSelectKeyHandler) {
        this.this$0 = bandSelectKeyHandler;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        int[] nArray = this.this$0.bandListHandler.getWavebands();
        if (n2 <= nArray.length) {
            this.this$0.bandSelected(nArray[n2], n4);
        } else {
            this.this$0.logger.hmi.log(10000, "[BandSelectKeyHandler#itemSelected] Illegal index: %1 (list length: %2)", (long)n2, (long)nArray.length);
        }
        BandSelectKeyHandler.access$500(this.this$0, n4);
    }

    /* synthetic */ BandSelectKeyHandler$ListListener(BandSelectKeyHandler bandSelectKeyHandler, BandSelectKeyHandler$1 bandSelectKeyHandler$1) {
        this(bandSelectKeyHandler);
    }
}

