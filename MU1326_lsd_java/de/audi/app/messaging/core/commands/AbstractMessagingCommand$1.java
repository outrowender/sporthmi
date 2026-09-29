/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.commands;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand$MessagingCommandCallException;

class AbstractMessagingCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ AbstractMessagingCommand this$0;

    AbstractMessagingCommand$1(AbstractMessagingCommand abstractMessagingCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = abstractMessagingCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[AbstractMessagingCommand#getErrorCommand#execute]");
        this.this$0.setExceptionCause(new AbstractMessagingCommand$MessagingCommandCallException(this, "Command list error."));
    }
}

