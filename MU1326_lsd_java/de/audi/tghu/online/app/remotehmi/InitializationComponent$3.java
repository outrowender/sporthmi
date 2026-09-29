/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.InitializationComponent;

class InitializationComponent$3
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ InitializationComponent this$0;

    InitializationComponent$3(InitializationComponent initializationComponent, String string, LogChannel logChannel) {
        this.this$0 = initializationComponent;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$logChannel.log(1078071040, "InitializationComponent#indicateCommand: state CommandsCore.INITIALIZATION_FINISHED");
        this.this$0.setInitialized(true);
    }
}

