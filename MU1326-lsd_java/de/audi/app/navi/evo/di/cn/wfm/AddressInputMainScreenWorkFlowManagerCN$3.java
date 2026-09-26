/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.wfm;

import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputMainScreenWorkFlowManagerCN$3
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerCN this$0;

    AddressInputMainScreenWorkFlowManagerCN$3(AddressInputMainScreenWorkFlowManagerCN addressInputMainScreenWorkFlowManagerCN, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerCN;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.spellerStack.reset();
        this.getCommandList().commandFinished();
    }
}

