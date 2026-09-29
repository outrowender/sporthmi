/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.compose.INewMessageObserver$DefaultNewMessageObserver;
import de.audi.app.messaging.evo.compose.MessageLengthPopup;
import de.audi.app.messaging.evo.compose.MessageLengthPopup$1;

final class MessageLengthPopup$NewMessageObserver
extends INewMessageObserver$DefaultNewMessageObserver {
    private final /* synthetic */ MessageLengthPopup this$0;

    private MessageLengthPopup$NewMessageObserver(MessageLengthPopup messageLengthPopup) {
        this.this$0 = messageLengthPopup;
    }

    @Override
    public void indicateMessageLength(int n, int n2) {
        boolean bl = n < 0;
        boolean bl2 = n2 < 0;
        MessageLengthPopup.access$400(this.this$0).log(-2137614336, "[MessageLengthPopup#indicateMessageLength] maxSubjectLengthExceeded = %1, maxBodyLengthExceeded = %2", bl, bl2);
        MessageLengthPopup.access$500(this.this$0, bl, bl2);
    }

    /* synthetic */ MessageLengthPopup$NewMessageObserver(MessageLengthPopup messageLengthPopup, MessageLengthPopup$1 messageLengthPopup$1) {
        this(messageLengthPopup);
    }
}

