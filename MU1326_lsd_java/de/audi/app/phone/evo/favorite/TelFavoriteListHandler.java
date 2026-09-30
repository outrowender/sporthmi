/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.favorite;

import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.favorite.TelEvoFavoriteListRow;
import de.audi.app.phone.evo.favorite.TelFavoriteHandler;
import de.audi.atip.favorite.AbstractFavoriteListHandler;
import de.audi.atip.favorite.FavoritePersistenceHandlerBase;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;

public class TelFavoriteListHandler
extends AbstractFavoriteListHandler {
    private final LogChannel log;
    private final ITelEvoApplication application;
    private final TelFavoriteHandler favoritesHandler;

    public TelFavoriteListHandler(ITelEvoApplication iTelEvoApplication, FavoritePersistenceHandlerBase favoritePersistenceHandlerBase, BaseListModelApp baseListModelApp, LogChannel logChannel, TelFavoriteHandler telFavoriteHandler) {
        super(favoritePersistenceHandlerBase, baseListModelApp, iTelEvoApplication.getFrameworkAccess().getHMIService().getOptionModel(300774), logChannel);
        this.log = logChannel;
        this.application = iTelEvoApplication;
        this.favoritesHandler = telFavoriteHandler;
    }

    void init() {
        this.favoriteListModel.setListener(this);
        this.loadFavoritesFromPersistence();
    }

    void deinit() {
        this.favoriteListModel.clearAll();
        this.favoriteListModel.setLength(0);
        this.favoriteListModel.resetListener();
    }

    public BaseListModelApp getListModelCopy() {
        return this.favoriteListModel.getCopy();
    }

    protected void capacityReached(boolean bl) {
        this.log.log(1000000, "[TelFavoriteListHandler#capacityReached] reached=%1", bl);
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(300699).setValue(bl ? 1 : 0);
    }

    void addToFavorites(String string, String string2, int n) {
        TelEvoFavoriteListRow telEvoFavoriteListRow = new TelEvoFavoriteListRow(string, string2, TelFavoriteHandler.getNextUniqueID(), n);
        this.addToFavorites(telEvoFavoriteListRow, true);
    }

    void loadFavoriteListFromPersistence() {
        this.loadFavoritesFromPersistence();
    }

    void removeFavorite(long l) {
        TelEvoFavoriteListRow telEvoFavoriteListRow = (TelEvoFavoriteListRow)this.favoriteListModel.getRowByUniqueID(l);
        this.removeFavorite(telEvoFavoriteListRow, true);
    }

    void renameFavorite(int n, String string) {
        TelEvoFavoriteListRow telEvoFavoriteListRow = (TelEvoFavoriteListRow)this.favoriteListModel.getRow(n);
        TelEvoFavoriteListRow telEvoFavoriteListRow2 = new TelEvoFavoriteListRow(string, telEvoFavoriteListRow.getNumber(), TelFavoriteHandler.getNextUniqueID(), telEvoFavoriteListRow.getPhoneNumberType());
        this.replaceFavorite(n, telEvoFavoriteListRow2, true);
    }

    void deleteAll() {
        this.removeAllFavorites(true);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(10000000, "[TelFavoriteListHandler#itemReleased] %1", (Object)TelLoggingUtils.itemReleased(evoListRow, n, n2, n3, n4));
    }

    public void favoriteSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(1000000, "[TelFavoriteListHandler#favoriteSelected] %1", (Object)TelLoggingUtils.itemSelectedBaseList(evoListRow, n, n2, n3, n4));
        if (evoListRow instanceof TelEvoFavoriteListRow) {
            TelEvoFavoriteListRow telEvoFavoriteListRow = (TelEvoFavoriteListRow)evoListRow;
            this.application.getTelephoneDSIAccess().dialNumberFromDBEntry(telEvoFavoriteListRow.getNumber(), 0L, telEvoFavoriteListRow.getName(), (short)telEvoFavoriteListRow.getPhoneNumberType(), (short)0, null, 0, 0, n4);
        } else {
            this.log.log(100000, "[TelFavoriteListHandler#favoriteSelected] row not a TelEvoFavoriteListRow: %1", (Object)evoListRow);
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(10000000, "[TelFavoriteListHandler#itemLongSelected] %1", (Object)TelLoggingUtils.itemLongSelected(evoListRow, n, n2, n3, n4));
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(10000000, "[TelFavoriteListHandler#itemFocused] %1", (Object)TelLoggingUtils.itemLongSelected(evoListRow, n, n2, n3, n4));
    }

    protected void updatePersistence() {
        super.updatePersistence();
        this.favoritesHandler.favoritesListUpdated();
    }

    protected void loadFavoritesFromPersistence() {
        super.loadFavoritesFromPersistence();
        this.favoritesHandler.favoritesListUpdated();
    }

    int getIndexForUniqueID(long l) {
        return this.favoriteListModel.getIndexForUniqueID(l);
    }

    public void moveModeActivated() {
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(300872).setValue(1);
    }

    public void moveModeDeactivated() {
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(300872).setValue(0);
    }
}

