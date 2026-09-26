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

public class NaviRouteInfosSetCommand
extends AbstractSystemCallCommand {
    private final int routeInfoOff;
    private final int routeInfoOn;
    private final int routeInfoFull;
    private final int routeInfoReduced;
    private final int[][] routeInfoOptionToMapServiceIdMapping;
    private final int routeInfoOption;
    private final NaviService naviService;

    public NaviRouteInfosSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.routeInfoOff = 0;
        this.routeInfoOn = 1;
        this.routeInfoFull = 2;
        this.routeInfoReduced = 3;
        int[][] nArrayArray = new int[4][];
        int[] nArray = new int[2];
        super.getClass();
        nArray[0] = 0;
        nArray[1] = 3;
        nArrayArray[0] = nArray;
        int[] nArray2 = new int[2];
        super.getClass();
        nArray2[0] = 1;
        nArray2[1] = 0;
        nArrayArray[1] = nArray2;
        int[] nArray3 = new int[2];
        super.getClass();
        nArray3[0] = 2;
        nArray3[1] = 0;
        nArrayArray[2] = nArray3;
        int[] nArray4 = new int[2];
        super.getClass();
        nArray4[0] = 3;
        nArray4[1] = 1;
        nArrayArray[3] = nArray4;
        this.routeInfoOptionToMapServiceIdMapping = nArrayArray;
        this.routeInfoOption = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.naviService = naviService;
    }

    @Override
    public void execute() {
        int n = SDSUtils.translate(this.routeInfoOption, this.routeInfoOptionToMapServiceIdMapping);
        if (n == 128) {
            this.logger.log(10000, "[%1#execute] routeInfoOption=%2 is unknown!", (Object)this.getName(), (long)this.routeInfoOption);
            this.sendResult(1100742656);
            return;
        }
        this.logger.log(-2137614336, "[%1#execute] Setting route info option on navi service with mapServiceId=%2 (routeInfoOption=%3)!", (Object)this.getName(), (long)n, (long)this.routeInfoOption);
        byte by = this.naviService.setSdsRouteInfo(n);
        if (by != 0) {
            this.logger.log(10000, "[%1#execute] Navi service returned error!", (Object)this.getName());
            this.sendResult(1100742656);
        } else {
            this.sendResult(1083965440);
        }
    }
}

