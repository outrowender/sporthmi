/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$9
extends DefaultButtonListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$9(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        UotaModelListener.access$000(this.this$0).log(1078071040, "[UotaModelListener.ConfirmDlStartButtonListener].keyTyped(): Start download confirmed!");
        UotaModelListener.access$100(this.this$0).startDownload();
        UotaModelListener.access$200(this.this$0).getConfirmDlStartButtonModel().fireEvent(n3);
    }
}

