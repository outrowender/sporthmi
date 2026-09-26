/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.tpegpoi.commands.TpegPoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import org.dsi.ifc.navigation.LIValueList;

class TpegPOIResultListSequence$2
extends NavCommand {
    private final /* synthetic */ TpegPOIResultListSequence this$0;

    TpegPOIResultListSequence$2(TpegPOIResultListSequence tpegPOIResultListSequence) {
        this.this$0 = tpegPOIResultListSequence;
    }

    @Override
    public void execute() {
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
        if (lIValueList == null || lIValueList.getList() == null) {
            this.logger.log(-2137614336, "%1#getResultListCommandList#execute() - poiValueList or poiValueList.getList is null.", (Object)this.CLASS_NAME);
            this.getCommandList().commandAborted("PoiValueList is empty.");
        }
        this.logger.log(-2137614336, "%1#getResultListCommandList#execute() - poiValueList: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
        int n = CommandUtil.getIndexForCriteria(16, lIValueList);
        this.logger.log(-2137614336, "%1#getResultListCommandList#execute(): index for criteria: %2", (Object)this.CLASS_NAME, (long)n);
        if (n < 0) {
            this.getCommandList().commandAborted("No matching selection criteria found.");
        }
        commandList.add(new TpegPoiSelectSelectionCriteriaCommand(n));
        commandList.add(new NewModelUpdateResultListCommand(TpegPOIResultListSequence.access$000(this.this$0)));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

