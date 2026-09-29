/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildResultScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiParentChildResultScreenInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiParentChildResultScreenInputSequence this$0;

    PoiParentChildResultScreenInputSequence$1(PoiParentChildResultScreenInputSequence poiParentChildResultScreenInputSequence, String string) {
        this.this$0 = poiParentChildResultScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
    }
}

