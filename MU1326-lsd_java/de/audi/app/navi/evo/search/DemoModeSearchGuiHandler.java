/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.DemoModeSearchGuiHandler$1;
import de.audi.app.navi.evo.search.DemoModeSearchGuiHandler$2;
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
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
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

    @Override
    public void activate() {
        ((IntelliDestSearch)this.appSearch).setSearchFilterForSource(3);
        this.registerListeners();
        this.mdlSpellerSearchText.clear();
        this.env.getChoiceModel(1881015808).setValue(1);
        this.performQuery("");
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.asyncLocationExtractor.executeCallbackWithNavLocation(searchResultListRow, 0, new DemoModeSearchGuiHandler$1(this, searchResultListRow, n));
        this.env.getBaseListModel(n2).fireEvent(n);
    }

    public static NavCommand getSetPositionCommand(NavLocation navLocation, LogChannel logChannel) {
        DemoModeSearchGuiHandler$2 demoModeSearchGuiHandler$2 = new DemoModeSearchGuiHandler$2("SetDemoModeStartPosition", navLocation, logChannel);
        return demoModeSearchGuiHandler$2;
    }

    static /* synthetic */ String access$000() {
        return LOGCLASS;
    }

    static /* synthetic */ LogChannel access$100(DemoModeSearchGuiHandler demoModeSearchGuiHandler) {
        return demoModeSearchGuiHandler.lc;
    }
}

