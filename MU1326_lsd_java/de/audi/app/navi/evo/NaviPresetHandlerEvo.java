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

    public int getType() {
        return 1;
    }

    public int[] getModelIds() {
        return new int[]{401421, 401334, 401864, 401316, 401408, 401377, 401612, 401486, 401837, 401840, DIScreensEvo.getDiEuCityZipScreenTiledListModel(), DIScreensEvo.getDiEuStreetScreenTiledListModel(), DIScreensEvo.getDiEuRefinementScreenTiledListModel(), DIScreensEvo.getDiEuHousenumberMatchSpellerScreenTiledListModel(), DIScreensEvo.getDiEuJunctionScreenTiledListModel(), DIScreensEvo.getDiJpPrefectureScreenTiledListModel(), DIScreensEvo.getDiJpPlacenameScreenTiledListModel(), DIScreensEvo.getDiJpWardScreenTiledListModel(), DIScreensEvo.getDiJpChomeScreenTiledListModel(), DIScreensEvo.getDiKrProvinceScreenTiledListModel(), DIScreensEvo.getDiKrCityScreenTiledListModel(), DIScreensEvo.getDiKrWardScreenTiledListModel(), DIScreensEvo.getDiKrTownStreetScreenTiledListModel(), PoiScreensEvo.getPoiResultScreeNoSpellerListModel(), PoiScreensEvo.getPoiResultScreenWithSpellerListModel(), PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel(), PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel(), PoiScreensEvo.getPoiParentChildResultScreenListModel(), 401114, 401311, 402065, 402068, 401787};
    }

    private final void createExtractors(SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor) {
        NaviFavoriteEvoNavLocationExtractor naviFavoriteEvoNavLocationExtractor = new NaviFavoriteEvoNavLocationExtractor(this.commandListFactory);
        this.registerRowExtractor(401334, naviFavoriteEvoNavLocationExtractor);
        this.registerRowExtractor(401864, naviFavoriteEvoNavLocationExtractor);
        SearchResultNavLocationExtractor searchResultNavLocationExtractor = new SearchResultNavLocationExtractor(searchResultAsyncNavLocationExtractor);
        this.registerRowExtractor(401316, searchResultNavLocationExtractor);
        this.registerRowExtractor(401408, searchResultNavLocationExtractor);
        this.registerRowExtractor(401377, searchResultNavLocationExtractor);
        this.registerRowExtractor(401612, searchResultNavLocationExtractor);
        this.registerRowExtractor(401486, searchResultNavLocationExtractor);
        this.registerRowExtractor(401421, searchResultNavLocationExtractor);
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
        this.registerRowExtractor(401837, liValueListNavLocationExtractor);
        this.registerRowExtractor(401840, liValueListNavLocationExtractor);
        this.registerRowExtractor(PoiScreensEvo.getPoiParentChildResultScreenListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(PoiScreensEvo.getPoiResultScreenWithSpellerListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(PoiScreensEvo.getPoiResultScreeNoSpellerListModel(), liValueListNavLocationExtractor);
        this.registerRowExtractor(401114, liValueListNavLocationExtractor);
        this.registerRowExtractor(401311, liValueListNavLocationExtractor);
        this.registerRowExtractor(402065, liValueListNavLocationExtractor);
        this.registerRowExtractor(402068, liValueListNavLocationExtractor);
        this.registerRowExtractor(401787, liValueListNavLocationExtractor);
    }
}

