/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.IInterappEvent;

public interface IInterappConManagerEvent
extends IInterappEvent {
    public static final int EVENT_COMA_SHOW_UNLOCK_STATEMACHINE;
    public static final int EVENT_COMA_SET_NAD_MODE_DATA_ONLY;
    public static final int EVENT_COMA_SET_NAD_MODE_VOICE_AND_DATA;
    public static final int EVENT_COMA_TOGGLE_PHONES;
    public static final int EVENT_COMA_CONNECT_BLUETOOTH_PHONE;
    public static final int EVENT_COMA_DISCONNECT_BLUETOOTH_PHONE;
    public static final int EVENT_COMA_CONNECT_BLUETOOTH_DATA;
    public static final int EVENT_COMA_ENTER_CONNECTIVITY_CHECK;
    public static final int EVENT_COMA_LEAVE_CONNECTIVITY_CHECK;
    public static final int EVENT_COMA_START_SMARTPHONE_INTEGRATION_TOGGLE;
    public static final int EVENT_COMA_END_SMARTPHONE_INTEGRATION_TOGGLE;
    public static final int EVENT_COMA_CONNECT_WIFI;
    public static final int EVENT_COMA_DISCONNECT_WIFI;
    public static final int EVENT_COMA_DISCONNECT_DATA;
    public static final int EVENT_COMA_CONNECT_WIFI_RESPONSE;
    public static final int EVENT_COMA_DISCONNECT_WIFI_RESPONSE;
    public static final int EVENT_COMA_TIMEOUT;
    public static final int EVENT_COMA_START_DELETE_DEVICE;
    public static final int EVENT_COMA_END_DELETE_DEVICE;
}

