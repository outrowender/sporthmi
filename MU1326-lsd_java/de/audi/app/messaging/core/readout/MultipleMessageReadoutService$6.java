/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.app.messaging.core.util.Logs;

class MultipleMessageReadoutService$6
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    MultipleMessageReadoutService$6(MultipleMessageReadoutService multipleMessageReadoutService, int n) {
        this.this$0 = multipleMessageReadoutService;
        this.val$result = n;
    }

    @Override
    public void run() {
        try {
            MultipleMessageReadoutService.access$4500(this.this$0).log(1078071040, "[MultipleMessageReadoutService#emitResponseBeginDialog] result = %1", (long)this.val$result);
            MultipleMessageReadoutService.access$900(this.this$0).responseBeginDialog(this.val$result);
        }
        catch (Exception exception) {
            Logs.logException(MultipleMessageReadoutService.access$4600(this.this$0), exception, "[MultipleMessageReadoutService#emitResponseBeginDialog]");
        }
    }
}

