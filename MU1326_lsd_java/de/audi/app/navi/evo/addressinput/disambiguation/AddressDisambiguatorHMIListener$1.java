/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.disambiguation;

import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorHMIListener;
import de.audi.atip.interapp.NaviADBService$LocationInputHandler;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressDisambiguatorHMIListener$1
extends NavCommand {
    private final /* synthetic */ AddressDisambiguatorHMIListener this$0;

    AddressDisambiguatorHMIListener$1(AddressDisambiguatorHMIListener addressDisambiguatorHMIListener, String string) {
        this.this$0 = addressDisambiguatorHMIListener;
        super(string);
    }

    @Override
    public void execute() {
        NaviADBService$LocationInputHandler naviADBService$LocationInputHandler = AddressDisambiguatorHMIListener.access$800(this.this$0).getCurrentLocationInputHandler();
        if (naviADBService$LocationInputHandler != null) {
            naviADBService$LocationInputHandler.updateLocation((byte[])this.getCommandList().get("LOCATION_STREAM"));
            AddressDisambiguatorHMIListener.access$800(this.this$0).removeHandler();
        } else {
            AddressDisambiguatorHMIListener.access$200((AddressDisambiguatorHMIListener)this.this$0).logger.log(-1601830656, "%1#saveDestinationInContact() - LocationInputhandler is null", (Object)"AddressDisambiguatorHMIListener");
        }
        this.getCommandList().commandFinished();
    }
}

