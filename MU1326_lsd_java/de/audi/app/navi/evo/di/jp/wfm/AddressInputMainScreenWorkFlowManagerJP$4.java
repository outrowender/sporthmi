/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.jp.wfm.AddressInputMainScreenWorkFlowManagerJP;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenWorkFlowManagerJP$4
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerJP this$0;

    AddressInputMainScreenWorkFlowManagerJP$4(AddressInputMainScreenWorkFlowManagerJP addressInputMainScreenWorkFlowManagerJP, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerJP;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.commandList.get("startMainScreenNavLocation");
        if (object != null && object instanceof NavLocation) {
            this.this$0.logChannel.log(-2137614336, "%1#createJpMainScreenStartForOnlineWorkFlow with navLocation = %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort((NavLocation)object));
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandListForOnline((NavLocation)object));
        } else {
            this.this$0.logChannel.log(-2137614336, "%1#createJpMainScreenStartForOnlineWorkFlow with null location!", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandListForOnline());
        }
    }
}

