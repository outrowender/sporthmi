/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.util.Logs;

class MessagingDictationService$11
implements Runnable {
    private final /* synthetic */ int val$compositionMode;
    private final /* synthetic */ int val$msgType;
    private final /* synthetic */ boolean val$accountAutoSelect;
    private final /* synthetic */ MessagingDictationService this$0;

    MessagingDictationService$11(MessagingDictationService messagingDictationService, int n, int n2, boolean bl) {
        this.this$0 = messagingDictationService;
        this.val$compositionMode = n;
        this.val$msgType = n2;
        this.val$accountAutoSelect = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        MessagingDictationService.access$202(this.this$0, false);
        try {
            MessagingDictationService.access$3400(this.this$0).log(1078071040, "[MessagingDictationService#requestBeginDialog] compositionMode = %1, msgType = %2, accountAutoSelect = %3", (long)this.val$compositionMode, (long)this.val$msgType, this.val$accountAutoSelect);
            if (MessagingDictationService.access$100(this.this$0)) {
                MessagingDictationService.access$3500(this.this$0).log(10000, "[MessagingDictationService#requestBeginDialog] Illegal state: A dialog is already in progress.");
                n = 3;
            } else {
                MessagingDictationService.access$300(this.this$0, false);
                if (this.val$compositionMode == 0) {
                    MessagingDictationService.access$3600(this.this$0, this.val$msgType, this.val$accountAutoSelect);
                } else if (this.val$compositionMode == 1) {
                    MessagingDictationService.access$3700(this.this$0);
                } else if (this.val$compositionMode == 2) {
                    MessagingDictationService.access$3800(this.this$0);
                } else if (this.val$compositionMode == 3) {
                    MessagingDictationService.access$3900(this.this$0, false);
                } else if (this.val$compositionMode == 4) {
                    MessagingDictationService.access$3900(this.this$0, true);
                } else if (this.val$compositionMode == 5) {
                    MessagingDictationService.access$4000(this.this$0);
                } else {
                    MessagingDictationService.access$4100(this.this$0).log(10000, "[MessagingDictationService#requestBeginDialog] Illegal argument: compositionMode = %1", (long)this.val$compositionMode);
                    n = 2;
                }
                if (n == 0) {
                    MessagingDictationService.access$102(this.this$0, true);
                }
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingDictationService.access$4200(this.this$0), exception, "[MessagingDictationService#requestBeginDialog]");
            n = 1;
        }
        finally {
            MessagingDictationService.access$2900(this.this$0, this.this$0.getCompositionState());
            MessagingDictationService.access$4300(this.this$0, n);
        }
    }
}

