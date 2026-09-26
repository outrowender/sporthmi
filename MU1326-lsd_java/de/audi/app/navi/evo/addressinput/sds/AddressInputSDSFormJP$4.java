/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormJP;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguationWrapper;

class AddressInputSDSFormJP$4
extends NavCommand {
    private final /* synthetic */ LocationDisambiguationWrapper val$disambiguationObject;
    private final /* synthetic */ AddressInputSDSFormJP this$0;

    AddressInputSDSFormJP$4(AddressInputSDSFormJP addressInputSDSFormJP, String string, LocationDisambiguationWrapper locationDisambiguationWrapper) {
        this.this$0 = addressInputSDSFormJP;
        this.val$disambiguationObject = locationDisambiguationWrapper;
        super(string);
    }

    @Override
    public void execute() {
        AddressInputSDSFormJP.access$100(this.this$0).startPopupHandlingForSds(this.val$disambiguationObject);
        this.getCommandList().commandFinished();
    }
}

