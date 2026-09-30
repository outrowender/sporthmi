/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.suppservices.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.suppservices.AbstractTelCallForwardingHandler;
import de.audi.app.phone.evo.intellicall.search.AbstractIntellicallSearchResultRow;
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

public class TelCallFowardSearchModelHandler
extends AbstractTelIntellicallSearchModelHandler {
    private final AbstractTelCallForwardingHandler callForwardingHandler;

    public TelCallFowardSearchModelHandler(ITelApplication iTelApplication, ITelDSISearchAccess iTelDSISearchAccess, AbstractTelCallForwardingHandler abstractTelCallForwardingHandler) {
        super(iTelApplication, iTelDSISearchAccess, "App.Phone.Search");
        this.callForwardingHandler = abstractTelCallForwardingHandler;
        this.addSubPhoneComponent(new CallFowardingLeftListener(iTelApplication));
    }

    protected SpellerModelApp getSearchSpellerModel() {
        return this.getSpellerModel(300765);
    }

    protected BaseListModelApp getSearchResultListModel() {
        return this.getBaseListModel(300766);
    }

    protected ChoiceModelApp getSearchIsActiveChoiceModel() {
        return this.getChoiceModel(300767);
    }

    protected void showCombinedCallStacks() {
        this.getChoiceModel(300769).setValue(0);
    }

    protected void showSearchResultList() {
        this.getChoiceModel(300769).setValue(1);
    }

    protected ChoiceModelApp getTelephoneNumberRecognizedChoice() {
        return this.getChoiceModel(300770);
    }

    protected LabelModelApp getSpellerContentLabel() {
        return this.getLabelModel(300771);
    }

    protected ButtonModelApp getSpellerContentButton() {
        return this.getButtonModel(300779);
    }

    protected MenuModelApp getMenu() {
        return this.getMenuModel(300808);
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.log.log(1000000, "[TelCallFowardSearchModelHandler#searchResultSelected] listRow=%1", (Object)searchResultListRow);
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

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            IntellicallADBEntryDetailsResultRow intellicallADBEntryDetailsResultRow = (IntellicallADBEntryDetailsResultRow)evoListRow;
            String string = intellicallADBEntryDetailsResultRow.getNumber();
            this.log.log(1000000, "[TelCallFowardSearchModelHandler#childNodeSelected] number %1", (Object)string);
            this.activateCallForwarding(string, n);
        }
    }

    private void activateCallForwarding(String string, int n) {
        if (!StringUtilities.isNullOrEmpty(string)) {
            this.log.log(1000000, "[TelCallForwardSearchGuiHandler#activateCallForwarding] number %1", (Object)string);
            this.callForwardingHandler.activateCallForwarding(string, n);
            this.getSearchSpellerModel().fireEvent(n);
            this.clearSearchSpeller();
        } else {
            this.log.log(1000000, "[TelCallForwardSearchGuiHandler#activateCallForwarding] number is empty --> NOP!");
        }
    }

    protected void spellerSelectedUnique(String string, int n) {
        this.log.log(1000000, "[TelCallFowardSearchModelHandler#spellerSelectedUnique] number=%1", (Object)string);
        this.activateCallForwarding(string, n);
    }

    protected void spellerContentButtonSelected(int n) {
        this.log.log(1000000, "[TelCallFowardSearchModelHandler#spellerContentButtonSelected]");
        String string = this.getSpellerContentLabel().getText();
        this.activateCallForwarding(string, n);
    }

    private class CallFowardingLeftListener
    extends AbstractTelActionProxyListener {
        public CallFowardingLeftListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Search", 16);
        }

        protected void actionProxyCalled(Map map) {
            TelCallFowardSearchModelHandler.this.clearSearchSpeller();
        }
    }
}

