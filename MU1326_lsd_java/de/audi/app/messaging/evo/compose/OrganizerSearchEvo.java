/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.addressbook.evo.common.search.organizer.ADBEvoOrganizerSearchListRow;
import de.audi.app.messaging.core.addressbook.MessagingAdbHandler;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.compose.AbstractOrganizerSearch;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.interapp.phone.TelIntellicallIGIUtil;
import de.audi.atip.util.StringUtilities;
import org.dsi.ifc.organizer.DataSet;

public final class OrganizerSearchEvo
extends AbstractOrganizerSearch {
    private final ISpellerMode noneSpellerMode = new NoneSpellerMode();
    private final ISpellerMode specialCharsSearchMode = new SpecialCharSearchMode();
    private final ISpellerMode matchSpellerMode = new MatchSpellerMode();
    private volatile ISpellerMode currentSpellerMode = this.noneSpellerMode;

    public OrganizerSearchEvo(MessagingBundleContext messagingBundleContext, MessagingAdbHandler messagingAdbHandler) {
        super(messagingBundleContext, messagingAdbHandler);
        this.getSpellerModel().setMinLength(0);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getActionProxyService().addSubscriber(new OrganizerSearchAudiActionProxy());
    }

    public EvoListRow[] createSearchListRows(DataSet[] dataSetArray) {
        return ADBEvoOrganizerSearchListRow.createFromDataSets(dataSetArray, this.appAdr.getAdbMode(), -1);
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1000000, "[OrganizerSearchEvo#textChanged]");
        this.setupSearchMode(string, c2);
        this.currentSpellerMode.textChanged(n, string, c2, n2);
    }

    public void setRowOpenState(EvoListRow evoListRow, boolean bl, BaseListModelApp baseListModelApp) {
        if (evoListRow != null && evoListRow instanceof ADBEvoOrganizerSearchListRow) {
            ((ADBEvoOrganizerSearchListRow)evoListRow).setOpen(bl);
            baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(evoListRow.getUniqueID()), evoListRow);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(10000000, "[OrganizerSearchEvo#keyTyped] Autoselecting the only search result");
        this.msgApp.getFramework().getHmiServiceApp().getModelApp(n).fireEvent(n3);
        if (this.getListLength() == 1) {
            this.selectListItem(0, n3);
        }
    }

    public void selectListItem(int n, int n2) {
        this.log.log(10000000, "[OrganizerSearchEvo#selectListItem] index = %1, terminalId = %2", (long)n, (long)n2);
        EvoListRow evoListRow = this.searchList.getRow(n);
        this.itemSelected(evoListRow, this.searchList.getID(), 0, 0, n2);
        this.menu.setFocusedItem(this.searchList.getID(), FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
    }

    public void spellerResult(int n, DataSet[] dataSetArray, int n2, String string, String string2) {
        this.log.log(1000000, "[TelEvoADBMatchSpellerHandler#spellerResult] uniqueChars = %1, currentSpellerMode = %2", (Object)string2, (Object)String.valueOf(this.currentSpellerMode));
        if ("".equals(string2) && this.currentSpellerMode instanceof MatchSpellerMode) {
            this.setSpellerMode(this.noneSpellerMode);
            this.clearSearchSpeller();
        }
        String string3 = this.prepareValidCharForSearchMode(string);
        super.spellerResult(n, dataSetArray, n2, string3, string2);
    }

    private void setupSearchMode(String string, char c2) {
        ISpellerMode iSpellerMode = this.currentSpellerMode;
        if (StringUtilities.isNullOrEmpty(string)) {
            iSpellerMode = this.noneSpellerMode;
        } else if (this.needToDetermineSearchMode(string, c2)) {
            iSpellerMode = TelIntellicallIGIUtil.isSpecialPhoneCharacter(c2) ? this.specialCharsSearchMode : this.matchSpellerMode;
        }
        this.setSpellerMode(iSpellerMode);
    }

    private void setSpellerMode(ISpellerMode iSpellerMode) {
        this.log.log(10000000, "[OrganizerSearchEvo#setSpellerMode] spellerMode = %1", (Object)iSpellerMode);
        this.currentSpellerMode = iSpellerMode;
        this.currentSpellerMode.spellerModeChanged();
    }

    private boolean needToDetermineSearchMode(String string, char c2) {
        return string != null && string.length() == 1 && c2 != '\b';
    }

    protected void startSpeller() {
        super.startSpeller();
        this.msgApp.getInterpretationGuessItem().update("");
    }

    private void clearSearchSpeller() {
        this.log.log(10000000, "[OrganizerSearchEvo#clearSearchSpeller]");
        this.getSpellerModel().clear();
        this.msgApp.getInterpretationGuessItem().update("");
    }

    private String prepareValidCharForSearchMode(String string) {
        if (!this.msgApp.getMessagingAdbHandler().isAdbReady()) {
            return null;
        }
        return this.currentSpellerMode.getValidChars(string);
    }

    private static interface ISpellerMode {
        public void spellerModeChanged();

        public void textChanged(int var1, String var2, char var3, int var4);

        public String getValidChars(String var1);
    }

    public final class NoneSpellerMode
    implements ISpellerMode {
        public void spellerModeChanged() {
            OrganizerSearchEvo.this.log.log(1000000, "[OrganizerSearchEvo#NoneSpellerMode#spellerModeChanged]");
        }

        public void textChanged(int n, String string, char c2, int n2) {
            OrganizerSearchEvo.this.log.log(1000000, "[OrganizerSearchEvo.NoneSpellerMode#textChanged] text = %1, latestChar = %2", (Object)string, (long)c2);
            OrganizerSearchEvo.this.clearSearchSpeller();
            OrganizerSearchEvo.this.startSpeller();
        }

        public String getValidChars(String string) {
            return null;
        }
    }

    private final class MatchSpellerMode
    implements ISpellerMode {
        private MatchSpellerMode() {
        }

        public void spellerModeChanged() {
            OrganizerSearchEvo.this.log.log(1000000, "[TelEvoADBMatchSpellerHandler#MatchSpellerMode#spellerModeChanged]");
        }

        public void textChanged(int n, String string, char c2, int n2) {
            OrganizerSearchEvo.this.log.log(1000000, "[OrganizerSearchEvo#MatchSpellerMode#textChanged] text = %1, latestChar = %2", (Object)string, (long)c2);
            OrganizerSearchEvo.super.textChanged(n, string, c2, n2);
            OrganizerSearchEvo.this.msgApp.getFramework().getHmiServiceApp().getModelApp(n).fireEvent(n2);
        }

        public String getValidChars(String string) {
            return string;
        }
    }

    private final class SpecialCharSearchMode
    implements ISpellerMode {
        private SpecialCharSearchMode() {
        }

        public void spellerModeChanged() {
            OrganizerSearchEvo.this.log.log(1000000, "[OrganizerSearchEvo#SpecialCharSearchMode#spellerModeChanged]");
            OrganizerSearchEvo.this.searchList.removeAll();
        }

        public void textChanged(int n, String string, char c2, int n2) {
            OrganizerSearchEvo.this.log.log(1000000, "[OrganizerSearchEvo#SpecialCharSearchMode#textChanged] text = %1, latestChar= %2", (Object)string, (long)c2);
            OrganizerSearchEvo.this.msgApp.getInterpretationGuessItem().update(string);
            OrganizerSearchEvo.this.getSpellerModel().setText(string);
            OrganizerSearchEvo.this.getSpellerModel().setValidChars(TelIntellicallIGIUtil.VALID_PHONE_NUMBER_SYMBOLS);
            OrganizerSearchEvo.this.getSpellerModel().setStatus(1);
        }

        public String getValidChars(String string) {
            return TelIntellicallIGIUtil.VALID_PHONE_NUMBER_SYMBOLS;
        }
    }

    private final class OrganizerSearchAudiActionProxy
    extends DefaultCoreActionProxy
    implements IActionProxySubscriber {
        private OrganizerSearchAudiActionProxy() {
        }

        public void searchableViewTransition(int n, int n2, int n3) {
            OrganizerSearchEvo.this.log.log(10000000, "[OrganizerSearchEvo#searchableViewTransition]");
            if (n3 == 0 && n2 == 1) {
                OrganizerSearchEvo.this.msgApp.getMessagingAdbHandler().setAdbMode(OrganizerSearchEvo.this.msgApp.getAccountManager().isEmailMode() ? 2 : 0);
                OrganizerSearchEvo.this.enableFiltering(true);
                OrganizerSearchEvo.this.startSearch();
            }
        }
    }
}

