/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.Vehicle;
import org.dsi.ifc.global.NavLocation;

public class SetVehicleCountryLocationCommandListCommand
extends NavCommand {
    private final String mapKey;

    public SetVehicleCountryLocationCommandListCommand(String string) {
        this.mapKey = string;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute() - use mapKey = %2", (Object)this.CLASS_NAME, (Object)this.mapKey);
        Object object = this.getCommandList().get(this.mapKey);
        if (object instanceof NavLocation) {
            Vehicle.getInstance().setVehicleCountryLocation((NavLocation)object);
        }
        this.getCommandList().commandFinished();
    }
}

