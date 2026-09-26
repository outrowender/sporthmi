/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.cmd.AbstractTelSearchModelHandler;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.evo.intellicall.search.AbstractIntellicallSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.AbstractTelIntellicallSearchModelHandler$1;
import de.audi.app.phone.evo.intellicall.search.AbstractTelIntellicallSearchModelHandler$SpellerContentButtonListener;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallCallStackSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallFavoriteSearchResultRow;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.phone.TelIntellicallIGIUtil;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.util.StringUtilities;
import org.dsi.ifc.search.SearchResult;

public abstract class AbstractTelIntellicallSearchModelHandler
extends AbstractTelSearchModelHandler {
    private final int[] sources = new int[]{7, 18, 3};

    public AbstractTelIntellicallSearchModelHandler(ITelApplication iTelApplication, ITelDSISearchAccess iTelDSISearchAccess, String string) {
        super(iTelApplication, iTelDSISearchAccess, string);
    }

    @Override
    public void init() {
        this.addSubPhoneComponent(new AbstractTelIntellicallSearchModelHandler$SpellerContentButtonListener(this, this.getApplication(), this.getSpellerContentButton().getID()));
        super.init();
    }

    protected abstract void showCombinedCallStacks() {
    }

    protected abstract void showSearchResultList() {
    }

    protected abstract ChoiceModelApp getTelephoneNumberRecognizedChoice() {
    }

    protected abstract LabelModelApp getSpellerContentLabel() {
    }

    protected abstract void spellerContentButtonSelected(int n) {
    }

    protected abstract ButtonModelApp getSpellerContentButton() {
    }

    protected abstract MenuModelApp getMenu() {
    }

    protected abstract void spellerSelectedUnique(String string, int n) {
    }

    @Override
    protected SearchResultListRow getSearchResultListRow(SearchResult searchResult) {
        AbstractIntellicallSearchResultRow abstractIntellicallSearchResultRow = null;
        if (searchResult != null) {
            switch (searchResult.getSource()) {
                case 3: {
                    abstractIntellicallSearchResultRow = new IntellicallADBSearchResultRow(searchResult, this.log);
                    break;
                }
                case 18: {
                    abstractIntellicallSearchResultRow = new IntellicallFavoriteSearchResultRow(searchResult, this.log);
                    break;
                }
                case 7: {
                    abstractIntellicallSearchResultRow = new IntellicallCallStackSearchResultRow(searchResult, this.log);
                    break;
                }
                default: {
                    this.log.log(-1601830656, "[AbstractTelIntellicallSearchModelHandler#updateSearchResult] no handling for source %1", (long)searchResult.getSource());
                }
            }
        }
        return abstractIntellicallSearchResultRow;
    }

    @Override
    protected int[] getSources() {
        return this.sources;
    }

    @Override
    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
        this.log.log(1078071040, "[AbstractTelIntellicallSearchModelHandler#requestChildrenNodes] listRow=%1", (Object)searchResultListRow);
        this.getApplication().getADBHandler().getADBEntry(searchResultListRow.getSearchResult().getDataId(), new AbstractTelIntellicallSearchModelHandler$1(this, searchResultListRow));
    }

    @Override
    protected void clearSearchSpeller() {
        super.clearSearchSpeller();
        this.showCombinedCallStacks();
        this.resetSpellerContentLabel();
        this.disableTelIconInSpeller();
    }

    @Override
    public void updateSearchResult(int n, SearchResult searchResult) {
        this.log.log(1078071040, "[AbstractTelIntellicallSearchModelHandler#updateSearchResult] queryID=%2, searchResult=%1", (Object)searchResult, (long)n);
        super.updateSearchResult(n, searchResult);
        this.showSearchResultList();
    }

    @Override
    public void searchEnded(int n) {
        this.log.log(1078071040, "[AbstractTelIntellicallSearchModelHandler#searchEnded] queryID=%1", (long)n);
        this.showSearchResultList();
        int n2 = this.getSearchResultListModel().getLength();
        if (n2 == 1 || this.isValidNumberInSpeller()) {
            this.enableTelIconInSpeller();
        } else {
            this.disableTelIconInSpeller();
        }
        super.searchEnded(n);
    }

    private void disableTelIconInSpeller() {
        this.getSearchSpellerModel().setCommandAvailable(7, false);
    }

    private void enableTelIconInSpeller() {
        this.getSearchSpellerModel().setCommandAvailable(7, true);
    }

    private boolean isValidNumberInSpeller() {
        String string = this.getSpellerContentLabel().getText();
        return TelIntellicallIGIUtil.getValidPhoneNumber(string) != null;
    }

    @Override
    public void searchCanceled(int n) {
        this.log.log(1078071040, "[AbstractTelIntellicallSearchModelHandler#searchCanceled] queryID=%1", (long)n);
        super.searchCanceled(n);
    }

    @Override
    protected void searchSpellerTextChanged(String string, char c2) {
        if (!StringUtilities.isNullOrEmpty(string)) {
            String string2 = TelIntellicallIGIUtil.getValidPhoneNumber(string);
            if (string2 != null) {
                this.log.log(-2137614336, "[AbstractTelIntellicallSearchModelHandler#textChanged] phone number recognized: %1", (Object)string2);
                this.enableTelIconInSpeller();
                this.spellerTextChanged(string2);
            } else {
                this.resetSpellerContentLabel();
            }
        } else {
            this.showCombinedCallStacks();
            this.clearSearchSpeller();
        }
        super.searchSpellerTextChanged(string, c2);
    }

    protected void spellerTextChanged(String string) {
        this.getSpellerContentLabel().setText(string);
        this.getTelephoneNumberRecognizedChoice().setValue(1);
    }

    protected void resetSpellerContentLabel() {
        this.getSpellerContentLabel().setText(null);
        this.getTelephoneNumberRecognizedChoice().setValue(0);
    }

    @Override
    public void spellerSelected(String string, int n) {
        if (this.getSearchResultListModel().getLength() == 1) {
            SearchResultListRow searchResultListRow = (SearchResultListRow)this.getSearchResultListModel().getRow(0);
            if (searchResultListRow instanceof IntellicallADBSearchResultRow) {
                this.parentNodeSelected(searchResultListRow, this.getSearchResultListModel().getID(), n);
                this.getMenu().setFocusedItem(this.getSearchResultListModel().getID(), FocusAdvice.KEEP_POSITION, 0L);
            } else if (searchResultListRow instanceof IntellicallCallStackSearchResultRow || searchResultListRow instanceof IntellicallFavoriteSearchResultRow) {
                this.searchResultSelected(searchResultListRow, n, this.getSearchResultListModel().getID());
            }
        } else if (this.getTelephoneNumberRecognizedChoice().getValue() == 1) {
            this.spellerSelectedUnique(this.getSpellerContentLabel().getText(), n);
        }
    }

    static /* synthetic */ LogChannel access$000(AbstractTelIntellicallSearchModelHandler abstractTelIntellicallSearchModelHandler) {
        return abstractTelIntellicallSearchModelHandler.log;
    }
}

