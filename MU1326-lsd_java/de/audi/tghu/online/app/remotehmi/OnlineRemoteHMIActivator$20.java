/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$20
extends AbstractRemoteHMITask {
    private final /* synthetic */ IPreviewMap val$iPreviewMap;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$20(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IPreviewMap iPreviewMap) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$iPreviewMap = iPreviewMap;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).getNaviComponent().setPreviewMap(this.val$iPreviewMap);
    }
}

