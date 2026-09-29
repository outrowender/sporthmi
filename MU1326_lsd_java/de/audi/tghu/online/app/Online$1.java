/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class Online$1
extends AbstractRemoteHMITask {
    private final /* synthetic */ Online this$0;

    Online$1(Online online, String string, LogAppender logAppender) {
        this.this$0 = online;
        super(string, logAppender);
    }

    @Override
    public void run() {
        Online.access$000(this.this$0).unlockModelGroup();
    }
}

