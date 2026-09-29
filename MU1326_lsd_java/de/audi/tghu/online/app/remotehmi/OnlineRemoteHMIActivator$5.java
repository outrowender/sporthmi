/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.browser.IBrowserHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$5
extends AbstractRemoteHMITask {
    private final /* synthetic */ IBrowserHandler val$browserHandler;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$5(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IBrowserHandler iBrowserHandler) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$browserHandler = iBrowserHandler;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).getBrowserController().setBrowserFullscreenHandler(this.val$browserHandler);
    }
}

