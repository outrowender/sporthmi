/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSimpleSequence;
import org.dsi.ifc.navigation.LIValueList;

class AddressInputStreetSimpleSequence$1
extends NavCommand {
    private final /* synthetic */ AddressInputStreetSimpleSequence this$0;

    AddressInputStreetSimpleSequence$1(AddressInputStreetSimpleSequence addressInputStreetSimpleSequence, String string) {
        this.this$0 = addressInputStreetSimpleSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(3)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(3, false, false, true));
        } else {
            this.dsiResponseContainer.setLispUpdateSpellerResult("", 0, false, false, "", 0, 0, false, false, 0);
            this.dsiResponseContainer.setLiValueList(new LIValueList(), 0L);
            this.getCommandList().commandFinished();
        }
    }
}

