/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$6$1;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class AddressInputHousenumberFreetextSequence$6
extends NavCommand {
    private final /* synthetic */ AddressInputHousenumberFreetextSequence this$0;

    AddressInputHousenumberFreetextSequence$6(AddressInputHousenumberFreetextSequence addressInputHousenumberFreetextSequence) {
        this.this$0 = addressInputHousenumberFreetextSequence;
    }

    @Override
    public void execute() {
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        LIValueListElement lIValueListElement = lIValueList.getList()[1];
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new AddressInputHousenumberFreetextSequence$6$1(this));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    static /* synthetic */ AddressInputHousenumberFreetextSequence access$100(AddressInputHousenumberFreetextSequence$6 addressInputHousenumberFreetextSequence$6) {
        return addressInputHousenumberFreetextSequence$6.this$0;
    }
}

