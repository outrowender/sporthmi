/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.evo.compose.MessageLengthPopup;
import de.audi.app.messaging.evo.compose.MessageLengthPopup$1;
import de.audi.atip.interapp.IMessagingDictationService$CompositionState;
import de.audi.atip.interapp.IMessagingDictationServiceListener$EmptyImplementation;

final class MessageLengthPopup$MessagingDictationServiceListener
extends IMessagingDictationServiceListener$EmptyImplementation {
    private final /* synthetic */ MessageLengthPopup this$0;

    private MessageLengthPopup$MessagingDictationServiceListener(MessageLengthPopup messageLengthPopup) {
        this.this$0 = messageLengthPopup;
    }

    @Override
    public void updateCompositionState(IMessagingDictationService$CompositionState iMessagingDictationService$CompositionState) {
        MessageLengthPopup.access$800(this.this$0).log(-2137614336, "[MessageLengthPopup#updateCompositionState] compositionState.isDialogActive() = %1", iMessagingDictationService$CompositionState.isDialogActive());
        MessageLengthPopup.access$900(this.this$0, iMessagingDictationService$CompositionState.isDialogActive());
    }

    /* synthetic */ MessageLengthPopup$MessagingDictationServiceListener(MessageLengthPopup messageLengthPopup, MessageLengthPopup$1 messageLengthPopup$1) {
        this(messageLengthPopup);
    }
}

