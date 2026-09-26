/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager;
import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager$14$1;
import de.audi.app.navi.evo.addressinput.poi.sds.SDSPoiScreensEvo;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenNoSpellerInputSequence;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiWorkFlowManager$14
extends NavCommand {
    private final /* synthetic */ PoiSearchArea val$searchArea;
    private final /* synthetic */ PoiWorkFlowManager this$0;

    PoiWorkFlowManager$14(PoiWorkFlowManager poiWorkFlowManager, String string, PoiSearchArea poiSearchArea) {
        this.this$0 = poiWorkFlowManager;
        this.val$searchArea = poiSearchArea;
        super(string);
    }

    @Override
    public void execute() {
        if (this.isGenericPoi()) {
            this.logger.log(-2137614336, "%1#startSpellerCommand#execute poiID is POICATEGORYTYPE_GENERIC", (Object)this.CLASS_NAME);
            CommandList commandList = PoiWorkFlowManager.access$000(this.this$0).createCommandList();
            commandList.add(new LISPCancelSpellerCommand());
            commandList.add(new PoiSetSortOrderCommand(0));
            commandList.add(new PoiWorkFlowManager$14$1(this, new StringBuffer().append(this.CLASS_NAME).append("#startSpeller").toString()));
            commandList.add(this.getSelectPoiByUidCommandList());
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else if (this.isTopPoi()) {
            this.logger.log(-2137614336, "%1#startSpellerCommand#execute poiID is POICATEGORYTYPE_TOPPOI", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinishedWithPostSequence(this.getSelectPoiByUidCommandList());
        } else if (this.isUndefinedPoi()) {
            this.logger.log(-2137614336, "%1#startSpellerCommand#execute poiID is POICATEGORYTYPE_UNDEFINED", (Object)this.CLASS_NAME);
            this.env.getBaseListModel(3901).removeAll();
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(0);
        }
    }

    private CommandList getSelectPoiByUidCommandList() {
        PoiResultScreenNoSpellerInputSequence poiResultScreenNoSpellerInputSequence = new PoiResultScreenNoSpellerInputSequence(SDSPoiScreensEvo.getResultsScreenModelAccess(this.env, PoiWorkFlowManager.access$1200(this.this$0), PoiWorkFlowManager.access$1300(this.this$0), PoiWorkFlowManager.access$1400(this.this$0)), PoiWorkFlowManager.access$000(this.this$0), this.val$searchArea, this.env, PoiWorkFlowManager.access$800(this.this$0), 50, PoiWorkFlowManager.access$200(this.this$0));
        return poiResultScreenNoSpellerInputSequence.getStartCommandList((Integer)this.commandList.get("selected poi UID"));
    }

    private boolean isTopPoi() {
        return this.checkForCategoryType(1);
    }

    private boolean isGenericPoi() {
        return this.checkForCategoryType(2);
    }

    private boolean isUndefinedPoi() {
        return this.checkForCategoryType(0);
    }

    private boolean checkForCategoryType(int n) {
        int[] nArray = this.dsiResponseContainer.getPoiGetCategoryTypesFromUId();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            return true;
        }
        return false;
    }

    static /* synthetic */ PoiSearchArea access$1000(PoiWorkFlowManager$14 poiWorkFlowManager$14) {
        return poiWorkFlowManager$14.val$searchArea;
    }

    static /* synthetic */ PoiWorkFlowManager access$1100(PoiWorkFlowManager$14 poiWorkFlowManager$14) {
        return poiWorkFlowManager$14.this$0;
    }
}

