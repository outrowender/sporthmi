/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess$IRemoteHMIDSIListener;

class RemoteHMIServiceEvo$7
implements RemoteHMIDSIAccess$IRemoteHMIDSIListener {
    private final /* synthetic */ RemoteHMIAction val$action;
    private final /* synthetic */ RemoteHMIServiceEvo this$0;

    RemoteHMIServiceEvo$7(RemoteHMIServiceEvo remoteHMIServiceEvo, RemoteHMIAction remoteHMIAction) {
        this.this$0 = remoteHMIServiceEvo;
        this.val$action = remoteHMIAction;
    }

    @Override
    public void remoteHmiDsiReady() {
        this.this$0.invokeAction(this.val$action);
    }
}

