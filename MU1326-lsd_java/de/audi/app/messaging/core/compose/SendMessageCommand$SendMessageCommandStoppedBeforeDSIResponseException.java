/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.SendMessageCommand;

class SendMessageCommand$SendMessageCommandStoppedBeforeDSIResponseException
extends RuntimeException {
    private static final long serialVersionUID;
    private final /* synthetic */ SendMessageCommand this$0;

    public SendMessageCommand$SendMessageCommandStoppedBeforeDSIResponseException(SendMessageCommand sendMessageCommand, String string) {
        this.this$0 = sendMessageCommand;
        super(string);
    }
}

