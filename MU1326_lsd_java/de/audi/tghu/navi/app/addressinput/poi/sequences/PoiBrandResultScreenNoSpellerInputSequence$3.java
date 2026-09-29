/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitForSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandResultScreenNoSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import org.dsi.ifc.navigation.LIValueList;

class PoiBrandResultScreenNoSpellerInputSequence$3
extends NavCommand {
    private final /* synthetic */ PoiBrandResultScreenNoSpellerInputSequence this$0;

    PoiBrandResultScreenNoSpellerInputSequence$3(PoiBrandResultScreenNoSpellerInputSequence poiBrandResultScreenNoSpellerInputSequence) {
        this.this$0 = poiBrandResultScreenNoSpellerInputSequence;
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
        int n = CommandUtil.getIndexForCriteria(16, lIValueList);
        if (n < 0) {
            this.getCommandList().commandAborted("No matching selection criteria found.");
            return;
        }
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        if (this.this$0.poiSearchArea.getSearchContext() == 5) {
            commandList.add(new PoiSelectSelectionCriteriaCommand(n));
        } else {
            commandList.add(new PoiSelectSelectionCriteriaSubstringCommand(n, 1, PoiBrandResultScreenNoSpellerInputSequence.access$100(this.this$0)));
        }
        if (this.this$0.poiSearchArea.getSearchContext() == 5) {
            commandList.add(new NewModelUpdateResultListCommand(PoiBrandResultScreenNoSpellerInputSequence.access$000(this.this$0)));
        } else {
            commandList.add(new ModelUpdateFullListWithWaitForSubstringCommand(PoiBrandResultScreenNoSpellerInputSequence.access$000(this.this$0), this.this$0.commandListFactory, 1, this.this$0.poiManager));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

