/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.templates.ChangeTemplateCommand;

class ChangeTemplateCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ ChangeTemplateCommand this$0;

    ChangeTemplateCommand$1(ChangeTemplateCommand changeTemplateCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = changeTemplateCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ChangeTemplateErrorCommand#execute]");
        ChangeTemplateCommand.access$000(this.this$0, false);
    }
}

