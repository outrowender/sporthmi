/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.translate;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.translate.TranslateLocationCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class TranslateVehicleCountryLocationCommand
extends TranslateLocationCommand {
    public TranslateVehicleCountryLocationCommand() {
        super((NavLocation)null);
    }

    public void execute() {
        NavLocation navLocation = this.navigation.getVehicle().getVehicleCountryLocation();
        if (navLocation == null) {
            this.logger.log(1000000, "TranslateVehicleCountryLocationCommand#execute() - vehicle country location not set, translation not needed");
            this.getCommandList().commandFinished();
        } else {
            this.setRouteToTranslate(TranslateVehicleCountryLocationCommand.constructRouteToTranslate(navLocation));
            super.execute();
        }
    }

    public CommandList handleTranslatedLocation(NavLocation navLocation) {
        this.logger.log(10000000, "TranslateVehicleCountryLocationCommand#handleTranslatedLocation( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.navigation.getVehicle().setVehicleCountryLocation(navLocation);
        return null;
    }
}

