/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.adb.ITelADBGetADBEntryListener;
import de.audi.app.phone.core.adb.ITelADBHandlerListener;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.adb.TelEntryDetailsListRowBuilder;
import de.audi.app.phone.evo.adb.TelEvoADBMatchSpellerListRow;
import de.audi.app.phone.evo.intellicall.TelEvoADBMatchSpellerHandler;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.phone.TelFavoriteStruct;
import java.util.Map;
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
        this.addSubPhoneComponent(new SpellerContentButtonListener(this.getApplication(), 300468));
        this.addSubPhoneComponent(new ResetSearchResultListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getADBHandler().registerListener(this);
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getOptionModel(300743).setListener(this, this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(300428).setListener(this, this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(300695).setListener(this, this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(300740).setListener(this, this.matchSpellerHandler.getMatchList().getID());
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getOptionModel(300743).removeListener(this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(300428).removeListener(this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(300695).removeListener(this.matchSpellerHandler.getMatchList().getID());
        this.getOptionModel(300740).removeListener(this.matchSpellerHandler.getMatchList().getID());
        this.getApplication().getADBHandler().removeListener(this);
    }

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
        return this.getChoiceModel(300686);
    }

    void resetSpellerContentLabel() {
        this.getSpellerContentLabel().setText(null);
        this.getTelephoneNumberRecognizedChoice().setValue(0);
    }

    private ChoiceModelApp getTelephoneNumberRecognizedChoice() {
        return this.getChoiceModel(300687);
    }

    private LabelModelApp getSpellerContentLabel() {
        return this.getLabelModel(300467);
    }

    private SpellerModelApp getSearchSpellerModel() {
        return this.getSpellerModel(300391);
    }

    void spellerTextChanged(String string) {
        this.getSpellerContentLabel().setText(string);
        this.getTelephoneNumberRecognizedChoice().setValue(1);
    }

    public void clearSearchSpeller() {
        this.log.log(10000000, "TelStdIntellicalSearchModelHanlder#clearSearchSpeller(): called");
        this.getSearchSpellerModel().clear();
        this.showCombinedCallStacks();
        this.resetSpellerContentLabel();
        this.getChoiceModel(300698).setValue(0);
        this.matchSpellerHandler.resetSpellerState();
    }

    public void updateActiveProfile(ProfileInfo profileInfo) {
    }

    public void profileDeleted(int n) {
    }

    public void updateSortOrder(int n, int n2) {
    }

    public void setAdbReady(boolean bl) {
        this.log.log(1000000, "TelIntellicallHandler#setAdbReady(): is ADB ready %1", bl);
        this.matchSpellerHandler.setAdbReady(bl);
    }

    public void handleInvalidData(int n, boolean bl) {
        this.matchSpellerHandler.handleInvalidData(n, bl);
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        int n6;
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelIntellicallHandler#keyTyped] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        if (n2 == (n6 = this.matchSpellerHandler.getMatchList().getID())) {
            EvoListRow evoListRow = this.getTiledListModel(n2).getRow(n3);
            if (n == 300743 && evoListRow instanceof TelEvoADBMatchSpellerListRow) {
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
            if (n == 300695) {
                this.log.log(1000000, "TelStdIntellicalSearchModelHanlder#keyTyped(): TEL_RSL_ADD_TO_FAVORITE_OPTION");
                String string = adbEntry.getCombinedName();
                String string2 = adbEntry.phoneData[n7].number;
                int n8 = adbEntry.phoneData[n7].numberType;
                this.getEvoApplication().getFavoriteHandler().addToFavorites(new TelFavoriteStruct(PhoneUtils.getDisplayName(string, string2), string2, n8));
                this.getOptionModel(300695).fireEvent(n5);
            } else if (n == 300740) {
                this.log.log(10000000, "TelStdIntellicalSearchModelHanlder#keyTyped(): TEL_RSL_EDIT_NUMBER_OPTION");
                String string = adbEntry.phoneData[n7].number;
                this.getButtonModel(300402).setStatus(string.length() > 0 ? 1 : 0);
                this.getSpellerModel(300680).setText(string);
                this.getOptionModel(300740).fireEvent(n5);
            } else if (n == 300428) {
                this.log.log(10000000, "TelStdIntellicalSearchModelHanlder#keyTyped(): TEL_RSL_DIAL_OPTION");
                this.getEvoApplication().getIntellicallHandler().dialNumberFromADBEntry(adbEntry, n7, 0);
            }
        }
    }

    private ITelEvoApplication getEvoApplication() {
        return (ITelEvoApplication)this.getApplication();
    }

    public void onEntrySelected(final ADBSearch aDBSearch, final ADBSearchListRow aDBSearchListRow, int n, int n2) {
        if (aDBSearchListRow == null) {
            this.log.log(10000, "TelStdIntellicalSearchModelHanlder#onEntrySelected selectedRow is null.");
            return;
        }
        this.log.log(1000000, "TelStdIntellicalSearchModelHanlder#onEntrySelected():  \"%1\", entryId: %2", (Object)aDBSearchListRow.getCombinedName(), aDBSearchListRow.getEntryId());
        this.getApplication().getADBHandler().getADBEntry(aDBSearchListRow.getEntryId(), new ITelADBGetADBEntryListener(){

            public void resultGetADBEntry(AdbEntry adbEntry) {
                ADBEntryDetailsListRow[] aDBEntryDetailsListRowArray = TelEntryDetailsListRowBuilder.getTelDetailsRows(adbEntry, new TelEntryDetailsListRowBuilder());
                aDBSearch.setSearchResultDetails(aDBEntryDetailsListRowArray, aDBSearchListRow);
            }
        });
    }

    public void onDetailsSelected(ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, int n2) {
        if (aDBEntryDetailsListRow == null) {
            this.log.log(10000, "TelStdIntellicalSearchModelHanlder#onDetailsSelected entryDetailsRow is null.");
            return;
        }
        this.log.log(1000000, "TelStdIntellicalSearchModelHanlder#onDetailsSelected():  \"%1\", entryId: %2", (Object)aDBEntryDetailsListRow.getCombinedName(), aDBEntryDetailsListRow.getEntryId());
        AdbEntry adbEntry = aDBEntryDetailsListRow.getEntry();
        int n3 = aDBEntryDetailsListRow.getDataIndex();
        if (adbEntry.entryId != 0L) {
            this.getApplication().getTelephoneDSIAccess().dialNumberFromADBEntry(adbEntry, n3, n2);
        } else {
            this.getApplication().getTelephoneDSIAccess().dialNumber(adbEntry.phoneData[n3].number, n2);
        }
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    private void spellerContentButtonSelected(int n) {
        ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumber(this.getSpellerContentLabel().getText(), n);
    }

    private class ResetSearchResultListener
    extends AbstractTelActionProxyListener {
        public ResetSearchResultListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Search", 21);
        }

        protected void actionProxyCalled(Map map) {
            this.log.log(10000000, "TelStdIntellicalSearchModelHanlder.ResetSearchResultListener#actionProxyCalled(): called");
            TelStdIntellicalSearchModelHanlder.this.clearSearchSpeller();
        }
    }

    private class SpellerContentButtonListener
    extends TelDefaultButtonListener {
        public SpellerContentButtonListener(ITelApplication iTelApplication, int n) {
            super(iTelApplication, "App.Phone.Search", n);
        }

        public void keyTyped(int n, int n2, int n3) {
            TelStdIntellicalSearchModelHanlder.this.spellerContentButtonSelected(n3);
            TelStdIntellicalSearchModelHanlder.this.clearSearchSpeller();
        }
    }
}

