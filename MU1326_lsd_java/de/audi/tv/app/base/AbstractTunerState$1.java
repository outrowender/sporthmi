/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.util.Handler$IMessageCodeToStringConverter;

final class AbstractTunerState$1
implements Handler$IMessageCodeToStringConverter {
    AbstractTunerState$1() {
    }

    @Override
    public String messageCodeToString(int n) {
        switch (n) {
            case 0: {
                return "CHILD_LOCK_ENABLED";
            }
            case 1: {
                return "CHILD_LOCK_DISABLED";
            }
            case 2: {
                return "AUDIO_FOCUS_MU_GOT";
            }
            case 3: {
                return "AUDIO_FOCUS_MU_LOST";
            }
            case 4: {
                return "AUDIO_FOCUS_SDIS_GOT";
            }
            case 5: {
                return "AUDIO_FOCUS_SDIS_LOST";
            }
            case 6: {
                return "TUNER_ACTIVATED";
            }
            case 7: {
                return "TUNER_DEACTIVATED";
            }
            case 8: {
                return "START_UP_MU_CONFIG_RECEIVED";
            }
            case 9: {
                return "ESM_ACTIVE";
            }
            case 10: {
                return "ESM_INACTIVE";
            }
            case 11: {
                return "SOURCE_SWITCH_REQUESTED";
            }
            case 12: {
                return "FACTORY_RESET_REQUESTED";
            }
            case 13: {
                return "SDIS_CONNECTION_GOT";
            }
            case 14: {
                return "SDIS_CONNECTION_LOST";
            }
            case 15: {
                return "HIGH_TEMPERATURE_SHUTDOWN";
            }
            case 16: {
                return "DEINIT";
            }
        }
        return "UNKNOWN";
    }
}

