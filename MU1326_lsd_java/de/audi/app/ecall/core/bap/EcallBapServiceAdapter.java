/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap;

import de.audi.app.ecall.core.bap.IEcallBapServiceAdapter;
import de.audi.atip.interapp.bap.ecall.BAPServiceEcall;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.log.LogChannel;

public class EcallBapServiceAdapter
implements IEcallBapServiceAdapter {
    private final LogChannel log;
    private final BAPServiceEcall bapServiceEcall;

    public EcallBapServiceAdapter(BAPServiceEcall bAPServiceEcall, LogChannel logChannel) {
        this.bapServiceEcall = bAPServiceEcall;
        this.log = logChannel;
    }

    public void terminateBreakdownService() {
        this.log.log(10000000, "EcallBapServiceAdapter#terminateBreakdownService(): called");
        this.bapServiceEcall.terminateServiceRequest(1);
    }

    public void endEmergencyCall(PhoneCall phoneCall) {
        this.log.log(10000000, "EcallBapServiceAdapter#endEmergencyCall(): called phoneCall=%1", (Object)phoneCall);
        this.bapServiceEcall.hangupCall(phoneCall);
    }

    public void endBreakdownCall(PhoneCall phoneCall) {
        this.log.log(10000000, "EcallBapServiceAdapter#endBreakdownCall(): called phoneCall=%1", (Object)phoneCall);
        this.bapServiceEcall.hangupCall(phoneCall);
    }

    public void acceptBreakdownCall() {
        this.log.log(10000000, "EcallBapServiceAdapter#acceptBreakdownCall(): called");
        this.bapServiceEcall.acceptServiceRequest(1);
    }

    public void acceptEmergencyServiceCall() {
        this.log.log(10000000, "EcallBapServiceAdapter#acceptEmergencyServiceCall(): called");
        this.bapServiceEcall.acceptServiceRequest(5);
    }

    public void dialEmergencyNumber(String string) {
        this.log.log(10000000, "EcallBapServiceAdapter#dialEmergencyNumber(): number=%1", (Object)string);
        this.bapServiceEcall.dialNumber(string);
    }

    public void setAudioSource(int n) {
        this.log.log(10000000, "EcallBapServiceAdapter#setAudioSource(): audioSource=%1", (long)n);
        this.bapServiceEcall.setAudioSource(n);
    }

    public void rejectBreakdownCall() {
        this.log.log(10000000, "EcallBapServiceAdapter#rejectBreakdownCall(): called");
        this.bapServiceEcall.rejectAllServiceRequests();
    }

    public void sendMainUnitAudioSource(boolean bl) {
        this.log.log(10000000, "EcallBapServiceAdapter#sendMainUnitAudioSource(): isCustomerCallActive %1", bl);
        if (bl) {
            this.setMainUnitPhoneAudioSource();
        } else {
            this.setMainUnitAudioSource();
        }
    }

    public void onCommunicationUp() {
        this.log.log(10000000, "EcallBapServiceAdapter#onCommunicationUp(): called");
        this.bapServiceEcall.getServiceRequest();
        this.bapServiceEcall.getServiceState();
        this.bapServiceEcall.getCallState();
    }

    public void startTestMode() {
        this.bapServiceEcall.startTestMode();
    }

    private void setMainUnitAudioSource() {
        this.bapServiceEcall.setAudioSource(5);
    }

    private void setMainUnitPhoneAudioSource() {
        this.bapServiceEcall.setAudioSource(6);
    }
}

