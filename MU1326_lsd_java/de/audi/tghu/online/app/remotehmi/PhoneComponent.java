/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.IConnectivityOnlineStateListener;
import de.audi.atip.interapp.messaging.IMessagingOnlineService;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;

public class PhoneComponent
extends AbstractRemoteHMIComponent {
    private ITelService telService;
    private IMessagingOnlineService onlineMessagingService;
    private IConnectivityOnlineStateListener connectivityOnlineStateListener;

    public ITelService getTelService() {
        return this.telService;
    }

    public void setTelService(ITelService iTelService) {
        this.telService = iTelService;
    }

    public void setOnlineMessagingService(IMessagingOnlineService iMessagingOnlineService) {
        this.onlineMessagingService = iMessagingOnlineService;
    }

    public IMessagingOnlineService getOnlineMessagingService() {
        return this.onlineMessagingService;
    }

    public IConnectivityOnlineStateListener getConnectivityOnlineStateListener() {
        return this.connectivityOnlineStateListener;
    }

    public void setConnectivityOnlineStateListener(IConnectivityOnlineStateListener iConnectivityOnlineStateListener) {
        this.connectivityOnlineStateListener = iConnectivityOnlineStateListener;
    }
}

