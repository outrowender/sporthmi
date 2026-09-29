/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoriesOrResultsWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiCategoriesOrResultsWrapperSequence$1
extends NavCommand {
    private final /* synthetic */ PoiCategoriesOrResultsWrapperSequence this$0;

    PoiCategoriesOrResultsWrapperSequence$1(PoiCategoriesOrResultsWrapperSequence poiCategoriesOrResultsWrapperSequence) {
        this.this$0 = poiCategoriesOrResultsWrapperSequence;
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

