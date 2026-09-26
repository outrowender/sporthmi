/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryByUIDSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.TopPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiUIDResultsWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiUIDResultsWrapperSequence$2
extends NavCommand {
    private final /* synthetic */ PoiCategoryByUIDSequence val$poiCategoryByUIDSequence;
    private final /* synthetic */ TopPoiInputSequence val$topPoiInputSequence;
    private final /* synthetic */ PoiUIDResultsWrapperSequence this$0;

    PoiUIDResultsWrapperSequence$2(PoiUIDResultsWrapperSequence poiUIDResultsWrapperSequence, PoiCategoryByUIDSequence poiCategoryByUIDSequence, TopPoiInputSequence topPoiInputSequence) {
        this.this$0 = poiUIDResultsWrapperSequence;
        this.val$poiCategoryByUIDSequence = poiCategoryByUIDSequence;
        this.val$topPoiInputSequence = topPoiInputSequence;
    }

    @Override
    public void execute() {
        if (this.isGenericPoi()) {
            this.this$0.currentInputSequence = this.val$poiCategoryByUIDSequence;
            this.getCommandList().commandFinishedWithPostSequence(this.val$poiCategoryByUIDSequence.createStartSequence());
        } else if (this.isTopPoi()) {
            this.this$0.currentInputSequence = this.val$topPoiInputSequence;
            this.getCommandList().commandFinishedWithPostSequence(this.val$topPoiInputSequence.createStartSequence());
        } else {
            this.getCommandList().commandAborted(0);
        }
    }

    private boolean isTopPoi() {
        int[] nArray = this.dsiResponseContainer.getPoiGetCategoryTypesFromUId();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != 1) continue;
            return true;
        }
        return false;
    }

    private boolean isGenericPoi() {
        int[] nArray = this.dsiResponseContainer.getPoiGetCategoryTypesFromUId();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != 2) continue;
            return true;
        }
        return false;
    }
}

