/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.util.Logs;

class MessagingDictationService$16
implements Runnable {
    private final /* synthetic */ MessagingDictationService this$0;

    MessagingDictationService$16(MessagingDictationService messagingDictationService) {
        this.this$0 = messagingDictationService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        try {
            MessagingDictationService.access$7300(this.this$0).log(1078071040, "[MessagingDictationService#requestSendMessage]");
            if (!MessagingDictationService.access$100(this.this$0)) {
                MessagingDictationService.access$7400(this.this$0).log(10000, "[MessagingDictationService#requestSendMessage] Illegal state: There is no dialog in progress.");
                n = 3;
            } else {
                MessagingDictationService.access$7500(this.this$0).getNewMessage().getSendMessageController().sendButton(-1483595520, 0);
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingDictationService.access$7600(this.this$0), exception, "[MessagingDictationService#requestSendMessage]");
            n = 1;
        }
        finally {
            MessagingDictationService.access$7700(this.this$0, n);
        }
    }
}

