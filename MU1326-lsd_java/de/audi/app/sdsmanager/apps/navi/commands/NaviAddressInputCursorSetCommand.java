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

public class NaviAddressInputCursorSetCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;
    private final byte destinationType;

    public NaviAddressInputCursorSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.destinationType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: destinationType=%2", (Object)this.getName(), (long)this.destinationType);
        int n = NaviSDSUtils.getNaviDestType(this.destinationType);
        this.logger.log(-2137614336, "%1#execute: Move cursor position to destType %2!", (Object)this.getName(), (long)n);
        this.naviService.nextDestinationInput(n);
        this.processingFinished();
    }
}

