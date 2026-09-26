/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.settings.parental.ParentalLevelList;
import de.audi.tv.app.settings.parental.ParentalLevelList$1;
import de.audi.tv.app.settings.parental.ParentalLevelList$ParentalLevelRow;

class ParentalLevelList$ListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ ParentalLevelList this$0;

    private ParentalLevelList$ListListener(ParentalLevelList parentalLevelList) {
        this.this$0 = parentalLevelList;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        ParentalLevelList.access$200((ParentalLevelList)this.this$0).lcHMI.log(-2137614336, "[ParentalLevelList.itemSelected] selected:%1", (long)n2);
        int n5 = ParentalLevelList.access$300(this.this$0).getSelected().getIndex();
        if (n2 != n5) {
            ParentalLevelList$ParentalLevelRow parentalLevelList$ParentalLevelRow = (ParentalLevelList$ParentalLevelRow)ParentalLevelList.access$300(this.this$0).getRow(n5);
            parentalLevelList$ParentalLevelRow.setSelected(0);
            ((ParentalLevelList$ParentalLevelRow)evoListRow).setSelected(1);
            ParentalLevelList.access$400(this.this$0).setValue(n2);
            ParentalLevelList.access$300(this.this$0).setRow(n2, evoListRow);
            ParentalLevelList.access$300(this.this$0).setRow(n5, parentalLevelList$ParentalLevelRow);
            ParentalLevelList.access$300(this.this$0).setSelectedIndex(n2);
            ParentalLevelList.access$500(this.this$0).saveParentalLevel(n2);
            int n6 = ParentalLevelList.access$600(this.this$0);
            if (ParentalLevelList.access$700(this.this$0) > n6 && n6 != 0) {
                ParentalLevelList.access$800(this.this$0).onChildLockEnabled();
                ParentalLevelList.access$200(this.this$0).getChoiceModel(-1867766016).setValue(1);
            } else {
                ParentalLevelList.access$200(this.this$0).getChoiceModel(-1867766016).setValue(0);
                ParentalLevelList.access$800(this.this$0).onChildLockDisabled();
            }
            ParentalLevelList.access$800(this.this$0).parentalLevelSettingChanged(n6);
            ParentalLevelList.access$300(this.this$0).fireEvent(n4);
        }
    }

    /* synthetic */ ParentalLevelList$ListListener(ParentalLevelList parentalLevelList, ParentalLevelList$1 parentalLevelList$1) {
        this(parentalLevelList);
    }
}

