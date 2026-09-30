/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.IInterappEvent;

public interface IInterappPhoneEvent
extends IInterappEvent {
    public static final int EVENT_PHONE_ACTIVE = 0;
    public static final int EVENT_PHONE_IDLE = 1;
    public static final int EVENT_SIM_UNLOCK_ACTIVE = 2;
    public static final int EVENT_SIM_UNLOCK_IDLE = 3;
    public static final int EVENT_RESPONSE_SET_NAD_MODE = 4;
    public static final int EVENT_UPDATE_NAD_MODE = 5;
    public static final int EVENT_KEYPAD_VISIBLE = 6;
    public static final int EVENT_SIM_UNLOCK_HIDDEN = 7;
    public static final int EVENT_SIM_CHANGE_PIN = 8;
    public static final int EVENT_SIM_TOGGLE_PIN = 9;
    public static final int EVENT_REQUEST_DISCONNECT_SAP = 10;
    public static final int EVENT_REQUEST_TOGGLE_SAP_2_HFP = 11;
}

