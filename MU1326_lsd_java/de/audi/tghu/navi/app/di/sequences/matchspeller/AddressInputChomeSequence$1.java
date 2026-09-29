/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputChomeSequence;
import org.dsi.ifc.global.NavLocation;

class AddressInputChomeSequence$1
extends NavCommand {
    private final /* synthetic */ AddressInputChomeSequence this$0;

    AddressInputChomeSequence$1(AddressInputChomeSequence addressInputChomeSequence, String string) {
        this.this$0 = addressInputChomeSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (AddressInputChomeSequence.access$000(this.this$0, navLocation)) {
            AddressInputChomeSequence.setIsChomeCenterSelected(true);
        } else {
            AddressInputChomeSequence.setIsChomeCenterSelected(false);
        }
        this.getCommandList().commandFinished();
    }
}

