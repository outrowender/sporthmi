/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.truffle;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.evo.truffle.CarSearchResultListRow;
import de.audi.app.car.evo.truffle.CarTruffleSearch;
import de.audi.app.car.evo.truffle.CarTruffleSearchResultFormatter;
import de.audi.app.car.evo.truffle.ICarTruffleSearchComponent;
import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.util.SearchResultListRow;

public class CarTruffleGUISearchHandler
extends AbstractGuiSearchHandler {
    private final LogChannel logChannel;
    private final ICarTruffleSearchComponent searchComponent;

    public CarTruffleGUISearchHandler(ICarApplication iCarApplication, LogChannel logChannel, CarTruffleSearch carTruffleSearch, ICarTruffleSearchComponent iCarTruffleSearchComponent) {
        super(new int[]{6}, iCarApplication.getFrameworkAccess().getHmiServiceApp().getBaseListModel(601107), iCarApplication.getFrameworkAccess().getHmiServiceApp().getSpellerModel(600453), iCarApplication.getFrameworkAccess().getHmiServiceApp().getChoiceModel(600454), logChannel, carTruffleSearch);
        this.logChannel = logChannel;
        this.searchComponent = iCarTruffleSearchComponent;
        this.registryFormatter.put(new Integer(6), new CarTruffleSearchResultFormatter(logChannel, CarSearchResultListRow.getMaxColumns()));
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.logChannel.log(1000000, "[CarTruffleGUISearchHandler#searchResultSelected] result '%1' selected", (Object)searchResultListRow.getSearchResult());
        this.appSearch.addToHistory(searchResultListRow.getSearchResult());
        long l = searchResultListRow.getSearchResult().getDataId();
        this.searchComponent.menuEntrySelected(l);
        AdditionalScreenData additionalScreenData = new AdditionalScreenData();
        additionalScreenData.addData(1, new Integer((int)l));
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[CarTruffleGUISearchHandler#searchResultSelected] BaseListModelApp.fireEvent('%1', '%2')", (Object)new Integer(n), (Object)additionalScreenData);
        }
        this.mdlListSearchResults.fireEvent(n, additionalScreenData);
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }
}

