/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiResultScreenWithMatchSpellerInputSequenceAsia$2
extends NavCommand {
    private final /* synthetic */ PoiResultScreenWithMatchSpellerInputSequenceAsia this$0;

    PoiResultScreenWithMatchSpellerInputSequenceAsia$2(PoiResultScreenWithMatchSpellerInputSequenceAsia poiResultScreenWithMatchSpellerInputSequenceAsia, String string) {
        this.this$0 = poiResultScreenWithMatchSpellerInputSequenceAsia;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(this.this$0.modelAccess, (LIValueListElement)this.commandList.get("CurrentSelection")));
    }
}

