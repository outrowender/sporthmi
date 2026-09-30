/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.online.IPhoneStateService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class RemoteHMIPhoneStatusService
implements IPhoneStateService,
RemoteHMIDSIAccess.IRemoteHMIDSIListener {
    public RemoteHMIService remoteHmiService;
    public LogChannel logchannel;
    private boolean phoneAvailable;

    public RemoteHMIPhoneStatusService(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.remoteHmiService = remoteHMIService;
        this.logchannel = logChannel;
        remoteHMIService.getDsiAccess().addDSIListener(this);
    }

    public void updatePhoneStatus(boolean bl) {
        this.logchannel.log(1000000, "RemoteHMIPhoneStatusService#updatePhoneStatus: phone %1", (Object)(bl ? "available" : "not available"));
        this.phoneAvailable = bl;
        RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(10008900);
        remoteHMIAction.getParameters().put("phoneStatus", new Boolean(bl));
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public void remoteHmiDsiReady() {
        this.logchannel.log(1000000, "RemoteHMIPhoneStatusService#remoteHmiDsiReady: sending phone %1", (Object)(this.phoneAvailable ? "available" : "not available"));
        RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(10008900);
        remoteHMIAction.getParameters().put("phoneStatus", new Boolean(this.phoneAvailable));
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }
}

