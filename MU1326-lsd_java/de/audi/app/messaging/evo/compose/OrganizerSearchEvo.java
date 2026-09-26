/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.addressbook.evo.common.search.organizer.ADBEvoOrganizerSearchListRow;
import de.audi.app.messaging.core.addressbook.MessagingAdbHandler;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.compose.AbstractOrganizerSearch;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$ISpellerMode;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$MatchSpellerMode;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$NoneSpellerMode;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$OrganizerSearchAudiActionProxy;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo$SpecialCharSearchMode;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.interapp.phone.TelIntellicallIGIUtil;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import org.dsi.ifc.organizer.DataSet;

public final class OrganizerSearchEvo
extends AbstractOrganizerSearch {
    private final OrganizerSearchEvo$ISpellerMode noneSpellerMode = new OrganizerSearchEvo$NoneSpellerMode(this);
    private final OrganizerSearchEvo$ISpellerMode specialCharsSearchMode = new OrganizerSearchEvo$SpecialCharSearchMode(this, null);
    private final OrganizerSearchEvo$ISpellerMode matchSpellerMode = new OrganizerSearchEvo$MatchSpellerMode(this, null);
    private volatile OrganizerSearchEvo$ISpellerMode currentSpellerMode = this.noneSpellerMode;

    public OrganizerSearchEvo(MessagingBundleContext messagingBundleContext, MessagingAdbHandler messagingAdbHandler) {
        super(messagingBundleContext, messagingAdbHandler);
        this.getSpellerModel().setMinLength(0);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getActionProxyService().addSubscriber(new OrganizerSearchEvo$OrganizerSearchAudiActionProxy(this, null));
    }

    @Override
    public EvoListRow[] createSearchListRows(DataSet[] dataSetArray) {
        return ADBEvoOrganizerSearchListRow.createFromDataSets(dataSetArray, this.appAdr.getAdbMode(), -1);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1078071040, "[OrganizerSearchEvo#textChanged]");
        this.setupSearchMode(string, c2);
        this.currentSpellerMode.textChanged(n, string, c2, n2);
    }

    @Override
    public void setRowOpenState(EvoListRow evoListRow, boolean bl, BaseListModelApp baseListModelApp) {
        if (evoListRow != null && evoListRow instanceof ADBEvoOrganizerSearchListRow) {
            ((ADBEvoOrganizerSearchListRow)evoListRow).setOpen(bl);
            baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(evoListRow.getUniqueID()), evoListRow);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(-2137614336, "[OrganizerSearchEvo#keyTyped] Autoselecting the only search result");
        this.msgApp.getFramework().getHmiServiceApp().getModelApp(n).fireEvent(n3);
        if (this.getListLength() == 1) {
            this.selectListItem(0, n3);
        }
    }

    public void selectListItem(int n, int n2) {
        this.log.log(-2137614336, "[OrganizerSearchEvo#selectListItem] index = %1, terminalId = %2", (long)n, (long)n2);
        EvoListRow evoListRow = this.searchList.getRow(n);
        this.itemSelected(evoListRow, this.searchList.getID(), 0, 0, n2);
        this.menu.setFocusedItem(this.searchList.getID(), FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
    }

    @Override
    public void spellerResult(int n, DataSet[] dataSetArray, int n2, String string, String string2) {
        this.log.log(1078071040, "[TelEvoADBMatchSpellerHandler#spellerResult] uniqueChars = %1, currentSpellerMode = %2", (Object)string2, (Object)String.valueOf(this.currentSpellerMode));
        if ("".equals(string2) && this.currentSpellerMode instanceof OrganizerSearchEvo$MatchSpellerMode) {
            this.setSpellerMode(this.noneSpellerMode);
            this.clearSearchSpeller();
        }
        String string3 = this.prepareValidCharForSearchMode(string);
        super.spellerResult(n, dataSetArray, n2, string3, string2);
    }

    private void setupSearchMode(String string, char c2) {
        OrganizerSearchEvo$ISpellerMode organizerSearchEvo$ISpellerMode = this.currentSpellerMode;
        if (StringUtilities.isNullOrEmpty(string)) {
            organizerSearchEvo$ISpellerMode = this.noneSpellerMode;
        } else if (this.needToDetermineSearchMode(string, c2)) {
            organizerSearchEvo$ISpellerMode = TelIntellicallIGIUtil.isSpecialPhoneCharacter(c2) ? this.specialCharsSearchMode : this.matchSpellerMode;
        }
        this.setSpellerMode(organizerSearchEvo$ISpellerMode);
    }

    private void setSpellerMode(OrganizerSearchEvo$ISpellerMode organizerSearchEvo$ISpellerMode) {
        this.log.log(-2137614336, "[OrganizerSearchEvo#setSpellerMode] spellerMode = %1", (Object)organizerSearchEvo$ISpellerMode);
        this.currentSpellerMode = organizerSearchEvo$ISpellerMode;
        this.currentSpellerMode.spellerModeChanged();
    }

    private boolean needToDetermineSearchMode(String string, char c2) {
        return string != null && string.length() == 1 && c2 != '\b';
    }

    @Override
    protected void startSpeller() {
        super.startSpeller();
        this.msgApp.getInterpretationGuessItem().update("");
    }

    private void clearSearchSpeller() {
        this.log.log(-2137614336, "[OrganizerSearchEvo#clearSearchSpeller]");
        this.getSpellerModel().clear();
        this.msgApp.getInterpretationGuessItem().update("");
    }

    private String prepareValidCharForSearchMode(String string) {
        if (!this.msgApp.getMessagingAdbHandler().isAdbReady()) {
            return null;
        }
        return this.currentSpellerMode.getValidChars(string);
    }

    static /* synthetic */ LogChannel access$300(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.log;
    }

    static /* synthetic */ LogChannel access$400(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.log;
    }

    static /* synthetic */ void access$501(OrganizerSearchEvo organizerSearchEvo, int n, String string, char c2, int n2) {
        super.textChanged(n, string, c2, n2);
    }

    static /* synthetic */ AbstractMsgApplication access$600(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.msgApp;
    }

    static /* synthetic */ LogChannel access$700(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.log;
    }

    static /* synthetic */ LogChannel access$800(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.log;
    }

    static /* synthetic */ void access$900(OrganizerSearchEvo organizerSearchEvo) {
        organizerSearchEvo.clearSearchSpeller();
    }

    static /* synthetic */ LogChannel access$1000(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.log;
    }

    static /* synthetic */ TiledListModelApp access$1100(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.searchList;
    }

    static /* synthetic */ LogChannel access$1200(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.log;
    }

    static /* synthetic */ AbstractMsgApplication access$1300(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.msgApp;
    }

    static /* synthetic */ LogChannel access$1400(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.log;
    }

    static /* synthetic */ AbstractMsgApplication access$1500(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$1600(OrganizerSearchEvo organizerSearchEvo) {
        return organizerSearchEvo.msgApp;
    }
}

