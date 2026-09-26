/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$6
extends AbstractRemoteHMITask {
    private final /* synthetic */ TTSSessionBasedService val$ttsSessionBasedService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$6(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, TTSSessionBasedService tTSSessionBasedService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$ttsSessionBasedService = tTSSessionBasedService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setTTSService(this.val$ttsSessionBasedService);
    }
}

