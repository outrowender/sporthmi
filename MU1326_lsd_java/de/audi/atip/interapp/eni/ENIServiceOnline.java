/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.eni;

import de.audi.atip.interapp.bap.eni.data.Service;

public interface ENIServiceOnline {
    public void triggerUpdateUserList();

    public boolean hasReceivedUserList();

    public void triggerPairMainUserUsingVehiclePIN(String var1, String var2);

    public void triggerMainUserReset();

    public void enableService(Service var1);

    public void disableService(Service var1);

    public void triggerPrivacyMode(boolean var1);

    public void triggerSubmitChangesToBackend();

    public void startVTANAuthData();

    public void remoteProcessGetVtan(String var1);

    public void startVTANDecryption(String var1);

    public void enableMobileDeviceKey();

    public void disableMobileDeviceKey();

    public void requestMobileDeviceKeyCount();

    public void setPrivacyModeFeatureAvailable(boolean var1);
}

