/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.folderbrowsing.ListEntriesCommand;
import org.dsi.ifc.messaging.ListEntry;

class ListEntriesCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ ListEntriesCommand this$0;

    ListEntriesCommand$1(ListEntriesCommand listEntriesCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = listEntriesCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ListEntriesErrorCommand#execute]");
        ListEntriesCommand.access$100(this.this$0, ListEntriesCommand.access$000(this.this$0).getRequestId(), 1, new ListEntry[0], -1, -1, -1);
    }
}

