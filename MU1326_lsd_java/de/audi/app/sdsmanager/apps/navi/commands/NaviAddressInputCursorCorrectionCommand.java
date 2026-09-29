/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviAddressInputCursorCorrectionCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;
    private final byte resetDestType;
    private final byte focusDestType;
    private final NaviSDSHandler naviHandler;

    public NaviAddressInputCursorCorrectionCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviSDSHandler naviSDSHandler, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.naviHandler = naviSDSHandler;
        this.resetDestType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.focusDestType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 1);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: resetDestType=%2 focusDestType=%3", (Object)this.getName(), (long)this.resetDestType, (long)this.focusDestType);
        NaviSDSUtils.resetVDEData(this.resetDestType, this.naviHandler);
        int n = NaviSDSUtils.getNaviDestType(this.focusDestType);
        this.logger.log(-2137614336, "%1#execute: Trigger address input return with destType %2!", (Object)this.getName(), (long)n);
        this.naviService.triggerAddressInputReturn(1, n);
    }

    public void responseTriggerAddressInputReturn(byte by) {
        this.logger.log(-2137614336, "%1#responseTriggerAddressInputReturn: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(-2137614336, "%1#responseTriggerAddressInputReturn: sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

