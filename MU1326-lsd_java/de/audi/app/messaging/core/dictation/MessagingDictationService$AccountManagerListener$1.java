/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.dictation.MessagingDictationService$AccountManagerListener;

class MessagingDictationService$AccountManagerListener$1
implements Runnable {
    private final /* synthetic */ MessagingDictationService$AccountManagerListener this$1;

    MessagingDictationService$AccountManagerListener$1(MessagingDictationService$AccountManagerListener messagingDictationService$AccountManagerListener) {
        this.this$1 = messagingDictationService$AccountManagerListener;
    }

    @Override
    public void run() {
        MessagingDictationService.access$7900(MessagingDictationService$AccountManagerListener.access$7800(this.this$1)).log(-2137614336, "[MessagingDictationService#selectedAccountChanged]");
        if (MessagingDictationService.access$100(MessagingDictationService$AccountManagerListener.access$7800(this.this$1))) {
            if (MessagingDictationService.access$8000(MessagingDictationService$AccountManagerListener.access$7800(this.this$1)).getAccountManager().getSelectedAccount() == null) {
                MessagingDictationService.access$202(MessagingDictationService$AccountManagerListener.access$7800(this.this$1), true);
            } else {
                MessagingDictationService.access$300(MessagingDictationService$AccountManagerListener.access$7800(this.this$1), true);
            }
            MessagingDictationService.access$2900(MessagingDictationService$AccountManagerListener.access$7800(this.this$1), MessagingDictationService$AccountManagerListener.access$7800(this.this$1).getCompositionState());
        }
    }
}

