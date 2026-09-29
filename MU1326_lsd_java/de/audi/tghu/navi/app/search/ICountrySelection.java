/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import org.dsi.ifc.search.Country;

public interface ICountrySelection {
    default public void updateCountriesList(Country[] countryArray) {
    }

    default public void loadCountriesFromNavigation() {
    }

    default public void loadPersistentState() {
    }

    default public void savePersistentState() {
    }

    default public String[] getActiveCountries() {
    }

    default public String[] getAllCountries() {
    }

    default public void resetSettings() {
    }
}

