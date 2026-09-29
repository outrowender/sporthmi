/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.search.Country;

public interface ICountrySelectionView {
    public static final String ALL_COUNTRIES_CODE;
    public static final String USA_COUNTRY_CODE;

    default public void updateCountriesList(Country[] countryArray) {
    }

    default public void updateCountriesList(LIValueListElement[] lIValueListElementArray) {
    }

    default public String getSelectedRowCode() {
    }

    default public int getSelectedCountryIconId() {
    }

    default public String[] getAllCountryCodes() {
    }

    default public void restoreDefaultSelection() {
    }

    default public void restorePersistedSelection(String string, int n) {
    }
}

