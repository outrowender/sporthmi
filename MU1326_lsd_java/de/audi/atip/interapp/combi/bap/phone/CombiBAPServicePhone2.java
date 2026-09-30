/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPService;

public interface CombiBAPServicePhone2
extends CombiBAPService {
    public static final int MOBILE_SERVICE_SUPPORT_MOBILE_SERVICE_SUPPORT = 0;
    public static final int MOBILE_SERVICE_SUPPORT_REGISTER_STATE = 1;
    public static final int MOBILE_SERVICE_SUPPORT_LOCK_STATE = 2;
    public static final int MOBILE_SERVICE_SUPPORT_NETWORK_PROVIDER = 3;
    public static final int MOBILE_SERVICE_SUPPORT_SIGNAL_QUALITY = 4;
    public static final int MOBILE_SERVICE_SUPPORT_PHONE_MODULE_STATE = 5;
    public static final int MOBILE_SERVICE_SUPPORT_AUTOMATIC_CALL_FORWARDING = 6;
    public static final int MOBILE_SERVICE_SUPPORT_MAX = 7;
    public static final int DIVERT_STATE_FORWARDING_IF_BUSY = 1;
    public static final int DIVERT_STATE_FORWARDING_IF_NOT_ANSWERED = 2;
    public static final int DIVERT_STATE_FORWARDING_IF_OUT_OF_REACH = 4;
    public static final int DIVERT_STATE_FORWARDING_IF_NOT_AVAILABLE = 8;
    public static final int DIVERT_STATE_FORWARDING_ALL_VOICE_CALLS = 16;
    public static final int DIVERT_STATE_FORWARDING_ALL_FAX_CALLS = 32;
    public static final int DIVERT_STATE_FORWARDING_ALL_DATA_CALLS = 64;

    public void updateMobileServiceSupport(boolean[] var1);

    public void updateRegisterState(int var1, int var2, int var3);

    public void updateLockState(int var1);

    public void updateNetworkProvider(int var1, String var2, int var3, String var4);

    public void updateSignalQuality(int var1);

    public void updatePhoneModuleState(int var1, int var2, int var3, int var4);

    public void updateAutomaticCallForwarding(int var1);
}

