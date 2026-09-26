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

public class NaviAddressInputCorrectionCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;
    private final byte destinationType;
    private final NaviSDSHandler naviHandler;

    public NaviAddressInputCorrectionCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviSDSHandler naviSDSHandler, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.naviHandler = naviSDSHandler;
        this.destinationType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: destinationType=%2", (Object)this.getName(), (long)this.destinationType);
        int n = NaviSDSUtils.getNaviDestType(this.destinationType);
        this.logger.log(-2137614336, "%1#execute: Trigger address input return with destType %2!", (Object)this.getName(), (long)n);
        NaviSDSUtils.resetVDEData(this.destinationType, this.naviHandler);
        switch (n) {
            case 19: {
                this.naviService.triggerMapCodeReturn();
                break;
            }
            default: {
                this.naviService.triggerAddressInputReturn(1);
            }
        }
    }

    public void responseTriggerAddressInputReturn(byte by) {
        this.logger.log(-2137614336, "%1#responseTriggerAddressInputReturn: result=%2", (Object)this.getName(), (long)by);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(-2137614336, "%1#responseTriggerAddressInputReturn: sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }

    public void responseMapCodeResult(byte by) {
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.logger.log(-2137614336, "%1#responseMapCodeResult: sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }
}

