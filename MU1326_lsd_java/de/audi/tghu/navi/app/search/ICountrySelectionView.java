/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.search.Country;

public interface ICountrySelectionView {
    public static final String ALL_COUNTRIES_CODE = "XX";
    public static final String USA_COUNTRY_CODE = "USA";

    public void updateCountriesList(Country[] var1);

    public void updateCountriesList(LIValueListElement[] var1);

    public String getSelectedRowCode();

    public int getSelectedCountryIconId();

    public String[] getAllCountryCodes();

    public void restoreDefaultSelection();

    public void restorePersistedSelection(String var1, int var2);
}

