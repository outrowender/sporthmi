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

public class NaviDestinationAvailableAsiaCommand
extends AbstractSystemCallCommand {
    private final NaviService naviService;
    private final byte value;

    public NaviDestinationAvailableAsiaCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviService naviService) {
        super(logChannel, string, sDSHandlerService);
        this.naviService = naviService;
        this.value = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        int n;
        this.logger.log(10000000, "[%1#execute] value=%2", (Object)this.getName(), (long)this.value);
        if (this.value != 0) {
            this.logger.log(10000, "[%1#execute] unexpected value %2", (Object)this.getName(), (long)this.value);
            n = 40001;
        } else {
            boolean bl = this.naviService.isDestTypeAvailable(5);
            boolean bl2 = this.naviService.isDestTypeAvailable(3);
            n = bl ? (bl2 ? 40000 : 40012) : (bl2 ? 40011 : 40006);
        }
        this.sendResult(n);
    }
}

