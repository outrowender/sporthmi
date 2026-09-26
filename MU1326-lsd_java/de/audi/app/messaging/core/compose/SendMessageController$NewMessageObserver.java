/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.INewMessageObserver$DefaultNewMessageObserver;
import de.audi.app.messaging.core.compose.SendMessageController;
import de.audi.app.messaging.core.compose.SendMessageController$1;

final class SendMessageController$NewMessageObserver
extends INewMessageObserver$DefaultNewMessageObserver {
    private final /* synthetic */ SendMessageController this$0;

    private SendMessageController$NewMessageObserver(SendMessageController sendMessageController) {
        this.this$0 = sendMessageController;
    }

    @Override
    public void messageCleared() {
        SendMessageController.access$802(this.this$0, false);
    }

    /* synthetic */ SendMessageController$NewMessageObserver(SendMessageController sendMessageController, SendMessageController$1 sendMessageController$1) {
        this(sendMessageController);
    }
}

