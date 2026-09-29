/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.favorite.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.cmd.AbstractTelSearchModelHandler;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.evo.favorite.search.TelFavoriteSearchModelHandler$ResetFavoriteSearchListener;
import de.audi.app.phone.evo.favorite.search.TelFavoriteSearchResultRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class TelFavoriteSearchModelHandler
extends AbstractTelSearchModelHandler {
    private final int[] sources = new int[]{18};

    public TelFavoriteSearchModelHandler(ITelApplication iTelApplication, ITelDSISearchAccess iTelDSISearchAccess) {
        super(iTelApplication, iTelDSISearchAccess, "App.Phone.Search");
        this.addSubPhoneComponent(new TelFavoriteSearchModelHandler$ResetFavoriteSearchListener(this, iTelApplication));
    }

    @Override
    protected SpellerModelApp getSearchSpellerModel() {
        return this.getSpellerModel(-1332345856);
    }

    @Override
    protected BaseListModelApp getSearchResultListModel() {
        return this.getBaseListModel(-1349123072);
    }

    @Override
    protected ChoiceModelApp getSearchIsActiveChoiceModel() {
        return this.getChoiceModel(-1315568640);
    }

    @Override
    protected SearchResultListRow getSearchResultListRow(SearchResult searchResult) {
        return new TelFavoriteSearchResultRow(searchResult, this.log);
    }

    @Override
    protected int[] getSources() {
        return this.sources;
    }

    @Override
    public void searchEnded(int n) {
        this.showSearchResultList();
        super.searchEnded(n);
    }

    @Override
    public void searchCanceled(int n) {
        this.showFavoritesList();
        super.searchCanceled(n);
    }

    @Override
    public void updateSearchResult(int n, SearchResult searchResult) {
        super.updateSearchResult(n, searchResult);
        this.showSearchResultList();
    }

    private void showSearchResultList() {
        this.getChoiceModel(-1282014208).setValue(1);
    }

    private void showFavoritesList() {
        this.getChoiceModel(-1282014208).setValue(0);
    }

    @Override
    protected void searchSpellerTextChanged(String string, char c2) {
        if (string == null || string.length() == 0) {
            this.showFavoritesList();
        }
        super.searchSpellerTextChanged(string, c2);
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.log.log(1078071040, "[TelFavoriteSearchModelHandler#searchResultSelected] %1", (Object)searchResultListRow);
        if (searchResultListRow instanceof TelFavoriteSearchResultRow) {
            TelFavoriteSearchResultRow telFavoriteSearchResultRow = (TelFavoriteSearchResultRow)searchResultListRow;
            this.getApplication().getTelephoneDSIAccess().dialNumberFromDBEntry(telFavoriteSearchResultRow.getTelephoneNumber(), 0L, telFavoriteSearchResultRow.getName(), (short)telFavoriteSearchResultRow.getPhoneNumberType(), (short)0, null, 0, 0, n);
        }
    }

    @Override
    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        this.log.log(-1601830656, "[TelFavoriteSearchModelHandler#childNodeSelected] listRow=%1", (Object)evoListRow);
    }

    @Override
    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
        this.log.log(-1601830656, "[TelFavoriteSearchModelHandler#childNodeSelected] listRow=%1", (Object)searchResultListRow);
    }

    @Override
    protected void clearSearchSpeller() {
        super.clearSearchSpeller();
        this.showFavoritesList();
    }

    @Override
    public void spellerSelected(String string, int n) {
        this.log.log(1078071040, "[TelFavoriteSearchModelHandler#spellerSelected] text=%1", (Object)string);
    }

    public void updateRenamedEntry(TelFavoriteSearchResultRow telFavoriteSearchResultRow, String string) {
        if (telFavoriteSearchResultRow != null) {
            this.log.log(-2137614336, "[TelFavoriteSearchModelHandler#updateRenamedEntry] new name=%1", (Object)string);
            telFavoriteSearchResultRow.updateName(string);
            this.updateRow(telFavoriteSearchResultRow);
        }
    }

    public void updateRow(TelFavoriteSearchResultRow telFavoriteSearchResultRow) {
        int n = this.getSearchResultListModel().getIndexForUniqueID(telFavoriteSearchResultRow.getUniqueID());
        this.getSearchResultListModel().setRow(n, telFavoriteSearchResultRow);
    }
}

