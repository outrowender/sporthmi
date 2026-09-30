/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap;

import de.audi.app.ecall.core.state.IGlobalEcallStateListener;

public interface IGlobalEcallState {
    public static final int ATTR_ECALL_CALLSTATE = 1;
    public static final int ATTR_ECALL_CUSTOMERCALLSTATE = 2;
    public static final int ATTR_ECALL_SERVICESTATE = 3;
    public static final int ATTR_ECALL_SERVICEREQUEST = 4;
    public static final int ATTR_ECALL_AUDIO_SOURCE_REQUESTED = 5;
    public static final int ATTR_ECALL_ON_COMMUNICATION_UP = 6;
    public static final int ATTR_ECALL_HANGUP_SERVICECALL_REQUESTED = 7;
    public static final int ATTR_ECALL_HANGUP_CUSTOMSOSCALL_REQUESTED = 8;
    public static final int ATTR_ECALL_DIAL_CUSTOMSOSCALL_REQUESTED = 9;
    public static final int ATTR_ECALL_SOSNUMBERLIST = 10;

    public void init();

    public void deinit();

    public void removeListener(IGlobalEcallStateListener var1);

    public void registerListener(IGlobalEcallStateListener var1);
}

