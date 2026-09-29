/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.INaviFormattingService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$11
extends AbstractRemoteHMITask {
    private final /* synthetic */ INaviFormattingService val$naviService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$11(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, INaviFormattingService iNaviFormattingService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$naviService = iNaviFormattingService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).getNaviComponent().setNaviFormattingService(this.val$naviService);
    }
}

