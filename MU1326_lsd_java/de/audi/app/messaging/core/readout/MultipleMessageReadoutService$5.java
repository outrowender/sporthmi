/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.app.messaging.core.util.Logs;
import org.dsi.ifc.messaging.MessageListEntry;

class MultipleMessageReadoutService$5
implements Runnable {
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    MultipleMessageReadoutService$5(MultipleMessageReadoutService multipleMessageReadoutService) {
        this.this$0 = multipleMessageReadoutService;
    }

    @Override
    public void run() {
        int n = 1;
        try {
            if (MultipleMessageReadoutService.access$800(this.this$0) == 0) {
                n = 3;
                MultipleMessageReadoutService.access$100(this.this$0, n);
            } else if (MultipleMessageReadoutService.access$2600(this.this$0) != null && MultipleMessageReadoutService.access$2600(this.this$0).hasNext()) {
                if (!MultipleMessageReadoutService.access$1100(this.this$0)) {
                    MessageListEntry messageListEntry = (MessageListEntry)MultipleMessageReadoutService.access$2600(this.this$0).next();
                    MultipleMessageReadoutService.access$2700(this.this$0).log(1078071040, "[MultipleMessageReadoutService#requestNextMessage] Requesting old message %1.", (Object)messageListEntry.getMessageID());
                    MultipleMessageReadoutService.access$2800(this.this$0).getMessageOptionsManager().setFocusedMessageListEntry(messageListEntry);
                    MultipleMessageReadoutService.access$3000(this.this$0).getSelectedMessage().requestSetMessage(messageListEntry, 0, MultipleMessageReadoutService.access$2900(this.this$0));
                } else {
                    String string = (String)MultipleMessageReadoutService.access$2600(this.this$0).next();
                    MessageListEntry messageListEntry = MultipleMessageReadoutService.access$3100(this.this$0, string);
                    MultipleMessageReadoutService.access$3200(this.this$0).log(1078071040, "[MultipleMessageReadoutService#requestNextMessage] Requesting new message %1.", (Object)string);
                    MultipleMessageReadoutService.access$3300(this.this$0).getMessageOptionsManager().setFocusedMessageListEntry(messageListEntry);
                    MultipleMessageReadoutService.access$3400(this.this$0).getSelectedMessage().requestSetMessage(messageListEntry, 0, MultipleMessageReadoutService.access$2900(this.this$0));
                }
            } else {
                n = 4;
                MultipleMessageReadoutService.access$100(this.this$0, n);
            }
        }
        catch (Exception exception) {
            Logs.logException(MultipleMessageReadoutService.access$3500(this.this$0), exception, "[MultipleMessageReadoutService#requestNextMessage]");
            MultipleMessageReadoutService.access$100(this.this$0, n);
        }
    }
}

