/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite;

import de.audi.atip.favorite.AbstractFavoriteListHandler;
import de.audi.atip.favorite.FavoritePersistenceHandlerBase;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.IFavoriteLocationFormat;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.search.AbstractNaviSearchDataProvider;
import org.dsi.ifc.global.NavLocation;

public abstract class NaviFavoriteHandler
extends AbstractFavoriteListHandler
implements INaviFavoriteHandler {
    private static final int persistenceVersion;
    private static long uniqueIdCounter;
    protected final LocationSerializer locationSerializer;
    protected final NavigationEnv env;
    protected final ICommandListFactory commandListFactory;
    protected final IPreviewMap previewMap;
    protected AbstractNaviSearchDataProvider favoriteDataProvider;
    protected final INavigationInputModeManager inputManager;
    protected final IFavoriteLocationFormat favoriteLocationFormat;

    public NaviFavoriteHandler(NavigationEnv navigationEnv, BaseListModelApp baseListModelApp, OptionModelApp optionModelApp, LocationSerializer locationSerializer, ICommandListFactory iCommandListFactory, IPreviewMap iPreviewMap) {
        super(new FavoritePersistenceHandlerBase(navigationEnv.getFramework().getStorageMgr(), 3, 1004, 991, navigationEnv.getLogChannel()), baseListModelApp, optionModelApp, navigationEnv.getLogChannel());
        this.locationSerializer = locationSerializer;
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.previewMap = iPreviewMap;
        this.inputManager = navigationEnv.getInputModeManager();
        this.favoriteLocationFormat = this.initLocationFormatForRegion();
        this.setMaxFavoriteCount(navigationEnv.getFramework().getSysConst(4440));
        this.init();
    }

    private void init() {
        this.favoriteListModel.setListener(this);
        this.loadFavoritesFromPersistence();
    }

    public void deinit() {
        this.favoriteListModel.removeAll();
        this.favoriteListModel.resetListener();
        this.favoriteDataProvider.stop();
    }

    protected abstract IFavoriteLocationFormat initLocationFormatForRegion() {
    }

    public abstract void updateNaviPersistence() {
    }

    @Override
    protected abstract void capacityReached(boolean bl) {
    }

    public static synchronized long generateUniqueID() {
        long l = uniqueIdCounter = uniqueIdCounter + 1L;
    }

    @Override
    public boolean isCapacityReached() {
        return false;
    }

    public abstract void resetMemorySettings() {
    }

    protected void resetInputMode() {
        this.env.getChoiceModel(170).setValue(0);
    }

    public void saveAsFavorite(NavLocation navLocation, String string, boolean bl) {
    }

    @Override
    public void addToFavorites(NavLocation navLocation) {
    }

    @Override
    public void saveAddressOfEditedFavorite(NavLocation navLocation) {
    }

    @Override
    public boolean isContextEditSavedFavorite() {
        return ((ChoiceModel)this.env.getChoiceModel(1579091456)).getValue() == 11;
    }

    @Override
    public boolean isContextHome() {
        return ((ChoiceModel)this.env.getChoiceModel(1579091456)).getValue() == 2;
    }

    @Override
    public boolean isContextOffice() {
        return ((ChoiceModel)this.env.getChoiceModel(1579091456)).getValue() == 8;
    }

    @Override
    public HomeAddressHandler getHomeAddressHandler() {
        return null;
    }

    @Override
    public HomeAddressHandler getOfficeAddressHandler() {
        return null;
    }

    @Override
    public void resetSavedTypeContext() {
    }

    public void resetMyScreenConfiguration() {
    }

    @Override
    public boolean handleActionDependingOnContext(NavLocation navLocation) {
        return false;
    }

    @Override
    public boolean handleActionDependingOnContext(NavLocation navLocation, String string) {
        return false;
    }

    static {
        uniqueIdCounter = 0L;
    }
}

