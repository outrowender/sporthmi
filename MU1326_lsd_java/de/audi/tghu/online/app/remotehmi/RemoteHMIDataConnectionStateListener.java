/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.DataConnectionStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class RemoteHMIDataConnectionStateListener
implements DataConnectionStateListener {
    private final LogChannel logger;
    private final RemoteHMIService remoteHmiService;

    public RemoteHMIDataConnectionStateListener(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logger = logChannel;
        this.remoteHmiService = remoteHMIService;
    }

    public void updateDataConnectionErrorState(int n) {
        this.logger.log(1000000, "RemoteHMIDataConnectionStateListener#updateDataConnectionErrorState: state %1", (Object)Integer.toString(n));
        RemoteHMIAction remoteHMIAction = this.getAction(1600);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public void updateDataConnectionState(int n) {
        this.logger.log(1000000, "RemoteHMIDataConnectionStateListener#updateDataConnectionState: state %1", (Object)Integer.toString(n));
    }

    public void resetOfflineFlags() {
    }

    protected RemoteHMIAction getAction(int n) {
        return this.remoteHmiService.getAction(n);
    }
}

