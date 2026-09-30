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
    private static final String EMPTY_STRING = "";
    private volatile boolean isADBReady;
    private final ISpellerMode noneSpellerMode = new NoneSpellerMode();
    private final ISpellerMode specialCharsSearchMode = new SpecialCharSearchMode();
    private final ISpellerMode matchSpellerMode = new MatchSpellerMode();
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

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (this.isIdle(iGlobalTelephoneStateStruct) && this.currentSpellerMode instanceof MatchSpellerMode) {
            this.enableCusorPositioningOnListUpdates(true);
        }
    }

    private boolean isIdle(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallState() != null && iGlobalTelephoneStateStruct.getCallState().isIdle();
    }

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
        this.hmiService.getChoiceModel(300698).setValue(1);
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
            this.log.log(1000000, "[TelEvoADBMatchSpellerHandler#entrySelected] %1", (Object)buffer);
        }
    }

    public void setRowOpenState(EvoListRow evoListRow, boolean bl, BaseListModelApp baseListModelApp) {
        if (evoListRow != null && evoListRow instanceof TelEvoADBMatchSpellerListRow) {
            ((TelEvoADBMatchSpellerListRow)evoListRow).setOpen(bl);
            baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(evoListRow.getUniqueID()), evoListRow);
        }
    }

    public void handleInvalidData(int n, boolean bl) {
        Buffer buffer = new Buffer("reason=");
        buffer.append(n).append(" reloadMainList=").append(bl);
        this.log.log(1000000, new StringBuffer().append("TelEvoADBMatchSpellerHandler#handleInvalidData(): ").append(buffer.toString()).toString());
        this.enableFiltering(true);
        this.startSearch();
    }

    public void refreshFromStart() {
        this.log.log(1000000, "TelEvoADBMatchSpellerHandler#refreshFromStart()");
        if (this.isSpellerOpened) {
            this.log.log(1000000, "TelEvoADBMatchSpellerHandler#refreshFromStart(): enableCusorPositioningOnListUpdates(false);");
            this.enableCusorPositioningOnListUpdates(false);
            super.refreshFromStart();
        } else {
            ViewWindowRequestInfo viewWindowRequestInfo = new ViewWindowRequestInfo(0, this.currentViewType, this.currentSpellerHandle, true, false);
            ViewWindowCommand.createViewWindowCommand(this.appAdr, viewWindowRequestInfo, this);
        }
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1000000, "TelEvoADBMatchSpellerHandler#textChanged(): text %1, latestChar: %2", (Object)string, (long)c2);
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

    public void spellerResult(int n, DataSet[] dataSetArray, int n2, String string, String string2) {
        if (EMPTY_STRING.equals(string2) && this.currentSpellerMode instanceof MatchSpellerMode) {
            this.log.log(1000000, "TelEvoADBMatchSpellerHandler#spellerResult(): uniqueChars %1, currentSpellerMode %2", (Object)string2, (Object)this.currentSpellerMode.toString());
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

    public void commandPressed(int n, int n2, int n3) {
        this.log.log(1000000, "TelEvoADBMatchSpellerHandler#commandPressed(): model %1, index %2, terminal %3", (long)n, (long)n2, (long)n3);
        if (n == 300749) {
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

    public class NoneSpellerMode
    implements ISpellerMode {
        public void spellerModeChanged() {
            TelEvoADBMatchSpellerHandler.this.enableCusorPositioningOnListUpdates(false);
            TelEvoADBMatchSpellerHandler.this.log.log(10000000, "TelEvoADBMatchSpellerHandler.NoneSpellerMode#spellerModeChanged(): called");
        }

        public void textChanged(int n, String string, char c2, int n2) {
            TelEvoADBMatchSpellerHandler.this.log.log(10000000, "TelEvoADBMatchSpellerHandler.NoneSpellerMode#textChanged(): text %1, latestChar %2", (Object)string, (long)c2);
            TelEvoADBMatchSpellerHandler.this.stdSearchSpellerHandler.clearSearchSpeller();
        }

        public String getValidChars(String string) {
            return null;
        }
    }

    private class MatchSpellerMode
    implements ISpellerMode {
        private MatchSpellerMode() {
        }

        public void spellerModeChanged() {
            TelEvoADBMatchSpellerHandler.this.log.log(10000000, "TelEvoADBMatchSpellerHandler.MatchSpellerMode#spellerModeChanged(): called");
            TelEvoADBMatchSpellerHandler.this.stdSearchSpellerHandler.showSearchResultList();
            TelEvoADBMatchSpellerHandler.this.hideMailbox();
            TelEvoADBMatchSpellerHandler.this.enableCusorPositioningOnListUpdates(true);
        }

        public void textChanged(int n, String string, char c2, int n2) {
            TelEvoADBMatchSpellerHandler.this.log.log(10000000, "TelEvoADBMatchSpellerHandler.MatchSpellerMode#textChanged(): text %1, latestChar %2", (Object)string, (long)c2);
            TelEvoADBMatchSpellerHandler.super.textChanged(n, string, c2, n2);
        }

        public String getValidChars(String string) {
            return string;
        }
    }

    public class SpecialCharSearchMode
    implements ISpellerMode {
        public void spellerModeChanged() {
            TelEvoADBMatchSpellerHandler.this.enableCusorPositioningOnListUpdates(false);
            TelEvoADBMatchSpellerHandler.this.log.log(10000000, "TelEvoADBMatchSpellerHandler.SpecialCharSearchMode#spellerModeChanged(): called");
            TelEvoADBMatchSpellerHandler.this.getMatchList().removeAll();
        }

        public void textChanged(int n, String string, char c2, int n2) {
            TelEvoADBMatchSpellerHandler.this.log.log(10000000, "TelEvoADBMatchSpellerHandler.SpecialCharSearchMode#textChanged(): text %1, latestChar %2", (Object)string, (long)c2);
            TelEvoADBMatchSpellerHandler.this.stdSearchSpellerHandler.spellerTextChanged(string);
            TelEvoADBMatchSpellerHandler.this.getSpellerModel().setText(string);
            TelEvoADBMatchSpellerHandler.this.getSpellerModel().setValidChars(TelIntellicallIGIUtil.VALID_PHONE_NUMBER_SYMBOLS);
            TelEvoADBMatchSpellerHandler.this.getSpellerModel().setStatus(1);
        }

        public String getValidChars(String string) {
            return TelIntellicallIGIUtil.VALID_PHONE_NUMBER_SYMBOLS;
        }
    }
}

