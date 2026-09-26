/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.esolutions.fw.util.commons.Buffer;

public class PhoneStateChangedEvent {
    public final int signalStrength;
    public final int registrationStatus;
    public final boolean airplaneMode;
    public final String mobileOperator;

    public PhoneStateChangedEvent(int n, int n2, boolean bl, String string) {
        this.signalStrength = n;
        this.registrationStatus = n2;
        this.airplaneMode = bl;
        this.mobileOperator = string;
    }

    public int getSignalStrength() {
        return this.signalStrength;
    }

    public int getRegistrationStatus() {
        return this.registrationStatus;
    }

    public boolean isAirplaneMode() {
        return this.airplaneMode;
    }

    public String getMobileOperator() {
        return this.mobileOperator;
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        buffer.append("PhoneStateChangedEvent [signalStrength=");
        buffer.append(this.signalStrength);
        buffer.append(", registrationStatus=");
        buffer.append(this.registrationStatus);
        buffer.append(", airplaneMode=");
        buffer.append(this.airplaneMode);
        buffer.append(", mobileOperator=");
        buffer.append(this.mobileOperator);
        buffer.append("]");
        return buffer.toString();
    }
}

