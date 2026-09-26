/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap;

import de.audi.app.ecall.core.state.IGlobalEcallStateListener;

public interface IGlobalEcallState {
    public static final int ATTR_ECALL_CALLSTATE;
    public static final int ATTR_ECALL_CUSTOMERCALLSTATE;
    public static final int ATTR_ECALL_SERVICESTATE;
    public static final int ATTR_ECALL_SERVICEREQUEST;
    public static final int ATTR_ECALL_AUDIO_SOURCE_REQUESTED;
    public static final int ATTR_ECALL_ON_COMMUNICATION_UP;
    public static final int ATTR_ECALL_HANGUP_SERVICECALL_REQUESTED;
    public static final int ATTR_ECALL_HANGUP_CUSTOMSOSCALL_REQUESTED;
    public static final int ATTR_ECALL_DIAL_CUSTOMSOSCALL_REQUESTED;
    public static final int ATTR_ECALL_SOSNUMBERLIST;

    default public void init() {
    }

    default public void deinit() {
    }

    default public void removeListener(IGlobalEcallStateListener iGlobalEcallStateListener) {
    }

    default public void registerListener(IGlobalEcallStateListener iGlobalEcallStateListener) {
    }
}

