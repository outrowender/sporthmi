/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassCategoriesInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiClassCategoriesInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiClassCategoriesInputSequence this$0;

    PoiClassCategoriesInputSequence$1(PoiClassCategoriesInputSequence poiClassCategoriesInputSequence, String string) {
        this.this$0 = poiClassCategoriesInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

