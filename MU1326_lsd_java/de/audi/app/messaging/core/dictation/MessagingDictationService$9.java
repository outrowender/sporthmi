/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.util.Logs;

class MessagingDictationService$9
implements Runnable {
    private final /* synthetic */ MessagingDictationService this$0;

    MessagingDictationService$9(MessagingDictationService messagingDictationService) {
        this.this$0 = messagingDictationService;
    }

    @Override
    public void run() {
        try {
            MessagingDictationService.access$2700(this.this$0).log(1078071040, "[MessagingDictationService#indicateSubjectEditorModelWrite] isDialogInProgress = %1", MessagingDictationService.access$100(this.this$0));
            if (MessagingDictationService.access$100(this.this$0)) {
                MessagingDictationService.access$2800(this.this$0).getNewMessage().subjectChanged(false);
                MessagingDictationService.access$2900(this.this$0, this.this$0.getCompositionState());
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingDictationService.access$3000(this.this$0), exception, "[MessagingDictationService#indicateSubjectEditorModelWrite]");
        }
    }
}

