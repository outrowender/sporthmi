/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.PortalAuthenticationService;
import de.audi.atip.interapp.PortalAuthenticationServiceCallbackListener;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IRemoteHMIAuthenticationProvider;
import de.audi.remotehmi.IRemoteHMIAuthenticationProviderListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoteHMIAuthenticationService
implements PortalAuthenticationServiceCallbackListener,
IRemoteHMIAuthenticationProvider {
    private final LogChannel logChannel;
    private PortalAuthenticationService portalAuthenticationService;
    private List listeners = new ArrayList(1);

    public RemoteHMIAuthenticationService(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void setPortalAuthenticationService(PortalAuthenticationService portalAuthenticationService) {
        this.portalAuthenticationService = portalAuthenticationService;
    }

    public PortalAuthenticationService getPortalAuthenticationService() {
        return this.portalAuthenticationService;
    }

    public void deletePairingCode() {
    }

    public void validatePairingCodeResult(boolean bl, int n, int n2) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            IRemoteHMIAuthenticationProviderListener iRemoteHMIAuthenticationProviderListener = (IRemoteHMIAuthenticationProviderListener)iterator.next();
            iRemoteHMIAuthenticationProviderListener.setPairingCodeResult(bl);
        }
    }

    public void addListener(IRemoteHMIAuthenticationProviderListener iRemoteHMIAuthenticationProviderListener) {
        this.listeners.add(iRemoteHMIAuthenticationProviderListener);
    }

    public void removeListener(IRemoteHMIAuthenticationProviderListener iRemoteHMIAuthenticationProviderListener) {
        this.listeners.remove(iRemoteHMIAuthenticationProviderListener);
    }

    public void validateCredentialsResult(boolean bl, int n, int n2) {
    }

    public void loginResult(int n) {
    }
}

