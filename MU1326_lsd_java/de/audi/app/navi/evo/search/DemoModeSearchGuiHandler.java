/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IIntelliDestSearchTimer;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.IntelliDestSearch;
import de.audi.app.navi.evo.search.NoPropertyFormatterADB;
import de.audi.app.navi.evo.search.NoPropertyFormatterNavDb;
import de.audi.app.navi.favorite.NaviFavoriteHandlerEvo;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RGSetPosition;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.NavLocation;

public class DemoModeSearchGuiHandler
extends IntelliDestGuiSearchHandler {
    private static String LOGCLASS = "DemoModeSearchGuiHandler";

    public DemoModeSearchGuiHandler(int[] nArray, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LogChannel logChannel, AbstractSearch abstractSearch, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, NaviADBHandler naviADBHandler, ADBInterAppService aDBInterAppService, InterAppService interAppService, IconHandler iconHandler, ICommandListFactory iCommandListFactory, NaviFavoriteHandlerEvo naviFavoriteHandlerEvo, IPoiService iPoiService, HomeAddressHandler homeAddressHandler, IAddressInputForm iAddressInputForm, SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, MapInterface mapInterface, DispatcherBase dispatcherBase, NaviServiceListener naviServiceListener, IIntelliDestSearchTimer iIntelliDestSearchTimer) {
        super(nArray, baseListModelApp, spellerModelApp, choiceModelApp, logChannel, abstractSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, naviFavoriteHandlerEvo, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, iIntelliDestSearchTimer, null);
        this.registryFormatter.put(new Integer(4), new NoPropertyFormatterNavDb(interAppService, iconHandler, logChannel, naviFavoriteHandlerEvo, navigationEnv));
        this.registryFormatter.put(new Integer(16), new NoPropertyFormatterNavDb(interAppService, iconHandler, logChannel, naviFavoriteHandlerEvo, navigationEnv));
        this.registryFormatter.put(new Integer(5), new NoPropertyFormatterNavDb(interAppService, iconHandler, logChannel, naviFavoriteHandlerEvo, navigationEnv));
        this.registryFormatter.put(new Integer(3), new NoPropertyFormatterADB(aDBInterAppService, navigationEnv));
    }

    public void activate() {
        ((IntelliDestSearch)this.appSearch).setSearchFilterForSource(3);
        this.registerListeners();
        this.mdlSpellerSearchText.clear();
        this.env.getChoiceModel(401008).setValue(1);
        this.performQuery("");
    }

    public void searchResultSelected(final SearchResultListRow searchResultListRow, final int n, int n2) {
        this.asyncLocationExtractor.executeCallbackWithNavLocation(searchResultListRow, 0, new NavLocationCallback(){

            public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                if (DemoModeSearchGuiHandler.this.isDisambiguationNeeded(searchResultListRow)) {
                    if (null != DemoModeSearchGuiHandler.this.addressDisambiguator) {
                        iCommandList.commandFinishedWithPostSequence(DemoModeSearchGuiHandler.this.addressDisambiguator.prepareCandidatesList(searchResultListRow, n));
                    } else {
                        DemoModeSearchGuiHandler.this.env.getLogChannel().log(100000, "%1#searchResultSelected() - addressDisambiguator is null", (Object)LOGCLASS);
                    }
                } else {
                    iCommandList.commandFinishedWithPostCommand(DemoModeSearchGuiHandler.getSetPositionCommand(navLocation, DemoModeSearchGuiHandler.this.lc));
                }
            }
        });
        this.env.getBaseListModel(n2).fireEvent(n);
    }

    public static NavCommand getSetPositionCommand(final NavLocation navLocation, final LogChannel logChannel) {
        NavCommand navCommand = new NavCommand("SetDemoModeStartPosition"){

            public void execute() {
                if (navLocation != null) {
                    if (navLocation.isPositionValid()) {
                        logChannel.log(10000000, "DemoModeSearchGuiHandler#searchResultSelected # location valid = %1", (Object)LocationFormatter.formatLocationShort(navLocation));
                        this.navigation.getDemoModeManager().demoLocationWasSet(navLocation);
                        this.getCommandList().commandFinishedWithPostCommand(new RGSetPosition(navLocation));
                    } else {
                        logChannel.log(10000000, "DemoModeSearchGuiHandler#searchResultSelected # location invalid= %1", (Object)LocationFormatter.formatLocationShort(navLocation));
                    }
                } else {
                    logChannel.log(10000000, "DemoModeSearchGuiHandler#searchResultSelected # no result or no location");
                    this.getCommandList().commandFinished();
                }
            }
        };
        return navCommand;
    }
}

