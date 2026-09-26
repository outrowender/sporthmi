/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.deletemessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.deletemessage.DeleteMessageCommand;

class DeleteMessageCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ DeleteMessageCommand this$0;

    DeleteMessageCommand$1(DeleteMessageCommand deleteMessageCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = deleteMessageCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[DeleteMessageErrorCommand#execute]");
        DeleteMessageCommand.access$000(this.this$0, 1);
    }
}

