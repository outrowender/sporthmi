/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IIntelliDestSearchTimer;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.IntelliDestSearch;
import de.audi.app.navi.evo.search.NaviAdbEntryListRow;
import de.audi.app.navi.evo.search.NoPropertyFormatterADB;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.NavLocation;

public class AdbContactsWithAddressGuiSearchHandler
extends IntelliDestGuiSearchHandler {
    public AdbContactsWithAddressGuiSearchHandler(int[] nArray, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LogChannel logChannel, AbstractSearch abstractSearch, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, NaviADBHandler naviADBHandler, ADBInterAppService aDBInterAppService, InterAppService interAppService, IconHandler iconHandler, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, IPoiService iPoiService, HomeAddressHandler homeAddressHandler, IAddressInputForm iAddressInputForm, SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, MapInterface mapInterface, DispatcherBase dispatcherBase, NaviServiceListener naviServiceListener, IIntelliDestSearchTimer iIntelliDestSearchTimer) {
        super(nArray, baseListModelApp, spellerModelApp, choiceModelApp, logChannel, abstractSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, iNaviFavoriteHandler, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, iIntelliDestSearchTimer, null);
        this.registryFormatter.put(new Integer(3), new NoPropertyFormatterADB(aDBInterAppService, navigationEnv));
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "AdbContactsWithAddressGuiSearchHandler#childNodeSelected, row: [%1], terminal: [%2], modelID: [%3]", (Object)evoListRow, (long)n, (long)n2);
        }
        NaviAdbEntryListRow naviAdbEntryListRow = (NaviAdbEntryListRow)evoListRow;
        NavLocation navLocation = this.searchResultNavLocationExtractor.extractNavLocationFromRow(naviAdbEntryListRow);
        this.homeAddressHandler.onCreateEditHomeAddress(navLocation);
        this.env.getHMIService().getBaseListModel(n2).fireEvent(n);
    }

    public void activate() {
        ((IntelliDestSearch)this.appSearch).setSearchFilterForSource(3);
        this.registerListeners();
        this.mdlSpellerSearchText.clear();
        this.env.getChoiceModel(401008).setValue(1);
        this.performQuery("");
    }
}

