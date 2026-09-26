/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.di.nar.listeners.AddressInputStreetRefinementScreenListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputStreetRefinementScreenListenerNAR$1;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputStreetRefinementScreenListenerNAR$StreetInputRefinementGetNavLocationCallbackCommand
extends NavCommand {
    private final EvoListRow row;
    private final AddressInputStreetRefinementScreenListenerNAR listener;
    private final /* synthetic */ AddressInputStreetRefinementScreenListenerNAR this$0;

    private AddressInputStreetRefinementScreenListenerNAR$StreetInputRefinementGetNavLocationCallbackCommand(AddressInputStreetRefinementScreenListenerNAR addressInputStreetRefinementScreenListenerNAR, EvoListRow evoListRow, AddressInputStreetRefinementScreenListenerNAR addressInputStreetRefinementScreenListenerNAR2) {
        this.this$0 = addressInputStreetRefinementScreenListenerNAR;
        this.row = evoListRow;
        this.listener = addressInputStreetRefinementScreenListenerNAR2;
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("LocationToTest");
        AddressInputStreetRefinementScreenListenerNAR.access$100(this.listener, navLocation, this.row);
        this.getCommandList().commandFinished();
    }

    /* synthetic */ AddressInputStreetRefinementScreenListenerNAR$StreetInputRefinementGetNavLocationCallbackCommand(AddressInputStreetRefinementScreenListenerNAR addressInputStreetRefinementScreenListenerNAR, EvoListRow evoListRow, AddressInputStreetRefinementScreenListenerNAR addressInputStreetRefinementScreenListenerNAR2, AddressInputStreetRefinementScreenListenerNAR$1 addressInputStreetRefinementScreenListenerNAR$1) {
        this(addressInputStreetRefinementScreenListenerNAR, evoListRow, addressInputStreetRefinementScreenListenerNAR2);
    }
}

