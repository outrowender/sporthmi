/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviAlternativeRouteNumberSetCommand
extends AbstractSystemCallCommand {
    private static final byte NAVI_ROUTE_NUMBER_1;
    private static final byte NAVI_ROUTE_NUMBER_2;
    private static final byte NAVI_ROUTE_NUMBER_3;
    private static final byte[][] routeNumberToAlternativeRouteNumber;
    private final byte routeNumber;
    private final NaviService service;

    public NaviAlternativeRouteNumberSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.routeNumber = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.service = naviService;
    }

    @Override
    public void execute() {
        byte by = SDSUtils.translate(this.routeNumber, routeNumberToAlternativeRouteNumber);
        this.logger.log(-2137614336, "%1#execute: routeNumber=%2, altRouteNumber=%3", (Object)this.getName(), (long)this.routeNumber, (long)by);
        if (by == -128) {
            this.logger.log(-1601830656, "%1#execute: Unhandled routeNumber %2!", (Object)this.getName(), (long)this.routeNumber);
            this.sendResult(1100742656);
            return;
        }
        this.service.selectAlternativeRoute(by);
    }

    public void responseSelectAlternativeRoute(byte by) {
        this.logger.log(-2137614336, "%1#responseSelectAlternativeRoute: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getSDSResult(by);
        this.logger.log(-2137614336, "%1#responseSelectAlternativeRoute: sdsRes=%2", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }

    static {
        routeNumberToAlternativeRouteNumber = new byte[][]{{0, 0}, {1, 1}, {2, 2}};
    }
}

