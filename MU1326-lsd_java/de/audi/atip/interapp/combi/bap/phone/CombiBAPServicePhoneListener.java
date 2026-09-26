/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry;

public interface CombiBAPServicePhoneListener
extends CombiBAPServiceListener {
    default public void dialNumber(String string, String string2) {
    }

    default public void dialNumberFromAdbEntry(String string, String string2, CombiBAPCallStackEntry combiBAPCallStackEntry) {
    }

    default public void dialService(int n) {
    }

    default public void confirmEmergencyCall(boolean bl) {
    }

    default public void hangupCall(int n) {
    }

    default public void acceptCall() {
    }

    default public void callHold() {
    }

    default public void resumeCall() {
    }

    default public void setMicMuteState(boolean bl) {
    }

    default public void releaseActiveCallAcceptWaitingCall() {
    }

    default public void swapCalls() {
    }

    default public void callHoldAcceptWaitingCall() {
    }

    default public void releaseAllCallsAcceptWaitingCall() {
    }

    default public void setWaitingCallOnHold() {
    }

    default public void joinCalls() {
    }

    default public void splitCall(int n) {
    }

    default public void setRingToneMuteState(boolean bl) {
    }

    default public void setAutomaticRedialActive(boolean bl) {
    }

    default public void resetMissedCallsIndicator() {
    }
}

