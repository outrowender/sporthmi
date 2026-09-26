/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$18
extends DefaultButtonListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$18(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (UotaModelListener.access$200(this.this$0).getUotaDisclaimerTypeChoiceModel().getValue() == 0) {
            UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.UotaDisclaimerBackButton].keyTyped(): returnt to the package screen!");
            UotaModelListener.access$100(this.this$0).setPopupButtonPressed(true);
            UotaModelListener.access$200(this.this$0).getUotaDisclaimerBackButton().fireEvent(n3);
        } else {
            UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.UotaDisclaimerBackButton].keyTyped(): it's not a manual Uota, fire cancel event");
            UotaModelListener.access$200(this.this$0).getSysProposalDisclaimerPopupCancelButtonModel().fireEvent(n3);
        }
    }
}

