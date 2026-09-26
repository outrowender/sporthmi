/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.settings.SetPushSmsCommand;

class SetPushSmsCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ SetPushSmsCommand this$0;

    SetPushSmsCommand$1(SetPushSmsCommand setPushSmsCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = setPushSmsCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetPushSmsErrorCommand#execute]");
        SetPushSmsCommand.access$000(this.this$0, false);
    }
}

