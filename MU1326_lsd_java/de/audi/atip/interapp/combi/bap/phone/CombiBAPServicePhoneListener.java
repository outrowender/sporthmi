/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry;

public interface CombiBAPServicePhoneListener
extends CombiBAPServiceListener {
    public void dialNumber(String var1, String var2);

    public void dialNumberFromAdbEntry(String var1, String var2, CombiBAPCallStackEntry var3);

    public void dialService(int var1);

    public void confirmEmergencyCall(boolean var1);

    public void hangupCall(int var1);

    public void acceptCall();

    public void callHold();

    public void resumeCall();

    public void setMicMuteState(boolean var1);

    public void releaseActiveCallAcceptWaitingCall();

    public void swapCalls();

    public void callHoldAcceptWaitingCall();

    public void releaseAllCallsAcceptWaitingCall();

    public void setWaitingCallOnHold();

    public void joinCalls();

    public void splitCall(int var1);

    public void setRingToneMuteState(boolean var1);

    public void setAutomaticRedialActive(boolean var1);

    public void resetMissedCallsIndicator();
}

