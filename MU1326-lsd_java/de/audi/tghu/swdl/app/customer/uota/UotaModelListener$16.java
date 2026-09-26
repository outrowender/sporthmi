/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$16
extends DefaultButtonListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$16(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.SysProposalDisclaimerPopupStartDownloadButtonModel].keyTyped(): start download system proposals!");
        UotaModelListener.access$100(this.this$0).setPopupButtonPressed(true);
        UotaModelListener.access$100(this.this$0).startDownload();
        UotaModelListener.access$200(this.this$0).getSysProposalDisclaimerPopupStartDownloadButtonModel().fireEvent(n3);
    }
}

