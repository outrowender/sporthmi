/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class RemoteHMISDSStateListener
implements ISDSServiceStatusListener {
    private final LogChannel logChannel;
    private final RemoteHMIService remoteHmiService;

    public RemoteHMISDSStateListener(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logChannel = logChannel;
        this.remoteHmiService = remoteHMIService;
    }

    @Override
    public void notifySDSDialogStarted() {
        this.logChannel.log(-2137614336, "RemoteHMISDSStateListener#notifySDSDialogStarted: Called.");
        this.remoteHmiService.getTTS().abort();
    }

    @Override
    public void notifySDSDialogEnded() {
        this.logChannel.log(-2137614336, "RemoteHMISDSStateListener#notifySDSDialogEnded: Called.");
    }

    @Override
    public void notifySDSDialogAborting() {
    }
}

