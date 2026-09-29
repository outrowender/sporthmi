/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitForSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import org.dsi.ifc.navigation.LIValueList;

class PoiResultScreenWithSpellerInputSequence$4
extends NavCommand {
    private final /* synthetic */ PoiResultScreenWithSpellerInputSequence this$0;

    PoiResultScreenWithSpellerInputSequence$4(PoiResultScreenWithSpellerInputSequence poiResultScreenWithSpellerInputSequence) {
        this.this$0 = poiResultScreenWithSpellerInputSequence;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#createStartSequence#execute()", (Object)this.CLASS_NAME);
        LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
        if (lIValueList == null || lIValueList.getList() == null) {
            this.logger.log(-2137614336, "%1#createStartSequence#execute() - poiValueList or poiValueList.getList is null.", (Object)this.CLASS_NAME);
            this.getCommandList().commandAborted("PoiValueList is empty.");
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "%1#createStartSequence#execute() - poiValueList: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
        }
        int n = CommandUtil.getIndexForCriteria(16, lIValueList);
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "%1#createStartSequence#execute(): index for criteria: %2", (Object)this.CLASS_NAME, (long)n);
        }
        if (n < 0) {
            this.getCommandList().commandAborted("No matching selection criteria found.");
            return;
        }
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        if (this.this$0.poiSearchArea.getSearchContext() == 5) {
            commandList.add(new PoiSelectSelectionCriteriaCommand(n));
        } else {
            commandList.add(new PoiSelectSelectionCriteriaSubstringCommand(n, 1, PoiResultScreenWithSpellerInputSequence.access$100(this.this$0)));
        }
        commandList.add(new ModelUpdateFullListWithWaitForSubstringCommand(PoiResultScreenWithSpellerInputSequence.access$000(this.this$0), this.this$0.commandListFactory, 1, this.this$0.poiManager));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

