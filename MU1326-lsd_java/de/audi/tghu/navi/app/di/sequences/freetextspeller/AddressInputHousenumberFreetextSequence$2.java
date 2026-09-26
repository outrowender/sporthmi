/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence;

class AddressInputHousenumberFreetextSequence$2
extends NavCommand {
    private final /* synthetic */ String val$latestChar;
    private final /* synthetic */ AddressInputHousenumberFreetextSequence this$0;

    AddressInputHousenumberFreetextSequence$2(AddressInputHousenumberFreetextSequence addressInputHousenumberFreetextSequence, String string, String string2) {
        this.this$0 = addressInputHousenumberFreetextSequence;
        this.val$latestChar = string2;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.updatePreviewHousenumber(this.val$latestChar);
        this.getCommandList().commandFinished();
    }
}

