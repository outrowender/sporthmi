/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenNoSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiResultScreenNoSpellerInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiResultScreenNoSpellerInputSequence this$0;

    PoiResultScreenNoSpellerInputSequence$2(PoiResultScreenNoSpellerInputSequence poiResultScreenNoSpellerInputSequence, String string) {
        this.this$0 = poiResultScreenNoSpellerInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(this.this$0.modelAccess, (LIValueListElement)this.commandList.get("CurrentSelection")));
    }
}

