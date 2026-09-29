/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tghu.swdl.app.customer.uota.AbstractPkgListRow;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$8
extends DefaultChoiceListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$8(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.NaviToggleRegionsChoiceListener].itemSelected(): Regions selection toggled!");
        UotaModelListener.access$100(this.this$0).toggleRowSelection((AbstractPkgListRow)UotaModelListener.access$200(this.this$0).getNaviRegionsListModel().getRow(0));
    }
}

