/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.settings.SetEmailIndicationsCommand;

class SetEmailIndicationsCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ SetEmailIndicationsCommand this$0;

    SetEmailIndicationsCommand$1(SetEmailIndicationsCommand setEmailIndicationsCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = setEmailIndicationsCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetEmailIndicationsErrorCommand#execute]");
        SetEmailIndicationsCommand.access$000(this.this$0, false);
    }
}

