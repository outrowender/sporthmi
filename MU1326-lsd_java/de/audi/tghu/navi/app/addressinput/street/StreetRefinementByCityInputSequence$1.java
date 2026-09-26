/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.street;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.street.StreetRefinementByCityInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class StreetRefinementByCityInputSequence$1
extends NavCommand {
    private final /* synthetic */ StreetRefinementByCityInputSequence this$0;

    StreetRefinementByCityInputSequence$1(StreetRefinementByCityInputSequence streetRefinementByCityInputSequence) {
        this.this$0 = streetRefinementByCityInputSequence;
    }

    @Override
    public void execute() {
        StreetRefinementByCityInputSequence.access$000(this.this$0).onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        CommandList commandList = StreetRefinementByCityInputSequence.access$100(this.this$0).createCommandList();
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(StreetRefinementByCityInputSequence.access$200(this.this$0)));
        commandList.add(new CmdNaviPreviewMapUpdate(StreetRefinementByCityInputSequence.access$300(this.this$0), 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(StreetRefinementByCityInputSequence.access$400(this.this$0)));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

