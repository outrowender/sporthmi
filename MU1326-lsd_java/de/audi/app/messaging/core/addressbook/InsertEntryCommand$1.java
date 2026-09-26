/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.messaging.core.addressbook.InsertEntryCommand;

class InsertEntryCommand$1
extends AbstractADBCommand {
    private final /* synthetic */ InsertEntryCommand this$0;

    InsertEntryCommand$1(InsertEntryCommand insertEntryCommand, ADBApplication aDBApplication) {
        this.this$0 = insertEntryCommand;
        super(aDBApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[InsertEntryErrorCommand#execute]");
        InsertEntryCommand.access$100(this.this$0, 1);
    }
}

