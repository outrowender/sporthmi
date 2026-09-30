/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.favorite;

import de.audi.atip.favorite.FavoriteListRow;
import de.audi.atip.favorite.FavoritePersistenceHandlerBase;
import de.audi.atip.favorite.IFavoriteStorage;
import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractFavoriteListHandler
implements BaseListModelListener {
    private int MAX_FAVORITES = 50;
    protected final FavoritePersistenceHandlerBase persistenceHandler;
    protected final BaseListModelApp favoriteListModel;
    protected final OptionModelApp favoriteMoveOption;
    protected final LogChannel log;
    private int nrFavorites;
    public static final int LOAD_MODE = 0;
    public static final int MOVE_MODE = 1;
    private int operationMode = 0;
    private FavoriteListRow moveRow;
    private int moveIndex;

    public AbstractFavoriteListHandler(FavoritePersistenceHandlerBase favoritePersistenceHandlerBase, BaseListModelApp baseListModelApp, OptionModelApp optionModelApp, LogChannel logChannel) {
        this.persistenceHandler = favoritePersistenceHandlerBase;
        this.favoriteListModel = baseListModelApp;
        this.favoriteMoveOption = optionModelApp;
        this.favoriteListModel.setListener(this);
        this.log = logChannel;
        if (this.favoriteMoveOption != null) {
            optionModelApp.setListener(new OptionListener(), baseListModelApp.getID());
        }
    }

    public final int getOperationMode() {
        return this.operationMode;
    }

    protected int getNrFavorites() {
        return this.nrFavorites;
    }

    protected void loadFavoritesFromPersistence() {
        this.log.log(10000000, "[AbstractFavoriteListHandler#loadFavoritesFromPersistence]");
        this.favoriteListModel.removeAll();
        IFavoriteStorage[] iFavoriteStorageArray = this.persistenceHandler.readFavorites();
        if (iFavoriteStorageArray != null) {
            this.nrFavorites = iFavoriteStorageArray.length;
            for (int i2 = 0; i2 < iFavoriteStorageArray.length; ++i2) {
                IFavoriteStorage iFavoriteStorage = iFavoriteStorageArray[i2];
                this.log.log(1000000, "[AbstractFavoriteListHandler#loadFavoritesFromPersistence] read favorite %1", (Object)iFavoriteStorage);
                this.favoriteListModel.append(iFavoriteStorage.getFavoriteListRow());
            }
            if (this.nrFavorites >= this.MAX_FAVORITES) {
                this.capacityReached(true);
            } else {
                this.capacityReached(false);
            }
        }
    }

    protected void addToFavorites(FavoriteListRow favoriteListRow, boolean bl) {
        this.log.log(10000000, "[AbstractFavoriteListHandler#addToFavorites] favoriteListRow=%1", (Object)favoriteListRow);
        if (this.nrFavorites < this.MAX_FAVORITES) {
            this.favoriteListModel.append(favoriteListRow);
            if (bl) {
                this.updatePersistence();
            }
            ++this.nrFavorites;
        }
        if (this.nrFavorites >= this.MAX_FAVORITES) {
            this.capacityReached(true);
        }
    }

    protected abstract void capacityReached(boolean var1);

    protected void removeFavorite(FavoriteListRow favoriteListRow, boolean bl) {
        if (this.nrFavorites == this.MAX_FAVORITES) {
            this.capacityReached(false);
        }
        this.favoriteListModel.remove(favoriteListRow);
        if (bl) {
            this.updatePersistence();
        }
        --this.nrFavorites;
    }

    protected void replaceFavorite(int n, FavoriteListRow favoriteListRow, boolean bl) {
        this.favoriteListModel.setRow(n, favoriteListRow);
        if (bl) {
            this.updatePersistence();
        }
    }

    protected void removeAllFavorites(boolean bl) {
        this.favoriteListModel.removeAll();
        this.nrFavorites = 0;
        this.capacityReached(false);
        if (bl) {
            this.updatePersistence();
        }
    }

    protected void isFavorite(long l) {
        this.favoriteListModel.contains(l);
    }

    protected void updatePersistence() {
        List list = this.favoriteListModel.asList();
        Iterator iterator = this.favoriteListModel.asList().iterator();
        IFavoriteStorage[] iFavoriteStorageArray = new IFavoriteStorage[list.size()];
        int n = 0;
        while (iterator.hasNext()) {
            FavoriteListRow favoriteListRow = (FavoriteListRow)iterator.next();
            IFavoriteStorage iFavoriteStorage = favoriteListRow != null ? favoriteListRow.getIFavorite() : null;
            iFavoriteStorageArray[n++] = iFavoriteStorage;
        }
        this.persistenceHandler.storeFavorites(iFavoriteStorageArray);
    }

    protected abstract void favoriteSelected(EvoListRow var1, int var2, int var3, int var4, int var5);

    public void moveModeActivated() {
    }

    public void moveModeDeactivated() {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(100000000, "AbstractFavoriteListHandler#itemSelected row = %1, operationMode = %2", (Object)evoListRow, (long)this.operationMode);
        if (this.operationMode == 0) {
            this.favoriteSelected(evoListRow, n, n2, n3, n4);
        } else if (n2 != this.moveIndex) {
            BaseListModelApp baseListModelApp = this.favoriteListModel.getCopy();
            long l = evoListRow.getUniqueID();
            if (n2 < this.moveIndex) {
                baseListModelApp.remove(this.moveRow);
                baseListModelApp.insertBefore(l, this.moveRow);
            } else if (n2 > this.moveIndex) {
                baseListModelApp.remove(this.moveRow);
                baseListModelApp.insertAfter(l, this.moveRow);
            }
            this.favoriteListModel.update(baseListModelApp);
            this.operationMode = 0;
            this.updatePersistence();
            this.favoriteListModel.trigger(ModelTrigger.DEACTIVATE_MOVE_MODE);
            this.moveModeDeactivated();
        } else {
            this.favoriteListModel.trigger(ModelTrigger.DEACTIVATE_MOVE_MODE);
            this.moveModeDeactivated();
            this.operationMode = 0;
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(100000000, "AbstractFavoriteListHandler#itemReleased row = %1", (Object)evoListRow);
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(100000000, "AbstractFavoriteListHandler#itemLongSelected row = %1", (Object)evoListRow);
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(100000000, "AbstractFavoriteListHandler#itemFocused row = %1", (Object)evoListRow);
    }

    protected final void setMaxFavoriteCount(int n) {
        this.MAX_FAVORITES = n;
    }

    private class OptionListener
    extends DefaultOptionListener {
        private OptionListener() {
        }

        public void keyTyped(int n, int n2, int n3, int n4, int n5) {
            AbstractFavoriteListHandler.this.log.log(100000000, "AbstractFavoriteListHandler#keyPressed modelID = %1, targetModelID = %2, targetRow = %3", (long)n, (long)n2, (long)n3);
            if (n == AbstractFavoriteListHandler.this.favoriteMoveOption.getID()) {
                AbstractFavoriteListHandler.this.operationMode = 1;
                AbstractFavoriteListHandler.this.moveRow = (FavoriteListRow)AbstractFavoriteListHandler.this.favoriteListModel.getRow(n3);
                AbstractFavoriteListHandler.this.moveIndex = AbstractFavoriteListHandler.this.favoriteListModel.getIndexForUniqueID(AbstractFavoriteListHandler.this.moveRow.getUniqueID());
                AbstractFavoriteListHandler.this.favoriteListModel.trigger(ModelTrigger.ACTIVATE_MOVE_MODE);
                AbstractFavoriteListHandler.this.moveModeActivated();
                AbstractFavoriteListHandler.this.favoriteMoveOption.fireEvent(n5);
            }
        }
    }
}

