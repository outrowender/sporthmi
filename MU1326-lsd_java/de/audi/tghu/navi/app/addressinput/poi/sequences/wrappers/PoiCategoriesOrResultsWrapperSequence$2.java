/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoriesOrResultsWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiCategoriesOrResultsWrapperSequence$2
extends NavCommand {
    private final /* synthetic */ PoiCategoriesOrResultsWrapperSequence this$0;

    PoiCategoriesOrResultsWrapperSequence$2(PoiCategoriesOrResultsWrapperSequence poiCategoriesOrResultsWrapperSequence) {
        this.this$0 = poiCategoriesOrResultsWrapperSequence;
    }

    @Override
    public void execute() {
        long l = this.dsiResponseContainer.getLispValueListCount();
        LIValueList lIValueList = this.dsiResponseContainer.getLispValueList();
        if (l == 1L && lIValueList != null && lIValueList.getList() != null && lIValueList.getList().length == 1) {
            LIValueListElement lIValueListElement = lIValueList.getList()[0];
            PoiResultsGeneralInputSequence poiResultsGeneralInputSequence = new PoiResultsGeneralInputSequence(PoiCategoriesOrResultsWrapperSequence.access$000(this.this$0).getResultsScreen(), PoiCategoriesOrResultsWrapperSequence.access$100(this.this$0), PoiCategoriesOrResultsWrapperSequence.access$200(this.this$0), this.env, lIValueListElement, PoiCategoriesOrResultsWrapperSequence.access$300(this.this$0), false, PoiCategoriesOrResultsWrapperSequence.access$400(this.this$0), this.this$0.detailsScreen);
            this.this$0.currentInputSequence = poiResultsGeneralInputSequence;
            this.logger.log(-2137614336, "[PoiInput] PoiCategoriesOrResultsInputSequence#navCommand#execute() - continue directly to results screen");
            this.getCommandList().commandFinishedWithPostSequence(poiResultsGeneralInputSequence.createStartSequence());
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

