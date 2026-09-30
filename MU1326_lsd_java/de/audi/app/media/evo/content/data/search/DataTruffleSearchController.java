/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.data.search.DataMediaSearch;
import de.audi.app.media.evo.content.data.IDataBrowserList;
import de.audi.app.media.evo.content.data.IDataBrowserListChangeListener;
import de.audi.app.media.evo.content.data.favorites.FavoritesSearchHandler;
import de.audi.app.media.evo.content.data.favorites.IFavoritesBrowserList;
import de.audi.app.media.evo.content.data.search.AbstractSearchHandlerEvo;
import de.audi.app.media.evo.content.data.search.BrowserGlobalSearchHandler;
import de.audi.app.media.evo.content.data.search.GlobalSearchHandler;
import de.audi.app.media.evo.content.data.search.LocalSearchHandler;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;
import java.util.Map;

public class DataTruffleSearchController
extends AbstractMediaTerminalComponent
implements IActionProxyListener,
IDataBrowserListChangeListener {
    private static final String SEARCH_LOGGER = "App.Media.Search";
    private static final String LOGCLASS = "DataTruffleSearchController";
    private final LogChannel logger;
    private final DataMediaSearch mediaSearch;
    private final AbstractSearchHandlerEvo globalSearchHandler;
    private final AbstractSearchHandlerEvo browserGlobalSearchHandler;
    private final LocalSearchHandler localSearchHandler;
    private final FavoritesSearchHandler favoritesSearchHandler;
    private volatile boolean waitForFadedOut;
    private final IDataBrowserList dataBrowserList;
    private volatile ISourceSlot activeSlot = null;

    public DataTruffleSearchController(IMediaTerminal iMediaTerminal, IDataBrowserList iDataBrowserList, IFavoritesBrowserList iFavoritesBrowserList) {
        super(iMediaTerminal);
        this.dataBrowserList = iDataBrowserList;
        this.logger = iMediaTerminal.getFramework().getLogChannel(SEARCH_LOGGER);
        this.mediaSearch = new DataMediaSearch(this.getTerminal().getServiceManager().getBundleContext(), this.getTerminal().getFramework(), this.logger);
        this.globalSearchHandler = new GlobalSearchHandler(this.logger, this.getBaseListModel(200721), this.getSpellerModel(200658), this.getChoiceModel(200660), this.getLabelModel(200661), this.getChoiceModel(200657), this.getResourceLocatorModel(200656), this.mediaSearch, iDataBrowserList, this.getChoiceModel(200749), this.getChoiceModel(201118), iMediaTerminal);
        this.localSearchHandler = new LocalSearchHandler(this.logger, this.getBaseListModel(200720), this.getSpellerModel(200624), this.getChoiceModel(200626), this.getLabelModel(200627), this.getChoiceModel(200623), this.getResourceLocatorModel(200656), this.mediaSearch, iDataBrowserList, this.getChoiceModel(200748), this.getChoiceModel(200809));
        this.browserGlobalSearchHandler = new BrowserGlobalSearchHandler(this.logger, this.getBaseListModel(200720), this.getSpellerModel(200624), this.getChoiceModel(200626), this.getLabelModel(200627), this.getChoiceModel(200623), this.getResourceLocatorModel(200656), this.mediaSearch, iDataBrowserList, this.getChoiceModel(200748), this.getChoiceModel(200809), this.getChoiceModel(201118), iMediaTerminal);
        this.favoritesSearchHandler = new FavoritesSearchHandler(this.logger, this.getBaseListModel(200719), this.getSpellerModel(200706), this.getChoiceModel(200707), this.getChoiceModel(200623), this.mediaSearch, iFavoritesBrowserList, this.getChoiceModel(200748));
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.mediaSearch.init();
        this.globalSearchHandler.init();
        this.localSearchHandler.init();
        this.browserGlobalSearchHandler.init();
        this.dataBrowserList.addBrowseListChangeListener(this);
        this.favoritesSearchHandler.init();
        this.getTerminal().addActionProxyListener(new int[]{26, 25, 29, 37, 39, 23}, (IActionProxyListener)this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.getTerminal().removeActionProxyListener(this);
        this.globalSearchHandler.deinit();
        this.localSearchHandler.deinit();
        this.browserGlobalSearchHandler.deinit();
        this.favoritesSearchHandler.deinit();
        this.mediaSearch.deinit();
    }

    public void activate(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.localSearchHandler.activate(iSourceSlot);
        this.globalSearchHandler.activate();
        this.browserGlobalSearchHandler.activate();
        this.favoritesSearchHandler.activate();
        this.activeSlot = iSourceSlot;
        this.getTerminal().getSourceController().addSourceSlotListener(this.activeSlot.getSource(), this.localSearchHandler, true);
        this.activeSlot = iSourceSlot;
        this.mediaSearch.activate();
        this.mediaSearch.setActiveGuiSearchHandler(this.globalSearchHandler);
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.localSearchHandler.deactivate();
        if (this.activeSlot != null) {
            this.getTerminal().getSourceController().removeSlotListener(this.activeSlot.getSource(), this.localSearchHandler);
        }
        this.activeSlot = null;
        this.globalSearchHandler.deactivate();
        this.browserGlobalSearchHandler.deactivate();
        this.favoritesSearchHandler.deactivate();
        this.mediaSearch.deactivate();
    }

    public void actionProxyCallPerformed(int n, Map map) {
        block0 : switch (n) {
            case 39: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] BROWSER_START_SEARCH_BROWSING", (Object)LOGCLASS);
                Integer n2 = (Integer)map.get("BROWSETYPE");
                switch (n2) {
                    case 1: 
                    case 8: 
                    case 9: 
                    case 10: {
                        this.localSearchHandler.reset();
                        this.mediaSearch.setActiveGuiSearchHandler(this.localSearchHandler);
                        this.browserGlobalSearchHandler.reset();
                        break block0;
                    }
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: {
                        this.localSearchHandler.reset();
                        this.browserGlobalSearchHandler.reset();
                        this.mediaSearch.setActiveGuiSearchHandler(this.browserGlobalSearchHandler);
                        break block0;
                    }
                    case 11: {
                        this.favoritesSearchHandler.reset();
                        this.mediaSearch.setActiveGuiSearchHandler(this.favoritesSearchHandler);
                        this.globalSearchHandler.reset();
                        this.browserGlobalSearchHandler.reset();
                        break block0;
                    }
                }
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] Type not supported.", (Object)LOGCLASS);
                break;
            }
            case 26: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] BROWSER_TRUFFLE_DISABLE", (Object)LOGCLASS);
                this.localSearchHandler.reset();
                this.browserGlobalSearchHandler.reset();
                this.favoritesSearchHandler.reset();
                break;
            }
            case 25: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] PLAYER_NEW_SEARCH", (Object)LOGCLASS);
                this.globalSearchHandler.reset();
                this.mediaSearch.setActiveGuiSearchHandler(this.globalSearchHandler);
                break;
            }
            case 29: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_BROWSER_TRUFFLE_DISABLE_ANIM_WAIT", (Object)LOGCLASS);
                this.waitForFadedOut = true;
                break;
            }
            case 37: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] AP_METHOD_SCREEN_FADED_OUT", (Object)LOGCLASS);
                if (!this.waitForFadedOut) break;
                this.waitForFadedOut = false;
                this.localSearchHandler.reset();
                this.favoritesSearchHandler.reset();
                this.browserGlobalSearchHandler.reset();
                break;
            }
            case 23: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] BROWSER_START_BROWSING", (Object)LOGCLASS);
                Integer n3 = (Integer)map.get("BROWSETYPE");
                switch (n3) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 9: 
                    case 10: {
                        this.logger.log(1000000, "[%1.actionProxyCallPerformed] Ignored for all Browsertypes but Favorites.", (Object)LOGCLASS);
                        break block0;
                    }
                    case 11: {
                        this.logger.log(1000000, "[%1.actionProxyCallPerformed] AP_CONST_BROWSERTYPE_FAVORITS", (Object)LOGCLASS);
                        this.favoritesSearchHandler.reset();
                        this.mediaSearch.setActiveGuiSearchHandler(this.favoritesSearchHandler);
                        this.globalSearchHandler.reset();
                        this.browserGlobalSearchHandler.reset();
                        break block0;
                    }
                }
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] Type not supported.", (Object)LOGCLASS);
                break;
            }
        }
    }

    public void browseListTypeChanged(int n) {
    }

    public void browseListLayoutChanged(int n) {
    }

    public void browseListCategorySelected(int n) {
        this.logger.log(1000000, "[%1.browseListCategorySelected] %2", (Object)LOGCLASS, (long)n);
        switch (n) {
            case 1: 
            case 8: 
            case 9: 
            case 10: 
            case 12: {
                this.localSearchHandler.reset();
                this.mediaSearch.setActiveGuiSearchHandler(this.localSearchHandler);
                this.browserGlobalSearchHandler.reset();
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                if (this.getChoiceModel(200809).getValue() == 0) {
                    this.localSearchHandler.reset();
                    this.browserGlobalSearchHandler.reset();
                }
                this.mediaSearch.setActiveGuiSearchHandler(this.browserGlobalSearchHandler);
                break;
            }
            case 11: {
                this.favoritesSearchHandler.reset();
                this.mediaSearch.setActiveGuiSearchHandler(this.favoritesSearchHandler);
                this.browserGlobalSearchHandler.reset();
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.browseListCategorySelected] category not supported.", (Object)LOGCLASS);
            }
        }
    }

    public void lastBrowseListCategoryChanged(int n) {
    }
}

