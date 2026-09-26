/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.di.eu.listeners.AddressInputStreetScreenListenerEU;
import de.audi.app.navi.evo.di.eu.listeners.AddressInputStreetScreenListenerEU$1;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputStreetScreenListenerEU$StreetInputGetNavLocationCallbackCommand
extends NavCommand {
    private final EvoListRow row;
    private final AddressInputStreetScreenListenerEU listener;
    private final /* synthetic */ AddressInputStreetScreenListenerEU this$0;

    private AddressInputStreetScreenListenerEU$StreetInputGetNavLocationCallbackCommand(AddressInputStreetScreenListenerEU addressInputStreetScreenListenerEU, EvoListRow evoListRow, AddressInputStreetScreenListenerEU addressInputStreetScreenListenerEU2) {
        this.this$0 = addressInputStreetScreenListenerEU;
        this.row = evoListRow;
        this.listener = addressInputStreetScreenListenerEU2;
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("LocationToTest");
        AddressInputStreetScreenListenerEU.access$100(this.listener, navLocation, this.row);
        this.getCommandList().commandFinished();
    }

    /* synthetic */ AddressInputStreetScreenListenerEU$StreetInputGetNavLocationCallbackCommand(AddressInputStreetScreenListenerEU addressInputStreetScreenListenerEU, EvoListRow evoListRow, AddressInputStreetScreenListenerEU addressInputStreetScreenListenerEU2, AddressInputStreetScreenListenerEU$1 addressInputStreetScreenListenerEU$1) {
        this(addressInputStreetScreenListenerEU, evoListRow, addressInputStreetScreenListenerEU2);
    }
}

