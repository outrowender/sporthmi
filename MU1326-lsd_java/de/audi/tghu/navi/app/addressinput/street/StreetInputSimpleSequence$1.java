/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.street;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.street.StreetInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.street.StreetRefinementByCityInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class StreetInputSimpleSequence$1
extends NavCommand {
    private final /* synthetic */ StreetInputSimpleSequence this$0;

    StreetInputSimpleSequence$1(StreetInputSimpleSequence streetInputSimpleSequence) {
        this.this$0 = streetInputSimpleSequence;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            StreetInputSimpleSequence.access$000(this.this$0).onElementSelected(navLocation);
            CommandList commandList = StreetInputSimpleSequence.access$100(this.this$0).createCommandList();
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(StreetInputSimpleSequence.access$200(this.this$0)));
            commandList.add(new CmdNaviPreviewMapUpdate(StreetInputSimpleSequence.access$300(this.this$0), 1, null, null));
            commandList.add(new SetBackupLocationForAddressInputFormCommand(this.this$0.addressInputForm));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            StreetInputSimpleSequence.access$400(this.this$0).onAmbiguousElementSelected();
            this.logger.log(-2137614336, "StreetInputSimpleSequence#getSelectListElementCommandList - refine: %1", StreetInputSimpleSequence.access$500(this.this$0));
            if (StreetInputSimpleSequence.access$500(this.this$0)) {
                StreetInputSimpleSequence.access$602(this.this$0, new StreetRefinementByCityInputSequence(StreetInputSimpleSequence.access$700(this.this$0), StreetInputSimpleSequence.access$800(this.this$0), StreetInputSimpleSequence.access$900(this.this$0), StreetInputSimpleSequence.access$1000(this.this$0), this.this$0.addressInputForm));
                this.getCommandList().commandFinishedWithPostSequence(((StreetRefinementByCityInputSequence)StreetInputSimpleSequence.access$1100(this.this$0)).createStartCommandList(false));
            } else {
                this.getCommandList().commandFinished();
            }
        }
    }
}

