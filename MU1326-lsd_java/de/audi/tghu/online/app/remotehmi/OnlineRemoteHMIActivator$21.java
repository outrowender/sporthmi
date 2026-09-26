/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.MapService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$21
extends AbstractRemoteHMITask {
    private final /* synthetic */ MapService val$mapService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$21(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, MapService mapService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$mapService = mapService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).getNaviComponent().setMapService(this.val$mapService);
    }
}

