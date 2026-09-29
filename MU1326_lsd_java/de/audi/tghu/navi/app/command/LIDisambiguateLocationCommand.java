/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.addressinput.asia.DisambiguatedNavLocation;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;

public class LIDisambiguateLocationCommand
extends NavCommand {
    private NavLocation location;

    public LIDisambiguateLocationCommand(NavLocation navLocation) {
        this.location = navLocation;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "LIDisambiguateLocationCommand#execute() - calling liDisambiguateLocation(%1)", (Object)LocationFormatter.formatLocationShort(this.location));
        this.getDSINavigation().liDisambiguateLocation(this.location);
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
        this.logger.log(-2137614336, "LIDisambiguateLocationCommand#liDisambiguateLocationResult - type.length=%1, locations.length=%2", (long)nArray.length, (long)navLocationArray.length);
        if (nArray == null || navLocationArray == null) {
            this.getCommandList().commandAborted("LIDisambiguateLocationCommand#liDisambiguateLocationResult - result lists are null.");
        } else if (nArray.length != navLocationArray.length) {
            this.getCommandList().commandAborted("LIDisambiguateLocationCommand#liDisambiguateLocationResult - length of resultlists are uneven.");
        } else if (navLocationArray.length == 0) {
            this.getCommandList().commandAborted("LIDisambiguateLocationCommand#liDisambiguateLocationResult - length of resultlists is 0.");
        }
        int n = navLocationArray.length;
        Buffer buffer = new Buffer();
        DisambiguatedNavLocation[] disambiguatedNavLocationArray = new DisambiguatedNavLocation[n];
        for (int i2 = 0; i2 < n; ++i2) {
            disambiguatedNavLocationArray[i2] = new DisambiguatedNavLocation(nArray[i2], navLocationArray[i2]);
            buffer.append(disambiguatedNavLocationArray[i2].toString()).append("\n");
        }
        this.logger.log(-2137614336, "LIDisambiguateLocationCommand#liDisambiguateLocationResult - results=%1", (Object)buffer.toString());
        this.dsiResponseContainer.setDisambiguatedNavLocations(disambiguatedNavLocationArray);
        this.getCommandList().commandFinished();
    }
}

