/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;

class AbstractAddressInputMatchSpellerSequence$1
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputMatchSpellerSequence this$0;

    AbstractAddressInputMatchSpellerSequence$1(AbstractAddressInputMatchSpellerSequence abstractAddressInputMatchSpellerSequence, String string) {
        this.this$0 = abstractAddressInputMatchSpellerSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLispValueListCount() > 0L) {
            this.getCommandList().commandFinishedWithPostCommand(new ModelUpdateSpellerAndResultListCommand(this.this$0.modelAccess));
            return;
        }
        this.this$0.undoCharacter();
        this.getCommandList().commandFinished();
    }
}

