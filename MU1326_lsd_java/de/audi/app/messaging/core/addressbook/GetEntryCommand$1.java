/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.messaging.core.addressbook.GetEntryCommand;

class GetEntryCommand$1
extends AbstractADBCommand {
    private final /* synthetic */ GetEntryCommand this$0;

    GetEntryCommand$1(GetEntryCommand getEntryCommand, ADBApplication aDBApplication) {
        this.this$0 = getEntryCommand;
        super(aDBApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[GetEntryErrorCommand#execute]");
        GetEntryCommand.access$000(this.this$0, 1, null);
    }
}

