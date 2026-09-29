/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.commands.ReplySDSTriggerAddressInputReturnCommand;
import de.audi.tghu.navi.app.addressinput.sds.AbstractAddressInputSDSForm;
import de.audi.tghu.navi.app.command.NavCommand;

class AbstractAddressInputSDSForm$1
extends NavCommand {
    private final /* synthetic */ int val$cursorPosition;
    private final /* synthetic */ NaviServiceListener val$naviServiceListener;
    private final /* synthetic */ AbstractAddressInputSDSForm this$0;

    AbstractAddressInputSDSForm$1(AbstractAddressInputSDSForm abstractAddressInputSDSForm, String string, int n, NaviServiceListener naviServiceListener) {
        this.this$0 = abstractAddressInputSDSForm;
        this.val$cursorPosition = n;
        this.val$naviServiceListener = naviServiceListener;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.nextDestinationInput(this.val$cursorPosition);
        this.getCommandList().commandFinishedWithPostCommand(new ReplySDSTriggerAddressInputReturnCommand(this.val$naviServiceListener, 0));
    }
}

