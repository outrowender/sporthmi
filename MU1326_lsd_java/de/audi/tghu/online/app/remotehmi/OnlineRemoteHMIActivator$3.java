/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.IRemoteHMI;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$3
extends AbstractRemoteHMITask {
    private final /* synthetic */ IRemoteHMI val$remoteHmi;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$3(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IRemoteHMI iRemoteHMI) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$remoteHmi = iRemoteHMI;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setIRemoteHMI(this.val$remoteHmi);
    }
}

