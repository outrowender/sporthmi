/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;

class ContextManagerComponent$1
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ ContextManagerComponent this$0;

    ContextManagerComponent$1(ContextManagerComponent contextManagerComponent, String string, LogChannel logChannel) {
        this.this$0 = contextManagerComponent;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    protected LogAppender getParamsForDebugging(Object object) {
        return LogAppender$Factory.fromString((String)object);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        if (!(object instanceof String)) {
            this.val$logChannel.log(10000, "ContextManagerComponent#indicateCommand: wrong payload provided");
            return;
        }
        this.this$0.setAudiConnectContextToBeStarted((String)object);
    }
}

