/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.browser;

import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIBrowserComponent;

class RemoteHMIBrowserComponent$1
extends AbstractCommandHandler {
    private final /* synthetic */ RemoteHMIBrowserComponent this$0;

    RemoteHMIBrowserComponent$1(RemoteHMIBrowserComponent remoteHMIBrowserComponent, String string) {
        this.this$0 = remoteHMIBrowserComponent;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        String string = object.toString();
        this.this$0.sendMessageToBrowser(string);
    }
}

