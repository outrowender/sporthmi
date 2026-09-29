/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.IResetSettingsListener;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.app.media.evo.content.data.favorites.FavoritesList;
import de.audi.app.media.evo.content.data.favorites.IFavoritesController;
import de.audi.app.media.evo.content.data.favorites.IMediaFavoriteListListener;
import de.audi.app.media.evo.content.data.favorites.persistent.FavoriteHeaderStorage;
import de.audi.app.media.evo.content.data.favorites.persistent.FavoriteListStorage;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;

public class FavoritesPersistentManager
implements IMediaFavoriteListListener,
IResetSettingsListener,
IDiagnosisDataProvider {
    private static final String LOGCLASS;
    private final IMediaTerminal terminal;
    private final LogChannel logger;
    private final IFavoritesController favoritesController;
    private final FavoriteHeaderStorage favoriteHeader;
    private volatile FavoriteListStorage favoriteListStorage;

    public FavoritesPersistentManager(IMediaTerminal iMediaTerminal, IFavoritesController iFavoritesController) {
        this.terminal = iMediaTerminal;
        this.logger = iMediaTerminal.getLogger().main();
        this.favoritesController = iFavoritesController;
        this.favoriteHeader = new FavoriteHeaderStorage(iMediaTerminal);
        iMediaTerminal.getDiagnosisManager().addDataProvider(-1, this);
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"FavoritesPersistentManager");
        this.favoriteHeader.loadFavoriteHeader();
        this.terminal.addResetSettingsListener(this);
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"FavoritesPersistentManager");
    }

    public void activate(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.activate]", (Object)"FavoritesPersistentManager");
        this.favoritesController.addFavoriteListListener(this);
        this.favoritesController.listChanged(this.loadFromPersistents((MediaSourceSlot)iSourceSlot));
    }

    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"FavoritesPersistentManager");
        this.favoritesController.removeFavoriteListListener(this);
    }

    @Override
    public void listChanged(FavoritesList favoritesList) {
        this.logger.log(1078071040, "[%1.listChanged]", (Object)"FavoritesPersistentManager");
        this.favoriteListStorage.setFavoriteList(favoritesList);
        if (favoritesList.getListSize() > 0) {
            this.favoriteHeader.updateLastUsed(this.favoriteListStorage.getPersistentKey());
        }
    }

    private FavoritesList loadFromPersistents(MediaSourceSlot mediaSourceSlot) {
        this.logger.log(1078071040, "[%1.loadFromPersistents]", (Object)"FavoritesPersistentManager");
        int n = this.favoriteHeader.getPersistentKey(mediaSourceSlot.getSource().getType(), mediaSourceSlot.getUniqueMediaId());
        if (-1 == n) {
            n = this.favoriteHeader.getNewPersistentKey(mediaSourceSlot.getSource().getType(), mediaSourceSlot.getUniqueMediaId());
            this.favoriteListStorage = new FavoriteListStorage(this.terminal, n);
            return new FavoritesList(this.logger);
        }
        if (null == this.favoriteListStorage || n != this.favoriteListStorage.getPersistentKey()) {
            this.favoriteListStorage = new FavoriteListStorage(this.terminal, n);
        }
        FavoritesList favoritesList = this.favoriteListStorage.getFavoriteList();
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "[%1.loadFromPersistents] listsize='%2'", (Object)"FavoritesPersistentManager", (long)favoritesList.getListSize());
            Iterator iterator = favoritesList.getFavoritesList().iterator();
            while (iterator.hasNext()) {
                this.logger.log(-2137614336, "[%1.loadFromPersistents] %2", (Object)"FavoritesPersistentManager", iterator.next());
            }
        }
        return favoritesList;
    }

    @Override
    public void onResetSettings(int n) {
        this.logger.log(1078071040, "[%1.onResetSettings]", (Object)"FavoritesPersistentManager");
        this.resetAllLists();
        this.favoriteHeader.resetFavoriteHeader();
        ISourceSlot iSourceSlot = this.terminal.getSourceController().getSelectedSlot();
        if (11 == iSourceSlot.getMediaType() || 9 == iSourceSlot.getMediaType() || 10 == iSourceSlot.getMediaType()) {
            this.favoritesController.listChanged(this.loadFromPersistents((MediaSourceSlot)iSourceSlot));
        }
    }

    public void removeFavoritesForSlot(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.removeFavoritesForSlot] %2", (Object)"FavoritesPersistentManager", (Object)iSourceSlot);
        int n = this.favoriteHeader.getPersistentKey(iSourceSlot.getSource().getType(), iSourceSlot.getUniqueMediaId());
        if (-1 == n) {
            return;
        }
        new FavoriteListStorage(this.terminal, n).clearList();
        ISourceSlot iSourceSlot2 = this.terminal.getSourceController().getSelectedSlot();
        if (((Object)iSourceSlot).equals(iSourceSlot2)) {
            this.favoritesController.listChanged(this.loadFromPersistents((MediaSourceSlot)iSourceSlot));
        }
    }

    private void resetAllLists() {
        this.logger.log(1078071040, "[%1.resetAllLists]", (Object)"FavoritesPersistentManager");
        for (int i2 = 0; i2 < 10; ++i2) {
            new FavoriteListStorage(this.terminal, FavoriteHeaderStorage.getPersistentKeyByIndex(i2)).clearList();
        }
    }

    @Override
    public String getDiagKey() {
        return "FavoriteHeader";
    }

    @Override
    public String getDiagValue() {
        FavoriteHeaderStorage favoriteHeaderStorage = this.favoriteHeader;
        return favoriteHeaderStorage.toString();
    }
}

