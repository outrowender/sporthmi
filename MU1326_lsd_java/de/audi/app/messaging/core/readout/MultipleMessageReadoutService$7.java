/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.app.messaging.core.util.Logs;
import de.esolutions.fw.util.commons.Buffer;

class MultipleMessageReadoutService$7
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    MultipleMessageReadoutService$7(MultipleMessageReadoutService multipleMessageReadoutService, int n) {
        this.this$0 = multipleMessageReadoutService;
        this.val$result = n;
    }

    @Override
    public void run() {
        try {
            Buffer buffer = new Buffer();
            MultipleMessageReadoutService.access$4700(this.this$0).log(1078071040, "[MultipleMessageReadoutService#emitResponseNextMessage] result = %1", (long)this.val$result);
            if (this.val$result == 0) {
                IReadable iReadable = MultipleMessageReadoutService.access$4800(this.this$0).getMessageReader().getReadableProvider().getReadable();
                if (iReadable != null) {
                    while (iReadable.hasNextSpeakTask()) {
                        buffer.append(iReadable.nextSpeakTask());
                    }
                } else {
                    MultipleMessageReadoutService.access$4900(this.this$0).log(-1601830656, "[MultipleMessageReadoutService#emitResponseNextMessage] readable is NULL");
                }
            }
            MultipleMessageReadoutService.access$900(this.this$0).responseNextMessage(this.val$result, buffer.toString());
        }
        catch (Exception exception) {
            Logs.logException(MultipleMessageReadoutService.access$5000(this.this$0), exception, "[MultipleMessageReadoutService#emitResponseNextMessage]");
        }
    }
}

