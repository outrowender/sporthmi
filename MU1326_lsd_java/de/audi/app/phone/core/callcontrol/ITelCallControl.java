/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callcontrol;

public interface ITelCallControl {
    public void acceptIncomingCall(int var1);

    public void rejectIncomingCall(int var1);

    public void swapCalls(int var1);

    public void joinCallsToConference(int var1);

    public void hangupCall(int var1);

    public void hangupCall(int var1, int var2);

    public void replaceActiveCallWithIncomingCall(int var1);

    public void acceptOnNCLDOngoing(boolean var1);
}

