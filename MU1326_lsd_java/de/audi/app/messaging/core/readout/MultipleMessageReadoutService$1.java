/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutServiceListener;

class MultipleMessageReadoutService$1
implements IMultipleMessageReadoutServiceListener {
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    MultipleMessageReadoutService$1(MultipleMessageReadoutService multipleMessageReadoutService) {
        this.this$0 = multipleMessageReadoutService;
    }

    @Override
    public void responseNextMessage(int n, String string) {
        MultipleMessageReadoutService.access$500(this.this$0).log(1078071040, "[IMultipleMessageReadoutServiceListener#responseNextMessage] result = %2, message = %1", (Object)string, (long)n);
    }

    @Override
    public void responseEndDialog(int n) {
        MultipleMessageReadoutService.access$600(this.this$0).log(1078071040, "[IMultipleMessageReadoutServiceListener#responseEndDialog] result = %1", (long)n);
    }

    @Override
    public void responseBeginDialog(int n) {
        MultipleMessageReadoutService.access$700(this.this$0).log(1078071040, "[IMultipleMessageReadoutServiceListener#responseBeginDialog] result = %1", (long)n);
    }
}

