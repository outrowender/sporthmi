/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.wfm;

import de.audi.app.navi.evo.di.kr.wfm.AddressInputMainScreenWorkFlowManagerKR;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenWorkFlowManagerKR$8
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerKR this$0;

    AddressInputMainScreenWorkFlowManagerKR$8(AddressInputMainScreenWorkFlowManagerKR addressInputMainScreenWorkFlowManagerKR, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerKR;
        super(string);
    }

    @Override
    public void execute() {
        IPoiService iPoiService = this.this$0.inputManager.getPoiService();
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        if (Util.isEmpty(LocationFormatter.formatState(navLocation))) {
            this.this$0.logChannel.log(-2137614336, "%1#execute() - SEARCH_CONTEXT_COUNTRY will be used because no state in currentLD is available", (Object)this.CLASS_NAME);
            iPoiService.startPoiHybridSearch(5, navLocation, false);
        } else {
            this.this$0.logChannel.log(-2137614336, "%1#execute() - SEARCH_CONTEXT_CITY will be used", (Object)this.CLASS_NAME);
            iPoiService.startPoiHybridSearch(0, navLocation, false);
        }
        this.getCommandList().commandFinished();
    }
}

