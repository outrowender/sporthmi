/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.settings;

import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigEmptyListener;
import de.audi.app.messaging.evo.settings.SmscNumberController;
import de.audi.app.messaging.evo.settings.SmscNumberController$1;

class SmscNumberController$MyDsiMessagingConfigListener
extends DsiMessagingConfigEmptyListener {
    private final /* synthetic */ SmscNumberController this$0;

    private SmscNumberController$MyDsiMessagingConfigListener(SmscNumberController smscNumberController) {
        this.this$0 = smscNumberController;
    }

    @Override
    public void updateSMSCNumber(String string, int n) {
        SmscNumberController.access$400(this.this$0).log(-2137614336, "[SmscNumberController#updateSMSCNumber]");
        SmscNumberController.access$500(this.this$0, string);
    }

    /* synthetic */ SmscNumberController$MyDsiMessagingConfigListener(SmscNumberController smscNumberController, SmscNumberController$1 smscNumberController$1) {
        this(smscNumberController);
    }
}

