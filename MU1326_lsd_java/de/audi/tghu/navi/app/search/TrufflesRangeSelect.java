/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.search.TrufflesRangeSelect$RangeSelectListListener;
import de.audi.tghu.navi.app.search.TrufflesRangeSelect$TrufflesRangeState;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.search.Country;

public class TrufflesRangeSelect {
    protected final BaseListModelApp countriesList;
    private final LogChannel lc;
    private final NavigationEnv env;
    protected static final int MAX_COLUMN_COUNT;
    protected static final int COUNTRY_NAME_COLUMN;
    protected static final int RADIO_BUTTON_STATE_COLUMN;
    protected static final int LAYOUT_COLUMN;
    protected static final int COUNTRY_CODE_COLUMN;
    protected static final int COUNTRY_ID_COLUMN;
    private static final int RADIO_BUTTON_UNCHECKED;
    private static final int RADIO_BUTTON_CHECKED;
    private static final int DYNAMIC_COUNTRY_LAYOUT;
    private static final int STATIC_ENTRY_ALL_COUNTRIES;
    protected static final String ALL_COUNTRIES_CODE;
    protected String lastSelectedCountry;
    protected int lastSelectedCountryIconId;

    public TrufflesRangeSelect(BaseListModelApp baseListModelApp, NavigationEnv navigationEnv, LogChannel logChannel) {
        this.countriesList = baseListModelApp;
        this.env = navigationEnv;
        this.lc = logChannel;
        this.countriesList.setListener(new TrufflesRangeSelect$RangeSelectListListener(this, null));
    }

    public void savePersistentState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        TrufflesRangeSelect$TrufflesRangeState trufflesRangeSelect$TrufflesRangeState = new TrufflesRangeSelect$TrufflesRangeState(iStorageAccess, this.lc);
        trufflesRangeSelect$TrufflesRangeState.setCountryCode(this.lastSelectedCountry);
        trufflesRangeSelect$TrufflesRangeState.setCountryIconId(this.lastSelectedCountryIconId);
        trufflesRangeSelect$TrufflesRangeState.serializeAndWrite();
    }

    public void loadPersistentState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        TrufflesRangeSelect$TrufflesRangeState trufflesRangeSelect$TrufflesRangeState = new TrufflesRangeSelect$TrufflesRangeState(iStorageAccess, this.lc);
        trufflesRangeSelect$TrufflesRangeState.readAndDeserialize();
        this.lastSelectedCountry = trufflesRangeSelect$TrufflesRangeState.getRangeSelection();
        this.lastSelectedCountryIconId = trufflesRangeSelect$TrufflesRangeState.getCountryIconId();
        this.setLastSelectedButtonValue(1);
    }

    public void resetSettings() {
        this.setLastSelectedButtonValue(0);
        this.lastSelectedCountry = "XX";
        this.setLastSelectedButtonValue(1);
        this.savePersistentState();
    }

    public void fillList(Country[] countryArray) {
        this.countriesList.removeAll();
        EvoListRow evoListRow = new EvoListRow(this.countriesList.getLength(), 5);
        evoListRow.setInteger(1, 0);
        evoListRow.setInteger(2, 1);
        evoListRow.setText(3, "XX");
        evoListRow.setInteger(4, -1);
        this.countriesList.append(evoListRow);
        for (int i2 = 0; i2 < countryArray.length; ++i2) {
            EvoListRow evoListRow2 = new EvoListRow(this.countriesList.getLength(), 5);
            evoListRow2.setText(0, countryArray[i2].name);
            evoListRow2.setInteger(1, 0);
            evoListRow2.setInteger(2, 0);
            if (Util.isHURegionNAR()) {
                String string = countryArray[i2].stateAbbreviation;
                if (string != null && "United States".equals(countryArray[i2].name)) {
                    evoListRow2.setText(3, countryArray[i2].code);
                }
                evoListRow2.setText(3, string != null ? string : countryArray[i2].code);
            } else {
                evoListRow2.setText(3, countryArray[i2].code);
            }
            evoListRow2.setInteger(4, countryArray[i2].countryID);
            this.countriesList.append(evoListRow2);
        }
    }

    public String[] getActiveCountries() {
        EvoListRow evoListRow = this.countriesList.getRow(0);
        if (evoListRow.getInteger(1) == 1) {
            return this.getAllCountryCodes();
        }
        for (int i2 = 1; i2 < this.countriesList.getLength(); ++i2) {
            EvoListRow evoListRow2 = this.countriesList.getRow(i2);
            if (evoListRow2.getInteger(1) != 1) continue;
            return new String[]{evoListRow2.getText(3)};
        }
        this.lc.log(10000, "TrufflesRangeSelect#getActiveCountries() no checked radio button found, return all country codes");
        return this.getAllCountryCodes();
    }

    private String[] getAllCountryCodes() {
        String[] stringArray = new String[this.countriesList.getLength() - 1];
        for (int i2 = 1; i2 < this.countriesList.getLength(); ++i2) {
            EvoListRow evoListRow = this.countriesList.getRow(i2);
            stringArray[i2 - 1] = evoListRow.getText(3);
        }
        return stringArray;
    }

    private void setLastSelectedButtonValue(int n) {
        for (int i2 = 0; i2 < this.countriesList.getLength(); ++i2) {
            EvoListRow evoListRow = this.countriesList.getRow(i2);
            if (!evoListRow.getText(3).equals(this.lastSelectedCountry)) continue;
            evoListRow.setInteger(1, n);
            this.countriesList.setRow(this.countriesList.getIndexForUniqueID(evoListRow.getUniqueID()), evoListRow);
            break;
        }
    }

    static /* synthetic */ LogChannel access$100(TrufflesRangeSelect trufflesRangeSelect) {
        return trufflesRangeSelect.lc;
    }

    static /* synthetic */ void access$200(TrufflesRangeSelect trufflesRangeSelect, int n) {
        trufflesRangeSelect.setLastSelectedButtonValue(n);
    }
}

