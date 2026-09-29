/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenSequence$4
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenSequence this$0;

    AddressInputMainScreenSequence$4(AddressInputMainScreenSequence addressInputMainScreenSequence, String string) {
        this.this$0 = addressInputMainScreenSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        this.this$0.routeGuidanceSequence.start(navLocation);
        this.getCommandList().commandFinished();
    }
}

