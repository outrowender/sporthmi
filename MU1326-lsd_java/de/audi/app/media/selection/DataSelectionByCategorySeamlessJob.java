/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.selection.AbstractDataSelectionJob;
import de.audi.app.media.selection.DataSelectionByCategorySeamlessJob$PlayerSelection;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.atip.log.LogChannel;

public class DataSelectionByCategorySeamlessJob
extends AbstractDataSelectionJob {
    static final String LOGCLASS;
    private final IPlayer player;
    private MediaListEntry[] currentFolder;

    public DataSelectionByCategorySeamlessJob(LogChannel logChannel, SelectionBrowser selectionBrowser, IDataSelectionContext iDataSelectionContext, IPlayer iPlayer) {
        super(logChannel, selectionBrowser, iDataSelectionContext);
        this.player = iPlayer;
    }

    @Override
    public String getName() {
        return "DataSelectionByCategorySeamlessJob";
    }

    @Override
    public void performSelection() {
        this.selectionBrowser.resetSelection();
        MediaListEntry mediaListEntry = MediaUtils.getLastEntryInStack(this.currentFolder);
        this.logger.log(1078071040, "[%1.performSelection] '%2'", (Object)"DataSelectionByCategorySeamlessJob", (Object)LogUtil.listEntryToStr(this.currentFolder));
        if (null != mediaListEntry) {
            this.selectionBrowser.addSelection(true, 0, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
        } else {
            this.abort(true);
        }
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
        if (bl) {
            this.abort(true);
            return;
        }
        switch (this.selectionContainer.getBrowserCategory()) {
            case 3: 
            case 4: 
            case 5: {
                this.logger.log(1078071040, "[%1.browseModeChanged] request rootEntries", (Object)"DataSelectionByCategorySeamlessJob");
                this.selectionBrowser.requestListIndexBased(0, this.selectionBrowser.getListSize());
                break;
            }
            default: {
                this.state = 3;
                if (null != this.selectionContainer.getFolder()) {
                    this.selectionBrowser.changeFolder(this.selectionContainer.getFolder());
                    break;
                }
                this.performSelection();
            }
        }
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (bl) {
            this.abort(true);
            return;
        }
        this.logger.log(1078071040, "[%1.browseFolderChanged] start normal selection", (Object)"DataSelectionByCategorySeamlessJob");
        this.currentFolder = mediaListEntryArray;
        super.browseFolderChanged(bl, mediaListEntryArray, n);
    }

    @Override
    public void playSelection() {
        this.player.setBrowserPlayerSelection(new DataSelectionByCategorySeamlessJob$PlayerSelection(this, null));
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (bl) {
            this.logger.log(1078071040, "[%1.responseList] asyncError", (Object)"DataSelectionByCategorySeamlessJob");
            this.abort(true);
            return;
        }
        this.logger.log(1078071040, "[%1.responseList]", (Object)"DataSelectionByCategorySeamlessJob");
        MediaListEntry[] mediaListEntryArray2 = this.selectionBrowser.getCurrentFolder();
        MediaListEntry[] mediaListEntryArray3 = new MediaListEntry[mediaListEntryArray2.length + 2];
        System.arraycopy((Object)mediaListEntryArray2, 0, (Object)mediaListEntryArray3, 0, mediaListEntryArray2.length);
        boolean bl2 = false;
        for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
            MediaListEntry mediaListEntry = mediaListEntryArray[i2];
            switch (mediaListEntry.getTitle().getI18NKey()) {
                case 5: {
                    this.logger.log(1078071040, "[%1.responseList] Albums", (Object)"DataSelectionByCategorySeamlessJob");
                    if (this.selectionContainer.getBrowserCategory() != 3) break;
                    mediaListEntryArray3[mediaListEntryArray2.length] = mediaListEntry;
                    mediaListEntryArray3[mediaListEntryArray2.length + 1] = new MediaListEntry(this.selectionContainer.getDetailInfo().getAlbumID(), 14, "");
                    bl2 = true;
                    break;
                }
                case 2: {
                    this.logger.log(1078071040, "[%1.responseList] Artists", (Object)"DataSelectionByCategorySeamlessJob");
                    if (this.selectionContainer.getBrowserCategory() != 4) break;
                    mediaListEntryArray3[mediaListEntryArray2.length] = mediaListEntry;
                    mediaListEntryArray3[mediaListEntryArray2.length + 1] = new MediaListEntry(this.selectionContainer.getDetailInfo().getArtistID(), 13, "");
                    bl2 = true;
                    break;
                }
                case 8: {
                    this.logger.log(1078071040, "[%1.responseList] Genres", (Object)"DataSelectionByCategorySeamlessJob");
                    if (this.selectionContainer.getBrowserCategory() != 5) break;
                    mediaListEntryArray3[mediaListEntryArray2.length] = mediaListEntry;
                    mediaListEntryArray3[mediaListEntryArray2.length + 1] = new MediaListEntry(this.selectionContainer.getDetailInfo().getGenreID(), 16, "");
                    bl2 = true;
                    break;
                }
            }
            if (!bl2) continue;
            this.state = 3;
            this.logger.log(1078071040, "[%1.responseList] path found", (Object)"DataSelectionByCategorySeamlessJob");
            this.selectionBrowser.changeFolder(mediaListEntryArray3);
            break;
        }
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

