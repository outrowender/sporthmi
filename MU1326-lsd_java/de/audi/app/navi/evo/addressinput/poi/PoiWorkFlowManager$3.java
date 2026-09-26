/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiWorkFlowManager$3
extends NavCommand {
    private final /* synthetic */ PoiSearchArea val$searchArea;
    private final /* synthetic */ PoiWorkFlowManager this$0;

    PoiWorkFlowManager$3(PoiWorkFlowManager poiWorkFlowManager, String string, PoiSearchArea poiSearchArea) {
        this.this$0 = poiWorkFlowManager;
        this.val$searchArea = poiSearchArea;
        super(string);
    }

    @Override
    public void execute() {
        long l = this.dsiResponseContainer.getLispValueListCount();
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        if (l == 1L && lIValueList != null && lIValueList.getList() != null && lIValueList.getList().length == 1) {
            LIValueListElement lIValueListElement = lIValueList.getList()[0];
            this.getCommandList().put("CurrentSelection", lIValueListElement);
            this.logger.log(-2137614336, "%1#navCommand#execute() - continue directly to brand result screen", (Object)this.CLASS_NAME);
            CommandList commandList = PoiWorkFlowManager.access$000(this.this$0).createCommandList();
            PoiWorkFlowManager.access$600(this.this$0, commandList, this.val$searchArea, this.env);
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

