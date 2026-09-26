/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.organizer.ViewWindowRequestInfo;
import de.audi.app.addressbook.core.common.search.organizer.commands.ViewWindowCommand;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.adb.AbstractTelADBOrganizerSearch;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.adb.TelEvoADBMatchSpellerListRow;
import de.audi.app.phone.evo.intellicall.ISpellerMode;
import de.audi.app.phone.evo.intellicall.TelEvoADBMatchSpellerHandler$MatchSpellerMode;
import de.audi.app.phone.evo.intellicall.TelEvoADBMatchSpellerHandler$NoneSpellerMode;
import de.audi.app.phone.evo.intellicall.TelEvoADBMatchSpellerHandler$SpecialCharSearchMode;
import de.audi.app.phone.evo.intellicall.TelStdIntellicalSearchModelHanlder;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.interapp.phone.TelIntellicallIGIUtil;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.organizer.DataSet;

public class TelEvoADBMatchSpellerHandler
extends AbstractTelADBOrganizerSearch
implements IGlobalTelephoneStateListener {
    private static final String EMPTY_STRING;
    private volatile boolean isADBReady;
    private final ISpellerMode noneSpellerMode = new TelEvoADBMatchSpellerHandler$NoneSpellerMode(this);
    private final ISpellerMode specialCharsSearchMode = new TelEvoADBMatchSpellerHandler$SpecialCharSearchMode(this);
    private final ISpellerMode matchSpellerMode = new TelEvoADBMatchSpellerHandler$MatchSpellerMode(this, null);
    private volatile ISpellerMode currentSpellerMode = this.noneSpellerMode;
    private TelStdIntellicalSearchModelHanlder stdSearchSpellerHandler;
    private final ITelEvoApplication telEvoApplication;
    private volatile boolean isSpellerOpened;

    public TelEvoADBMatchSpellerHandler(ADBApplication aDBApplication, ITelApplication iTelApplication, LogChannel logChannel) {
        super(iTelApplication.getFrameworkAccess().getHMIService(), aDBApplication, logChannel);
        this.stdSearchSpellerHandler = new TelStdIntellicalSearchModelHanlder(iTelApplication, this);
        this.telEvoApplication = (ITelEvoApplication)iTelApplication;
        this.enableCusorPositioningOnListUpdates(false);
    }

    public void initHandler() {
        this.stdSearchSpellerHandler.init();
    }

    public void deinitHandler() {
        this.stdSearchSpellerHandler.deinit();
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (this.isIdle(iGlobalTelephoneStateStruct) && this.currentSpellerMode instanceof TelEvoADBMatchSpellerHandler$MatchSpellerMode) {
            this.enableCusorPositioningOnListUpdates(true);
        }
    }

    private boolean isIdle(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null && iGlobalTelephoneStateStruct.getCallState().isIdle();
    }

    @Override
    protected EvoListRow[] getRows(DataSet[] dataSetArray) {
        if (dataSetArray == null) {
            this.log.log(10000, "TelEvoADBMatchSpellerHandler#getRows dataSetList is null.");
            return null;
        }
        EvoListRow[] evoListRowArray = new TelEvoADBMatchSpellerListRow[dataSetArray.length];
        for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
            evoListRowArray[i2] = new TelEvoADBMatchSpellerListRow(dataSetArray[i2]);
        }
        return evoListRowArray;
    }

    private void hideMailbox() {
        this.hmiService.getChoiceModel(-1701444608).setValue(1);
    }

    public void entrySelected(long l, String string, ADBSearchListRow aDBSearchListRow, int n) {
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("entryId=");
            buffer.append(l);
            buffer.append(", ");
            buffer.append("combinedName=");
            buffer.append(string);
            buffer.append(", ");
            buffer.append("row=");
            buffer.append(aDBSearchListRow);
            buffer.append(", ");
            buffer.append("index=");
            buffer.append(n);
            this.log.log(1078071040, "[TelEvoADBMatchSpellerHandler#entrySelected] %1", (Object)buffer);
        }
    }

    @Override
    public void setRowOpenState(EvoListRow evoListRow, boolean bl, BaseListModelApp baseListModelApp) {
        if (evoListRow != null && evoListRow instanceof TelEvoADBMatchSpellerListRow) {
            ((TelEvoADBMatchSpellerListRow)evoListRow).setOpen(bl);
            baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(evoListRow.getUniqueID()), evoListRow);
        }
    }

    public void handleInvalidData(int n, boolean bl) {
        Buffer buffer = new Buffer("reason=");
        buffer.append(n).append(" reloadMainList=").append(bl);
        this.log.log(1078071040, new StringBuffer().append("TelEvoADBMatchSpellerHandler#handleInvalidData(): ").append(buffer.toString()).toString());
        this.enableFiltering(true);
        this.startSearch();
    }

    @Override
    public void refreshFromStart() {
        this.log.log(1078071040, "TelEvoADBMatchSpellerHandler#refreshFromStart()");
        if (this.isSpellerOpened) {
            this.log.log(1078071040, "TelEvoADBMatchSpellerHandler#refreshFromStart(): enableCusorPositioningOnListUpdates(false);");
            this.enableCusorPositioningOnListUpdates(false);
            super.refreshFromStart();
        } else {
            ViewWindowRequestInfo viewWindowRequestInfo = new ViewWindowRequestInfo(0, this.currentViewType, this.currentSpellerHandle, true, false);
            ViewWindowCommand.createViewWindowCommand(this.appAdr, viewWindowRequestInfo, this);
        }
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1078071040, "TelEvoADBMatchSpellerHandler#textChanged(): text %1, latestChar: %2", (Object)string, (long)c2);
        this.setupSearchMode(string, c2);
        this.currentSpellerMode.textChanged(n, string, c2, n2);
    }

    private void setupSearchMode(String string, char c2) {
        if (StringUtilities.isNullOrEmpty(string)) {
            this.setupNoneSpellerMode();
        } else if (this.needToDetermineSearchMode(string, c2)) {
            if (TelIntellicallIGIUtil.isSpecialPhoneCharacter(c2) || !this.isADBReady) {
                this.currentSpellerMode = this.specialCharsSearchMode;
                this.enableTelIconInSpeller();
            } else {
                this.currentSpellerMode = this.matchSpellerMode;
                this.disableTelIconInSpeller();
            }
        }
        this.currentSpellerMode.spellerModeChanged();
    }

    private void setupNoneSpellerMode() {
        this.currentSpellerMode = this.noneSpellerMode;
        this.disableTelIconInSpeller();
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.getSpellerModel().getID()) {
            this.telEvoApplication.getIntellicallHandler().dialNumber(this.getSpellerModel().getText(), n3);
        }
    }

    public void setAdbReady(boolean bl) {
        this.isADBReady = bl;
        this.startSearch();
    }

    public void resetSpellerState() {
        this.currentSpellerMode = this.noneSpellerMode;
        this.enableCusorPositioningOnListUpdates(false);
        if (this.isADBReady) {
            this.startSpeller();
        }
    }

    private boolean needToDetermineSearchMode(String string, char c2) {
        return string != null && string.length() == 1 && c2 != '\b';
    }

    @Override
    public void spellerResult(int n, DataSet[] dataSetArray, int n2, String string, String string2) {
        if ("".equals(string2) && this.currentSpellerMode instanceof TelEvoADBMatchSpellerHandler$MatchSpellerMode) {
            this.log.log(1078071040, "TelEvoADBMatchSpellerHandler#spellerResult(): uniqueChars %1, currentSpellerMode %2", (Object)string2, (Object)this.currentSpellerMode.toString());
            this.setupNoneSpellerMode();
            this.currentSpellerMode.spellerModeChanged();
            this.stdSearchSpellerHandler.clearSearchSpeller();
        }
        String string3 = this.prepareValidCharForSearchMode(string);
        super.spellerResult(n, dataSetArray, n2, string3, string2);
    }

    private void disableTelIconInSpeller() {
        this.getSpellerModel().setCommandAvailable(7, false);
    }

    private void enableTelIconInSpeller() {
        this.getSpellerModel().setCommandAvailable(7, true);
    }

    private String prepareValidCharForSearchMode(String string) {
        if (!this.isADBReady) {
            return null;
        }
        return this.currentSpellerMode.getValidChars(string);
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
        this.log.log(1078071040, "TelEvoADBMatchSpellerHandler#commandPressed(): model %1, index %2, terminal %3", (long)n, (long)n2, (long)n3);
        if (n == -845806592) {
            if (n2 == 4711) {
                this.isSpellerOpened = true;
            } else if (n2 == 4712) {
                this.isSpellerOpened = false;
            }
        }
    }

    public TiledListModelApp getMatchList() {
        return this.getMatchListModel();
    }

    static /* synthetic */ LogChannel access$100(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        return telEvoADBMatchSpellerHandler.log;
    }

    static /* synthetic */ TelStdIntellicalSearchModelHanlder access$200(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        return telEvoADBMatchSpellerHandler.stdSearchSpellerHandler;
    }

    static /* synthetic */ void access$300(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        telEvoADBMatchSpellerHandler.hideMailbox();
    }

    static /* synthetic */ LogChannel access$400(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        return telEvoADBMatchSpellerHandler.log;
    }

    static /* synthetic */ void access$501(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler, int n, String string, char c2, int n2) {
        super.textChanged(n, string, c2, n2);
    }

    static /* synthetic */ LogChannel access$600(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        return telEvoADBMatchSpellerHandler.log;
    }

    static /* synthetic */ LogChannel access$700(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        return telEvoADBMatchSpellerHandler.log;
    }

    static /* synthetic */ LogChannel access$800(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        return telEvoADBMatchSpellerHandler.log;
    }

    static /* synthetic */ LogChannel access$900(TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        return telEvoADBMatchSpellerHandler.log;
    }
}

