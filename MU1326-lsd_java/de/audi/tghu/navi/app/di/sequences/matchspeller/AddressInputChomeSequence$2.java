/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputChomeSequence;
import org.dsi.ifc.global.NavLocation;

class AddressInputChomeSequence$2
extends NavCommand {
    private final /* synthetic */ AddressInputChomeSequence this$0;

    AddressInputChomeSequence$2(AddressInputChomeSequence addressInputChomeSequence, String string) {
        this.this$0 = addressInputChomeSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid() && !AddressInputChomeSequence.access$100(this.this$0, this.dsiResponseContainer)) {
            this.this$0.modelAccess.onElementSelected(navLocation);
        } else {
            this.this$0.modelAccess.onAmbiguousElementSelected();
        }
        this.getCommandList().commandFinished();
    }
}

