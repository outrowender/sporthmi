/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager;
import de.audi.tghu.navi.app.guidance.Vehicle;
import org.dsi.ifc.global.NavLocation;

class AbstractAddressInputManager$6
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputManager this$0;

    AbstractAddressInputManager$6(AbstractAddressInputManager abstractAddressInputManager, String string) {
        this.this$0 = abstractAddressInputManager;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = Vehicle.getInstance().getVehicleLocationDescription();
        this.navigation.getNavObserverRegistry().countryUpdated(navLocation.getCountry(), navLocation.getCountryAbbreviation());
        this.getCommandList().commandFinished();
    }
}

