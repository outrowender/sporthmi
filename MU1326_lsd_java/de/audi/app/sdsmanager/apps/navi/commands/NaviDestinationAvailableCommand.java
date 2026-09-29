/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;

public class NaviDestinationAvailableCommand
extends AbstractSystemCallCommand {
    private final NaviService service;
    private final byte destinationType;

    public NaviDestinationAvailableCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
        this.destinationType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] destinationType=%2", (Object)this.getName(), (long)this.destinationType);
        SDSModelAccess.setNaviDestinationTypeModel(this.destinationType);
        int n = NaviSDSUtils.getNaviDestType(this.destinationType);
        if (n == -1) {
            this.logger.log(-1601830656, "[%1#execute] No matching destination type found for destinationType %2!", (Object)this.getName(), (long)this.destinationType);
            this.sendResult(3001);
            return;
        }
        boolean bl = this.service.isDestTypeAvailable(n);
        this.logger.log(-2137614336, "[%1#execute] naviDestType=%3, destTypeAvailable=%2!", (Object)this.getName(), (Object)bl, (long)n);
        int n2 = this.destinationType == 39 ? (bl ? 1402732544 : 1419509760) : (bl ? 3000 : 3001);
        this.sendResult(n2);
    }
}

