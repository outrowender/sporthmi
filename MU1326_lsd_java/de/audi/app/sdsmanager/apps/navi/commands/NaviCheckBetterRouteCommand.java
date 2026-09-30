/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviCheckBetterRouteCommand
extends AbstractSystemCallCommand {
    private final NaviService service;

    public NaviCheckBetterRouteCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        boolean bl = this.service.hasBetterRoute();
        this.logger.log(10000000, "%1#execute: isBetterRoute=%2", (Object)this.getName(), (Object)bl);
        if (bl) {
            this.logger.log(10000000, "%1#execute: Better route available, determining saved time, focusing the route and entering selection screen!");
            int n = this.service.getSavingTime();
            if (n == 0) {
                this.logger.log(100000, "%1#execute: Better route is supposed to be available but savedMinutes=%2", (Object)this.getName(), (long)n);
                bl = false;
            } else {
                String string = "";
                if (n > 0) {
                    string = Integer.toString(n);
                }
                SDSModelAccess.setNavRouteSavingTimeLabel(string);
                this.service.selectRoute((byte)1, false);
                this.service.switchToSemidynamicRouteGuidance();
            }
        }
        this.sendResult(bl ? 40000 : 40006);
    }
}

