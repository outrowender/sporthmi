/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IIntelliDestSearchTimer;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.LastDestGuiSearchHandler$1;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class LastDestGuiSearchHandler
extends IntelliDestGuiSearchHandler {
    public LastDestGuiSearchHandler(int[] nArray, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LogChannel logChannel, AbstractSearch abstractSearch, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, NaviADBHandler naviADBHandler, ADBInterAppService aDBInterAppService, InterAppService interAppService, IconHandler iconHandler, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, IPoiService iPoiService, HomeAddressHandler homeAddressHandler, IAddressInputForm iAddressInputForm, SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, MapInterface mapInterface, DispatcherBase dispatcherBase, NaviServiceListener naviServiceListener, IIntelliDestSearchTimer iIntelliDestSearchTimer) {
        super(nArray, baseListModelApp, spellerModelApp, choiceModelApp, logChannel, abstractSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, iNaviFavoriteHandler, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, iIntelliDestSearchTimer, null);
    }

    @Override
    public void activate() {
        this.registerListeners();
        this.mdlSpellerSearchText.clear();
        this.env.getChoiceModel(1881015808).setValue(1);
        this.performQuery("");
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
        this.lc.log(-2137614336, "%1#commandPressed # model=%2, index=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        CommandList commandList = this.commandListFactory.createCommandList();
        if (n2 == 4711) {
            commandList.add(new HidePreviewMapCommand(this.previewMap));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#hidePreviewMap").toString());
        } else if (n2 == 4712) {
            if (this.env.getFramework().isAsia()) {
                commandList.add(new LastDestGuiSearchHandler$1(this, new StringBuffer().append(this.CLASS_NAME).append("#itemFocused").toString()));
                commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#previewAreaAroundCCP").toString());
            } else {
                commandList.add(new HidePreviewMapCommand(this.previewMap));
                commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#hidePreviewMap").toString());
            }
        }
    }

    static /* synthetic */ IPreviewMap access$000(LastDestGuiSearchHandler lastDestGuiSearchHandler) {
        return lastDestGuiSearchHandler.previewMap;
    }
}

