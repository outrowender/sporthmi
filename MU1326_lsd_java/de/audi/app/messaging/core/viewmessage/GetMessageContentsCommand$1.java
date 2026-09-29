/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.viewmessage.GetMessageContentsCommand;

class GetMessageContentsCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ GetMessageContentsCommand this$0;

    GetMessageContentsCommand$1(GetMessageContentsCommand getMessageContentsCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = getMessageContentsCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[GetMessageContentsErrorCommand#execute]");
        GetMessageContentsCommand.access$000(this.this$0, false, null);
    }
}

