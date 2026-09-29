/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo;

import de.audi.app.navi.evo.NavigationEvo;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.country.UpdateDestinationCountryCodeCommand;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.SaveLocationToPersistenceCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class NavigationEvo$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$oldLocation;
    private final /* synthetic */ NavigationEvo this$0;

    NavigationEvo$1(NavigationEvo navigationEvo, String string, NavLocation navLocation) {
        this.this$0 = navigationEvo;
        this.val$oldLocation = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = NavigationEvo.access$000(this.this$0).getVehicleLocationDescription();
        if (this.val$oldLocation == null) {
            this.oldLocationIsNull(navLocation);
        } else if (navLocation == null) {
            this.logger.log(-2137614336, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#execute() - newLocation is null or has the same countryname (newLocation = %1)", (Object)LocationFormatter.formatLocationShort(navLocation));
            this.getCommandList().commandFinished();
        } else if (Util.isEmpty(navLocation.country)) {
            this.logger.log(-2137614336, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#execute() - newLocation.country is empty! (newLocation = %1)", (Object)LocationFormatter.formatLocationShort(navLocation));
            this.getCommandList().commandFinished();
        } else if (navLocation.country.equalsIgnoreCase(this.val$oldLocation.country)) {
            this.logger.log(-2137614336, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#execute() - newLocation and oldlocation have the same countryname (country = %1)", (Object)navLocation.country);
            this.getCommandList().commandFinished();
        } else {
            this.createUpdateCountryCodeCommandListAndFinish(navLocation);
        }
    }

    private void oldLocationIsNull(NavLocation navLocation) {
        if (navLocation == null) {
            this.logger.log(10000, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#oldLocationIsNull() - oldLocation AND newLocation are null!");
            this.getCommandList().commandFinished();
        } else if (Util.isEmpty(navLocation.country)) {
            this.logger.log(10000, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#oldLocationIsNull() - newLocation has no country! (newLocation = %1)", (Object)LocationFormatter.formatLocationShort(navLocation));
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(-2137614336, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#oldLocationIsNull - newLocation looks valid -> update!");
            this.createUpdateCountryCodeCommandListAndFinish(navLocation);
        }
    }

    private void createUpdateCountryCodeCommandListAndFinish(NavLocation navLocation) {
        CommandList commandList = NavigationEvo.access$100(this.this$0).createCommandList();
        commandList.add(new LocationToStreamCommand(navLocation));
        commandList.add(new SaveLocationToPersistenceCommand(989, "LOCATION_STREAM"));
        if (!this.env.getInputModeManager().isSdsActive()) {
            commandList.add(new UpdateDestinationCountryCodeCommand(navLocation));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

