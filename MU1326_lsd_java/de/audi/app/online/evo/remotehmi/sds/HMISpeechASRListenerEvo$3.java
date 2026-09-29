/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.sds;

import de.audi.app.online.evo.remotehmi.sds.HMISpeechASRListenerEvo;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class HMISpeechASRListenerEvo$3
extends AbstractRemoteHMITask {
    private final /* synthetic */ String val$idString;
    private final /* synthetic */ HMISpeechASRListenerEvo this$0;

    HMISpeechASRListenerEvo$3(HMISpeechASRListenerEvo hMISpeechASRListenerEvo, String string, String string2) {
        this.this$0 = hMISpeechASRListenerEvo;
        this.val$idString = string2;
        super(string);
    }

    @Override
    public void run() {
        RemoteHMIAction remoteHMIAction = HMISpeechASRListenerEvo.access$500(this.this$0, 900);
        remoteHMIAction.getParameters().put("selectedId", this.val$idString);
        remoteHMIAction.getParameters().put("actionId", this.val$idString);
        HMISpeechASRListenerEvo.access$600(this.this$0).invokeAction(remoteHMIAction);
    }
}

