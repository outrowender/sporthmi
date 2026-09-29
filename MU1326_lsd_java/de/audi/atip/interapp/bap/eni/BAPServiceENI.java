/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni;

import de.audi.atip.interapp.bap.BAPService;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.Service;

public interface BAPServiceENI
extends BAPService {
    default public void getDestinationList() {
    }

    default public void setDestinationListCapacity(int n) {
    }

    default public void deleteDestination(Destination destination) {
    }

    default public void remoteProcessUpdateUserList() {
    }

    default public void remoteProcessDeleteUserList() {
    }

    default public void remoteProcessPairMainUserUsingPairingCode(String string, String string2) {
    }

    default public void remoteProcessPairMainUserUsingVehiclePin(String string, String string2) {
    }

    default public void remoteProcessConfirmExpirationWarningForService(Service service) {
    }

    default public void remoteProcessConfirmExpirationWarningForServices(Service[] serviceArray) {
    }

    default public void remoteProcessConfirmExpirationWarningForAllServices() {
    }

    default public void remoteProcessTerminate() {
    }

    default public void getUserList() {
    }

    default public void getServiceList() {
    }

    default public void enableService(Service service) {
    }

    default public void disableService(Service service) {
    }

    default public void getMonitorings() {
    }

    default public void enablePrivacyMode() {
    }

    default public void disablePrivacyMode() {
    }

    default public void remoteProcessPrivacyMode(boolean bl) {
    }

    default public void remoteProcessSubmitChangesToBackend() {
    }

    default public void remoteProcessGetMobileDeviceKeyCount() {
    }

    default public void remoteProcessGetVtan(String string) {
    }

    default public boolean getPrivacyModeSupported() {
    }
}

