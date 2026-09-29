/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiResultScreenWithMatchSpellerInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiResultScreenWithMatchSpellerInputSequence this$0;

    PoiResultScreenWithMatchSpellerInputSequence$1(PoiResultScreenWithMatchSpellerInputSequence poiResultScreenWithMatchSpellerInputSequence, String string) {
        this.this$0 = poiResultScreenWithMatchSpellerInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
    }
}

