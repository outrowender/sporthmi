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

    @Override
    public void terminateBreakdownService() {
        this.log.log(-2137614336, "EcallBapServiceAdapter#terminateBreakdownService(): called");
        this.bapServiceEcall.terminateServiceRequest(1);
    }

    @Override
    public void endEmergencyCall(PhoneCall phoneCall) {
        this.log.log(-2137614336, "EcallBapServiceAdapter#endEmergencyCall(): called phoneCall=%1", (Object)phoneCall);
        this.bapServiceEcall.hangupCall(phoneCall);
    }

    @Override
    public void endBreakdownCall(PhoneCall phoneCall) {
        this.log.log(-2137614336, "EcallBapServiceAdapter#endBreakdownCall(): called phoneCall=%1", (Object)phoneCall);
        this.bapServiceEcall.hangupCall(phoneCall);
    }

    @Override
    public void acceptBreakdownCall() {
        this.log.log(-2137614336, "EcallBapServiceAdapter#acceptBreakdownCall(): called");
        this.bapServiceEcall.acceptServiceRequest(1);
    }

    @Override
    public void acceptEmergencyServiceCall() {
        this.log.log(-2137614336, "EcallBapServiceAdapter#acceptEmergencyServiceCall(): called");
        this.bapServiceEcall.acceptServiceRequest(5);
    }

    @Override
    public void dialEmergencyNumber(String string) {
        this.log.log(-2137614336, "EcallBapServiceAdapter#dialEmergencyNumber(): number=%1", (Object)string);
        this.bapServiceEcall.dialNumber(string);
    }

    @Override
    public void setAudioSource(int n) {
        this.log.log(-2137614336, "EcallBapServiceAdapter#setAudioSource(): audioSource=%1", (long)n);
        this.bapServiceEcall.setAudioSource(n);
    }

    @Override
    public void rejectBreakdownCall() {
        this.log.log(-2137614336, "EcallBapServiceAdapter#rejectBreakdownCall(): called");
        this.bapServiceEcall.rejectAllServiceRequests();
    }

    @Override
    public void sendMainUnitAudioSource(boolean bl) {
        this.log.log(-2137614336, "EcallBapServiceAdapter#sendMainUnitAudioSource(): isCustomerCallActive %1", bl);
        if (bl) {
            this.setMainUnitPhoneAudioSource();
        } else {
            this.setMainUnitAudioSource();
        }
    }

    @Override
    public void onCommunicationUp() {
        this.log.log(-2137614336, "EcallBapServiceAdapter#onCommunicationUp(): called");
        this.bapServiceEcall.getServiceRequest();
        this.bapServiceEcall.getServiceState();
        this.bapServiceEcall.getCallState();
    }

    @Override
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

