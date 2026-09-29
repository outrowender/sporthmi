/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.disambiguation;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class LISPGetLocationFromIndexCommand
extends NavCommand {
    private final int index;

    public LISPGetLocationFromIndexCommand(int n) {
        this.index = n;
    }

    @Override
    public void execute() {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "LISPGetLocationFromIndexCommand#execute with index = >>%1<< ", (long)this.index);
        }
        this.getDSINavigation().lispGetLocationFromLiValueListElement(this.index);
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "LISPGetLocationFromIndexCommand#lispGetLocationFromLiValueListResult: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        this.dsiResponseContainer.setSelectedLocation(navLocation);
        this.getCommandList().commandFinished();
    }
}

