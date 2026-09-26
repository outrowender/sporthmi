/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoryByUIDWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiCategoryByUIDWrapperSequence$1
extends NavCommand {
    private final /* synthetic */ PoiCategoryByUIDWrapperSequence this$0;

    PoiCategoryByUIDWrapperSequence$1(PoiCategoryByUIDWrapperSequence poiCategoryByUIDWrapperSequence) {
        this.this$0 = poiCategoryByUIDWrapperSequence;
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

