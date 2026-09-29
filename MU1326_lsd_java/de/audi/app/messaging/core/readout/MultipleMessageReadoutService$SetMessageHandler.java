/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$1;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$ISetMessageResultHandler;
import org.dsi.ifc.messaging.MessageDetails;

class MultipleMessageReadoutService$SetMessageHandler
implements SelectedMessage$ISetMessageResultHandler {
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    private MultipleMessageReadoutService$SetMessageHandler(MultipleMessageReadoutService multipleMessageReadoutService) {
        this.this$0 = multipleMessageReadoutService;
    }

    @Override
    public void responseSetMessage(boolean bl, MessageDetails messageDetails) {
        if (bl) {
            MultipleMessageReadoutService.access$000(this.this$0).log(-2137614336, "[MultipleMessageReadoutService#responseSetMessage] Message set.");
            MultipleMessageReadoutService.access$100(this.this$0, 0);
        } else {
            MultipleMessageReadoutService.access$200(this.this$0).log(-1601830656, "[MultipleMessageReadoutService#responseSetMessage] Message could not be loaded.");
            MultipleMessageReadoutService.access$100(this.this$0, 1);
        }
    }

    /* synthetic */ MultipleMessageReadoutService$SetMessageHandler(MultipleMessageReadoutService multipleMessageReadoutService, MultipleMessageReadoutService$1 multipleMessageReadoutService$1) {
        this(multipleMessageReadoutService);
    }
}

