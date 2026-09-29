/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.eni;

import de.audi.atip.interapp.bap.eni.data.Service;

public interface ENIServiceOnline {
    default public void triggerUpdateUserList() {
    }

    default public boolean hasReceivedUserList() {
    }

    default public void triggerPairMainUserUsingVehiclePIN(String string, String string2) {
    }

    default public void triggerMainUserReset() {
    }

    default public void enableService(Service service) {
    }

    default public void disableService(Service service) {
    }

    default public void triggerPrivacyMode(boolean bl) {
    }

    default public void triggerSubmitChangesToBackend() {
    }

    default public void startVTANAuthData() {
    }

    default public void remoteProcessGetVtan(String string) {
    }

    default public void startVTANDecryption(String string) {
    }

    default public void enableMobileDeviceKey() {
    }

    default public void disableMobileDeviceKey() {
    }

    default public void requestMobileDeviceKeyCount() {
    }

    default public void setPrivacyModeFeatureAvailable(boolean bl) {
    }
}

