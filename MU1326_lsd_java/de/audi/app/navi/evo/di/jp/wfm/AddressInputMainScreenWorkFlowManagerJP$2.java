/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.jp.wfm.AddressInputMainScreenWorkFlowManagerJP;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenWorkFlowManagerJP$2
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerJP this$0;

    AddressInputMainScreenWorkFlowManagerJP$2(AddressInputMainScreenWorkFlowManagerJP addressInputMainScreenWorkFlowManagerJP, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerJP;
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

