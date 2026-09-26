/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.interapp.IMessagingDictationServiceListener;
import java.util.Iterator;

class MessagingDictationService$4
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ MessagingDictationService this$0;

    MessagingDictationService$4(MessagingDictationService messagingDictationService, int n) {
        this.this$0 = messagingDictationService;
        this.val$result = n;
    }

    @Override
    public void run() {
        try {
            MessagingDictationService.access$1200(this.this$0).log(1078071040, "[MessagingDictationService#emitResponseAddRecipient] result = %1", (long)this.val$result);
            MessagingDictationService.access$400(this.this$0).responseAddRecipient(this.val$result);
            Iterator iterator = MessagingDictationService.access$600(this.this$0).iterator();
            while (iterator.hasNext()) {
                try {
                    ((IMessagingDictationServiceListener)iterator.next()).responseAddRecipient(this.val$result);
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.access$1300(this.this$0), exception, "[MessagingDictationService#emitResponseAddRecipient]");
                }
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingDictationService.access$1400(this.this$0), exception, "[MessagingDictationService#emitResponseAddRecipient]");
        }
    }
}

