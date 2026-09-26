/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.settings.ActivateStoreSmsOnSentCommand;

class ActivateStoreSmsOnSentCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ ActivateStoreSmsOnSentCommand this$0;

    ActivateStoreSmsOnSentCommand$1(ActivateStoreSmsOnSentCommand activateStoreSmsOnSentCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = activateStoreSmsOnSentCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ActivateStoreSmsOnSentErrorCommand#execute]");
        ActivateStoreSmsOnSentCommand.access$000(this.this$0, false);
    }
}

