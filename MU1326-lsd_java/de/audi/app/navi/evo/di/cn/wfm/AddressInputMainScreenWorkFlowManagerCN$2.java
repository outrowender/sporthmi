/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.wfm;

import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenWorkFlowManagerCN$2
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerCN this$0;

    AddressInputMainScreenWorkFlowManagerCN$2(AddressInputMainScreenWorkFlowManagerCN addressInputMainScreenWorkFlowManagerCN, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerCN;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.commandList.get("startMainScreenNavLocation");
        if (object != null && object instanceof NavLocation) {
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
        } else {
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandList());
        }
    }
}

