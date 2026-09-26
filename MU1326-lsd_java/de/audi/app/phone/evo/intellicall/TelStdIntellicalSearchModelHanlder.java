/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.adb.ITelADBHandlerListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.adb.TelEvoADBMatchSpellerListRow;
import de.audi.app.phone.evo.intellicall.TelEvoADBMatchSpellerHandler;
import de.audi.app.phone.evo.intellicall.TelStdIntellicalSearchModelHanlder$1;
import de.audi.app.phone.evo.intellicall.TelStdIntellicalSearchModelHanlder$ResetSearchResultListener;
import de.audi.app.phone.evo.intellicall.TelStdIntellicalSearchModelHanlder$SpellerContentButtonListener;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.phone.TelFavoriteStruct;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.ProfileInfo;

public class TelStdIntellicalSearchModelHanlder
extends AbstractPhoneComponent
implements ITelADBHandlerListener,
OptionModelListener {
    private final TelEvoADBMatchSpellerHandler matchSpellerHandler;

    public TelStdIntellicalSearchModelHanlder(ITelApplication iTelApplication, TelEvoADBMatchSpellerHandler telEvoADBMatchSpellerHandler) {
        super(iTelApplication, "App.Phone.Main");
        this.matchSpellerHandler = telEvoADBMatchSpellerHandler;
        this.addSubPhoneComponent(new TelStdIntellicalSearchModelHanlder$SpellerContentButtonListener(this, this.getApplication(), -1265302528));
        this.addSubPhoneComponent(new TelStdIntellicalSearchModelHanlder$ResetSearchResultListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getADBHandler().registerListener(this);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getOptionModel(-946469888).setListener(this, this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(-1936391168).setListener(this, this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(-1751776256).setListener(this, this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(-996801536).setListener(this, this.matchSpellerHandler.getMatchList().getID());
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getOptionModel(-946469888).removeListener(this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(-1936391168).removeListener(this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(-1751776256).removeListener(this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(-996801536).removeListener(this.matchSpellerHandler.getMatchList().getID());
        this.getApplication().getADBHandler().removeListener(this);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (!iGlobalTelephoneStateStruct.isPhoneReady()) {
            this.clearSearchSpeller();
        }
    }

    void showCombinedCallStacks() {
        this.getIntellicalModeChoice().setValue(1);
    }

    void showSearchResultList() {
        this.getIntellicalModeChoice().setValue(0);
    }

    private ChoiceModelApp getIntellicalModeChoice() {
        return this.getChoiceModel(-1902771200);
    }

    void resetSpellerContentLabel() {
        this.getSpellerContentLabel().setText(null);
        this.getTelephoneNumberRecognizedChoice().setValue(0);
    }

    private ChoiceModelApp getTelephoneNumberRecognizedChoice() {
        return this.getChoiceModel(-1885993984);
    }

    private LabelModelApp getSpellerContentLabel() {
        return this.getLabelModel(-1282079744);
    }

    private SpellerModelApp getSearchSpellerModel() {
        return this.getSpellerModel(1737819136);
    }

    void spellerTextChanged(String string) {
        this.getSpellerContentLabel().setText(string);
        this.getTelephoneNumberRecognizedChoice().setValue(1);
    }

    public void clearSearchSpeller() {
        this.log.log(-2137614336, "TelStdIntellicalSearchModelHanlder#clearSearchSpeller(): called");
        this.getSearchSpellerModel().clear();
        this.showCombinedCallStacks();
        this.resetSpellerContentLabel();
        this.getChoiceModel(-1701444608).setValue(0);
        this.matchSpellerHandler.resetSpellerState();
    }

    @Override
    public void updateActiveProfile(ProfileInfo profileInfo) {
    }

    @Override
    public void profileDeleted(int n) {
    }

    @Override
    public void updateSortOrder(int n, int n2) {
    }

    @Override
    public void setAdbReady(boolean bl) {
        this.log.log(1078071040, "TelIntellicallHandler#setAdbReady(): is ADB ready %1", bl);
        this.matchSpellerHandler.setAdbReady(bl);
    }

    @Override
    public void handleInvalidData(int n, boolean bl) {
        this.matchSpellerHandler.handleInvalidData(n, bl);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        int n6;
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelIntellicallHandler#keyTyped] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        if (n2 == (n6 = this.matchSpellerHandler.getMatchList().getID())) {
            EvoListRow evoListRow = this.getTiledListModel(n2).getRow(n3);
            if (n == -946469888 && evoListRow instanceof TelEvoADBMatchSpellerListRow) {
                long l = ((TelEvoADBMatchSpellerListRow)evoListRow).getEntryId();
                this.getApplication().getADBHandler().showEntryDetails(l);
                this.getOptionModel(n).fireEvent(n5);
            }
            AdbEntry adbEntry = null;
            int n7 = -1;
            EvoListRow evoListRow2 = this.getTiledListModel(n2).getRow(n3);
            if (!(evoListRow2 instanceof ADBEntryDetailsListRow)) {
                return;
            }
            n7 = ((ADBEntryDetailsListRow)evoListRow2).getDataIndex();
            adbEntry = ((ADBEntryDetailsListRow)evoListRow2).getEntry();
            if (n == -1751776256) {
                this.log.log(1078071040, "TelStdIntellicalSearchModelHanlder#keyTyped(): TEL_RSL_ADD_TO_FAVORITE_OPTION");
                String string = adbEntry.getCombinedName();
                String string2 = adbEntry.phoneData[n7].number;
                int n8 = adbEntry.phoneData[n7].numberType;
                this.getEvoApplication().getFavoriteHandler().addToFavorites(new TelFavoriteStruct(PhoneUtils.getDisplayName(string, string2), string2, n8));
                this.getOptionModel(-1751776256).fireEvent(n5);
            } else if (n == -996801536) {
                this.log.log(-2137614336, "TelStdIntellicalSearchModelHanlder#keyTyped(): TEL_RSL_EDIT_NUMBER_OPTION");
                String string = adbEntry.phoneData[n7].number;
                this.getButtonModel(1922368512).setStatus(string.length() > 0 ? 1 : 0);
                this.getSpellerModel(-2003434496).setText(string);
                this.getOptionModel(-996801536).fireEvent(n5);
            } else if (n == -1936391168) {
                this.log.log(-2137614336, "TelStdIntellicalSearchModelHanlder#keyTyped(): TEL_RSL_DIAL_OPTION");
                this.getEvoApplication().getIntellicallHandler().dialNumberFromADBEntry(adbEntry, n7, 0);
            }
        }
    }

    private ITelEvoApplication getEvoApplication() {
        return (ITelEvoApplication)this.getApplication();
    }

    @Override
    public void onEntrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
        if (aDBSearchListRow == null) {
            this.log.log(10000, "TelStdIntellicalSearchModelHanlder#onEntrySelected selectedRow is null.");
            return;
        }
        this.log.log(1078071040, "TelStdIntellicalSearchModelHanlder#onEntrySelected():  \"%1\", entryId: %2", (Object)aDBSearchListRow.getCombinedName(), aDBSearchListRow.getEntryId());
        this.getApplication().getADBHandler().getADBEntry(aDBSearchListRow.getEntryId(), new TelStdIntellicalSearchModelHanlder$1(this, aDBSearch, aDBSearchListRow));
    }

    @Override
    public void onDetailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
        if (aDBEntryDetailsListRow == null) {
            this.log.log(10000, "TelStdIntellicalSearchModelHanlder#onDetailsSelected entryDetailsRow is null.");
            return;
        }
        this.log.log(1078071040, "TelStdIntellicalSearchModelHanlder#onDetailsSelected():  \"%1\", entryId: %2", (Object)aDBEntryDetailsListRow.getCombinedName(), aDBEntryDetailsListRow.getEntryId());
        AdbEntry adbEntry = aDBEntryDetailsListRow.getEntry();
        int n3 = aDBEntryDetailsListRow.getDataIndex();
        if (adbEntry.entryId != 0L) {
            this.getApplication().getTelephoneDSIAccess().dialNumberFromADBEntry(adbEntry, n3, n2);
        } else {
            this.getApplication().getTelephoneDSIAccess().dialNumber(adbEntry.phoneData[n3].number, n2);
        }
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    private void spellerContentButtonSelected(int n) {
        ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumber(this.getSpellerContentLabel().getText(), n);
    }

    static /* synthetic */ void access$000(TelStdIntellicalSearchModelHanlder telStdIntellicalSearchModelHanlder, int n) {
        telStdIntellicalSearchModelHanlder.spellerContentButtonSelected(n);
    }
}

