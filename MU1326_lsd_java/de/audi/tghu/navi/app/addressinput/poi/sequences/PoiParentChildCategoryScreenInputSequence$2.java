/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildCategoryScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiParentChildCategoryScreenInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiParentChildCategoryScreenInputSequence this$0;

    PoiParentChildCategoryScreenInputSequence$2(PoiParentChildCategoryScreenInputSequence poiParentChildCategoryScreenInputSequence, String string) {
        this.this$0 = poiParentChildCategoryScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiParentChildCategoryScreenInputSequence.access$000(this.this$0), (LIValueListElement)this.commandList.get("CurrentSelection")));
    }
}

