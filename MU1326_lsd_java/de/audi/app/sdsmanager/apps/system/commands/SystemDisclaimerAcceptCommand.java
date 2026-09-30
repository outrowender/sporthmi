/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.ISdsConnectivityService;
import de.audi.atip.log.LogChannel;

public class SystemDisclaimerAcceptCommand
extends AbstractSystemCallCommand {
    private final boolean acceptDisclaimer;
    private final ISdsConnectivityService connectivity;

    public SystemDisclaimerAcceptCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISdsConnectivityService iSdsConnectivityService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.acceptDisclaimer = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 0);
        this.connectivity = iSdsConnectivityService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: acceptDisclaimer=%2", (Object)this.getName(), (Object)this.acceptDisclaimer);
        if (this.acceptDisclaimer) {
            this.connectivity.disclaimerAccept();
        } else {
            this.connectivity.reject();
        }
        this.sendResult(3000);
    }
}

