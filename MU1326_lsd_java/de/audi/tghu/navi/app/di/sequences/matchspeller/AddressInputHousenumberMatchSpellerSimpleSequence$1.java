/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHousenumberMatchSpellerSimpleSequence;
import org.dsi.ifc.navigation.LIValueListElement;

class AddressInputHousenumberMatchSpellerSimpleSequence$1
extends NavCommand {
    private final /* synthetic */ LIValueListElement val$element;
    private final /* synthetic */ AddressInputHousenumberMatchSpellerSimpleSequence this$0;

    AddressInputHousenumberMatchSpellerSimpleSequence$1(AddressInputHousenumberMatchSpellerSimpleSequence addressInputHousenumberMatchSpellerSimpleSequence, LIValueListElement lIValueListElement) {
        this.this$0 = addressInputHousenumberMatchSpellerSimpleSequence;
        this.val$element = lIValueListElement;
    }

    @Override
    public void execute() {
        if (this.val$element.isToRefine()) {
            this.this$0.modelAccess.onAmbiguousElementSelected();
            this.getCommandList().commandFinishedWithPostSequence(AddressInputHousenumberMatchSpellerSimpleSequence.access$000(this.this$0, 127, false));
        } else {
            this.this$0.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.this$0.modelAccess));
            commandList.add(new CmdNaviPreviewMapUpdate(this.this$0.previewMap, 1, null, null));
            commandList.add(new SetBackupLocationForAddressInputFormCommand(this.this$0.inputManager));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

