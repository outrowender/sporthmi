/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.interapp.IMessagingDictationService$CompositionState;
import de.audi.atip.interapp.IMessagingDictationServiceListener;
import java.util.Iterator;

class MessagingDictationService$8
implements Runnable {
    private final /* synthetic */ IMessagingDictationService$CompositionState val$compositionState;
    private final /* synthetic */ MessagingDictationService this$0;

    MessagingDictationService$8(MessagingDictationService messagingDictationService, IMessagingDictationService$CompositionState iMessagingDictationService$CompositionState) {
        this.this$0 = messagingDictationService;
        this.val$compositionState = iMessagingDictationService$CompositionState;
    }

    @Override
    public void run() {
        try {
            MessagingDictationService.access$2400(this.this$0).log(1078071040, "[MessagingDictationService#emitUpdateCompositionState] compositionState = %1", (Object)this.val$compositionState);
            MessagingDictationService.access$400(this.this$0).updateCompositionState(this.val$compositionState);
            Iterator iterator = MessagingDictationService.access$600(this.this$0).iterator();
            while (iterator.hasNext()) {
                try {
                    ((IMessagingDictationServiceListener)iterator.next()).updateCompositionState(this.val$compositionState);
                }
                catch (Exception exception) {
                    Logs.logException(MessagingDictationService.access$2500(this.this$0), exception, "[MessagingDictationService#emitUpdateCompositionState]");
                }
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingDictationService.access$2600(this.this$0), exception, "[MessagingDictationService#emitUpdateCompositionState]");
        }
    }
}

