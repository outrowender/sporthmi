/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class LISPGetLocationFromLIValueListElementCommand
extends NavCommand {
    private final LIValueListElement liValueListElement;

    public LISPGetLocationFromLIValueListElementCommand(LIValueListElement lIValueListElement) {
        this.liValueListElement = lIValueListElement;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "LISPGetLocationFromLIValueListElementCommand#execute - valueListElement#getListIndex=%1", (long)this.liValueListElement.getListIndex());
        this.logger.log(-2137614336, "LISPGetLocationFromLIValueListElementCommand#execute - valueListElement=%1", (Object)this.liValueListElement);
        this.getDSINavigation().lispGetLocationFromLiValueListElement(this.liValueListElement.getListIndex());
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        this.logger.log(1078071040, "LISPGetLocationFromLIValueListElementCommand#lispGetLocationFromLiValueListResult: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        if (navLocation == null || !navLocation.positionValid) {
            this.logger.log(10000, "LISPGetLocationFromLIValueListElementCommand#lispGetLocationFromLiValueListResult - listIndex=%1 no valid position", (long)n);
        }
        this.dsiResponseContainer.setSelectedLocation(navLocation);
        this.getCommandList().commandFinished();
    }
}

