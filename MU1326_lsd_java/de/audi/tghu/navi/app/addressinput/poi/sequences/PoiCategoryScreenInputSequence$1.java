/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiCategoryScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiCategoryScreenInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiCategoryScreenInputSequence this$0;

    PoiCategoryScreenInputSequence$1(PoiCategoryScreenInputSequence poiCategoryScreenInputSequence, String string) {
        this.this$0 = poiCategoryScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        LIValueListElement lIValueListElement = (LIValueListElement)this.commandList.get("CurrentSelection");
        if (lIValueListElement != null) {
            this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiCategoryScreenInputSequence.access$000(this.this$0), lIValueListElement));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

