/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiBrandScreenInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiBrandScreenInputSequence this$0;

    PoiBrandScreenInputSequence$2(PoiBrandScreenInputSequence poiBrandScreenInputSequence, String string) {
        this.this$0 = poiBrandScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new ModelOnElementSelectedCommand(PoiBrandScreenInputSequence.access$000(this.this$0), (LIValueListElement)this.commandList.get("CurrentSelection")));
    }
}

