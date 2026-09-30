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

public class NaviAddDestinationCommand
extends AbstractSystemCallCommand {
    private static final int ROUTE_OPTION_STOPOVER_ADD = 0;
    private static final int ROUTE_OPTION_STOPOVER_REPLACE = 1;
    private static final int ROUTE_OPTION_REPLACE_ALL = 2;
    private static final int ROUTE_OPTION_REPLACE_LAST_DEST = 3;
    private final int routeOptions;
    private final NaviService naviService;

    public NaviAddDestinationCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.routeOptions = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.naviService = naviService;
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] addDestination with routeOptions=%2!", (Object)this.getName(), (long)this.routeOptions);
        switch (this.routeOptions) {
            case 0: {
                this.naviService.addSelectedDestinationAtIndex(0, false);
                break;
            }
            case 1: {
                this.naviService.addSelectedDestinationAtIndex(0, true);
                break;
            }
            case 2: {
                this.naviService.addSelectedDestinationAtIndex(-2, true);
                break;
            }
            case 3: {
                this.naviService.addSelectedDestinationAtIndex(-1, true);
                break;
            }
            default: {
                this.logger.log(100000, "[%1#execute] Unknown routeOptions=%2, sending ERROR!", (Object)this.getName(), (long)this.routeOptions);
                this.sendResult(3001);
            }
        }
    }

    public void responseAddSelectedDestinationAtIndex(byte by) {
        this.logger.log(10000000, "[%1#responseAddSelectedDestinationAtIndex] result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getSDSResult(by);
        this.logger.log(10000000, "[%1#responseAddSelectedDestinationAtIndex] sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

