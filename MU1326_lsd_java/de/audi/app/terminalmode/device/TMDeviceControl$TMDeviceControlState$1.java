/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.atip.utils.statemachine.Handler$IMessageCodeToStringConverter;

final class TMDeviceControl$TMDeviceControlState$1
implements Handler$IMessageCodeToStringConverter {
    TMDeviceControl$TMDeviceControlState$1() {
    }

    @Override
    public String messageCodeToString(int n) {
        switch (n) {
            case 1: {
                return "DEVICE_DISCOVERED";
            }
            case 2: {
                return "ACTIVATE";
            }
            case 3: {
                return "DEACTIVATE";
            }
            case 4: {
                return "DEVICE_NOT_DISCOVERED";
            }
            case 5: {
                return "CONNECTIONSTATE_CONNECTED";
            }
            case 6: {
                return "CONNECTIONSTATE_STARTED";
            }
            case 7: {
                return "CONNECTIONSTATE_FAILED";
            }
            case 8: {
                return "CONNECTIONSTATE_DISCONNECTED";
            }
            case 9: {
                return "CONNECTIONSTATE_STOPPED";
            }
            case 10: {
                return "CLEANUP_DONE";
            }
            case 12: {
                return "TIMEOUT";
            }
            case 13: {
                return "CONNECT_DEVICE_FAILED";
            }
            case 14: {
                return "HANDLE_DELETE";
            }
            case 15: {
                return "SUPRESS_AUTOMATIC_ACTIVATIONS_TIMER";
            }
            case 16: {
                return "DEVICE_DISCOVERED_DEBOUNCED";
            }
            case 17: {
                return "DEVICE_DISCOVERED_PHONE_CALL_ACTIVE";
            }
            case 18: {
                return "PHONE_CALL_ENDED";
            }
        }
        return Integer.toString(n);
    }
}

