/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.extracteditems.ExtractInformationCommand;
import org.dsi.ifc.messaging.ExtractedItem;

class ExtractInformationCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ ExtractInformationCommand this$0;

    ExtractInformationCommand$1(ExtractInformationCommand extractInformationCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = extractInformationCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ExtractInformationErrorCommand#execute]");
        ExtractInformationCommand.access$000(this.this$0, 1, new ExtractedItem[0]);
    }
}

