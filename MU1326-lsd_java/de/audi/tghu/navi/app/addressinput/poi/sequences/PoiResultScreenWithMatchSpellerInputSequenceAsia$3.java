/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import org.dsi.ifc.navigation.LIValueList;

class PoiResultScreenWithMatchSpellerInputSequenceAsia$3
extends NavCommand {
    private final /* synthetic */ PoiResultScreenWithMatchSpellerInputSequenceAsia this$0;

    PoiResultScreenWithMatchSpellerInputSequenceAsia$3(PoiResultScreenWithMatchSpellerInputSequenceAsia poiResultScreenWithMatchSpellerInputSequenceAsia, String string) {
        this.this$0 = poiResultScreenWithMatchSpellerInputSequenceAsia;
        super(string);
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
        commandList.add(new PoiSelectSelectionCriteriaCommand(n));
        commandList.add(new NewModelUpdateSpellerCommand(this.this$0.modelAccess));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

