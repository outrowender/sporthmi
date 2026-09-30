/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.poi.CitySelectedCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class PrepareOnlinePOIAfterSelCityCommand
extends CitySelectedCommand {
    public void execute() {
        CommandList commandList = null;
        if (this.selectedCity == null) {
            NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
            this.env.getChoiceModel(400271).setValue(navLocation.isPositionValid() ? 1 : 0);
            if (navLocation.isPositionValid()) {
                this.logger.log(10000000, "PrepareOnlinePOIAfterSelCityCommand#execute() - use currentLD: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
            } else {
                this.logger.log(10000000, "PrepareOnlinePOIAfterSelCityCommand#execute() - location is not navigable (%1)!", (Object)LocationFormatter.formatLocationShort(navLocation));
            }
        } else {
            this.logger.log(10000000, "PrepareOnlinePOIAfterSelCityCommand#execute() - use selected city: %1", (Object)LocationFormatter.formatLocationShort(this.selectedCity));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

