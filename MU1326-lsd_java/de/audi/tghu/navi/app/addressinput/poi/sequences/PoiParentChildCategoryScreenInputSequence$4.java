/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildCategoryScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiParentChildCategoryScreenInputSequence$4
extends NavCommand {
    private final /* synthetic */ PoiParentChildCategoryScreenInputSequence this$0;

    PoiParentChildCategoryScreenInputSequence$4(PoiParentChildCategoryScreenInputSequence poiParentChildCategoryScreenInputSequence, String string) {
        this.this$0 = poiParentChildCategoryScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new PoiSetContextCommand(this.dsiResponseContainer.getLiCurrentLD()));
    }
}

