/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.selection.DataSelectionByCategoryJob;
import de.audi.app.media.selection.DataSelectionByCategoryJob$1;

class DataSelectionByCategoryJob$PlayerSelection
implements IPlayerSelectionRequest {
    private final /* synthetic */ DataSelectionByCategoryJob this$0;

    private DataSelectionByCategoryJob$PlayerSelection(DataSelectionByCategoryJob dataSelectionByCategoryJob) {
        this.this$0 = dataSelectionByCategoryJob;
    }

    @Override
    public int getBrowserID() {
        return this.this$0.selectionBrowser.getBrowserID();
    }

    @Override
    public long getEntryID() {
        if (this.this$0.selectionContainer.getEntryToPlay() != null) {
            return this.this$0.selectionContainer.getEntryToPlay().getEntryID();
        }
        return -1L;
    }

    @Override
    public boolean isSeamless() {
        return false;
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

    /* synthetic */ DataSelectionByCategoryJob$PlayerSelection(DataSelectionByCategoryJob dataSelectionByCategoryJob, DataSelectionByCategoryJob$1 dataSelectionByCategoryJob$1) {
        this(dataSelectionByCategoryJob);
    }
}

