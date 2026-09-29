/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class LiLastCityOrStreetHistoryAddCommand
extends NavCommand {
    private boolean isLastCity;
    private boolean hasStreets;
    private NavLocation location;
    private String name;

    public LiLastCityOrStreetHistoryAddCommand(NavLocation navLocation, boolean bl, String string) {
        this.isLastCity = true;
        this.location = navLocation;
        this.hasStreets = bl;
        this.name = string;
    }

    public LiLastCityOrStreetHistoryAddCommand(NavLocation navLocation, String string) {
        this.isLastCity = false;
        this.location = navLocation;
        this.hasStreets = false;
        this.name = string;
    }

    @Override
    public void execute() {
        if (this.isLastCity) {
            this.logger.log(-2137614336, "LiLastCityOrStreetHistoryAddCommand#execute() - calling liLastCityHistoryAdd(%1) ", (Object)LocationFormatter.formatLocationShort(this.location));
            this.getDSINavigation().liLastCityHistoryAdd(this.location, this.hasStreets, this.name);
        } else {
            this.logger.log(-2137614336, "LiLastCityOrStreetHistoryAddCommand#execute() - calling liLastStreetHistoryAdd(%1) ", (Object)LocationFormatter.formatLocationShort(this.location));
            this.getDSINavigation().liLastStreetHistoryAdd(this.location, this.name);
        }
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        if (l == 0L) {
            this.logger.log(-2137614336, "LiLastCityOrStreetHistoryAddCommand#liLastCityAndStreetHistoryResult()");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "LiLastCityOrStreetHistoryAddCommand#liLastCityAndStreetHistoryResult() - commandAborted");
            this.getCommandList().commandAborted(l);
        }
    }
}

