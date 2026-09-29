/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassCategoriesInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import org.dsi.ifc.navigation.LIValueList;

class PoiClassCategoriesInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiClassCategoriesInputSequence this$0;

    PoiClassCategoriesInputSequence$2(PoiClassCategoriesInputSequence poiClassCategoriesInputSequence, String string) {
        this.this$0 = poiClassCategoriesInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
        if (lIValueList == null || lIValueList.getList() == null) {
            this.getCommandList().commandAborted("PoiValueList is empty.");
            return;
        }
        int n = CommandUtil.getIndexForCriteria(2, lIValueList);
        if (n >= 0) {
            this.getCommandList().commandFinishedWithPostCommand(new PoiSelectSelectionCriteriaCommand(n));
        } else {
            this.getCommandList().commandAborted("No matching selection criteria found.");
        }
    }
}

