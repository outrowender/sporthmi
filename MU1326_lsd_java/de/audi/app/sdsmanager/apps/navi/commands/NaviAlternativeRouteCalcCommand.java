/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviAlternativeRouteCalcCommand
extends AbstractSystemCallCommand {
    private final NaviService service;

    public NaviAlternativeRouteCalcCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        this.updateSelectedAlternativeRoute();
        this.service.calculateAlternativeRoutes();
    }

    protected void updateSelectedAlternativeRoute() {
    }

    public void responseCalculateAlternativeRoutes(byte by) {
        this.logger.log(10000000, "%1#responseCalculateAlternativeRoutes: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getSDSResult(by);
        this.logger.log(10000000, "%1#responseCalculateAlternativeRoutes: sdsRes=%2", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

