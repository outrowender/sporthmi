/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.app.messaging.core.util.Logs;

class MultipleMessageReadoutService$8
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    MultipleMessageReadoutService$8(MultipleMessageReadoutService multipleMessageReadoutService, int n) {
        this.this$0 = multipleMessageReadoutService;
        this.val$result = n;
    }

    @Override
    public void run() {
        try {
            MultipleMessageReadoutService.access$5100(this.this$0).log(1078071040, "[MultipleMessageReadoutService#emitResponseEndDialog] result = %1", (long)this.val$result);
            MultipleMessageReadoutService.access$900(this.this$0).responseEndDialog(this.val$result);
        }
        catch (Exception exception) {
            Logs.logException(MultipleMessageReadoutService.access$5200(this.this$0), exception, "[MultipleMessageReadoutService#emitResponseEndDialog]");
        }
    }
}

