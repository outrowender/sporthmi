/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callcontrol;

public interface ITelCallControl {
    default public void acceptIncomingCall(int n) {
    }

    default public void rejectIncomingCall(int n) {
    }

    default public void swapCalls(int n) {
    }

    default public void joinCallsToConference(int n) {
    }

    default public void hangupCall(int n) {
    }

    default public void hangupCall(int n, int n2) {
    }

    default public void replaceActiveCallWithIncomingCall(int n) {
    }

    default public void acceptOnNCLDOngoing(boolean bl) {
    }
}

