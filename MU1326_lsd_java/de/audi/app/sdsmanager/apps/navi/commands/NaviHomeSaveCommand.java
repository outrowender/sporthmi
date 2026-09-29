/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviHomeSaveCommand
extends AbstractSystemCallCommand {
    private final NaviService service;

    public NaviHomeSaveCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] Save home address", (Object)this.getName());
        byte by = this.service.setHomeAddress();
        if (by == 0) {
            this.logger.log(-2137614336, "[%1#execute] Home address successfully set!", (Object)this.getName());
            SDSModelAccess.setFavoritesStatus(0);
            this.sendResult(1083965440);
            return;
        }
        if (by == 1) {
            this.logger.log(10000, "[%1#execute] Error during setting of home address!", (Object)this.getName());
        } else {
            this.logger.log(-1601830656, "[%1#execute] Unknown response from navi service, treating as error: %2!", (Object)this.getName(), (long)by);
        }
        this.logger.log(-2137614336, "[%1#execute] No home address available, preparing jump to D4_NAV_WIZARD_FAVORITES_NODATA!", (Object)this.getName());
        SDSModelAccess.setFavoritesStatus(1);
        this.sendResult(1100742656);
    }
}

