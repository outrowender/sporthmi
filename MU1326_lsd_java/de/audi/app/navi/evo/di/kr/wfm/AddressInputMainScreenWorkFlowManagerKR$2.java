/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenWorkFlowManagerKR$2
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerKR this$0;

    AddressInputMainScreenWorkFlowManagerKR$2(AddressInputMainScreenWorkFlowManagerKR addressInputMainScreenWorkFlowManagerKR, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerKR;
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

