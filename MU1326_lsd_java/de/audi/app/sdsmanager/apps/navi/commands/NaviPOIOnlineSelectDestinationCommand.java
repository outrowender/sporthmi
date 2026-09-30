/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.NavLocation;

public class NaviPOIOnlineSelectDestinationCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandler sdsHandler;
    private final NaviSDSPOIOnlineService poiOnlineService;

    public NaviPOIOnlineSelectDestinationCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandler naviSDSHandler, NaviSDSPOIOnlineService naviSDSPOIOnlineService) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandler;
        this.poiOnlineService = naviSDSPOIOnlineService;
    }

    public void execute() {
        int n = Math.max(0, SDSModelAccess.getEnumerationNumberStatus());
        this.logger.log(10000000, "[%1#execute] index of selected row=%2", (Object)this.getName(), (long)n);
        this.poiOnlineService.selectDestination(n);
    }

    public void responseSelectDestination(NavLocation navLocation) {
        if (navLocation == null) {
            this.logger.log(100000, "[%1#execute] responseSelectDestination is null!", (Object)this.getName());
            this.sendResult(40001);
            return;
        }
        this.sdsHandler.setPoiOnlineDestination(navLocation);
        this.sendResult(40000);
    }
}

