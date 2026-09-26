/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import org.dsi.ifc.navigation.LIValueList;

class PoiBrandScreenInputSequence$3
extends NavCommand {
    private final /* synthetic */ PoiBrandScreenInputSequence this$0;

    PoiBrandScreenInputSequence$3(PoiBrandScreenInputSequence poiBrandScreenInputSequence) {
        this.this$0 = poiBrandScreenInputSequence;
    }

    @Override
    public void execute() {
        int n;
        this.logger.log(-2137614336, "%1#getStartCommandList#execute()", (Object)this.CLASS_NAME);
        LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
        if (lIValueList == null || lIValueList.getList() == null) {
            this.logger.log(-2137614336, "%1#getStartCommandList#execute() - poiValueList or poiValueList.getList is null.", (Object)this.CLASS_NAME);
            this.getCommandList().commandAborted("PoiValueList is empty.");
        }
        if ((n = CommandUtil.getIndexForCriteria(13, lIValueList)) < 0) {
            n = CommandUtil.getIndexForCriteria(11, lIValueList);
        }
        if (n < 0) {
            this.getCommandList().commandAborted("No matching selection criteria found.");
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new PoiSelectSelectionCriteriaCommand(n));
        }
    }
}

