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

    @Override
    public boolean hasActiveCall() {
        return this.hasActiveCall;
    }

    @Override
    public boolean isServiceActive() {
        return this.isServiceActive;
    }

    @Override
    public PhoneCall getCall() {
        return this.phoneCall;
    }

    @Override
    public int getServiceKind() {
        return this.serviceKind;
    }

    @Override
    public boolean isEmergencyCallType() {
        return this.isEmergencyCallType;
    }

    @Override
    public boolean isCustomerCallNotAllowed() {
        return false;
    }

    public String toString() {
        return new Buffer().append("NullEcallState [isServiceActive=").append(this.isServiceActive).append(", hasActiveCall=").append(this.hasActiveCall).append(", serviceKind=").append(this.serviceKind).append("]").toString();
    }

    @Override
    public boolean isCustomerCallAllowed() {
        return !this.isCustomerCallNotAllowed();
    }

    @Override
    public boolean isLowPrioritySOSEmergencyCallType() {
        return this.phoneCall != null && this.phoneCall.isLowPrioritySOSCall();
    }

    @Override
    public EmergencyNumber[] getAllowedEmergencyNumbers() {
        return this.emergencyNumbers;
    }

    @Override
    public String getEmergencyNumberToBeDialed() {
        return null;
    }
}

