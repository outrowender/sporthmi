/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

public class BluetoothState {
    public static final int DEACTIVATED;
    public static final int AUDIO_PLAYER_DEACTIVATED;
    public static final int AUDIO_PLAYER_NOT_CONNECTED;
    public static final int RECONNECTING;
    public static final int READY;
    private final int state;

    public BluetoothState(int n) {
        switch (n) {
            case 0: {
                this.state = 0;
                break;
            }
            case 1: {
                this.state = 1;
                break;
            }
            case 3: {
                this.state = 3;
                break;
            }
            case 4: {
                this.state = 2;
                break;
            }
            default: {
                this.state = 4;
            }
        }
    }

    public int getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        BluetoothState bluetoothState = (BluetoothState)object;
        return this.state == bluetoothState.state;
    }

    public String toString() {
        switch (this.state) {
            case 1: {
                return "AUDIO_PLAYER_DEACTIVATED";
            }
            case 2: {
                return "AUDIO_PLAYER_NOT_CONNECTED";
            }
            case 0: {
                return "DEACTIVATED";
            }
            case 4: {
                return "READY";
            }
            case 3: {
                return "RECONNECTING";
            }
        }
        return new StringBuffer().append("UNKNOWN (").append(this.state).append(")").toString();
    }
}

