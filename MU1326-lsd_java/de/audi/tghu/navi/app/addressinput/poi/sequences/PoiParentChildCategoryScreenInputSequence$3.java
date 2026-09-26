/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildCategoryScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiParentChildCategoryScreenInputSequence$3
extends NavCommand {
    private final /* synthetic */ PoiParentChildCategoryScreenInputSequence this$0;

    PoiParentChildCategoryScreenInputSequence$3(PoiParentChildCategoryScreenInputSequence poiParentChildCategoryScreenInputSequence, String string) {
        this.this$0 = poiParentChildCategoryScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        CommandList commandList = PoiParentChildCategoryScreenInputSequence.access$100(this.this$0, this.this$0.spellerType);
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

