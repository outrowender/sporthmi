/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandsInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import org.dsi.ifc.navigation.LIValueList;

class PoiBrandsInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiBrandsInputSequence this$0;

    PoiBrandsInputSequence$2(PoiBrandsInputSequence poiBrandsInputSequence) {
        this.this$0 = poiBrandsInputSequence;
    }

    @Override
    public void execute() {
        int n;
        this.logger.log(-2137614336, "[PoiInput] PoiBrandsInputSequence#createStartSequence#execute()");
        LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
        if (lIValueList == null || lIValueList.getList() == null) {
            this.logger.log(-2137614336, "[PoiInput] PoiBrandsInputSequence#createStartSequence#execute() - poiValueList or poiValueList.getList is null.");
            this.getCommandList().commandAborted("PoiValueList is empty.");
        }
        if ((n = CommandUtil.getIndexForCriteria(11, lIValueList)) < 0) {
            n = CommandUtil.getIndexForCriteria(13, lIValueList);
        }
        if (n < 0) {
            this.getCommandList().commandAborted("No matching selection criteria found.");
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new PoiSelectSelectionCriteriaCommand(n));
        }
    }
}

