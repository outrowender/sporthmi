/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassCategoriesInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoryByUIDWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiCategoryByUIDWrapperSequence$2
extends NavCommand {
    private final /* synthetic */ PoiCategoryByUIDWrapperSequence this$0;

    PoiCategoryByUIDWrapperSequence$2(PoiCategoryByUIDWrapperSequence poiCategoryByUIDWrapperSequence) {
        this.this$0 = poiCategoryByUIDWrapperSequence;
    }

    @Override
    public void execute() {
        LIValueListElement lIValueListElement = new LIValueListElement();
        lIValueListElement.poiUniqueId = this.this$0.criteriaNumber;
        PoiClassCategoriesInputSequence poiClassCategoriesInputSequence = new PoiClassCategoriesInputSequence(this.this$0.categoriesModelAccess, this.this$0.commandListFactory, this.this$0.searchArea, this.env, lIValueListElement, this.this$0.vehicle, true, this.this$0.detailsScreen);
        this.this$0.currentInputSequence = poiClassCategoriesInputSequence;
        this.logger.log(-2137614336, "[PoiInput] CategoryByUIDWrapperSequence#navCommand#execute() - continue directly to results screen");
        this.getCommandList().commandFinishedWithPostSequence(poiClassCategoriesInputSequence.createStartSequence());
    }
}

