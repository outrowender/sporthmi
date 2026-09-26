/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandResultScreenNoSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiBrandResultScreenNoSpellerInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiBrandResultScreenNoSpellerInputSequence this$0;

    PoiBrandResultScreenNoSpellerInputSequence$2(PoiBrandResultScreenNoSpellerInputSequence poiBrandResultScreenNoSpellerInputSequence, String string) {
        this.this$0 = poiBrandResultScreenNoSpellerInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiBrandResultScreenNoSpellerInputSequence.access$000(this.this$0), (LIValueListElement)this.commandList.get("CurrentSelection")));
    }
}

