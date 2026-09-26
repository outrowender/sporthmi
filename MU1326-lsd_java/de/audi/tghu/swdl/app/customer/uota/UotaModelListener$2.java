/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$2
extends DefaultButtonListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$2(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.AbortDownloadButtonListener].keyTyped(): Download aborted!");
        UotaModelListener.access$100(this.this$0).cleanupPackageHierarchy();
        UotaModelListener.access$100(this.this$0).setDownloadState(0);
        UotaModelListener.access$200(this.this$0).getAbortDownloadButtonModel().fireEvent(n3);
    }
}

