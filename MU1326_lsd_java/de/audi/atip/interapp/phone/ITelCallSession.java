/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;

public interface ITelCallSession {
    public static final int CALLTYPE_NORMAL = 0;
    public static final int CALLTYPE_OPERATOR = 1;
    public static final int CALLTYPE_P_CALL = 65536;
    public static final int CALLTYPE_C_CALL = 131072;
    public static final int CALLTYPE_B_CALL = 196608;
    public static final int MIC_MUTE_ON = 0;
    public static final int MIC_MUTE_OFF = 1;

    public int getCallType();

    public String getTelephoneNumber();

    public void onActive(ITelCallControl var1);

    public void onClose();

    public void updateCallInformation(ITelCallInformation var1, int var2);
}

