/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.search.TrufflesRangeSelect;
import de.audi.tghu.navi.app.search.TrufflesRangeSelect$1;

class TrufflesRangeSelect$RangeSelectListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ TrufflesRangeSelect this$0;

    private TrufflesRangeSelect$RangeSelectListListener(TrufflesRangeSelect trufflesRangeSelect) {
        this.this$0 = trufflesRangeSelect;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        TrufflesRangeSelect.access$100(this.this$0).log(-2137614336, "RangeSelectListListener#itemSelected() row=%1, lastSelectedCountry=%2", (Object)evoListRow, (Object)this.this$0.lastSelectedCountry);
        String string = evoListRow.getText(3);
        TrufflesRangeSelect.access$200(this.this$0, 0);
        this.this$0.lastSelectedCountry = string;
        this.this$0.lastSelectedCountryIconId = evoListRow.getInteger(4);
        TrufflesRangeSelect.access$200(this.this$0, 1);
    }

    /* synthetic */ TrufflesRangeSelect$RangeSelectListListener(TrufflesRangeSelect trufflesRangeSelect, TrufflesRangeSelect$1 trufflesRangeSelect$1) {
        this(trufflesRangeSelect);
    }
}

