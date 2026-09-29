/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.AdbContactsGuiSearchHandler$1;
import de.audi.app.navi.evo.search.AdbContactsGuiSearchHandler$2;
import de.audi.app.navi.evo.search.IIntelliDestSearchTimer;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.IntelliDestSearch;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.CommandList;
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
import org.dsi.ifc.search.Token;

public class AdbContactsGuiSearchHandler
extends IntelliDestGuiSearchHandler {
    private BaseListModelApp addressSelectBaseListModel;

    public AdbContactsGuiSearchHandler(int[] nArray, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LogChannel logChannel, AbstractSearch abstractSearch, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, NaviADBHandler naviADBHandler, ADBInterAppService aDBInterAppService, InterAppService interAppService, IconHandler iconHandler, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, IPoiService iPoiService, HomeAddressHandler homeAddressHandler, IAddressInputForm iAddressInputForm, SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, MapInterface mapInterface, DispatcherBase dispatcherBase, NaviServiceListener naviServiceListener, IIntelliDestSearchTimer iIntelliDestSearchTimer) {
        super(nArray, baseListModelApp, spellerModelApp, choiceModelApp, logChannel, abstractSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, iNaviFavoriteHandler, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, iIntelliDestSearchTimer, null);
        this.addressSelectBaseListModel = navigationEnv.getHMIService().getBaseListModel(-1927281152);
    }

    @Override
    public void activate() {
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "AdbContactsGuiSearchHandler#activate()");
        }
        ((IntelliDestSearch)this.appSearch).clearAddressDataFilterForAdb();
        this.registerListeners();
        this.mdlSpellerSearchText.clear();
        this.env.getChoiceModel(1881015808).setValue(1);
        this.performQuery("");
    }

    @Override
    public void enterScreen() {
        this.mdlSpellerSearchText.clear();
    }

    @Override
    protected void parentNodeSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.lc.log(-2137614336, "AdbContactsGuiSearchHandler#parentNodeSelected");
        this.createSelectionListFor(searchResultListRow);
        this.saveContactNameInLabel(searchResultListRow);
        ((IntelliDestSearch)this.appSearch).destinationAddedToContact = true;
        this.env.getHMIService().getBaseListModel(n).fireEvent(n2);
    }

    private void saveContactNameInLabel(SearchResultListRow searchResultListRow) {
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResultListRow.getSearchResult().tokens, 5);
        this.env.getLabelModel(-1390410240).setText(token.getToken());
    }

    private void createSelectionListFor(SearchResultListRow searchResultListRow) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new AdbContactsGuiSearchHandler$1(this, "AdbContactsGuiSearchHandler#getAdbEntry", searchResultListRow));
        commandList.add(new AdbContactsGuiSearchHandler$2(this, "AdbContactsGuiSearchHandler#createAdbEntrySelectionList"));
        commandList.execute("Start Save Address on Contact");
    }

    static /* synthetic */ ChoiceModelApp access$000(AdbContactsGuiSearchHandler adbContactsGuiSearchHandler) {
        return adbContactsGuiSearchHandler.mdlChoiceSearchIsActive;
    }

    static /* synthetic */ BaseListModelApp access$100(AdbContactsGuiSearchHandler adbContactsGuiSearchHandler) {
        return adbContactsGuiSearchHandler.addressSelectBaseListModel;
    }
}

