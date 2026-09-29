/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public abstract class AbstractRemoteHMIComponent {
    protected LogChannel logChannel;
    protected RemoteHMIService remoteHmiService;

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logChannel = logChannel;
        this.remoteHmiService = remoteHMIService;
    }

    public void onExit() {
    }

    public void onEnter() {
    }

    protected OnlineModelBankAccess getModelBank() {
        return this.remoteHmiService.getModelBankAccess();
    }

    protected IFrameworkAccess getFrameworkAccess() {
        return this.remoteHmiService.getFrameworkAccess();
    }
}

