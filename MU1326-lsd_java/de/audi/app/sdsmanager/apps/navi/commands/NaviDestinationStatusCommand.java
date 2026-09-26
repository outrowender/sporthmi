/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviDestinationStatusCommand
extends AbstractSystemCallCommand {
    private final NaviService service;

    public NaviDestinationStatusCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
    }

    @Override
    public void execute() {
        int n = 3000;
        if (this.service.isRouteGuidancePossible()) {
            this.logger.log(-2137614336, "[%1#execute] Navigable route or destination available!", (Object)this.getName());
        } else {
            this.logger.log(-1601830656, "[%1#execute] No navigable destinations found!", (Object)this.getName());
            n = 3001;
        }
        this.sendResult(n);
    }
}

