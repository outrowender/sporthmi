/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.DataBrowserListRow;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewListRow;
import de.audi.app.media.evo.content.data.favorites.FavoriteSelectionJob;
import de.audi.app.media.evo.content.data.favorites.FavoritesBrowserList;
import de.audi.app.media.evo.content.data.favorites.FavoritesList;
import de.audi.app.media.evo.content.data.favorites.FavoritesListRow;
import de.audi.app.media.evo.content.data.favorites.FavoritesPersistentManager;
import de.audi.app.media.evo.content.data.favorites.FavoritesSearchDataProvider;
import de.audi.app.media.evo.content.data.favorites.IFavoriteSelectionListener;
import de.audi.app.media.evo.content.data.favorites.IFavoritesBrowserList;
import de.audi.app.media.evo.content.data.favorites.IFavoritesController;
import de.audi.app.media.evo.content.data.favorites.IMediaFavoriteListListener;
import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.app.media.evo.utils.MediaEvoUtils;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.IFavoritePlayerSelectionListener;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FavoritesController
extends AbstractMediaTerminalComponent
implements IFavoritesController,
OptionModelListener,
ButtonListener,
IActionProxyListener,
IDiagnosisDataProvider,
ISourceSlotListener,
IFavoriteSelectionListener,
ISelectionListener {
    private static final String LOGCLASS = "FavoritesController";
    private static final int FAVORITES_NOT_SUPPORTED = 0;
    private static final int FAVORITES_SUPPORTED = 1;
    private static final int NEW_FAVORITE_STORED = 0;
    private static final int ITEM_IS_ALREADY_STORED = 1;
    private final ChoiceModelApp favoriteStoredSuccessfully;
    private final LogChannel logger;
    private final CopyOnWriteArrayList registeredFavListListener;
    private volatile FavoritesList favoritesList;
    private final FavoritesBrowserList favoriteBrowserList;
    private final FavoritesPersistentManager favoritesPersistentManager;
    private final FavoritesSearchDataProvider favoritesSearchDataProvider;
    private volatile IPlayer player;

    public FavoritesController(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.logger = iMediaTerminal.getLogger().hmi();
        this.registeredFavListListener = new CopyOnWriteArrayList(2);
        this.favoriteBrowserList = new FavoritesBrowserList(iMediaTerminal, this);
        this.favoritesPersistentManager = new FavoritesPersistentManager(iMediaTerminal, this);
        this.favoritesSearchDataProvider = iMediaTerminal.getFramework().isEvoHigh() ? new FavoritesSearchDataProvider(iMediaTerminal, iMediaTerminal.getLogger().main(), this) : null;
        iMediaTerminal.getDiagnosisManager().addDataProvider(-1, this);
        this.favoriteStoredSuccessfully = this.getChoiceModel(201115);
    }

    public void setPlayer(IPlayer iPlayer) {
        this.player = iPlayer;
    }

    public void init() {
        ISource iSource;
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.favoriteBrowserList.init();
        this.favoritesPersistentManager.init();
        if (null != this.favoritesSearchDataProvider) {
            this.favoritesSearchDataProvider.init();
        }
        if ((iSource = this.getTerminal().getSourceController().getSource(6)) != null) {
            this.getTerminal().getSourceController().addSourceSlotListener(iSource, this, false);
        }
    }

    public void deinit() {
        ISource iSource;
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.favoriteBrowserList.deinit();
        this.favoritesPersistentManager.deinit();
        if (null != this.favoritesSearchDataProvider) {
            this.favoritesSearchDataProvider.deinit();
        }
        if ((iSource = this.getTerminal().getSourceController().getSource(6)) != null) {
            this.getTerminal().getSourceController().removeSlotListener(this.getTerminal().getSourceController().getSource(6), this);
        }
    }

    public void activate(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        MediaCapabilities mediaCapabilities = iSourceSlot.getCapabilities();
        if (!mediaCapabilities.isListHandling()) {
            this.logger.log(1000000, "[%1.activate] No browse list, no favorites possible.", (Object)LOGCLASS);
            return;
        }
        this.internalActivate(iSourceSlot);
    }

    private void internalActivate(ISourceSlot iSourceSlot) {
        boolean bl = FavoritesController.isFavoriteSupported(iSourceSlot);
        this.getChoiceModel(200950).setValue(bl ? 1 : 0);
        if (!bl) {
            this.logger.log(1000000, "[%1.activate] No favorite support for source '%2'", (Object)LOGCLASS, (long)iSourceSlot.getSource().getType());
            return;
        }
        this.favoriteBrowserList.activate(this);
        this.favoritesPersistentManager.activate(iSourceSlot);
        if (null != this.favoritesSearchDataProvider) {
            this.favoritesSearchDataProvider.activate();
        }
        this.getOptionModel(200700).setListener(this, 200601);
        this.getOptionModel(200700).setListener(this, 200640);
        this.getOptionModel(200702).setListener(this, 200598);
        this.getButtonModel(200701).setButtonListener(this);
        this.getTerminal().addActionProxyListener(23, (IActionProxyListener)this);
    }

    public void update(byte by, ISourceSlot iSourceSlot) {
        if (3 == by) {
            this.logger.log(1000000, "[%1.update] Update not relevant.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.update]", (Object)LOGCLASS);
        this.internalActivate(iSourceSlot);
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.favoriteBrowserList.deactivate();
        this.favoritesPersistentManager.deactivate();
        if (null != this.favoritesSearchDataProvider) {
            this.favoritesSearchDataProvider.deactivate();
        }
        this.getChoiceModel(200950).setValue(0);
        this.getOptionModel(200700).removeListener(200601);
        this.getOptionModel(200700).removeListener(200640);
        this.getOptionModel(200702).removeListener(200598);
        this.getButtonModel(200701).setButtonListener(null);
        this.getTerminal().removeActionProxyListener(this);
        this.favoritesList = null;
    }

    public void addFavoriteListListener(IMediaFavoriteListListener iMediaFavoriteListListener) {
        this.logger.log(1000000, "[%1.addFavoriteListListener]", (Object)LOGCLASS);
        boolean bl = this.registeredFavListListener.add(iMediaFavoriteListListener);
        if (bl && null != this.favoritesList) {
            iMediaFavoriteListListener.listChanged(this.favoritesList);
        }
    }

    public void removeFavoriteListListener(IMediaFavoriteListListener iMediaFavoriteListListener) {
        this.logger.log(1000000, "[%1.removeFavoriteListListener]", (Object)LOGCLASS);
        this.registeredFavListListener.remove(iMediaFavoriteListListener);
    }

    private void notifyFavoriteListListener(FavoritesList favoritesList) {
        this.logger.log(1000000, "[%1.notifyFavoriteListListener]", (Object)LOGCLASS);
        Iterator iterator = this.registeredFavListListener.iterator();
        while (iterator.hasNext()) {
            try {
                ((IMediaFavoriteListListener)iterator.next()).listChanged(favoritesList);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyFavoriteListListener] ", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void actionProxyCallPerformed(int n, Map map) {
        if (n == 23) {
            Integer n2 = (Integer)map.get("BROWSETYPE");
            if (null != n2 && 11 == n2) {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_BROWSER_START_BROWSING", (Object)LOGCLASS);
                this.getChoiceModel(200604).setValue(11);
            }
            this.favoriteBrowserList.reset();
        }
    }

    public IFavoritesBrowserList getFavoriteBrowserList() {
        return this.favoriteBrowserList;
    }

    private static boolean isFavoriteSupported(ISourceSlot iSourceSlot) {
        switch (iSourceSlot.getMediaType()) {
            case 9: 
            case 10: 
            case 11: {
                return true;
            }
            case 13: {
                return 10 == iSourceSlot.getSource().getType();
            }
        }
        return false;
    }

    public void updateFavorite(MediaFavorite mediaFavorite) {
        this.logger.log(1000000, "[%1.updateFavorite]", (Object)LOGCLASS);
        if (!mediaFavorite.isPlayable()) {
            ChoiceModelApp choiceModelApp;
            choiceModelApp.setValue((choiceModelApp = this.getChoiceModel(200800)).getValue() != 1 ? 1 : 2);
            this.removeFavorite(mediaFavorite);
            return;
        }
        FavoritesList favoritesList = this.favoritesList.getCopy();
        favoritesList.updateFavorite(mediaFavorite);
        this.favoritesList = favoritesList;
        this.notifyFavoriteListListener(favoritesList);
    }

    private void addFavorite(MediaFavorite mediaFavorite) {
        this.logger.log(1000000, "[%1.addFavorite]", (Object)LOGCLASS);
        FavoritesList favoritesList = this.favoritesList.getCopy();
        boolean bl = favoritesList.addFavorite(mediaFavorite);
        this.favoriteStoredSuccessfully.setValue(bl ? 0 : 1);
        this.logger.log(1000000, "[%1.addFavorite] isNewFavoriteAdded: '%2'.", (Object)LOGCLASS, (Object)(bl ? "NEW_FAVORITE_STORED" : "ITEM_IS_ALREADY_STORED"));
        this.favoritesList = favoritesList;
        this.notifyFavoriteListListener(favoritesList);
    }

    private void removeFavorite(MediaFavorite mediaFavorite) {
        this.logger.log(1000000, "[%1.removeFavorite]", (Object)LOGCLASS);
        FavoritesList favoritesList = this.favoritesList.getCopy();
        favoritesList.removeFavorite(mediaFavorite);
        this.favoritesList = favoritesList;
        this.notifyFavoriteListListener(favoritesList);
        if (favoritesList.getListSize() == 0) {
            this.logger.log(1000000, "[%1.removeFavorite] The last favorite had been removed.", (Object)LOGCLASS);
            this.showAllFavoritesDeletedPopUp();
        }
    }

    private void removeAllFavorites() {
        this.logger.log(1000000, "[%1.removeAllFavorites]", (Object)LOGCLASS);
        this.favoritesList = new FavoritesList(this.logger);
        this.notifyFavoriteListListener(this.favoritesList);
        this.showAllFavoritesDeletedPopUp();
    }

    private void showAllFavoritesDeletedPopUp() {
        this.logger.log(1000000, "[%1.showAllFavoritesRemovedPopUp] Show the 'All favourites had been deleted' pop-up.", (Object)LOGCLASS);
        ChoiceModelApp choiceModelApp = this.getChoiceModel(200703);
        choiceModelApp.setValue(choiceModelApp.getValue() != 1 ? 1 : 2);
    }

    public void listChanged(FavoritesList favoritesList) {
        this.logger.log(1000000, "[%1.listLoaded]", (Object)LOGCLASS);
        this.favoritesList = favoritesList;
        this.notifyFavoriteListListener(favoritesList.getCopy());
    }

    public void playFavoriteSelection(MediaFavorite mediaFavorite, IFavoritePlayerSelectionListener iFavoritePlayerSelectionListener) {
        this.logger.log(1000000, "[%1.playFavoriteSelection]", (Object)LOGCLASS);
        SelectionBrowser selectionBrowser = this.getTerminal().getSelectionBrowser();
        selectionBrowser.enqueueSelectionJob(new FavoriteSelectionJob(selectionBrowser, mediaFavorite, this.getTerminal().getSourceController().getSelectedSlot(), iFavoritePlayerSelectionListener, this, this.player, this.logger));
    }

    public void notifySelectionChanged(IDataSelectionContext iDataSelectionContext, boolean bl) {
        this.logger.log(1000000, "[%1.notifySelectionChanged]", (Object)LOGCLASS);
        if (!this.getTerminal().getAudioManager().hasFrontAudioFocus()) {
            this.getTerminal().getAudioManager().requestAudioFocus();
        }
        this.favoriteBrowserList.playFavoriteSelectionDone(bl);
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        this.logger.log(1000000, "[%1.keyTyped]", (Object)LOGCLASS);
        switch (n) {
            case 200700: {
                this.logger.log(1000000, "[%1.keyTyped] Add an entry.", (Object)LOGCLASS);
                switch (n2) {
                    case 200601: {
                        boolean bl;
                        int n6 = this.getChoiceModel(200628).getValue();
                        int n7 = n6 == 1 ? 0 : 1;
                        DataBrowserListRow dataBrowserListRow = (DataBrowserListRow)this.getTiledListModel(n2).getRow(n3);
                        if (dataBrowserListRow.isPlayListContent() && n7 == 0) {
                            this.addFavorite(new MediaFavorite(this.logger, dataBrowserListRow.getFolderMediaEntry(), dataBrowserListRow.getFolderStack(), 4));
                            break;
                        }
                        if (dataBrowserListRow.isFolder()) {
                            this.addFavorite(new MediaFavorite(this.logger, dataBrowserListRow.getFolderMediaEntry(), dataBrowserListRow.getFolderStack(), n7));
                            break;
                        }
                        MediaListEntry[] mediaListEntryArray = dataBrowserListRow.getFolderStack();
                        boolean bl2 = bl = this.getChoiceModel(200628).getValue() == 1;
                        if (bl && mediaListEntryArray.length == 1) {
                            this.addFavorite(new MediaFavorite(this.logger, mediaListEntryArray[0], new MediaListEntry[0], 0));
                            break;
                        }
                        if (mediaListEntryArray.length == 3 && mediaListEntryArray[1].getTitle().getI18NKey() == 5) {
                            MediaListEntry[] mediaListEntryArray2 = MediaEvoUtils.createDefaultAlbumpath(dataBrowserListRow.getFileMediaEntry().getArtist().getOriginalString());
                            MediaListEntry mediaListEntry = MediaEvoUtils.createAlbumMediaListEntry(dataBrowserListRow.getFileMediaEntry().getAlbum().getOriginalString(), dataBrowserListRow.getFileMediaEntry().getArtist().getOriginalString());
                            this.addFavorite(new MediaFavorite(this.logger, mediaListEntry, mediaListEntryArray2, 1));
                            break;
                        }
                        if (bl || mediaListEntryArray.length > 2) {
                            MediaListEntry[] mediaListEntryArray3 = new MediaListEntry[mediaListEntryArray.length - 1];
                            System.arraycopy((Object)mediaListEntryArray, 0, (Object)mediaListEntryArray3, 0, mediaListEntryArray.length - 1);
                            this.addFavorite(new MediaFavorite(this.logger, mediaListEntryArray[mediaListEntryArray.length - 1], mediaListEntryArray3, n7));
                            break;
                        }
                        MediaListEntry[] mediaListEntryArray4 = MediaEvoUtils.createDefaultAlbumpath(dataBrowserListRow.getArtist());
                        MediaListEntry mediaListEntry = MediaEvoUtils.createAlbumMediaListEntry(dataBrowserListRow.getAlbum(), dataBrowserListRow.getArtist());
                        this.addFavorite(new MediaFavorite(this.logger, mediaListEntry, mediaListEntryArray4, 1));
                        break;
                    }
                    case 200640: {
                        DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.getTiledListModel(n2).getRow(n3);
                        MediaListEntry[] mediaListEntryArray = MediaEvoUtils.createDefaultAlbumpath(dataPlayerPlayViewListRow.getArtist());
                        MediaListEntry mediaListEntry = MediaEvoUtils.createAlbumMediaListEntry(dataPlayerPlayViewListRow.getAlbum(), dataPlayerPlayViewListRow.getArtist());
                        this.addFavorite(new MediaFavorite(this.logger, mediaListEntry, mediaListEntryArray, 1));
                        break;
                    }
                }
                this.getModel(n).fireEvent(n5);
                break;
            }
            case 200702: {
                this.logger.log(1000000, "[%1.keyTyped] Remove an entry.", (Object)LOGCLASS);
                FavoritesListRow favoritesListRow = (FavoritesListRow)this.getBaseListModel(n2).getRow(n3);
                this.removeFavorite(favoritesListRow.getMediaFavorite());
                this.getModel(n).fireEvent(n5);
                break;
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == 200701) {
            this.logger.log(1000000, "[%1.keyTyped] Remove all entries.", (Object)LOGCLASS);
            this.getButtonModel(n).fireEvent(0);
            this.removeAllFavorites();
        }
    }

    public String getDiagKey() {
        return "FavoriteList";
    }

    public String getDiagValue() {
        if (null == this.favoritesList) {
            return "No favorite list";
        }
        List list = this.favoritesList.getFavoritesList();
        if (null == list || list.isEmpty()) {
            return "List is empty";
        }
        Buffer buffer = new Buffer(100);
        buffer.append("listsize=");
        buffer.append(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            buffer.append("\n");
            buffer.append(iterator.next());
        }
        return buffer.toString();
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    public void slotsChanged(ISource iSource) {
        this.logger.log(1000000, "[%1.slotsChanged]", (Object)LOGCLASS);
        ISourceSlot iSourceSlot = iSource.getSlot(0);
        if (22 == iSourceSlot.getError()) {
            this.favoritesPersistentManager.removeFavoritesForSlot(iSourceSlot);
        }
    }
}

