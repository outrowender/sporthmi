/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.viewmessage.SetMessageReadStatusCommand;

class SetMessageReadStatusCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ SetMessageReadStatusCommand this$0;

    SetMessageReadStatusCommand$1(SetMessageReadStatusCommand setMessageReadStatusCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = setMessageReadStatusCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetMessageReadStatusErrorCommand#execute]");
        SetMessageReadStatusCommand.access$000(this.this$0, false);
    }
}

