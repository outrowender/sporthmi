/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitForSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiFuelWarningSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import org.dsi.ifc.navigation.LIValueList;

class PoiFuelWarningSequence$1
extends NavCommand {
    private final /* synthetic */ PoiFuelWarningSequence this$0;

    PoiFuelWarningSequence$1(PoiFuelWarningSequence poiFuelWarningSequence, String string) {
        this.this$0 = poiFuelWarningSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "PoiFuelWarningSequence#getStartCommandListWithElementByUid#execute()");
        LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
        if (lIValueList == null || lIValueList.getList() == null) {
            this.logger.log(-2137614336, "PoiFuelWarningSequence#getStartCommandListWithElementByUid#execute() - poiValueList or poiValueList.getList is null.");
            this.getCommandList().commandAborted("PoiValueList is empty.");
            return;
        }
        int n = CommandUtil.getIndexForCriteria(16, lIValueList);
        if (n < 0) {
            this.getCommandList().commandAborted("No matching selection criteria found.");
            return;
        }
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        commandList.add(new PoiSelectSelectionCriteriaSubstringCommand(n, 1, PoiFuelWarningSequence.access$000(this.this$0)));
        commandList.add(new ModelUpdateFullListWithWaitForSubstringCommand(PoiFuelWarningSequence.access$100(this.this$0), this.this$0.commandListFactory, PoiFuelWarningSequence.access$200(this.this$0), this.this$0.poiManager));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

