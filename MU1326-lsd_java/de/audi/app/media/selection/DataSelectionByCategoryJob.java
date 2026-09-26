/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.selection.AbstractDataSelectionJob;
import de.audi.app.media.selection.DataSelectionByCategoryJob$PlayerSelection;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.atip.log.LogChannel;

public class DataSelectionByCategoryJob
extends AbstractDataSelectionJob {
    static final String LOGCLASS;
    private final IPlayer player;
    private MediaListEntry[] currentFolder;
    private boolean pathFound = false;
    public volatile boolean useSelectionRangeIndex = true;

    public DataSelectionByCategoryJob(LogChannel logChannel, SelectionBrowser selectionBrowser, IDataSelectionContext iDataSelectionContext, IPlayer iPlayer) {
        super(logChannel, selectionBrowser, iDataSelectionContext);
        this.player = iPlayer;
    }

    @Override
    public String getName() {
        return "DataSelectionByCategoryJob";
    }

    @Override
    public void performSelection() {
        this.selectionBrowser.resetSelection();
        MediaListEntry mediaListEntry = MediaUtils.getLastEntryInStack(this.currentFolder);
        this.logger.log(1078071040, "[%1.performSelection] '%2'", (Object)"DataSelectionByCategoryJob", (Object)LogUtil.listEntryToStr(this.currentFolder));
        if (null != mediaListEntry) {
            this.logger.log(1078071040, "[%1.performSelection] start (selectionRange='%2')", (Object)"DataSelectionByCategoryJob", (Object)(this.useSelectionRangeIndex ? "INDEX" : "ALL"));
            int n = this.useSelectionRangeIndex ? 0 : 1;
            this.selectionBrowser.addSelection(true, n, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
        } else {
            this.logger.log(1078071040, "[%1.performSelection] no last entry -> abort");
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
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                this.logger.log(1078071040, "[%1.browseModeChanged] nothing to do -> handling in browseFolderChanged ", (Object)"DataSelectionByCategoryJob");
                return;
            }
        }
        this.abort(true);
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (bl) {
            this.abort(true);
            return;
        }
        if (!this.pathFound) {
            this.logger.log(1078071040, "[%1.browseFolderChanged] request rootEntries again", (Object)"DataSelectionByCategoryJob");
            this.selectionBrowser.requestListIndexBased(0, this.selectionBrowser.getListSize());
            return;
        }
        this.logger.log(1078071040, "[%1.browseFolderChanged] start normal selection", (Object)"DataSelectionByCategoryJob");
        this.currentFolder = mediaListEntryArray;
        super.browseFolderChanged(bl, mediaListEntryArray, n);
    }

    @Override
    public void playSelection() {
        this.player.setBrowserPlayerSelection(new DataSelectionByCategoryJob$PlayerSelection(this, null));
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (bl) {
            this.logger.log(1078071040, "[%1.responseList] asyncError", (Object)"DataSelectionByCategoryJob");
            this.abort(true);
            return;
        }
        this.logger.log(1078071040, "[%1.responseList]", (Object)"DataSelectionByCategoryJob");
        MediaListEntry[] mediaListEntryArray2 = this.selectionBrowser.getCurrentFolder();
        MediaListEntry[] mediaListEntryArray3 = this.selectionContainer.getFolder();
        MediaListEntry[] mediaListEntryArray4 = new MediaListEntry[mediaListEntryArray2.length + 1 + mediaListEntryArray3.length];
        System.arraycopy((Object)mediaListEntryArray2, 0, (Object)mediaListEntryArray4, 0, mediaListEntryArray2.length);
        if (mediaListEntryArray3.length > 0) {
            System.arraycopy((Object)mediaListEntryArray3, 0, (Object)mediaListEntryArray4, mediaListEntryArray2.length + 1, mediaListEntryArray3.length);
        }
        for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
            MediaListEntry mediaListEntry = mediaListEntryArray[i2];
            switch (mediaListEntry.getTitle().getI18NKey()) {
                case 12: {
                    MediaListEntry[] mediaListEntryArray5 = new MediaListEntry[mediaListEntryArray2.length + 1];
                    System.arraycopy((Object)mediaListEntryArray2, 0, (Object)mediaListEntryArray5, 0, mediaListEntryArray2.length);
                    mediaListEntryArray5[mediaListEntryArray2.length] = mediaListEntry;
                    this.selectionBrowser.changeFolder(mediaListEntryArray5);
                    return;
                }
                case 5: {
                    this.logger.log(1078071040, "[%1.responseList] Albums", (Object)"DataSelectionByCategoryJob");
                    if (this.selectionContainer.getBrowserCategory() != 3) break;
                    mediaListEntryArray4[mediaListEntryArray2.length] = mediaListEntry;
                    this.pathFound = true;
                    break;
                }
                case 2: {
                    this.logger.log(1078071040, "[%1.responseList] Artists", (Object)"DataSelectionByCategoryJob");
                    if (this.selectionContainer.getBrowserCategory() != 4) break;
                    mediaListEntryArray4[mediaListEntryArray2.length] = mediaListEntry;
                    this.pathFound = true;
                    break;
                }
                case 8: {
                    this.logger.log(1078071040, "[%1.responseList] Genres", (Object)"DataSelectionByCategoryJob");
                    if (this.selectionContainer.getBrowserCategory() != 5) break;
                    mediaListEntryArray4[mediaListEntryArray2.length] = mediaListEntry;
                    this.pathFound = true;
                    break;
                }
                case 33: {
                    this.logger.log(1078071040, "[%1.responseList] Songs", (Object)"DataSelectionByCategoryJob");
                    if (this.selectionContainer.getBrowserCategory() != 2) break;
                    mediaListEntryArray4[mediaListEntryArray2.length] = mediaListEntry;
                    this.pathFound = true;
                    break;
                }
            }
            if (!this.pathFound) continue;
            this.state = 3;
            this.logger.log(1078071040, "[%1.responseList] path found", (Object)"DataSelectionByCategoryJob");
            this.selectionBrowser.changeFolder(mediaListEntryArray4);
            return;
        }
        this.logger.log(1078071040, "[%1.responseList] path not found -> abort", (Object)"DataSelectionByCategoryJob");
        this.abort(true);
    }

    @Override
    protected void browseModeError() {
        this.abort(true);
    }

    @Override
    protected void browseFolderError() {
        this.abort(true);
    }
}

