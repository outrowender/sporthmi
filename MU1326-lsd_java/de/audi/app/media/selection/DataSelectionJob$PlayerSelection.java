/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.selection.DataSelectionJob;
import de.audi.app.media.selection.DataSelectionJob$1;

class DataSelectionJob$PlayerSelection
implements IPlayerSelectionRequest {
    private final /* synthetic */ DataSelectionJob this$0;

    private DataSelectionJob$PlayerSelection(DataSelectionJob dataSelectionJob) {
        this.this$0 = dataSelectionJob;
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

    /* synthetic */ DataSelectionJob$PlayerSelection(DataSelectionJob dataSelectionJob, DataSelectionJob$1 dataSelectionJob$1) {
        this(dataSelectionJob);
    }
}

