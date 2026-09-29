/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateFullListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildResultScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import org.dsi.ifc.navigation.LIValueList;

class PoiParentChildResultScreenInputSequence$3
extends NavCommand {
    private final /* synthetic */ PoiParentChildResultScreenInputSequence this$0;

    PoiParentChildResultScreenInputSequence$3(PoiParentChildResultScreenInputSequence poiParentChildResultScreenInputSequence) {
        this.this$0 = poiParentChildResultScreenInputSequence;
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
        commandList.add(new PoiSelectSelectionCriteriaCommand(n));
        commandList.add(new NewModelUpdateFullListCommand(PoiParentChildResultScreenInputSequence.access$000(this.this$0), this.this$0.commandListFactory, 1));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

