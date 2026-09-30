/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class LISetCountryForCityAndStreetHistoryCommand
extends NavCommand {
    private String countryAbbrev;

    public LISetCountryForCityAndStreetHistoryCommand(String string) {
        this.countryAbbrev = string;
    }

    public void execute() {
        if (this.countryAbbrev != null && this.countryAbbrev.length() > 0) {
            this.logger.log(10000000, "LISetCountryForCityAndStreetHistoryCommand#execute() - calling liSetCountryForCityAndStreetHistory( %1 ) ", (Object)this.countryAbbrev);
            this.getDSINavigation().liSetCountryForCityAndStreetHistory(this.countryAbbrev);
        } else {
            this.logger.log(100000, "LISetCountryForCityAndStreetHistoryCommand#execute() - no country abbreviation set");
            this.getCommandList().commandFinished();
        }
    }

    public void updateLiCountryForCityAndStreetHistory(String string) {
        this.logger.log(10000000, "LISetCountryForCityAndStreetHistoryCommand#updateLiCountryForCityAndStreetHistory( %1 )", (Object)string);
    }

    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        if (n == 0) {
            this.logger.log(10000000, "LISetCountryForCityAndStreetHistoryCommand#liSetCountryForCityAndStreetHistoryResult()");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "LISetCountryForCityAndStreetHistoryCommand#liSetCountryForCityAndStreetHistoryResult() - commandAborted");
            this.getCommandList().commandAborted(n);
        }
    }
}

