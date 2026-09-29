/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class RemoteHMIServiceEvo$5
extends AbstractRemoteHMITask {
    private final /* synthetic */ RemoteHMIServiceEvo this$0;

    RemoteHMIServiceEvo$5(RemoteHMIServiceEvo remoteHMIServiceEvo, String string, LogAppender logAppender) {
        this.this$0 = remoteHMIServiceEvo;
        super(string, logAppender);
    }

    @Override
    public void run() {
        RemoteHMIServiceEvo.access$400(this.this$0).refresh();
    }
}

