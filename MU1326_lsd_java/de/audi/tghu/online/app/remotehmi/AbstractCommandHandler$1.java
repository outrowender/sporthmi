/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class AbstractCommandHandler$1
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$status;
    private final /* synthetic */ Object val$payload;
    private final /* synthetic */ AbstractCommandHandler this$0;

    AbstractCommandHandler$1(AbstractCommandHandler abstractCommandHandler, String string, LogAppender logAppender, int n, Object object) {
        this.this$0 = abstractCommandHandler;
        this.val$status = n;
        this.val$payload = object;
        super(string, logAppender);
    }

    @Override
    public void run() {
        this.this$0.indicateCommand(this.val$status, this.val$payload);
    }
}

