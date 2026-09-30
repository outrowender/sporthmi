/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search.countryselection;

import de.audi.app.navi.evo.search.countryselection.CountrySelectionRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.search.ICountrySelectionView;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.search.Country;

public class CountrySelectionView
implements ICountrySelectionView {
    private static final String EMPTY_COUNTRY_STATE_CODE = "";
    private static final int EMPTY_ICON_ID = 0;
    private final int EXTDATATYPE_STATEABBREAVIATION;
    static final int RADIO_BUTTON_UNCHECKED = 0;
    static final int RADIO_BUTTON_CHECKED = 1;
    static final int DYNAMIC_COUNTRY_LAYOUT = 0;
    static final int STATIC_ENTRY_ALL_COUNTRIES = 1;
    protected static final int ALL_COUNTRIES_ROW_INDEX = 0;
    private final IconHandler iconHandler;
    private final LogChannel logChannel;
    private final BaseListModelApp listCountries;
    private int selectedRowIndex;
    private final ChoiceModelApp countryIconVisible;
    private final ChoiceModelApp countryIconID;
    private final LabelModelApp stateAbbreviationLabel;
    private static final int COUNTRY_ICON_INVISIBLE = 0;
    private static final int COUNTRY_ICON_VISIBLE = 1;
    private static final int COUNTRY_NO_ICON_INDEX = -1;

    public CountrySelectionView(BaseListModelApp baseListModelApp, NavigationEnv navigationEnv, IconHandler iconHandler) {
        this.EXTDATATYPE_STATEABBREAVIATION = 18;
        this.listCountries = baseListModelApp;
        this.logChannel = navigationEnv.getSearchLogChannel();
        this.iconHandler = iconHandler;
        this.listCountries.setListener(new CountrySelectionListListener());
        this.stateAbbreviationLabel = navigationEnv.getLabelModel(402088);
        this.countryIconVisible = navigationEnv.getChoiceModel(401886);
        this.countryIconID = navigationEnv.getChoiceModel(401885);
        this.countryIconID.setValue(-1);
    }

    public void updateCountriesList(Country[] countryArray) {
        this.listCountries.removeAll();
        this.listCountries.append(this.createAllCountriesListRow());
        for (int i2 = 0; i2 < countryArray.length; ++i2) {
            String string = !Util.isEmpty(countryArray[i2].stateName) ? countryArray[i2].stateName : countryArray[i2].name;
            this.listCountries.append(new CountrySelectionRow(string, countryArray[i2].code, countryArray[i2].stateAbbreviation, countryArray[i2].countryID, 0, i2 + 1));
        }
    }

    public void updateCountriesList(LIValueListElement[] lIValueListElementArray) {
        this.listCountries.removeAll();
        this.listCountries.append(this.createAllCountriesListRow());
        int n = this.getUSAIconId(lIValueListElementArray);
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            String string = this.getExtendedDataFromListElement(lIValueListElementArray[i2], 18);
            int n2 = lIValueListElementArray[i2].countryAbbreviation.equalsIgnoreCase("USA") && !Util.isEmpty(string) ? n : lIValueListElementArray[i2].iconIndex;
            this.listCountries.append(new CountrySelectionRow(lIValueListElementArray[i2].data, lIValueListElementArray[i2].countryAbbreviation, string, n2, 0, i2 + 1));
        }
    }

    private CountrySelectionRow createAllCountriesListRow() {
        return new CountrySelectionRow(EMPTY_COUNTRY_STATE_CODE, "XX", EMPTY_COUNTRY_STATE_CODE, 0, 1, 0L);
    }

    private String getExtendedDataFromListElement(LIValueListElement lIValueListElement, int n) {
        for (int i2 = 0; i2 < lIValueListElement.getExtendedData().length; ++i2) {
            if (lIValueListElement.getExtendedData()[i2].getType() != n) continue;
            return lIValueListElement.getExtendedData()[i2].getData();
        }
        return null;
    }

    public String getSelectedRowCode() {
        return this.getCountryCodeForIndex(this.selectedRowIndex);
    }

    private String getCountryCodeForIndex(int n) {
        String string = ((CountrySelectionRow)this.listCountries.getRow(n)).getStateCode();
        String string2 = ((CountrySelectionRow)this.listCountries.getRow(n)).getCountryCode();
        if (!Util.isEmpty(string)) {
            return string;
        }
        return string2;
    }

    public String[] getAllCountryCodes() {
        String[] stringArray = new String[this.listCountries.getLength() - 1];
        for (int i2 = 1; i2 < this.listCountries.getLength(); ++i2) {
            stringArray[i2 - 1] = this.getCountryCodeForIndex(i2);
        }
        return stringArray;
    }

    public int getSelectedCountryIconId() {
        return ((CountrySelectionRow)this.listCountries.getRow(this.selectedRowIndex)).getCountryIconId();
    }

    public void restoreDefaultSelection() {
        this.rowSelected(0);
    }

    public void restorePersistedSelection(String string, int n) {
        for (int i2 = 0; i2 < this.listCountries.getLength(); ++i2) {
            if (!this.getCountryCodeForIndex(i2).equalsIgnoreCase(string)) continue;
            this.logChannel.log(10000000, "CountrySelectionView#restorePersistedSelection found countryCode: %1 on position %2", (Object)string, (long)i2);
            this.rowSelected(i2);
            break;
        }
        this.updateCountryFlagIcon(n, string);
    }

    private void rowSelected(int n) {
        CountrySelectionRow countrySelectionRow;
        if (this.selectedRowIndex >= 0 && this.selectedRowIndex < this.listCountries.getLength()) {
            countrySelectionRow = (CountrySelectionRow)this.listCountries.getRow(this.selectedRowIndex);
            countrySelectionRow.setRadioButtonStatus(0);
            this.listCountries.setRow(this.selectedRowIndex, countrySelectionRow);
        } else {
            this.logChannel.log(100000, "CountrySelectionView#rowSelected( %1 ) selected index is out of range!", (long)n);
        }
        this.selectedRowIndex = n;
        countrySelectionRow = (CountrySelectionRow)this.listCountries.getRow(this.selectedRowIndex);
        countrySelectionRow.setRadioButtonStatus(1);
        this.listCountries.setRow(this.selectedRowIndex, countrySelectionRow);
        this.updateCountryFlagIcon(this.getSelectedCountryIconId(), this.getSelectedRowCode());
        this.updateStateCodeLabel((CountrySelectionRow)this.listCountries.getRow(this.selectedRowIndex));
    }

    private void updateStateCodeLabel(CountrySelectionRow countrySelectionRow) {
        if ("USA".equalsIgnoreCase(countrySelectionRow.getCountryCode()) && !Util.isEmpty(countrySelectionRow.getStateCode())) {
            this.stateAbbreviationLabel.setText(countrySelectionRow.getStateCode());
        } else {
            this.stateAbbreviationLabel.setText(EMPTY_COUNTRY_STATE_CODE);
        }
    }

    private void updateCountryFlagIcon(int n, String string) {
        if ("XX".equals(string)) {
            this.countryIconVisible.setValue(0);
            this.countryIconID.setValue(-1);
        } else {
            int n2 = this.iconHandler.resolveCountryIconResourceID(n);
            this.countryIconVisible.setValue(1);
            this.countryIconID.setValue(n2);
        }
    }

    private int getUSAIconId(LIValueListElement[] lIValueListElementArray) {
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            String string = this.getExtendedDataFromListElement(lIValueListElementArray[i2], 18);
            if (!"USA".equalsIgnoreCase(lIValueListElementArray[i2].countryAbbreviation) || !Util.isEmpty(string)) continue;
            return lIValueListElementArray[i2].iconIndex;
        }
        return -1;
    }

    private class CountrySelectionListListener
    extends DefaultBaseListModelListener {
        private CountrySelectionListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            CountrySelectionView.this.logChannel.log(10000000, "CountrySelectionListListener#itemSelected() row=%1, index=%2", (Object)evoListRow, (long)n2);
            CountrySelectionView.this.rowSelected(n2);
        }
    }
}

