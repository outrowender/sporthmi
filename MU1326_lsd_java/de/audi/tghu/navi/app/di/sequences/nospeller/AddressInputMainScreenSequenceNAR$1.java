/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequenceNAR;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenSequenceNAR$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$initialLocation;
    private final /* synthetic */ AddressInputMainScreenSequenceNAR this$0;

    AddressInputMainScreenSequenceNAR$1(AddressInputMainScreenSequenceNAR addressInputMainScreenSequenceNAR, NavLocation navLocation) {
        this.this$0 = addressInputMainScreenSequenceNAR;
        this.val$initialLocation = navLocation;
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(this.val$initialLocation));
    }
}

