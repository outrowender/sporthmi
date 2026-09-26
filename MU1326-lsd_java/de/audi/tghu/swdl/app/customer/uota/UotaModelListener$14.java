/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$14
extends DefaultButtonListener {
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$14(UotaModelListener uotaModelListener) {
        this.this$0 = uotaModelListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.DlProgressErrorRetryButtonListener].keyTyped(): Retry triggered after download error!");
        if (UotaModelListener.access$100(this.this$0).isUotaError()) {
            UotaModelListener.access$100(this.this$0).restartDownload();
        } else {
            UotaModelListener.access$000(this.this$0).log(-1601830656, "[UotaModelListener.DlProgressErrorRetryButtonListener].keyTyped(): DownloadOTA is not active, cannot retry download!");
        }
        UotaModelListener.access$200(this.this$0).getDlProgressErrorRetryButtonModel().fireEvent(n3);
    }
}

