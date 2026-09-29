/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenWorkFlowManagerKR$7
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerKR this$0;

    AddressInputMainScreenWorkFlowManagerKR$7(AddressInputMainScreenWorkFlowManagerKR addressInputMainScreenWorkFlowManagerKR, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerKR;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.commandList.get("startMainScreenNavLocation");
        if (object != null && object instanceof NavLocation) {
            this.this$0.logChannel.log(-2137614336, "%1#createKrMainScreenStartForRemoteHmiWorkFlow with navLocation = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort((NavLocation)object));
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandList((NavLocation)object));
        } else {
            this.this$0.logChannel.log(-2137614336, "%1#createKrMainScreenStartForRemoteHmiWorkFlow with null location!", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandList());
        }
    }
}

