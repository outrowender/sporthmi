/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.selection.DataSelectionSeamlessJob;
import de.audi.app.media.selection.DataSelectionSeamlessJob$1;

class DataSelectionSeamlessJob$PlayerSelection
implements IPlayerSelectionRequest {
    private final /* synthetic */ DataSelectionSeamlessJob this$0;

    private DataSelectionSeamlessJob$PlayerSelection(DataSelectionSeamlessJob dataSelectionSeamlessJob) {
        this.this$0 = dataSelectionSeamlessJob;
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

    /* synthetic */ DataSelectionSeamlessJob$PlayerSelection(DataSelectionSeamlessJob dataSelectionSeamlessJob, DataSelectionSeamlessJob$1 dataSelectionSeamlessJob$1) {
        this(dataSelectionSeamlessJob);
    }
}

