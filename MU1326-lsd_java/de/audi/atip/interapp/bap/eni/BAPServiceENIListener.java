/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni;

import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.MobileKeyCount;
import de.audi.atip.interapp.bap.eni.data.Monitorings;
import de.audi.atip.interapp.bap.eni.data.PrivacySetup;
import de.audi.atip.interapp.bap.eni.data.RemoteProcessState;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.SupportedRemoteProcesses;
import de.audi.atip.interapp.bap.eni.data.User;

public interface BAPServiceENIListener
extends BAPServiceListener {
    default public void onCommunicationUp() {
    }

    default public void onDestinationList(Destination[] destinationArray) {
    }

    default public void onRemoteProcessFinished(boolean bl) {
    }

    default public void onSupportedRemoteProcesses(SupportedRemoteProcesses supportedRemoteProcesses) {
    }

    default public void onRemoteProcessState(RemoteProcessState remoteProcessState) {
    }

    default public void onUserList(User[] userArray) {
    }

    default public void onServiceList(Service[] serviceArray) {
    }

    default public void onMonitorings(Monitorings monitorings) {
    }

    default public void onPrivacySetup(PrivacySetup privacySetup) {
    }

    default public void onMobileDeviceKeyCount(MobileKeyCount mobileKeyCount) {
    }

    default public void onVtanDataEncrypted(String string) {
    }

    default public void onFleetModeAvailability(boolean bl) {
    }

    default public void onPrivacyModeSupported(boolean bl) {
    }
}

