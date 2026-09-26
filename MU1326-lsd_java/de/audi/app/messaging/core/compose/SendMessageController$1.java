/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.compose.SendMessageController;
import de.audi.tghu.command.Command;

class SendMessageController$1
implements ICommandCallback {
    private final /* synthetic */ SendMessageController this$0;

    SendMessageController$1(SendMessageController sendMessageController) {
        this.this$0 = sendMessageController;
    }

    @Override
    public void terminating(Command command) {
        SendMessageController.access$000(this.this$0, command);
    }
}

