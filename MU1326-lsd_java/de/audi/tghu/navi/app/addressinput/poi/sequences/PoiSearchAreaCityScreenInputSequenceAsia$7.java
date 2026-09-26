/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiSearchAreaCityScreenInputSequenceAsia$7
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ PoiSearchAreaCityScreenInputSequenceAsia this$0;

    PoiSearchAreaCityScreenInputSequenceAsia$7(PoiSearchAreaCityScreenInputSequenceAsia poiSearchAreaCityScreenInputSequenceAsia, String string, int n) {
        this.this$0 = poiSearchAreaCityScreenInputSequenceAsia;
        this.val$model = n;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLispValueListCount() == 1L) {
            LIValueListElement lIValueListElement = this.dsiResponseContainer.getLispValueList().getList()[0];
            CommandList commandList = this.this$0.getAutoselectListElementCommandList(lIValueListElement);
            this.this$0.poiManager.handlePoiSelectionEvent(commandList, 1303);
            this.getCommandList().commandFinishedWithPostSequence(commandList);
            this.env.fireModelEvent(this.val$model, 0);
            return;
        }
        this.this$0.spellerStack.pop();
        this.getCommandList().commandFinished();
    }
}

