/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviDestinationDeleteCommand
extends AbstractSystemCallCommand {
    private final NaviService service;

    public NaviDestinationDeleteCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] called", (Object)this.getName());
        this.service.reduceRouteToFinalDestination();
    }

    public void responseReduceRouteToFinalDestination(byte by) {
        this.logger.log(10000000, "[%1#responseReduceRouteToFinalDestination] result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(10000000, "[%1#responseReduceRouteToFinalDestination] sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

