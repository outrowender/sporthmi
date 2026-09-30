/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.countryinfo.ICountryInfoHandler;
import de.audi.tghu.navi.app.tr.TrafficRegulationService;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public class RequestRoadClassSpeedInfoForCountryCommand
extends NavCommand
implements TrafficRegulationService.CountrySpeedInfoObserver {
    private String countryAbbreviation;
    private ICountryInfoHandler handler;

    public RequestRoadClassSpeedInfoForCountryCommand(ICountryInfoHandler iCountryInfoHandler, String string) {
        this.handler = iCountryInfoHandler;
        this.countryAbbreviation = string;
    }

    public void execute() {
        if (Util.isHURegionAsia()) {
            this.logger.log(10000000, "RequestRoadClassSpeedInfoForCountryCommand#execute() - Asia not supported");
            this.getCommandList().commandFinished();
            return;
        }
        if (!Util.isEmpty(this.countryAbbreviation)) {
            this.logger.log(10000000, "RequestRoadClassSpeedInfoForCountryCommand#execute() - calling requestRoadClassSpeedInfoForCountry( %1 )", (Object)this.countryAbbreviation);
            TrafficRegulationService trafficRegulationService = this.navigation.getTrafficRegulationService();
            if (trafficRegulationService != null) {
                trafficRegulationService.registerCountrySpeedInfoObserver(this);
                trafficRegulationService.requestRoadClassSpeedInfoForCountry(this.countryAbbreviation);
            } else {
                this.logger.log(10000, "RequestRoadClassSpeedInfoForCountryCommand#execute() - TrafficRegulationService not available");
                this.getCommandList().commandFinished();
            }
        } else {
            this.logger.log(10000, "RequestRoadClassSpeedInfoForCountryCommand#execute() - countryAbbreviation not available");
            this.getCommandList().commandFinished();
        }
    }

    public void requestRoadClassSpeedInfoForCountryResult(RoadClassSpeedInfo[] roadClassSpeedInfoArray, int n) {
        this.logger.log(10000000, "RequestRoadClassSpeedInfoForCountryCommand#requestRoadClassSpeedInfoForCountryResult() - resultCode: %1", (long)n);
        this.navigation.getTrafficRegulationService().registerCountrySpeedInfoObserver(null);
        if (n == 0) {
            if (this.validateRCSInfoArray(roadClassSpeedInfoArray)) {
                if (this.handler != null) {
                    this.handler.updateRoadClassSpeedInfo(roadClassSpeedInfoArray);
                } else {
                    this.logger.log(10000, "RequestRoadClassSpeedInfoForCountryCommand#requestRoadClassSpeedInfoForCountryResult() - listener is null!");
                }
            } else {
                this.logger.log(10000000, "RequestRoadClassSpeedInfoForCountryCommand#requestRoadClassSpeedInfoForCountryResult() - result is null or countryAbbreviation (%1) does not match with first element of array", (Object)this.countryAbbreviation);
                if (this.handler != null) {
                    this.handler.updateRoadClassSpeedInfo(null);
                } else {
                    this.logger.log(10000, "RequestRoadClassSpeedInfoForCountryCommand#requestRoadClassSpeedInfoForCountryResult() - listener is null!");
                }
            }
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n);
        }
    }

    private boolean validateRCSInfoArray(RoadClassSpeedInfo[] roadClassSpeedInfoArray) {
        if (roadClassSpeedInfoArray == null) {
            return false;
        }
        return roadClassSpeedInfoArray.length == 0 || roadClassSpeedInfoArray[0].getCountryAbbreviation().equals(this.countryAbbreviation);
    }
}

