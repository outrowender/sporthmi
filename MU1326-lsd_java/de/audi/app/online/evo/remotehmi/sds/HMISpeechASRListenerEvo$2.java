/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.sds;

import de.audi.app.online.evo.remotehmi.sds.HMISpeechASRListenerEvo;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class HMISpeechASRListenerEvo$2
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$id;
    private final /* synthetic */ HMISpeechASRListenerEvo this$0;

    HMISpeechASRListenerEvo$2(HMISpeechASRListenerEvo hMISpeechASRListenerEvo, String string, int n) {
        this.this$0 = hMISpeechASRListenerEvo;
        this.val$id = n;
        super(string);
    }

    @Override
    public void run() {
        HMISpeechASRListenerEvo.access$200(this.this$0).log(1078071040, "HMISpeechASRListenerEvo#invokeAction: running selectedID ASR HELP");
        RemoteHMIAction remoteHMIAction = HMISpeechASRListenerEvo.access$300(this.this$0, 901);
        remoteHMIAction.getParameters().put("selectedId", Integer.toString(this.val$id));
        HMISpeechASRListenerEvo.access$400(this.this$0).invokeAction(remoteHMIAction);
    }
}

