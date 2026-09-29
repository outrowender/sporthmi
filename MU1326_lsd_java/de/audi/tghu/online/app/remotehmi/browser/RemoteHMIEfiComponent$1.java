/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.browser;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIEfiComponent;

class RemoteHMIEfiComponent$1
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ RemoteHMIEfiComponent this$0;

    RemoteHMIEfiComponent$1(RemoteHMIEfiComponent remoteHMIEfiComponent, String string, LogChannel logChannel) {
        this.this$0 = remoteHMIEfiComponent;
        this.val$logChannel = logChannel;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        if (!(object instanceof String)) {
            this.val$logChannel.log(10000, "RemoteHMIEfiComponent#indicateCommand: invalid bayload. String expected");
            return;
        }
        this.this$0.updateEfiLink((String)object);
    }
}

