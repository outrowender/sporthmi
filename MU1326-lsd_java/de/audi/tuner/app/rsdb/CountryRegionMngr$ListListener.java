/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.rsdb.CountryRegionMngr;
import de.audi.tuner.app.rsdb.CountryRegionMngr$1;
import de.audi.tuner.app.rsdb.CountryRegionMngr$CountryRow;

class CountryRegionMngr$ListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ CountryRegionMngr this$0;

    private CountryRegionMngr$ListListener(CountryRegionMngr countryRegionMngr) {
        this.this$0 = countryRegionMngr;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        int n5 = ((CountryRegionMngr$CountryRow)evoListRow).getCountryId();
        if (this.this$0.selectedRegion != n5) {
            CountryRegionMngr.access$100(this.this$0).log(1078071040, "[CountryRegionMngr.ListListener.itemSelected] selectedRegion: %1", (long)n5);
            CountryRegionMngr.access$200(this.this$0, n5);
        }
    }

    /* synthetic */ CountryRegionMngr$ListListener(CountryRegionMngr countryRegionMngr, CountryRegionMngr$1 countryRegionMngr$1) {
        this(countryRegionMngr);
    }
}

