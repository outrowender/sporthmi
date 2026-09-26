/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo;

import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NaviPresetHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.navi.evo.navlocationextractor.NaviFavoriteEvoNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultNavLocationExtractor;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;

public class NaviPresetHandlerEvo
extends NaviPresetHandler {
    public NaviPresetHandlerEvo(NavigationEnv navigationEnv, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ICommandListFactory iCommandListFactory, SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, HomeAddressHandler homeAddressHandler) {
        super(navigationEnv, iStartGuidanceToDestinationSequence, iCommandListFactory, homeAddressHandler);
        this.createExtractors(searchResultAsyncNavLocationExtractor);
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{220202496, -1239480832, -937359872, -1541470720, 0x200600, -518060544, -870316544, 1310721536, -1390344704, -1340013056, DIScreensEvo.getDiEuCityZipScreenTiledListModel(), DIScreensEvo.getDiEuStreetScreenTiledListModel(), DIScreensEvo.getDiEuRefinementScreenTiledListModel(), DIScreensEvo.getDiEuHousenumberMatchSpellerScreenTiledListModel(), DIScreensEvo.getDiEuJunctionScreenTiledListModel(), DIScreensEvo.getDiJpPrefectureScreenTiledListModel(), DIScreensEvo.getDiJpPlacenameScreenTiledListModel(), DIScreensEvo.getDiJpWardScreenTiledListModel(), DIScreensEvo.getDiJpChomeScreenTiledListModel(), DIScreensEvo.getDiKrProvinceScreenTiledListModel(), DIScreensEvo.getDiKrCityScreenTiledListModel(), DIScreensEvo.getDiKrWardScreenTiledListModel(), DIScreensEvo.getDiKrTownStreetScreenTiledListModel(), PoiScreensEvo.getPoiResultScreeNoSpellerListModel(), PoiScreensEvo.getPoiResultScreenWithSpellerListModel(), PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel(), PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel(), PoiScreensEvo.getPoiParentChildResultScreenListModel(), -635566592, -1625356800, -1860041216, -1809709568, 2065761792};
    }

    private final void createExtractors(SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor) {
        NaviFavoriteEvoNavLocationExtractor naviFavoriteEvoNavLocationExtractor = new NaviFavoriteEvoNavLocationExtractor(this.commandListFactory);
        this.registerRowExtractor(-1239480832, naviFavoriteEvoNavLocationExtractor);
        this.registerRowExtractor(-937359872, naviFavoriteEvoNavLocationExtractor);
        SearchResultNavLocationExtractor searchResultNavLocationExtractor = new SearchResultNavLocationExtractor(searchResultAsyncNavLocationExtractor);
        this.registerRowExtractor(-1541470720, searchResultNavLocationExtractor);
        this.registerRowExtractor(0x200600, searchResultNavLocationExtractor);
        this.registerRowExtractor(-518060544, searchResultNavLocationExtractor);
        this.registerRowExtractor(-870316544, searchResultNavLocationExtractor);
        this.registerRowExtractor(1310721536, searchResultNavLocationExtractor);
        this.registerRowExtractor(220202496, searchResultNavLocationExtractor);
        LiValueListNavLocationExtractor liValueListNavLocationExtractor = new LiValueListNavLocationExtractor(this.commandListFactory);
        this.registerRowExtractor(DIScreensEvo.getDiEuCityZipScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiEuStreetScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiEuRefinementScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiEuHousenumberMatchSpellerScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiEuJunctionScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiJpPrefectureScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiJpPlacenameScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiJpWardScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiJpPlacenameScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiJpChomeScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiKrProvinceScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiKrCityScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiKrWardScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(DIScreensEvo.getDiKrTownStreetScreenTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(-1390344704, liValueListNavLocationExtractor);
        this.registerRowExtractor(-1340013056, liValueListNavLocationExtractor);
        this.registerRowExtractor(PoiScreensEvo.getPoiParentChildResultScreenListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(PoiScreensEvo.getPoiResultScreenWithSpellerListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(PoiScreensEvo.getPoiResultScreeNoSpellerListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(-635566592, liValueListNavLocationExtractor);
        this.registerRowExtractor(-1625356800, liValueListNavLocationExtractor);
        this.registerRowExtractor(-1860041216, liValueListNavLocationExtractor);
        this.registerRowExtractor(-1809709568, liValueListNavLocationExtractor);
        this.registerRowExtractor(2065761792, liValueListNavLocationExtractor);
    }
}

