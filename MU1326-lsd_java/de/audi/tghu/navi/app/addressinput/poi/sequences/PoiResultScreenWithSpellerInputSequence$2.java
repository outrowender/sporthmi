/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiResultScreenWithSpellerInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiResultScreenWithSpellerInputSequence this$0;

    PoiResultScreenWithSpellerInputSequence$2(PoiResultScreenWithSpellerInputSequence poiResultScreenWithSpellerInputSequence, String string) {
        this.this$0 = poiResultScreenWithSpellerInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiResultScreenWithSpellerInputSequence.access$000(this.this$0), (LIValueListElement)this.commandList.get("CurrentSelection")));
    }
}

