/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenNoSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiResultScreenNoSpellerInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiResultScreenNoSpellerInputSequence this$0;

    PoiResultScreenNoSpellerInputSequence$1(PoiResultScreenNoSpellerInputSequence poiResultScreenNoSpellerInputSequence, String string) {
        this.this$0 = poiResultScreenNoSpellerInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
    }
}

