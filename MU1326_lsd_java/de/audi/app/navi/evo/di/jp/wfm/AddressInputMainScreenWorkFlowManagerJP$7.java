/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.wfm;

import de.audi.app.navi.evo.di.jp.wfm.AddressInputMainScreenWorkFlowManagerJP;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenWorkFlowManagerJP$7
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenWorkFlowManagerJP this$0;

    AddressInputMainScreenWorkFlowManagerJP$7(AddressInputMainScreenWorkFlowManagerJP addressInputMainScreenWorkFlowManagerJP, String string) {
        this.this$0 = addressInputMainScreenWorkFlowManagerJP;
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

