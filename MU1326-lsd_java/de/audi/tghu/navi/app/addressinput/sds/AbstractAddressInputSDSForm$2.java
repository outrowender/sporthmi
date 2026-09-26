/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.sds.AbstractAddressInputSDSForm;
import de.audi.tghu.navi.app.command.LISetHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class AbstractAddressInputSDSForm$2
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputSDSForm this$0;

    AbstractAddressInputSDSForm$2(AbstractAddressInputSDSForm abstractAddressInputSDSForm, String string) {
        this.this$0 = abstractAddressInputSDSForm;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetHistoryCommand(this.dsiResponseContainer.getLiCurrentLD()));
    }
}

