/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.messaging.core.addressbook.GetEntryForMessageOptionsCommand;

class GetEntryForMessageOptionsCommand$1
extends AbstractADBCommand {
    private final /* synthetic */ GetEntryForMessageOptionsCommand this$0;

    GetEntryForMessageOptionsCommand$1(GetEntryForMessageOptionsCommand getEntryForMessageOptionsCommand, ADBApplication aDBApplication) {
        this.this$0 = getEntryForMessageOptionsCommand;
        super(aDBApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[GetEntryForMessageOptionsCommand#execute]");
        GetEntryForMessageOptionsCommand.access$000(this.this$0, 1, null);
    }
}

