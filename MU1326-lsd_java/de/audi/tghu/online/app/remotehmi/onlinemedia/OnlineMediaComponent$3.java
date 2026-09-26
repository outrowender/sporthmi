/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent;

class OnlineMediaComponent$3
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ OnlineMediaComponent this$0;

    OnlineMediaComponent$3(OnlineMediaComponent onlineMediaComponent, String string, LogChannel logChannel) {
        this.this$0 = onlineMediaComponent;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$logChannel.log(1078071040, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [resume] received");
        this.this$0.resume();
    }
}

