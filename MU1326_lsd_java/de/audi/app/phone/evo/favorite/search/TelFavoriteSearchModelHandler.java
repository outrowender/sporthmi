/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.favorite.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.search.cmd.AbstractTelSearchModelHandler;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.evo.favorite.search.TelFavoriteSearchResultRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.search.util.SearchResultListRow;
import java.util.Map;
import org.dsi.ifc.search.SearchResult;

public class TelFavoriteSearchModelHandler
extends AbstractTelSearchModelHandler {
    private final int[] sources = new int[]{18};

    public TelFavoriteSearchModelHandler(ITelApplication iTelApplication, ITelDSISearchAccess iTelDSISearchAccess) {
        super(iTelApplication, iTelDSISearchAccess, "App.Phone.Search");
        this.addSubPhoneComponent(new ResetFavoriteSearchListener(iTelApplication));
    }

    protected SpellerModelApp getSearchSpellerModel() {
        return this.getSpellerModel(300720);
    }

    protected BaseListModelApp getSearchResultListModel() {
        return this.getBaseListModel(300719);
    }

    protected ChoiceModelApp getSearchIsActiveChoiceModel() {
        return this.getChoiceModel(300721);
    }

    protected SearchResultListRow getSearchResultListRow(SearchResult searchResult) {
        return new TelFavoriteSearchResultRow(searchResult, this.log);
    }

    protected int[] getSources() {
        return this.sources;
    }

    public void searchEnded(int n) {
        this.showSearchResultList();
        super.searchEnded(n);
    }

    public void searchCanceled(int n) {
        this.showFavoritesList();
        super.searchCanceled(n);
    }

    public void updateSearchResult(int n, SearchResult searchResult) {
        super.updateSearchResult(n, searchResult);
        this.showSearchResultList();
    }

    private void showSearchResultList() {
        this.getChoiceModel(300723).setValue(1);
    }

    private void showFavoritesList() {
        this.getChoiceModel(300723).setValue(0);
    }

    protected void searchSpellerTextChanged(String string, char c2) {
        if (string == null || string.length() == 0) {
            this.showFavoritesList();
        }
        super.searchSpellerTextChanged(string, c2);
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.log.log(1000000, "[TelFavoriteSearchModelHandler#searchResultSelected] %1", (Object)searchResultListRow);
        if (searchResultListRow instanceof TelFavoriteSearchResultRow) {
            TelFavoriteSearchResultRow telFavoriteSearchResultRow = (TelFavoriteSearchResultRow)searchResultListRow;
            this.getApplication().getTelephoneDSIAccess().dialNumberFromDBEntry(telFavoriteSearchResultRow.getTelephoneNumber(), 0L, telFavoriteSearchResultRow.getName(), (short)telFavoriteSearchResultRow.getPhoneNumberType(), (short)0, null, 0, 0, n);
        }
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        this.log.log(100000, "[TelFavoriteSearchModelHandler#childNodeSelected] listRow=%1", (Object)evoListRow);
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
        this.log.log(100000, "[TelFavoriteSearchModelHandler#childNodeSelected] listRow=%1", (Object)searchResultListRow);
    }

    protected void clearSearchSpeller() {
        super.clearSearchSpeller();
        this.showFavoritesList();
    }

    public void spellerSelected(String string, int n) {
        this.log.log(1000000, "[TelFavoriteSearchModelHandler#spellerSelected] text=%1", (Object)string);
    }

    public void updateRenamedEntry(TelFavoriteSearchResultRow telFavoriteSearchResultRow, String string) {
        if (telFavoriteSearchResultRow != null) {
            this.log.log(10000000, "[TelFavoriteSearchModelHandler#updateRenamedEntry] new name=%1", (Object)string);
            telFavoriteSearchResultRow.updateName(string);
            this.updateRow(telFavoriteSearchResultRow);
        }
    }

    public void updateRow(TelFavoriteSearchResultRow telFavoriteSearchResultRow) {
        int n = this.getSearchResultListModel().getIndexForUniqueID(telFavoriteSearchResultRow.getUniqueID());
        this.getSearchResultListModel().setRow(n, telFavoriteSearchResultRow);
    }

    private class ResetFavoriteSearchListener
    extends AbstractTelActionProxyListener {
        public ResetFavoriteSearchListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Search", 25);
        }

        protected void actionProxyCalled(Map map) {
            TelFavoriteSearchModelHandler.this.clearSearchSpeller();
        }
    }
}

