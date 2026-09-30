/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviSetBypassRouteCommand
extends AbstractSystemCallCommand {
    private final NaviService service;
    private final boolean useBetterRoute;

    public NaviSetBypassRouteCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
        this.useBetterRoute = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: useBetterRoute=%2, leaving selection screen!", (Object)this.getName(), (Object)this.useBetterRoute);
        this.service.selectRoute(this.useBetterRoute ? (byte)1 : 0, true);
        this.sendResult(40000);
    }
}

