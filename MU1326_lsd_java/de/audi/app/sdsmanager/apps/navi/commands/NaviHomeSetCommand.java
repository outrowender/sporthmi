/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviHomeSetCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandler sdsHandler;
    private final NaviService service;

    public NaviHomeSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviSDSHandler naviSDSHandler, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandler;
        this.service = naviService;
    }

    public void execute() {
        this.sdsHandler.setSDSAddressInputMode((byte)5);
        if (this.service.isHomeAvailable()) {
            this.logger.log(10000000, "[%1#execute] Home address available, setting input mode!", (Object)this.getName());
            SDSModelAccess.setFavoritesStatus(0);
            byte by = this.service.selectHomeAddressForRouteGuidance();
            this.logger.log(10000000, "[%1#execute] Navi setting home address for route guidance result=%2!", (Object)this.getName(), (long)by);
            if (by == 0) {
                this.sendResult(3000);
                return;
            }
            this.sendResult(3001);
        } else {
            this.logger.log(10000000, "[%1#execute] No home address available, preparing jump to D4_NAV_WIZARD_FAVORITES_NODATA!", (Object)this.getName());
            SDSModelAccess.setFavoritesStatus(1);
            this.sendResult(3006);
        }
    }
}

