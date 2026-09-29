/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.util.Logs;

class MessagingDictationService$13
implements Runnable {
    private final /* synthetic */ int val$dialogStep;
    private final /* synthetic */ MessagingDictationService this$0;

    MessagingDictationService$13(MessagingDictationService messagingDictationService, int n) {
        this.this$0 = messagingDictationService;
        this.val$dialogStep = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        try {
            MessagingDictationService.access$5200(this.this$0).log(1078071040, "[MessagingDictationService#requestDialogStep] dialogStep = %1", (long)this.val$dialogStep);
            if (!MessagingDictationService.access$100(this.this$0)) {
                MessagingDictationService.access$5300(this.this$0).log(10000, "[MessagingDictationService#requestDialogStep] Illegal state: There is no dialog in progress.");
                n = 3;
            } else if (this.val$dialogStep != 2 && this.val$dialogStep != 0 && this.val$dialogStep != 3 && this.val$dialogStep != 1) {
                MessagingDictationService.access$5400(this.this$0).log(10000, "[MessagingDictationService#requestDialogStep] Illegal argument: dialogStep = %1", (long)this.val$dialogStep);
                n = 2;
            } else {
                int n2;
                switch (this.val$dialogStep) {
                    case 2: {
                        n2 = 2;
                        break;
                    }
                    case 0: {
                        n2 = 0;
                        break;
                    }
                    case 3: {
                        n2 = 3;
                        break;
                    }
                    case 1: {
                        n2 = 1;
                        break;
                    }
                    default: {
                        n2 = 0;
                    }
                }
                MessagingDictationService.access$5500(this.this$0).getNewMessage().setCursorPosition(n2);
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingDictationService.access$5600(this.this$0), exception, "[MessagingDictationService#requestDialogStep]");
            n = 1;
        }
        finally {
            MessagingDictationService.access$5700(this.this$0, n);
        }
    }
}

