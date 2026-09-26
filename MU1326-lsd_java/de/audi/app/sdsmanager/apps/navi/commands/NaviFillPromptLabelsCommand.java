/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviService$NaviInfoDetails;
import de.audi.atip.log.LogChannel;

public class NaviFillPromptLabelsCommand
extends AbstractSystemCallCommand {
    private final NaviService service;
    private NaviSDSHandler naviHandler;

    public NaviFillPromptLabelsCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService, NaviSDSHandler naviSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
        this.naviHandler = naviSDSHandler;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called");
        NaviService$NaviInfoDetails naviService$NaviInfoDetails = this.service.getAddressDetails(this.naviHandler.getSDSAddressInputMode());
        this.logger.log(-2137614336, "%1#execute: infoDetails=%2!", (Object)this.getName(), (Object)naviService$NaviInfoDetails);
        if (naviService$NaviInfoDetails == null) {
            this.logger.log(-1601830656, "%1#execute: No infoDetails given!", (Object)this.getName());
            this.sendResult(1100742656);
            return;
        }
        SDSModelAccess.setOneshotCityLabel(SDSUtils.isEmpty(naviService$NaviInfoDetails.city) ? "" : naviService$NaviInfoDetails.city);
        SDSModelAccess.setOneshotStreetLabel(SDSUtils.isEmpty(naviService$NaviInfoDetails.street) ? "" : naviService$NaviInfoDetails.street);
        SDSModelAccess.setOneshotHouseNRLabel(SDSUtils.isEmpty(naviService$NaviInfoDetails.houseNumber) ? "" : naviService$NaviInfoDetails.houseNumber);
        if (SDSUtils.isEmpty(naviService$NaviInfoDetails.city)) {
            this.logger.log(-2137614336, "%1#execute: No city in infoDetails given!", (Object)this.getName());
            this.sendResult(1184628736);
        } else {
            this.sendResult(1083965440);
        }
    }
}

