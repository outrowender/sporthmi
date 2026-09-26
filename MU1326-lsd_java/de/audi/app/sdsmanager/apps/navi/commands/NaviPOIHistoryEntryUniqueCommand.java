/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.online.IOperatorCallSDSService;
import de.audi.atip.log.LogChannel;

public class NaviPOIHistoryEntryUniqueCommand
extends AbstractSystemCallCommand {
    private final IOperatorCallSDSService operatorCAllService;
    private final int serviceType;

    public NaviPOIHistoryEntryUniqueCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, IOperatorCallSDSService iOperatorCallSDSService) {
        super(logChannel, string, sDSHandlerService);
        this.operatorCAllService = iOperatorCallSDSService;
        this.serviceType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        int n = this.sdsHandlerService.getSelectedRow();
        this.logger.log(-2137614336, "%1#execute: selected row %2", (Object)this.getName(), (long)n);
        if (n < 0) {
            this.logger.log(10000, "%1#execute: selected row < 0", (Object)this.getName());
            this.sendResult(1100742656);
            return;
        }
        int n2 = SDSUtils.translate(this.serviceType, NaviSDSUtils.operatorCallServiceType2dsiServiceType);
        if (n2 == 128) {
            this.logger.log(10000, "%1#execute: service type %2 invalid", (Object)this.getName(), (long)this.serviceType);
            this.sendResult(1100742656);
            return;
        }
        int n3 = this.operatorCAllService.getNumberOfPoisOfHistoryCallForSDS(n2, n);
        if (n3 <= 0) {
            this.logger.log(10000, "%1#execute: number of POIs for row %2 = %3", (Object)this.getName(), (long)n, (long)n3);
            this.sendResult(1100742656);
            return;
        }
        this.sendResult(n3 == 1 ? 1083965440 : 1251737600);
    }
}

