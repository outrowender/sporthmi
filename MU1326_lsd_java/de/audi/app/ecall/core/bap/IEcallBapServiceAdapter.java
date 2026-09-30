/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap;

import de.audi.atip.interapp.bap.ecall.data.PhoneCall;

public interface IEcallBapServiceAdapter {
    public void terminateBreakdownService();

    public void endEmergencyCall(PhoneCall var1);

    public void endBreakdownCall(PhoneCall var1);

    public void acceptBreakdownCall();

    public void rejectBreakdownCall();

    public void acceptEmergencyServiceCall();

    public void dialEmergencyNumber(String var1);

    public void setAudioSource(int var1);

    public void sendMainUnitAudioSource(boolean var1);

    public void onCommunicationUp();

    public void startTestMode();
}

