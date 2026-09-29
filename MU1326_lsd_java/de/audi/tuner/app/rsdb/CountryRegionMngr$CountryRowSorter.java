/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.rsdb.CountryRegionMngr$CountryRow;
import java.util.Comparator;

class CountryRegionMngr$CountryRowSorter
implements Comparator {
    private final transient LanguageManager langMngr;

    public CountryRegionMngr$CountryRowSorter(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    @Override
    public int compare(Object object, Object object2) {
        CountryRegionMngr$CountryRow countryRegionMngr$CountryRow = (CountryRegionMngr$CountryRow)object;
        CountryRegionMngr$CountryRow countryRegionMngr$CountryRow2 = (CountryRegionMngr$CountryRow)object2;
        int n = countryRegionMngr$CountryRow.getSortId();
        int n2 = countryRegionMngr$CountryRow2.getSortId();
        if (n == 128 || n2 == 128) {
            return this.langMngr.getCollator().compare(countryRegionMngr$CountryRow.getText(0), countryRegionMngr$CountryRow2.getText(0));
        }
        return n - n2;
    }
}

