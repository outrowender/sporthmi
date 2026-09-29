/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.selection.DataSelectionByCategorySeamlessJob;
import de.audi.app.media.selection.DataSelectionByCategorySeamlessJob$1;

class DataSelectionByCategorySeamlessJob$PlayerSelection
implements IPlayerSelectionRequest {
    private final /* synthetic */ DataSelectionByCategorySeamlessJob this$0;

    private DataSelectionByCategorySeamlessJob$PlayerSelection(DataSelectionByCategorySeamlessJob dataSelectionByCategorySeamlessJob) {
        this.this$0 = dataSelectionByCategorySeamlessJob;
    }

    @Override
    public int getBrowserID() {
        return this.this$0.selectionBrowser.getBrowserID();
    }

    @Override
    public long getEntryID() {
        return -1L;
    }

    @Override
    public boolean isSeamless() {
        return true;
    }

    @Override
    public boolean waitForPlayposition() {
        return false;
    }

    @Override
    public void responseSetSelection(boolean bl) {
        this.this$0.selectionBrowser.responseSetSelection(bl, this.this$0.selectionContainer);
        this.this$0.finishJob();
    }

    /* synthetic */ DataSelectionByCategorySeamlessJob$PlayerSelection(DataSelectionByCategorySeamlessJob dataSelectionByCategorySeamlessJob, DataSelectionByCategorySeamlessJob$1 dataSelectionByCategorySeamlessJob$1) {
        this(dataSelectionByCategorySeamlessJob);
    }
}

