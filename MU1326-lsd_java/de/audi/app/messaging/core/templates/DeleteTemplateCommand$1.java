/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.templates.DeleteTemplateCommand;

class DeleteTemplateCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ DeleteTemplateCommand this$0;

    DeleteTemplateCommand$1(DeleteTemplateCommand deleteTemplateCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = deleteTemplateCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[DeleteTemplateErrorCommand#execute]");
        DeleteTemplateCommand.access$000(this.this$0, false);
    }
}

