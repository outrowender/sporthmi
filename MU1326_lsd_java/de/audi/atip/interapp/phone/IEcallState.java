/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;

public interface IEcallState {
    public static final int ATTR_SERVICE_STATE = 0;
    public static final int ATTR_CALL_STATE = 1;
    public static final int ATTR_SERVICE_REQUESTED = 2;
    public static final int ATTR_SOSNUMBERLIST_STATE = 3;

    public boolean hasActiveCall();

    public boolean isServiceActive();

    public int getServiceKind();

    public PhoneCall getCall();

    public boolean isEmergencyCallType();

    public boolean isLowPrioritySOSEmergencyCallType();

    public boolean isCustomerCallNotAllowed();

    public boolean isCustomerCallAllowed();

    public EmergencyNumber[] getAllowedEmergencyNumbers();

    public String getEmergencyNumberToBeDialed();
}

