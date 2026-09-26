/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class LISetHistoryCommand
extends NavCommand {
    private NavLocation location;

    public LISetHistoryCommand(NavLocation navLocation) {
        this.location = navLocation;
    }

    @Override
    public void execute() {
        String string = Util.getCountryAbbreviation(this.location);
        String string2 = Util.getStateAbbreviation(this.location);
        if (!Util.isEmpty(string) && !Util.isEmpty(string2)) {
            this.logger.log(-2137614336, "LISetHistoryCommand#execute() - calling liSetHistory( %1, %2 ) ", (Object)string, (Object)string2);
            this.getDSINavigation().liSetHistory(string, string2);
        } else if (!Util.isEmpty(string)) {
            this.logger.log(-2137614336, "LISetHistoryCommand#execute() - calling liSetCountryForCityAndStreetHistory( %1 ) ", (Object)string);
            this.getDSINavigation().liSetCountryForCityAndStreetHistory(string);
        } else {
            this.logger.log(-1601830656, "LISetHistoryCommand#execute() - no country abbreviation available");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void liHistoryResult(int n) {
        if (n == 0) {
            this.logger.log(-2137614336, "LISetHistoryCommand#liHistoryResult()");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "LISetHistoryCommand#liHistoryResult() - commandAborted");
            this.getCommandList().commandAborted(n);
        }
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        if (n == 0) {
            this.logger.log(-2137614336, "LISetHistoryCommand#liSetCountryForCityAndStreetHistoryResult()");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "LISetHistoryCommand#liSetCountryForCityAndStreetHistoryResult() - commandAborted");
            this.getCommandList().commandAborted(n);
        }
    }
}

