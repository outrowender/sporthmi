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

public class NaviRouteOptionsSetCommand
extends AbstractSystemCallCommand {
    private static final byte NAVI_ROUTE_SEMIDYN_AUTO = 0;
    private static final byte NAVI_NAVI_ROUTE_SEMIDYN_MANUAL = 1;
    private static final byte NAVI_NAVI_ROUTE_SEMIDYN_OFF = 2;
    private final NaviService service;
    private final byte routeOption;

    public NaviRouteOptionsSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
        this.routeOption = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(100000, "[%1#execute] routeOption=%2!", (Object)this.getName(), (long)this.routeOption);
        switch (this.routeOption) {
            case 0: {
                this.logger.log(10000000, "[%1#execute] Semidynamic Auto route requested!", (Object)this.getName());
                this.service.setRouteOptionDynamic(0);
                break;
            }
            case 1: {
                this.logger.log(10000000, "[%1#execute] Semidynamic Manual route requested!", (Object)this.getName());
                this.service.setRouteOptionDynamic(1);
                break;
            }
            case 2: {
                this.logger.log(10000000, "[%1#execute] Semidynamic Off route requested!", (Object)this.getName());
                this.service.setRouteOptionDynamic(2);
                break;
            }
            default: {
                this.logger.log(100000, "[%1#execute] Unhandled routeOption %2!", (Object)this.getName(), (long)this.routeOption);
                this.sendResult(3001);
            }
        }
    }

    public void responseSetRouteOption(byte by) {
        this.logger.log(10000000, "[%1#responseSetRouteOption] result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(10000000, "[%1#responseSetRouteOption] sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

