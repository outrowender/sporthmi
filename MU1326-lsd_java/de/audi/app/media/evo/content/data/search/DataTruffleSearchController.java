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
    private static final String SEARCH_LOGGER;
    private static final String LOGCLASS;
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
        this.logger = iMediaTerminal.getFramework().getLogChannel("App.Media.Search");
        this.mediaSearch = new DataMediaSearch(this.getTerminal().getServiceManager().getBundleContext(), this.getTerminal().getFramework(), this.logger);
        this.globalSearchHandler = new GlobalSearchHandler(this.logger, this.getBaseListModel(0x11100300), this.getSpellerModel(-770768128), this.getChoiceModel(-737213696), this.getLabelModel(-720436480), this.getChoiceModel(-787545344), this.getResourceLocatorModel(-804322560), this.mediaSearch, iDataBrowserList, this.getChoiceModel(756024064), this.getChoiceModel(-1643052288), iMediaTerminal);
        this.localSearchHandler = new LocalSearchHandler(this.logger, this.getBaseListModel(0x10100300), this.getSpellerModel(-1341193472), this.getChoiceModel(-1307639040), this.getLabelModel(-1290861824), this.getChoiceModel(-1357970688), this.getResourceLocatorModel(-804322560), this.mediaSearch, iDataBrowserList, this.getChoiceModel(739246848), this.getChoiceModel(1762657024));
        this.browserGlobalSearchHandler = new BrowserGlobalSearchHandler(this.logger, this.getBaseListModel(0x10100300), this.getSpellerModel(-1341193472), this.getChoiceModel(-1307639040), this.getLabelModel(-1290861824), this.getChoiceModel(-1357970688), this.getResourceLocatorModel(-804322560), this.mediaSearch, iDataBrowserList, this.getChoiceModel(739246848), this.getChoiceModel(1762657024), this.getChoiceModel(-1643052288), iMediaTerminal);
        this.favoritesSearchHandler = new FavoritesSearchHandler(this.logger, this.getBaseListModel(252707584), this.getSpellerModel(34603776), this.getChoiceModel(0x3100300), this.getChoiceModel(-1357970688), this.mediaSearch, iFavoritesBrowserList, this.getChoiceModel(739246848));
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"DataTruffleSearchController");
        this.mediaSearch.init();
        this.globalSearchHandler.init();
        this.localSearchHandler.init();
        this.browserGlobalSearchHandler.init();
        this.dataBrowserList.addBrowseListChangeListener(this);
        this.favoritesSearchHandler.init();
        this.getTerminal().addActionProxyListener(new int[]{26, 25, 29, 37, 39, 23}, (IActionProxyListener)this);
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"DataTruffleSearchController");
        this.getTerminal().removeActionProxyListener(this);
        this.globalSearchHandler.deinit();
        this.localSearchHandler.deinit();
        this.browserGlobalSearchHandler.deinit();
        this.favoritesSearchHandler.deinit();
        this.mediaSearch.deinit();
    }

    public void activate(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.activate]", (Object)"DataTruffleSearchController");
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
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"DataTruffleSearchController");
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

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        block0 : switch (n) {
            case 39: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] BROWSER_START_SEARCH_BROWSING", (Object)"DataTruffleSearchController");
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
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] Type not supported.", (Object)"DataTruffleSearchController");
                break;
            }
            case 26: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] BROWSER_TRUFFLE_DISABLE", (Object)"DataTruffleSearchController");
                this.localSearchHandler.reset();
                this.browserGlobalSearchHandler.reset();
                this.favoritesSearchHandler.reset();
                break;
            }
            case 25: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] PLAYER_NEW_SEARCH", (Object)"DataTruffleSearchController");
                this.globalSearchHandler.reset();
                this.mediaSearch.setActiveGuiSearchHandler(this.globalSearchHandler);
                break;
            }
            case 29: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_BROWSER_TRUFFLE_DISABLE_ANIM_WAIT", (Object)"DataTruffleSearchController");
                this.waitForFadedOut = true;
                break;
            }
            case 37: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_SCREEN_FADED_OUT", (Object)"DataTruffleSearchController");
                if (!this.waitForFadedOut) break;
                this.waitForFadedOut = false;
                this.localSearchHandler.reset();
                this.favoritesSearchHandler.reset();
                this.browserGlobalSearchHandler.reset();
                break;
            }
            case 23: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] BROWSER_START_BROWSING", (Object)"DataTruffleSearchController");
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
                        this.logger.log(1078071040, "[%1.actionProxyCallPerformed] Ignored for all Browsertypes but Favorites.", (Object)"DataTruffleSearchController");
                        break block0;
                    }
                    case 11: {
                        this.logger.log(1078071040, "[%1.actionProxyCallPerformed] AP_CONST_BROWSERTYPE_FAVORITS", (Object)"DataTruffleSearchController");
                        this.favoritesSearchHandler.reset();
                        this.mediaSearch.setActiveGuiSearchHandler(this.favoritesSearchHandler);
                        this.globalSearchHandler.reset();
                        this.browserGlobalSearchHandler.reset();
                        break block0;
                    }
                }
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] Type not supported.", (Object)"DataTruffleSearchController");
                break;
            }
        }
    }

    @Override
    public void browseListTypeChanged(int n) {
    }

    @Override
    public void browseListLayoutChanged(int n) {
    }

    @Override
    public void browseListCategorySelected(int n) {
        this.logger.log(1078071040, "[%1.browseListCategorySelected] %2", (Object)"DataTruffleSearchController", (long)n);
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
                if (this.getChoiceModel(1762657024).getValue() == 0) {
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
                this.logger.log(1078071040, "[%1.browseListCategorySelected] category not supported.", (Object)"DataTruffleSearchController");
            }
        }
    }

    @Override
    public void lastBrowseListCategoryChanged(int n) {
    }
}

