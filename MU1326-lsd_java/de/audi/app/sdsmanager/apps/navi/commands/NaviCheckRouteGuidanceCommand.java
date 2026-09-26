/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviCheckRouteGuidanceCommand
extends AbstractSystemCallCommand {
    private final NaviService service;

    public NaviCheckRouteGuidanceCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1.processCheckRouteGuidance] called", (Object)this.getName());
        this.service.checkRouteGuidance();
    }

    public void responseCheckRouteGuidance(byte by) {
        this.logger.log(-2137614336, "[%1#responseCheckRouteGuidance] result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(-2137614336, "[%1#responseCheckRouteGuidance] sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

