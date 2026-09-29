/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.compose.NewMessage$1;
import de.audi.atip.interapp.IMessagingDictationService$CompositionState;
import de.audi.atip.interapp.IMessagingDictationServiceListener$EmptyImplementation;

final class NewMessage$MessagingDictationServiceListener
extends IMessagingDictationServiceListener$EmptyImplementation {
    private final /* synthetic */ NewMessage this$0;

    private NewMessage$MessagingDictationServiceListener(NewMessage newMessage) {
        this.this$0 = newMessage;
    }

    @Override
    public void updateCompositionState(IMessagingDictationService$CompositionState iMessagingDictationService$CompositionState) {
        NewMessage.access$900(this.this$0).log(-2137614336, "[NewMessage#updateCompositionState] compositionState.isDialogActive() = %1", iMessagingDictationService$CompositionState.isDialogActive());
        NewMessage.access$1000(this.this$0, iMessagingDictationService$CompositionState.isDialogActive());
    }

    /* synthetic */ NewMessage$MessagingDictationServiceListener(NewMessage newMessage, NewMessage$1 newMessage$1) {
        this(newMessage);
    }
}

