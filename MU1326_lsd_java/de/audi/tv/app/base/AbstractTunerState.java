/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.util.Handler;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.sm.State;
import org.dsi.ifc.tvtuner.StartUpConfig;

public abstract class AbstractTunerState
extends State {
    static final int CHILD_LOCK_ENABLED = 0;
    static final int CHILD_LOCK_DISABLED = 1;
    static final int AUDIO_FOCUS_MU_GOT = 2;
    static final int AUDIO_FOCUS_MU_LOST = 3;
    static final int AUDIO_FOCUS_SDIS_GOT = 4;
    static final int AUDIO_FOCUS_SDIS_LOST = 5;
    static final int TUNER_ACTIVATED = 6;
    static final int TUNER_DEACTIVATED = 7;
    static final int START_UP_MU_CONFIG_RECEIVED = 8;
    static final int ESM_ACTIVE = 9;
    static final int ESM_INACTIVE = 10;
    static final int SOURCE_SWITCH_REQUESTED = 11;
    static final int FACTORY_RESET_REQUESTED = 12;
    static final int SDIS_CONNECTION_GOT = 13;
    static final int SDIS_CONNECTION_LOST = 14;
    static final int HIGH_TEMPERATURE_SHUTDOWN = 15;
    static final int DEINIT = 16;
    private boolean handled = false;

    public final boolean processMessage(Message message) {
        this.handled = true;
        switch (message.getCode()) {
            case 0: {
                this.onChildLockEnabled();
                break;
            }
            case 1: {
                this.onChildLockDisabled();
                break;
            }
            case 2: {
                this.onMuGotAudioFocus((Boolean)message.obj);
                break;
            }
            case 3: {
                this.onMuLostAudioFocus();
                break;
            }
            case 4: {
                this.onSdisGotAudioFocus();
                break;
            }
            case 5: {
                this.onSdisLostAudioFocus();
                break;
            }
            case 6: {
                this.onTunerActivated();
                break;
            }
            case 7: {
                this.onTunerDeactivated();
                break;
            }
            case 8: {
                this.onStartUpMUConfig((StartUpConfig)message.obj);
                break;
            }
            case 9: {
                this.onEsmActivated();
                break;
            }
            case 10: {
                this.onEsmDeactivated();
                break;
            }
            case 11: {
                this.onSourceSwitchRequested(message.arg1);
                break;
            }
            case 12: {
                this.onFactoryReset();
                break;
            }
            case 13: {
                this.onGotSdisConnection();
                break;
            }
            case 14: {
                this.onLostSdisConnection();
                break;
            }
            case 15: {
                this.onHighTemperatureShutdown();
                break;
            }
            case 16: {
                this.onDeinit();
                break;
            }
            default: {
                this.markNotHandled();
            }
        }
        return this.handled;
    }

    protected void onChildLockEnabled() {
        this.markNotHandled();
    }

    protected void onChildLockDisabled() {
        this.markNotHandled();
    }

    protected void onMuGotAudioFocus(boolean bl) {
        this.markNotHandled();
    }

    protected void onMuLostAudioFocus() {
        this.markNotHandled();
    }

    protected void onSdisGotAudioFocus() {
        this.markNotHandled();
    }

    protected void onSdisLostAudioFocus() {
        this.markNotHandled();
    }

    protected void onTunerActivated() {
        this.markNotHandled();
    }

    protected void onTunerDeactivated() {
        this.markNotHandled();
    }

    protected void onStartUpMUConfig(StartUpConfig startUpConfig) {
        this.markNotHandled();
    }

    protected void onEsmActivated() {
        this.markNotHandled();
    }

    protected void onEsmDeactivated() {
        this.markNotHandled();
    }

    protected void onSourceSwitchRequested(int n) {
        this.markNotHandled();
    }

    protected void onFactoryReset() {
        this.markNotHandled();
    }

    protected void onGotSdisConnection() {
        this.markNotHandled();
    }

    protected void onLostSdisConnection() {
        this.markNotHandled();
    }

    protected void onHighTemperatureShutdown() {
        this.markNotHandled();
    }

    protected void onDeinit() {
        this.markNotHandled();
    }

    protected final void markNotHandled() {
        this.handled = false;
    }

    static Handler.IMessageCodeToStringConverter getMessageCodeConverter() {
        return new Handler.IMessageCodeToStringConverter(){

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
        };
    }
}

