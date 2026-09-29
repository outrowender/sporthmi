/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenWorkFlowManagerKR$6
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerKR this$0;

    AddressInputMainScreenWorkFlowManagerKR$6(AddressInputMainScreenWorkFlowManagerKR addressInputMainScreenWorkFlowManagerKR) {
        this.this$0 = addressInputMainScreenWorkFlowManagerKR;
    }

    @Override
    public void execute() {
        Object object = this.commandList.get("startMainScreenNavLocation");
        this.this$0.logChannel.log(-2137614336, "%1#createKrMainScreenStartForRemoteHmiWorkFlow with navLocation = %2", (Object)this.CLASS_NAME, object);
        if (object != null && object instanceof NavLocation) {
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
        } else {
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandList());
        }
    }
}

