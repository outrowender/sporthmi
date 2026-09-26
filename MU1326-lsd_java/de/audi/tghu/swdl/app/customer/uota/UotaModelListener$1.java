/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$1
extends DefaultButtonListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$1(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.StartDownloadButtonListener].keyTyped(): Package selection done!");
        UotaModelListener.access$100(this.this$0).calculateAndSetDownloadSize();
        UotaModelListener.access$200(this.this$0).getUotaDisclaimerTypeChoiceModel().setValue(0);
        UotaModelListener.access$200(this.this$0).getStartDownloadButtonModel().fireEvent(n3);
        UotaModelListener.access$100(this.this$0).showSystemProposalDisclaimerPopup();
    }
}

