/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.util.Logs;

class MessagingDictationService$15
implements Runnable {
    private final /* synthetic */ int val$recipientType;
    private final /* synthetic */ MessagingDictationService this$0;

    MessagingDictationService$15(MessagingDictationService messagingDictationService, int n) {
        this.this$0 = messagingDictationService;
        this.val$recipientType = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        block8: {
            int n = 0;
            try {
                MessagingDictationService.access$6600(this.this$0).log(1078071040, "[MessagingDictationService#requestClearRecipients] recipientType = %1", (long)this.val$recipientType);
                if (!MessagingDictationService.access$100(this.this$0)) {
                    MessagingDictationService.access$6700(this.this$0).log(10000, "[MessagingDictationService#requestClearRecipients] Illegal state: There is no dialog in progress.");
                    n = 3;
                    break block8;
                }
                int n2 = 0;
                try {
                    n2 = MessagingDictationService.access$6800(this.val$recipientType);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    MessagingDictationService.access$6900(this.this$0).log(10000, "[MessagingDictationService#requestClearRecipients] Illegal argument: recipientType = %1", (long)this.val$recipientType);
                    n = 2;
                }
                MessagingDictationService.access$7000(this.this$0).getNewMessage().getSelectedRecipientList().clear(n2);
            }
            catch (Exception exception) {
                Logs.logException(MessagingDictationService.access$7100(this.this$0), exception, "[MessagingDictationService#requestClearRecipients]");
                n = 1;
            }
            finally {
                MessagingDictationService.access$2900(this.this$0, this.this$0.getCompositionState());
                MessagingDictationService.access$7200(this.this$0, n);
            }
        }
    }
}

