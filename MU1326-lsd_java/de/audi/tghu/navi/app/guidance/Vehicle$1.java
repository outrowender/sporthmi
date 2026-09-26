/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class Vehicle$1
extends NavCommand {
    private final /* synthetic */ Vehicle this$0;

    Vehicle$1(Vehicle vehicle, String string) {
        this.this$0 = vehicle;
        super(string);
    }

    @Override
    public void execute() {
        Vehicle.access$002(this.this$0, (NavLocation)this.getCommandList().get("STRIPPED_LOCATION"));
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "GetCountryVehicleLocation#execute() - strippedLocation: %1", (Object)LocationFormatter.formatLocationShort(Vehicle.access$000(this.this$0)));
        }
        this.getCommandList().commandFinished();
    }
}

