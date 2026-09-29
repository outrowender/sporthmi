/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.di.kr.listener.AddressInputTownStreetScreenListenerKR;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputTownStreetScreenListenerKR$1
extends NavCommand {
    private final /* synthetic */ AddressInputTownStreetScreenListenerKR this$0;

    AddressInputTownStreetScreenListenerKR$1(AddressInputTownStreetScreenListenerKR addressInputTownStreetScreenListenerKR, String string) {
        this.this$0 = addressInputTownStreetScreenListenerKR;
        super(string);
    }

    @Override
    public void execute() {
        this.env.getChoiceModel(1042351616).setValue(0);
        AddressInputTownStreetScreenListenerKR.access$000(this.this$0).getPoiService().startPoiWithSearchContext(4, this.dsiResponseContainer.getLiCurrentLD(), true);
        this.getCommandList().commandFinished();
    }
}

