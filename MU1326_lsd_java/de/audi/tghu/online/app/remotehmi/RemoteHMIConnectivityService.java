/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.IConnectivityRHMIService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class RemoteHMIConnectivityService
implements IConnectivityRHMIService {
    private final LogChannel logger;
    private final RemoteHMIService remoteHmiService;

    public RemoteHMIConnectivityService(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logger = logChannel;
        this.remoteHmiService = remoteHMIService;
    }

    protected RemoteHMIAction getAction(int n) {
        return this.remoteHmiService.getAction(n);
    }

    public void activateSource(String string) {
        this.logger.log(10000000, "RemoteHMIConnectivityService#activateSource: device with address %1 activated.", (Object)string);
        RemoteHMIAction remoteHMIAction = this.getAction(10005000);
        remoteHMIAction.getParameters().putString("activatedMacAddress", string);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public void deactivateSource(String string) {
        this.logger.log(10000000, "RemoteHMIConnectivityService#deactivateSource: device with address %1 deactivated.", (Object)string);
        RemoteHMIAction remoteHMIAction = this.getAction(10006000);
        remoteHMIAction.getParameters().putString("activatedMacAddress", string);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }
}

