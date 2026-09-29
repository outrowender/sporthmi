/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.jp.wfm.AddressInputMainScreenWorkFlowManagerJP;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenWorkFlowManagerJP$6
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerJP this$0;

    AddressInputMainScreenWorkFlowManagerJP$6(AddressInputMainScreenWorkFlowManagerJP addressInputMainScreenWorkFlowManagerJP) {
        this.this$0 = addressInputMainScreenWorkFlowManagerJP;
    }

    @Override
    public void execute() {
        Object object = this.commandList.get("startMainScreenNavLocation");
        if (object != null && object instanceof NavLocation) {
            this.this$0.logChannel.log(-2137614336, "%1#createJpMainScreenStartForRemoteHmiWorkFlow with navLocation = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort((NavLocation)object));
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
        } else {
            this.this$0.logChannel.log(-2137614336, "%1#createJpMainScreenStartForRemoteHmiWorkFlow with null location!", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandList());
        }
    }
}

