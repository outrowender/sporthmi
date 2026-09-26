/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$22
extends DefaultButtonListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$22(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.NaviPopupLicenseDownloadButtonListener].keyTyped(): system proposal component selection pop-up requested!");
        UotaModelListener.access$200(this.this$0).getNaviPopupLicenseDownloadButtonModel().fireEvent(n3);
        UotaModelListener.access$100(this.this$0).buildSysProposalRows();
        UotaModelListener.access$100(this.this$0).setDownloadState(9);
        UotaModelListener.access$200(this.this$0).getSysProposalPopupStartDisclaimerButtonModel().setStatus(0);
        UotaModelListener.access$100(this.this$0).setPopupButtonPressed(true);
        UotaModelListener.access$100(this.this$0).showUpdateSystemProposalPopup();
    }
}

