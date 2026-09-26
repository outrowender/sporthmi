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

public class SystemConnectionAcceptCommand
extends AbstractSystemCallCommand {
    private static final int CONNECTION_DECLINE_ONCE;
    private static final int CONNECTION_ACCEPT_ONCE;
    private static final int CONNECTION_ACCEPT_ALWAYS;
    private static final int CONNECTION_DECLINE_ALWAYS;
    private final int acceptConnection;
    private final ISdsConnectivityService connectivity;

    public SystemConnectionAcceptCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISdsConnectivityService iSdsConnectivityService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.acceptConnection = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
        this.connectivity = iSdsConnectivityService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: acceptConnection=%2", (Object)this.getName(), (long)this.acceptConnection);
        switch (this.acceptConnection) {
            case 0: {
                this.logger.log(-2137614336, "%1#execute: decline connection", (Object)this.getName());
                this.connectivity.reject();
                break;
            }
            case 1: {
                this.logger.log(-2137614336, "%1#execute: accept connection once", (Object)this.getName());
                this.connectivity.acceptOnce();
                break;
            }
            case 2: {
                this.logger.log(-2137614336, "%1#execute: accept connection always", (Object)this.getName());
                this.connectivity.acceptAlways();
                break;
            }
            case 3: {
                this.logger.log(-2137614336, "%1#execute: decline connection forever", (Object)this.getName());
                this.connectivity.deactivateOnlineConnection();
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#execute: unhandled accept mode %2", (Object)this.getName(), (long)this.acceptConnection);
                this.sendResult(3001);
                return;
            }
        }
        this.sendResult(3000);
    }
}

