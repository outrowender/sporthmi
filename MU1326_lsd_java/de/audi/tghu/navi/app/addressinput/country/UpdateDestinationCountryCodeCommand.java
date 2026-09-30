/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.country;

import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.navobserver.INavObserverRegistry;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class UpdateDestinationCountryCodeCommand
extends NavCommand {
    private static int NO_IMAGE_ID = -1;
    private NavLocation navLocation;

    public UpdateDestinationCountryCodeCommand() {
        this.navLocation = Vehicle.getInstance().getVehicleLocationDescription();
    }

    public UpdateDestinationCountryCodeCommand(NavLocation navLocation) {
        this.navLocation = navLocation;
    }

    public void execute() {
        if (Util.isHURegionNAR()) {
            this.logger.log(1000000, "UpdateDestinationCountryCodeCommand#execute HU is Region NAR send country AND state update");
            this.getNavObserverRegistry().countryUpdated(this.navLocation.getCountry(), this.navLocation.getCountryAbbreviation());
            String string = LocationFormatter.formatState(this.navLocation);
            String string2 = LocationFormatter.formatStateAbbreviation(this.navLocation);
            this.getNavObserverRegistry().stateUpdated(string, string2);
        } else {
            this.logger.log(1000000, "UpdateDestinationCountryCodeCommand#execute - send country update, country = %1, Abbreviation = %2", (Object)this.navLocation.getCountry(), (Object)this.navLocation.getCountryAbbreviation());
            this.getNavObserverRegistry().countryUpdated(this.navLocation.getCountry(), this.navLocation.getCountryAbbreviation());
        }
        int n = Util.getLocationAccessor(this.navLocation).getCountryIconIndex();
        int n2 = this.getIconHandler().resolveCountryIconResourceID(n);
        this.logger.log(1000000, "UpdateDestinationCountryCodeCommand#execute() - countryIconIndex = %1, resolvedIconID = %2", (long)n, (long)n2);
        this.updateSDSChoiceModel(n2);
        this.getCommandList().commandFinished();
    }

    private void updateSDSChoiceModel(int n) {
        this.logger.log(10000000, "%1#updateSDSChoiceModel() - update choiceModel with iconID = %2", (Object)this.CLASS_NAME, (long)n);
        if (n == 0) {
            this.logger.log(10000000, "%1#updateSDSChoiceModel() - invalid iconID = 0, changed to -1", (Object)this.CLASS_NAME);
            n = NO_IMAGE_ID;
        }
        this.env.getChoiceModel(402087).setValue(n);
    }

    private INavObserverRegistry getNavObserverRegistry() {
        return this.navigation.getNavObserverRegistry();
    }

    private IconHandler getIconHandler() {
        return this.navigation.getIconHandler();
    }
}

