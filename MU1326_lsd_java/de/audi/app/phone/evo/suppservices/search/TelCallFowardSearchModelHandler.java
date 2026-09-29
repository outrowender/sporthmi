/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.suppservices.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.suppservices.AbstractTelCallForwardingHandler;
import de.audi.app.phone.evo.intellicall.search.AbstractIntellicallSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.AbstractTelIntellicallSearchModelHandler;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBEntryDetailsResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallCallStackSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallFavoriteSearchResultRow;
import de.audi.app.phone.evo.suppservices.search.TelCallFowardSearchModelHandler$CallFowardingLeftListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.util.StringUtilities;

public class TelCallFowardSearchModelHandler
extends AbstractTelIntellicallSearchModelHandler {
    private final AbstractTelCallForwardingHandler callForwardingHandler;

    public TelCallFowardSearchModelHandler(ITelApplication iTelApplication, ITelDSISearchAccess iTelDSISearchAccess, AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        super(iTelApplication, iTelDSISearchAccess, "App.Phone.Search");
        this.callForwardingHandler = abstractTelCallForwardingHandler;
        this.addSubPhoneComponent(new TelCallFowardSearchModelHandler$CallFowardingLeftListener(this, iTelApplication));
    }

    @Override
    protected SpellerModelApp getSearchSpellerModel() {
        return this.getSpellerModel(-577371136);
    }

    @Override
    protected BaseListModelApp getSearchResultListModel() {
        return this.getBaseListModel(-560593920);
    }

    @Override
    protected ChoiceModelApp getSearchIsActiveChoiceModel() {
        return this.getChoiceModel(-543816704);
    }

    @Override
    protected void showCombinedCallStacks() {
        this.getChoiceModel(-510262272).setValue(0);
    }

    @Override
    protected void showSearchResultList() {
        this.getChoiceModel(-510262272).setValue(1);
    }

    @Override
    protected ChoiceModelApp getTelephoneNumberRecognizedChoice() {
        return this.getChoiceModel(-493485056);
    }

    @Override
    protected LabelModelApp getSpellerContentLabel() {
        return this.getLabelModel(-476707840);
    }

    @Override
    protected ButtonModelApp getSpellerContentButton() {
        return this.getButtonModel(-342490112);
    }

    @Override
    protected MenuModelApp getMenu() {
        return this.getMenuModel(144114688);
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.log.log(1078071040, "[TelCallFowardSearchModelHandler#searchResultSelected] listRow=%1", (Object)searchResultListRow);
        String string = null;
        if (searchResultListRow instanceof IntellicallCallStackSearchResultRow) {
            AbstractIntellicallSearchResultRow abstractIntellicallSearchResultRow = (AbstractIntellicallSearchResultRow)searchResultListRow;
            string = abstractIntellicallSearchResultRow.getTelephoneNumber();
        } else if (searchResultListRow instanceof IntellicallFavoriteSearchResultRow) {
            IntellicallFavoriteSearchResultRow intellicallFavoriteSearchResultRow = (IntellicallFavoriteSearchResultRow)searchResultListRow;
            string = intellicallFavoriteSearchResultRow.getTelephoneNumber();
        }
        this.activateCallForwarding(string, n);
    }

    @Override
    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            IntellicallADBEntryDetailsResultRow intellicallADBEntryDetailsResultRow = (IntellicallADBEntryDetailsResultRow)evoListRow;
            String string = intellicallADBEntryDetailsResultRow.getNumber();
            this.log.log(1078071040, "[TelCallFowardSearchModelHandler#childNodeSelected] number %1", (Object)string);
            this.activateCallForwarding(string, n);
        }
    }

    private void activateCallForwarding(String string, int n) {
        if (!StringUtilities.isNullOrEmpty(string)) {
            this.log.log(1078071040, "[TelCallForwardSearchGuiHandler#activateCallForwarding] number %1", (Object)string);
            this.callForwardingHandler.activateCallForwarding(string, n);
            this.getSearchSpellerModel().fireEvent(n);
            this.clearSearchSpeller();
        } else {
            this.log.log(1078071040, "[TelCallForwardSearchGuiHandler#activateCallForwarding] number is empty --> NOP!");
        }
    }

    @Override
    protected void spellerSelectedUnique(String string, int n) {
        this.log.log(1078071040, "[TelCallFowardSearchModelHandler#spellerSelectedUnique] number=%1", (Object)string);
        this.activateCallForwarding(string, n);
    }

    @Override
    protected void spellerContentButtonSelected(int n) {
        this.log.log(1078071040, "[TelCallFowardSearchModelHandler#spellerContentButtonSelected]");
        String string = this.getSpellerContentLabel().getText();
        this.activateCallForwarding(string, n);
    }

    static /* synthetic */ void access$000(TelCallFowardSearchModelHandler telCallFowardSearchModelHandler) {
        telCallFowardSearchModelHandler.clearSearchSpeller();
    }
}

