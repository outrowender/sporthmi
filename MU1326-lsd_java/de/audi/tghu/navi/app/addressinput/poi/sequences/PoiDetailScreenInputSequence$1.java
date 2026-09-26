/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiDetailScreenInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiDetailScreenInputSequence this$0;

    PoiDetailScreenInputSequence$1(PoiDetailScreenInputSequence poiDetailScreenInputSequence, String string) {
        this.this$0 = poiDetailScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
    }
}

