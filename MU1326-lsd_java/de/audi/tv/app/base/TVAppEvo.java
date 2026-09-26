/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.statemachine.ap.TVActionProxy;
import de.audi.tv.app.IScreenActionListener;
import de.audi.tv.app.TVPresetHandler;
import de.audi.tv.app.ap.TVActionProxyDistributorEvo;
import de.audi.tv.app.base.EWSPopupHandler;
import de.audi.tv.app.base.OSDUpdateTimer;
import de.audi.tv.app.base.TVAppCommon;
import de.audi.tv.app.base.TVAppEvo$ActivationHandler;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVServiceListener;
import de.audi.tv.app.base.TVStateProvider;
import de.audi.tv.app.base.TerminalModeHandler;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.FavoritesActionConfirmations;
import de.audi.tv.app.lists.FocusProvider;
import de.audi.tv.app.lists.TVEvoRowFactory;
import de.audi.tv.app.lists.TVFavoritesList;
import de.audi.tv.app.lists.favorites.FavoritesActionListener;
import de.audi.tv.app.settings.ParentalActionConfirmations;
import de.audi.tv.app.tm.TouchPadHandler;
import de.audi.tv.app.truffles.SearchHandler;
import org.osgi.framework.BundleContext;

public class TVAppEvo
extends TVAppCommon {
    final TVActionProxyDistributorEvo actionProxy;
    final TVServiceListener tvServiceListener;
    final TVStateProvider tvStateProvider;
    private final TVFavoritesList favoritesList;
    final TVPresetHandler presetHandler;
    private final OSDUpdateTimer osdUpdateTimer;
    final SearchHandler searchHandler;

    public TVAppEvo(TVEnv tVEnv, BundleContext bundleContext) {
        super(tVEnv);
        FavoritesActionListener favoritesActionListener = new FavoritesActionListener(tVEnv, this.serviceResource, 1839998720);
        this.favoritesList = new TVFavoritesList(tVEnv, this.storage, this.dsiHandler, this.mapper, this.normAreaSublist, favoritesActionListener.favoriteMoveModeListener);
        this.serviceResource.registerFavoritesList(this.favoritesList);
        this.dsiListener.setFavoritesList(this.favoritesList);
        this.focusHandler.registerFocusProvider(new FocusProvider(this.stationList, this.favoritesList));
        this.tvServiceListener = new TVServiceListener(tVEnv.lcMain, this.focusHandler, this.stateTracker.switchSourceListener, this.audioFocus, this.dsiHandler);
        this.tvStateProvider = new TVStateProvider(tVEnv.lcMain, this.storage);
        TerminalModeHandler terminalModeHandler = new TerminalModeHandler(tVEnv);
        TouchPadHandler touchPadHandler = new TouchPadHandler(tVEnv, this.tvEventDispatcher);
        this.presetHandler = new TVPresetHandler(tVEnv, this.dsiHandler, this.audioFocus, new int[]{1839998720}, null, this.sourceActivatorAdapter);
        int[] nArray = new int[]{20027, 27, 10027};
        this.searchHandler = new SearchHandler(bundleContext, tVEnv, this.dsiHandler, this.menuModelListener, this.stationList, this.favoritesList, this.focusHandler, this.mapper, -1263786240, -1297340672, -1280563456, new TVEvoRowFactory(), nArray);
        this.osdUpdateTimer = new OSDUpdateTimer(tVEnv.lcMain, this.osd.osdUpdateListener);
        this.actionProxy = new TVActionProxyDistributorEvo(tVEnv.lcHMI);
        this.actionProxy.setApListeners(new TVActionProxy[]{new TVAppEvo$ActivationHandler(this, null), terminalModeHandler.actionProxy, touchPadHandler.apListener});
        this.dsiListener.addListeners(new DefaultTVListener[]{this.tvServiceListener.tvListener, this.favoritesList.tvListener, this.tvStateProvider.tvListener, this.presetHandler.tvListener});
        this.dsiHandler.addListeners(new DSICallListener[]{this.tvServiceListener.callListener, this.favoritesList.callListener, this.presetHandler.dsiDownListener});
        this.hmiApplication.addListeners(new IScreenActionListener[]{this.searchHandler.getScreenActionListener()});
        this.tvEventDispatcher.addListener(this.tvStateProvider.tvStatusListener);
        this.tvEventDispatcher.addListener(this.osdUpdateTimer.tvListener);
        this.tvEventDispatcher.addListener(this.tvServiceListener.tvStatusListener);
        this.tvEventDispatcher.addListener(this.presetHandler.eventListener);
        this.tvEventDispatcher.addListener(this.searchHandler.getEventListener());
        this.combiBAPHandler.registerFavoritesList(this.favoritesList);
        this.combiBAPListener.registerFavoritesList(this.favoritesList);
        this.sdsServiceHandler.registerFavoritesList(this.favoritesList);
        this.sdsServiceListener.setFavoritesList(this.favoritesList);
        this.favoritesList.registerFavoritesListener(new FavoritesActionConfirmations(tVEnv));
        this.favoritesList.registerFavoritesListener(this.focusHandler);
        this.favoritesList.registerFavoritesListener(this.combiBAPHandler.listsListener);
        this.favoritesList.registerFavoritesListener(this.tvServiceListener);
        this.favoritesList.registerFavoritesListener(this.sdsServiceHandler.listsListener);
        this.favoritesList.registerFavoritesListener(this.searchHandler.getListsListener());
        this.stationList.registerListener(this.searchHandler.getListsListener());
        this.settings.addListener(new ParentalActionConfirmations(tVEnv));
        this.touchpadListener.registerTouchpadHandler(touchPadHandler);
        this.ews.registerPopupHandler(new EWSPopupHandler(tVEnv));
    }

    @Override
    public void resetSettings(boolean bl, boolean bl2) {
        super.resetSettings(bl, bl2);
        this.favoritesList.resetToDefault();
    }

    @Override
    void deinit() {
        super.deinit();
        this.tvStateProvider.deinit();
        this.searchHandler.deinit();
        this.osdUpdateTimer.deinit();
    }
}

