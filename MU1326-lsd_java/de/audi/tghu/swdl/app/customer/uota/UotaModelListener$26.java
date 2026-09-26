/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$26
extends DefaultButtonListener {
    private final /* synthetic */ ButtonModelApp val$buttonModel;
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$26(UotaModelListener uotaModelListener, ButtonModelApp buttonModelApp) {
        this.this$0 = uotaModelListener;
        this.val$buttonModel = buttonModelApp;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.NoOnlineDataConfirmButtonListener].keyTyped(): cancel download, hide pop-up!");
        UotaModelListener.access$100(this.this$0).abortDownload();
        this.val$buttonModel.fireEvent(n3);
    }
}

