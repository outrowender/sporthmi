/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$21
extends DefaultButtonListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$21(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.getMoreCountriesButtonListener].keyTyped(): additional countries screen requested!");
        UotaModelListener.access$100(this.this$0).setFocusToSysProposalItem();
        UotaModelListener.access$200(this.this$0).getMoreCountriesButtonModel().fireEvent(n3);
    }
}

