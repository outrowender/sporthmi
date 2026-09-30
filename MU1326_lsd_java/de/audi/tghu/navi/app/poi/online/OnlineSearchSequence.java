/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.ShowOnlineResultsCommand;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener;
import de.audi.tghu.navi.app.command.poi.online.OnlinePoiCommandList;
import de.audi.tghu.navi.app.command.poi.online.OnlinePoiCommandListFactory;
import de.audi.tghu.navi.app.command.poi.online.OnlinePoiCommandListSupplier;
import de.audi.tghu.navi.app.command.poi.online.OnlineSearchCommand;
import de.audi.tghu.navi.app.command.poi.online.OnlineSearchNextOrPreviousResultsCommand;
import de.audi.tghu.navi.app.command.poi.online.OnlineSearchSetLanguageCommand;
import de.audi.tghu.navi.app.command.poi.online.OnlineSearchUsedPoiCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.poi.online.OnlineSearchContext;
import de.audi.tghu.navi.app.poi.online.OnlineSearchUpdateMapCommand;
import de.audi.tghu.navi.app.poi.online.PoiOnlineSearchArea;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class OnlineSearchSequence {
    private static final String CLASS_NAME = (class$de$audi$tghu$navi$app$poi$online$OnlineSearchSequence == null ? (class$de$audi$tghu$navi$app$poi$online$OnlineSearchSequence = OnlineSearchSequence.class$("de.audi.tghu.navi.app.poi.online.OnlineSearchSequence")) : class$de$audi$tghu$navi$app$poi$online$OnlineSearchSequence).getName();
    public static final int ERRORCODE_UNDEFINED = 0;
    public static final int MAX_LIST_REQUEST = 10;
    private IOnlineSearchForm form;
    private LogChannel logChannel;
    protected OnlinePoiCommandListFactory commandListFactory;
    private OnlineDSIPoiListener poiListener;
    private IFrameworkAccess fw;
    private NavigationEnv env;
    public static final int SEARCH_AREA_VICINITY = 0;
    public static final int SEARCH_AREA_DESTINATION = 1;
    public static final int DIRECTION_PREV = 0;
    public static final int DIRECTION_NEXT = 1;
    private int currentResultIndex = -1;
    private OnlineSearchContext onlineSearchContext;
    private PoiOnlineSearchArea searchArea;
    private final IPreviewMap previewMap;
    private final ICommandListFactory naviCommandListFactory;
    private final IVehicle vehicle;
    private final IRouteManager routeManager;
    private boolean isSpellerOpen;
    private PoiOnlineSearchValuelist valueList;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$poi$online$OnlineSearchSequence;

    public OnlineSearchSequence(IVehicle iVehicle, LogChannel logChannel, IFrameworkAccess iFrameworkAccess, PoiOnlineSearchArea poiOnlineSearchArea, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IRouteManager iRouteManager, NavigationEnv navigationEnv) {
        this.vehicle = iVehicle;
        this.logChannel = logChannel;
        this.fw = iFrameworkAccess;
        this.env = navigationEnv;
        this.searchArea = poiOnlineSearchArea;
        this.previewMap = iPreviewMap;
        this.naviCommandListFactory = iCommandListFactory;
        this.routeManager = iRouteManager;
        logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#OnlineSearchSequence").toString());
    }

    public void init(IOnlineSearchForm iOnlineSearchForm) {
        this.form = iOnlineSearchForm;
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#init").toString());
        CommandListManager commandListManager = new CommandListManager("Online Poi Command Lists", this.fw, this.logChannel, new OnlinePoiCommandListSupplier(this.logChannel, this.env), null);
        this.poiListener = new OnlineDSIPoiListener(commandListManager, this.logChannel);
        this.commandListFactory = new OnlinePoiCommandListFactory(commandListManager, this.poiListener, this.form, this.onlineSearchContext);
        commandListManager.start();
        this.onlineSearchContext = new OnlineSearchContext(this.logChannel);
        this.onlineSearchContext.setSearchArea(this.searchArea);
    }

    public void requestValueList(int n) {
        this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("#requestValueList( %1 )").toString(), (long)n);
        this.form.clearResultList();
        int n2 = 0;
        int n3 = this.onlineSearchContext.getIndexOfCurrentFirstItem();
        if (n == 0) {
            this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("requestValueList DIRECTION_PREV").toString());
            n2 = n3 - 10 < 0 ? 0 : n3 - 10;
        } else {
            this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("requestValueList DIRECTION NEXT modelAccess.getResultsLength() %1 indexOfCurrentFirstItem %2").toString(), (long)this.onlineSearchContext.getResultsLength(), (long)n3);
            int n4 = this.onlineSearchContext.getResultsLength();
            n2 = n3 + n4;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new OnlineSearchNextOrPreviousResultsCommand(this.logChannel, n2, this.form, this.onlineSearchContext));
        commandList.execute("OnlineSearchSequence#getNextOrPreviousPage");
    }

    public void startSearch(String string, boolean bl) {
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#startSearch").toString());
        this.form.clearResultList();
        this.form.setSearchTextLabel(string);
        this.form.resetSpellingSuggestion();
        NavLocation navLocation = null;
        if (this.onlineSearchContext != null && this.onlineSearchContext.getSearchArea() != null) {
            this.updateSearchArea(this.onlineSearchContext.getSearchArea());
            navLocation = this.onlineSearchContext.getSearchArea().getNavLocation();
        }
        if (string == null || string.length() == 0) {
            this.logChannel.log(100000, new StringBuffer().append(CLASS_NAME).append("startSearch( %1 ) - searchString is empty!").toString(), (Object)string);
            this.form.indicateError(0, "0");
            return;
        }
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("startSearch( %1 ) - preparing searchContext: %2").toString(), (Object)string, (Object)LocationFormatter.formatLocationShort(navLocation));
        if (navLocation == null && !this.fw.isTarget()) {
            this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("startSearch( %1 ) - PCSim fake").toString(), (Object)string);
            int n = NavigationUtilities.degreeToWgs84(11.0);
            int n2 = NavigationUtilities.degreeToWgs84(49.0);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new OnlineSearchCommand(this.logChannel, string, n, n2, bl, this.form, this.onlineSearchContext));
            commandList.execute("OnlineSearch#startSearch");
        } else if (navLocation == null) {
            this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("startSearch( %1 ) - searchContext is null!").toString(), (Object)string);
            this.form.indicateError(0, "0");
        } else {
            this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("startSearch( %1 ) - searchContext: %2").toString(), (Object)string, (Object)LocationFormatter.formatLocationShort(navLocation));
            int n = navLocation.getLongitude();
            int n3 = navLocation.getLatitude();
            Language language = this.fw.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI");
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new OnlineSearchSetLanguageCommand(this.logChannel, language));
            commandList.add(new OnlineSearchCommand(this.logChannel, string, n, n3, bl, this.form, this.onlineSearchContext));
            commandList.execute("OnlineSearch#startSearch");
        }
    }

    public void abortSearch() {
        this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("#abortSearch").toString());
        CommandList commandList = this.commandListFactory.createCommandList();
        if (commandList instanceof OnlinePoiCommandList) {
            OnlinePoiCommandList onlinePoiCommandList = (OnlinePoiCommandList)commandList;
            this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("abortSearch(): poiStopSelection").toString());
            onlinePoiCommandList.getOnlineSearch().poiStopSelection();
        }
    }

    public void markCurrentResultUsedFor(int n) {
        this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("#markCurrentResultUsedFor( %1 )").toString(), (long)n);
        OnlinePOIResultList onlinePOIResultList = this.onlineSearchContext.getResultList();
        if (onlinePOIResultList == null) {
            this.logChannel.log(10000, new StringBuffer().append(CLASS_NAME).append("markCurrentResultUsedFor( %1 ): not initialized").toString(), (long)n);
            return;
        }
        PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = onlinePOIResultList.getPOIElementAt(this.currentResultIndex);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new OnlineSearchUsedPoiCommand(this.logChannel, poiOnlineSearchValuelistElement, n));
        commandList.execute("OnlineSearch#usedPoi");
    }

    public void startGuidance(NavLocation navLocation, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, boolean bl) {
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#startGuidance").toString());
        iStartGuidanceToDestinationSequence.start(navLocation, bl);
    }

    public CommandList refreshDetailsFor(final int n) {
        this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("#refreshDetailsFor( %1 )").toString(), (long)n);
        this.currentResultIndex = n;
        final OnlinePOIResultList onlinePOIResultList = this.onlineSearchContext.getResultList();
        this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("refreshDetailsFor( %1 ): Command list factory is %1").toString(), (Object)this.naviCommandListFactory.getClass().getName());
        CommandList commandList = this.naviCommandListFactory.createCommandList();
        if (onlinePOIResultList != null) {
            commandList.add(onlinePOIResultList.resolveEntry(n, this.naviCommandListFactory));
            commandList.add(new NavCommand("OnlineSearchSequence#resolveEntry"){

                public void execute() {
                    OnlineSearchSequence.this.logChannel.log(1000000, "OnlineSearchRequest#CMD_resolveEntry: resolving index %1", (long)n);
                    PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = onlinePOIResultList.getPOIElementAt(n);
                    NavLocation navLocation = onlinePOIResultList.getTransformedLocationAt(n);
                    OnlineSearchSequence.this.form.updateSelectedOnlineDetails(onlinePOIResultList, poiOnlineSearchValuelistElement, navLocation, n);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.add(new OnlineSearchUpdateMapCommand(this.logChannel, onlinePOIResultList, this.searchArea, n, this.previewMap));
        }
        return commandList;
    }

    public OnlinePoiCommandListFactory getCommandListFactory() {
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#getCommandListFactory").toString());
        return this.commandListFactory;
    }

    public OnlineDSIPoiListener getPoiListener() {
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#getPoiListener").toString());
        return this.poiListener;
    }

    public void setLanguage(Language language) {
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#setLanguage: %1").toString(), (Object)language);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new OnlineSearchSetLanguageCommand(this.logChannel, language));
        commandList.execute("OnlineSearchSequence#setLanguage");
    }

    public OnlineSearchContext getSearchContext() {
        return this.onlineSearchContext;
    }

    public boolean setSearchArea(int n, NavLocation navLocation) {
        this.onlineSearchContext.getSearchArea().setSearchContext(n, navLocation);
        this.form.setSearchLocation(n, navLocation);
        return true;
    }

    public boolean setSearchArea(int n) {
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#setSearchArea: called for searchContextLocationVicinity '%1'").toString(), (long)n);
        NavLocation navLocation = this.getNavLocation(n);
        if (navLocation == null) {
            this.logChannel.log(100000, new StringBuffer().append(CLASS_NAME).append("setSearchArea: Could not get NavLocation object").toString());
            return false;
        }
        this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("setSearchArea: NavLocation object is '%1'").toString(), (Object)LocationFormatter.formatLocationShort(navLocation));
        return this.setSearchArea(n, navLocation);
    }

    private void updateSearchArea(PoiOnlineSearchArea poiOnlineSearchArea) {
        int n = poiOnlineSearchArea.getSearchContext();
        NavLocation navLocation = this.getNavLocation(n);
        if (navLocation == null) {
            this.logChannel.log(100000, new StringBuffer().append(CLASS_NAME).append("#getNavLocation: could not get NavLocation object").toString());
        }
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("updateSearchArea: setting search area to %1").toString(), (Object)navLocation);
        poiOnlineSearchArea.setSearchContext(n, navLocation);
    }

    public void onlineSearchExit() {
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#onlineSearchExit: called").toString());
        this.form.onlineSearchExit();
    }

    public NavLocation getNavLocation(int n) {
        NavLocation navLocation;
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#getNavLocation: called for searchContextLocationVicinity '%1'").toString(), (long)n);
        switch (n) {
            case 0: {
                this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("getNavLocation: PoiOnlineSearchArea.SEARCH_CONTEXT_LOCATION_VICINITY").toString());
                navLocation = this.vehicle.getVehicleLocation();
                break;
            }
            case 1: {
                this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("getNavLocation: PoiOnlineSearchArea.SEARCH_CONTEXT_DESTINATION_VICINITY").toString());
                navLocation = this.getDestination(1);
                break;
            }
            case 2: {
                this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("getNavLocation: PoiOnlineSearchArea.SEARCH_CONTEXT_STOPOVER_VICINITY").toString());
                navLocation = this.getDestination(2);
                break;
            }
            case 3: {
                this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("getNavLocation: PoiOnlineSearchArea.SEARCH_CONTEXT_NEW_LOCATION").toString());
                navLocation = this.searchArea.getNavLocation();
                break;
            }
            default: {
                this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("getNavLocation: vicinity not defined properly").toString());
                navLocation = null;
            }
        }
        return navLocation;
    }

    private NavLocation getDestination(int n) {
        int n2;
        this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#getDestination: called for searchContext '%1'").toString(), (long)n);
        Route route = this.routeManager.getRoute();
        if (route == null) {
            this.logChannel.log(10000, new StringBuffer().append(CLASS_NAME).append("getDestination: 'Route' is null").toString());
            return null;
        }
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        if (routeDestinationArray == null || routeDestinationArray.length == 0) {
            this.logChannel.log(10000, new StringBuffer().append(CLASS_NAME).append("getDestination: 'routelist' is null or length its 0").toString());
            return null;
        }
        if (n == 1) {
            n2 = routeDestinationArray.length - 1;
        } else if (n == 2) {
            n2 = routeDestinationArray.length - 2;
        } else {
            this.logChannel.log(10000, new StringBuffer().append(CLASS_NAME).append("getDestination: searchContext %1 is not supported").toString(), (long)n);
            return null;
        }
        for (int i2 = n2; i2 >= 0; --i2) {
            RouteDestination routeDestination = routeDestinationArray[i2];
            if (routeDestination == null || routeDestination.destinationType != 1) continue;
            return routeDestination.getRouteLocation();
        }
        return null;
    }

    public void prepareMapScreen(int n) {
        OnlinePOIResultList onlinePOIResultList = this.onlineSearchContext.getResultList();
        if (onlinePOIResultList != null && onlinePOIResultList.length() > 0) {
            OnlinePOIResultList onlinePOIResultList2 = new OnlinePOIResultList(this.logChannel, onlinePOIResultList, n, true);
            this.logChannel.log(1000000, new StringBuffer().append(CLASS_NAME).append("#prepareMapScreen: Loading pin %1").toString(), (long)n);
            CommandList commandList = this.naviCommandListFactory.createCommandList();
            commandList.add(new ShowOnlineResultsCommand(onlinePOIResultList2));
            commandList.execute("OnlineSearchSequence#prepareMapScreen");
        } else {
            this.logChannel.log(10000, new StringBuffer().append(CLASS_NAME).append("prepareMapScreen: No result list found").toString());
        }
    }

    public void onlinePOIMainEnter() {
        this.form.onlinePOIMainEnter();
    }

    public void onlinePOIMainExit() {
        this.form.onlinePOIMainExit();
    }

    public PoiOnlineSearchValuelist getCurrentPOIOnlineList() {
        return this.valueList;
    }

    public void setCurrentPOIOnlineList(PoiOnlineSearchValuelist poiOnlineSearchValuelist) {
        this.valueList = poiOnlineSearchValuelist;
    }

    public CommandList startRouteGuidance(final IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        CommandList commandList = this.naviCommandListFactory.createCommandList();
        commandList.add(new NavCommand("OnlineSearchSequence#startRouteGuidance"){

            public void execute() {
                NavLocation navLocation = OnlineSearchSequence.this.form.getCurrentlySelectedLocation();
                OnlineSearchSequence.this.logChannel.log(1000000, new StringBuffer().append(this.CLASS_NAME).append("#startRouteGuidance: %1").toString(), (Object)LocationFormatter.formatLocationShort(navLocation));
                OnlineSearchSequence.this.startGuidance(navLocation, iStartGuidanceToDestinationSequence, false);
                OnlineSearchSequence.this.markCurrentResultUsedFor(10);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public void setInitialNavLocationForSearchArea(NavLocation navLocation) {
        this.searchArea.setNavLocation(navLocation);
    }

    public void refreshPreviewMap(int n) {
        CommandList commandList = this.naviCommandListFactory.createCommandList();
        commandList.add(new OnlineSearchUpdateMapCommand(this.logChannel, this.onlineSearchContext.getResultList(), this.searchArea, n, this.previewMap));
        commandList.execute("online-search-sequence-refresh-preview-map");
    }

    public void previewSearchArea() {
        if (!this.isSpellerOpen()) {
            this.logChannel.log(10000000, "OnlineSearchSequence#previewSearchArea - isSpellerOpen = false -> show");
            if (this.searchArea == null) {
                this.logChannel.log(100000, "OnlineSearchSequence#previewSearchArea - searchArea is null");
                return;
            }
            final int n = this.searchArea.getSearchContext();
            final NavLocation navLocation = this.searchArea.getNavLocation();
            CommandList commandList = this.naviCommandListFactory.createCommandList();
            commandList.add(new NavCommand("online-preview-search-area-command"){

                public void execute() {
                    switch (n) {
                        case 3: {
                            OnlineSearchSequence.this.previewMap.setPreviewLocation(navLocation, 3, null, null);
                            break;
                        }
                        case 1: 
                        case 2: {
                            OnlineSearchSequence.this.previewMap.setPreviewDestination(navLocation, 3, null, null);
                            break;
                        }
                        default: {
                            OnlineSearchSequence.this.previewMap.setPreviewAreaAroundCCP(3);
                        }
                    }
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute("online-search-sequence-preview-search-area");
        } else {
            this.logChannel.log(10000000, "OnlineSearchSequence#previewSearchArea - isSpellerOpen = false -> hide");
            this.hidePreviewMap(this.previewMap);
        }
    }

    public void hidePreviewMap(IPreviewMap iPreviewMap) {
        if (iPreviewMap != null) {
            CommandList commandList = this.naviCommandListFactory.createCommandList(1);
            commandList.add(new HidePreviewMapCommand(iPreviewMap));
            commandList.execute(new StringBuffer().append(CLASS_NAME).append("#hidePreviewMap").toString());
        }
    }

    public void setSpellerOpen(boolean bl) {
        this.isSpellerOpen = bl;
    }

    public boolean isSpellerOpen() {
        return this.isSpellerOpen;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

