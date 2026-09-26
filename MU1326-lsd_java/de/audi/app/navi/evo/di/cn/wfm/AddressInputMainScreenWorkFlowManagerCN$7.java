/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.wfm;

import de.audi.app.navi.evo.di.cn.wfm.AddressInputMainScreenWorkFlowManagerCN;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputMainScreenWorkFlowManagerCN$7
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerCN this$0;

    AddressInputMainScreenWorkFlowManagerCN$7(AddressInputMainScreenWorkFlowManagerCN addressInputMainScreenWorkFlowManagerCN, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerCN;
        super(string);
    }

    @Override
    public void execute() {
        IPoiService iPoiService = this.this$0.inputManager.getPoiService();
        iPoiService.startPoiHybridSearch(0, this.env.getContainer().getLiCurrentLD(), false);
        this.getCommandList().commandFinished();
    }
}

