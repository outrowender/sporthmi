/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import org.dsi.ifc.search.Country;

public interface ICountrySelection {
    public void updateCountriesList(Country[] var1);

    public void loadCountriesFromNavigation();

    public void loadPersistentState();

    public void savePersistentState();

    public String[] getActiveCountries();

    public String[] getAllCountries();

    public void resetSettings();
}

