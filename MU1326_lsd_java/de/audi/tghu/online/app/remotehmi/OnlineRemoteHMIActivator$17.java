/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.online.IRemoteHMIEsimLicenseListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$17
extends AbstractRemoteHMITask {
    private final /* synthetic */ IRemoteHMIEsimLicenseListener val$remoteHMIESimLicenseListener;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$17(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IRemoteHMIEsimLicenseListener iRemoteHMIEsimLicenseListener) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$remoteHMIESimLicenseListener = iRemoteHMIEsimLicenseListener;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setRemoteHMIESimLicenseListener(this.val$remoteHMIESimLicenseListener);
        this.val$remoteHMIESimLicenseListener.updateLicenseState(1);
    }
}

