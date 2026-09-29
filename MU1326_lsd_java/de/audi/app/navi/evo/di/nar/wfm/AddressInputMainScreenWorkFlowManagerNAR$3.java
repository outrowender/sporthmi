/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AddressInputMainScreenWorkFlowManagerNAR;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenWorkFlowManagerNAR$3
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerNAR this$0;

    AddressInputMainScreenWorkFlowManagerNAR$3(AddressInputMainScreenWorkFlowManagerNAR addressInputMainScreenWorkFlowManagerNAR, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerNAR;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
        this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getMainScreenListener().getStartCommandList(navLocation));
    }
}

