/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.state;

import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.phone.ITelState;

public interface IEcallStateStruct {
    public int getBapAudioSource();

    public PendingServiceRequests getPendingServiceCalls();

    public int getServiceCallKind();

    public int getServiceState();

    public PhoneCall[] getPhoneCalls();

    public PhoneCall getCurrentPhoneCall();

    public PhoneCall getCurrentPhoneCallByKind(int var1);

    public PhoneCall getCurrentHighPriorityPhoneCall();

    public ITelState getCustomerTelState();

    public String getEmergencyNumberToBeDialed();

    public EmergencyNumber[] getAllowedEmergencyNumbersList();

    public boolean isUSMRequestPresent();

    public boolean getCustomerCallActive();

    public boolean isActiveCustomerCallPresent();

    public boolean isCallActive();

    public boolean isCallActive(int var1);

    public boolean isServiceActive();

    public boolean isEmergencyConnecting();

    public boolean isEmergencyConnected();

    public boolean isEmergencyCallBackIncoming();

    public boolean isServiceIDLE();
}

