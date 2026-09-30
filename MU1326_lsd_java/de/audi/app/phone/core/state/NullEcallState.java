/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.phone.IEcallState;
import de.esolutions.fw.util.commons.Buffer;

public class NullEcallState
implements IEcallState {
    private final boolean hasActiveCall;
    private final boolean isServiceActive;
    private final boolean isEmergencyCallType;
    private final int serviceKind;
    private final PhoneCall phoneCall;
    EmergencyNumber[] emergencyNumbers;

    public NullEcallState() {
        this(false, false);
    }

    public NullEcallState(boolean bl, boolean bl2) {
        this(bl, bl2, -1);
    }

    public NullEcallState(boolean bl, boolean bl2, int n) {
        this(bl, bl2, n, null);
    }

    public NullEcallState(boolean bl, boolean bl2, int n, EmergencyNumber[] emergencyNumberArray) {
        this(bl, bl2, false, n, PhoneCall.getNullInstance(), emergencyNumberArray);
    }

    public NullEcallState(boolean bl, boolean bl2, boolean bl3, int n, PhoneCall phoneCall, EmergencyNumber[] emergencyNumberArray) {
        this.hasActiveCall = bl;
        this.isServiceActive = bl2;
        this.isEmergencyCallType = bl3;
        this.serviceKind = n;
        this.phoneCall = phoneCall;
        this.emergencyNumbers = emergencyNumberArray;
    }

    public boolean hasActiveCall() {
        return this.hasActiveCall;
    }

    public boolean isServiceActive() {
        return this.isServiceActive;
    }

    public PhoneCall getCall() {
        return this.phoneCall;
    }

    public int getServiceKind() {
        return this.serviceKind;
    }

    public boolean isEmergencyCallType() {
        return this.isEmergencyCallType;
    }

    public boolean isCustomerCallNotAllowed() {
        return false;
    }

    public String toString() {
        return new Buffer().append("NullEcallState [isServiceActive=").append(this.isServiceActive).append(", hasActiveCall=").append(this.hasActiveCall).append(", serviceKind=").append(this.serviceKind).append("]").toString();
    }

    public boolean isCustomerCallAllowed() {
        return !this.isCustomerCallNotAllowed();
    }

    public boolean isLowPrioritySOSEmergencyCallType() {
        return this.phoneCall != null && this.phoneCall.isLowPrioritySOSCall();
    }

    public EmergencyNumber[] getAllowedEmergencyNumbers() {
        return this.emergencyNumbers;
    }

    public String getEmergencyNumberToBeDialed() {
        return null;
    }
}

