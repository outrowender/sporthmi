/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.countryinfo.ICountryInfoHandler;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.CountryInfo;

public class RequestCountryInfoCommand
extends NavCommand {
    private String countryAbbreviation;
    private ICountryInfoHandler handler;

    public RequestCountryInfoCommand(ICountryInfoHandler iCountryInfoHandler, String string) {
        this.handler = iCountryInfoHandler;
        this.countryAbbreviation = string;
    }

    public void execute() {
        if (!Util.isEmpty(this.countryAbbreviation)) {
            this.logger.log(10000000, "RequestCountryInfoCommand#execute() - calling requestCountryInfo( %1 )", (Object)this.countryAbbreviation);
            this.getDSINavigation().requestCountryInfo(this.countryAbbreviation);
        } else {
            this.logger.log(10000, "RequestCountryInfoCommand#execute() - countryAbbreviation not available");
            this.getCommandList().commandFinished();
        }
    }

    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
        this.logger.log(10000000, "RequestCountryInfoCommand#requestCountryInfoResult() - resultCode: %1", (long)n);
        if (n == 0) {
            if (countryInfo != null && !Util.isEmpty(this.countryAbbreviation) && this.countryAbbreviation.equals(countryInfo.getCountryAbbreviation())) {
                if (this.handler != null) {
                    this.handler.updateCountryInfo(countryInfo);
                } else {
                    this.logger.log(10000, "RequestCountryInfoCommand#requestCountryInfoResult() - listener is null!");
                }
            } else {
                this.logger.log(10000000, "RequestCountryInfoCommand#requestCountryInfoResult() - result is null or countryAbbreviation (%1) does not match", (Object)this.countryAbbreviation);
                if (this.handler != null) {
                    this.handler.updateCountryInfo(null);
                } else {
                    this.logger.log(10000, "RequestCountryInfoCommand#requestCountryInfoResult() - listener is null!");
                }
            }
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n);
        }
    }
}

