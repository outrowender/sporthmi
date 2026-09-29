/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$11
extends DefaultButtonListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$11(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.DlProgressAbortDownloadButtonListener].keyTyped(): Download abort requested!");
        UotaModelListener.access$200(this.this$0).getDlProgressAbortDownloadButtonModel().fireEvent(n3);
    }
}

