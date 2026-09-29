/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiUIDResultsWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiUIDResultsWrapperSequence$3
extends NavCommand {
    private final /* synthetic */ PoiUIDResultsWrapperSequence this$0;

    PoiUIDResultsWrapperSequence$3(PoiUIDResultsWrapperSequence poiUIDResultsWrapperSequence) {
        this.this$0 = poiUIDResultsWrapperSequence;
    }

    @Override
    public void execute() {
        PoiResultsGeneralInputSequence poiResultsGeneralInputSequence = new PoiResultsGeneralInputSequence(this.this$0.resultsModelAccess, this.this$0.commandListFactory, this.this$0.searchArea, this.env, this.this$0.categoryListElement, this.this$0.vehicle, true, this.this$0.minInitialResults, this.this$0.detailsScreen);
        this.this$0.currentInputSequence = poiResultsGeneralInputSequence;
        this.logger.log(-2137614336, "[PoiInput] PoiUIDResultsWrapperSequence#navCommand#execute() - continue directly to results screen");
        this.getCommandList().commandFinishedWithPostSequence(poiResultsGeneralInputSequence.createStartSequence());
    }
}

