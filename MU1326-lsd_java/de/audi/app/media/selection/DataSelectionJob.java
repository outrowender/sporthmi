/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.selection.AbstractDataSelectionJob;
import de.audi.app.media.selection.DataSelectionJob$PlayerSelection;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.atip.log.LogChannel;

public class DataSelectionJob
extends AbstractDataSelectionJob {
    private final IPlayer player;
    protected volatile MediaListEntry currentBrowsingFolder = null;

    public DataSelectionJob(LogChannel logChannel, SelectionBrowser selectionBrowser, IDataSelectionContext iDataSelectionContext, IPlayer iPlayer) {
        super(logChannel, selectionBrowser, iDataSelectionContext);
        this.player = iPlayer;
    }

    @Override
    public String getName() {
        return "DataSelectionJob";
    }

    @Override
    public void performSelection() {
        this.selectionBrowser.resetSelection();
        MediaListEntry mediaListEntry = this.selectionContainer.getFolderToSelect();
        if (null != mediaListEntry) {
            if (mediaListEntry.getEntryID() != -1L) {
                this.selectionBrowser.addSelection(true, 0, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
            } else if (this.currentBrowsingFolder != null) {
                this.selectionBrowser.addSelection(true, 0, this.currentBrowsingFolder.getEntryID(), this.currentBrowsingFolder.getContentType(), false);
            } else {
                this.abort(true);
            }
        } else {
            this.abort(true);
        }
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (!bl) {
            this.currentBrowsingFolder = mediaListEntryArray[mediaListEntryArray.length - 1];
        }
        super.browseFolderChanged(bl, mediaListEntryArray, n);
    }

    @Override
    public void playSelection() {
        this.player.setBrowserPlayerSelection(new DataSelectionJob$PlayerSelection(this, null));
    }

    public void listUpdated(int n) {
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

