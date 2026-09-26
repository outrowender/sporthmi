/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.housenumber;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSimpleSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class HousenumberMatchspellerInputSimpleSequence$1
extends NavCommand {
    private final /* synthetic */ LIValueListElement val$element;
    private final /* synthetic */ HousenumberMatchspellerInputSimpleSequence this$0;

    HousenumberMatchspellerInputSimpleSequence$1(HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence, LIValueListElement lIValueListElement) {
        this.this$0 = housenumberMatchspellerInputSimpleSequence;
        this.val$element = lIValueListElement;
    }

    @Override
    public void execute() {
        if (this.val$element.isToRefine()) {
            HousenumberMatchspellerInputSimpleSequence.access$000(this.this$0).onAmbiguousElementSelected();
            this.getCommandList().commandFinishedWithPostSequence(HousenumberMatchspellerInputSimpleSequence.access$100(this.this$0, 127, false));
        } else {
            HousenumberMatchspellerInputSimpleSequence.access$200(this.this$0).onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
            CommandList commandList = HousenumberMatchspellerInputSimpleSequence.access$300(this.this$0).createCommandList();
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(HousenumberMatchspellerInputSimpleSequence.access$400(this.this$0)));
            commandList.add(new CmdNaviPreviewMapUpdate(HousenumberMatchspellerInputSimpleSequence.access$500(this.this$0), 1, null, null));
            commandList.add(new SetBackupLocationForAddressInputFormCommand(this.this$0.addressInputForm));
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(HousenumberMatchspellerInputSimpleSequence.access$600(this.this$0)));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

