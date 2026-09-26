/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;

public interface ITelCallSession {
    public static final int CALLTYPE_NORMAL;
    public static final int CALLTYPE_OPERATOR;
    public static final int CALLTYPE_P_CALL;
    public static final int CALLTYPE_C_CALL;
    public static final int CALLTYPE_B_CALL;
    public static final int MIC_MUTE_ON;
    public static final int MIC_MUTE_OFF;

    default public int getCallType() {
    }

    default public String getTelephoneNumber() {
    }

    default public void onActive(ITelCallControl iTelCallControl) {
    }

    default public void onClose() {
    }

    default public void updateCallInformation(ITelCallInformation iTelCallInformation, int n) {
    }
}

