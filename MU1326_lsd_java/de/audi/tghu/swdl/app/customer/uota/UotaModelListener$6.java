/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.swdl.app.customer.uota.AbstractPkgListRow;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$6
extends DefaultBaseListModelListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$6(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.SysProposalListListener].itemSelected(): region selected: %1", (Object)evoListRow);
        UotaModelListener.access$100(this.this$0).packageSelected((AbstractPkgListRow)evoListRow, UotaModelListener.access$200(this.this$0).getSysProposalListModel(), n4);
    }
}

