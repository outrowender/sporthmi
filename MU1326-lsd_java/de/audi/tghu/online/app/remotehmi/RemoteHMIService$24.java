/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.PortalAuthenticationService$UpdateProfileInfoListener;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import org.dsi.ifc.online.OSRDevice;

class RemoteHMIService$24
implements PortalAuthenticationService$UpdateProfileInfoListener {
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$24(RemoteHMIService remoteHMIService) {
        this.this$0 = remoteHMIService;
    }

    @Override
    public void updateProfileInfo(Object object) {
        this.this$0.forwardProfileInfoChanged(object);
    }

    @Override
    public void updateDeviceInfo(OSRDevice[] oSRDeviceArray) {
    }
}

