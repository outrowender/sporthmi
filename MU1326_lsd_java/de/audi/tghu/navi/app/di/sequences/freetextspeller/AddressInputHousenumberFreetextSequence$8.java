/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$8$1;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class AddressInputHousenumberFreetextSequence$8
extends NavCommand {
    private final /* synthetic */ AddressInputHousenumberFreetextSequence this$0;

    AddressInputHousenumberFreetextSequence$8(AddressInputHousenumberFreetextSequence addressInputHousenumberFreetextSequence) {
        this.this$0 = addressInputHousenumberFreetextSequence;
    }

    @Override
    public void execute() {
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        long l = this.dsiResponseContainer.getLispValueListCount();
        if (this.dsiResponseContainer.isLispIsFullMatch() && l == 1L) {
            this.this$0.modelAccess.onHousenumberValid();
            LIValueListElement lIValueListElement = lIValueList.getList()[0];
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
            commandList.add(new AddressInputHousenumberFreetextSequence$8$1(this));
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.this$0.modelAccess));
            commandList.add(new CmdNaviPreviewMapUpdate(this.this$0.previewMap, 1, null, null));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else if (!this.dsiResponseContainer.isLispIsFullMatch() && l == 0) {
            String string = this.this$0.getHouseNumber(lIValueList.getList(), true).getData();
            this.this$0.modelAccess.onHousenumberInvalid(string);
            this.getCommandList().commandFinished();
        } else if (this.env.getFramework().isPGen2()) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("Unexpected result for house number list!");
        }
    }

    static /* synthetic */ AddressInputHousenumberFreetextSequence access$200(AddressInputHousenumberFreetextSequence$8 addressInputHousenumberFreetextSequence$8) {
        return addressInputHousenumberFreetextSequence$8.this$0;
    }
}

