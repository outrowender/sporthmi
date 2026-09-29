/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import org.dsi.ifc.navigation.LIValueList;

class PoiResultsGeneralInputSequence$9
extends NavCommand {
    private final /* synthetic */ PoiResultsGeneralInputSequence this$0;

    PoiResultsGeneralInputSequence$9(PoiResultsGeneralInputSequence poiResultsGeneralInputSequence) {
        this.this$0 = poiResultsGeneralInputSequence;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#createStartSequence#execute()");
        LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
        if (lIValueList == null || lIValueList.getList() == null) {
            this.logger.log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#createStartSequence#execute() - poiValueList or poiValueList.getList is null.");
            this.getCommandList().commandAborted("PoiValueList is empty.");
            return;
        }
        int n = CommandUtil.getIndexForCriteria(16, lIValueList);
        if (n < 0) {
            this.getCommandList().commandAborted("No matching selection criteria found.");
            return;
        }
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        if (this.this$0.searchArea.getSearchContext() == 5) {
            commandList.add(new PoiSelectSelectionCriteriaCommand(n));
        } else {
            commandList.add(new PoiSelectSelectionCriteriaSubstringCommand(n, this.this$0.minimumInitialResults, this.this$0.substringSearchHandler));
        }
        commandList.add(new ModelUpdateFullListWithWaitCommand(this.this$0.modelAccess, this.this$0.commandListFactory, -1, 0, 1));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

