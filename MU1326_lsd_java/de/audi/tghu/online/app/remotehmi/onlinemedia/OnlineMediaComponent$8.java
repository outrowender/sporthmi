/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent;

class OnlineMediaComponent$8
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ OnlineMediaComponent this$0;

    OnlineMediaComponent$8(OnlineMediaComponent onlineMediaComponent, String string, LogChannel logChannel) {
        this.this$0 = onlineMediaComponent;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$logChannel.log(1078071040, "OnlineMediaHandler#indicateCommand() ONLINEMEDIA [updateCoverUrl] received");
        if (object instanceof String[]) {
            String[] stringArray = (String[])object;
            OnlineMediaComponent.access$000(this.this$0, stringArray[0], stringArray[1]);
        } else {
            this.val$logChannel.log(10000, "OnlineMediaHandler#indicateCommand() wrong payload received. It should be of class String[], but it is of class %1. Payload=%2", (Object)object.getClass().getName(), object);
        }
    }
}

