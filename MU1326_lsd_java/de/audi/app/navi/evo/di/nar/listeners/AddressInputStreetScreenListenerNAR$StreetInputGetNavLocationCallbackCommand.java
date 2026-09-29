/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.di.nar.listeners.AddressInputStreetScreenListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputStreetScreenListenerNAR$1;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputStreetScreenListenerNAR$StreetInputGetNavLocationCallbackCommand
extends NavCommand {
    private final EvoListRow row;
    private final AddressInputStreetScreenListenerNAR listener;
    private final /* synthetic */ AddressInputStreetScreenListenerNAR this$0;

    private AddressInputStreetScreenListenerNAR$StreetInputGetNavLocationCallbackCommand(AddressInputStreetScreenListenerNAR addressInputStreetScreenListenerNAR, EvoListRow evoListRow, AddressInputStreetScreenListenerNAR addressInputStreetScreenListenerNAR2) {
        this.this$0 = addressInputStreetScreenListenerNAR;
        this.row = evoListRow;
        this.listener = addressInputStreetScreenListenerNAR2;
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("LocationToTest");
        AddressInputStreetScreenListenerNAR.access$100(this.listener, navLocation, this.row);
        this.getCommandList().commandFinished();
    }

    /* synthetic */ AddressInputStreetScreenListenerNAR$StreetInputGetNavLocationCallbackCommand(AddressInputStreetScreenListenerNAR addressInputStreetScreenListenerNAR, EvoListRow evoListRow, AddressInputStreetScreenListenerNAR addressInputStreetScreenListenerNAR2, AddressInputStreetScreenListenerNAR$1 addressInputStreetScreenListenerNAR$1) {
        this(addressInputStreetScreenListenerNAR, evoListRow, addressInputStreetScreenListenerNAR2);
    }
}

