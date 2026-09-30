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
import de.audi.atip.interapp.online.IOperatorCallSDSServiceListener;
import de.audi.atip.log.LogChannel;

public class NaviOperatorcallCommand
extends AbstractSystemCallCommand {
    private final int serviceType;
    private final IOperatorCallSDSService operatorCallService;
    private final IOperatorCallSDSServiceListener operatorCallServiceSDSListener;

    public NaviOperatorcallCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, IOperatorCallSDSService iOperatorCallSDSService, IOperatorCallSDSServiceListener iOperatorCallSDSServiceListener) {
        super(logChannel, string, sDSHandlerService);
        this.serviceType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.operatorCallService = iOperatorCallSDSService;
        this.operatorCallServiceSDSListener = iOperatorCallSDSServiceListener;
    }

    public void execute() {
        boolean bl;
        this.logger.log(10000000, "%1#execute: service type %2", (Object)this.getName(), (long)this.serviceType);
        int n = SDSUtils.translate(this.serviceType, NaviSDSUtils.operatorCallServiceType2dsiServiceType);
        boolean bl2 = bl = this.serviceType != 2;
        if (n == Integer.MIN_VALUE) {
            this.logger.log(10000, "%1#execute: no mapping for %2", (Object)this.getName(), (long)this.serviceType);
            this.sendResult(40001);
            return;
        }
        this.operatorCallService.startCallcenterCallBySDS(n, this.operatorCallServiceSDSListener, bl);
    }

    public void startCallcenterCallBySDSResult(int n) {
        this.logger.log(10000000, "%1#startCallcenterCallBySDSResult: result %2", (Object)this.getName(), (long)n);
        switch (n) {
            case 0: {
                this.sendResult(40000);
                break;
            }
            case 3: {
                this.sendResult(40022);
                break;
            }
            default: {
                this.sendResult(40001);
            }
        }
    }
}

