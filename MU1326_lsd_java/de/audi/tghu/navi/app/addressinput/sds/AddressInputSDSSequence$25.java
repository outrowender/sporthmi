/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequenceExt;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class AddressInputSDSSequence$25
extends NavCommand {
    private final /* synthetic */ IMatchspellerInputSequenceExt val$sequence;
    private final /* synthetic */ String val$input;
    private final /* synthetic */ AddressInputSDSSequence this$0;

    AddressInputSDSSequence$25(AddressInputSDSSequence addressInputSDSSequence, String string, IMatchspellerInputSequenceExt iMatchspellerInputSequenceExt, String string2) {
        this.this$0 = addressInputSDSSequence;
        this.val$sequence = iMatchspellerInputSequenceExt;
        this.val$input = string2;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLispValueListCount() > 0L && this.dsiResponseContainer.getLispValueList() != null) {
            LIValueListElement lIValueListElement = this.dsiResponseContainer.getLispValueList().getList()[0];
            this.logger.log(-2137614336, "AddressInputSDSSequence#execute#liValueList() - select element ( %1 )", (Object)lIValueListElement.getData());
            this.getCommandList().commandFinishedWithPostSequence(this.val$sequence.getSelectListElementCommandList(lIValueListElement, false));
        } else {
            this.logger.log(10000, "AddressInputSDSSequence#execute#liValueList() - no results found for input ( %1 )!", (Object)this.val$input);
            this.getCommandList().commandAborted("no results found");
        }
    }
}

