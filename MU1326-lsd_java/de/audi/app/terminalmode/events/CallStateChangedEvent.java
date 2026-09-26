/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import org.dsi.ifc.carplay.CallState;

public class CallStateChangedEvent {
    private String phoneNumber;
    private String callerName;
    private int status;
    private int direction;
    private String uniqueCallID;

    public CallStateChangedEvent(String string, String string2, int n, int n2, String string3) {
        this.phoneNumber = string;
        this.callerName = string2;
        this.status = n;
        this.direction = n2;
        this.uniqueCallID = string3;
    }

    public CallStateChangedEvent(CallState callState) {
        this.phoneNumber = callState.phoneNumber;
        this.callerName = callState.callerName;
        this.status = callState.status;
        this.direction = callState.direction;
        this.uniqueCallID = callState.uniqueCallID;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getCallerName() {
        return this.callerName;
    }

    public int getStatus() {
        return this.status;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getUniqueCallID() {
        return this.uniqueCallID;
    }
}

