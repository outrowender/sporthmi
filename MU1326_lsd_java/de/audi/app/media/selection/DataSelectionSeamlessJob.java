/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.selection.AbstractDataSelectionJob;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.atip.log.LogChannel;

public class DataSelectionSeamlessJob
extends AbstractDataSelectionJob {
    private final IPlayer player;

    public DataSelectionSeamlessJob(LogChannel logChannel, SelectionBrowser selectionBrowser, IDataSelectionContext iDataSelectionContext, IPlayer iPlayer) {
        super(logChannel, selectionBrowser, iDataSelectionContext);
        this.player = iPlayer;
    }

    public String getName() {
        return "DataSelectionSeamlessJob";
    }

    public void performSelection() {
        this.selectionBrowser.resetSelection();
        MediaListEntry mediaListEntry = this.selectionContainer.getFolderToSelect();
        if (null != mediaListEntry) {
            this.selectionBrowser.addSelection(true, 0, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
        } else {
            this.abort(true);
        }
    }

    public void playSelection() {
        this.player.setBrowserPlayerSelection(new PlayerSelection());
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    protected void browseModeError() {
        this.getExecutionContext().jobFinished();
    }

    protected void browseFolderError() {
        this.getExecutionContext().jobFinished();
    }

    private class PlayerSelection
    implements IPlayerSelectionRequest {
        private PlayerSelection() {
        }

        public int getBrowserID() {
            return DataSelectionSeamlessJob.this.selectionBrowser.getBrowserID();
        }

        public long getEntryID() {
            return -1L;
        }

        public boolean isSeamless() {
            return true;
        }

        public boolean waitForPlayposition() {
            return false;
        }

        public void responseSetSelection(boolean bl) {
            DataSelectionSeamlessJob.this.selectionBrowser.responseSetSelection(bl, DataSelectionSeamlessJob.this.selectionContainer);
            DataSelectionSeamlessJob.this.finishJob();
        }
    }
}

