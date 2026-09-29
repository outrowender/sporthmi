/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.wfm;

import de.audi.app.navi.evo.di.eu.wfm.AddressInputMainScreenWorkFlowManagerEU;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputMainScreenWorkFlowManagerEU$3
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerEU this$0;

    AddressInputMainScreenWorkFlowManagerEU$3(AddressInputMainScreenWorkFlowManagerEU addressInputMainScreenWorkFlowManagerEU, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerEU;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.spellerStack.reset();
        this.getCommandList().commandFinished();
    }
}

