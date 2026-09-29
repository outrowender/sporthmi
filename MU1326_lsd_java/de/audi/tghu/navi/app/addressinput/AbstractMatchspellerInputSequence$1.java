/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.AbstractMatchspellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class AbstractMatchspellerInputSequence$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ AbstractMatchspellerInputSequence this$0;

    AbstractMatchspellerInputSequence$1(AbstractMatchspellerInputSequence abstractMatchspellerInputSequence, String string, int n) {
        this.this$0 = abstractMatchspellerInputSequence;
        this.val$model = n;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLispValueListCount() == 1L) {
            CommandList commandList = this.this$0.getSelectListElementCommandList(this.dsiResponseContainer.getLispValueList().getList()[0], true);
            this.getCommandList().commandFinishedWithPostSequence(commandList);
            this.env.fireModelEvent(this.val$model, 0);
            return;
        }
        this.getCommandList().commandFinished();
    }
}

