/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.IInterappEvent;

public interface IInterappConManagerEvent
extends IInterappEvent {
    public static final int EVENT_COMA_SHOW_UNLOCK_STATEMACHINE = 1;
    public static final int EVENT_COMA_SET_NAD_MODE_DATA_ONLY = 2;
    public static final int EVENT_COMA_SET_NAD_MODE_VOICE_AND_DATA = 3;
    public static final int EVENT_COMA_TOGGLE_PHONES = 4;
    public static final int EVENT_COMA_CONNECT_BLUETOOTH_PHONE = 5;
    public static final int EVENT_COMA_DISCONNECT_BLUETOOTH_PHONE = 6;
    public static final int EVENT_COMA_CONNECT_BLUETOOTH_DATA = 7;
    public static final int EVENT_COMA_ENTER_CONNECTIVITY_CHECK = 8;
    public static final int EVENT_COMA_LEAVE_CONNECTIVITY_CHECK = 9;
    public static final int EVENT_COMA_START_SMARTPHONE_INTEGRATION_TOGGLE = 10;
    public static final int EVENT_COMA_END_SMARTPHONE_INTEGRATION_TOGGLE = 11;
    public static final int EVENT_COMA_CONNECT_WIFI = 12;
    public static final int EVENT_COMA_DISCONNECT_WIFI = 13;
    public static final int EVENT_COMA_DISCONNECT_DATA = 14;
    public static final int EVENT_COMA_CONNECT_WIFI_RESPONSE = 15;
    public static final int EVENT_COMA_DISCONNECT_WIFI_RESPONSE = 16;
    public static final int EVENT_COMA_TIMEOUT = 17;
    public static final int EVENT_COMA_START_DELETE_DEVICE = 18;
    public static final int EVENT_COMA_END_DELETE_DEVICE = 19;
}

