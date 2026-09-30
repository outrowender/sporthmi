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

    public void execute() {
        this.logger.log(10000000, "%1#execute: called");
        NaviService.NaviInfoDetails naviInfoDetails = this.service.getAddressDetails(this.naviHandler.getSDSAddressInputMode());
        this.logger.log(10000000, "%1#execute: infoDetails=%2!", (Object)this.getName(), (Object)naviInfoDetails);
        if (naviInfoDetails == null) {
            this.logger.log(100000, "%1#execute: No infoDetails given!", (Object)this.getName());
            this.sendResult(40001);
            return;
        }
        SDSModelAccess.setOneshotCityLabel(SDSUtils.isEmpty(naviInfoDetails.city) ? "" : naviInfoDetails.city);
        SDSModelAccess.setOneshotStreetLabel(SDSUtils.isEmpty(naviInfoDetails.street) ? "" : naviInfoDetails.street);
        SDSModelAccess.setOneshotHouseNRLabel(SDSUtils.isEmpty(naviInfoDetails.houseNumber) ? "" : naviInfoDetails.houseNumber);
        if (SDSUtils.isEmpty(naviInfoDetails.city)) {
            this.logger.log(10000000, "%1#execute: No city in infoDetails given!", (Object)this.getName());
            this.sendResult(40006);
        } else {
            this.sendResult(40000);
        }
    }
}

