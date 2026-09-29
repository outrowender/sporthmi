/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$6;

class AddressInputHousenumberFreetextSequence$6$1
extends NavCommand {
    private final /* synthetic */ AddressInputHousenumberFreetextSequence$6 this$1;

    AddressInputHousenumberFreetextSequence$6$1(AddressInputHousenumberFreetextSequence$6 addressInputHousenumberFreetextSequence$6) {
        this.this$1 = addressInputHousenumberFreetextSequence$6;
    }

    @Override
    public void execute() {
        AddressInputHousenumberFreetextSequence$6.access$100((AddressInputHousenumberFreetextSequence$6)this.this$1).modelAccess.onHousenumberValid();
        AddressInputHousenumberFreetextSequence$6.access$100((AddressInputHousenumberFreetextSequence$6)this.this$1).modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        CommandList commandList = AddressInputHousenumberFreetextSequence$6.access$100((AddressInputHousenumberFreetextSequence$6)this.this$1).commandListFactory.createCommandList();
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(AddressInputHousenumberFreetextSequence$6.access$100((AddressInputHousenumberFreetextSequence$6)this.this$1).modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(AddressInputHousenumberFreetextSequence$6.access$100((AddressInputHousenumberFreetextSequence$6)this.this$1).previewMap, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(AddressInputHousenumberFreetextSequence$6.access$100((AddressInputHousenumberFreetextSequence$6)this.this$1).inputManager));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

