/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;

public interface IEcallState {
    public static final int ATTR_SERVICE_STATE;
    public static final int ATTR_CALL_STATE;
    public static final int ATTR_SERVICE_REQUESTED;
    public static final int ATTR_SOSNUMBERLIST_STATE;

    default public boolean hasActiveCall() {
    }

    default public boolean isServiceActive() {
    }

    default public int getServiceKind() {
    }

    default public PhoneCall getCall() {
    }

    default public boolean isEmergencyCallType() {
    }

    default public boolean isLowPrioritySOSEmergencyCallType() {
    }

    default public boolean isCustomerCallNotAllowed() {
    }

    default public boolean isCustomerCallAllowed() {
    }

    default public EmergencyNumber[] getAllowedEmergencyNumbers() {
    }

    default public String getEmergencyNumberToBeDialed() {
    }
}

