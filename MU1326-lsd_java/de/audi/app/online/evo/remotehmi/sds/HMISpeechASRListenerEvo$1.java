/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.sds;

import de.audi.app.online.evo.remotehmi.sds.HMISpeechASRListenerEvo;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class HMISpeechASRListenerEvo$1
extends AbstractRemoteHMITask {
    private final /* synthetic */ HMISpeechASRListenerEvo this$0;

    HMISpeechASRListenerEvo$1(HMISpeechASRListenerEvo hMISpeechASRListenerEvo, String string) {
        this.this$0 = hMISpeechASRListenerEvo;
        super(string);
    }

    @Override
    public void run() {
        RemoteHMIAction remoteHMIAction = HMISpeechASRListenerEvo.access$000(this.this$0, 901);
        remoteHMIAction.getParameters().put("selectedId", "-1");
        HMISpeechASRListenerEvo.access$100(this.this$0).invokeAction(remoteHMIAction);
    }
}

