/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IOnlineConnectivityStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import java.util.ArrayList;
import java.util.List;

public class RemoteHMIConnectivityChangedService
implements IOnlineConnectivityStateListener {
    private final LogChannel logger;
    private final RemoteHMIService remoteHmiService;
    private List listeners = new ArrayList(1);

    public RemoteHMIConnectivityChangedService(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logger = logChannel;
        this.remoteHmiService = remoteHMIService;
    }

    public void addListener(IOnlineConnectivityStateListener iOnlineConnectivityStateListener) {
        this.listeners.add(iOnlineConnectivityStateListener);
    }

    public void onlineStateChanged() {
        this.logger.log(10000000, "RemoteHMIConnectivityChangedService#onlineStateChanged: Called.");
        ChoiceModelApp choiceModelApp = this.remoteHmiService.getFrameworkAccess().getHMIService().getChoiceModel(2301000);
        choiceModelApp.setValue(~choiceModelApp.getValue());
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((IOnlineConnectivityStateListener)this.listeners.get(i2)).onlineStateChanged();
        }
    }

    public void updateErrorState(boolean bl, int n) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((IOnlineConnectivityStateListener)this.listeners.get(i2)).updateErrorState(bl, n);
        }
    }

    public void updateConnectionState(boolean bl) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((IOnlineConnectivityStateListener)this.listeners.get(i2)).updateConnectionState(bl);
        }
    }

    public void connectivityCheckEntryAction() {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((IOnlineConnectivityStateListener)this.listeners.get(i2)).connectivityCheckEntryAction();
        }
    }

    public void connectivityCheckExitAction(boolean bl) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((IOnlineConnectivityStateListener)this.listeners.get(i2)).connectivityCheckExitAction(bl);
        }
    }

    public void connectivityCheckExitAction(int n, boolean bl) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((IOnlineConnectivityStateListener)this.listeners.get(i2)).connectivityCheckExitAction(n, bl);
        }
    }
}

