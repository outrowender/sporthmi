/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;

class UotaModelListener$29
extends DefaultButtonListener {
    private final /* synthetic */ ButtonModelApp val$switchToButtonModel;
    private final /* synthetic */ UotaModelListener this$0;

    UotaModelListener$29(UotaModelListener uotaModelListener, ButtonModelApp buttonModelApp) {
        this.this$0 = uotaModelListener;
        this.val$switchToButtonModel = buttonModelApp;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        UotaModelListener.access$000(this.this$0).log(-2137614336, "[UotaModelListener.DestinationSwitchToUotaButtonListener].keyTyped():");
        UotaModelListener.access$100(this.this$0).setPopupButtonPressed(true);
        UotaModelListener.access$100(this.this$0).showUpdateDestinationConfirmationPopup();
        this.val$switchToButtonModel.fireEvent(n3);
    }
}

