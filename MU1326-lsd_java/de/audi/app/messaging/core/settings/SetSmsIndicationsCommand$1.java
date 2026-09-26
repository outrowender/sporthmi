/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.settings.SetSmsIndicationsCommand;

class SetSmsIndicationsCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ SetSmsIndicationsCommand this$0;

    SetSmsIndicationsCommand$1(SetSmsIndicationsCommand setSmsIndicationsCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = setSmsIndicationsCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetSmsIndicationsErrorCommand#execute]");
        SetSmsIndicationsCommand.access$000(this.this$0, false);
    }
}

