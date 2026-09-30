/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.dsi.ifc.search.Country;

public class TrufflesRangeSelect {
    protected final BaseListModelApp countriesList;
    private final LogChannel lc;
    private final NavigationEnv env;
    protected static final int MAX_COLUMN_COUNT = 5;
    protected static final int COUNTRY_NAME_COLUMN = 0;
    protected static final int RADIO_BUTTON_STATE_COLUMN = 1;
    protected static final int LAYOUT_COLUMN = 2;
    protected static final int COUNTRY_CODE_COLUMN = 3;
    protected static final int COUNTRY_ID_COLUMN = 4;
    private static final int RADIO_BUTTON_UNCHECKED = 0;
    private static final int RADIO_BUTTON_CHECKED = 1;
    private static final int DYNAMIC_COUNTRY_LAYOUT = 0;
    private static final int STATIC_ENTRY_ALL_COUNTRIES = 1;
    protected static final String ALL_COUNTRIES_CODE = "XX";
    protected String lastSelectedCountry;
    protected int lastSelectedCountryIconId;

    public TrufflesRangeSelect(BaseListModelApp baseListModelApp, NavigationEnv navigationEnv, LogChannel logChannel) {
        this.countriesList = baseListModelApp;
        this.env = navigationEnv;
        this.lc = logChannel;
        this.countriesList.setListener(new RangeSelectListListener());
    }

    public void savePersistentState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        TrufflesRangeState trufflesRangeState = new TrufflesRangeState(iStorageAccess, this.lc);
        trufflesRangeState.setCountryCode(this.lastSelectedCountry);
        trufflesRangeState.setCountryIconId(this.lastSelectedCountryIconId);
        trufflesRangeState.serializeAndWrite();
    }

    public void loadPersistentState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        TrufflesRangeState trufflesRangeState = new TrufflesRangeState(iStorageAccess, this.lc);
        trufflesRangeState.readAndDeserialize();
        this.lastSelectedCountry = trufflesRangeState.getRangeSelection();
        this.lastSelectedCountryIconId = trufflesRangeState.getCountryIconId();
        this.setLastSelectedButtonValue(1);
    }

    public void resetSettings() {
        this.setLastSelectedButtonValue(0);
        this.lastSelectedCountry = ALL_COUNTRIES_CODE;
        this.setLastSelectedButtonValue(1);
        this.savePersistentState();
    }

    public void fillList(Country[] countryArray) {
        this.countriesList.removeAll();
        EvoListRow evoListRow = new EvoListRow(this.countriesList.getLength(), 5);
        evoListRow.setInteger(1, 0);
        evoListRow.setInteger(2, 1);
        evoListRow.setText(3, ALL_COUNTRIES_CODE);
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

    private static class TrufflesRangeState
    extends PersistentState {
        private static final int VERSION = 5;
        String persistedCountryCode;
        int persistedCountryIconId;

        public TrufflesRangeState(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 5, 1004, 920, logChannel);
        }

        protected void initWithDefaultValues() {
            this.persistedCountryCode = TrufflesRangeSelect.ALL_COUNTRIES_CODE;
            this.persistedCountryIconId = -1;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.persistedCountryCode = TrufflesRangeSelect.ALL_COUNTRIES_CODE;
            this.persistedCountryIconId = -1;
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            this.serializeStringArray(new String[]{this.persistedCountryCode}, dataOutputStream);
            this.serializeIntArray(new int[]{this.persistedCountryIconId}, dataOutputStream);
            this.logChannel.log(10000000, "TrufflesRangeState serialize: persistedCountryCode=%1, persistedCountryIconId=%2", (Object)this.persistedCountryCode, (long)this.persistedCountryIconId);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            String[] stringArray = this.deserializeStringArray(dataInputStream);
            int[] nArray = this.deserializeIntArray(dataInputStream);
            try {
                this.persistedCountryCode = stringArray[0];
                this.persistedCountryIconId = nArray[0];
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TrufflesRangeState WARNING deserialized: %1, deserializedString=%2, deserializedInt=%3", (Object)exception, (Object)stringArray, (Object)nArray);
                this.persistedCountryCode = TrufflesRangeSelect.ALL_COUNTRIES_CODE;
                this.persistedCountryIconId = -1;
            }
            this.logChannel.log(10000000, "TrufflesRangeState deserialize: persistedCountryCode=%1, persistedCountryIconId=%2", (Object)this.persistedCountryCode, (long)this.persistedCountryIconId);
        }

        public String getRangeSelection() {
            return this.persistedCountryCode;
        }

        public void setCountryCode(String string) {
            this.persistedCountryCode = string;
        }

        public int getCountryIconId() {
            return this.persistedCountryIconId;
        }

        public void setCountryIconId(int n) {
            this.persistedCountryIconId = n;
        }
    }

    private class RangeSelectListListener
    extends DefaultBaseListModelListener {
        private RangeSelectListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            TrufflesRangeSelect.this.lc.log(10000000, "RangeSelectListListener#itemSelected() row=%1, lastSelectedCountry=%2", (Object)evoListRow, (Object)TrufflesRangeSelect.this.lastSelectedCountry);
            String string = evoListRow.getText(3);
            TrufflesRangeSelect.this.setLastSelectedButtonValue(0);
            TrufflesRangeSelect.this.lastSelectedCountry = string;
            TrufflesRangeSelect.this.lastSelectedCountryIconId = evoListRow.getInteger(4);
            TrufflesRangeSelect.this.setLastSelectedButtonValue(1);
        }
    }
}

