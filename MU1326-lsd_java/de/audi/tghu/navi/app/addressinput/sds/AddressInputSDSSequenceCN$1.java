/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequenceCN;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputSDSSequenceCN$1
extends NavCommand {
    private final /* synthetic */ AddressInputSDSSequenceCN this$0;

    AddressInputSDSSequenceCN$1(AddressInputSDSSequenceCN addressInputSDSSequenceCN, String string) {
        this.this$0 = addressInputSDSSequenceCN;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLispValueListCount() >= 1L && this.dsiResponseContainer.getLispValueList() != null) {
            AddressInputSDSSequenceCN.access$000(this.this$0, this.dsiResponseContainer.getLispValueList());
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "%1#execute#liValueList() - no results found for input ( %2 )!", (Object)this.CLASS_NAME, (Object)this.name);
            this.getCommandList().commandAborted("no results found");
        }
    }
}

