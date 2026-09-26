/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.jp.wfm.AddressInputMainScreenWorkFlowManagerJP;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputMainScreenWorkFlowManagerJP$5
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerJP this$0;

    AddressInputMainScreenWorkFlowManagerJP$5(AddressInputMainScreenWorkFlowManagerJP addressInputMainScreenWorkFlowManagerJP, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerJP;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.spellerStack.reset();
        this.getCommandList().commandFinished();
    }
}

