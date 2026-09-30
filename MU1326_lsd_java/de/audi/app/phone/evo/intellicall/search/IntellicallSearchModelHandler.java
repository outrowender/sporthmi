/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.search.cmd.ITelSearchQueryListener;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.intellicall.IntellicallFullMenuFocusHandler;
import de.audi.app.phone.evo.intellicall.search.AbstractTelIntellicallSearchModelHandler;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBEntryDetailsResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallCallStackSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallFavoriteSearchResultRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.util.StringUtilities;
import java.util.Map;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class IntellicallSearchModelHandler
extends AbstractTelIntellicallSearchModelHandler
implements ITelSearchQueryListener {
    private final IntellicallFullMenuFocusHandler fullViewFocusManager;

    public IntellicallSearchModelHandler(ITelApplication iTelApplication, ITelDSISearchAccess iTelDSISearchAccess, IntellicallFullMenuFocusHandler intellicallFullMenuFocusHandler) {
        super(iTelApplication, iTelDSISearchAccess, "App.Phone.Search");
        this.fullViewFocusManager = intellicallFullMenuFocusHandler;
        this.addSubPhoneComponent(new ResetSearchResultListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.showCombinedCallStacks();
    }

    protected SpellerModelApp getSearchSpellerModel() {
        return this.getSpellerModel(300391);
    }

    protected BaseListModelApp getSearchResultListModel() {
        return this.getBaseListModel(300718);
    }

    protected ChoiceModelApp getSearchIsActiveChoiceModel() {
        return this.getChoiceModel(300398);
    }

    protected ChoiceModelApp getTelephoneNumberRecognizedChoice() {
        return this.getChoiceModel(300687);
    }

    protected LabelModelApp getSpellerContentLabel() {
        return this.getLabelModel(300467);
    }

    protected ButtonModelApp getSpellerContentButton() {
        return this.getButtonModel(300468);
    }

    protected MenuModelApp getMenu() {
        return this.getMenuModel(300744);
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.log.log(1000000, "[IntellicallSearchModelHandler#searchResultSelected] listRow=%1", (Object)searchResultListRow);
        if (searchResultListRow instanceof IntellicallCallStackSearchResultRow) {
            IntellicallCallStackSearchResultRow intellicallCallStackSearchResultRow = (IntellicallCallStackSearchResultRow)searchResultListRow;
            CallStackEntry callStackEntry = intellicallCallStackSearchResultRow.getCallStackEntry();
            ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumberFromCallStackEntry(callStackEntry, n);
            this.clearSearchSpeller();
        } else if (searchResultListRow instanceof IntellicallFavoriteSearchResultRow) {
            IntellicallFavoriteSearchResultRow intellicallFavoriteSearchResultRow = (IntellicallFavoriteSearchResultRow)searchResultListRow;
            ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumberFromDBEntry(intellicallFavoriteSearchResultRow.getTelephoneNumber(), 0L, intellicallFavoriteSearchResultRow.getName(), (short)intellicallFavoriteSearchResultRow.getPhoneNumberType(), (short)0, null, 0, 0, n);
            this.clearSearchSpeller();
        }
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        this.log.log(1000000, "[IntellicallSearchModelHandler#childNodeSelected] listRow=%1", (Object)evoListRow);
        if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            IntellicallADBEntryDetailsResultRow intellicallADBEntryDetailsResultRow = (IntellicallADBEntryDetailsResultRow)evoListRow;
            AdbEntry adbEntry = intellicallADBEntryDetailsResultRow.getEntry();
            int n3 = intellicallADBEntryDetailsResultRow.getPhoneNumberIdx();
            this.log.log(10000000, "[AbstractTelIntellicallSearchModelHandler#childNodeSelected] dialing %1", (Object)intellicallADBEntryDetailsResultRow.getNumber());
            ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumberFromADBEntry(adbEntry, n3, n);
            this.clearSearchSpeller();
        }
    }

    protected void searchSpellerTextChanged(String string, char c2) {
        this.fullViewFocusManager.focusSearchFieldTop();
        if (!StringUtilities.isNullOrEmpty(string)) {
            this.getChoiceModel(300698).setValue(1);
        }
        super.searchSpellerTextChanged(string, c2);
    }

    public void clearSearchSpeller() {
        super.clearSearchSpeller();
        this.getChoiceModel(300698).setValue(0);
    }

    protected void showCombinedCallStacks() {
        this.getIntellicalModeChoice().setValue(1);
    }

    protected ChoiceModelApp getIntellicalModeChoice() {
        return this.getChoiceModel(300686);
    }

    protected void showSearchResultList() {
        this.getIntellicalModeChoice().setValue(0);
    }

    protected void spellerSelectedUnique(String string, int n) {
        ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumber(this.getSpellerContentLabel().getText(), n);
    }

    protected void spellerContentButtonSelected(int n) {
        ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumber(this.getSpellerContentLabel().getText(), n);
    }

    private class ResetSearchResultListener
    extends AbstractTelActionProxyListener {
        public ResetSearchResultListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Search", 21);
        }

        protected void actionProxyCalled(Map map) {
            IntellicallSearchModelHandler.this.clearSearchSpeller();
            IntellicallSearchModelHandler.this.getDsiSearchAccess().cancelActiveSearchQuery();
        }
    }
}

