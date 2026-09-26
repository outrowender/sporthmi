/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.folderbrowsing.ChangeFolderCommand;

class ChangeFolderCommand$1
extends AbstractMessagingCommand {
    private final /* synthetic */ ChangeFolderCommand this$0;

    ChangeFolderCommand$1(ChangeFolderCommand changeFolderCommand, AbstractMsgApplication abstractMsgApplication) {
        this.this$0 = changeFolderCommand;
        super(abstractMsgApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ChangeFolderErrorCommand#execute]");
        ChangeFolderCommand.access$000(this.this$0, false, null);
    }
}

