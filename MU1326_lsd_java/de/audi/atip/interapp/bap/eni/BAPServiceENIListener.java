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
    public void onCommunicationUp();

    public void onDestinationList(Destination[] var1);

    public void onRemoteProcessFinished(boolean var1);

    public void onSupportedRemoteProcesses(SupportedRemoteProcesses var1);

    public void onRemoteProcessState(RemoteProcessState var1);

    public void onUserList(User[] var1);

    public void onServiceList(Service[] var1);

    public void onMonitorings(Monitorings var1);

    public void onPrivacySetup(PrivacySetup var1);

    public void onMobileDeviceKeyCount(MobileKeyCount var1);

    public void onVtanDataEncrypted(String var1);

    public void onFleetModeAvailability(boolean var1);

    public void onPrivacyModeSupported(boolean var1);
}

