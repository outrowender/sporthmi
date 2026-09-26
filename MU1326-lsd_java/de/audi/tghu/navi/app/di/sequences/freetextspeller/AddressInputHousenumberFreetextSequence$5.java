/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$5$1;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class AddressInputHousenumberFreetextSequence$5
extends NavCommand {
    private final /* synthetic */ AddressInputHousenumberFreetextSequence this$0;

    AddressInputHousenumberFreetextSequence$5(AddressInputHousenumberFreetextSequence addressInputHousenumberFreetextSequence, String string) {
        this.this$0 = addressInputHousenumberFreetextSequence;
        super(string);
    }

    @Override
    public void execute() {
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        LIValueListElement lIValueListElement = lIValueList.getList()[0];
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new AddressInputHousenumberFreetextSequence$5$1(this, new StringBuffer().append(this.CLASS_NAME).append("#selectAlternativeHousenumber - call modelAccess onHousenumberValid").toString()));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    static /* synthetic */ AddressInputHousenumberFreetextSequence access$000(AddressInputHousenumberFreetextSequence$5 addressInputHousenumberFreetextSequence$5) {
        return addressInputHousenumberFreetextSequence$5.this$0;
    }
}

