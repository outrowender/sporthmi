/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.NavPoiInfo;

public class RequestRMLPOIInformationCommand
extends NavCommand {
    private CombinedRouteListElement combinedRouteListElement;

    public RequestRMLPOIInformationCommand(CombinedRouteListElement combinedRouteListElement) {
        this.combinedRouteListElement = combinedRouteListElement;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "RequestRMLPOIInformationCommand#execute - calling requestPOIInformation( %1 )", this.combinedRouteListElement.getUid());
        this.getDSICombinedRouteList().requestPOIInformation(this.combinedRouteListElement.getUid());
    }

    @Override
    public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
        this.logger.log(-2137614336, "RequestRMLPOIInformationCommand#poiInformationResult()");
        if (n == 0) {
            NavLocation[] navLocationArray = navPoiInfo.getPoiLocations();
            if (navLocationArray != null && navLocationArray.length > 0) {
                this.dsiResponseContainer.setRMLPOILocation(navLocationArray[0]);
                this.getCommandList().commandFinished();
            } else {
                this.logger.log(10000, "RequestRMLPOIInformationCommand#poiInformationResult() - no location information found !");
                this.getCommandList().commandAborted("no location information");
            }
        } else {
            this.logger.log(10000, "RequestPOIInformationCommand#poiInformationResult() - error in result: %1 !", (long)n);
            this.getCommandList().commandAborted(n);
        }
    }
}

