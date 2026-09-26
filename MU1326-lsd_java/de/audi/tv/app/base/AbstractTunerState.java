/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.AbstractTunerState$1;
import de.audi.tv.app.util.Handler$IMessageCodeToStringConverter;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.sm.State;
import org.dsi.ifc.tvtuner.StartUpConfig;

public abstract class AbstractTunerState
extends State {
    static final int CHILD_LOCK_ENABLED;
    static final int CHILD_LOCK_DISABLED;
    static final int AUDIO_FOCUS_MU_GOT;
    static final int AUDIO_FOCUS_MU_LOST;
    static final int AUDIO_FOCUS_SDIS_GOT;
    static final int AUDIO_FOCUS_SDIS_LOST;
    static final int TUNER_ACTIVATED;
    static final int TUNER_DEACTIVATED;
    static final int START_UP_MU_CONFIG_RECEIVED;
    static final int ESM_ACTIVE;
    static final int ESM_INACTIVE;
    static final int SOURCE_SWITCH_REQUESTED;
    static final int FACTORY_RESET_REQUESTED;
    static final int SDIS_CONNECTION_GOT;
    static final int SDIS_CONNECTION_LOST;
    static final int HIGH_TEMPERATURE_SHUTDOWN;
    static final int DEINIT;
    private boolean handled = false;

    @Override
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

    static Handler$IMessageCodeToStringConverter getMessageCodeConverter() {
        return new AbstractTunerState$1();
    }
}

