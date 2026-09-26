/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.IInterappEvent;

public interface IInterappPhoneEvent
extends IInterappEvent {
    public static final int EVENT_PHONE_ACTIVE;
    public static final int EVENT_PHONE_IDLE;
    public static final int EVENT_SIM_UNLOCK_ACTIVE;
    public static final int EVENT_SIM_UNLOCK_IDLE;
    public static final int EVENT_RESPONSE_SET_NAD_MODE;
    public static final int EVENT_UPDATE_NAD_MODE;
    public static final int EVENT_KEYPAD_VISIBLE;
    public static final int EVENT_SIM_UNLOCK_HIDDEN;
    public static final int EVENT_SIM_CHANGE_PIN;
    public static final int EVENT_SIM_TOGGLE_PIN;
    public static final int EVENT_REQUEST_DISCONNECT_SAP;
    public static final int EVENT_REQUEST_TOGGLE_SAP_2_HFP;
}

