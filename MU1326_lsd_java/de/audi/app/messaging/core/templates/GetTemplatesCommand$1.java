/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.templates.GetTemplatesCommand;

class GetTemplatesCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ GetTemplatesCommand this$0;

    GetTemplatesCommand$1(GetTemplatesCommand getTemplatesCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = getTemplatesCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[GetMessageContentsCommand#execute]");
        GetTemplatesCommand.access$000(this.this$0, false, null);
    }
}

