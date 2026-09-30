/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.adb.ITelADBGetADBEntryListener;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.search.cmd.AbstractTelSearchModelHandler;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.evo.intellicall.search.AbstractIntellicallSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBEntryDetailsResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallCallStackSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallFavoriteSearchResultRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.phone.TelIntellicallIGIUtil;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.util.StringUtilities;
import java.util.ArrayList;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.search.SearchResult;

public abstract class AbstractTelIntellicallSearchModelHandler
extends AbstractTelSearchModelHandler {
    private final int[] sources = new int[]{7, 18, 3};

    public AbstractTelIntellicallSearchModelHandler(ITelApplication iTelApplication, ITelDSISearchAccess iTelDSISearchAccess, String string) {
        super(iTelApplication, iTelDSISearchAccess, string);
    }

    public void init() {
        this.addSubPhoneComponent(new SpellerContentButtonListener(this.getApplication(), this.getSpellerContentButton().getID()));
        super.init();
    }

    protected abstract void showCombinedCallStacks();

    protected abstract void showSearchResultList();

    protected abstract ChoiceModelApp getTelephoneNumberRecognizedChoice();

    protected abstract LabelModelApp getSpellerContentLabel();

    protected abstract void spellerContentButtonSelected(int var1);

    protected abstract ButtonModelApp getSpellerContentButton();

    protected abstract MenuModelApp getMenu();

    protected abstract void spellerSelectedUnique(String var1, int var2);

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
                    this.log.log(100000, "[AbstractTelIntellicallSearchModelHandler#updateSearchResult] no handling for source %1", (long)searchResult.getSource());
                }
            }
        }
        return abstractIntellicallSearchResultRow;
    }

    protected int[] getSources() {
        return this.sources;
    }

    public void requestChildrenNodes(final SearchResultListRow searchResultListRow, int n) {
        this.log.log(1000000, "[AbstractTelIntellicallSearchModelHandler#requestChildrenNodes] listRow=%1", (Object)searchResultListRow);
        this.getApplication().getADBHandler().getADBEntry(searchResultListRow.getSearchResult().getDataId(), new ITelADBGetADBEntryListener(){

            public void resultGetADBEntry(AdbEntry adbEntry) {
                AbstractTelIntellicallSearchModelHandler.this.log.log(1000000, "[AbstractTelIntellicallSearchModelHandler.requestChildrenNodes(...).new ITelADBGetADBEntryListener() {...}#resultGetADBEntry] entry=%1", (Object)adbEntry);
                if (adbEntry != null && adbEntry.getPhoneData() != null && adbEntry.getPhoneData().length > 0) {
                    PhoneData[] phoneDataArray = adbEntry.getPhoneData();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < phoneDataArray.length; ++i2) {
                        String string = phoneDataArray[i2].getNumber();
                        if (StringUtilities.isNullOrEmpty(string)) continue;
                        arrayList.add(new IntellicallADBEntryDetailsResultRow(adbEntry, i2));
                    }
                    EvoListRow[] evoListRowArray = (IntellicallADBEntryDetailsResultRow[])arrayList.toArray(new IntellicallADBEntryDetailsResultRow[arrayList.size()]);
                    AbstractTelIntellicallSearchModelHandler.this.setChildrenNodes(evoListRowArray, searchResultListRow);
                }
            }
        });
    }

    protected void clearSearchSpeller() {
        super.clearSearchSpeller();
        this.showCombinedCallStacks();
        this.resetSpellerContentLabel();
        this.disableTelIconInSpeller();
    }

    public void updateSearchResult(int n, SearchResult searchResult) {
        this.log.log(1000000, "[AbstractTelIntellicallSearchModelHandler#updateSearchResult] queryID=%2, searchResult=%1", (Object)searchResult, (long)n);
        super.updateSearchResult(n, searchResult);
        this.showSearchResultList();
    }

    public void searchEnded(int n) {
        this.log.log(1000000, "[AbstractTelIntellicallSearchModelHandler#searchEnded] queryID=%1", (long)n);
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

    public void searchCanceled(int n) {
        this.log.log(1000000, "[AbstractTelIntellicallSearchModelHandler#searchCanceled] queryID=%1", (long)n);
        super.searchCanceled(n);
    }

    protected void searchSpellerTextChanged(String string, char c2) {
        if (!StringUtilities.isNullOrEmpty(string)) {
            String string2 = TelIntellicallIGIUtil.getValidPhoneNumber(string);
            if (string2 != null) {
                this.log.log(10000000, "[AbstractTelIntellicallSearchModelHandler#textChanged] phone number recognized: %1", (Object)string2);
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

    private class SpellerContentButtonListener
    extends TelDefaultButtonListener {
        public SpellerContentButtonListener(ITelApplication iTelApplication, int n) {
            super(iTelApplication, "App.Phone.Search", n);
        }

        public void keyTyped(int n, int n2, int n3) {
            AbstractTelIntellicallSearchModelHandler.this.spellerContentButtonSelected(n3);
        }
    }
}

