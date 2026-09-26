/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search.countryselection;

import de.audi.app.navi.evo.search.countryselection.CountrySelectionView;
import de.audi.app.navi.evo.search.countryselection.CountrySelectionView$1;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;

class CountrySelectionView$CountrySelectionListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ CountrySelectionView this$0;

    private CountrySelectionView$CountrySelectionListListener(CountrySelectionView countrySelectionView) {
        this.this$0 = countrySelectionView;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        CountrySelectionView.access$100(this.this$0).log(-2137614336, "CountrySelectionListListener#itemSelected() row=%1, index=%2", (Object)evoListRow, (long)n2);
        CountrySelectionView.access$200(this.this$0, n2);
    }

    /* synthetic */ CountrySelectionView$CountrySelectionListListener(CountrySelectionView countrySelectionView, CountrySelectionView$1 countrySelectionView$1) {
        this(countrySelectionView);
    }
}

