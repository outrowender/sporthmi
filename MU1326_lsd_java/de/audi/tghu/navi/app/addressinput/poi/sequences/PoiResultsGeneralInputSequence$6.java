/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;

class PoiResultsGeneralInputSequence$6
extends NavCommand {
    private final /* synthetic */ IPoiSpellerModelAccess val$modelAccess;
    private final /* synthetic */ IStartGuidanceToDestinationSequence val$startGuidanceSequence;
    private final /* synthetic */ PoiResultsGeneralInputSequence this$0;

    PoiResultsGeneralInputSequence$6(PoiResultsGeneralInputSequence poiResultsGeneralInputSequence, IPoiSpellerModelAccess iPoiSpellerModelAccess, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        this.this$0 = poiResultsGeneralInputSequence;
        this.val$modelAccess = iPoiSpellerModelAccess;
        this.val$startGuidanceSequence = iStartGuidanceToDestinationSequence;
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(0x6800000)) {
            this.logger.log(-2137614336, "[PoiInput] PoiResultsInputSequence#startParentChild() - Starting parent child sequence");
            PoiParentChildInputSequence poiParentChildInputSequence = new PoiParentChildInputSequence(this.val$modelAccess, this.this$0.commandListFactory, this.this$0.searchArea, this.env, this.this$0.vehicle, this.this$0.selectedElement.getListIndex(), this.this$0.detailsScreen);
            this.this$0.currentInputSequence = poiParentChildInputSequence;
            this.getCommandList().commandFinishedWithPostSequence(poiParentChildInputSequence.createStartSequence());
            return;
        }
        this.logger.log(-2137614336, "[PoiInput] PoiResultsInputSequence#startGuidance() - Starting route guidance");
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            this.getCommandList().commandFinishedWithPostSequence(this.val$startGuidanceSequence.getStartSequence(navLocation));
        } else {
            this.getCommandList().commandAborted("Position for element is not valid");
        }
    }
}

