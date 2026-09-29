/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.drafts;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.drafts.SaveAsDraftCommand;

class SaveAsDraftCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ SaveAsDraftCommand this$0;

    SaveAsDraftCommand$1(SaveAsDraftCommand saveAsDraftCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = saveAsDraftCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SaveAsDraftErrorCommand#execute]");
        SaveAsDraftCommand.access$100(this.this$0, 1, "", SaveAsDraftCommand.access$000(this.this$0));
    }
}

