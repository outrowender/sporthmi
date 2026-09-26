/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.selection.IFavoritePlayerSelectionListener;
import de.audi.app.media.selection.PresetSelectionJob;

class PresetSelectionJob$1
implements IFavoritePlayerSelectionListener {
    private final /* synthetic */ PresetSelectionJob this$0;

    PresetSelectionJob$1(PresetSelectionJob presetSelectionJob) {
        this.this$0 = presetSelectionJob;
    }

    @Override
    public void playFavoriteSelectionDone(boolean bl) {
        this.this$0.logger.log(1078071040, "[%1.playFavoriteSelectionDone] %2", (Object)"PresetSelectionJob", (Object)(bl ? "OK" : "NOK"));
        this.this$0.selectionBrowser.responseSetSelection(bl, this.this$0.selectionContainer);
        this.this$0.finishJob();
    }
}

