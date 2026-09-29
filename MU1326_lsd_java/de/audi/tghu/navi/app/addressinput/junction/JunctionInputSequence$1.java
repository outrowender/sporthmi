/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.junction;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.junction.JunctionInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class JunctionInputSequence$1
extends NavCommand {
    private final /* synthetic */ LIValueListElement val$element;
    private final /* synthetic */ JunctionInputSequence this$0;

    JunctionInputSequence$1(JunctionInputSequence junctionInputSequence, LIValueListElement lIValueListElement) {
        this.this$0 = junctionInputSequence;
        this.val$element = lIValueListElement;
    }

    @Override
    public void execute() {
        if (this.val$element.isToRefine()) {
            JunctionInputSequence.access$000(this.this$0).onAmbiguousElementSelected();
            this.getCommandList().commandFinishedWithPostSequence(JunctionInputSequence.access$100(this.this$0, 127, false));
        } else {
            JunctionInputSequence.access$200(this.this$0).onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
            CommandList commandList = JunctionInputSequence.access$300(this.this$0).createCommandList();
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(JunctionInputSequence.access$400(this.this$0)));
            commandList.add(new CmdNaviPreviewMapUpdate(JunctionInputSequence.access$500(this.this$0), 1, null, null));
            commandList.add(new SetBackupLocationForAddressInputFormCommand(JunctionInputSequence.access$600(this.this$0)));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

