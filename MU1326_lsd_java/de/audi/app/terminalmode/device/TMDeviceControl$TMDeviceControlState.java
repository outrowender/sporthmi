/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDeviceControl$1;
import de.audi.app.terminalmode.device.TMDeviceControl$TMDeviceControlState$1;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$ErrorCode;
import de.audi.atip.utils.statemachine.Handler$IMessageCodeToStringConverter;
import de.audi.atip.utils.statemachine.Message;
import de.audi.atip.utils.statemachine.State;

class TMDeviceControl$TMDeviceControlState
extends State {
    public static final int DEVICE_DISCOVERED;
    public static final int ACTIVATE;
    public static final int DEACTIVATE;
    public static final int DEVICE_NOT_DISCOVERED;
    public static final int CONNECTIONSTATE_CONNECTED;
    public static final int CONNECTIONSTATE_STARTED;
    public static final int CONNECTIONSTATE_FAILED;
    public static final int CONNECTIONSTATE_DISCONNECTED;
    public static final int CONNECTIONSTATE_STOPPED;
    public static final int CLEANUP_DONE;
    public static final int TIMEOUT;
    public static final int CONNECT_DEVICE_FAILED;
    public static final int HANDLE_DELETE;
    public static final int SUPRESS_AUTOMATIC_ACTIVATIONS_TIMER;
    public static final int DEVICE_DISCOVERED_DEBOUNCED;
    public static final int DEVICE_DISCOVERED_PHONE_CALL_ACTIVE;
    public static final int PHONE_CALL_ENDED;
    private boolean handled = false;

    private TMDeviceControl$TMDeviceControlState() {
    }

    @Override
    public final boolean processMessage(Message message) {
        this.handled = true;
        switch (message.getCode()) {
            case 1: {
                this.deviceDiscovered((PhysicalDevice)message.obj);
                break;
            }
            case 16: {
                this.deviceDiscoveredDebounced((PhysicalDevice)message.obj);
                break;
            }
            case 2: {
                this.activate();
                break;
            }
            case 3: {
                this.deactivate();
                break;
            }
            case 4: {
                this.deviceNotDiscovered();
                break;
            }
            case 5: {
                this.connectionStateConnected();
                break;
            }
            case 6: {
                this.connectionStateStarted();
                break;
            }
            case 7: {
                this.connectionStateFailed(message.arg1);
                break;
            }
            case 8: {
                this.connectionStateDisconnected();
                break;
            }
            case 9: {
                this.connectionStateStopped();
                break;
            }
            case 10: {
                this.cleanupDone();
                break;
            }
            case 12: {
                this.timeout((String)message.obj);
                break;
            }
            case 13: {
                this.connectDeviceFailed((SmartphoneIntegrationDSILifecycleController$ErrorCode)message.obj);
                break;
            }
            case 14: {
                this.handleDelete();
                break;
            }
            case 15: {
                break;
            }
            case 17: {
                this.deviceDiscoveredPhoneCallActive((PhysicalDevice)message.obj);
                break;
            }
            case 18: {
                this.phoneCallEnded();
                break;
            }
            default: {
                this.markNotHandled();
            }
        }
        return this.handled;
    }

    protected void deviceDiscovered(PhysicalDevice physicalDevice) {
        this.markNotHandled();
    }

    protected void deviceDiscoveredDebounced(PhysicalDevice physicalDevice) {
        this.markNotHandled();
    }

    protected void deviceNotDiscovered() {
        this.markNotHandled();
    }

    protected void activate() {
        this.markNotHandled();
    }

    protected void deactivate() {
        this.markNotHandled();
    }

    protected void connectionStateConnected() {
        this.markNotHandled();
    }

    protected void connectionStateStopped() {
        this.markNotHandled();
    }

    protected void connectionStateDisconnected() {
        this.markNotHandled();
    }

    protected void connectionStateFailed(int n) {
        this.markNotHandled();
    }

    protected void connectionStateStarted() {
        this.markNotHandled();
    }

    protected void cleanupDone() {
        this.markNotHandled();
    }

    protected void timeout(String string) {
        this.markNotHandled();
    }

    protected void connectDeviceFailed(SmartphoneIntegrationDSILifecycleController$ErrorCode smartphoneIntegrationDSILifecycleController$ErrorCode) {
        this.markNotHandled();
    }

    protected void handleDelete() {
        this.markNotHandled();
    }

    protected void deviceDiscoveredPhoneCallActive(PhysicalDevice physicalDevice) {
        this.markNotHandled();
    }

    protected void phoneCallEnded() {
        this.markNotHandled();
    }

    protected void markNotHandled() {
        this.handled = false;
    }

    static Handler$IMessageCodeToStringConverter getMessageCodeConverter() {
        return new TMDeviceControl$TMDeviceControlState$1();
    }

    /* synthetic */ TMDeviceControl$TMDeviceControlState(TMDeviceControl$1 tMDeviceControl$1) {
        this();
    }
}

