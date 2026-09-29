/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AddressInputMainScreenWorkFlowManagerNAR;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputMainScreenWorkFlowManagerNAR$5
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerNAR this$0;

    AddressInputMainScreenWorkFlowManagerNAR$5(AddressInputMainScreenWorkFlowManagerNAR addressInputMainScreenWorkFlowManagerNAR, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerNAR;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.spellerStack.reset();
        this.getCommandList().commandFinished();
    }
}

