/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.favorites.FavoritesController;
import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.app.media.selection.DataSelectionContainer;
import de.audi.app.media.selection.DataSelectionJob;
import de.audi.app.media.selection.IFavoritePlayerSelectionListener;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;

public class FavoriteSelectionJob
extends DataSelectionJob {
    private static final String LOGCLASS;
    private final FavoritesController favoritesController;
    private final IFavoritePlayerSelectionListener favoritePlayerSelectionListener;
    private final MediaFavorite mediaFavorite;

    public FavoriteSelectionJob(SelectionBrowser selectionBrowser, MediaFavorite mediaFavorite, ISourceSlot iSourceSlot, IFavoritePlayerSelectionListener iFavoritePlayerSelectionListener, FavoritesController favoritesController, IPlayer iPlayer, LogChannel logChannel) {
        super(logChannel, selectionBrowser, FavoriteSelectionJob.createDataContainer(iSourceSlot, mediaFavorite), iPlayer);
        this.favoritesController = favoritesController;
        this.mediaFavorite = mediaFavorite;
        this.favoritePlayerSelectionListener = iFavoritePlayerSelectionListener;
    }

    private static DataSelectionContainer createDataContainer(ISourceSlot iSourceSlot, MediaFavorite mediaFavorite) {
        MediaListEntry[] mediaListEntryArray = mediaFavorite.getFavoritePath();
        MediaListEntry mediaListEntry = mediaListEntryArray[mediaListEntryArray.length - 1];
        DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(iSourceSlot, mediaFavorite.getBrowseType(), mediaListEntryArray, mediaListEntry, null);
        return dataSelectionContainer;
    }

    @Override
    public String getName() {
        return "FavoriteSelectionJob";
    }

    @Override
    public void start() {
        this.selectionBrowser.addSelectionListener(this.favoritesController);
        super.start();
    }

    @Override
    public void finishJob() {
        this.selectionBrowser.removeSelectionListener(this.favoritesController);
        super.finishJob();
    }

    @Override
    public void performSelection() {
        this.logger.log(1078071040, "[%1.performSelection]", (Object)"FavoriteSelectionJob");
        if (this.mediaFavorite.isFolderstackEmpty()) {
            this.selectionBrowser.addSelection(true, 1, 0L, 0, false);
        } else {
            this.selectionBrowser.resetSelection();
            this.selectionBrowser.addSelection(true, 0, this.currentBrowsingFolder.getEntryID(), this.currentBrowsingFolder.getContentType(), false);
        }
    }

    private void handleError() {
        this.logger.log(1078071040, "[%1.handleError]", (Object)"FavoriteSelectionJob");
        this.mediaFavorite.setPlayable(false);
        this.favoritePlayerSelectionListener.playFavoriteSelectionDone(false);
        this.finishJob();
    }

    @Override
    protected void browseModeError() {
        this.handleError();
    }

    @Override
    protected void browseFolderError() {
        this.handleError();
    }

    @Override
    public void abort(boolean bl) {
        super.abort(bl);
        this.logger.log(1078071040, "[%1.abort]", (Object)"FavoriteSelectionJob");
        this.favoritePlayerSelectionListener.playFavoriteSelectionDone(false);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append(this.getName());
        stringBuffer.append(" '");
        stringBuffer.append(this.mediaFavorite);
        stringBuffer.append('\'');
        return stringBuffer.toString();
    }
}

