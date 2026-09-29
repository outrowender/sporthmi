/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.selection.AbstractDataSelectionJob;
import de.audi.app.media.selection.DataSelectionSeamlessJob$PlayerSelection;
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

    @Override
    public String getName() {
        return "DataSelectionSeamlessJob";
    }

    @Override
    public void performSelection() {
        this.selectionBrowser.resetSelection();
        MediaListEntry mediaListEntry = this.selectionContainer.getFolderToSelect();
        if (null != mediaListEntry) {
            this.selectionBrowser.addSelection(true, 0, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
        } else {
            this.abort(true);
        }
    }

    @Override
    public void playSelection() {
        this.player.setBrowserPlayerSelection(new DataSelectionSeamlessJob$PlayerSelection(this, null));
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
    }

    @Override
    protected void browseModeError() {
        this.getExecutionContext().jobFinished();
    }

    @Override
    protected void browseFolderError() {
        this.getExecutionContext().jobFinished();
    }
}

