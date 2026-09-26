/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiResultScreenWithSpellerInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiResultScreenWithSpellerInputSequence this$0;

    PoiResultScreenWithSpellerInputSequence$1(PoiResultScreenWithSpellerInputSequence poiResultScreenWithSpellerInputSequence, String string) {
        this.this$0 = poiResultScreenWithSpellerInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
    }
}

