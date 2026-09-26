/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search.countryselection;

import de.audi.atip.hmi.model.list.EvoListRow;

public class CountrySelectionRow
extends EvoListRow {
    protected static final int MAX_COLUMN_COUNT;
    protected static final int COLUMN_COUNTRY_NAME;
    protected static final int COLUMN_RADIO_BUTTON_STATE;
    protected static final int COLUMN_LAYOUT;
    private final String countryCode;
    private final String stateCode;
    private final int iconId;

    public CountrySelectionRow(String string, String string2, String string3, int n, int n2, long l) {
        super(l, 3);
        this.setText(0, string);
        this.setInteger(1, 0);
        this.setInteger(2, n2);
        this.countryCode = string2;
        this.stateCode = string3;
        this.iconId = n;
    }

    public CountrySelectionRow(CountrySelectionRow countrySelectionRow) {
        super(countrySelectionRow);
        this.countryCode = countrySelectionRow.countryCode;
        this.stateCode = countrySelectionRow.stateCode;
        this.iconId = countrySelectionRow.iconId;
    }

    @Override
    public EvoListRow copy() {
        return new CountrySelectionRow(this);
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getStateCode() {
        return this.stateCode;
    }

    public int getCountryIconId() {
        return this.iconId;
    }

    public void setRadioButtonStatus(int n) {
        this.setInteger(1, n);
    }
}

