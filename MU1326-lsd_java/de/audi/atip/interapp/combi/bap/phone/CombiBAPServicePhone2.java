/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPService;

public interface CombiBAPServicePhone2
extends CombiBAPService {
    public static final int MOBILE_SERVICE_SUPPORT_MOBILE_SERVICE_SUPPORT;
    public static final int MOBILE_SERVICE_SUPPORT_REGISTER_STATE;
    public static final int MOBILE_SERVICE_SUPPORT_LOCK_STATE;
    public static final int MOBILE_SERVICE_SUPPORT_NETWORK_PROVIDER;
    public static final int MOBILE_SERVICE_SUPPORT_SIGNAL_QUALITY;
    public static final int MOBILE_SERVICE_SUPPORT_PHONE_MODULE_STATE;
    public static final int MOBILE_SERVICE_SUPPORT_AUTOMATIC_CALL_FORWARDING;
    public static final int MOBILE_SERVICE_SUPPORT_MAX;
    public static final int DIVERT_STATE_FORWARDING_IF_BUSY;
    public static final int DIVERT_STATE_FORWARDING_IF_NOT_ANSWERED;
    public static final int DIVERT_STATE_FORWARDING_IF_OUT_OF_REACH;
    public static final int DIVERT_STATE_FORWARDING_IF_NOT_AVAILABLE;
    public static final int DIVERT_STATE_FORWARDING_ALL_VOICE_CALLS;
    public static final int DIVERT_STATE_FORWARDING_ALL_FAX_CALLS;
    public static final int DIVERT_STATE_FORWARDING_ALL_DATA_CALLS;

    default public void updateMobileServiceSupport(boolean[] blArray) {
    }

    default public void updateRegisterState(int n, int n2, int n3) {
    }

    default public void updateLockState(int n) {
    }

    default public void updateNetworkProvider(int n, String string, int n2, String string2) {
    }

    default public void updateSignalQuality(int n) {
    }

    default public void updatePhoneModuleState(int n, int n2, int n3, int n4) {
    }

    default public void updateAutomaticCallForwarding(int n) {
    }
}

