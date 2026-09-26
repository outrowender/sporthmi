/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputJunctionSequence;
import org.dsi.ifc.navigation.LIValueListElement;

class AddressInputJunctionSequence$2
extends NavCommand {
    private final /* synthetic */ LIValueListElement val$element;
    private final /* synthetic */ AddressInputJunctionSequence this$0;

    AddressInputJunctionSequence$2(AddressInputJunctionSequence addressInputJunctionSequence, LIValueListElement lIValueListElement) {
        this.this$0 = addressInputJunctionSequence;
        this.val$element = lIValueListElement;
    }

    @Override
    public void execute() {
        if (this.val$element.isToRefine()) {
            this.getCommandList().commandFinishedWithPostSequence(AddressInputJunctionSequence.access$000(this.this$0, 127, false));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

