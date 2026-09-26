/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.remotehmi.IRemoteHMISpeechContext$CommandDisplay;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechASRListener;

class RemoteHMIServiceEvo$6
extends AbstractRemoteHMITask {
    private final /* synthetic */ IRemoteHMISpeechContext$CommandDisplay val$pttCommandDisplay;
    private final /* synthetic */ RemoteHMIServiceEvo this$0;

    RemoteHMIServiceEvo$6(RemoteHMIServiceEvo remoteHMIServiceEvo, String string, IRemoteHMISpeechContext$CommandDisplay iRemoteHMISpeechContext$CommandDisplay) {
        this.this$0 = remoteHMIServiceEvo;
        this.val$pttCommandDisplay = iRemoteHMISpeechContext$CommandDisplay;
        super(string);
    }

    @Override
    public void run() {
        HMISpeechASRListener hMISpeechASRListener = this.this$0.getASR();
        if (hMISpeechASRListener != null) {
            RemoteHMIServiceEvo.access$500(this.this$0).log(-2137614336, "RemoteHMIServiceEvo#indicateContextsCommandDisplay: Called.");
            hMISpeechASRListener.indicateApplicationCommands(this.val$pttCommandDisplay);
        }
    }
}

