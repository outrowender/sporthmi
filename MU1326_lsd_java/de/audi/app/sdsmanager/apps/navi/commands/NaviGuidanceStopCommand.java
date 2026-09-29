/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviGuidanceStopCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;

    public NaviGuidanceStopCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] called", (Object)this.getName());
        this.naviService.stopRouteGuidance();
    }

    public void responseStopRouteGuidance(byte by) {
        this.logger.log(-2137614336, "[%1#responseStopRouteGuidance] result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getSDSResult(by);
        this.logger.log(-2137614336, "[%1#responseStopRouteGuidance] sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

