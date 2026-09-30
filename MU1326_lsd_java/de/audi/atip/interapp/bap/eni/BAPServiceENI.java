/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni;

import de.audi.atip.interapp.bap.BAPService;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.Service;

public interface BAPServiceENI
extends BAPService {
    public void getDestinationList();

    public void setDestinationListCapacity(int var1);

    public void deleteDestination(Destination var1);

    public void remoteProcessUpdateUserList();

    public void remoteProcessDeleteUserList();

    public void remoteProcessPairMainUserUsingPairingCode(String var1, String var2);

    public void remoteProcessPairMainUserUsingVehiclePin(String var1, String var2);

    public void remoteProcessConfirmExpirationWarningForService(Service var1);

    public void remoteProcessConfirmExpirationWarningForServices(Service[] var1);

    public void remoteProcessConfirmExpirationWarningForAllServices();

    public void remoteProcessTerminate();

    public void getUserList();

    public void getServiceList();

    public void enableService(Service var1);

    public void disableService(Service var1);

    public void getMonitorings();

    public void enablePrivacyMode();

    public void disablePrivacyMode();

    public void remoteProcessPrivacyMode(boolean var1);

    public void remoteProcessSubmitChangesToBackend();

    public void remoteProcessGetMobileDeviceKeyCount();

    public void remoteProcessGetVtan(String var1);

    public boolean getPrivacyModeSupported();
}

