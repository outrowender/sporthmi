/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandResultScreenNoSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

class PoiBrandResultScreenNoSpellerInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiBrandResultScreenNoSpellerInputSequence this$0;

    PoiBrandResultScreenNoSpellerInputSequence$1(PoiBrandResultScreenNoSpellerInputSequence poiBrandResultScreenNoSpellerInputSequence, String string) {
        this.this$0 = poiBrandResultScreenNoSpellerInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
    }
}

