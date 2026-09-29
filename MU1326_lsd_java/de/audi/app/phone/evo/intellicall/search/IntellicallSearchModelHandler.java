/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.search.cmd.ITelSearchQueryListener;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.intellicall.IntellicallFullMenuFocusHandler;
import de.audi.app.phone.evo.intellicall.search.AbstractTelIntellicallSearchModelHandler;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBEntryDetailsResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallCallStackSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallFavoriteSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallSearchModelHandler$ResetSearchResultListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.util.StringUtilities;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class IntellicallSearchModelHandler
extends AbstractTelIntellicallSearchModelHandler
implements ITelSearchQueryListener {
    private final IntellicallFullMenuFocusHandler fullViewFocusManager;

    public IntellicallSearchModelHandler(ITelApplication iTelApplication, ITelDSISearchAccess iTelDSISearchAccess, IntellicallFullMenuFocusHandler intellicallFullMenuFocusHandler) {
        super(iTelApplication, iTelDSISearchAccess, "App.Phone.Search");
        this.fullViewFocusManager = intellicallFullMenuFocusHandler;
        this.addSubPhoneComponent(new IntellicallSearchModelHandler$ResetSearchResultListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.showCombinedCallStacks();
    }

    @Override
    protected SpellerModelApp getSearchSpellerModel() {
        return this.getSpellerModel(1737819136);
    }

    @Override
    protected BaseListModelApp getSearchResultListModel() {
        return this.getBaseListModel(-1365900288);
    }

    @Override
    protected ChoiceModelApp getSearchIsActiveChoiceModel() {
        return this.getChoiceModel(1855259648);
    }

    @Override
    protected ChoiceModelApp getTelephoneNumberRecognizedChoice() {
        return this.getChoiceModel(-1885993984);
    }

    @Override
    protected LabelModelApp getSpellerContentLabel() {
        return this.getLabelModel(-1282079744);
    }

    @Override
    protected ButtonModelApp getSpellerContentButton() {
        return this.getButtonModel(-1265302528);
    }

    @Override
    protected MenuModelApp getMenu() {
        return this.getMenuModel(-929692672);
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.log.log(1078071040, "[IntellicallSearchModelHandler#searchResultSelected] listRow=%1", (Object)searchResultListRow);
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

    @Override
    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        this.log.log(1078071040, "[IntellicallSearchModelHandler#childNodeSelected] listRow=%1", (Object)evoListRow);
        if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            IntellicallADBEntryDetailsResultRow intellicallADBEntryDetailsResultRow = (IntellicallADBEntryDetailsResultRow)evoListRow;
            AdbEntry adbEntry = intellicallADBEntryDetailsResultRow.getEntry();
            int n3 = intellicallADBEntryDetailsResultRow.getPhoneNumberIdx();
            this.log.log(-2137614336, "[AbstractTelIntellicallSearchModelHandler#childNodeSelected] dialing %1", (Object)intellicallADBEntryDetailsResultRow.getNumber());
            ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumberFromADBEntry(adbEntry, n3, n);
            this.clearSearchSpeller();
        }
    }

    @Override
    protected void searchSpellerTextChanged(String string, char c2) {
        this.fullViewFocusManager.focusSearchFieldTop();
        if (!StringUtilities.isNullOrEmpty(string)) {
            this.getChoiceModel(-1701444608).setValue(1);
        }
        super.searchSpellerTextChanged(string, c2);
    }

    @Override
    public void clearSearchSpeller() {
        super.clearSearchSpeller();
        this.getChoiceModel(-1701444608).setValue(0);
    }

    @Override
    protected void showCombinedCallStacks() {
        this.getIntellicalModeChoice().setValue(1);
    }

    protected ChoiceModelApp getIntellicalModeChoice() {
        return this.getChoiceModel(-1902771200);
    }

    @Override
    protected void showSearchResultList() {
        this.getIntellicalModeChoice().setValue(0);
    }

    @Override
    protected void spellerSelectedUnique(String string, int n) {
        ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumber(this.getSpellerContentLabel().getText(), n);
    }

    @Override
    protected void spellerContentButtonSelected(int n) {
        ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumber(this.getSpellerContentLabel().getText(), n);
    }

    static /* synthetic */ ITelDSISearchAccess access$000(IntellicallSearchModelHandler intellicallSearchModelHandler) {
        return intellicallSearchModelHandler.getDsiSearchAccess();
    }
}

